package com.luanvv.springdata.redis.example;

import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

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
    return new LettuceConnectionFactory(new RedisClusterConfiguration(clusterNodes));
  }
}
