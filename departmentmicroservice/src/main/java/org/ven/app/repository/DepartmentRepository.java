package org.ven.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ven.app.entity.DepartmentTable;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentTable, Integer> {

}
