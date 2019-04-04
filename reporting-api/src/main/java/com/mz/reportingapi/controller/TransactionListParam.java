package com.mz.reportingapi.controller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionListParam {
	private Date fromDate;
	private Date toDate;
	private Integer merchantId;
	private Integer acquirerId;
	String status;
	String operation;
	String  paymentMethod;
	String filterField;
	String filterValue;
	Integer page;
}
