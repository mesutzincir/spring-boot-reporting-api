package com.mz.reportingapi.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	private Integer id;//"​id​"​:​ ​​1​,
	private Date created_at; //"​created_at​"​:​ ​​"2015-10-09​ ​12:09:10"​,
	private Date updated_at; //"​updated_at​"​:​ ​​"2015-10-09​ ​12:09:10"​,
	private Date deleted_at;//"​deleted_at​"​:​ ​null,
	private String number; //"​number​"​:​ ​​"401288XXXXXX1881"​,
	private Integer expiryMonth;//"​expiryMonth​"​:​ ​​"6"​,
	private Integer expiryYear; //"​expiryYear​"​:​ ​​"2017"​,
	private Integer startMonth;// "​startMonth​"​:​ ​null,
	private Integer startYear;//"​startYear​"​:​ ​null,
	private Integer issueNumber;//"​issueNumber​"​:​ ​null,
	private String email; //"​email​"​:​ ​​"michael@gmail.com"​,
	
	private Date birthday;//"​birthday​"​:​ ​​"1986-03-20​ ​12:09:10"​,
	private String gender; //"​gender​"​:​ ​null,
	private String billingTitle;//"​billingTitle​"​:​ ​null,
	private String billingFirstName;//"​billingFirstName​"​:​ ​​"Michael"​,
	private String billingLastName;//"​billingLastName​"​:​ ​​"Kara"​,
	private String billingCompany;//"​billingCompany​"​:​ ​null,
	private String billingAddress1;//"​billingAddress1​"​:​ ​​"test​ ​address"​,
	private String billingAddress2;//"​billingAddress2​"​:​ ​null,
	private String billingCity;//"​billingCity​"​:​ ​​"Antalya"​,
	private String billingPostcode;//"​billingPostcode​"​:​ ​​"07070"​,
	private String billingState;//"​billingState​"​:​ ​null,
	private String billingCountry;//"​billingCountry​"​:​ ​​"TR"​,
	private String billingPhone;//"​billingPhone​"​:​ ​null,
	private String billingFax;//"​billingFax​"​:​ ​null,
	private String shippingTitle;//"​shippingTitle​"​:​ ​null,
	private String shippingFirstName;//"​shippingFirstName​"​:​ ​​"Michael"​,
	private String shippingLastName;//"​shippingLastName​"​:​ ​​"Kara"​,
	private String shippingCompany;//"​shippingCompany​"​:​ ​null,
	private String shippingAddress1;//"​shippingAddress1​"​:​ ​​"test​ ​address"​,
	private String shippingAddress2;//"​shippingAddress2​"​:​ ​null,
	private String shippingCity;//"​shippingCity​"​:​ ​​"Antalya"​,
	private String shippingPostcode;//"​shippingPostcode​"​:​ ​​"07070"​,
	private String shippingState;//"​shippingState​"​:​ ​null,
	private String shippingCountry;//"​shippingCountry​"​:​ ​​"TR"​,
	private String shippingPhone;//"​shippingPhone​"​:​ ​null,
	private String shippingFax;//"​shippingFax​"​:​ ​null
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Transaction> transactions = new ArrayList<Transaction>();
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Agent> agents = new ArrayList<Agent>();
}
