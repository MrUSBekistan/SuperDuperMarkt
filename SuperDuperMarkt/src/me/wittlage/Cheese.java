package me.wittlage;

import java.time.LocalDate;

public class Cheese extends Product {

	final int minqual = 30;
	
	
	public Cheese(String name, LocalDate expiry, int quality, double price) {
			super(name, expiry, quality, price);
		}

	@Override
	public boolean stillgood() {
		if(getQuality() < minqual || getExpiry().equals(LocalDate.now())) {
			return false;
		}
		else 
		{
			return true;
		}
	}
}