package com.capg.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.model.Address;
import com.capg.model.Company;
import com.capg.model.Employee;
import com.capg.repository.AddressRepository;
import com.capg.repository.CompanyRepository;
import com.capg.repository.EmployeeRepository;

@Component								//Test class should be a component then only you can inject it into main
public class TestApplication {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private AddressRepository addressRepository;

	public void saveEmployeeCompanyAndAddress() {
		Employee employee1 = new Employee();
		employee1.setEmployeeId("1250");
		employee1.setEmployeeName("Suvarna");
		employee1.setEmployeePhoneNumber("9886329921");

		Company company = new Company();
		company.setCompanyID("1111");
		company.setCompanyName("Capgemini");
		company.setEmployee(Arrays.asList(employee1));

		Address address = new Address();
		address.setAddressID("250");
		address.setAddressName("Mangalore");
		address.setEmployee(employee1);
		addressRepository.save(address);

		Address address1 = new Address();
		address1.setAddressID("566");
		address1.setAddressName("Bangalore");
		address1.setEmployee(employee1);
		addressRepository.save(address1);

		companyRepository.save(company);

		employee1.setAddress(Arrays.asList(address, address1));

		employee1.setCompany(company);
		employeeRepository.save(employee1);
	}

	public void FindAll() {
		System.out.println(employeeRepository.findAll());
		System.out.println(addressRepository.findAll());
		System.out.println(companyRepository.findAll());

	}

	public void employeeNativeQuery() {
		System.out
				.println(employeeRepository.findByEmployeeIdAndEmployeePhoneNumber("1250", "9886329921").getCompany());
		System.out.println(employeeRepository.findByEmployeePhoneNumber("9886329921"));
	}

	public Object[] getEmployeeSelectedFields() {
		return employeeRepository.findByEmployeeName("Suvarna");

	}

	public void companyNativeQueries() {
		System.out.println(companyRepository.findByEmployeeEmployeeName("Suvarna"));
		System.out.println(companyRepository.findByEmployeeEmployeeNameAndCompanyName("Suvarna", "Capgemini"));
		System.out.println(companyRepository.findByEmployeeAddressAddressName("Mangalore"));
		System.out.println(companyRepository.findByEmployeeAddresfdfgfgsAddressName("Mangalore"));
	}

}
