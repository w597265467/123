package test2;

import java.util.Arrays;

public class RequestToMethodItem {
    public String controllerName;
    public String methodName;
    public String requestType;
    public String requestUrl;
    public Class<?>[] methodParamTypes;
    public String[] parameterNames;
    public String returnJson;

    public RequestToMethodItem(String requestUrl, String requestType, String controllerName, String requestMethodName,
                               Class<?>[] methodParamTypes, String[] parameterNames) {
        this.requestUrl = requestUrl;
        this.requestType = requestType;
        this.controllerName = controllerName;
        this.methodName = requestMethodName;
        this.methodParamTypes = methodParamTypes;
        this.parameterNames = parameterNames;
    }

    @Override
    public String toString() {
        return "请求接口:{" +
                "所属类:'" + controllerName + '\'' +
                ", 方法名:'" + methodName + '\'' +
                ", 请求类型:'" + requestType + '\'' +
                ", 访问地址:/iot-oms'" + requestUrl + '\'' +
                ", 参数列表:" + Arrays.toString(methodParamTypes) +
                ", 参数名称:" + Arrays.toString(parameterNames) +
                '}';
    }
}