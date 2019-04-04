package com.mz.reportingapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {
	@Id
	private Integer id;
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy="merchant")
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
}
