package com.priyanshu.Department.Management.System.repository;

import com.priyanshu.Department.Management.System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee , Long> {

}
