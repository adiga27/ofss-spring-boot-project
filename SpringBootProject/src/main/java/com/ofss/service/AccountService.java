package com.ofss.service;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ofss.model.AccountRepository;
import com.ofss.model.BankRepository;
import com.ofss.model.CustomerRepository;
import com.ofss.model.Bank;
import com.ofss.model.Customer;
import com.ofss.DTO.AccountResponseDTO;
import com.ofss.model.Account;


@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BankRepository bankRepository;

	public ResponseEntity<Object> addAccount(Account account) {
		account.setAccountCreationDate(LocalDate.now());
		account.setBalance(0);
		Account newAccount = accountRepository.save(account);
		if (newAccount.getAccountNumber() != 0) {
			return ResponseEntity.ok("Account added successfully!");
		}
		return ResponseEntity.ok("Account is not added, add proper payload");		
	}

	public List<AccountResponseDTO> listAccounts() {
		List<AccountResponseDTO> accountDTO = new ArrayList<>();
	    for (Account account : accountRepository.findAll()) {
	        Customer customer = customerRepository.findById(account.getCustId()).orElse(null);
	        Bank bank = bankRepository.findById(account.getBankId()).orElse(null);
	        AccountResponseDTO dto = new AccountResponseDTO(
	        	account.getAccountNumber(),
	            account.getAccountCreationDate(),
	            account.getAccountType(),
	            account.getBalance(),
	            customer,
	            bank
	        );
	        accountDTO.add(dto);
	    }
	    return accountDTO;
	}

	public ResponseEntity<Object> getOneAccount(int accountId) {
		if (accountRepository.existsById(accountId)) {
			Account account = accountRepository.findById(accountId).orElse(null);
			Customer customer = customerRepository.findById(account.getCustId()).orElse(null);
	        Bank bank = bankRepository.findById(account.getBankId()).orElse(null);
			return ResponseEntity.ok(new AccountResponseDTO(
		        	account.getAccountNumber(),
		            account.getAccountCreationDate(),
		            account.getAccountType(),
		            account.getBalance(),
		            customer,
		            bank
		        ));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
	}

	public ResponseEntity<String> deleteAccount(int accountId) {
		if (accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("account not found");
	}

	public ResponseEntity<String> updateAllAccountDetails(int accountId, Account updateAccountData) {

		Optional<Account> optionalAccount = accountRepository.findById(accountId);

		if (optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			account.setAccountType(updateAccountData.getAccountType());
			account.setBalance(updateAccountData.getBalance());

			accountRepository.save(account);
			return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("account not found");

	}

	public ResponseEntity<String> updateAccountDetails(int accountId, Account updateAccountData) {

		Optional<Account> optionalAccount = accountRepository.findById(accountId);

		if (optionalAccount.isPresent()) {
			Account account = optionalAccount.get();
			if (updateAccountData.getAccountType() != null) {
				account.setAccountType(updateAccountData.getAccountType());
			}
			if (updateAccountData.getBalance() != 0) {
				account.setBalance(updateAccountData.getBalance());
			}
			accountRepository.save(account);
			return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("account not found");

	}
}
