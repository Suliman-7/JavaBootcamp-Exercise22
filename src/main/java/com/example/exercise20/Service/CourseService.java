package com.example.exercise20.Service;

import com.example.exercise20.Api.ApiException;
import com.example.exercise20.Model.Course;
import com.example.exercise20.Model.Teacher;
import com.example.exercise20.Repository.CourseRepository;
import com.example.exercise20.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(int id , Course course) {
        Course course1 = courseRepository.findCourseById(id);
        if(course1 == null) {
            throw new ApiException("Course not found");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void deleteCourse(int id) {
        Course course = courseRepository.findCourseById(id);
        if(course == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

    public void assignCourseToTeacher(int course_id, int teacher_id) {
        Course course = courseRepository.findCourseById(course_id);
        if(course == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if(teacher == null) {
            throw new ApiException("Teacher not found");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);

    }

    public String getTeacherName(int course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if(course == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher = course.getTeacher();
        if(teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher.getName();
    }


}
