package com.cg.apps.task1.customerms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.task1.customerms.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long>{

}