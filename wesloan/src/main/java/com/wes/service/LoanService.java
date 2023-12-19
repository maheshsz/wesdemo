package com.wes.service;

import java.util.List;

import com.wes.model.Loan;

public interface LoanService {
	
	 Loan apply(Loan loan);
	 
	 List<Loan> fetchAllLoans();
	 
	 Loan getLoanById(Long id);
	 
	 Loan updateLoanById(Long id, Loan loan);
	 
	 String deleteLoanById(Long id);

}
