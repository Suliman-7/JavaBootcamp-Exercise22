package com.example.exercise20.Controller;

import com.example.exercise20.Model.Student;
import com.example.exercise20.Service.StudentService;
import jakarta.validation.Valid;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor


public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/post")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("student updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted successfully");
    }

    @PutMapping("/{sid}/assign/{cid}")
    public ResponseEntity assignStudentandCourse(@PathVariable int sid, @PathVariable int cid) {
        studentService.assignStudentandCourse(sid, cid);
        return ResponseEntity.status(200).body("student and course assigned successfully");
    }

    @PutMapping("/changemajor/{sid}/{newmajor}")
    public ResponseEntity changeMajor(@PathVariable int sid , @PathVariable String newmajor){
        studentService.changeMajor(sid, newmajor);
        return ResponseEntity.status(200).body("student major changed successfully");
    }

    @GetMapping("/gitbycourseid/{cid}")
    public ResponseEntity getStudentsByCourseId(@PathVariable int cid){
        return ResponseEntity.status(200).body(studentService.getStudentsByCourseId(cid));
    }


}
