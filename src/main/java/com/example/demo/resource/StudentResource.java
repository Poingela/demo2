package com.example.demo.resource;


import com.example.demo.dto.ScoreDto;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

//base - http://localhost:8080
@RestController
@RequestMapping("api/student") //base - http://localhost:8080/api/student
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("testCreateScore")
    public void testCreateScore(){
        studentService.testCreateScore();
    }

    //以下是20241009上課內容MVC
//    //以下寫是在網址後面http://localhost:8080/api/student/getStudentById/2(放上要尋的id)
//    @GetMapping("getStudentById2/{id}")
//    public ResponseEntity<?> getStudentById(@PathVariable long id){
//        try {
//            Student student = studentService.getStudentById(id);
//            return new ResponseEntity<>(student, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("找不到學生",HttpStatus.BAD_REQUEST);
//        }
//    }

    //以下寫法是在網址後面http://localhost:8080/api/student/getStudentById?id=?(?表示要輸入的資料）
    @GetMapping("getStudentById")
    public ResponseEntity<?>getStudentById(@RequestParam long id){
        try {
            Student student = studentService.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("找不到學生",HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("getStudentByNameAndAge")
    public ResponseEntity<?> getNameAge (@RequestBody StudentDTO studentDTo) {
        try {
            List<Student> student = studentService.getStudentByNameAndAge(studentDTo);
            return new ResponseEntity<>(student ,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("找不到學生", HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("getScoreByStudentId")
    public ResponseEntity<?> getScoreById (@RequestBody StudentDTO studentDTo) {
        try {
            List<ScoreDto> scores = studentService.getScoreByStudentId(studentDTo.getId());
            return new ResponseEntity<>(scores ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("找不到學生分數", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("getScoreByStudentIdAndSubject")
    public  ResponseEntity<?> getScoreByIdAndSubject (@RequestBody StudentDTO studentDTo) {
        try {
            List<ScoreDto> scores2 = studentService.getScoreByStudentIdAndSubject(
                    studentDTo.getId(),
                    studentDTo.getSubject());
            return new ResponseEntity<>(scores2 ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("找不到資料" ,HttpStatus.BAD_REQUEST);
        }
    }



//    @GetMapping("testCreate")
//    public void test() {
//        studentService.testCreateNewStudent();
//    }

}
