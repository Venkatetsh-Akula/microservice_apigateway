package org.ven.app.service;

import org.springframework.http.ResponseEntity;
import org.ven.app.entity.DepartmentTable;

public interface DepartmentService {

	ResponseEntity<?> getAllDepartmentDetails();

	ResponseEntity<?> departmentById(int id);

	ResponseEntity<?> saveDepartmentDetails(DepartmentTable departmentTable);

	ResponseEntity<?> updateDepartmentDetails(DepartmentTable departmentTable,int id);

	ResponseEntity<?> deleteDepartmentDetails(int id);

}
