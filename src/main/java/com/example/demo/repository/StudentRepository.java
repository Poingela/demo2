package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    //Long指的是資料庫＠id的資料型別
    List<Student> findByNameAndAge (String name,int age);
    List<Student> findByAgeBetween(int age, int i);


}
