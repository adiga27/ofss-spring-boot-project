package com.ofss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ofss.model.Bank;
import com.ofss.model.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;
	
	public ResponseEntity<Object> addBank(Bank bank){
		Bank newBank = bankRepository.save(bank);
		if(newBank.getBankId() != 0) {
			return ResponseEntity.ok("Bank added successfully!");			
		}
		return ResponseEntity.ok("Bank is not added, add proper payload");	
	}
	
	public List<Bank> listBanks() {
		ArrayList<Bank> allBanks=new ArrayList<>();
		bankRepository.findAll().forEach(bank -> allBanks.add(bank));
		return allBanks;
	}

	public ResponseEntity<Object> getOneBank(int bankId){
		return ResponseEntity.ok(bankRepository.findById(bankId));
	}
	
	public ResponseEntity<String> deleteBank(int bankId){
		if(bankRepository.existsById(bankId)) {
			bankRepository.deleteById(bankId);			
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");		
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank not found");
	}
	
	public ResponseEntity<String> updateAllBankDetails(int bankId, Bank updateBankData){
		
		Optional<Bank> optionalBank = bankRepository.findById(bankId);
		
        if (optionalBank.isPresent()) {
            Bank bank = optionalBank.get();
            bank.setBankName(updateBankData.getBankName());
            bank.setBranchName(updateBankData.getBranchName());
            bank.setIfscCode(updateBankData.getIfscCode());

            bankRepository.save(bank);
            return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
        }
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank not found");
        
	}
	
	public ResponseEntity<String> updateBankDetails(int bankId, Bank updateBankData){
		
		Optional<Bank> optionalBank = bankRepository.findById(bankId);
		
        if (optionalBank.isPresent()) {
            Bank bank = optionalBank.get();
            if(updateBankData.getBankName()!=null) {
            	bank.setBankName(updateBankData.getBankName());            	
            }
            if(updateBankData.getBranchName()!=null) {
            	bank.setBranchName(updateBankData.getBranchName());            	
            }
            if(updateBankData.getIfscCode()!=null) {
            	bank.setIfscCode(updateBankData.getIfscCode());            	
            }

            bankRepository.save(bank);
            return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
        }
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bank not found");
        
	}
}

