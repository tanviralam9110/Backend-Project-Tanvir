package com.Backend.Assignment.Tanvir.service;

import com.Backend.Assignment.Tanvir.entity.Post;
import com.Backend.Assignment.Tanvir.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repo;

    public Post create(Post post) {
        return repo.save(post);
    }
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void testRedis() {
        try {
            redisTemplate.opsForValue().set("test", "hello");
            System.out.println("Redis value: " + redisTemplate.opsForValue().get("test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

