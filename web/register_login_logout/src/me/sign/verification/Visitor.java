package me.sign.verification;

import java.util.HashMap;
import java.util.List;

import me.sign.people.Person;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Visitor {
	public static boolean isNew(String uid) {
		boolean isNew = false;
		@SuppressWarnings("resource")
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
		Jedis jedis = null;

		try {
			jedis = pool.getResource();
			//成功注册的条件是数据库中保存完整账号信息
			//未验证邮箱认为注册失败
			List<String> list = jedis.hmget(uid, "key");
			if (list.get(0) == null)
				isNew = true;

		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

		return isNew;
	}

	public static void insert(Person p) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", p.getCode());
		map.put("inTime", String.valueOf(p.getInTime()));
		// map.put("key", p.getKey());

		@SuppressWarnings("resource")
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
		Jedis jedis = null;

		try {
			jedis = pool.getResource();
			jedis.hmset(p.getUid(), map);

		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}
}
