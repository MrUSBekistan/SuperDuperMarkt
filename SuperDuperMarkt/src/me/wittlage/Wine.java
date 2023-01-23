package me.wittlage;

import java.time.LocalDate;

    class Wine extends Product {
	
	private final int maxqual = 50;

	Wine(String name, LocalDate expiry, int quality, double price) {
		super(name, expiry, quality, price);
	}

	@Override
	public void ageing(long days){
		long updateQuality;
		if (days%10 == 0) {
			updateQuality = super.getQuality()+days/10; //nach 10Tagen wird Qualli um 1 erhöht
		}	
		else {
			updateQuality = super.getQuality();
		}
		super.setQuality(updateQuality);
		
		if (updateQuality >= maxqual) { //wenn neue Qualli über maxqual wird Qualli=maxqual gesetzt
			super.setQuality(maxqual);
		}
	};

	@Override
	public boolean stillgood() {
		if(super.getExpiry().equals(LocalDate.now())) {
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	@Override
	public double getDayprice() {
		return super.baseprice;
	}
}
