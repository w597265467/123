package test2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import utils.FileReadLine;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class JsonDataDoSomeThing {
    public static void main(String[] args) throws IOException {
        String s = FileReadLine.readString("D:\\project\\123\\src\\main\\resources\\chengdu2.json");
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("list");
        Set<JSONObject> set = new HashSet<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONArray iotElectricBoxShowInfos = jsonArray.getJSONObject(i).getJSONArray("iotElectricBoxShowInfos");
            JSONObject ebData = iotElectricBoxShowInfos.getJSONObject(0);
            JSONObject json = new JSONObject();
            //    {
            //        "name": "城市理想AL2",
            //        "id": 355,
            //        "serialNo": null,
            //        "outSum": 53,
            //        "outLoopSum": null,
            //        "feeType": null,
            //        "version": null,
            //        "status": null,
            //        "switchStatus": 0,
            //        "builderId": null,
            //        "builderName": null,
            //        "linkman": null,
            //        "phone": null,
            //        "provinceName": "四川省",
            //        "cityName": "成都市",
            //        "districtName": "锦江区",
            //        "roadName": null,
            //        "areaName": "四川省成都市锦江区",
            //        "doorStatus": null
            //    }
            int switchStatus = ebData.getIntValue("switchStatus");

            if (switchStatus == 1){
                json.put("ebId",ebData.getIntValue("id"));
                json.put("name",ebData.getString("name"));
                json.put("switchStatus", switchStatus);
                set.add(json);
            }
        }
        for (JSONObject object : set) {
            System.out.println(object.toJSONString());
        }

    }
}
