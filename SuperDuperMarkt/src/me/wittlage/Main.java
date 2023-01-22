package me.wittlage;

public class Main {

	public static void main(String[] args) {

		int param;
		BusinessPractice practice = new BusinessPractice();
		
		Gui grafik = new Gui();
		grafik.openGUI();
		
		if(args.length != 0) 
		{
			param = Integer.parseInt(args[0]);
			DemoData.makeData();
			for(int i=1;i<param+1;i++){
				practice.ageByDays(i);
			} 
		}
		
		else {
			System.out.print("Bitte geben Sie zur Konsolennutzung einen Parameter ein! \n");
		}
	}
}
