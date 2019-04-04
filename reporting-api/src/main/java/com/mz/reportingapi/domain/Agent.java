package com.mz.reportingapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agent {
	@Id
	private Integer id;	
	private String customerUserAgent;
	
	/*
	"​agent​"​:​{​"​id​"​:​ ​1,​ ​​"​customerIp​"​:​ ​"192.168.1.2",
	"​customerUserAgent​"​:​ ​"Agent",​ ​​"​merchantIp​"​:​ ​"127.0.0.1",…​}*/
	@JsonIgnore
	@OneToMany(mappedBy="agent")
	private List<Transaction> transactions = new ArrayList<Transaction>();
	@JsonIgnore
	@ManyToOne 
	private Customer customer;
	
}
