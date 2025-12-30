package com.example.schedule.controller;

import com.example.schedule.dto.Comment.CreateCommentRequest;
import com.example.schedule.dto.Comment.CreateCommentResponse;
import com.example.schedule.dto.Comment.GetScheduleCommentResponse;
import com.example.schedule.service.CommentService;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final ScheduleService scheduleService;
    //댓글 생성
    @PostMapping("/schedules/comments/{scheduleId}")
    public ResponseEntity<CreateCommentResponse> creatComment(@PathVariable Long scheduleId, @RequestBody CreateCommentRequest request){
        CreateCommentResponse result = commentService.save(scheduleId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //일정 조회 업그레이드
    @GetMapping("/schedules/comments/{scheduleId}")
    public ResponseEntity<GetScheduleCommentResponse> getAllPlusComment(@PathVariable Long scheduleId){
        GetScheduleCommentResponse result = commentService.getAllPlusComment(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
