package me.wittlage;

public class Main {

	public static void main(String[] args) {

		int n;
		DemoData.makeData();
		BusinessPractice practice = new BusinessPractice(0);
		
		if(args.length != 0) 
		{
			n = Integer.parseInt(args[0]);
			for(int i=1;i<n+1;i++){
				practice.ageByDays(i);
			} 
		}
	}
}
