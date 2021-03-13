package com.cg.apps.task1.customerms.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@GeneratedValue
	@Id
	private Long accountId;

	private Double balance;
	private LocalDateTime created;

	public Account() {

	}

	public Account(double balance, LocalDateTime created) {
		this.balance = balance;
		this.created = created;
	}

	public Long getAccountID() {
		return accountId;
	}

	public void setAccountID(Long accountID) {
		this.accountId = accountID;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountId + ", balance=" + balance + ", created=" + created + "]";
	}

}