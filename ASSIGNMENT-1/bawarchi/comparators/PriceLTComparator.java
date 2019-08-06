package com.bawarchi.comparators;

import java.util.Comparator;

import com.bawarchi.model.Dish;

public class PriceLTComparator implements Comparator<Dish>{



	@Override
	public int compare(Dish d1, Dish d2) {
		// TODO Auto-generated method stub
		return Double.valueOf(d1.getPrice()).compareTo(d2.getPrice());
	}


}
