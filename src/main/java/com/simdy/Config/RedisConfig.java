package com.simdy.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/28 22:01
 * @Version 1.0
 **/
@Configuration
public class RedisConfig {

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        return new JedisPool(jedisPoolConfig,
                jedisConnectionFactory.getHostName(),jedisConnectionFactory.getPort(),
                jedisConnectionFactory.getTimeout(),jedisConnectionFactory.getPassword());
    }

}
