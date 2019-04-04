package com.mz.reportingapi.controller;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionListInfo {
Integer per_page=50;
Integer current_page=0;
String next_page_url;
String prev_page_url;
Integer from;
Integer to;
ArrayList<TransactionListInfoData> data= new ArrayList<TransactionListInfoData>();
}
