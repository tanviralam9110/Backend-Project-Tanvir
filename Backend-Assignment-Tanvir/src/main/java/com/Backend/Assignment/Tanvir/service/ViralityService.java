package com.Backend.Assignment.Tanvir.service;

import com.Backend.Assignment.Tanvir.Util.RedisKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViralityService {
    @Autowired
    private final RedisTemplate<String, Object> redis;

    public void update(Long postId, String type) {
        int score = switch (type) {
            case "BOT" -> 1;
            case "LIKE" -> 20;
            case "COMMENT" -> 50;
            default -> 0;
        };
        redis.opsForValue().increment(RedisKeys.virality(postId), score);
    }
}
