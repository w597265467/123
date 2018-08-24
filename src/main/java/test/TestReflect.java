package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import test.vo.testVo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReflect {
	protected String priValue;
	public static void main(String[] arg) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		List list = new ArrayList();
		list.add(new testVo("1","1"));
		list.add(new testVo("2","1"));
		list.add(new testVo("3","1"));
		list.add(new testVo("4","1"));
		test(list);
//		Son son = new Son();

	}
	public static void test(List a) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		List list = new ArrayList();
		for (Object o : a) {
			Map<String,Object> map = new HashMap<>();
			Class<?> aClass = o.getClass();
			Field[] fields = aClass.getFields();
			for (Field field : fields) {
				String name = field.getName();
				Method method = aClass.getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length()), null);
				Object invoke = method.invoke(o);
				map.put(name,invoke);
			}
			list.add(map);
		}
		System.out.println(JSONArray.toJSONString(list));
//		Class<?> superclass = son.getClass().getSuperclass();
//		Field[] declaredFields = superclass.getDeclaredFields();
//		for (Field declaredField : declaredFields) {
//			System.out.println(declaredField.getName());
//		}
//		System.out.println("========");
//		Field[] fields = superclass.getFields();
//		for (Field field : fields) {
//			System.out.println(field.getName());
//		}
	}
}
class Son extends TestReflect{

}