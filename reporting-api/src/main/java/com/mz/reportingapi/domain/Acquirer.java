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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Acquirer {

	@Id
	private Integer id;
	private String name;
	private String code;
	private String type; //TODO: maybe enum
	
	@JsonIgnore
	@OneToMany(mappedBy="acquirer")
	private List<Transaction> transactions = new ArrayList<Transaction>();
}
