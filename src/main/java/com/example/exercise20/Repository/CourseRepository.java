package com.example.exercise20.Repository;


import com.example.exercise20.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(int id);

}
