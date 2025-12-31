package com.example.schedule.repository;

import com.example.schedule.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //댓글 데이터베이스에 있는 scheduleId와 같은 값을 가진 필드 개수 카운트
    int countByScheduleId(Long scheduleId);

    //일정 아이디 찾기(댓글 테이블에 있는 scheduleId와 매핑하는 역할)
    List<Comment> findByScheduleId (Long scheduleId);
}
