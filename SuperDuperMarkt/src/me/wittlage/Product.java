package me.wittlage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Product {	//Produkt

	private String name;
	private LocalDate expiry;
	private long quality;
	private double baseprice;
	private double dayprice;
	
	public Product(String name, LocalDate expiry, int quality, double baseprice) {
		super();
		this.name = name;
		this.expiry = expiry;
		this.quality = quality;
		this.baseprice= baseprice;
	}
	
	public void ageing(LocalDate today){
		long age = ChronoUnit.DAYS.between(getExpiry(), today);
		System.out.print(age+" ");//zeit bis zum ablauf
		long updateQuality = getQuality()-(age);
		setQuality(updateQuality);
	};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getExpiry() {
		return expiry;
	}
	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}
	
	public long getQuality() {
		return quality;
	}
	public void setQuality(long updateQuality) {
		this.quality = updateQuality;
	
	}
	
	public double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}

	public double getDayprice() {
		setDayprice();
		Double round = Math.round(dayprice * 100.0) / 100.0;
		return round;
	}
	public void setDayprice() {
		 /* der Faktor Qualität muss noch rein*/
		dayprice = baseprice+(0.1*getQuality());
	}

	public boolean stillgood() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
