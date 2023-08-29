package com.example.blog.entity;


import com.example.blog.dto.BlogRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "blog")
@NoArgsConstructor
public class Blog extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "contents",length = 500)
    private String contents;

    @Column(name = "pw",length = 20)
    private String pw;

    @Column(name = "title")
    private String title;

    public Blog(BlogRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.pw = requestDto.getPw();
        this.title = requestDto.getTitle();
    }

    public void update(BlogRequestDto requestDto) {
        System.out.println("여기 변경되니 : " + requestDto.getUsername());;
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.pw = requestDto.getPw();
        this.title = requestDto.getTitle();
    }
}
