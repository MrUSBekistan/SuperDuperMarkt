package me.wittlage;

import java.util.ArrayList;
import java.util.List;

public class ProdRange {	//Sortiment
	
	List<Product> range = new ArrayList<Product>();

	public ProdRange(List<Product> range) {
		super();
		this.range = range;
	}
	
	public List<Product> getRange() {
		return range;
	}
	
	public void setRange(List<Product> range) {
		this.range = range;
	}
	
}
