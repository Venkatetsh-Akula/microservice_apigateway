package org.ven.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.ven.app.dto.DepartmentTable;
import org.ven.app.dto.EmployeeDetails;
import org.ven.app.entity.EmployeeTable;
import org.ven.app.openfeign.EmployeeFeignClient;
import org.ven.app.repository.EmployeeRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeFeignClient employeeFeignClient; 

	@Override
	public ResponseEntity<?> allEmployeeDetails() {
		List<EmployeeTable> employee=employeeRepository.findAll();
		List<EmployeeDetails> result=new ArrayList<>();
		for(EmployeeTable emp:employee) {
			Object edept= employeeFeignClient.getDepartmentByIdController(emp.getDepartmentId()).getBody();
			ObjectMapper mapper=new ObjectMapper();
			DepartmentTable dept=mapper.convertValue(edept, DepartmentTable.class);
			EmployeeDetails employeeDetails=new EmployeeDetails();
			employeeDetails.setEmployeeId(emp.getEmployeeId());
			employeeDetails.setEmployeeName(emp.getEmployeeName());
			employeeDetails.setEmployeeAge(emp.getEmployeeAge());
			employeeDetails.setSalary(emp.getSalary());
			employeeDetails.setDepartment(dept);
			result.add(employeeDetails);
		}
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<?> findEmployeeById(int id) {
		Optional<EmployeeTable> emp=employeeRepository.findById(id);
		if(emp.isPresent()) {
			Object response=employeeFeignClient.getDepartmentByIdController(emp.get().getDepartmentId()).getBody();
			ObjectMapper mapper=new ObjectMapper();
			DepartmentTable res=mapper.convertValue(response, DepartmentTable.class);
			EmployeeDetails employeeDetails=new EmployeeDetails();
			employeeDetails.setDepartment(res);
			employeeDetails.setEmployeeId(emp.get().getEmployeeId());
			employeeDetails.setEmployeeName(emp.get().getEmployeeName());
			employeeDetails.setSalary(emp.get().getSalary());
			employeeDetails.setEmployeeAge(emp.get().getEmployeeAge());
			return new ResponseEntity(employeeDetails,HttpStatus.OK);
		}
		return new ResponseEntity("Employee not found",HttpStatus.NOT_FOUND);
	}	
	
	@Override
	public ResponseEntity<?> saveEmployeeDetails(EmployeeTable employee) {
		EmployeeTable savedEmployee=employeeRepository.save(employee);
		return new ResponseEntity(savedEmployee,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteEmployeeDetails(int id) {
		Optional<EmployeeTable> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.deleteById(id);
			return new ResponseEntity("Employee Details deleted",HttpStatus.OK);
		}
		return new ResponseEntity("No Employee has found",HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> updateEmployeeDetails(int id, EmployeeTable employee) {
		Optional<EmployeeTable> emp=employeeRepository.findById(id);
		if(emp.isPresent()) {
			EmployeeTable updatedEmployee=employeeRepository.save(employee);
			return new ResponseEntity(updatedEmployee,HttpStatus.OK);
		}
		return new ResponseEntity("Employee not found",HttpStatus.NOT_FOUND);
	}
}
