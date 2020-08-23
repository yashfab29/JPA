package com.capgemini.bean;

import javax.persistence.Entity;

@Entity
public class Transaction extends Loan {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8434583293547246858L;
	Double amount;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + "]";
	}

	public Double depositAmount(String AccountId, Integer amount) {
		return (dao.depositAmount(AccountId, amount));
	}

	public Double withdrawAmount(String accountId, Integer amount) {
		return (dao.withdrawAmount(accountId,amount));
	}

	public Loan payLoan(Loan loan,Double loanamount) {
		return(dao.payLoan(loan,loanamount));
	}

	public void showAccountDetails() {

	}

}
