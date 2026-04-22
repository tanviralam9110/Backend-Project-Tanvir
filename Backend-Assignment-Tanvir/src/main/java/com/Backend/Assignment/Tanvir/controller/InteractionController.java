package com.Backend.Assignment.Tanvir.controller;

import com.Backend.Assignment.Tanvir.service.ViralityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InteractionController {
    private final RedisTemplate<String, Object> redis;

    @PostMapping("/api/posts/{id}/like")
    public String like(@PathVariable Long id) {

        redis.opsForValue().increment("post:" + id + ":virality_score", 20);
        return "Liked";
    }
}
