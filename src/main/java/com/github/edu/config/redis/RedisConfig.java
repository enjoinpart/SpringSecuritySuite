package com.github.edu.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @author ：liming
 * @date ：2019/7/18 17:07
 * @description：
 */

@Configuration
public class RedisConfig   {

    @Autowired
    private RedisPorperties redisPorperties;

    @Bean
    @SuppressWarnings("all")
    public  RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setEnableTransactionSupport(true);
        return  redisTemplate;
    }


    @Bean
    public JedisPool JedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisPorperties.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisPorperties.getPoolMaxWait() * 1000);
        JedisPool jp = new JedisPool(poolConfig, redisPorperties.getHost(), redisPorperties.getPort(),
                redisPorperties.getTimeout()*1000, redisPorperties.getPassword(), 0);
        return jp;
    }



}
