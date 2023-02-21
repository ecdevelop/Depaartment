package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

// @CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
/*@RequestMapping("/departments") //acst a base url for all uri*/
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments" ) //post method create method
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@Valid @RequestBody Department department ){ //@RequestBody take a JSON Object and convert it into a department entity
        LOGGER.info("Inside saveDepartment of DepartmentController");
    return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/getdepartment/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartment(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
    }

    @DeleteMapping("/departments/deleteAll")
    public String deleteAllDepartments(){
        departmentService.deleteAll();
        return"All departments deleted Successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                       @RequestBody  Department department){
        try {
            return departmentService.updateDepartment(departmentId,department);
        } catch (DepartmentNotFoundException departmentNotFoundException) {
            throw new RuntimeException(departmentNotFoundException);
    }
    }

    @GetMapping("/departments/name/")
    public Department fetchDepartmentByName(@RequestParam String departmentName)throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @GetMapping("/getHeaderValues")
    public String getHeaderValues(
//                                    @RequestHeader  Map<String, String> mapValues,
            @RequestHeader(required = false) String authorization,
            @RequestHeader(required = false)  String postmanToken,
            @RequestHeader(required = false)  String ip,
            @RequestHeader(required = false)  String deviceType,
            @RequestHeader(required = false)  String os,
            @RequestHeader(required = false)  String userAgent,
            @RequestHeader(required = false)  String triggeredBy,
            @RequestHeader(required = false)  String sessionID
    ) {

//        Map<String,String> Map = mapValues;
//        String auth = mapValues.get("authorization");
//        String post = mapValues.get("postmanToken");
//        String ipAddress = mapValues.get("ip");
//        String device = mapValues.get("deviceType");

//        String OperatingSystem = mapValues.get("os");
//        String agent = mapValues.get("userAgent");
//        String trigger = mapValues.get("triggeredBy");
//        String sessId = mapValues.get("sessionID");

        System.out.println( authorization+" "+postmanToken+" "+" "+ip+" "+deviceType+" "+os+" "+userAgent+" "+triggeredBy+" "+sessionID);
        return  "Success " + authorization+" "+postmanToken+" "+" "+ip+" "+deviceType+" "+os+" "+userAgent+" "+triggeredBy+" "+sessionID;
    }

//    @GetMapping("/departments/pageOrdered")
//    public Object getPageTest(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
//                              @RequestParam(required = false) Integer pageSize,
//                              @RequestParam(required = false, defaultValue = "ASC") String sortOrder,
//                              @RequestParam(required = false) List<String> event,
//                              @RequestParam(required = false) List<Date> date){
//
//        return userActivityConsumerService.getPageTest(pageIndex,pageSize,event,date,sortOrder);
//    }
 }
