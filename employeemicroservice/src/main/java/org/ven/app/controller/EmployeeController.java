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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ven.app.entity.EmployeeTable;
import org.ven.app.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/allemployees")
	public ResponseEntity<?> getAllEmployeeDetails(){
		return employeeService.allEmployeeDetails();
	}
	
	@GetMapping("/getemployee/{id}")
	public ResponseEntity<?> getEmployeeDetails(@PathVariable int id){
		return employeeService.findEmployeeById(id);
	}
	
	@PostMapping("/saveemployee")
	public ResponseEntity<?> saveEmployeeDetails(@RequestBody EmployeeTable employee){
		return employeeService.saveEmployeeDetails(employee);
	}
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable int id,@RequestBody EmployeeTable employee){
		return employeeService.updateEmployeeDetails(id,employee);
	}
	
	@DeleteMapping("deleteemployee/{id}")
	public ResponseEntity<?> deleteEmployeeDetails(@PathVariable int id){
		return employeeService.deleteEmployeeDetails(id);
	}
}
