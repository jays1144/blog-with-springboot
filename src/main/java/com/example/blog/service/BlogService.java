package com.example.blog.service;

import com.example.blog.dto.BlogRequestDto;
import com.example.blog.dto.BlogResponseDto;
import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogResponseDto createBlog(BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);

        Blog saveBlog = blogRepository.save(blog);

        BlogResponseDto blogResponseDto = new BlogResponseDto(saveBlog);

        return blogResponseDto;
    }

    public List<BlogResponseDto> getBlogs() {
        return blogRepository.findAllByOrderByCreatedAtDesc().stream().map(BlogResponseDto::new).toList();
    }

    public List<BlogResponseDto> getBlogsByKeyword(String keyword) {
        return blogRepository.findAllByContentsContainsOrderByModifiedAtDesc(keyword).stream().map(BlogResponseDto::new).toList();
    }


    @Transactional
    public Long updateBlogs(Long id, BlogRequestDto requestDto) {
        Blog blog = findBlog(id,requestDto.getPw());
        System.out.println("여기는 Service부분 : " + blog.getUsername());
        blog.update(requestDto);
        return id;
    }

    public String deleteBlog(Long id,String pw){
        System.out.println("service : " + id + pw);
        Blog blog = findBlog(id,pw);
        System.out.println("여기 보여줘 " + blog);
        blogRepository.delete(blog);
        return "삭제";
    }


    private Blog findBlog(Long id,String pw) {
        return blogRepository.findByIdAndPw(id,pw);
    };
}
