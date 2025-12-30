package com.example.schedule.dto.Schedule;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateScheduleResponse {
    private final Long scheduleId;
    private final String title;
    private final String content;
    private final String name;
    private final Date createDate;
    private final Date updateDate;

    public CreateScheduleResponse(Long scheduleId, String title, String content, String name, Date createDate, Date updateDate) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
