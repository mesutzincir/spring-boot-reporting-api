package com.mz.reportingapi.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)	
	private Integer id; // "​id​"​:​ ​​1​,
	//merchant​ ​:​{
	private String referenceNo; //"​referenceNo​"​:​ ​​"reference_5617ae66281ee"​,
	//private int merchantId;//"​merchantId​"​:​ ​​1​,
	@JsonIgnore
	 @ManyToOne
	 private Merchant merchant;
	
	private String status;//"​status​"​:​ ​​"WAITING"​,
	private String channel;//"​channel​"​:​ ​​"API"​,
	private String customData;//"​customData​"​:​ ​null,
	private String chainId;//"​chainId​"​:​ ​​"5617ae666b4cb"​,
	//private int agentInfoId;//"​agentInfoId​"​:​ ​​1​,
	private String operation;//"​operation​"​:​ ​​"DIRECT"​,
	private int fxTransactionId ;//"​fxTransactionId​"​:​ ​​1​,
	
	private Date updated_at; //"​updated_at​"​:​ ​​"2015-10-09​ ​12:09:12"​,
	
	private Date created_at; //"​created_at​"​:​ ​​"2015-10-09​ ​12:09:10"​,	
	private String acquirerTransactionId; //"​acquirerTransactionId​"​:​ ​​1​,
	@JsonIgnore
	@ManyToOne
	private Acquirer acquirer;
	//private int acquirerId;
	private String code; //"​code​"​:​ ​​"00"​,
	private String message; //"​message​"​:​ ​​"Waiting"​,
	private String transactionId; // "​transactionId​"​:​ ​​"1-1444392550-1"​,
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	//private int agentId;
	@JsonIgnore
	@ManyToOne
	private Agent agent;
	private String customerIp;
	private String merchantIp;
	
	/*
	"​agent​"​:​{​"​id​"​:​ ​1,​ ​​"​customerIp​"​:​ ​"192.168.1.2",
	"​customerUserAgent​"​:​ ​"Agent",​ ​​"​merchantIp​"​:​ ​"127.0.0.1",…​}*/
	
	private int  originalAmount;
	private String originalCurrency;
	/*
	 fx​"​:​{
"​merchant​"​:​{
"​originalAmount​"​:​ ​​100​,
"​originalCurrency​"​:​ ​​"EUR"
	 */
}
