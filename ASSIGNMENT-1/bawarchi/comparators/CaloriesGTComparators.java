package com.bawarchi.comparators;

import java.util.Comparator;

import com.bawarchi.model.Dish;

public class CaloriesGTComparators implements Comparator<Dish> {

	@Override
	public int compare(Dish d2, Dish d1) {
		// TODO Auto-generated method stub
		return Integer.valueOf(d2.getCalories()).compareTo(d1.getCalories());
	}

}
