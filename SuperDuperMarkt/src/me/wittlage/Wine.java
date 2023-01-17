package me.wittlage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wine extends Product {
	
	private final int minqual = 2147483647;

	public Wine(String name, LocalDate expiry, int quality, double price) {
		super(name, expiry, quality, price);
	}

	@Override
	public void ageing(LocalDate today){
		long age = ChronoUnit.DAYS.between(super.getExpiry(), today);
		System.out.print(age+ " ");
		long updateQuality = super.getQuality()+age;
		super.setQuality(updateQuality);
	};
	
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
