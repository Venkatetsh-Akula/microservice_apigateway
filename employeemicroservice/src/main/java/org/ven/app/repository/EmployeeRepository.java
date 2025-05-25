package org.ven.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ven.app.entity.EmployeeTable;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTable, Integer> {

}
