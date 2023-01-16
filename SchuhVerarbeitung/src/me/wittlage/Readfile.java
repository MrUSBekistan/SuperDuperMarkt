package me.wittlage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Readfile {

	static List<String> farben = new ArrayList<String>();
	static Set<Shoes> shoe = new TreeSet<>();
	static String first;

	public static void readIn(String infile) {
	
		File file = new File(infile);
		
	try {
		@SuppressWarnings("resource")
		Scanner inputStream = new Scanner(file);
		
			first = inputStream.nextLine(); // zum Rausfiltern der ersten Zeile 
		
			while (inputStream.hasNextLine()) {
				String line = inputStream.nextLine();
				String[] splittedline = line.split(";");
				shoe.add(new Shoes(Integer.parseInt(splittedline[0]), splittedline[1], 
						splittedline[2], Double.parseDouble(splittedline[3]), splittedline[4], 
						Double.parseDouble(splittedline[5])));
				farben.add(splittedline[4]);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
	}
	
	public static void writeOut(String outfile) {
		
		try {
			File f = new File(outfile);
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			fw.write(first+"\n");
			for (Shoes s: shoe) {
				fw.write(s+"");    
				}
		    
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static List<String> getFarben() {
		return farben;
	}
	
}
