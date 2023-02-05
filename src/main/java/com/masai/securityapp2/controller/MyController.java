package com.masai.securityapp2.controller;

import com.masai.securityapp2.domain.Employee;
import com.masai.securityapp2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@GetMapping("/user")
	public ResponseEntity<String> commonResourse() {
	String msg = "Welcome user..! It's a non secured resource";
	return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	@GetMapping("/secure/user")
	public ResponseEntity<String> securedResourse() {
	String msg = "It's a secured resource";
	return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	@GetMapping("/admin")
	public ResponseEntity<String> admin() {
	return new ResponseEntity<String>("Welcome to Masai App for Admin", HttpStatus.ACCEPTED);
	}
	@PostMapping("/user")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
	//implement the method to persist Employee record in database
	//create required methods in Repository if needed
		Employee emp = employeeRepo.save(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}

}
