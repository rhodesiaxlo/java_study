package com.lsx;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.sound.midi.Soundbank;
import java.util.Date;
import java.util.Set;

public class JedisTest {


    @Test
    public  void stringTest() {
        // 建立连接
        Jedis jedis = new Jedis("192.168.1.161", 6379);

        jedis.set("zhangsan", "success");

        System.out.println(jedis.get("zhangsan"));

        jedis.close();

    }

    @Test
    public void stringTest1() {
        // string 的常用操作
        // type
        // keys
        // expire
        // ttl
        //

        Jedis jedis = new Jedis("192.168.1.161", 6379);

        String setreturn = jedis.set("javastring", "zhangsan");
        System.out.println(" string set retur " +setreturn);
//        String setexreturn = jedis.setex("javastring", 20, "20-second-lifespan");
//        System.out.println("set ex return " + setexreturn);
        Long setnxreturn = jedis.setnx("javastring", "i-have-been-updated");
        System.out.println("set nx return " + setnxreturn);

        Long ttl = jedis.ttl("javastring");
        System.out.println("ttl of javastring is " + ttl);
        jedis.close();
    }

    @Test
    /**
     * 哈希操作
     * hget
     * hset
     * hmset
     */
    public void hashTest() {
        Jedis jedis = new Jedis("192.168.1.161", 6379);
        jedis.hset("javahash", "name", "zhangsan");
        jedis.hset("javahash", "age", "20");
        jedis.hset("javahash", "birthday", new Date().toString());

        System.out.println(" java hast name " + jedis.hget("javahash", "name"));
        System.out.println(" java hast age " + jedis.hget("javahash", "age"));
        System.out.println(" java hast birthday " + jedis.hget("javahash", "birthday"));

        System.out.println(" java hash get all " + jedis.hgetAll("javahash"));

        jedis.hexists("javahash", "name");
        System.out.println(" check if key exist " + jedis.exists("javahash"));
        System.out.println("check if filed exist in " +jedis.hexists("javahash", "name"));
        System.out.println("check hash lenght" + jedis.hlen("javahash"));
        System.out.println("check hash lenght" + jedis.hlen("javahash"));
        jedis.close();
    }
    
    @Test
    /**
     * 列表操作
     * 
     * 顺序
     * 索引
     * 
     */
    public void listTest() {


        Jedis jedis = new Jedis("192.168.1.161", 6379);

        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "left-1");
        jedis.lpush("javalist", "left-2");
        jedis.lpush("javalist", "left-3");
        
        jedis.rpush("javalist", "right-1");
        jedis.rpush("javalist", "right-2");
        jedis.rpush("javalist", "right-3");


        System.out.println(" list " +jedis.lrange("javalist", 0, -1));
        
        // 弹出
        String lpopval = jedis.lpop("javalist");
        String rpopval = jedis.rpop("javalist");
        System.out.println(" left pop val = " +lpopval +" right pop val = " + rpopval);
        
        // 计算长度和是否存在
        jedis.llen("javalist");
        Long numberofelementremoved = jedis.lrem("javalist", 10, "hello");
        System.out.println(" remove right 1 from javalisth , result number is " + numberofelementremoved );
        System.out.println(" list afater remove " +jedis.lrange("javalist", 0, -1));

        // 截取操作

        jedis.close();
    }

    @Test
    /**
     * 演示 list 删除操作
     */
    public void listRemoveTest() {
        Jedis jedis = new Jedis("192.168.1.161", 6379);

        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "world");
        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "world");
        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "world");
        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "world");
        jedis.lpush("javalist", "hello");
        jedis.lpush("javalist", "world");

        Long lrem = jedis.lrem("javalist", 10, "hello");

        System.out.println(" remove count " + lrem + " list remain " + jedis.lrange("javalist", 0, -1));



        jedis.close();
    }

    @Test
    /**
     * set 操作
     */
    public void setTest() {
        // 无需集合
        // sget
        // sget
        // smembers
        // sismember
        //

        // sorted set
        // 有序，和索引

        //
        Jedis jedis = new Jedis("192.168.1.161", 6379);


        jedis.zadd("javazset", 1988, "lushixin");
        jedis.zadd("javazset", 1979, "raozhangbiao");
        jedis.zadd("javazset", 2000, "raojiayi");

        Set<String> jzset = jedis.zrange("javazset", 0, -1);
        System.out.println(" sorted set result " +jzset);

        Set<String> jzset2 = jedis.zrangeByScore("javazset", 0, 10000);
        System.out.println(" sorted set 2 result = " + jzset2);
        jedis.close();
    }

    @Test
    /**
     *  jedis 连接池对象
     */
    public void jedisPoolTest() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxIdle(50);

        JedisPool jedisPool = new JedisPool("192.168.1.161", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("var-created-by-jedis-pool", "1");
        jedis.close();

    }
}
