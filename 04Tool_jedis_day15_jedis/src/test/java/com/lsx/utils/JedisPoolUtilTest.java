package com.lsx.utils;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisPoolUtilTest {

    @Test
    /**
     * jedis pool 工具类
     */
    public void poolUtilTest() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("polled", "helloworld");
        jedis.close();
    }
}
