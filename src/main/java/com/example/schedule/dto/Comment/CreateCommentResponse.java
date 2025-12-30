package com.example.schedule.dto.Comment;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateCommentResponse {
    private final Long commentId;
    private final Long scheduleId;
    private final String commentContent;
    private final String commentWriterName;
    private final Date commentCreateDate;
    private final Date commentUpdateDate;

    public CreateCommentResponse(Long commentId, Long scheduleId, String commentContent, String commentWriterName, Date commentCreateDate, Date commentUpdateDate) {
        this.commentId = commentId;
        this.scheduleId = scheduleId;
        this.commentContent = commentContent;
        this.commentWriterName = commentWriterName;
        this.commentCreateDate = commentCreateDate;
        this.commentUpdateDate = commentUpdateDate;
    }
}
