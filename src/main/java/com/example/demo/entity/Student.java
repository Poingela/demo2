package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private  int age;

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonManagedReference
    private List<Score> scores = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<Score> getScores() { return scores; }
    public void setScores(List<Score> scores) { this.scores = scores; }



}
