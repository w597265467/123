package test;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        String s = "集中器状态管理功能测试通过\n" +
                "报表统计功能测试通过\n" +
                "信息发布-策略管理功能测试通过\n" +
                "信息发布--素材管理功能测试通过\n" +
                "BIM功能测试通过\n" +
                "用户登录功能测试通过\n" +
                "系统设置功能测试通过\n" +
                "首页功能测试通过\n" +
                "视频监控功能测试通过\n" +
                "集中器管理功能测试通过\n" +
                "省市区路功能测试通过\n" +
                "信息发布-节目管理功能测试通过\n" +
                "环境检测-传感器列表功能测试通过\n" +
                "智能开关功能测试通过\n" +
                "信息发布——显示屏管理功能测试通过\n" +
                "GIS地图页面功能测试通过\n" +
                "单灯调光页面功能测试通过\n" +
                "集中器组功能测试通过\n" +
                "Wifi功能测试通过\n" +
                "环境检测-环境监测列表功能测试通过\n" +
                "紧急求助功能测试通过\n" +
                "路灯管理功能测试通过";
        String[] split = s.split("\n");
        Arrays.sort(split);
        for (String s1 : split) {
            System.out.println(s1);
        }
    }
}
