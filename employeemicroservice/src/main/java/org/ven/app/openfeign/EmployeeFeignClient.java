package org.ven.app.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="departmentmicroservice",url="http://localhost:8080/api/depart")
public interface EmployeeFeignClient {

	@GetMapping(value="/alldepartments")
	public ResponseEntity<?> getDepartment();
	@GetMapping(value="/department/{id}")
	public ResponseEntity<?> getDepartmentByIdController(@PathVariable int id);
}
