package test;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestJedisTTL {
	private static final int port = 6379;


	public static void main(String[] arg) {
		Jedis jedis = new Jedis("192.168.2.5",port);
		Set<String> keys = jedis.keys("ali_trade*");
		for (String key : keys) {
			Long ttl = jedis.ttl(key);
			long time = 86400;
			long jian = 0;
			if (ttl>0){
				jian = time - ttl;
			}else {
				jian = Long.MAX_VALUE;
			}
			if (jian<1000){
				System.out.println("key:"+key+"\tTTL:"+ttl+"\tjian:"+jian);
			}
		}
	}
}
