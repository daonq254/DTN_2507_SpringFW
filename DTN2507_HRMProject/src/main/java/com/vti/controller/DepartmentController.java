package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments() {
		List<Department> listdeDepartments = departmentService.getAllDepartments(); // id name
//
		List<DepartmentDto> listdepDepartmentDtos = new ArrayList<>(); // name
		for (Department department : listdeDepartments) {
//			DepartmentDto departmentDto = new DepartmentDto();
//			departmentDto.setName(department.getName());

			DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);

			listdepDepartmentDtos.add(departmentDto);
		}

//		
		return new ResponseEntity<>(listdepDepartmentDtos, HttpStatus.OK);
	}

//	
}
