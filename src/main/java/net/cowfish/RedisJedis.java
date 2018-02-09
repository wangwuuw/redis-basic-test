package net.cowfish;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @classDesc： 功能描述：（通过Jedis去操作redis数据库）
 * @author：王武
 * @createTime 2018/2/8
 * @verson: v1.0
 * @copyright: 上海江豚教育科技有限公司
 * @qq:834667820
 */
public class RedisJedis {
    private static Jedis jedis=null;

    public static void main(String[] args) {
        jedis=new Jedis("192.168.229.128",6379);
        jedis.auth("123456");
//        		setString();
//		setMap();
		setList();
//        setSet();
    }
    public static void  setString(){
        jedis.set("name", "zhuyuanzhang");
        System.out.println("添加成功..");
    }
    public static void setMap(){
        Map<String, String> map= new HashMap<String, String>();
        map.put("lishiming", "25000");
        map.put("tanglingfeng", "28000");
        map.put("outingting", "28000");
        jedis.hmset("xinzi", map);
        System.out.println("添加成功..");
    }
    public static void setList(){
        jedis.lpush("liubang", "20000");
        jedis.lpush("xiangyu", "25000");
    }
    public static void setSet(){
        jedis.sadd("chengjisihan","12000");
        jedis.sadd("napolun","18000");
        jedis.sadd("kaisa","25000");
    }
}
