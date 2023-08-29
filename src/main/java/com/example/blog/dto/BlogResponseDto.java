package com.example.blog.dto;

import com.example.blog.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogResponseDto {
    private Long id;
    private String title;
    private String username;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public BlogResponseDto(Blog blog) {
        this.id = blog.getId();
        this.username = blog.getUsername();
        this.contents = blog.getContents();
        this.title = blog.getTitle();
        this.createAt = blog.getCreatedAt();
        this.modifiedAt = blog.getModifiedAt();
    }
}
