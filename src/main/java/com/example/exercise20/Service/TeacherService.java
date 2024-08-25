package com.example.exercise20.Service;

import com.example.exercise20.Api.ApiException;
import com.example.exercise20.Model.Teacher;
import com.example.exercise20.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> findAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(int id,Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1 == null){
            throw new ApiException("Teacher not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(int id){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1 == null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher1);
    }


    public Teacher findTeacherById(int id){
        return teacherRepository.findTeacherById(id);
    }


}
