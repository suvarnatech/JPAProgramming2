package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	Employee findByEmployeeIdAndEmployeePhoneNumber(String employeeId, String employeePhoneNumber);

	Employee findByEmployeePhoneNumber(String employeePhoneNumber);
	
	@Query("SELECT employeeName, employeePhoneNumber from Employee where employeeName=?1")
	Object[] findByEmployeeName(String employeeName);
	

}
