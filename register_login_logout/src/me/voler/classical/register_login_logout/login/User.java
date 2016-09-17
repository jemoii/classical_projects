package me.voler.classical.register_login_logout.login;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class User {
    public static boolean retrieve(String uid, String key) {
        boolean isLogin = false;
        @SuppressWarnings("resource")
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        Jedis jedis = null;

        try {
            jedis = pool.getResource();
            List<String> list = jedis.hmget(uid, "key");
            if (key.equals(list.get(0)))
                isLogin = true;

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return isLogin;
    }

}
