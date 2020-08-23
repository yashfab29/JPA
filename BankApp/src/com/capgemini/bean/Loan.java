package com.capgemini.bean;

import javax.persistence.Entity;

@Entity
public class Loan extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	Integer loanId;
	Double loanAmount;
	String loanType;

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Loan getLoan(String loanId,String loanType,Double loanAmount) {
		return(dao.getLoan(loanId,loanType,loanAmount));
	}

	public Loan showLoanDetails(Loan loan) {
		return(dao.showLoanDetails(loan));
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", loanType=" + loanType + "]";
	}
	

}
