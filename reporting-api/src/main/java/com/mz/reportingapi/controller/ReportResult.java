package com.mz.reportingapi.controller;

import java.util.List;

import com.mz.reportingapi.domain.TransactionSum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportResult {	
	private String status;
	private List<TransactionSum>  response; 
}
