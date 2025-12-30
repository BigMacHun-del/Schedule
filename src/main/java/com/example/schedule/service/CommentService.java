package com.example.schedule.service;

import com.example.schedule.dto.CreateCommentRequest;
import com.example.schedule.dto.CreateCommentResponse;
import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.CommentRepository;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    //댓글 생성
    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));

        Comment comment = new Comment(
                request.getCommentContent(),
                request.getCommentWriterName(),
                request.getCommentPassword(),
                schedule
        );

        Comment saveComment = commentRepository.save(comment);
        return new CreateCommentResponse(
                saveComment.getCommentId(),
                saveComment.getSchedule(),
                saveComment.getCommentContent(),
                saveComment.getCommentWriterName(),
                saveComment.getCommentCreateDate(),
                saveComment.getCommentUpdateDate()
        );
    }
}
