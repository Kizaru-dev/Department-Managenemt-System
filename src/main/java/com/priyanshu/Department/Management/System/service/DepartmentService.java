package com.priyanshu.Department.Management.System.service;

import com.priyanshu.Department.Management.System.entity.Department;
import com.priyanshu.Department.Management.System.entity.Employee;
import com.priyanshu.Department.Management.System.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo ;

    public DepartmentService(DepartmentRepo departmentRepo){
        this.departmentRepo = departmentRepo;
    }

    public List<Department> getAllEmployee(){
        return departmentRepo.findAll();
    }
    public Department createDepartment(Department department){
       return departmentRepo.save(department);
    }

    public Department getDepartmentById(Long id){
        return departmentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Argument Passed"));
    }
}
