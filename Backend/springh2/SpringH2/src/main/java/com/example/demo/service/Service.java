package com.example.demo.service;

import com.example.demo.model.SchoolData;
import com.example.demo.dto.courseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
import com.example.demo.entity.Professor;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    public String greetMe(){
        return "Hello User!";
    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public List<Professor> getAllProfessor(){
        return professorRepository.findAll();
    }

    public List<Course> getCourse(){
        List<Course> courseList = getAllCourses();
        return courseList;
    }
    public List<SchoolData> getListOfStudent(){

        List<Course> c = courseRepository.findAll();  //get course table
        List<Professor> p = professorRepository.findAll(); //get professor table
        List<Department> d = departmentRepository.findAll(); // get department table

        SchoolData coursesList = new SchoolData();
        SchoolData professorList = new SchoolData();
        SchoolData departmentList = new SchoolData();

        coursesList.setCourses(c); coursesList.setType("Courses");
        professorList.setProfessor(p); professorList.setType("Professor");
        departmentList.setDepartment(d); departmentList.setType("Departments");

        List<SchoolData> ListOfSchoolData = new ArrayList<SchoolData>();
        ListOfSchoolData.add(coursesList);
        ListOfSchoolData.add(professorList);
        ListOfSchoolData.add(departmentList);

        return ListOfSchoolData;
    }
    public courseDTO fromEntityCourseToNewDto(Course course){
//        return new courseDTO(course.getCourseId(),course.getCourseName(),course.ge);
        return null;
    }



}
