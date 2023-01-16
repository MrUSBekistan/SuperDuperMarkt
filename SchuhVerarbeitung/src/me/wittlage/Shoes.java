package me.wittlage;

public class Shoes implements Comparable<Shoes>{
	
	private String name, vendor, color;
	private int id;
	private Double rating, price;
	
	public Shoes(Integer id, String name, String vendor, Double rating, String color, Double price) {
		
		this.id = id;
		this.name = name;
		this.vendor = vendor;
		this.rating = rating;
		this.color = color;
		this.price = price;	
	}

	public String getName() {
		return name;
	}
	
	@Override 
	public String toString() {
		return id + ";" + name + ";" + vendor + ";" + rating + ";" + color + ";" + price + ""+"\n";
	}

	@Override //Sortiert nach Name
	public int compareTo(Shoes o) {
		return name.compareTo(o.getName());
	}
}
