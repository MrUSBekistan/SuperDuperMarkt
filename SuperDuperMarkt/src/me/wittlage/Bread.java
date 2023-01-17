package me.wittlage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bread extends Product {

	public Bread(String name, LocalDate expiry, int quality, double price) {
		super(name, expiry, quality, price);
	}

	@Override
	public void ageing(long days){
		long updateQuality = super.getQuality()-days*2;
		super.setQuality(updateQuality);
	};
}
