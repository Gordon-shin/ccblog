package com.ccblog.common.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class JedisClientPool implements JedisClient {

    private static JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    private static void initialPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);
        config.setMaxIdle(8);
        config.setMaxWaitMillis(1);
        jedisPool = new JedisPool(config, "127.0.0.1", 6480, 5000);
    }
    @Override
    public String set(String key, String value) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    @Override
    public String get(String key) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    @Override
    public Boolean exists(String key) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Boolean result = jedis.exists(key);
        jedis.close();
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }

    @Override
    public Long ttl(String key) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    @Override
    public Long incr(String key) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Long result = jedis.hset(key, field, value);
        jedis.close();
        return result;
    }

    @Override
    public String hget(String key, String field) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        String result = jedis.hget(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Long result = jedis.hdel(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Boolean hexists(String key, String field) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Boolean result = jedis.hexists(key, field);
        jedis.close();
        return result;
    }

    @Override
    public List<String> hvals(String key) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        List<String> result = jedis.hvals(key);
        jedis.close();
        return result;
    }

    @Override
    public Long del(String key) {
        initialPool();
        Jedis jedis = jedisPool.getResource();
        jedis.auth("root");
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

}
