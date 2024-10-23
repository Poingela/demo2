package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "score")
    private int score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonBackReference
    private Student student;


    public long getId() {  return id; }

    public void setId(long id) { this.id = id; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }


    public Student getStudent() { return student; }

    public void setStudent(Student student) { this.student = student; }
}
