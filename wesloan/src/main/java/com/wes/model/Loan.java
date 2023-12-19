package com.wes.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "loan")
@Data
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;

	@Column
	private int userId;

	@Enumerated(EnumType.STRING)
	private LoanType type;

	@Enumerated(EnumType.STRING)
	private LoanStatus status;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false, length = 10)
	// @CreatedDate
	private Date createdDate;

	@Column
	private Double amount;

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}
}
