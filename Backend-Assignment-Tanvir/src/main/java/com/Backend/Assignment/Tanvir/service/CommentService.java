package com.Backend.Assignment.Tanvir.service;

import com.Backend.Assignment.Tanvir.entity.Comment;
import com.Backend.Assignment.Tanvir.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository repo;
    private final GuardrailService guard;
    private final ViralityService virality;
    private final NotificationService notify;

    public Comment add(Long postId, Comment c, boolean isBot) {

        c.setPostId(postId);

        guard.checkDepth(c.getDepthLevel());

        if (isBot) {
            guard.checkBotLimit(postId);
            guard.checkCooldown(c.getAuthorId(), 1L);
            virality.update(postId, "BOT");
        } else {
            virality.update(postId, "COMMENT");
        }

        notify.handle(1L, "New interaction");

        return repo.save(c);
    }
}
