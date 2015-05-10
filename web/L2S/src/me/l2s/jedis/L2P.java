package me.l2s.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class L2P {

	public static String mapPath(String[] svalues, String lvalue) {
		String suri = "";
		@SuppressWarnings("resource")
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
		Jedis jedis = null;

		try {
			jedis = pool.getResource();
			
			// 若给定的长链接已经转换，直接返回已转换的结果
			if (jedis.hget("l2s", lvalue) != null)
				suri = jedis.hget("l2s", lvalue);
			else {
				//对于得到的4个字符串
				//逐个检查是否重复
				//不重复，将转换结果与长链接相互关联
				//退出检查
				for (int i = 0; i < svalues.length; i++) {
					if (jedis.hget("l2s", svalues[i]) == null) {
						jedis.hset("l2s", svalues[i], lvalue);
						jedis.hset("l2s", lvalue, svalues[i]);
						suri = jedis.hget("l2s", lvalue);
						break;
					}
				}
			}

		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

		return suri;
	}

}
