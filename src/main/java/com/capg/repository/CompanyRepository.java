package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {
	Company findByEmployeeEmployeeName(String name);
	Company findByEmployeeEmployeeNameAndCompanyName(String ename,String cname);
	
	Company findByEmployeeAddressAddressName(String aname);
	
	@Query("SELECT com from Company com,Employee emp, Address add where add.addressName=?1")
	Company findByEmployeeAddresfdfgfgsAddressName(String aname);	//Here priority is given to hql query and native query is not checked

}
