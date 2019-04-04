package com.mz.reportingapi;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mz.reportingapi.domain.Acquirer;
import com.mz.reportingapi.domain.Agent;
import com.mz.reportingapi.domain.Customer;
import com.mz.reportingapi.domain.Merchant;
import com.mz.reportingapi.domain.Transaction;
import com.mz.reportingapi.domain.UserInfo;
import com.mz.reportingapi.repository.AcquirerRepository;
import com.mz.reportingapi.repository.AgentRepository;
import com.mz.reportingapi.repository.CustomerRepository;
import com.mz.reportingapi.repository.MerchantRepository;
import com.mz.reportingapi.repository.TransactionRepository;
import com.mz.reportingapi.repository.UserInfoRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class ReportingApiApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReportingApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner CreateCommandLineRunner
	(
     AcquirerRepository pAcquirerRepository,
     AgentRepository pAgentRepository,
     CustomerRepository pCustomerRepository,
     MerchantRepository pMerchantRepository,
     TransactionRepository pTransactionRepository,
     UserInfoRepository pUserInfoRepository
	)
	{
		return (args) -> {
			//String testDate = "2015-08-01 23:59:59";
			//DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date("2015/08/01"); //formatter.parse(testDate);
			
			Acquirer acquirer= new Acquirer(12, "Mesut ​Bank", "MB", "CREDITCARD", null);
			pAcquirerRepository.save(acquirer);
			 acquirer= new Acquirer(1, "Mergen​ ​Bank", "MB", "CREDITCARD", null);
			pAcquirerRepository.save(acquirer);
			
			Agent agent= new Agent(1,"Agent​", null, null);
			pAgentRepository.save(agent);
			Customer customer = new Customer(1, date, date, null,
					"401288XXXXXX1881", 6, 2017,
					null, null, null,
					"michael@gmail.com", new Date("2015/08/01"), null,
					null,"Michael", "Kara", null,
					"test​ ​address", null,"Antalya",
					"07070",null, "TR",
					null, null, null,
					"Michael", "Kara", null,
					"test​ ​address", null, "Antalya",
					"07070",null, "TR", null, null, 
					null, null
					);
			pCustomerRepository.save(customer);
			Merchant merchant = new Merchant(1,"DEV-Merchant",null );
			pMerchantRepository.save( merchant);
			Transaction transaction = new Transaction(
					null, "reference_5617ae66281ee", merchant, 
					"WAITING", "API", null, "5617ae666b4cb",
					"DIRECT",1, new Date("2015/08/01"), new Date("2015/08/01"), "1",acquirer,
					"00","Waiting","1-1444392550-1",
					customer, agent, "192.168.1.2", "127.0.0.1",
					100, "USD"
					); 
			pTransactionRepository.save(transaction);
			
			transaction = new Transaction(
					null, "reference_5617ae66281ee", merchant, 
					"WAITING", "API", null, "5617ae666b4cb",
					"DIRECT",1, new Date("2015/08/01"), new Date("2015/08/01"), "1",acquirer,
					"00","Waiting","1-1444392550-2",
					customer, agent, "192.168.1.2", "127.0.0.1",
					150, "USD"
					); 
			pTransactionRepository.save(transaction);
			
			transaction = new Transaction(
					null, "reference_5617ae66281ee", merchant, 
					"WAITING", "API", null, "5617ae666b4cb",
					"DIRECT",1, date, date, "1",acquirer,
					"00","Waiting","1-1444392550-3",
					customer, agent, "192.168.1.2", "127.0.0.1",
					200, "EUR"
					); 
			pTransactionRepository.save(transaction);
			transaction = new Transaction(
					null, "reference_5617ae66281ee", merchant, 
					"WAITING", "API", null, "5617ae666b4cb",
					"DIRECT",1, date, date, "1",acquirer,
					"00","Waiting","1-1444392550-4",
					customer, agent, "192.168.1.2", "127.0.0.1",
					300, "EUR"
					); 
			pTransactionRepository.save(transaction);
			pUserInfoRepository.save(new UserInfo("admin@gmail.com", "password"));
			pUserInfoRepository.save(new UserInfo("merchant@test.com", "123*-+"));
		}; 
	}
}

