package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ScoreDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private  int score;
    private String subject;
//    private Long studentId;
    private String studentName;
    private int studentAge;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score;}
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
//    public Long getStudentId() { return studentId; }
//    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public int getStudentAge() { return studentAge; }
    public void setStudentAge(int studentAge) { this.studentAge = studentAge; }

}
