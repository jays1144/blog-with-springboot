package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findAllByOrderByCreatedAtDesc();

    List<Blog> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);

    Blog findByIdAndPw(Long id,String pw);

}
