package com.Backend.Assignment.Tanvir.controller;

import com.Backend.Assignment.Tanvir.entity.Post;
import com.Backend.Assignment.Tanvir.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping
    public Post create(@RequestBody Post post) {
        return service.create(post);
    }
}
