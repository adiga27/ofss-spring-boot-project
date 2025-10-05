package com.ofss.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepositAmountDTO {
	private double depositAmount;

	public DepositAmountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public DepositAmountDTO(double depositAmount) {
		super();
		this.depositAmount = depositAmount;
	}
	
}
