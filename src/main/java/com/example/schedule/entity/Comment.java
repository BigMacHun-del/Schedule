package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.swing.text.StringContent;
import java.util.Date;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;  //댓글 고유 id

    @Column(nullable = false)
    private Long scheduleId;  //댓글 달 일정의 id

//    @ManyToOne(fetch = FetchType.LAZY)  //다대일 선언
//    @JoinColumn(name = "scheduleId", nullable = false)  //외래키 정의
//    private Schedule schedule;

    @Column(nullable = false)
    private String commentWriterName;  //댓글 작성자 명

    @Column(nullable = false)
    private String commentPassword;   //댓글 비밀번호

    @Column(length = 300, nullable = false)
    private String commentContent;  //댓글 내용

    @Column(nullable = false)
    private Date commentCreateDate;  //댓글 생성일

    @Column(nullable = false)
    private Date commentUpdateDate;  //댓글 수정일

    public Comment(String commentWriterName, String commentPassword, String commentContent, Long scheduleId){
        this.commentWriterName = commentWriterName;
        this.commentPassword = commentPassword;
        this.commentContent = commentContent;
        this.scheduleId = scheduleId;
    }


    // 생성 시 자동으로 시간 설정
    @PrePersist
    public void setCreateDate(){
        commentCreateDate = new Date();
        commentUpdateDate = new Date();
    }

    // 수정 시 자동으로 시간 설정
    @PreUpdate
    public void setUpdateDate(){
        commentUpdateDate = new Date();
    }
}
