package me.wittlage;

import java.time.LocalDate;

public class Bread extends Product {

	long minqual = 30;
	
	public Bread(String name, LocalDate expiry, int quality, double price) {
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
	
	@Override
	public void ageing(long days){
		long updateQuality = super.getQuality()-days*2;
		super.setQuality(updateQuality);
	};
}
