package me.wittlage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bread extends Product {

	public Bread(String name, LocalDate expiry, int quality, double price) {
		super(name, expiry, quality, price);
	}

	public void ageing(){
		long age = ChronoUnit.DAYS.between(super.getExpiry(), LocalDate.now());
		System.out.print(age);
		long updateQuality = super.getQuality()+(int)age;
		super.setQuality(updateQuality);
	};
}
