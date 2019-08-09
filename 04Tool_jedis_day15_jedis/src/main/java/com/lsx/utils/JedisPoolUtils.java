package com.lsx.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * jedis 工具类
 */
public class JedisPoolUtils {
    private static JedisPool pool;


    static {
        // 读取 property 生成 pool
        Properties prop = new Properties();
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.prop");
        try {
            prop.load(is);

            JedisPoolConfig config = new JedisPoolConfig();

            // 根据 property 设置config

            // 生成 jedispool
            pool = new JedisPool(config, prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JedisPool getPool() {
        return pool;
    }

    public static Jedis getJedis() {
        if(null == pool) {
            return null;
        } else {
            return pool.getResource();
        }
    }

}
