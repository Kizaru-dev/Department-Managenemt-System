package com.priyanshu.Department.Management.System.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private String description ;


    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Employee> employees = new ArrayList<>();


    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
        employee.setDepartment(null);
    }

}
