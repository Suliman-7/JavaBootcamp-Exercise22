package com.example.exercise20.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should be not empty")
    private String name;

    @NotNull(message = "age should be not null")
    private int age;

    @NotEmpty(message = "major should be not empty")
    private String major;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "students")
    private Set<Course> courses;

}

