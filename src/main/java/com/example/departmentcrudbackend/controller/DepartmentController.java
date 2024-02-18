package com.example.departmentcrudbackend.controller;

import com.example.departmentcrudbackend.dto.DepartmentDto;
import com.example.departmentcrudbackend.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    public final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto),
        HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") int id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") int id,
                                                          @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.updateDepartment(id,departmentDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteDepartment(@PathVariable("id") int id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

}
