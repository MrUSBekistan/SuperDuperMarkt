package me.wittlage;

import java.time.LocalDate;

public class BusinessPractice {
	
	LocalDate today = LocalDate.now();
	int agingdays;
	
	public BusinessPractice(int agingdays) {
		super();
		this.agingdays = agingdays;
	}
	
	
	public void setToday(LocalDate today) {
		this.today = today;
	}
	public int getAgingdays() {
		return agingdays;
	}
	public void setAgingdays(int agingdays) {
		this.agingdays = agingdays;
	}
	
	/*
 	public void ageToDate(LocalDate date) {
		for(Product p : DemoData.demo) {
			p.ageing(date);
			System.out.print(p.getName()+" aged +1 ");
		}
	}
	*/
	
	public void ageByDays(long days) {
		LocalDate datumundtage = today.plusDays(days);
		System.out.print("Status der Produktpalette am "+datumundtage+" \n");
		
		for(Product p : DemoData.demo) {
			p.ageing(days);
			System.out.print(p);
		}
	}
	
	public void isStillGood() {
		for(Product p : DemoData.demo) {
			p.stillgood();
		}
	}
	
}
