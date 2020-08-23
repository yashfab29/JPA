package com.capgemini.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.capgemini.bean.Account;
import com.capgemini.bean.Loan;

public interface IDao {
	
	EntityManager getConnection();
	void createAccount(Account account) throws SQLException;
	Account getDetails(String accountId);
	Loan getLoan(String loanId,String loanType,Double loanAmount);
	Loan showLoanDetails(Loan loan);
	Double withdrawAmount(String AccountId, Integer amount);
	Loan payLoan(Loan loan,Double loanamount);
	Double depositAmount(String AccountId, Integer amount);

}
