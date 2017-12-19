package com.dubeniot.dao;



/**
 *
 *<P>Title：JedisClient<P>
 * @author BUB-4
 *@data 2017年4月27日上午8:21:48
 */
public interface JedisClient {
	
	String get(String key);
	String set(String key,String value);
	long hset(String hkey,String key,String value);
	String hget(String hkey,String key);
	long incr(String key);
	long expire(String key,int second);
	long ttl(String key);
	long del(String key);
	long hdel(String hkey,String key);
}
