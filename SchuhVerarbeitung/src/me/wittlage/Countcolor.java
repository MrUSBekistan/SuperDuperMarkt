package me.wittlage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Countcolor {

	
	public static String zaehle(List<String> list) {
		
	      Map<String, Integer> duplicates = new HashMap<String, Integer>(); 
	      
	      for (String line : list) { 
	         if (duplicates.containsKey(line)) { 
	            duplicates.put(line, duplicates.get(line) + 1); 
	         } else { 
	            duplicates.put(line, 1); 
	         } 
	      } 
	 
	      return duplicates.toString();
	}
}