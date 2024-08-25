package com.example.exercise20.Controller;


import com.example.exercise20.Model.Teacher;
import com.example.exercise20.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor

public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        return ResponseEntity.status(200).body(teacherService.findAllTeachers());
    }

    @PostMapping("/post")
    public ResponseEntity postTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity getTeacherById(@PathVariable int id){
        return ResponseEntity.status(200).body(teacherService.findTeacherById(id));
    }
}
