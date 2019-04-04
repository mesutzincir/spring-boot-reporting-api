package com.mz.reportingapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.reportingapi.controller.ReportParam;
import com.mz.reportingapi.controller.TransactionListParam;
import com.mz.reportingapi.domain.Transaction;
import com.mz.reportingapi.domain.TransactionSum;
import com.mz.reportingapi.repository.TransactionRepository;

@Service
public class TransactionsService implements ITransactionsService {

	@Autowired
	TransactionRepository transactionRepository;
	@Override
	public List<TransactionSum> report(ReportParam pReportParam) {
		List<TransactionSum> arrayTransaction = 
				transactionRepository.GetTransactionSum(pReportParam.getFromDate(),
				pReportParam.getToDate(), pReportParam.getMerchant(), 
				pReportParam.getAcquirer());
		return arrayTransaction;
	}
	
	public List<Transaction> getAll()
	{
		return transactionRepository.findAll();
	}

	@Override
	public Transaction getTransactionByTransactionId(String pTransactionId) {
		Transaction  transaction = transactionRepository.findByTransactionId(pTransactionId);
		//Transaction  transaction = transactionRepository.findById(1).get();
		return transaction;
	}

	@Override
	public List<Transaction> list(TransactionListParam pTransactionListParam) {
		List<Transaction> listTransaction = transactionRepository.findAll();
		Stream<Transaction> streamTransaction = listTransaction.stream();
		if (pTransactionListParam.getFromDate() != null) {
			streamTransaction = streamTransaction
					.filter((t) -> t.getCreated_at().compareTo(pTransactionListParam.getFromDate()) >= 0);
		}
		if (pTransactionListParam.getToDate() != null) {
			streamTransaction = streamTransaction
					.filter((t) -> t.getCreated_at().compareTo(pTransactionListParam.getToDate()) <= 0);
		}
		if (pTransactionListParam.getMerchantId() != null) {
			streamTransaction = streamTransaction
					.filter((t) -> t.getMerchant().getId().equals(pTransactionListParam.getMerchantId()));
		}
		if (pTransactionListParam.getAcquirerId() != null) {
			streamTransaction = streamTransaction
					.filter((t) -> t.getAcquirer().getId().equals(pTransactionListParam.getAcquirerId()));
		}
		if (pTransactionListParam.getStatus() != null) {
			streamTransaction = streamTransaction
					.filter((t) -> t.getStatus().equals(pTransactionListParam.getStatus()));
		}
		if (pTransactionListParam.getOperation() != null) {
			streamTransaction = streamTransaction
					.filter((t) -> t.getOperation().equals(pTransactionListParam.getOperation()));
		}
		if (pTransactionListParam.getPaymentMethod() != null) {
			streamTransaction = streamTransaction
					.filter((t) -> t.getAcquirer().getType().equals(pTransactionListParam.getPaymentMethod()));
		}
		listTransaction = streamTransaction.collect(Collectors.toList());
		return listTransaction;
	}

}
