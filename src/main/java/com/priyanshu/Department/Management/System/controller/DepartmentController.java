package com.priyanshu.Department.Management.System.controller;


import com.priyanshu.Department.Management.System.entity.Department;
import com.priyanshu.Department.Management.System.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService ;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public String getAllDepartment(Model model){
        model.addAttribute("departments",departmentService.getAllEmployee());
        return "departments/list";
    }

    @GetMapping("/new")
    public String showCreateDepartmentForm(Model model){
        model.addAttribute("department",new Department());
        return "departments/form";
    }

    @PostMapping
    public String saveDepartment(@ModelAttribute Department department){
        departmentService.createDepartment(department);
        return "redirect:/departments";
    }
}
