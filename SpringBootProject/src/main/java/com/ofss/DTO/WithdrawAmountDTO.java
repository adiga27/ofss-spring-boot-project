package com.ofss.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WithdrawAmountDTO {
	private double withdrawAmount;

	public WithdrawAmountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WithdrawAmountDTO(double withdrawAmount) {
		super();
		this.withdrawAmount = withdrawAmount;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
}
