package com.capgemini.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.bean.Account;
import com.capgemini.bean.Loan;

public class DaoImpl implements IDao{
	public EntityManager em = null;
	
	public void createAccount(Account account) throws SQLException{
		em.getTransaction().begin();
		Query getAccount = em.createNativeQuery("INSERT INTO account VALUES(:accountId, :accountName, :depositAmount, :address", Account.class);
		getAccount.setParameter("accountId", account.getaccountId());
		getAccount.setParameter("accountName", account.getaccountName());
		getAccount.setParameter("depositAmount", account.getDepositAmount());
		getAccount.setParameter("address", account.getAddress());
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public Account getDetails(String accountId) {
		List<Account> accountList;
		em.getTransaction().begin();
		Query getAccount = em.createNativeQuery("SELECT * FROM account where accountId=:accountId", Account.class);
		getAccount.setParameter("accountId", accountId);
		
		while ( (accountList = getAccount.getResultList()) != null ){
			
			for (Account acc: accountList){
				em.getTransaction().commit();
				return acc;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Loan getLoan(String loanId,String loanType,Double loanAmount) {
		List<Loan> loanList;
		em.getTransaction().begin();
		Query getLoan = em.createNativeQuery("select * from  loan where loanId = :loanId and loanType = :loanType and loanAmount = :loanAmount", Loan.class);
		getLoan.setParameter("loanId", loanId);
		getLoan.setParameter("loanType", loanType);
		getLoan.setParameter("loanAmount", loanAmount);;
		
		while ( (loanList = getLoan.getResultList()) != null ){		
			for (Loan loan: loanList){
				em.getTransaction().commit();
				return loan;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Double depositAmount(String accountId, Integer amount) {
		Double bal = 0.0;
		List<Account> accountList;
		em.getTransaction().begin();
		Query getAccount = em.createNativeQuery("SELECT * FROM account where accountId=:accountId", Account.class);
		getAccount.setParameter("accountId", accountId);
		
		while ( getAccount.getResultList() != null ){
			accountList = getAccount.getResultList();
			for (Account acc: accountList){
				bal = acc.getDepositAmount();
				bal = bal + amount;
				acc.setDepositAmount(bal);
				em.getTransaction().commit();
			}
		}
		
		em.getTransaction().begin();
		Query updateAmount = em.createNativeQuery("Update account set depositAmount = :amount", Account.class);
		updateAmount.setParameter("amount", bal);
		em.getTransaction().commit();
        return bal;
}

	@Override
	public EntityManager getConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankApp");
		em = emf.createEntityManager();
		return em;
	}

	@Override
	public Loan showLoanDetails(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Double withdrawAmount(String accountId, Integer amount) {
		Double bal = 0.0;
		List<Account> accountList;
		em.getTransaction().begin();
		Query getAccount = em.createNativeQuery("SELECT * FROM account where accountId=:accountId", Account.class);
		getAccount.setParameter("accountId", accountId);
		
		while ( getAccount.getResultList() != null ){
			accountList = getAccount.getResultList();
			for (Account acc: accountList){
				bal = acc.getDepositAmount();
				bal = bal - amount;
				acc.setDepositAmount(bal);
				em.getTransaction().commit();
			}
		}
		
		em.getTransaction().begin();
		Query updateAmount = em.createNativeQuery("Update account set depositAmount = :amount", Account.class);
		updateAmount.setParameter("amount", bal);
		em.getTransaction().commit();
        return bal;
	}

	@Override
	public Loan payLoan(Loan loan, Double loanamount) {
		// TODO Auto-generated method stub
		return null;
	}
}
