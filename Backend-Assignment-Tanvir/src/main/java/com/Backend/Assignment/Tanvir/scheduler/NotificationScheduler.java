package com.Backend.Assignment.Tanvir.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class NotificationScheduler {
    private final RedisTemplate<String, Object> redis;

    @Scheduled(fixedRate = 300000)
    public void process() {

        Set<String> keys = redis.keys("user:*:pending_notifs");

        if (keys == null) return;

        for (String key : keys) {

            List<Object> list = redis.opsForList().range(key, 0, -1);

            if (list == null || list.isEmpty()) continue;

            System.out.println("Summary Notification: " + list.size());

            redis.delete(key);
        }
    }
}
