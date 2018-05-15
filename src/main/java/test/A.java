package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A {
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.2.7:3306/finance?characterEncoding=utf-8",
					"jft",
					"3edcvBHU8");
			String sql = "select * from order_gift_config ";
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				String orderMallId = resultSet.getString("order_mall_id");
				String skuId = resultSet.getString("sku_id");
				String contractPeriod = resultSet.getString("contract_period");
				String gift_name = resultSet.getString("gift_name");
				String gift_price = resultSet.getString("gift_price");
				String return_cycle = resultSet.getString("return_cycle");
				String status = resultSet.getString("status");

				String sql2 = "insert into credit_promotion_config (order_mall_id,sku_id,contract_period,gift_name,return_cycle,status,gift_price,gift_type) values(?,?,?,?,?,?,?,1)";
				PreparedStatement pstm2 = connection.prepareStatement(sql2);
				pstm2.setString(1,orderMallId);
				pstm2.setString(2,skuId);
				pstm2.setString(3,contractPeriod);
				pstm2.setString(4,gift_name);
				pstm2.setString(5,return_cycle);
				pstm2.setString(6,status);
				pstm2.setString(7,gift_price);
				pstm2.execute();




/*
CREATE TABLE `order_gift_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_mall_id` int(11) DEFAULT NULL COMMENT '订单所属商城(天猫:100，迪信通:200)',
  `item_id` varchar(100) DEFAULT NULL COMMENT 'item_id',
  `sku_id` varchar(100) DEFAULT NULL COMMENT 'sku_id',
  `contract_period` int(11) DEFAULT '999999' COMMENT '套餐分期',
  `gift_name` varchar(200) DEFAULT NULL COMMENT '赠品名称',
  `gift_price` int(11) DEFAULT NULL COMMENT '赠品价格,分',
  `return_cycle` int(11) DEFAULT NULL COMMENT '返还周期',
  `status` int(11) DEFAULT '0' COMMENT '1,有效,0，失效',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=542 DEFAULT CHARSET=utf8 COMMENT='商品赠品配置表'


  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_mall_id` int(11) DEFAULT NULL COMMENT '订单所属商城(天猫:100，迪信通:200)',
  `item_id` varchar(100) DEFAULT NULL COMMENT 'item_id',
  `sku_id` varchar(100) DEFAULT NULL COMMENT 'sku_id',
  `contract_period` int(11) DEFAULT '999999' COMMENT '套餐分期',
  `gift_name` varchar(200) DEFAULT NULL COMMENT '赠品名称',
  `gift_type` int(11) DEFAULT NULL COMMENT '礼品类型,1:石油卡:2:天猫券',
  `gift_price` int(11) DEFAULT NULL COMMENT '赠品价格,分',
  `return_cycle` int(11) DEFAULT NULL COMMENT '返还周期',
  `status` int(11) DEFAULT '0' COMMENT '1,有效,0，失效',
  `start_time` datetime DEFAULT NULL COMMENT '活动开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '活动结束时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 */
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
