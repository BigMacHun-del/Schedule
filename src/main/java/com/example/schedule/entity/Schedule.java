package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;  //일정 고유 id

    @Column(length = 30, nullable = false)
    private String title;  //일정 제목

    @Column(length = 200, nullable = false)
    private String content;  //일정 내용

    @Column(length = 20, nullable = false)
    private String name;  //작성자 명

    @Column(length = 30, nullable = false)
    private String password;  //비밀번호

    @Column(nullable = false)
    private Date createDate;  //생성일

    @Column(nullable = false)
    private Date updateDate;  //수정일

    public Schedule(String title, String content, String name, String password){
        this.content = content;
        this.title = title;
        this.name = name;
        this.password = password;
    }

    // 생성 시 자동으로 시간 설정
    @PrePersist
    public void setCreateDate(){
        createDate = new Date();
        updateDate = new Date();
    }

    // 수정 시 자동으로 시간 설정
    @PreUpdate
    public void setUpdateDate(){
        updateDate = new Date();
    }

    public void updateSchedule(String title, String name){
        this.title = title;
        this.name = name;
    }
}
