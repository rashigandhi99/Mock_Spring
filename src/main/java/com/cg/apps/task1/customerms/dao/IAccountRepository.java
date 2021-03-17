package com.cg.apps.task1.customerms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.task1.customerms.entities.Account;

public interface IAccountRepository extends JpaRepository<Account,Long>  {

}
