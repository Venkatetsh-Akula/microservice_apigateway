package org.ven.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ven.app.entity.DepartmentTable;
import org.ven.app.service.DepartmentService;

@RestController
@RequestMapping(value="/api/depart")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value="/alldepartments")
	public ResponseEntity<?> getDepartment(){
		return departmentService.getAllDepartmentDetails();
	}
	
	@GetMapping(value="/department/{id}")
	public ResponseEntity<?> getDepartmentByIdController(@PathVariable int id){
		return departmentService.departmentById(id);
	}
	
	@PostMapping(value="/savedepartment")
	public ResponseEntity<?> saveDepartmentDetails(@RequestBody DepartmentTable departmentTable){
		return departmentService.saveDepartmentDetails(departmentTable);
	}
	
	@PutMapping(value="/updatedepartment/{id}")
	public ResponseEntity<?> updateDepartmentDetails(@RequestBody DepartmentTable departmentTable,@PathVariable int id){
		return departmentService.updateDepartmentDetails(departmentTable,id);
	}
	
	@DeleteMapping(value="/deletedepartment/{id}")
	public ResponseEntity<?> deleteMappingDetails(@PathVariable int id){
		return departmentService.deleteDepartmentDetails(id);
	}
}
