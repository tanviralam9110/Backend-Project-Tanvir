package com.Backend.Assignment.Tanvir.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private Long authorId;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();
}
