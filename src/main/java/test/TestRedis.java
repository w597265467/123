package test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestRedis {


	public static void main(String[] args){

		//这么些感觉也？这

		Jedis jedis = new Jedis("192.168.2.5", 6379);

		Set<String> keys = jedis.keys("CREDIT_APPLY_*");

		for (String key : keys) {

			try {
				String s = jedis.get(key);
				System.out.println(key + "======" +s);
			} catch (Exception e) {
				System.out.println(key);
			}
		}


	}
}
