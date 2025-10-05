package com.ofss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.DTO.DepositAmountDTO;
import com.ofss.DTO.TransferAmountDTO;
import com.ofss.DTO.WithdrawAmountDTO;
import com.ofss.service.TransactionService;

@RestController
@RequestMapping("/api/v1/user")
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@PostMapping("/deposit/accounts/id/{id}")
	public ResponseEntity<Object> depositAmount(@PathVariable("id") int accountId,
			@RequestBody DepositAmountDTO depositAmount) {
		return transactionService.depositMoney(accountId, depositAmount.getDepositAmount());
	}

	@PostMapping("/withdraw/accounts/id/{id}")
	public ResponseEntity<Object> withdrawAmount(@PathVariable("id") int accountId,
			@RequestBody WithdrawAmountDTO withdrawAmount) {
		return transactionService.withdrawMoney(accountId, withdrawAmount.getWithdrawAmount());
	}

	@PostMapping("/transfer/{fromAccount}/{toAccount}")
	public ResponseEntity<Object> transferAmount(@PathVariable("fromAccount") int fromAccountId,
			@PathVariable("toAccount") int toAccountId, @RequestBody TransferAmountDTO transferAmount) {
		return transactionService.transferMoney(fromAccountId, toAccountId, transferAmount.getTransferAmount());
	}
}
