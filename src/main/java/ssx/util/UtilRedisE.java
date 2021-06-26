package ssx.util;

import redis.clients.jedis.Jedis;

public class UtilRedisE {
    public static String saddSet(String args) {
//        Client client = new Client("192.168.192.129",6379);
//        client.auth("1");
//        client.select(9);
        Jedis jedis = new Jedis("192.168.192.129", 6379);
        jedis.auth("1");

        Long result = jedis.sadd("MiDengDemo", args);//返回值为0代表添加失败因为集合已存在次成员。返回1代表OK
        if (result==0){
            return "N";
        }else if (result==1){
            return "Y";
        }else {
            return "N";
        }

    }
    public static String sremSet(String args) {
        Jedis jedis = new Jedis("192.168.192.129", 6379);
        jedis.auth("1");

        Long result = jedis.srem("MiDengDemo", args);//返回值为0代表添加失败因为集合已存在次成员。返回1代表OK
        if (result == 0) {
            return "N";
        } else if (result == 1) {
            return "Y";
        } else {
            return "N";
        }
    }
}
