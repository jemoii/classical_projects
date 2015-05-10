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

			if (jedis.hget("l2s", lvalue) != null)
				suri = jedis.hget("l2s", lvalue);
			else {
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
