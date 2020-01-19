package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capg.test.TestApplication;

@SpringBootApplication
public class JpaDemo2ProgramApplication implements CommandLineRunner {

	@Autowired
	TestApplication test;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemo2ProgramApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// test.saveEmployeeCompanyAndAddress();
		// test.FindAll();
		//test.employeeNativeQuery();
		// System.out.println(test.getEmployeeSelectedFields()[0]);
		test.companyNativeQueries();
	}

}
