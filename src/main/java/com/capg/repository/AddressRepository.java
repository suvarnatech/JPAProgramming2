package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.model.Address;

public interface AddressRepository extends JpaRepository<Address, String>{

}
