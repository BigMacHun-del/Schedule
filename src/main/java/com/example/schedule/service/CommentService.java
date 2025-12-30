package com.example.schedule.service;

import com.example.schedule.dto.Comment.CreateCommentRequest;
import com.example.schedule.dto.Comment.CreateCommentResponse;
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
        // 일정이 있는지 확인
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));

        // 댓글 데이터베이스에 있는 scheduleId 값을 세서 10이 넘으면 예외를 던져줌
        int commentCount = commentRepository.countByScheduleId(scheduleId);
        if (commentCount >= 10) {
            throw new IllegalStateException("하나의 일정에는 댓글을 10개까지만 작성할 수 있습니다.");
        }

        Comment comment = new Comment(
                request.getCommentContent(),
                request.getCommentWriterName(),
                request.getCommentPassword(),
                scheduleId
        );

        Comment saveComment = commentRepository.save(comment);
        return new CreateCommentResponse(
                saveComment.getCommentId(),
                saveComment.getScheduleId(),
                saveComment.getCommentContent(),
                saveComment.getCommentWriterName(),
                saveComment.getCommentCreateDate(),
                saveComment.getCommentUpdateDate()
        );
    }
}
