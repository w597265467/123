package test2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class TestCreatHtmlTable2 {
    private static int i;

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        String json = "{\n" +
                "                \"no\": 1,\n" +
                "                \"lightingDuration\": 0,\n" +
                "                \"transformersRate\": 20,\n" +
                "                \"name\": \"第1回路\",\n" +
                "                \"electricCurrent\": 3,\n" +
                "                \"id\": 4649,\n" +
                "                \"activePower\": 4\n" +
                "            }";
        JsonObject jsonObj = parser.parse(json).getAsJsonObject();
        StringBuilder table = new StringBuilder();
        table.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\n" +
                "        \"http://www.w3.org/TR/html4/strict.dtd\">\n" +
                "<html>")
        .append("<head>\n" +
                "    <title>iot-cloud</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "    <meta name=\"date\" content=\"Thu, 14 Apr 2020 09:19:02 +0800\">\n" +
                "    <meta name=\"generator\" content=\"MySQL-Front 6.1  (Build 1.26)\">\n" +
                "    <style type=\"text/css\">\n" +
                "    body {font-family: Arial,Helvetica,sans-serif; font-size: 14px;}\n" +
                "    h1 {font-size: 17px; text-decoration: bold;}\n" +
                "    h2 {font-size: 15px; text-decoration: bold;}\n" +
                "    h3 {font-size: 13px; text-decoration: bold;}\n" +
                "    th,\n" +
                "    td {font-size: 14px; border-color: #000000;text-align: center; border-style: solid; border-width: 0px; font-weight: normal;}\n" +
                "    code {font-size: 14px;}\n" +
                "    .TableObject {border-collapse: collapse; border-color: #000000; font-family: Microsoft Sans Serif}\n" +
                "    .TableData {border-collapse: collapse; border-color: #000000; font-family: Microsoft Sans Serif}\n" +
                "    .center {font-weight: bold; text-align: center; border-color: #000000; font-family: Microsoft Sans Serif}\n" +
                "    .TableHeader {border-color: #000000; text-decoration: bold; background-color: #e0e0e0;}\n" +
                "    .StructureHeader {padding-left: 5px; text-align: left; border-color: #000000; text-decoration: bold;}\n" +
                "    .Structure {text-align: left; border-color: #aaaaaa;}\n" +
                "    .DataHeader {padding-left: 5px; text-align: left; border-color: #000000; background-color: #e0e0e0;}\n" +
                "    .Null {color: #999999;}\n" +
                "    .PrimaryKey {font-weight: bold;}\n" +
                "    .RightAlign {text-align: right;}\n" +
                "    </style>\n" +
                "</head>");
        Set<String> strings =  jsonObj.keySet();
        table.append("<table border=\"0\" cellspacing=\"0\" class=\"TableObject\" width=850px>");
        for (String string : strings) {
            JsonElement jsonElement = jsonObj.get(string);
            table.append(creatHtmlTable(string,jsonElement,table));
        }
        table.append("</table> <br/>");
        table.append("</body>")
                .append("</html>");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
                "C:\\Users\\wly\\Desktop\\"+System.currentTimeMillis()+".html"));
        bufferedWriter.write(table.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static StringBuilder creatHtmlTable(String string, JsonElement o,StringBuilder sb) {
        StringBuilder table = new StringBuilder(0);
        if (o == null||o.isJsonNull()){
            table.append("<tr class='Structure'>");
            htmlTable(table, 0, 0, "FFFFFF",string);
            htmlTable(table, 0, 0, "FFFFFF", "String");
            table.append("</tr>\n");
            return table;
        }
        if (o.isJsonPrimitive()){
            JsonPrimitive jsonPrimitive = o.getAsJsonPrimitive();
            if (jsonPrimitive.isString()){
                table.append("<tr class='Structure'>");
                htmlTable(table, 0, 0, "FFFFFF",string);
                htmlTable(table, 0, 0, "FFFFFF", "String");
                table.append("</tr>\n");
                return table;
            }else if(jsonPrimitive.isNumber()){
                table.append("<tr class='Structure'>");
                htmlTable(table, 0, 0, "FFFFFF",string);
                htmlTable(table, 0, 0, "FFFFFF", "Integer");
                table.append("</tr>\n");
                return table;
            }
        }

        if (o.isJsonObject()){
            table.append("<tr class='Structure'>");
            htmlTable(table, 0, 0, "FFFFFF", string);
            htmlTable(table, 0, 2, "FFFFFF", "JsonObject");
            table.append("</tr>\n");
            jsonObjectToHtml(table, o.getAsJsonObject());
            table.append("<tr class='Structure'>");
            htmlTable(table, 0, 0, "FFFFFF", string);
            htmlTable(table, 0, 2, "FFFFFF", "JsonObjectEND");
            table.append("</tr>\n");
        }else if (o.isJsonArray()){
            table.append("<tr class='Structure'>");
            htmlTable(table, 0, 0, "FFFFFF", string);
            htmlTable(table, 0, 2, "FFFFFF", "JsonArray");
            table.append("</tr>\n");
            JsonArray jsonArray = o.getAsJsonArray();
            for (JsonElement next : jsonArray) {
                if (next.isJsonObject()) {
                    jsonObjectToHtml(table, next.getAsJsonObject());
                }
            }
            table.append("<tr class='Structure'>");
            htmlTable(table, 0, 0, "FFFFFF", string);
            htmlTable(table, 0, 2, "FFFFFF", "JsonArrayEND");
            table.append("</tr>\n");

        }
        return table;
    }

    private static void jsonObjectToHtml(StringBuilder sb, JsonObject asJsonObject) {
        JsonObject jsonObject = asJsonObject;
        Set<String> strings = (jsonObject).keySet();
        for (String s : strings) {
            sb.append(creatHtmlTable(s, jsonObject.get(s), sb));
        }
    }

//    private static StringBuilder creatHtmlTable(String string, Object o,StringBuilder sb) {
//        StringBuilder table = new StringBuilder(0);
//        if (o == null){
//            table.append("<tr class='Structure'>");
//            htmlTable(table, 0, 0, "FFFFFF",string);
//            htmlTable(table, 0, 0, "FFFFFF", "String");
//            table.append("</tr>\n");
//            return table;
//        }
//        if (o instanceof Integer){
//            table.append("<tr class='Structure'>");
//            htmlTable(table, 0, 0, "FFFFFF",string);
//            htmlTable(table, 0, 0, "FFFFFF", "Integer");
//            table.append("</tr>\n");
//        }else if (o instanceof String){
//            table.append("<tr class='Structure'>");
//            htmlTable(table, 0, 0, "FFFFFF",string);
//            htmlTable(table, 0, 0, "FFFFFF", "String");
//            table.append("</tr>\n");
//        }else if (o instanceof JsonObject){
//            JsonObject jsonObject = (JsonObject) o;
//            Set<String> strings = (jsonObject).keySet();
//            for (String s : strings) {
//                sb.append(creatHtmlTable(s,jsonObject.get(s),sb));
//            }
//        }else if (o instanceof JsonArray){
//            JsonArray jsonArray = (JsonArray) o;
//            table.append("<tr class='Structure'>");
//            htmlTable(table, 0, 3, "FFFFFF", "JsonArray");
//            table.append("</tr>\n");
//            for (Object next : jsonArray) {
//                if (next instanceof JsonObject) {
//                    JsonObject jsonObject = (JsonObject) next;
//                    Set<String> strings = (jsonObject).keySet();
//                    for (String s : strings) {
//                        sb.append(creatHtmlTable(s, jsonObject.get(s), sb));
//                    }
//                }
//            }
//        }
//        return table;
//    }
//
//    private static StringBuilder creatHtmlTable(RequestToMethodItem request) {
//        Class<?>[] methodParamTypes = request.methodParamTypes;
//        StringBuilder table = new StringBuilder(0);
////        table.append("<h2>2.").append(i++).append("</h2>");
//        table.append("<table border=\"0\" cellspacing=\"0\" class=\"TableObject\" width=850px>");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 0, "D9D9D9", "接口地址","center");
//        htmlTable(table, 0, 5, "FFFFFF", "/iot-cloud"+request.requestUrl);
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 0, "D9D9D9", "接口方式","center");
//        htmlTable(table, 0, 5, "FFFFFF", "HTTP " + (request.requestType == null ? "GET" : request.requestType));
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 0, "D9D9D9", "数据流向","center");
//        htmlTable(table, 0, 5, "FFFFFF", "运维服务器->前端");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 0, "D9D9D9", "数据频率","center");
//        htmlTable(table, 0, 5, "FFFFFF", "用户操作时");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 0, "D9D9D9", "接口描述","center");
//        htmlTable(table, 0, 5, "FFFFFF", "");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 6, "D9D9D9", "参数定义","center");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, methodParamTypes.length+1, 0, "D9D9D9", "发送参数","center");
//        htmlTable(table, 0, 0, "D9D9D9", "中文名称","center");
//        htmlTable(table, 0, 0, "D9D9D9", "字段名称","center");
//        htmlTable(table, 0, 0, "D9D9D9", "字段类型","center");
//        htmlTable(table, 0, 0, "D9D9D9", "类型","center");
//        htmlTable(table, 0, 0, "D9D9D9", "参数说明","center");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//
//        int j = 8;
//        String[] parameterNames = request.parameterNames;
//        for (int i = 0; i < methodParamTypes.length; i++) {
//            htmlTable(table, 0, 0, "FFFFFF", "");
//            htmlTable(table, 0, 0, "FFFFFF", parameterNames[i]);
//            Class<?> methodParamType = methodParamTypes[i];
//            String s = methodParamType == null ? "" : methodParamType.toString()
//                    .replace("class","")
//                    .replace("java.lang.","")
//                    .replace("java.utils.","")
//                    .replace("\n","")
//                    .replace("interface","")
//                    .replace("javax.servlet.http.HttpSession","")
//                    .replace("javax.servlet.http.","")
//                    .replace("org.springframework.web.multipart.","");
//            htmlTable(table, 0, 0, "FFFFFF", s);
//            htmlTable(table, 0, 0, "FFFFFF", "must");
//            htmlTable(table, 0, 0, "FFFFFF", "");
//            table.append("</tr>\n");
//            table.append("<tr class='Structure'>");
//            j++;
//        }
//        htmlTable(table, 4, 1, "D9D9D9", "返回参数","center");
//        htmlTable(table, 0, 1, "D9D9D9", "中文名称","center");
//        htmlTable(table, 0, 1, "D9D9D9", "字段名称","center");
//        htmlTable(table, 0, 2, "D9D9D9", "字段类型","center");
//        htmlTable(table, 0, 1, "D9D9D9", "参数说明","center");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 1, "FFFFFF", "返回码","center");
//        htmlTable(table, 0, 1, "FFFFFF", "code");
//        htmlTable(table, 0, 2, "FFFFFF", "Integer");
//        htmlTable(table, 0, 1, "FFFFFF", "20000成功,其他失败");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 1, "FFFFFF", "数据","center");
//        htmlTable(table, 0, 1, "FFFFFF", "data");
//        htmlTable(table, 0, 2, "FFFFFF", "Json");
//        htmlTable(table, 0, 1, "FFFFFF", "json对象内包含返回实际数据");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 1, "FFFFFF", "信息","center");
//        htmlTable(table, 0, 1, "FFFFFF", "message");
//        htmlTable(table, 0, 2, "FFFFFF", "String");
//        htmlTable(table, 0, 1, "FFFFFF", "返回提示");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 6, "D9D9D9", "Json格式参考","center");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 0, "D9D9D9", "发送参数","center");
//        htmlTable(table, 0, 5, "FFFFFF", "");
//        table.append("</tr>\n");
//        table.append("<tr class='Structure'>");
//        htmlTable(table, 0, 0, "D9D9D9", "返回参数","center");
//        htmlTable(table, 0, 5, "FFFFFF", "");
//        table.append("</tr>\n");
//        table.append("</table> <br/>");
//        return table;
//    }
//
//    private static void htmlTable(StringBuilder table, int rowSpan, int cellSpan, String colorRgb, String text,String tdClass) {
//        table.append("<td class='").append(tdClass).append("' style='background-color:#").append(colorRgb).append("'");
//        if (cellSpan != 0) {
//            table.append(" colspan=").append(cellSpan);
//        }else {
//            table.append(" width=").append(100);
//        }
//        if (rowSpan != 0) {
//            table.append(" rowspan=").append(rowSpan);
//        }
//
//        table.append("'>").append(text)
//                .append("</td>\n");
//
//    }
    private static void htmlTable(StringBuilder table, int rowSpan, int cellSpan, String colorRgb, String text) {
        table.append("<td class='Structure' style='background-color:#").append(colorRgb).append("'");
        if (cellSpan != 0) {
            table.append(" colspan=").append(cellSpan).append(" width=").append(150*cellSpan);
        }else {
            table.append(" width=").append(150);
        }
        if (rowSpan != 0) {
            table.append(" rowspan=").append(rowSpan);
        }

        table.append("'>").append(text)
                .append("</td>\n");

    }

}
