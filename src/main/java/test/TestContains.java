package test;

public class TestContains {
    public static void main(String[] arg){
        String str = "16:32:10.429 [taskExecutor-20] DEBUG cn.jf180.finance.service.dxt.DxtService - =============>天猫退款订单[3]导入失败:orderId:6229912017122617114580274239,tmallOrderId:107090127306834495,天猫系统认为不是【用户退款成功】的订单.";
        System.out.println(str.contains("失败"));
        System.out.println(str.contains("6229912017122617114580274239"));
        System.out.println(str.contains("失败")&&str.contains("6229912017122617114580274239"));
    }

}
