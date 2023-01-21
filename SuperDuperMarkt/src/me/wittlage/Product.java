package me.wittlage;

import java.time.LocalDate;

public class Product implements Comparable<Product> {	//Produkt

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
	
	public boolean stillgood() {
		return true;
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
		dayprice = baseprice+(0.1*getQuality());
	}
	
	@Override
		public String toString() {
			String out = " "+getName()+" hat eine Qualität von "+getQuality()+ 
					" und kostet " +getDayprice()+ "€"+
					(stillgood() ? ", die Haltbarkeit ist noch gut" : ", sollte aus dem Regal genommen werden") +" \n";
			return out;
		}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
