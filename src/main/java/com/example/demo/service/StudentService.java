package com.example.demo.service;

import com.example.demo.dto.ScoreDto;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Score;
import com.example.demo.entity.Student;
import com.example.demo.repository.ScoreRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired   //不用做new了
    private StudentRepository studentRepository;

    @Autowired
    private ScoreRepository scoreRepository;


    @Transactional
    public List<Student> findAll() {
        //List<Student> students = studentRepository.findAll();

        //System.out.println("Testing: " + students.size());

        //List<Student> a = studentRepository.findByAgeBetween(30,40);
        //return students;
        //return a;
        return studentRepository.findAll();
    }

    public void testCreateScore(){
        Student student = new Student();
        student.setAge(36);
        student.setName("Cindy");
        student.setScores(mockScores(student));

        studentRepository.save(student);

    }
    private List<Score> mockScores(Student student){
        Score score = new Score();

        score.setScore(65);
        score.setSubject("Chinese");
        score.setStudent(student);

        return Collections.singletonList(score);
    }

    public Student getStudentById(long id)throws Exception{
        Optional<Student> studentOp = studentRepository.findById(id);

        if (studentOp.isPresent()){
            return studentOp.get();
        }else {
            throw new Exception("找不到學生");
        }
    }


    public List<Student> getStudentByNameAndAge(StudentDTO studentDTo) throws  Exception{

        List<Student> students = studentRepository.findByNameAndAge(studentDTo.getName(),studentDTo.getAge());

        if(!students.isEmpty()) {
            return students;
        } else {
            throw new Exception("找不到學生");
        }
    }

    public List<ScoreDto> getScoreByStudentId(Long studentId) throws Exception {

        List<Score> scores = scoreRepository.findByStudentId(studentId);
        if (!scores.isEmpty()) {
            List<ScoreDto> scoreDtos = new ArrayList<>();
            Student student = scores.get(0).getStudent();
            for (Score score : scores) {
                ScoreDto scoreDto = new ScoreDto();
                scoreDto.setStudentName(student.getName());
                scoreDto.setStudentAge(student.getAge());
                scoreDto.setSubject(score.getSubject());
                scoreDto.setScore(score.getScore());

                scoreDtos.add(scoreDto);

            }
            return scoreDtos;
        } else {
            throw new Exception("找不到學生及分數");

        }
    }

        public List<ScoreDto> getScoreByStudentIdAndSubject (Long studentId, String subject) throws Exception {

        List<Score> scores2 = scoreRepository.findByStudentIdAndSubject(studentId, subject);
        if (!scores2.isEmpty()) {
            List<ScoreDto> scoreDtos = new ArrayList<>();
            Student student = scores2.get(0).getStudent();
            for (Score score : scores2) {
                ScoreDto scoreDto = new ScoreDto();
                scoreDto.setStudentName(student.getName());
                scoreDto.setStudentAge(student.getAge());
                scoreDto.setSubject(score.getSubject());
                scoreDto.setScore(score.getScore());

                scoreDtos.add(scoreDto);

            }
            return scoreDtos;
        } else {
            throw new Exception("找不到學生及分數");

        }
    }




    //public List<Student> getStudentByNameAndAge(){};



//    public void testCreateNewStudent(){
//        Student student = new Student();
//
//        student.setAge(45);
//        student.setName("Chris");
//
//        studentRepository.save(student);
//        System.out.println("新增學生: " + student.getName());
//
//    }

}



