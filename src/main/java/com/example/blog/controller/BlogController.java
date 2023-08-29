package com.example.blog.controller;


import com.example.blog.dto.BlogRequestDto;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @PostMapping("/blogs")
    public BlogResponseDto create(@RequestBody BlogRequestDto requestDto){
        return blogService.createBlog(requestDto);
    }

    @GetMapping("/blogs")
    public List<BlogResponseDto> getBlogs(){
        return blogService.getBlogs();
    }

    @GetMapping("/blogs/contents")
    public List<BlogResponseDto> getBlogsByKeyword(@RequestParam String keyword){
        return blogService.getBlogsByKeyword(keyword);
    }

    @PutMapping("/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        System.out.println("여기는 controller : " + requestDto.getUsername());
        return blogService.updateBlogs(id,requestDto);
    }

    @DeleteMapping("/blogs/{id}")
    public String deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto){
        System.out.println("여기는 Controller : " + id + requestDto.getPw());
        return blogService.deleteBlog(id,requestDto.getPw());
    }
}
