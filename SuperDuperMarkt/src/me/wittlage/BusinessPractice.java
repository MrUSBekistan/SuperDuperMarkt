package me.wittlage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusinessPractice {
	
	private static LocalDate datumundtage;
	private static LocalDate today = LocalDate.now();
	private static List<String> infobox = new ArrayList<String>();
	
	public void ageByDays(long days) {
		datumundtage = today.plusDays(days);
		System.out.print("Status der Produktpalette am "+datumundtage+" \n");
		infobox.add(" Status der Produktpalette am "+datumundtage+"\n");
		for(Product p : DemoData.getDemo()) {
			p.ageing(days);
			infobox.add(p.toString());
			System.out.print(p);
		}
	}
	
	public static List<String> getInfobox() {
		return infobox;
	}
	
	public static void clearInfobox() {
		infobox.clear();;
	}
	
	public static String formatetInfo() {
		//datumundtage = today.plusDays(days);
		return getInfobox().toString().substring(1, getInfobox().toString().length() - 1).replace(",", ""); 
	}
	
	public void isStillGood() {
		for(Product p : DemoData.getDemo()) {
			p.stillgood();
		}
	}
}
