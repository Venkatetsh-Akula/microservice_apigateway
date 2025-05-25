package org.ven.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {
	
	private int employeeId;
	private String employeeName;
	private int employeeAge;
	private double salary;
	private DepartmentTable department;

}
