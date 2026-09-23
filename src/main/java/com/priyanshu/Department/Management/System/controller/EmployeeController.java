package com.priyanshu.Department.Management.System.controller;

import com.priyanshu.Department.Management.System.entity.Department;
import com.priyanshu.Department.Management.System.entity.Employee;
import com.priyanshu.Department.Management.System.repository.EmployeeRepo;
import com.priyanshu.Department.Management.System.service.DepartmentService;
import com.priyanshu.Department.Management.System.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class EmployeeController {

    private EmployeeService employeeService ;
    private DepartmentService departmentService ;

    public EmployeeController(EmployeeService employeeService , DepartmentService departmentService){
        this.employeeService = employeeService ;
        this.departmentService = departmentService ;
    }

    @GetMapping("/{departmentId}/employees/new")
    public String showEmployeeForm(@PathVariable Long departmentId , Model model){
        Department department = departmentService.getDepartmentById(departmentId);
        model.addAttribute("department",department);
        model.addAttribute("employee",new Employee());
        return "employees/form";
    }

    @PostMapping("/{departmentId}/employees")
    public String saveEmployees(@PathVariable Long departmentId , @ModelAttribute Employee employee){
        employeeService.addEmployeeToDepartment(departmentId,employee);
        return "redirect:/departments";
    }
}
