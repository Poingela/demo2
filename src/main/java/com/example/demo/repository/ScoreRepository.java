package com.example.demo.repository;

import com.example.demo.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    List<Score> findByStudentId (Long studentId);
    List<Score> findByStudentIdAndSubject (Long studentId, String subject);

}
