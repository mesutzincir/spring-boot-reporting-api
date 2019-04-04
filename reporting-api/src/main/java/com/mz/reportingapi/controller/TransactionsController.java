package com.mz.reportingapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mz.reportingapi.domain.Transaction;
import com.mz.reportingapi.service.ITransactionsService;

@RestController
@RequestMapping(MapApiEndPoint.baseUrl)
public class TransactionsController {

	@Autowired
	ITransactionsService transectionsService;

	@PostMapping("/transaction/report")
	public ReportResult report(@RequestBody ReportParam pReportParam) {
		ReportResult res = new ReportResult();
		res.setStatus("APPROVED");
		res.setResponse(transectionsService.report(pReportParam));
		return res;
	}
    
	@PostMapping("transaction")
	public TransactionDetail getTransactionByTransactionId(@RequestBody TransactionIDParam param) {
		
		Transaction transaction = transectionsService.getTransactionByTransactionId(param.getTransactionId());

		TransactionDetail detail = new TransactionDetail();
				
		
		detail.setCustomerInfo(transaction.getCustomer());
		FxData fx = new FxData();
		fx.setMerchant(new FxDataMerchant());
		fx.getMerchant().setOriginalAmount(transaction.getOriginalAmount());
		fx.getMerchant().setOriginalCurrency(transaction.getOriginalCurrency());
		detail.setFx(fx);
		
		Map<String, String> merchant= new HashMap<>();
		merchant.put("name", transaction.getMerchant().getName());
		detail.setMerchant(merchant);
		
		Map<String, String> mapMerchant = new HashMap<>();
		mapMerchant.put("referenceNo", transaction.getReferenceNo());
		mapMerchant.put("merchantId", transaction.getMerchant().getId().toString());
		mapMerchant.put("status", transaction.getStatus());
		mapMerchant.put("channel", transaction.getStatus());
		mapMerchant.put("customData", transaction.getCustomData());
		mapMerchant.put("chainId", transaction.getChainId());
		mapMerchant.put("agentInfoId", transaction.getAgent().getId().toString());
		
		mapMerchant.put("operation", transaction.getOperation());
		mapMerchant.put("fxTransactionId", ""+transaction.getFxTransactionId());
		mapMerchant.put("updated_at", transaction.getUpdated_at().toString());
		mapMerchant.put("created_at", transaction.getCreated_at().toString());
		mapMerchant.put("id", transaction.getId().toString());
		mapMerchant.put("acquirerTransactionId", transaction.getAcquirerTransactionId());
		mapMerchant.put("code", transaction.getCode());
		mapMerchant.put("message", transaction.getMessage());
		mapMerchant.put("transactionId", transaction.getTransactionId());

		
		Map<String, Map<String, String>> transectionMerchant= new HashMap<>();
		
		transectionMerchant.put("merchant", mapMerchant);
		detail.setTransaction(transectionMerchant);
		
		return detail;
	}

	@GetMapping("transaction/get-all")
	public ArrayList<TransactionInfo> getAll() {
		List<Transaction> listTransaction = transectionsService.getAll();
		ArrayList<TransactionInfo> arr = new ArrayList<TransactionInfo>();
		for (Transaction transaction : listTransaction) {
			TransactionInfo info = new TransactionInfo(transaction.getId(), transaction.getReferenceNo(),
					transaction.getMerchant().getId(), transaction.getStatus(), transaction.getChannel(),
					transaction.getCustomData(), transaction.getChainId(), transaction.getOperation(),
					transaction.getFxTransactionId(), transaction.getUpdated_at(), transaction.getCreated_at(),
					transaction.getAcquirerTransactionId(), transaction.getAcquirer().getId(), transaction.getCode(),
					transaction.getMessage(), transaction.getTransactionId(), transaction.getCustomer().getId(),
					transaction.getAgent().getId(), transaction.getCustomerIp(), transaction.getMerchantIp(),
					transaction.getOriginalAmount(), transaction.getOriginalCurrency());
			arr.add(info);
		}
		return arr;
	}

	@PostMapping("transaction/list")
	public ArrayList<TransactionListInfo> list(@RequestBody TransactionListParam pTransactionListParam) {
		List<Transaction> listTransaction = transectionsService.list(pTransactionListParam);
		
		ArrayList<TransactionListInfo> arr = new ArrayList<TransactionListInfo>();
		for (Transaction transaction : listTransaction) {
			TransactionListInfo tInfoData = new TransactionListInfo();
			tInfoData.setCurrent_page(pTransactionListParam.getPage());
			tInfoData.setFrom(1);
			tInfoData.setTo(50);
			
			if (pTransactionListParam.getPage()!= null && pTransactionListParam.getPage() > 1) {
				// TODO: url
				tInfoData.setPrev_page_url(MapApiEndPoint.baseUrl);
			}
			
			// TODO: url
			tInfoData.setNext_page_url(MapApiEndPoint.baseUrl);
			TransactionListInfoData listInfData = new TransactionListInfoData();
			
			tInfoData.getData().add(listInfData);

			ModelMapper modelMapper = new ModelMapper();
			// user here is a prepopulated User instance
			AcquirerInfo acquirer = modelMapper.map(transaction.getAcquirer(), AcquirerInfo.class);
			listInfData.setAcquirer(acquirer);
			CustomerInfo customerInfo = modelMapper.map(transaction.getCustomer(), CustomerInfo.class);
			listInfData.setCustomerInfo(customerInfo);
			FxData fx = new FxData();
			fx.setMerchant(new FxDataMerchant());
			fx.getMerchant().setOriginalAmount(transaction.getOriginalAmount());
			fx.getMerchant().setOriginalCurrency(transaction.getOriginalCurrency());
			listInfData.setFx(fx);
			IpnInfo ipn = new IpnInfo(true);
			listInfData.setIpn(ipn);
			listInfData.setRefundable(true);
			TransactionListInfoDataT infoT = new TransactionListInfoDataT();
			MerchantInfo minfo = modelMapper.map(transaction.getMerchant(), MerchantInfo.class);
			infoT.setMerchant(minfo);
			listInfData.setTransaction(infoT);
			arr.add(tInfoData);
		}
		return arr;
	}
}
