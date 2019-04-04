package com.mz.reportingapi.service;


import java.util.List;

import com.mz.reportingapi.controller.ReportParam;
import com.mz.reportingapi.controller.TransactionListParam;
import com.mz.reportingapi.domain.Transaction;
import com.mz.reportingapi.domain.TransactionSum;

public interface ITransactionsService {
	List<TransactionSum> report( ReportParam pReportParam);
	List<Transaction> getAll();
	Transaction getTransactionByTransactionId(String pTransactionId);
	List<Transaction> list(TransactionListParam pTransactionListParam);
}
