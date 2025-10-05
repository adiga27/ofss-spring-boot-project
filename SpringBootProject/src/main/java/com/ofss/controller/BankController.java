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

import com.ofss.model.Bank;
import com.ofss.service.BankService;

@RestController
@RequestMapping("/api/v1/admin")
public class BankController {
	@Autowired
	BankService bankService;
	
	@GetMapping("/banks")
	public List<Bank> listAllBanks() {
		return bankService.listBanks();
	}
	@GetMapping("/banks/id/{id}")
	public ResponseEntity<Object> getOneBanks(@PathVariable("id") int bankId) {
		return bankService.getOneBank(bankId);
	}
	@PostMapping("/banks")
	public ResponseEntity<Object> addBanks(@RequestBody Bank body) {
		return bankService.addBank(body);
	}
	@DeleteMapping("/banks/id/{id}")
	public ResponseEntity<String> deleteBank(@PathVariable("id") int bankId){
		return bankService.deleteBank(bankId);
	}
	@PutMapping("/banks/id/{id}")
	public ResponseEntity<String> updateBankAllDetails(@PathVariable("id") int bankId,@RequestBody Bank bank){
		return bankService.updateAllBankDetails(bankId,bank);
	}
	@PatchMapping("/banks/id/{id}")
	public ResponseEntity<String> updateBankDetails(@PathVariable("id") int bankId,@RequestBody Bank bank){
		return bankService.updateBankDetails(bankId,bank);
	}
}
