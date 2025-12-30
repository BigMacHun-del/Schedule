package com.example.schedule.repository;

import com.example.schedule.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByScheduleId(Long scheduleId);  //댓글 데이터베이스에 있는 scheduleId와 같은 값을 가진 필드 개수 카운트
}
