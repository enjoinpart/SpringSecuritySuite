package com.github.edu.config.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author ：liming
 * @date ：2019/7/22 14:47
 * @description：
 */
@Component
@Data
public class RedisPorperties {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;//秒
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.pool.max-total}")
    private int poolMaxTotal;
    @Value("${spring.redis.pool.max-idle}")
    private int poolMaxIdle;
    @Value("${spring.redis.pool.max-wait}")
    private int poolMaxWait;//秒

}
