package com.tobilko.english.configuration.redis;

import com.tobilko.english.configuration.redis.listener.GlobalRedisMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Created by Andrew Tobilko on 9/5/17.
 */
//@Configuration
@EnableRedisRepositories
public class GlobalRedisConfiguration {

    @Bean
    public RedisMessageListenerContainer getConfiguredRedisMessageListenerContainer(
            RedisConnectionFactory factory,
            MessageListenerAdapter adapter
    ) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();

        container.setConnectionFactory(factory);
        container.addMessageListener(adapter, new PatternTopic("main"));

        return container;
    }

    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(GlobalRedisMessageListener listener) {
        return new MessageListenerAdapter(listener, "receiveMessageFromRedis");
    }

    @Bean
    public JedisConnectionFactory getRedisConnectionFactory(RedisStandaloneConfiguration configuration) {
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

    @Bean
    public RedisStandaloneConfiguration getRedisStandaloneConfiguration() {
        return new RedisStandaloneConfiguration();
    }

}
