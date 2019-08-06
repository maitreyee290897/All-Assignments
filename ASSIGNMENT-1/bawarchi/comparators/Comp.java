

package com.bawarchi.comparators;
import com.bawarchi.model.*;
import java.util.Comparator;
public class Comp {


	public  static Comparator<Dish> getComparators(int choice)
	{
		switch(choice)
		{
		case 1:
		{
			return new CaloriesGTComparators();
		}
		case 2:
		{
			return new CaloriesLTComparator();
		}
		case 3:
		{
			return new PriceLTComparator();
		}
			
		default:
		{
			return new PriceGTComparator();
		}
		}
		
	}
}
