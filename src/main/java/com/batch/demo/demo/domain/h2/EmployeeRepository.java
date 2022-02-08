package com.batch.demo.demo.domain.h2;

import com.batch.demo.demo.domain.h2.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
