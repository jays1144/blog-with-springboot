package com.example.blog.dto;

import lombok.Getter;

@Getter
public class BlogRequestDto {
    private String username;
    private String title;
    private String contents;
    private String pw;
}
