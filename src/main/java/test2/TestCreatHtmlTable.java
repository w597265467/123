package test2;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;
import utils.FileReadLine;
import utils.HttpUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static utils.FileReadLine.readString;

public class TestCreatHtmlTable {
    private static int i = 1;
    static Map<String, String> resBodyMap;
    static Map<String, String> titleMap;
    static JsonParser parser = new JsonParser();
    static String projectName = "iot-think";
    static String returnFile = "api (1).json";
    static Map<String, String> translateMap = new HashMap<>();
    static String translateFileName = "C:\\Users\\wly\\Desktop\\translate.txt";

    static {
        try {
            resBodyMap = getResponseParam();
            titleMap = getResponseParam2();
            translateMap = getTranslationMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> getTranslationMap() throws IOException {
        HashMap<String, String> map = new HashMap<>();
        List<String> strings = null;
        try {
            strings = FileReadLine.readLine(translateFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (strings == null) {
            return map;
        }
        for (String string : strings) {
            String[] split = string.split(":");
            map.put(split[0], split[1]);
        }
        return map;
    }

    public TestCreatHtmlTable() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        List<String> strings = FileReadLine.readLine("D:\\project\\123\\src\\main\\resources\\1000.txt");
        List<RequestToMethodItem> requests = new ArrayList<>();
        for (String string : strings) {
            requests.add(JSONObject.parseObject(string, RequestToMethodItem.class));
        }
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
                        "    td {padding:6px font-size: 14px; text-align: center; border-style: solid; border-width: 0px; font-weight: normal;}\n" +
                        "    code {font-size: 14px;}\n" +
                        "    .TableObject {border-style: solid; border-width: 0px; border-color: #000000; font-family: Microsoft Sans Serif}\n" +
                        "    .TableData {border-style: solid; border-width: 0px; border-color: #000000; font-family: Microsoft Sans Serif}\n" +
                        "    .center {font-weight: bold; text-align: center; border-color: #000000; font-family: Microsoft Sans Serif}\n" +
                        "    .TableHeader {border-color: #000000; text-decoration: bold; background-color: #e0e0e0;}\n" +
                        "    .StructureHeader {padding-left: 5px; text-align: left; border-color: #000000; text-decoration: bold;}\n" +
                        "    .Structure {text-align: left;  border-color: #000000; font-family: Microsoft Sans Serif}\n" +
                        "    .DataHeader {padding-left: 5px; text-align: left; border-color: #000000; background-color: #e0e0e0;}\n" +
                        "    .Null {color: #999999;}\n" +
                        "    .PrimaryKey {font-weight: bold;}\n" +
                        "    .RightAlign {text-align: right;}\n" +
                        "    </style>\n" +
                        "</head>");

        for (RequestToMethodItem request : requests) {
            System.out.println(request);
//            if (request.requestUrl.startsWith("/box/"))
            table.append(creatHtmlTable(request));
        }
        table.append("</body>")
                .append("</html>");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\wly\\Desktop\\" + projectName + "-" + System.currentTimeMillis() + ".html"));
        bufferedWriter.write(table.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedWriter = new BufferedWriter(new FileWriter(translateFileName));
        Set<String> keySet = translateMap.keySet();
        for (String s : keySet) {
            bufferedWriter.write(s + ":" + translateMap.get(s));
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    private static StringBuilder creatHtmlTable(RequestToMethodItem request) throws IOException {
        Class<?>[] methodParamTypes = request.methodParamTypes;
        StringBuilder table = new StringBuilder(0);
//        table.append("<h2>2.").append(i++).append("</h2>");
        request.requestUrl = projectName + request.requestUrl;
        String s = resBodyMap.get(request.requestUrl.toUpperCase());
        if (StringUtils.isEmpty(s)) {
            return table;
        }
        String s1 = titleMap.get(request.requestUrl);
        table.append("<h3>").append(s1).append("<h3/>");
        table.append("<table border=\"0\" cellspacing=\"0\" class=\"TableObject\" width=850px>");
        table.append("<tr class='Structure'>");
        JsonObject data = null;
        JsonObject jsonObj = null;
        if (!StringUtils.isEmpty(s)) {
            System.out.println(s);
//            s = s.replace("\n","");
            jsonObj = parser.parse(s).getAsJsonObject();
            if (!jsonObj.isJsonNull() && jsonObj.isJsonObject()) {
                JsonElement data1 = jsonObj.get("data");
                if (data1 == null) {
                    data = jsonObj;
                } else if (data1.isJsonObject()) {
                    data = data1.getAsJsonObject();
                }
            }
        }
        htmlTable(table, 0, 0, "D9D9D9", "接口地址", "center");
        htmlTable(table, 0, 5, "FFFFFF", request.requestUrl);
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 0, "D9D9D9", "接口方式", "center");
        htmlTable(table, 0, 5, "FFFFFF", "HTTP " + (request.requestType == null ? "GET" : request.requestType));
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 0, "D9D9D9", "数据流向", "center");
        htmlTable(table, 0, 5, "FFFFFF", "运维服务器->前端");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 0, "D9D9D9", "数据频率", "center");
        htmlTable(table, 0, 5, "FFFFFF", "用户操作时");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 0, "D9D9D9", "接口描述", "center");

        htmlTable(table, 0, 5, "FFFFFF", s1 == null ? "" : s1);
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 6, "D9D9D9", "参数定义", "center");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, methodParamTypes.length + 1, 0, "D9D9D9", "发送参数", "center");
        htmlTable(table, 0, 0, "D9D9D9", "中文名称", "center");
        htmlTable(table, 0, 0, "D9D9D9", "字段名称", "center");
        htmlTable(table, 0, 0, "D9D9D9", "字段类型", "center");
        htmlTable(table, 0, 0, "D9D9D9", "类型", "center");
        htmlTable(table, 0, 0, "D9D9D9", "参数说明", "center");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");

