package com.example.departmentcrudbackend.mapper;


import com.example.departmentcrudbackend.dto.DepartmentDto;
import com.example.departmentcrudbackend.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto toDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getCode(),
                department.getName(),
                department.getCountry()
        );
    }

    public static Department toEntity(DepartmentDto departmentDto){
        return new Department(
                departmentDto.getCode(),
                departmentDto.getName(),
                departmentDto.getCountry()
        );
    }
}
