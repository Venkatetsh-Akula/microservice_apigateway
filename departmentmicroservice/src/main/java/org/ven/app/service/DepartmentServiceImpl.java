package org.ven.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.ven.app.entity.DepartmentTable;
import org.ven.app.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public ResponseEntity<?> getAllDepartmentDetails() {
		List<DepartmentTable> department=departmentRepository.findAll();
		ResponseEntity response=new ResponseEntity(department,HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<?> departmentById(int id) {
		Optional<DepartmentTable> department=departmentRepository.findById(id);
		if(department.isPresent()) {
			return new ResponseEntity(department,HttpStatus.OK);
		}else {
			return new ResponseEntity("Department no found",HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> saveDepartmentDetails(DepartmentTable departmentTable) {
		DepartmentTable department=departmentRepository.save(departmentTable);
		return new ResponseEntity(department,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateDepartmentDetails(DepartmentTable departmentTable,int id) {
		Optional<DepartmentTable> department=departmentRepository.findById(id);
		if(department.isPresent()) {
			DepartmentTable depart=departmentRepository.save(departmentTable);
			return new ResponseEntity(depart,HttpStatus.OK);
		}else {
			return new ResponseEntity("No Department found",HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> deleteDepartmentDetails(int id) {
		Optional<DepartmentTable> department=departmentRepository.findById(id);
		if(department.isPresent()) {
			departmentRepository.deleteById(id);
			return new ResponseEntity("Department delete",HttpStatus.OK);
		}else {
			return new ResponseEntity("Department not found on given id",HttpStatus.NOT_FOUND);
		}
	}

}
