package com.mz.reportingapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mz.reportingapi.domain.Transaction;
import com.mz.reportingapi.domain.TransactionSum;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	Transaction findByTransactionId(String transactionId);
	
	@Query("SELECT new com.mz.reportingapi.domain.TransactionSum("
			+ " t.originalCurrency as currency, COUNT(t.originalCurrency) as count, SUM(t.originalAmount) as total) " + 		
			 " FROM Transaction t " + 
			" WHERE t.created_at >= :pFromDate AND t.created_at <= :pToDate "+
			" AND t.merchant.id = :pMerchant AND t.acquirer.id = :pAcquirer "+
			" GROUP BY t.originalCurrency " + 			
			" ORDER BY t.originalCurrency ")
	List<TransactionSum> GetTransactionSum(@Param("pFromDate") Date pFromDate, 
			@Param("pToDate") Date pToDate,
			@Param("pMerchant") int pMerchant,
			@Param("pAcquirer")int pAcquirer);
}
