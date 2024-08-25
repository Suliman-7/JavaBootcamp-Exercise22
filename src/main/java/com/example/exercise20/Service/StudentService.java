package com.example.exercise20.Service;

import com.example.exercise20.Api.ApiException;
import com.example.exercise20.Model.Course;
import com.example.exercise20.Model.Student;
import com.example.exercise20.Repository.CourseRepository;
import com.example.exercise20.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(int id , Student student) {
        Student student1 = studentRepository.findStudentById(id);
        if (student1 == null) {
            throw new ApiException("Student not found");
        }
        student1.setAge(student.getAge());
        student1.setName(student.getName());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }

    public void deleteStudent(int id) {
        Student student1 = studentRepository.findStudentById(id);

        if (student1 == null) {
            throw new ApiException("Student not found");
        }

        studentRepository.delete(student1);

    }

    public void assignStudentandCourse(int studentId, int courseId) {
        Student student1 = studentRepository.findStudentById(studentId);
        if (student1 == null) {
            throw new ApiException("Student not found");
        }
        Course course1 = courseRepository.findCourseById(courseId);
        if (course1 == null) {
            throw new ApiException("Course not found");
        }
        student1.getCourses().add(course1);
        course1.getStudents().add(student1);
        studentRepository.save(student1);
        courseRepository.save(course1);
    }

    public void changeMajor(int studentId, String newMajor) {
        Student student1 = studentRepository.findStudentById(studentId);
        if (student1 == null) {
            throw new ApiException("Student not found");
        }
        for (Course course : student1.getCourses()) {
            course.getStudents().remove(student1);
        }
        student1.setMajor(newMajor);
        studentRepository.save(student1);
    }

    public List<Student> getStudentsByCourseId(int courseId) {
        List<Student> stu = new ArrayList<>();
        Course course = courseRepository.findCourseById(courseId);
        for (Student student : course.getStudents()) {
            stu.add(student);
        }
        return stu;
    }


}
