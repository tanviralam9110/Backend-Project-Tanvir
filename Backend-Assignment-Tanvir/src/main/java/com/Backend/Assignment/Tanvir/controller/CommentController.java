package com.Backend.Assignment.Tanvir.controller;

import com.Backend.Assignment.Tanvir.entity.Comment;
import com.Backend.Assignment.Tanvir.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @PostMapping("/api/posts/{postId}/comments")
    public Comment add(@PathVariable Long postId, @RequestBody Comment comment,
                       @RequestParam boolean isBot) {

        return service.add(postId, comment, isBot);
    }
}
