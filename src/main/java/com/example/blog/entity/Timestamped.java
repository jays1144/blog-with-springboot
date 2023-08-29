package com.example.blog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // Entity클래스의 상속
@EntityListeners(AuditingEntityListener.class) // auditing기능을 부여 = 자동으로 시간을 넣어줌
public abstract class Timestamped {
    // 추상클래스가 아니여도 상관은없다
    // 다른 Entity를 상속하기 위해 만들었기때문에 객체로 만들필요가없어서 추상클래스로 만듬

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;
}