        int j = 8;
        String[] parameterNames = request.parameterNames;
        for (int i = 0; i < methodParamTypes.length; i++) {
            String parameterName = parameterNames[i];
            addChineseParamName(table, parameterName);
            htmlTable(table, 0, 0, "FFFFFF", parameterName);
            Class<?> methodParamType = methodParamTypes[i];
            String ss = methodParamType == null ? "" : methodParamType.toString()
                    .replace("class", "")
                    .replace("java.lang.", "")
                    .replace("java.utils.", "")
                    .replace("\n", "")
                    .replace("interface", "")
                    .replace("javax.servlet.http.HttpSession", "")
                    .replace("javax.servlet.http.", "")
                    .replace("org.springframework.web.multipart.", "");
            htmlTable(table, 0, 0, "FFFFFF", ss);
            htmlTable(table, 0, 0, "FFFFFF", "must");
            htmlTable(table, 0, 0, "FFFFFF", "");
            table.append("</tr>\n");
            table.append("<tr class='Structure'>");
            j++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = 4;
        if (data != null) {
            Set<String> strings = data.keySet();
            for (String string : strings) {
                stringBuilder = creatHtmlTable(string, data, stringBuilder);
            }
            size += set.size();
            set.clear();
        }
        htmlTable(table, size, 1, "D9D9D9", "返回参数", "center");
        htmlTable(table, 0, 1, "D9D9D9", "中文名称", "center");
        htmlTable(table, 0, 1, "D9D9D9", "字段名称", "center");
        htmlTable(table, 0, 2, "D9D9D9", "字段类型", "center");
        htmlTable(table, 0, 1, "D9D9D9", "参数说明", "center");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 1, "FFFFFF", "返回码", "center");
        htmlTable(table, 0, 1, "FFFFFF", "code");
        htmlTable(table, 0, 2, "FFFFFF", "Integer");
        htmlTable(table, 0, 1, "FFFFFF", "20000成功,其他失败");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 1, "FFFFFF", "数据", "center");
        htmlTable(table, 0, 1, "FFFFFF", "data");
        htmlTable(table, 0, 2, "FFFFFF", "Json");
        htmlTable(table, 0, 1, "FFFFFF", "json对象内包含返回实际数据");
        table.append("</tr>\n");
        //addChineseParamName(table, parameterName);
        table.append(stringBuilder);
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 1, "FFFFFF", "信息", "center");
        htmlTable(table, 0, 1, "FFFFFF", "message");
        htmlTable(table, 0, 2, "FFFFFF", "String");
        htmlTable(table, 0, 1, "FFFFFF", "返回提示");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 6, "D9D9D9", "Json格式参考", "center");
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 0, "D9D9D9", "发送参数", "center");

        if ("POST".equalsIgnoreCase(request.requestType)) {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i < methodParamTypes.length; i++) {
                Class<?> paramType = methodParamTypes[i];
                String parameterName = parameterNames[i];
                if (paramType == String.class) {
                    jsonObject.put(parameterName, parameterName);
                } else if (paramType == Integer.class) {
                    jsonObject.put(parameterName, 126);
                }
            }
            htmlTable(table, 0, 5, "FFFFFF", jsonObject.toJSONString().replace(",", ",\n"));
        } else {
            if (methodParamTypes.length > 0) {
                request.requestUrl += "?";
                for (int i = 0; i < methodParamTypes.length; i++) {
                    Class<?> paramType = methodParamTypes[i];
                    String parameterName = parameterNames[i];
                    if (paramType == String.class) {
                        request.requestUrl = request.requestUrl + (parameterName + "=" + parameterName + "&");
                    } else if (paramType == Integer.class) {
                        request.requestUrl = request.requestUrl + (parameterName + "=" + 126 + "&");
                    } else {
                        request.requestUrl = request.requestUrl + (parameterName + "=" + null + "&");
                    }
                }
                request.requestUrl = request.requestUrl.substring(0, request.requestUrl.length() - 1);
                htmlTable(table, 0, 5, "FFFFFF", request.requestUrl.replace("&", "&\n"));
            } else {
                htmlTable(table, 0, 5, "FFFFFF", request.requestUrl);
            }
        }
        table.append("</tr>\n");
        table.append("<tr class='Structure'>");
        htmlTable(table, 0, 0, "D9D9D9", "返回参数", "center");
        htmlTable(table, 0, 5, "FFFFFF", s == null ? "{\n" +
                "    \"code\": 20000,\n" +
                "    \"data\": null,\n" +
                "    \"message\": null\n" +
                "}" : s.replace("\t","&nbsp;&nbsp;&nbsp;&nbsp;")
                .replace("\n","<br/>")
        );
        table.append("</tr>\n");
        table.append("</table> <br/>");
        return table;
    }

    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

    static String jsonObjectFormatString(JsonObject data) {
        int level = 0;
        String jsonStr = data.toString();
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    char d = jsonStr.charAt(i - 1);
                    if (d == '"' || d == ']') {
                        jsonForMatStr.append(c + "\n");
                    } else {
                        jsonForMatStr.append(c);
                    }
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }

    static Set<String> set = new HashSet<>();

    private static StringBuilder creatHtmlTable(String string, JsonElement o, StringBuilder sb) {
        if (o == null || o.isJsonNull() && !set.contains(string)) {
            sb.append("<tr class='Structure'>");
            addChineseParamName(sb, string);
            htmlTable(sb, 0, 0, "FFFFFF", string);
            htmlTable(sb, 0, 2, "FFFFFF", "String");
            htmlTable(sb, 0, 1, "FFFFFF", "");
            set.add(string);
            sb.append("</tr>\n");
            return sb;
        }
        if (o.isJsonPrimitive()) {
            JsonPrimitive jsonPrimitive = o.getAsJsonPrimitive();
            if (jsonPrimitive.isString() && !set.contains(string)) {
                sb.append("<tr class='Structure'>");
                addChineseParamName(sb, string);
                htmlTable(sb, 0, 0, "FFFFFF", string);
                htmlTable(sb, 0, 2, "FFFFFF", "String");
                htmlTable(sb, 0, 1, "FFFFFF", "");
                set.add(string);
                sb.append("</tr>\n");
                return sb;
            } else if (jsonPrimitive.isNumber() && !set.contains(string)) {
                sb.append("<tr class='Structure'>");
                addChineseParamName(sb, string);
                htmlTable(sb, 0, 0, "FFFFFF", string);
                htmlTable(sb, 0, 2, "FFFFFF", "Integer");
                htmlTable(sb, 0, 1, "FFFFFF", "");
                set.add(string);
                sb.append("</tr>\n");
                return sb;
            }
        }

        if (o.isJsonObject()) {
            JsonObject jsonObject = o.getAsJsonObject();
            Set<String> strings = (jsonObject).keySet();
            for (String s : strings) {
                creatHtmlTable(s, jsonObject.get(s), sb);
            }
        } else if (o.isJsonArray()) {
            JsonArray jsonArray = o.getAsJsonArray();
            for (JsonElement next : jsonArray) {
                if (next.isJsonObject()) {
                    JsonObject jsonObject = next.getAsJsonObject();
                    Set<String> strings = (jsonObject).keySet();
                    for (String s : strings) {
                        creatHtmlTable(s, jsonObject.get(s), sb);
                    }
                }
            }
        }
        return sb;
    }

    private static Map<String, String> getResponseParam() throws IOException {
        String s = readString("D:\\project\\123\\src\\main\\resources\\" + returnFile);
        JSONArray jsonArray = JSONObject.parseArray(s);
        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < jsonArray.size(); j++) {
            JSONObject jsonObject = jsonArray.getJSONObject(j);
            JSONArray list = jsonObject.getJSONArray("list");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                JSONObject json = list.getJSONObject(i);
                JSONObject query_path = json.getJSONObject("query_path");
                String res_body = json.getString("res_body");
                String path = query_path.getString("path");
                map.put((projectName + path).toUpperCase(), res_body);
            }
        }
        return map;
    }

    private static Map<String, String> getResponseParam2() throws IOException {
        String s = readString("D:\\project\\123\\src\\main\\resources\\" + returnFile);
        JSONArray jsonArray = JSONObject.parseArray(s);
        Map<String, String> map = new HashMap<>();
        for (int j = 0; j < jsonArray.size(); j++) {
            JSONObject jsonObject = jsonArray.getJSONObject(j);
            JSONArray list = jsonObject.getJSONArray("list");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                JSONObject json = list.getJSONObject(i);
                JSONObject query_path = json.getJSONObject("query_path");
                String res_body = json.getString("title");
                String path = query_path.getString("path");
                map.put(projectName + path, res_body);
            }
        }
        return map;
    }

    private static void addChineseParamName(StringBuilder table, String parameterName) {
        if (parameterName != null) {
            if (parameterName.equalsIgnoreCase("pageNum")) {
                htmlTable(table, 0, 0, "FFFFFF", "当前页面");
            } else if (parameterName.equalsIgnoreCase("pageSize")) {
                htmlTable(table, 0, 0, "FFFFFF", "每页显示");
            } else if (parameterName.equalsIgnoreCase("nodeType")) {
                htmlTable(table, 0, 0, "FFFFFF", "节点类型");
            } else if (parameterName.equalsIgnoreCase("ebId")) {
                htmlTable(table, 0, 0, "FFFFFF", "电箱编号");
            } else if (parameterName.equalsIgnoreCase("commandNo")) {
                htmlTable(table, 0, 0, "FFFFFF", "命令号");
            } else if (parameterName.equalsIgnoreCase("operationType")) {
                htmlTable(table, 0, 0, "FFFFFF", "操作类型");
            } else if (parameterName.equalsIgnoreCase("playType")) {
                htmlTable(table, 0, 0, "FFFFFF", "播放类型");
            } else if (parameterName.equalsIgnoreCase("nodeStatus")) {
                htmlTable(table, 0, 0, "FFFFFF", "节点状态");
            } else if (parameterName.equalsIgnoreCase("searchKey")) {
                htmlTable(table, 0, 0, "FFFFFF", "搜索关键字");
            } else if (parameterName.equalsIgnoreCase("verify")) {
                htmlTable(table, 0, 0, "FFFFFF", "校验");
            } else if (parameterName.equalsIgnoreCase("week")) {
                htmlTable(table, 0, 0, "FFFFFF", "周");
            } else if (parameterName.equalsIgnoreCase("textContent")) {
                htmlTable(table, 0, 0, "FFFFFF", "文字内容");
            } else if (parameterName.equalsIgnoreCase("textEffect")) {
                htmlTable(table, 0, 0, "FFFFFF", "文字效果");
            } else if (parameterName.equalsIgnoreCase("textArrangeDirection")) {
                htmlTable(table, 0, 0, "FFFFFF", "文字排列方向");
            } else if (parameterName.equalsIgnoreCase("textFontColor")) {
                htmlTable(table, 0, 0, "FFFFFF", "文字字体颜色");
            } else if (parameterName.equalsIgnoreCase("textFontBackColor")) {
                htmlTable(table, 0, 0, "FFFFFF", "文字字体返回颜色");
            } else if (parameterName.equalsIgnoreCase("textFontSpacing")) {
                htmlTable(table, 0, 0, "FFFFFF", "文字字体间距");
            } else if (parameterName.equalsIgnoreCase("textFontName")) {
                htmlTable(table, 0, 0, "FFFFFF", "文字字体名称");
            } else if (parameterName.equalsIgnoreCase("materialType")) {
                htmlTable(table, 0, 0, "FFFFFF", "材料类型");
            } else if (parameterName.equalsIgnoreCase("sendStatus")) {
                htmlTable(table, 0, 0, "FFFFFF", "发送状态");
            } else if (parameterName.equalsIgnoreCase("total")) {
                htmlTable(table, 0, 0, "FFFFFF", "总条数");
            } else if (parameterName.equalsIgnoreCase("pages")) {
                htmlTable(table, 0, 0, "FFFFFF", "总页数");
            } else if (parameterName.equalsIgnoreCase("code")) {
                htmlTable(table, 0, 0, "FFFFFF", "代号");
            } else if (parameterName.equalsIgnoreCase("value")) {
                htmlTable(table, 0, 0, "FFFFFF", "值");
            } else if (parameterName.equalsIgnoreCase("areaName")) {
                htmlTable(table, 0, 0, "FFFFFF", "地区名");
            } else if (parameterName.equalsIgnoreCase("orgId")) {
                htmlTable(table, 0, 0, "FFFFFF", "组织编号");
            } else if (parameterName.equalsIgnoreCase("orgName")) {
                htmlTable(table, 0, 0, "FFFFFF", "组织名字");
            } else if (parameterName.equalsIgnoreCase("roleRelId")) {
                htmlTable(table, 0, 0, "FFFFFF", "角色关联id");
            } else if (parameterName.equalsIgnoreCase("roleId")) {
                htmlTable(table, 0, 0, "FFFFFF", "角色id");
            } else if (parameterName.equalsIgnoreCase("roleName")) {
                htmlTable(table, 0, 0, "FFFFFF", "角色名");
            } else if (parameterName.equalsIgnoreCase("departmentId")) {
                htmlTable(table, 0, 0, "FFFFFF", "部门编号");
            } else if (parameterName.equalsIgnoreCase("departmentName")) {
                htmlTable(table, 0, 0, "FFFFFF", "部门名字");
            } else if (parameterName.equalsIgnoreCase("userId")) {
                htmlTable(table, 0, 0, "FFFFFF", "用户编号");
            } else if (parameterName.equalsIgnoreCase("name")) {
                htmlTable(table, 0, 0, "FFFFFF", "名字");
            } else if (parameterName.equalsIgnoreCase("userName")) {
                htmlTable(table, 0, 0, "FFFFFF", "用户名");
            } else if (parameterName.equalsIgnoreCase("mobile")) {
                htmlTable(table, 0, 0, "FFFFFF", "电话");
            } else if (parameterName.equalsIgnoreCase("email")) {
                htmlTable(table, 0, 0, "FFFFFF", "邮箱");
            } else if (parameterName.equalsIgnoreCase("content")) {
                htmlTable(table, 0, 0, "FFFFFF", "内容");
            } else if (parameterName.equalsIgnoreCase("avatar")) {
                htmlTable(table, 0, 0, "FFFFFF", "头像");
            } else if (parameterName.equalsIgnoreCase("status")) {
                htmlTable(table, 0, 0, "FFFFFF", "状态");
            } else if (parameterName.equalsIgnoreCase("isOrgManager")) {
                htmlTable(table, 0, 0, "FFFFFF", "是否管理员");
            } else if (parameterName.equalsIgnoreCase("organizationId")) {
                htmlTable(table, 0, 0, "FFFFFF", "组织编号");
            } else if (parameterName.equalsIgnoreCase("status")) {
                htmlTable(table, 0, 0, "FFFFFF", "状态");
            } else if (parameterName.equalsIgnoreCase("password")) {
                htmlTable(table, 0, 0, "FFFFFF", "密码");
            } else if (parameterName.equalsIgnoreCase("status")) {
                htmlTable(table, 0, 0, "FFFFFF", "状态");
            } else if (parameterName.equalsIgnoreCase("id")) {
                htmlTable(table, 0, 0, "FFFFFF", "编号");
            } else if (parameterName.equalsIgnoreCase("ip")) {
                htmlTable(table, 0, 0, "FFFFFF", "ip");
            } else if (parameterName.equalsIgnoreCase("taskId")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单编号");
            } else if (parameterName.equalsIgnoreCase("content")) {
                htmlTable(table, 0, 0, "FFFFFF", "内容");
            } else if (parameterName.equalsIgnoreCase("proId")) {
                htmlTable(table, 0, 0, "FFFFFF", "流程实例id");
            } else if (parameterName.equalsIgnoreCase("oaOrderId")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单实例");

            } else if (parameterName.equalsIgnoreCase("flag")) {
                htmlTable(table, 0, 0, "FFFFFF", "标志");
            } else if (parameterName.equalsIgnoreCase("type")) {
                htmlTable(table, 0, 0, "FFFFFF", "类型");
            } else if (parameterName.equalsIgnoreCase("switchStatus")) {
                htmlTable(table, 0, 0, "FFFFFF", "开关状态");
            } else if (parameterName.equalsIgnoreCase("lat")) {
                htmlTable(table, 0, 0, "FFFFFF", "进度");
            } else if (parameterName.equalsIgnoreCase("lng")) {
                htmlTable(table, 0, 0, "FFFFFF", "纬度");
            } else if (parameterName.equalsIgnoreCase("signalStrength")) {
                htmlTable(table, 0, 0, "FFFFFF", "信号强度");
            } else if (parameterName.equalsIgnoreCase("describe")) {
                htmlTable(table, 0, 0, "FFFFFF", "描述");
            } else if (parameterName.equalsIgnoreCase("playStatus")) {
                htmlTable(table, 0, 0, "FFFFFF", "播放状态");
            } else if (parameterName.equalsIgnoreCase("provinceName")) {
                htmlTable(table, 0, 0, "FFFFFF", "省名");
            } else if (parameterName.equalsIgnoreCase("cityName")) {
                htmlTable(table, 0, 0, "FFFFFF", "市名");
            } else if (parameterName.equalsIgnoreCase("districtName")) {
                htmlTable(table, 0, 0, "FFFFFF", "区名");


            } else if (parameterName.equalsIgnoreCase("roadName")) {
                htmlTable(table, 0, 0, "FFFFFF", "路名");
            } else if (parameterName.equalsIgnoreCase("areaName")) {
                htmlTable(table, 0, 0, "FFFFFF", "地区名称");
            } else if (parameterName.equalsIgnoreCase("fullAddress")) {
                htmlTable(table, 0, 0, "FFFFFF", "详细地址");
            } else if (parameterName.equalsIgnoreCase("sn")) {
                htmlTable(table, 0, 0, "FFFFFF", "序列号");
            } else if (parameterName.equalsIgnoreCase("guaranteeRecordId")) {
                htmlTable(table, 0, 0, "FFFFFF", "养护记录id");
            } else if (parameterName.equalsIgnoreCase("guaranteeDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修情况描述");
            } else if (parameterName.equalsIgnoreCase("guaranteeImgs")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修图片地址列表");
            } else if (parameterName.equalsIgnoreCase("createTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "创建时间");
            } else if (parameterName.equalsIgnoreCase("updateTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "最后更新时间");

            } else if (parameterName.equalsIgnoreCase("orderId")) {
                htmlTable(table, 0, 0, "FFFFFF", "命令编号");
            } else if (parameterName.equalsIgnoreCase("maintainRecordId")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修记录id");
            } else if (parameterName.equalsIgnoreCase("repairDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修情况描述");
            } else if (parameterName.equalsIgnoreCase("maintainDevList")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修设备列表");
            } else if (parameterName.equalsIgnoreCase("repairImgs")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修图片地址列表");


            } else if (parameterName.equalsIgnoreCase("signDate")) {
                htmlTable(table, 0, 0, "FFFFFF", "打卡时间");
            } else if (parameterName.equalsIgnoreCase("year")) {
                htmlTable(table, 0, 0, "FFFFFF", "年");
            } else if (parameterName.equalsIgnoreCase("month")) {
                htmlTable(table, 0, 0, "FFFFFF", "月");
            } else if (parameterName.equalsIgnoreCase("isDepManager")) {
                htmlTable(table, 0, 0, "FFFFFF", "是否是部门领导");
            } else if (parameterName.equalsIgnoreCase("repairImgs")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修图片地址列表");
            } else if (parameterName.equalsIgnoreCase("token")) {
                htmlTable(table, 0, 0, "FFFFFF", "令牌");
            } else if (parameterName.equalsIgnoreCase("captcha")) {
                htmlTable(table, 0, 0, "FFFFFF", "验证码");
            } else if (parameterName.equalsIgnoreCase("file")) {
                htmlTable(table, 0, 0, "FFFFFF", "文件");
            } else if (parameterName.equalsIgnoreCase("newPassword")) {
                htmlTable(table, 0, 0, "FFFFFF", "密码");
            } else if (parameterName.equalsIgnoreCase("oldPassword")) {
                htmlTable(table, 0, 0, "FFFFFF", "密码");
            } else if (parameterName.equalsIgnoreCase("yearMonth")) {
                htmlTable(table, 0, 0, "FFFFFF", "年月");
            } else if (parameterName.equalsIgnoreCase("departId")) {
                htmlTable(table, 0, 0, "FFFFFF", "部门编号");
            } else if (parameterName.equalsIgnoreCase("selectDate")) {
                htmlTable(table, 0, 0, "FFFFFF", "选择时间");
            } else if (parameterName.equalsIgnoreCase("updateMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "更新人");
            } else if (parameterName.equalsIgnoreCase("date")) {
                htmlTable(table, 0, 0, "FFFFFF", "时间");
            } else if (parameterName.equalsIgnoreCase("title")) {
                htmlTable(table, 0, 0, "FFFFFF", "标题");
            } else if (parameterName.equalsIgnoreCase("creater")) {
                htmlTable(table, 0, 0, "FFFFFF", "创造者");
            } else if (parameterName.equalsIgnoreCase("updater")) {
                htmlTable(table, 0, 0, "FFFFFF", "更新者");
            } else if (parameterName.equalsIgnoreCase("read")) {
                htmlTable(table, 0, 0, "FFFFFF", "读数");
            } else if (parameterName.equalsIgnoreCase("createrName")) {
                htmlTable(table, 0, 0, "FFFFFF", "创造者名字");


            } else if (parameterName.equalsIgnoreCase("createrName")) {
                htmlTable(table, 0, 0, "FFFFFF", "创造者名字");
            } else if (parameterName.equalsIgnoreCase("createTimeStr")) {
                htmlTable(table, 0, 0, "FFFFFF", "创建时间字符串");
            } else if (parameterName.equalsIgnoreCase("contractFiles")) {
                htmlTable(table, 0, 0, "FFFFFF", "合同文件");
            } else if (parameterName.equalsIgnoreCase("landmarkId")) {
                htmlTable(table, 0, 0, "FFFFFF", "地标id");
            } else if (parameterName.equalsIgnoreCase("landmarkName")) {
                htmlTable(table, 0, 0, "FFFFFF", "地标名称");
            } else if (parameterName.equalsIgnoreCase("assetsTotal")) {
                htmlTable(table, 0, 0, "FFFFFF", "资产合计");
            } else if (parameterName.equalsIgnoreCase("devTypeName")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备类型名称");
            } else if (parameterName.equalsIgnoreCase("purchaseId")) {
                htmlTable(table, 0, 0, "FFFFFF", "采购记录id");
            } else if (parameterName.equalsIgnoreCase("devName")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备名称");
            } else if (parameterName.equalsIgnoreCase("price")) {
                htmlTable(table, 0, 0, "FFFFFF", "单价");
            } else if (parameterName.equalsIgnoreCase("unit")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备计量单位");
            } else if (parameterName.equalsIgnoreCase("supplier")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备供应商");
            } else if (parameterName.equalsIgnoreCase("typeId")) {
                htmlTable(table, 0, 0, "FFFFFF", "类型编号");
            } else if (parameterName.equalsIgnoreCase("devCount")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备数量");
            } else if (parameterName.equalsIgnoreCase("assetsDepreciationTotal")) {
                htmlTable(table, 0, 0, "FFFFFF", "资产折旧合计");
            } else if (parameterName.equalsIgnoreCase("guaranteeCosts")) {
                htmlTable(table, 0, 0, "FFFFFF", "养护次数");
            } else if (parameterName.equalsIgnoreCase("guaranteeNum")) {
                htmlTable(table, 0, 0, "FFFFFF", "养护成本");
            } else if (parameterName.equalsIgnoreCase("checkItemIds")) {
                htmlTable(table, 0, 0, "FFFFFF", "检查项id");
            } else if (parameterName.equalsIgnoreCase("abnormalInfo")) {
                htmlTable(table, 0, 0, "FFFFFF", "异常信息");
            } else if (parameterName.equalsIgnoreCase("siteInfo")) {
                htmlTable(table, 0, 0, "FFFFFF", "位置信息");
            } else if (parameterName.equalsIgnoreCase("abnormalType")) {
                htmlTable(table, 0, 0, "FFFFFF", "异常类型");
            } else if (parameterName.equalsIgnoreCase("imgUrlList")) {
                htmlTable(table, 0, 0, "FFFFFF", "图片地址列表");
            } else if (parameterName.equalsIgnoreCase("abnormalDescList")) {
                htmlTable(table, 0, 0, "FFFFFF", "异常描述");
            } else if (parameterName.equalsIgnoreCase("pointId")) {
                htmlTable(table, 0, 0, "FFFFFF", "保障点id");
            } else if (parameterName.equalsIgnoreCase("assureTaskLandmarkList")) {
                htmlTable(table, 0, 0, "FFFFFF", "保障点相关的地标异常信息");
            } else if (parameterName.equalsIgnoreCase("normalImgs")) {
                htmlTable(table, 0, 0, "FFFFFF", "正常情况的佐证图片");
            } else if (parameterName.equalsIgnoreCase("imgName")) {
                htmlTable(table, 0, 0, "FFFFFF", "图片名称");
            } else if (parameterName.equalsIgnoreCase("imgURL")) {
                htmlTable(table, 0, 0, "FFFFFF", "图片url");
            } else if (parameterName.equalsIgnoreCase("recordId")) {
                htmlTable(table, 0, 0, "FFFFFF", "巡检记录id");
            } else if (parameterName.equalsIgnoreCase("inspectPointId")) {
                htmlTable(table, 0, 0, "FFFFFF", "巡检点id");
            } else if (parameterName.equalsIgnoreCase("pointName")) {
                htmlTable(table, 0, 0, "FFFFFF", "巡检点名称");
            } else if (parameterName.equalsIgnoreCase("orderSn")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单Sn");
            } else if (parameterName.equalsIgnoreCase("politicalOutlook")) {
                htmlTable(table, 0, 0, "FFFFFF", "政治观");
            } else if (parameterName.equalsIgnoreCase("place")) {
                htmlTable(table, 0, 0, "FFFFFF", "通讯地址");
            } else if (parameterName.equalsIgnoreCase("education")) {
                htmlTable(table, 0, 0, "FFFFFF", "学历");
            } else if (parameterName.equalsIgnoreCase("major")) {
                htmlTable(table, 0, 0, "FFFFFF", "专业");
            } else if (parameterName.equalsIgnoreCase("university")) {
                htmlTable(table, 0, 0, "FFFFFF", "毕业院校");
            } else if (parameterName.equalsIgnoreCase("entryTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "入职时间");
            } else if (parameterName.equalsIgnoreCase("department")) {
                htmlTable(table, 0, 0, "FFFFFF", "部门名称");
            } else if (parameterName.equalsIgnoreCase("job")) {
                htmlTable(table, 0, 0, "FFFFFF", "职务");
            } else if (parameterName.equalsIgnoreCase("endowmentInsurance")) {
                htmlTable(table, 0, 0, "FFFFFF", "养老保险");
            } else if (parameterName.equalsIgnoreCase("employmentInjuryInsurance")) {
                htmlTable(table, 0, 0, "FFFFFF", "工伤保险");
            } else if (parameterName.equalsIgnoreCase("medicalInsurance")) {
                htmlTable(table, 0, 0, "FFFFFF", "医疗保险");
            } else if (parameterName.equalsIgnoreCase("unemploymentInsurance")) {
                htmlTable(table, 0, 0, "FFFFFF", "失业保险");
            } else if (parameterName.equalsIgnoreCase("maternityInsurance")) {
                htmlTable(table, 0, 0, "FFFFFF", "生育保险");
            } else if (parameterName.equalsIgnoreCase("housingProvidentFund")) {
                htmlTable(table, 0, 0, "FFFFFF", "住房公积金");
            } else if (parameterName.equalsIgnoreCase("socialSecurityAccount")) {
                htmlTable(table, 0, 0, "FFFFFF", "社保账户");
            } else if (parameterName.equalsIgnoreCase("certificateInformation")) {
                htmlTable(table, 0, 0, "FFFFFF", "证书信息");
            } else if (parameterName.equalsIgnoreCase("nativePlace")) {
                htmlTable(table, 0, 0, "FFFFFF", "籍贯");

            } else if (parameterName.equalsIgnoreCase("nation")) {
                htmlTable(table, 0, 0, "FFFFFF", "民族");
            } else if (parameterName.equalsIgnoreCase("registeredResidence")) {
                htmlTable(table, 0, 0, "FFFFFF", "户口性质");
            } else if (parameterName.equalsIgnoreCase("birthday")) {
                htmlTable(table, 0, 0, "FFFFFF", "出生年月");
            } else if (parameterName.equalsIgnoreCase("personalPhotoUrl")) {
                htmlTable(table, 0, 0, "FFFFFF", "个人照片url");
            } else if (parameterName.equalsIgnoreCase("sex")) {
                htmlTable(table, 0, 0, "FFFFFF", "性别");
            } else if (parameterName.equalsIgnoreCase("numberId")) {
                htmlTable(table, 0, 0, "FFFFFF", "身份证号");
            } else if (parameterName.equalsIgnoreCase("scrapId")) {
                htmlTable(table, 0, 0, "FFFFFF", "关联的设备报废表的sn");
            } else if (parameterName.equalsIgnoreCase("orderId")) {
                htmlTable(table, 0, 0, "FFFFFF", "报废记录关联的入库工单id");
            } else if (parameterName.equalsIgnoreCase("devSn")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备sn");
            } else if (parameterName.equalsIgnoreCase("scrapNumber")) {
                htmlTable(table, 0, 0, "FFFFFF", "报废数量");
            } else if (parameterName.equalsIgnoreCase("scrapReson")) {
                htmlTable(table, 0, 0, "FFFFFF", "报废原因");
            } else if (parameterName.equalsIgnoreCase("dfee")) {
                htmlTable(table, 0, 0, "FFFFFF", "前端传double类型电费");
            } else if (parameterName.equalsIgnoreCase("fee")) {
                htmlTable(table, 0, 0, "FFFFFF", "费");
            } else if (parameterName.equalsIgnoreCase("startTimeS")) {
                htmlTable(table, 0, 0, "FFFFFF", "接受前端传递来的字符串类型开始时间");
            } else if (parameterName.equalsIgnoreCase("endTimeS")) {
                htmlTable(table, 0, 0, "FFFFFF", "接受前端传递来的字符串类型结束时间");
            } else if (parameterName.equalsIgnoreCase("endTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "结束时间");
            } else if (parameterName.equalsIgnoreCase("startTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "开始时间");
            } else if (parameterName.equalsIgnoreCase("port")) {
                htmlTable(table, 0, 0, "FFFFFF", "端口号");
            } else if (parameterName.equalsIgnoreCase("oaSource")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单来源信息");
            } else if (parameterName.equalsIgnoreCase("owner")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单创建人");
            } else if (parameterName.equalsIgnoreCase("oaTypeId")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单总类型");
            } else if (parameterName.equalsIgnoreCase("level")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单优先级");
            } else if (parameterName.equalsIgnoreCase("resource")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单来源");
            } else if (parameterName.equalsIgnoreCase("masterOrder")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单关联巡检工单");
            } else if (parameterName.equalsIgnoreCase("outRepOrder")) {
                htmlTable(table, 0, 0, "FFFFFF", "工单关联出库工单");
            } else if (parameterName.equalsIgnoreCase("supplier")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备供应商");
            } else if (parameterName.equalsIgnoreCase("result")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修结果");
            } else if (parameterName.equalsIgnoreCase("exceptionDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "异常描述");
            } else if (parameterName.equalsIgnoreCase("siteDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "位置信息");
            } else if (parameterName.equalsIgnoreCase("inspectImg")) {
                htmlTable(table, 0, 0, "FFFFFF", "巡检图片");
            } else if (parameterName.equalsIgnoreCase("repairDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修情况说明");
            } else if (parameterName.equalsIgnoreCase("beginDate")) {
                htmlTable(table, 0, 0, "FFFFFF", "查询条件--开始日期");
            } else if (parameterName.equalsIgnoreCase("endDate")) {
                htmlTable(table, 0, 0, "FFFFFF", "查询条件--结束日期");
            } else if (parameterName.equalsIgnoreCase("responsiblePerson")) {
                htmlTable(table, 0, 0, "FFFFFF", "经办人");
            } else if (parameterName.equalsIgnoreCase("applyPerson")) {
                htmlTable(table, 0, 0, "FFFFFF", "申请人");
            } else if (parameterName.equalsIgnoreCase("startDate")) {
                htmlTable(table, 0, 0, "FFFFFF", "开始时间");
            } else if (parameterName.equalsIgnoreCase("endDate")) {
                htmlTable(table, 0, 0, "FFFFFF", "结束时间");
            } else if (parameterName.equalsIgnoreCase("workHour")) {
                htmlTable(table, 0, 0, "FFFFFF", "工作时长");
            } else if (parameterName.equalsIgnoreCase("note")) {
                htmlTable(table, 0, 0, "FFFFFF", "备注");
            } else if (parameterName.equalsIgnoreCase("updateMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "修改人");
            } else if (parameterName.equalsIgnoreCase("count")) {
                htmlTable(table, 0, 0, "FFFFFF", "数量");
            } else if (parameterName.equalsIgnoreCase("start")) {
                htmlTable(table, 0, 0, "FFFFFF", "开始");
            } else if (parameterName.equalsIgnoreCase("lightDuration")) {
                htmlTable(table, 0, 0, "FFFFFF", "亮灯时长");
            } else if (parameterName.equalsIgnoreCase("address")) {
                htmlTable(table, 0, 0, "FFFFFF", "地址");
            } else if (parameterName.equalsIgnoreCase("voltage")) {
                htmlTable(table, 0, 0, "FFFFFF", "电压");
            } else if (parameterName.equalsIgnoreCase("electricCurrent")) {
                htmlTable(table, 0, 0, "FFFFFF", "电流");
            } else if (parameterName.equalsIgnoreCase("faultTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "故障时间");
            } else if (parameterName.equalsIgnoreCase("faultDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "故障描述");
            } else if (parameterName.equalsIgnoreCase("manufacturer")) {
                htmlTable(table, 0, 0, "FFFFFF", "制造商");
            } else if (parameterName.equalsIgnoreCase("accessoryUrl")) {
                htmlTable(table, 0, 0, "FFFFFF", "附件网址");
            } else if (parameterName.equalsIgnoreCase("nodeSum")) {
                htmlTable(table, 0, 0, "FFFFFF", "节点数量");
            } else if (parameterName.equalsIgnoreCase("branchLightSum")) {
                htmlTable(table, 0, 0, "FFFFFF", "分控数量");
            } else if (parameterName.equalsIgnoreCase("monitorSum")) {
                htmlTable(table, 0, 0, "FFFFFF", "摄像头数量");
            } else if (parameterName.equalsIgnoreCase("devSum")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备数量");
            } else if (parameterName.equalsIgnoreCase("fences")) {
                htmlTable(table, 0, 0, "FFFFFF", "围栏");
            } else if (parameterName.equalsIgnoreCase("fencesList")) {
                htmlTable(table, 0, 0, "FFFFFF", "围栏清单");
            } else if (parameterName.equalsIgnoreCase("maintainNum")) {
                htmlTable(table, 0, 0, "FFFFFF", "维护数量");
            } else if (parameterName.equalsIgnoreCase("maintainCosts")) {
                htmlTable(table, 0, 0, "FFFFFF", "维护花费");
            } else if (parameterName.equalsIgnoreCase("streetLightId")) {
                htmlTable(table, 0, 0, "FFFFFF", "路灯ID");
            } else if (parameterName.equalsIgnoreCase("landMarkId")) {
                htmlTable(table, 0, 0, "FFFFFF", "地标ID");
            } else if (parameterName.equalsIgnoreCase("nodes")) {
                htmlTable(table, 0, 0, "FFFFFF", "总节点数");
            } else if (parameterName.equalsIgnoreCase("controls")) {
                htmlTable(table, 0, 0, "FFFFFF", "总分控数");
            } else if (parameterName.equalsIgnoreCase("lamps")) {
                htmlTable(table, 0, 0, "FFFFFF", "总灯具数");
            } else if (parameterName.equalsIgnoreCase("rtus")) {
                htmlTable(table, 0, 0, "FFFFFF", "电箱数");
            } else if (parameterName.equalsIgnoreCase("assets")) {
                htmlTable(table, 0, 0, "FFFFFF", "资产");
            } else if (parameterName.equalsIgnoreCase("depreciated")) {
                htmlTable(table, 0, 0, "FFFFFF", "折旧");
            } else if (parameterName.equalsIgnoreCase("inspectNum")) {
                htmlTable(table, 0, 0, "FFFFFF", "检查数量");
            } else if (parameterName.equalsIgnoreCase("maintainNum")) {
                htmlTable(table, 0, 0, "FFFFFF", "维护数量");
            } else if (parameterName.equalsIgnoreCase("landId")) {
                htmlTable(table, 0, 0, "FFFFFF", "土地编号");
            } else if (parameterName.equalsIgnoreCase("landName")) {
                htmlTable(table, 0, 0, "FFFFFF", "地名");
            } else if (parameterName.equalsIgnoreCase("specKey")) {
                htmlTable(table, 0, 0, "FFFFFF", "规格键");
            } else if (parameterName.equalsIgnoreCase("specValues")) {
                htmlTable(table, 0, 0, "FFFFFF", "规格值");
            } else if (parameterName.equalsIgnoreCase("specValueAttr")) {
                htmlTable(table, 0, 0, "FFFFFF", "规格值属性");
            } else if (parameterName.equalsIgnoreCase("sort")) {
                htmlTable(table, 0, 0, "FFFFFF", "分类");
            } else if (parameterName.equalsIgnoreCase("remark")) {
                htmlTable(table, 0, 0, "FFFFFF", "备注");
            } else if (parameterName.equalsIgnoreCase("checkPerson")) {
                htmlTable(table, 0, 0, "FFFFFF", "检查人员");
            } else if (parameterName.equalsIgnoreCase("claimant")) {
                htmlTable(table, 0, 0, "FFFFFF", "领料人id");
            } else if (parameterName.equalsIgnoreCase("claimantName")) {
                htmlTable(table, 0, 0, "FFFFFF", "领料人姓名");
            } else if (parameterName.equalsIgnoreCase("claimantPhone")) {
                htmlTable(table, 0, 0, "FFFFFF", "领料人电话");
            } else if (parameterName.equalsIgnoreCase("approver")) {
                htmlTable(table, 0, 0, "FFFFFF", "审批人id");
            } else if (parameterName.equalsIgnoreCase("approverName")) {
                htmlTable(table, 0, 0, "FFFFFF", "审批人姓名");
            } else if (parameterName.equalsIgnoreCase("approverPhone")) {
                htmlTable(table, 0, 0, "FFFFFF", "审批人电话");
            } else if (parameterName.equalsIgnoreCase("purpose")) {
                htmlTable(table, 0, 0, "FFFFFF", "目的");
            } else if (parameterName.equalsIgnoreCase("landName")) {
                htmlTable(table, 0, 0, "FFFFFF", "领料人id");
            } else if (parameterName.equalsIgnoreCase("landName")) {
                htmlTable(table, 0, 0, "FFFFFF", "领料人id");
            } else if (parameterName.equalsIgnoreCase("Id")) {
                htmlTable(table, 0, 0, "FFFFFF", "编号");
            } else if (parameterName.equalsIgnoreCase("backCount")) {
                htmlTable(table, 0, 0, "FFFFFF", "归还");
            } else if (parameterName.equalsIgnoreCase("stocker")) {
                htmlTable(table, 0, 0, "FFFFFF", "储存");
            } else if (parameterName.equalsIgnoreCase("stockerName")) {
                htmlTable(table, 0, 0, "FFFFFF", "仓库名称");
            } else if (parameterName.equalsIgnoreCase("purchaseSn")) {
                htmlTable(table, 0, 0, "FFFFFF", "购买序列号");
            } else if (parameterName.equalsIgnoreCase("stockoutSn")) {
                htmlTable(table, 0, 0, "FFFFFF", "缺少序列号");
            } else if (parameterName.equalsIgnoreCase("refundMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "退款人");
            } else if (parameterName.equalsIgnoreCase("SN")) {
                htmlTable(table, 0, 0, "FFFFFF", "序列号");
            } else if (parameterName.equalsIgnoreCase("DevSn")) {
                htmlTable(table, 0, 0, "FFFFFF", "dev序列号");
            } else if (parameterName.equalsIgnoreCase("repairSn")) {
                htmlTable(table, 0, 0, "FFFFFF", "维修序列号");
            } else if (parameterName.equalsIgnoreCase("scrapTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "报废时间");
            } else if (parameterName.equalsIgnoreCase("list")) {
                htmlTable(table, 0, 0, "FFFFFF", "数组");
            } else if (parameterName.equalsIgnoreCase("List")) {
                htmlTable(table, 0, 0, "FFFFFF", "数组");
            } else if (parameterName.equalsIgnoreCase("utilPrice")) {
                htmlTable(table, 0, 0, "FFFFFF", "工具的价格");
            } else if (parameterName.equalsIgnoreCase("manufactorId")) {
                htmlTable(table, 0, 0, "FFFFFF", "制造商ID");
            } else if (parameterName.equalsIgnoreCase("util")) {
                htmlTable(table, 0, 0, "FFFFFF", "工具");
            } else if (parameterName.equalsIgnoreCase("life")) {
                htmlTable(table, 0, 0, "FFFFFF", "生活");
            } else if (parameterName.equalsIgnoreCase("manufactorSN")) {
                htmlTable(table, 0, 0, "FFFFFF", "制造商序列号");
            } else if (parameterName.equalsIgnoreCase("manufactorName")) {
                htmlTable(table, 0, 0, "FFFFFF", "制造商名称");
            } else if (parameterName.equalsIgnoreCase("SNName")) {
                htmlTable(table, 0, 0, "FFFFFF", "SN名称");
            } else if (parameterName.equalsIgnoreCase("ManuName")) {
                htmlTable(table, 0, 0, "FFFFFF", "Manu名称");
            } else if (parameterName.equalsIgnoreCase("ManuSN")) {
                htmlTable(table, 0, 0, "FFFFFF", "Manu SN");
            } else if (parameterName.equalsIgnoreCase("remainingStockNumber")) {
                htmlTable(table, 0, 0, "FFFFFF", "剩余库存");
            } else if (parameterName.equalsIgnoreCase("Name")) {
                htmlTable(table, 0, 0, "FFFFFF", "名字");
            } else if (parameterName.equalsIgnoreCase("periodFees")) {
                htmlTable(table, 0, 0, "FFFFFF", "期间费用");
            } else if (parameterName.equalsIgnoreCase("mrFree")) {
                htmlTable(table, 0, 0, "FFFFFF", "费用");
            } else if (parameterName.equalsIgnoreCase("periodId")) {
                htmlTable(table, 0, 0, "FFFFFF", "期间编号");
            } else if (parameterName.equalsIgnoreCase("timePeriodId")) {
                htmlTable(table, 0, 0, "FFFFFF", "时间段ID");
            } else if (parameterName.equalsIgnoreCase("bimLandmarkId")) {
                htmlTable(table, 0, 0, "FFFFFF", "BIM地标ID");
            } else if (parameterName.equalsIgnoreCase("num")) {
                htmlTable(table, 0, 0, "FFFFFF", "数量");
            } else if (parameterName.equalsIgnoreCase("repairMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "修理工");
            } else if (parameterName.equalsIgnoreCase("inspector")) {
                htmlTable(table, 0, 0, "FFFFFF", "检查员");
            } else if (parameterName.equalsIgnoreCase("inspectOrderId")) {
                htmlTable(table, 0, 0, "FFFFFF", "检查订单ID");
            } else if (parameterName.equalsIgnoreCase("devType")) {
                htmlTable(table, 0, 0, "FFFFFF", "设备类型");
            } else if (parameterName.equalsIgnoreCase("oaType")) {
                htmlTable(table, 0, 0, "FFFFFF", "类型");
            } else if (parameterName.equalsIgnoreCase("oaResource")) {
                htmlTable(table, 0, 0, "FFFFFF", "资源的");
            } else if (parameterName.equalsIgnoreCase("overTime")) {
                htmlTable(table, 0, 0, "FFFFFF", "超时时间");
            } else if (parameterName.equalsIgnoreCase("workMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "工作人");
            } else if (parameterName.equalsIgnoreCase("procInstId")) {
                htmlTable(table, 0, 0, "FFFFFF", "流程实例id");
            } else if (parameterName.equalsIgnoreCase("guaranteeMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "养护人员id");
            } else if (parameterName.equalsIgnoreCase("assureMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "保证人");
            } else if (parameterName.equalsIgnoreCase("applyMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "申请人");
            } else if (parameterName.equalsIgnoreCase("reson")) {
                htmlTable(table, 0, 0, "FFFFFF", "原因");
            } else if (parameterName.equalsIgnoreCase("abnormalDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "异常描述");
            } else if (parameterName.equalsIgnoreCase("abnormal")) {
                htmlTable(table, 0, 0, "FFFFFF", "不正常");
            } else if (parameterName.equalsIgnoreCase("guaranteeRecordDesc")) {
                htmlTable(table, 0, 0, "FFFFFF", "保证记录描述");
            } else if (parameterName.equalsIgnoreCase("guaranteePrice")) {
                htmlTable(table, 0, 0, "FFFFFF", "保证价格");
            } else if (parameterName.equalsIgnoreCase("guaranteeImgUrl")) {
                htmlTable(table, 0, 0, "FFFFFF", "保证图片网址");
            } else if (parameterName.equalsIgnoreCase("inspectMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "检查人");
            } else if (parameterName.equalsIgnoreCase("taskTitle")) {
                htmlTable(table, 0, 0, "FFFFFF", "任务标题");
            } else if (parameterName.equalsIgnoreCase("creator")) {
                htmlTable(table, 0, 0, "FFFFFF", "创作者");
            } else if (parameterName.equalsIgnoreCase("completeMan")) {
                htmlTable(table, 0, 0, "FFFFFF", "完成者");
            } else if (parameterName.equalsIgnoreCase("assigneeNow")) {
                htmlTable(table, 0, 0, "FFFFFF", "立即受让人");
            } else if (parameterName.equalsIgnoreCase("taskNow")) {
                htmlTable(table, 0, 0, "FFFFFF", "现在的任务");
            } else if (parameterName.equalsIgnoreCase("finish")) {
                htmlTable(table, 0, 0, "FFFFFF", "结束");
            } else if (parameterName.equalsIgnoreCase("inspectId")) {
                htmlTable(table, 0, 0, "FFFFFF", "检查编号");
            } else if (parameterName.equalsIgnoreCase("parentId")) {
                htmlTable(table, 0, 0, "FFFFFF", "家长编号");
            } else if (parameterName.equalsIgnoreCase("depName")) {
                htmlTable(table, 0, 0, "FFFFFF", "部门名称");
            } else if (parameterName.equalsIgnoreCase("depId")) {
                htmlTable(table, 0, 0, "FFFFFF", "部门编号");
            } else if (parameterName.equalsIgnoreCase("areaRelId")) {
                htmlTable(table, 0, 0, "FFFFFF", "区域编号");
            } else if (parameterName.equalsIgnoreCase("menuId")) {
                htmlTable(table, 0, 0, "FFFFFF", "菜单ID");
            } else if (parameterName.equalsIgnoreCase("phone")) {
                htmlTable(table, 0, 0, "FFFFFF", "电话");
            } else if (parameterName.equalsIgnoreCase("resName")) {
                htmlTable(table, 0, 0, "FFFFFF", "资源名称");
            } else if (parameterName.equalsIgnoreCase("itemId")) {
                htmlTable(table, 0, 0, "FFFFFF", "项目编号");
            } else if (parameterName.equalsIgnoreCase("itemName")) {
                htmlTable(table, 0, 0, "FFFFFF", "项目名称");
            } else if (parameterName.equalsIgnoreCase("param")) {
                htmlTable(table, 0, 0, "FFFFFF", "参数");
            } else if (parameterName.equalsIgnoreCase("resName")) {
                htmlTable(table, 0, 0, "FFFFFF", "资源名称");
            } else if (parameterName.equalsIgnoreCase("station")) {
                htmlTable(table, 0, 0, "FFFFFF", "站");
            } else if (parameterName.equalsIgnoreCase("certifications")) {
                htmlTable(table, 0, 0, "FFFFFF", "认证书");
            } else if (parameterName.equalsIgnoreCase("fences")) {
                htmlTable(table, 0, 0, "FFFFFF", "围栏");
            } else if (parameterName.equalsIgnoreCase("fencesList")) {
                htmlTable(table, 0, 0, "FFFFFF", "围栏清单");
            } else if (parameterName.equalsIgnoreCase("session")) {
                htmlTable(table, 0, 0, "FFFFFF", "会话");
            } else if (parameterName.equalsIgnoreCase("resName")) {
                htmlTable(table, 0, 0, "FFFFFF", "资源名称");
            } else if (parameterName.equalsIgnoreCase("map")) {
                htmlTable(table, 0, 0, "FFFFFF", "映射");
            } else if (parameterName.equalsIgnoreCase("request")) {
                htmlTable(table, 0, 0, "FFFFFF", "请求");
            } else if (parameterName.equalsIgnoreCase("response")) {
                htmlTable(table, 0, 0, "FFFFFF", "响应");
            } else if (parameterName.equalsIgnoreCase("resName")) {
                htmlTable(table, 0, 0, "FFFFFF", "资源名称");
            } else {
                //{
                //    "type": "EN2ZH_CN",
                //    "errorCode": 0,
                //    "elapsedTime": 1,
                //    "translateResult": [
                //        [
                //            {
                //                "src": "small",
                //                "tgt": "小"
                //            }
                //        ]
                //    ]
                //}

// TODO Auto-generated method stub
                String[] ss = new String[100];
                int count = 0;
                ss[count] = "";
                for (int i = 0; i < parameterName.length(); i++) {
                    char a = parameterName.charAt(i);
                    String b = "" + a;
                    if (a > 64 && a < 91) { //大写字母的ASCLL码取值范围
                        count++;
                        ss[count] = b;
                    } else {
                        ss[count] = ss[count].concat(b);
                    }
                }
                for (int i = 0; i < ss.length; i++) {
                    System.out.println("ss[" + i + "]=" + ss[i]);
                }
                StringBuilder tgt = new StringBuilder();
                for (String s1 : ss) {
                    if (s1 != null) {
                        tgt.append(getTanslationString(s1));
                    } else {
                        break;
                    }
                }
                htmlTable(table, 0, 0, "FFFFFF", tgt.toString());
            }
        } else {
            htmlTable(table, 0, 0, "FFFFFF", "");
        }
    }

    private static String getTanslationString(String parameterName) {
        String s = translateMap.get(parameterName);
        if (StringUtils.isEmpty(s)) {
            JSONObject hget = HttpUtil.hget("http://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i=" + parameterName);
            JSONArray jsonArray = hget.getJSONArray("translateResult");
            s = jsonArray.getJSONArray(0).getJSONObject(0).getString("tgt");
            translateMap.put(parameterName, s);
        }
        //JSON.translateResult[0][0].tgt
        return s;
    }

    private static void htmlTable(StringBuilder table, int rowSpan, int cellSpan, String colorRgb, String text, String tdClass) {
        table.append("<td class='").append(tdClass).append("' style='background-color:#").append(colorRgb).append("'");
        if (cellSpan != 0) {
            table.append(" colspan=").append(cellSpan);
        } else {
            table.append(" width=").append(100);
        }
        if (rowSpan != 0) {
            table.append(" rowspan=").append(rowSpan);
        }

        table.append("'>").append(text)
                .append("</td>\n");

    }

    private static void htmlTable(StringBuilder table, int rowSpan, int cellSpan, String colorRgb, String text) {
        table.append("<td class='Structure' style='background-color:#").append(colorRgb).append("'");
        if (cellSpan != 0) {
            table.append(" colspan=").append(cellSpan).append(" width=").append(150 * cellSpan);
        } else {
            table.append(" width=").append(150);
        }
        if (rowSpan != 0) {
            table.append(" rowspan=").append(rowSpan);
        }

        table.append("'>").append(text)
                .append("</td>\n");

    }

}
