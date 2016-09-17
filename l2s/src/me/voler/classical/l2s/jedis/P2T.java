package me.voler.classical.l2s.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class P2T {
    public static String check(String path) {
        String direct = null;
        @SuppressWarnings("resource")
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        Jedis jedis = null;

        try {
            jedis = pool.getResource();

            //重定向时，用于判定短链接是否有效
            direct = jedis.hget("l2s", path);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return direct;
    }
}
