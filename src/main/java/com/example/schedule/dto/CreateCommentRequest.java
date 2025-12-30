package com.example.schedule.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateCommentRequest {
    private String commentWriterName;
    private String commentPassword;
    private String commentContent;
}
