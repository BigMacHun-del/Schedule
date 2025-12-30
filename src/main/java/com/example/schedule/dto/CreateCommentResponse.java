package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateCommentResponse {
    private final Long commentId;
    private final Schedule schedule;
    private final String commentContent;
    private final String commentWriterName;
    private final Date commentCreateDate;
    private final Date commentUpdateDate;

    public CreateCommentResponse(Long commentId, Schedule schedule, String commentContent, String commentWriterName, Date commentCreateDate, Date commentUpdateDate) {
        this.commentId = commentId;
        this.schedule = schedule;
        this.commentContent = commentContent;
        this.commentWriterName = commentWriterName;
        this.commentCreateDate = commentCreateDate;
        this.commentUpdateDate = commentUpdateDate;
    }
}
