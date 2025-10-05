package com.ofss.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ofss.DTO.TransactionResponseDTO;
import com.ofss.model.Account;
import com.ofss.model.AccountRepository;
import com.ofss.model.Transaction;
import com.ofss.model.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	public ResponseEntity<Object> depositMoney(int accountId, double depositAmount) {
		Optional<Account> optionalAccount = accountRepository.findById(accountId);
		if (optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			double balance = account.getBalance();
			double totalBalance = depositAmount + balance;
			Map<String, Object> amount = new HashMap<>();
			amount.put("balance", balance);
			amount.put("deposit", depositAmount);
			amount.put("Total Balance", totalBalance);
			if (depositAmount > 0) {
				Transaction transaction = new Transaction(account.getCustId(), account.getAccountNumber(),
						LocalDate.now(), "DEPOSIT", depositAmount);
				account.setBalance(totalBalance);
				accountRepository.save(account);
				transactionRepository.save(transaction);
				amount.put("transaction", transaction);
				return ResponseEntity.status(HttpStatus.OK).body(amount);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Deposited Amount should be greater than 0");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("account not found");
	}

	public ResponseEntity<Object> withdrawMoney(int accountId, double withdrawAmount) {
		Optional<Account> optionalAccount = accountRepository.findById(accountId);

		if (optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			double balance = account.getBalance();
			double totalBalance =  balance-withdrawAmount;
			Map<String, Object> amount = new HashMap<>();
			amount.put("balance", balance);
			amount.put("withdraw", withdrawAmount);
			amount.put("Total Balance", totalBalance);
			if (withdrawAmount > 0) {
				Transaction transaction = new Transaction(account.getCustId(), account.getAccountNumber(),
						LocalDate.now(), "WITHDRAW", withdrawAmount);
				account.setBalance(totalBalance);
				accountRepository.save(account);
				transactionRepository.save(transaction);
				amount.put("transaction", transaction);
				return ResponseEntity.status(HttpStatus.OK).body(amount);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Withdraw Amount should be greater than 0");

		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("account not found");
	}

	public ResponseEntity<Object> transferMoney(int fromAccountId, int toAccountId, double transferAmount) {
		Optional<Account> fromAccount = accountRepository.findById(fromAccountId);
		Optional<Account> toAccount = accountRepository.findById(toAccountId);

		if (fromAccount.isPresent()) {
			Account accountFrom = fromAccount.get();
			Account accountTo = toAccount.get();
			
			double fromAccountBalance = accountFrom.getBalance();
			double toAccountBalance = accountTo.getBalance();

			double totalFromAccountBalance = fromAccountBalance - transferAmount;
			double totalToAccountBalance = toAccountBalance + transferAmount;
			
			TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
			
			transactionResponseDTO.setFromAccountBalance(fromAccountBalance);
			transactionResponseDTO.setTransferAmount(transferAmount);
			transactionResponseDTO.setToAccountBalance(toAccountBalance);
			transactionResponseDTO.setTotalFromAccountBalance(totalFromAccountBalance);
			transactionResponseDTO.setTotalToAccountBalance(totalToAccountBalance);
			
			if (transferAmount > 0) {
				accountTo.setBalance(totalToAccountBalance);
				Transaction transaction = new Transaction(accountFrom.getCustId(), accountTo.getAccountNumber(),
						LocalDate.now(), "TRANSFER", transferAmount);
				accountFrom.setBalance(totalFromAccountBalance);
				accountRepository.save(accountFrom);
				accountRepository.save(accountTo);
				transactionRepository.save(transaction);
				
				transactionResponseDTO.setTransaction(transaction);
				return ResponseEntity.status(HttpStatus.OK).body(transactionResponseDTO);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Transfer Amount should be greater than 0");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("account not found");
	}

}
