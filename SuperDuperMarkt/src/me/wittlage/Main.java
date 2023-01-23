package me.wittlage;

public class Main {

	public static void main(String[] args) {

		int param;
		BusinessPractice practice = new BusinessPractice();
		
		
		
		
		if(args.length != 0) 
		{
			try {
				param = Integer.parseInt(args[0]);
				DemoData.makeData();
				for(int i=1;i<param+1;i++){
					practice.ageByDays(i);
				} 
			} catch (NumberFormatException e) {
			    System.out.println("Bitte geben Sie die Anzahl der Tagen an, für welche die Sortimentsplaung ausgeführt werden soll.");
			}
			
		}
		
		else {
			System.out.println("Bitte geben Sie zur Konsolennutzung einen Parameter ein! \n");
			Gui grafik = new Gui();
			grafik.openGUI();
		}
	}
}
