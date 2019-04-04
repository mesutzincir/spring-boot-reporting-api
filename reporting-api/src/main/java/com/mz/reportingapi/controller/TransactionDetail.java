package com.mz.reportingapi.controller;

import java.util.Map;

import com.mz.reportingapi.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetail {

	Customer customerInfo;
	FxData fx;
	Map<String, String> merchant;
	Map<String, Map<String, String>> transaction;
}
