package test;

public class TestContains {
    public static void main(String[] arg){
        String str = "失败6229912017122617114580274239";
        System.out.println(str.contains("失败"));
        System.out.println(str.contains("6229912017122617114580274239"));
        System.out.println(str.contains("失败")&&str.contains("6229912017122617114580274239"));
    }

}
