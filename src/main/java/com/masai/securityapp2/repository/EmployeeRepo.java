package com.masai.securityapp2.repository;

import com.masai.securityapp2.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	public Employee findByUserName(String username);
}
