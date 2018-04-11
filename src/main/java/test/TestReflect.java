package test;

import java.lang.reflect.Field;

public class TestReflect {
	protected String priValue;
	public static void main(String[] arg) throws NoSuchFieldException {

		Son son = new Son();
		Class<?> superclass = son.getClass().getSuperclass();
		Field[] declaredFields = superclass.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			System.out.println(declaredField.getName());
		}
		System.out.println("========");
		Field[] fields = superclass.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}

}

class Son extends TestReflect{

}