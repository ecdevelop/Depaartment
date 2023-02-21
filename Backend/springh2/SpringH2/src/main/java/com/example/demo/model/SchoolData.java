package com.example.demo.model;

import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.example.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolData  {

    private String type;
//    private List<Object> list =  Arrays.asList(
//            new CourseList(),
//            new ProfessorList(),
    private List<Course> courses;
    private List<Professor> professor;
    private List<Department> department;
}
