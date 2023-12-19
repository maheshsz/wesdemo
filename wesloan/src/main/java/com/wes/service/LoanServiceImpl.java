package com.wes.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.model.Loan;
import com.wes.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Override
	public Loan apply(Loan loan) {
		return loanRepository.save(loan);
	}

	@Override
	public List<Loan> fetchAllLoans() {

		return loanRepository.findAll();
	}

	@Override
	public Loan getLoanById(Long id) {
		Optional<Loan> loan = loanRepository.findById(id);
		if (loan.isPresent()) {
			return loan.get();
		}
		return null;
	}

	@Override
	public String deleteLoanById(Long id) {

		if (loanRepository.findById(id).isPresent()) {
			loanRepository.deleteById(id);
			return "Loan deleted successfully";
		}
		return "No such Loan Exist";
	}

	@Override
	public Loan updateLoanById(Long id, Loan loan) {

		Optional<Loan> loanDetails = loanRepository.findById(id);
		if (loanDetails.isPresent()) {
			Loan originalLoan = loanDetails.get();
			if (Objects.nonNull(loan.getType())) {
				originalLoan.setType(loan.getType());
			}
			if (Objects.nonNull(loan.getStatus())) {
				originalLoan.setStatus(loan.getStatus());
			}
			return loanRepository.save(originalLoan);
		}
		return null;
	}

}
