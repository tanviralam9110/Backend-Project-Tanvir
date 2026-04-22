package com.Backend.Assignment.Tanvir.service;

import com.Backend.Assignment.Tanvir.Util.RedisKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class GuardrailService {

    private final RedisTemplate<String, Object> redis;

    public void checkBotLimit(Long postId) {
        String key = RedisKeys.botCount(postId);
        Long count = redis.opsForValue().increment(key);

        if (count > 100) {
            throw new RuntimeException("429 Too Many Requests");
        }
    }

    public void checkDepth(int depth) {
        if (depth > 20) {
            throw new RuntimeException("Depth limit exceeded");
        }
    }

    public void checkCooldown(Long botId, Long userId) {
        String key = RedisKeys.cooldown(botId, userId);

        if (redis.hasKey(key)) {
            throw new RuntimeException("Cooldown active");
        }
        redis.opsForValue().set(key, "1", 10, TimeUnit.MINUTES);
    }
}
