package me.wittlage;

import java.time.LocalDate;

public class Cheese extends Product {

	private final int minqual = 30;
	
	
public Cheese(String name, LocalDate expiry, int quality, double price) {
		super(name, expiry, quality, price);
	}
	
	@Override
	public boolean stillgood() {
		if(super.getQuality() < minqual || super.getExpiry().equals(LocalDate.now())) {
			return false;
		}
		else 
		{
			return true;
		}
	}
}
