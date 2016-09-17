package me.voler.classical.register_login_logout.register;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    public static List<String> retrieve(String uid) {
        List<String> list = new ArrayList<String>();
        @SuppressWarnings("resource")
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        Jedis jedis = null;

        try {
            jedis = pool.getResource();

            list = jedis.hmget(uid, "inTime", "code");

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return list;
    }

    public static void register(String uid, HashMap<String, String> map) {

        @SuppressWarnings("resource")
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        Jedis jedis = null;

        try {
            jedis = pool.getResource();
            jedis.hmset(uid, map);

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
