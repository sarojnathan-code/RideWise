package com.airtribe.ridewise.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FareReceipt {
	
	private int rideId;

	private BigDecimal amount;

	private LocalDateTime generatedAt;

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}

	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}

	
}
