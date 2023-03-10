package me.wittlage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


	class DemoData {
	
	public DemoData() {
			makeData();
		}



	//demoProdukte
	private static List<Product> demo = new ArrayList<Product>();
	
	//Produkte
	static Product p1 = new Cheese("Gouda", LocalDate.of(2023, 03, 17), 45 , 4.20);
	static Product p2 = new Cheese("Emmentaler", LocalDate.of(2023, 04, 03), 100 , 3.78);
	static Product p3 = new Wine("Riesling", LocalDate.of(2022, 12, 1), 20 , 10.50);
	static Product p4 = new Wine("Dornfelder", LocalDate.of(2024, 12, 1), 15 , 7.99);
	static Product p5 = new Bread("Pumpernickel", LocalDate.of(2023, 2, 3), 77, 2.25);
	static Product p6 = new Bread("Ciabatta", LocalDate.of(2023, 1, 30), 40, 1.98);	
	
	
	
	static List<Product> getDemo() {
		return demo;
	}



	static void setDemo(List<Product> demo) {
		DemoData.demo = demo;
	}



	public static void makeData() {
			demo.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
			}
}
