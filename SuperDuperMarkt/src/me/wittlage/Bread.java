package me.wittlage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bread extends Product {
	
	private final int minqual = 30;

	public Bread(String name, LocalDate expiry, int quality, double price) {
		super(name, expiry, quality, price);
	}
	
	@Override
	public void ageing(LocalDate today){
		long age = ChronoUnit.DAYS.between(super.getExpiry(), today);
		System.out.print(age+" ");
		long updateQuality = super.getQuality()+age*2;
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
