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
public class MerchantInfo {
String referenceNo;
String status;
String operation;
String message;
Date created_at;
String transactionId;
}
