package test2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import utils.FileReadLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class CompareJsonData {
    public static void main(String[] args) throws IOException {
        String src = FileReadLine.readString("C:\\Users\\wly\\Desktop\\1.txt");
        String now = FileReadLine.readString("C:\\Users\\wly\\Desktop\\2.txt");
        JSONArray srcJson = JSONObject.parseObject(src).getJSONObject("data").getJSONArray("list");
        JSONArray nowJson = JSONObject.parseObject(now).getJSONObject("data").getJSONArray("list");
        Set<String> srcSet = new TreeSet<>();
        Set<String> nowSet = new TreeSet<>();
        for (int i = 0; i < srcJson.size(); i++) {
            JSONArray iotElectricBoxShowInfos = srcJson.getJSONObject(i).getJSONArray("iotElectricBoxShowInfos");
            for (int j = 0; j < iotElectricBoxShowInfos.size(); j++) {
                JSONObject jsonObject = iotElectricBoxShowInfos.getJSONObject(j);
                srcSet.add(jsonObject.getString("name"));
            }
        }
        for (int i = 0; i < nowJson.size(); i++) {
            JSONArray iotElectricBoxShowInfos = nowJson.getJSONObject(i).getJSONArray("iotElectricBoxShowInfos");
            for (int j = 0; j < iotElectricBoxShowInfos.size(); j++) {
                JSONObject jsonObject = iotElectricBoxShowInfos.getJSONObject(j);
                nowSet.add(jsonObject.getString("name"));
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String str = "1\n1";
        String[] split = str.split("\n");

        for (String s : srcSet) {
            boolean contains = false;
            for (String s1 : nowSet) {
                if (s.equals(s1)){
                    contains = true;
                    break;
                }
            }
            if (!contains){
                arrayList.add(s);
            }
        }
        arrayList.removeAll(Arrays.asList(split));
        arrayList.removeAll(nowSet);
        for (String s : arrayList) {
            System.out.println(s);
        }
    }
}
