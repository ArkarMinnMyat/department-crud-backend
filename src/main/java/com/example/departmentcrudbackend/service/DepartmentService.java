package com.example.departmentcrudbackend.service;

import com.example.departmentcrudbackend.dao.DepartmentDao;
import com.example.departmentcrudbackend.dto.DepartmentDto;
import com.example.departmentcrudbackend.entity.Department;
import com.example.departmentcrudbackend.exception.ResourceNotFoundException;
import com.example.departmentcrudbackend.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.departmentcrudbackend.mapper.DepartmentMapper.*;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentDto createDepartment(DepartmentDto departmentDto){
        return toDto(departmentDao.save(toEntity(departmentDto)));
    }

    public DepartmentDto getDepartmentById(int id){
        return toDto(departmentDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department is not exist with given id : " + id)));
    }

    public List<DepartmentDto> getAllDepartments(){
        return departmentDao.findAll()
                .stream()
                .map(DepartmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public DepartmentDto updateDepartment(int id, DepartmentDto departmentDto){
        DepartmentDto dep = getDepartmentById(id);
        dep.setCode(departmentDto.getCode());
        dep.setName(departmentDto.getName());
        dep.setCountry(departmentDto.getCountry());
        Department department = toEntity(dep);
        department.setId(id);
        return toDto(departmentDao.save(department));
    }

    public void deleteDepartment(int id){
        if (departmentDao.existsById(id)){
            departmentDao.deleteById(id);
        }else
            throw new ResourceNotFoundException("Department is not exist with given id : " + id);
    }
}
