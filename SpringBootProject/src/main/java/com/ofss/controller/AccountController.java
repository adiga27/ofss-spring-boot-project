package com.ofss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.DTO.AccountResponseDTO;
import com.ofss.model.Account;
import com.ofss.service.AccountService;

@RestController
@RequestMapping("/api/v1/admin")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@GetMapping("/accounts")
	public List<AccountResponseDTO> listAllaccounts() {
		return accountService.listAccounts();
	}
	@GetMapping("/accounts/id/{id}")
	public ResponseEntity<Object> getOneaccounts(@PathVariable("id") int accountId) {
		return accountService.getOneAccount(accountId);
	}
	@PostMapping("/accounts")
	public ResponseEntity<Object> addaccounts(@RequestBody Account body) {
		return accountService.addAccount(body);
	}
	@DeleteMapping("/accounts/id/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") int accountId){
		return accountService.deleteAccount(accountId);
	}
	@PutMapping("/accounts/id/{id}")
	public ResponseEntity<String> updateAccountAllDetails(@PathVariable("id") int accountId,@RequestBody Account account){
		return accountService.updateAllAccountDetails(accountId,account);
	}
	@PatchMapping("/accounts/id/{id}")
	public ResponseEntity<String> updateAccountDetails(@PathVariable("id") int accountId,@RequestBody Account account){
		return accountService.updateAccountDetails(accountId,account);
	}
}
