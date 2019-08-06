package com.bawarchi.comparators;

import java.util.Comparator;

import com.bawarchi.model.Dish;

public class CaloriesLTComparator implements Comparator<Dish> {

	@Override
	public int compare(Dish d1, Dish d2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(d1.getCalories()).compareTo(d2.getCalories());
	}

}
