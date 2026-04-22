package com.Backend.Assignment.Tanvir.service;

import com.Backend.Assignment.Tanvir.Util.RedisKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final RedisTemplate<String, Object> redis;

    public void handle(Long userId, String message) {

        String cooldown = RedisKeys.notifCooldown(userId);

        if (redis.hasKey(cooldown)) {
            redis.opsForList().rightPush(RedisKeys.notifList(userId), message);
        } else {
            System.out.println("Push Notification Sent");
            redis.opsForValue().set(cooldown, "1", 15, TimeUnit.MINUTES);
        }
    }
}
