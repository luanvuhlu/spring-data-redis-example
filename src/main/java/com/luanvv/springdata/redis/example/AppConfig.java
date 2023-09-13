package com.luanvv.springdata.redis.example;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Application context configuration setting up {@link RedisConnectionFactory} and {@link RedisTemplate} according to
 * {@link ClusterConfigurationProperties}.
 *
 * @author Christoph Strobl
 */
@EnableAutoConfiguration
@Configuration
public class AppConfig {

  List<String> clusterNodes = List.of("node1-redis-dev.com:6379");

  @Bean
  RedisConnectionFactory connectionFactory() {
    return new JedisConnectionFactory(new RedisClusterConfiguration(clusterNodes));
  }

  @Bean
  RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {

    // just used StringRedisTemplate for simplicity here.
    return new StringRedisTemplate(factory);
  }
}
