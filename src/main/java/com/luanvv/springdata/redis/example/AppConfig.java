package com.luanvv.springdata.redis.example;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Application context configuration setting up {@link RedisConnectionFactory} and {@link RedisTemplate} according to
 * {@link ClusterConfigurationProperties}.
 *
 * @author Christoph Strobl
 */
@EnableAutoConfiguration
public class AppConfig {

}
