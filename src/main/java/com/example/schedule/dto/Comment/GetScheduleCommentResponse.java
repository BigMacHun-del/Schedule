package com.example.schedule.dto.Comment;

import com.example.schedule.entity.Comment;
import lombok.Getter;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Getter
public class GetScheduleCommentResponse {
    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String name;
    private final Date createDate;
    private final Date updateDate;
    private List<GetCommentListResponse> comments;

    public GetScheduleCommentResponse(Long scheduleId, String title, String content, String name, Date createDate, Date updateDate, List<GetCommentListResponse> comments) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;

    }
}
