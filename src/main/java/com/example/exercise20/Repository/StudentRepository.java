package com.example.exercise20.Repository;


import com.example.exercise20.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(int id);
}
