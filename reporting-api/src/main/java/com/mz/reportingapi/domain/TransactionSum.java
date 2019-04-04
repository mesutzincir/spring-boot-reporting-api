package com.mz.reportingapi.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionSum {
	Long count;
	Long total;
	String currency;
	public TransactionSum() {
		
	}
	public TransactionSum(String pcurrency, Long pcount, Long ptotal)
	{
		currency=pcurrency;
		count=pcount;
		total= ptotal;
	}
}
