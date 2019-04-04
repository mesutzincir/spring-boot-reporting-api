package com.mz.reportingapi.controller;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInfo {

	private Integer id; // "​id​"​:​ ​​1​,
	//merchant​ ​:​{
	private String referenceNo; //"​referenceNo​"​:​ ​​"reference_5617ae66281ee"​,
	
	 private Integer merchantId;
	private String status;//"​status​"​:​ ​​"WAITING"​,
	private String channel;//"​channel​"​:​ ​​"API"​,
	private String customData;//"​customData​"​:​ ​null,
	private String chainId;//"​chainId​"​:​ ​​"5617ae666b4cb"​,
	//private int agentInfoId;//"​agentInfoId​"​:​ ​​1​,
	private String operation;//"​operation​"​:​ ​​"DIRECT"​,
	private int fxTransactionId ;//"​fxTransactionId​"​:​ ​​1​,
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date updated_at; //"​updated_at​"​:​ ​​"2015-10-09​ ​12:09:12"​,
	
	private Date created_at; //"​created_at​"​:​ ​​"2015-10-09​ ​12:09:10"​,	
	private String acquirerTransactionId; //"​acquirerTransactionId​"​:​ ​​1​,
	
	private Integer acquirerId;
	//private int acquirerId;
	private String code; //"​code​"​:​ ​​"00"​,
	private String message; //"​message​"​:​ ​​"Waiting"​,
	private String transactionId; // "​transactionId​"​:​ ​​"1-1444392550-1"​,
	@ManyToOne
	private Integer customerId;
	//private int agentId;

	private Integer agentId;
	private String customerIp;
	private String merchantIp;
	
	/*
	"​agent​"​:​{​"​id​"​:​ ​1,​ ​​"​customerIp​"​:​ ​"192.168.1.2",
	"​customerUserAgent​"​:​ ​"Agent",​ ​​"​merchantIp​"​:​ ​"127.0.0.1",…​}*/
	
	private int  originalAmount;
	private String originalCurrency;
}
