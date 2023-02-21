package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

   public void deleteAll();

   public Department saveDepartment(Department department);

   List<Department> fetchDepartmentList();

   Department getDepartment(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException;

   Department fetchDepartmentByName(String departmentName);
}
