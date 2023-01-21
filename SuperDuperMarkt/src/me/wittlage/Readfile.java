package me.wittlage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Readfile {

	static List<Product> dataset  = new ArrayList<Product>();
	static String first;

	public static void readIn(String infile) throws FileNotFoundException {
	
		File file = new File(infile);
		
		try (Scanner inputStream = new Scanner(file)) {
			first = inputStream.nextLine(); // zum Rausfiltern der ersten Zeile 
			
			while (inputStream.hasNextLine()) {
				String line = inputStream.nextLine();
				String[] splittedline = line.split(";");
				switch (splittedline[0]) {
				case "wine": {
					dataset.add(new Wine(splittedline[1], LocalDate.parse(splittedline[2]), 
							Integer.parseInt(splittedline[3]), Double.parseDouble(splittedline[4])));
					break;
				}
				case "cheese":{
					dataset.add(new Cheese(splittedline[1], LocalDate.parse(splittedline[2]), 
							Integer.parseInt(splittedline[3]), Double.parseDouble(splittedline[4])));
					break;
				}
				case "bread": {
					dataset.add(new Bread(splittedline[1], LocalDate.parse(splittedline[2]), 
							Integer.parseInt(splittedline[3]), Double.parseDouble(splittedline[4])));
					break;
				}
				default:
					if (splittedline[0]!=null) {
					dataset.add(new Product(splittedline[1], LocalDate.parse(splittedline[2]), 
							Integer.parseInt(splittedline[3]), Double.parseDouble(splittedline[4])));
					break;
					}
					else {
						System.out.print("Bitte gescheiten Datensatz eingeben!");
					}
				}
				DemoData.setDemo(dataset);
			}
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
	
	/*public static void writeOut(String outfile) {
		
		try {
			File f = new File(outfile);
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			fw.write(first+"\n");
			for (Product p : DemoData.getDemo()) {
				fw.write(p+"");    
				}
		    
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}*/
	
}
