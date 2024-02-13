package com.example.departmentcrudbackend.dao;

import com.example.departmentcrudbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
