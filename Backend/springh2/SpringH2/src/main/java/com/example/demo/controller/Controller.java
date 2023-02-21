package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.model.SchoolData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.Service;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/")
    public String welcome(){
        return "Welcome to IntelliJIdea SpringBoot ";
    }

    @GetMapping("/helloworld") //getmapping is newer than request mapping
    public String greet(){
        return "Hello World";
    }

    @RequestMapping(value = "/greetme", method = RequestMethod.GET)
    public String greetMe(){
        return service.greetMe();
    }

//    @GetMapping("/schoolData")
//    public List<Object> getschoolData(){
//        SchoolData p = new SchoolData();
//        return p.getList();
//    }
//    @GetMapping("/schoolData2")
//    public List<SchoolData> getSchools() {
//        SchoolDataList x = new SchoolDataList();
//        return x.getSchoolDataList();
//    }
    @GetMapping("/getCoursesFromDB")
    public List<Course> getCoursesFromDB(){
        return service.getAllCourses();
    }

    @GetMapping("/etona")
    public List<SchoolData> getEtoNa(){
       List<SchoolData> s = service.getListOfStudent();
        return s;
    }

}
