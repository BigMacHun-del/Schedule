package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //작성자 명 오름차순으로 그룹 묶고, 수정일 기준으로 내림차순 메서드(쿼리 메소드 사용)
    List<Schedule> findAllByOrderByNameAscUpdateDateDesc();
}
