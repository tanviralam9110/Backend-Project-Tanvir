package com.Backend.Assignment.Tanvir.repository;

import com.Backend.Assignment.Tanvir.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
