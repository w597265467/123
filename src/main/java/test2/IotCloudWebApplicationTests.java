package test2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class IotCloudWebApplicationTests {

    @Resource
    ApplicationContext appContext;



    @Test
    public void getAllControllerMathed() throws IOException {
        //请求url和处理方法的映射
        List<RequestToMethodItem> requestToMethodItemList = new ArrayList<RequestToMethodItem>();
        //获取所有的RequestMapping
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext,
                HandlerMapping.class, true, false);

        for (HandlerMapping handlerMapping : allRequestMappings.values()) {
            //本项目只需要RequestMappingHandlerMapping中的URL映射
            if (handlerMapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
                    RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                    HandlerMethod mappingInfoValue = requestMappingInfoHandlerMethodEntry.getValue();
                    RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();
                    RequestMethod first = first(methodCondition.getMethods());
                    String requestType = null;
                    if (first != null) {
                        requestType = first.name();
                    }
                    PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                    String requestUrl = first(patternsCondition.getPatterns());

                    String controllerName = mappingInfoValue.getBeanType().toString();
                    Method method = mappingInfoValue.getMethod();
                    String requestMethodName = method.getName();
                    Class<?>[] methodParamTypes = method.getParameterTypes();
                    DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();
                    String[] parameterNames = discoverer.getParameterNames(method);
                    boolean isAnnotationRequestBody = isAnnotationRequestBody(methodParamTypes);
                    if (isAnnotationRequestBody){
                        requestType = "POST";
                    }
                    InnerData innerData = new InnerData(methodParamTypes, parameterNames).invoke();
                    methodParamTypes = innerData.getMethodParamTypes();
                    parameterNames = innerData.getParameterNames();

                    RequestToMethodItem item = new RequestToMethodItem(requestUrl, requestType, controllerName, requestMethodName,
                            methodParamTypes, parameterNames);
                    requestToMethodItemList.add(item);
                }
                break;
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                "D:\\projectsvn\\iot-cloud-v3\\iot-cloud-web\\src\\test\\java\\com\\rz\\iot\\web\\1.txt")));
        for (RequestToMethodItem requestToMethodItem : requestToMethodItemList) {
            String s = JSONObject.toJSONString(requestToMethodItem);
            JSONObject.parseObject(s, RequestToMethodItem.class);
            bufferedWriter.write(s);
            bufferedWriter.write("\n");
            System.out.println(requestToMethodItem);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private boolean isAnnotationRequestBody(Class<?>[] methodParamTypes) {
        for (Class<?> methodParamType : methodParamTypes) {
            RequestBody annotation = methodParamType.getAnnotation(RequestBody.class);
            if (annotation != null){
                return true;
            }
        }

        return false;
    }

    public static <T> T first(Set<T> T) {
        for (T t : T) {
            return t;
        }
        return null;
    }

    private class InnerData {
        private Class<?>[] methodParamTypes;
        private String[] parameterNames;

        public InnerData(Class<?>[] methodParamTypes, String[] parameterNames) {
            this.methodParamTypes = methodParamTypes;
            this.parameterNames = parameterNames;
        }

        public Class<?>[] getMethodParamTypes() {
            return methodParamTypes;
        }

        public String[] getParameterNames() {
            return parameterNames;
        }

        public InnerData invoke() {
            List<String> strings = new ArrayList<>();
            List<Class> classList = new ArrayList<>();
            for (int i = 0; i < methodParamTypes.length; i++) {
                if (methodParamTypes[i].toString().contains("model")) {
                    Field[] fields = methodParamTypes[i].getDeclaredFields();
                    for (Field field : fields) {
                        if (field.getType().toString().contains("model")) {
                            Field[] fields2 = field.getType().getDeclaredFields();
                            for (Field field1 : fields2) {
                                strings.add(field1.getName());
                                classList.add(field1.getType());
                            }
                        }
                        strings.add(field.getName());
                        classList.add(field.getType());
                    }
                } else {
                    strings.add(parameterNames[i]);
                    classList.add(methodParamTypes[i]);
                }
            }
            parameterNames = new String[strings.size()];
            for (int i = 0; i < strings.size(); i++) {
                parameterNames[i] = strings.get(i);
            }
            methodParamTypes = new Class[classList.size()];
            for (int i = 0; i < classList.size(); i++) {
                methodParamTypes[i] = classList.get(i);
            }
            return this;
        }
    }
}
