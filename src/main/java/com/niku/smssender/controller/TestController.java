package com.niku.smssender.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final StringRedisTemplate redisTemplate;

    public TestController(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/test/redis")
    public String testRedis() {

        redisTemplate.opsForValue().set("hello", "world");

        return redisTemplate.opsForValue().get("hello");
    }
}