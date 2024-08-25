package com.example.exercise20.Controller;

import com.example.exercise20.Model.Course;
import com.example.exercise20.Service.CourseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor

public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
       return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/post")
    public ResponseEntity addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("course added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id, @Valid @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("course updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("course deleted successfully");
    }

    @PutMapping("/{cid}/assign/{tid}")
    public ResponseEntity assignCourse(@PathVariable int cid, @PathVariable int tid) {
        courseService.assignCourseToTeacher(cid,tid);
        return ResponseEntity.status(200).body("course assigned to teacher successfully");
    }

    @GetMapping("/getname/{cid}")
    public ResponseEntity getTeacherName(@PathVariable int cid) {
        return ResponseEntity.status(200).body(courseService.getTeacherName(cid));
    }
}
