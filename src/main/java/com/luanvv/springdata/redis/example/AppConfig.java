package com.luanvv.springdata.redis.example;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
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

  @Bean
  RedisConnectionFactory connectionFactory(
      @Value("${spring.redis.cluster.nodes}") List<String> nodes
  ) {
    return new LettuceConnectionFactory(new RedisClusterConfiguration(nodes));
  }
}
