package com.example.schedule.dto.Comment;

import lombok.Getter;

import java.util.Date;

@Getter
public class GetCommentListResponse {  //단건 조회 업그레이드 시 댓글 리스트 받기 dto
    private Long commentId;
    private String commentContent;
    private String commentWriterName;
    private Date commentCreateDate;
    private Date commentUpdateDate;

    public GetCommentListResponse(Long commentId, String commentContent, String commentWriterName, Date commentCreateDate, Date commentUpdateDate) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentWriterName = commentWriterName;
        this.commentCreateDate = commentCreateDate;
        this.commentUpdateDate = commentUpdateDate;
    }
}
