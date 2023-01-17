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
	
	public void ageing(long days){
		long updateQuality = getQuality()-(days);
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
		/*if(getQuality() < minqual || getExpiry().equals(LocalDate.now())) {
			return false;
		}
		else 
		{
			return true;
		}*/
		return true;
	}
	
	
	@Override
		public String toString() {
			String out = "Name: "+getName()+" \n"+"Ablauf: "+getExpiry()+" \n"+"Qualität: "+getQuality()+" \n"+"Preis: " +getDayprice()+ " \n"+ " \n";
			return out;
		}
	
}
