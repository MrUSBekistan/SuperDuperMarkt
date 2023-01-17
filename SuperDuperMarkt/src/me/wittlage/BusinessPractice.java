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
	
	public void ageToDate(LocalDate date) {
		for(Product p : DemoData.demo) {
			p.ageing(date);
			System.out.print(p.getName()+" aged +1 ");
		}
	}
	
	public void ageByDays(long days) {
		for(Product p : DemoData.demo) {
			p.ageing(today.plusDays(days));
			LocalDate datumundtage = today.plusDays(days);
			System.out.print(datumundtage+" ");
			System.out.print(p.getName()+" "+p.getQuality()+" \n");
		}
	}
	
	public void isStillGood() {
		for(Product p : DemoData.demo) {
			p.stillgood();
		}
	}
	
}
