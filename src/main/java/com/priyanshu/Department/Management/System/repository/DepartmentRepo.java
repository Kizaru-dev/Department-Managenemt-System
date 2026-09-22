package com.priyanshu.Department.Management.System.repository;

import com.priyanshu.Department.Management.System.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department , Long> {

}
