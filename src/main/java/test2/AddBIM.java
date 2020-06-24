package test2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import utils.FileReadLine;
import utils.HttpUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class AddBIM {
    public static void main(String[] args) throws IOException {
        String landMarkString = FileReadLine.readString("D:\\project\\123\\src\\main\\resources\\LandMark.json");
        String lightString = FileReadLine.readString("D:\\project\\123\\src\\main\\resources\\Light.json");
        String nodeString = FileReadLine.readString("D:\\project\\123\\src\\main\\resources\\node.json");
        JSONObject nodeJson = JSONObject.parseObject(nodeString);
        JSONObject lightJson = JSONObject.parseObject(lightString);
        JSONObject landMarkJson = JSONObject.parseObject(landMarkString);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonArray.add(jsonObject);
        JSONArray landMarkJSONArray = landMarkJson.getJSONArray("data");
        JSONArray nodeJsonJSONArray = nodeJson.getJSONArray("data");
        JSONArray lightJsonJSONArray = lightJson.getJSONArray("data");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\project\\123\\src\\main\\resources\\nomatch.txt"));
        for (int i = 0; i < landMarkJSONArray.size(); i++) {
            JSONObject landMarkData = landMarkJSONArray.getJSONObject(i);
            String name = landMarkData.getString("name");
            Integer landmarkId = landMarkData.getInteger("id");
            List<JSONObject> nodeNames = new ArrayList<>();
            for (int j = 0; j < nodeJsonJSONArray.size(); j++) {
                JSONObject nodeData = nodeJsonJSONArray.getJSONObject(j);
                String nodeName = nodeData.getString("nodeName");
                if (Objects.equals(nodeName, name)) {
                    nodeNames.add(nodeData);
                }
            }
            if (nodeNames.size() > 0) {
                JSONArray array = new JSONArray();
                for (JSONObject nodeData : nodeNames) {
                    Integer nodeId = nodeData.getInteger("nodeId");
                    String nodeSn = nodeData.getString("nodeSn");
                    JSONObject landNodeRel = new JSONObject();
                    landNodeRel.put("landmarkId", landmarkId);
                    landNodeRel.put("nodeId", nodeId);
                    landNodeRel.put("nodeSn", nodeSn);
                    landNodeRel.put("nodeType", 1);
                    array.add(landNodeRel);
                }
                HttpUtil.hpost("http://oms.chengdutianfu.com:8181/iot-oms/bimLandMark/addLandMarkWithNode", array);
                for (JSONObject nodeData : nodeNames) {
                    Integer nodeId = nodeData.getInteger("nodeId");
                    String nodeSn = nodeData.getString("nodeSn");
                    jsonObject.put("nodeSn", nodeSn);
                    JSONArray controllerData = jsonArray(jsonArray, "http://oms.chengdutianfu.com:8181/iot-oms/bimLandMark/getControllerBranchForLandMarkAdd");
                    JSONArray addNodeControllerArray = new JSONArray();
                    for (int j = 0; j < controllerData.size(); j++) {
                        JSONObject controller = controllerData.getJSONObject(j);
                        Integer controllerBranchNo = controller.getInteger("controllerBranchNo");
                        Integer controllerBranchId = controller.getInteger("controllerBranchId");
                        JSONObject addNodeControllerObject = new JSONObject();
                        String nodeName = nodeData.getString("nodeName");
                        addNodeControllerObject.put("nodeSn", nodeSn);
                        addNodeControllerObject.put("controllerBranchName", nodeName + "的分控" + controllerBranchNo);
                        addNodeControllerObject.put("controllerBranchNo", controllerBranchNo);
                        addNodeControllerObject.put("devType", null);
                        addNodeControllerObject.put("controllerBranchId", controllerBranchId);
                        addNodeControllerObject.put("landmarkId", landmarkId);
                        addNodeControllerObject.put("controllerBranchRelId", null);
                        randomLightTypeNum(lightJsonJSONArray, addNodeControllerObject);
                        addNodeControllerArray.add(addNodeControllerObject);
                    }
                    HttpUtil.hpost("http://oms.chengdutianfu.com:8181/iot-oms/bimLandMark/addNodeControllerBranchRel", addNodeControllerArray);
                    JSONArray boxArray = jsonArray(jsonArray, "http://oms.chengdutianfu.com:8181/iot-oms/bimLandMark/getBoxForLandMarkAdd");
                    int size = boxArray.size();
                    if (size == 1) {
                        JSONObject boxData = boxArray.getJSONObject(0);
                        String ebSn = boxData.getString("electricSn");
                        JSONArray addBoxControllerArray = new JSONArray();
                        for (int j = 0; j < controllerData.size(); j++) {
                            JSONObject controller = controllerData.getJSONObject(j);
                            Integer controllerBranchId = controller.getInteger("controllerBranchId");
                            //addBoxControllerBranchRel
                            JSONObject addBoxControllerObject = new JSONObject();
                            addBoxControllerObject.put("nodeSn", nodeSn);
                            addBoxControllerObject.put("ebSn", ebSn);
                            addBoxControllerObject.put("controllerTempId", controllerBranchId);
                            addBoxControllerObject.put("landmarkId", landmarkId);
                            addBoxControllerArray.add(addBoxControllerObject);
                        }
                        HttpUtil.hpost("http://oms.chengdutianfu.com:8181/iot-oms/bimLandMark/addBoxControllerBranchRel", addBoxControllerArray);
                        //{
                        //        "nodeSn": "cd093",
                        //        "ebSn": "0755000719090012",
                        //        "controllerTempId": 540,
                        //        "landmarkId": 103
                        //    }
                    } else {
                        JSONArray addBoxControllerArray = new JSONArray();
                        for (int j = 0; j < controllerData.size(); j++) {
                            JSONObject boxData = boxArray.getJSONObject(j % size);
                            String ebSn = boxData.getString("electricSn");
                            JSONObject controller = controllerData.getJSONObject(j);
                            Integer controllerBranchId = controller.getInteger("controllerBranchId");
                            //addBoxControllerBranchRel
                            JSONObject addBoxControllerObject = new JSONObject();
                            addBoxControllerObject.put("nodeSn", nodeSn);
                            addBoxControllerObject.put("ebSn", ebSn);
                            addBoxControllerObject.put("controllerTempId", controllerBranchId);
                            addBoxControllerObject.put("landmarkId", landmarkId);
                            addBoxControllerArray.add(addBoxControllerObject);
                        }
                        HttpUtil.hpost("http://oms.chengdutianfu.com:8181/iot-oms/bimLandMark/addBoxControllerBranchRel", addBoxControllerArray);
                    }
                }
            } else {
                bufferedWriter.write(name + "匹配失败\n");
                bufferedWriter.flush();
            }
        }
        bufferedWriter.close();
    }


    private static void randomLightTypeNum(JSONArray lightJsonJSONArray, JSONObject addNodeControllerObject) {
        Random random = new Random();
        int i = random.nextInt(lightJsonJSONArray.size());
        JSONObject jsonObject = lightJsonJSONArray.getJSONObject(i);
        String devSn = jsonObject.getString("devSn");
        String devName = jsonObject.getString("devName");
        int devNum = 10;
        if (devName.contains("点光源")) {
            devNum = (random.nextInt(5) + 1) * 100;
        } else if (devName.contains("投光灯")) {
            devNum = (random.nextInt(20) + 1);
        } else if (devName.contains("线条灯")) {
            devNum = (random.nextInt(10) + 1) * 10;
        } else if (devName.contains("洗墙灯")) {
            devNum = (random.nextInt(100) + 1);
        } else if (devName.contains("led灯具")) {
            devNum = random.nextInt(100) + 1;
        }
        addNodeControllerObject.put("devSn", devSn);
        addNodeControllerObject.put("devNum", devNum);

    }

    private static JSONObject jsonDate(JSONArray jsonArray, String s) {
        JSONObject boxDate = HttpUtil.hpost(s, jsonArray);
        if (boxDate == null) {
            return null;
        }
        return boxDate.getJSONObject("data");
    }

    private static JSONArray jsonArray(JSONArray jsonArray, String s) {
        JSONObject boxDate = HttpUtil.hpost(s, jsonArray);
        if (boxDate == null) {
            return new JSONArray();
        }
        return boxDate.getJSONArray("data");
    }

}
