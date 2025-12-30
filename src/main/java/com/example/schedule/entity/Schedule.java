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
    private Long scheduleId;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String content;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String password;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date updateDate;

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
