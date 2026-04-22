package com.Backend.Assignment.Tanvir.repository;

import com.Backend.Assignment.Tanvir.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
