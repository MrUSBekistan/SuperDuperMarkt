package me.wittlage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wine extends Product {
	
	private final int minqual = 2147483647;

	public Wine(String name, LocalDate expiry, int quality, double price) {
		super(name, expiry, quality, price);
	}

	@Override
	public void ageing(long days){
		long updateQuality;
		if (days%10 == 0) {
			updateQuality = super.getQuality()+days/10;
			//System.out.print("bisher: "+super.getQuality()+" jetzt"+updateQuality);
		}	
		else {
			updateQuality = super.getQuality();
		}
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
