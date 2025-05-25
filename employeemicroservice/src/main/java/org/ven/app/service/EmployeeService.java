package org.ven.app.service;

import org.springframework.http.ResponseEntity;
import org.ven.app.entity.EmployeeTable;

public interface EmployeeService {

	ResponseEntity<?> saveEmployeeDetails(EmployeeTable employee);

	ResponseEntity<?> deleteEmployeeDetails(int id);

	ResponseEntity<?> allEmployeeDetails();

	ResponseEntity<?> findEmployeeById(int id);

	ResponseEntity<?> updateEmployeeDetails(int id, EmployeeTable employee);

}
