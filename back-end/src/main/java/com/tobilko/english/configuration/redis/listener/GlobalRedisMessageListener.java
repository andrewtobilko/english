package com.tobilko.english.configuration.redis.listener;

import org.springframework.stereotype.Component;

/**
 * Created by Andrew Tobilko on 9/5/17.
 */
@Component
public class GlobalRedisMessageListener {

    public void receiveMessageFromRedis(String message) {
        System.out.println("redis message > " + message);
    }

}
