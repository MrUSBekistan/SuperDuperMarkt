package me.wittlage;

import java.time.LocalDate;

public class BusinessPractice {
	
	LocalDate today = LocalDate.now();
	
	public void setToday(LocalDate today) {
		this.today = today;
	}
	
	public void ageByDays(long days) {
		LocalDate datumundtage = today.plusDays(days);
		System.out.print("Status der Produktpalette am "+datumundtage+" \n");
		
		for(Product p : DemoData.getDemo()) {
			p.ageing(days);
			System.out.print(p);
		}
	}
	
	public void isStillGood() {
		for(Product p : DemoData.getDemo()) {
			p.stillgood();
		}
	}
	
}
