package com.priyanshu.Department.Management.System.service;

import com.priyanshu.Department.Management.System.entity.Department;
import com.priyanshu.Department.Management.System.entity.Employee;
import com.priyanshu.Department.Management.System.repository.DepartmentRepo;
import com.priyanshu.Department.Management.System.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepo  employeeRepo;
    private final DepartmentService departmentService;

    public EmployeeService(EmployeeRepo employeeRepo , DepartmentService departmentService){
        this.employeeRepo = employeeRepo;
        this.departmentService = departmentService;
    }

    public Employee addEmployeeToDepartment(Long departmentId , Employee employee){
        Department department = departmentService.getDepartmentById(departmentId);
        employee.setDepartment(department);
        return employeeRepo.save(employee);
    }
}
