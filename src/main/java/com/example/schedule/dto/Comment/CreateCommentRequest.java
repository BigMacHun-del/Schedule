package com.example.schedule.dto.Comment;

import lombok.Getter;

@Getter
public class CreateCommentRequest {
    private String commentWriterName;
    private String commentPassword;
    private String commentContent;
    private Long scheduleId;
}
