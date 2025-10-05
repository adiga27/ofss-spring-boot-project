package com.ofss.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferAmountDTO {
	private double transferAmount;

	public TransferAmountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferAmountDTO(double transferAmount) {
		super();
		this.transferAmount = transferAmount;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	
}
