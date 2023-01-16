package me.wittlage;

public class Main {

	public static void main(String[] args) {
		DemoData.makeData();
		BusinessPractice practice = new BusinessPractice(5);
		
		practice.ageByDays(1);
		practice.isStillGood();
		
		practice.ageByDays(2);
		practice.isStillGood();
	}

}
