package com.wes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wes.model.Loan;
import com.wes.service.LoanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@PostMapping(value = "/loan", consumes = { /* MediaType.APPLICATION_JSON_VALUE, */
			MediaType.APPLICATION_XML_VALUE }, produces = { /* MediaType.APPLICATION_JSON_VALUE, */
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Loan> applyLoan(@RequestBody @Valid Loan loan) {
		Loan apply = loanService.apply(loan);
		return ResponseEntity.status(HttpStatus.CREATED).body(apply);
	}

	@GetMapping(value = "/loan", consumes = { /* MediaType.APPLICATION_JSON_VALUE, */
			MediaType.APPLICATION_XML_VALUE }, produces = { /* MediaType.APPLICATION_JSON_VALUE, */
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Loan>> getAllLoans() {

		List<Loan> fetchAllLoans = loanService.fetchAllLoans();
		return ResponseEntity.status(HttpStatus.OK).body(fetchAllLoans);
	}

	@GetMapping(value = "/loan/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { /* MediaType.APPLICATION_JSON_VALUE, */
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Loan> getLoanById(@PathVariable("id") Long id) {

		Loan loanById = loanService.getLoanById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(loanById);
	}
	
	@PutMapping(value = "/loan/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { /* MediaType.APPLICATION_JSON_VALUE, */
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Loan> updateLoan(@PathVariable("id") Long id, @RequestBody Loan loan) {
		Loan updateLoan = loanService.updateLoanById(id, loan);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateLoan);
	}

	@DeleteMapping(value = "/loan/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { /* MediaType.APPLICATION_JSON_VALUE, */
					MediaType.APPLICATION_XML_VALUE })
	public String deleteLoan(@PathVariable("id") Long id) {
		return loanService.deleteLoanById(id);
	}
}
