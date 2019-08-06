
package com.bawarchi.client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import com.bawarchi.model.*;

import com.bawarchi.comparators.*;

public class Restaurant {

	public static void main(String[] args)
	{
	Scanner scanner=new Scanner(System.in);
	List<Dish> dishList= new ArrayList<>();
	dishList.add(new Dish(5, "Neer Dosa", 50, 100));
	dishList.add(new Dish(2, "Idli Vada", 40, 200));
	dishList.add(new Dish(4, "Roti Curry", 100, 250));
	dishList.add(new Dish(1, "Dosa", 50, 300));
	dishList.add(new Dish(3, "Pulav", 80, 350));
	
	System.out.println("==========WELCOME===========");
	System.out.println("Please choose from the below options: ");
	System.out.println("");
	System.out.println("1 => To sort the dishes in the increasing order of calories");
	System.out.println("2 => To sort the dishes in the decreasing order of calories ");
	System.out.println("3 => To sort the dishes in the increasing order of price");
	System.out.println(" 4 => To sort the dishes in the decreasing order of price");
	
	int choice;
	choice=scanner.nextInt();
	scanner.nextLine();
	
	Collections.sort(dishList, Comp.getComparators(choice));
	//System.out.println(dishList);
	System.out.println("=================Please select the Dish Id and hit enter===============================");
	for(Dish dish:dishList)
	{
		System.out.println(dish);
	}
	System.out.println("=======================================================================================");
	choice= scanner.nextInt();
	scanner.nextLine();
	int flag=0;
	double price=0;
	for(Dish dish:dishList)
	{
		if(dish.getDishId()==choice)
		{
			flag=1;
			System.out.println("============You have selected "+ dish.getName()+"========");
			price=dish.getPrice();
			break;
		}
	}	
	if(flag==0)
	{
		System.out.println("INVALID OPTION");
	}
	System.out.println("Please enter your name");
	String name= scanner.nextLine();
	System.out.println("Please pay the bill of Rs. "+ price+ " ");
	
	double priceInput = scanner.nextDouble();
	scanner.nextLine();
	
	if(priceInput>price)
	{
		double change= priceInput-price;
		System.out.println("Please collect change of Rs. "+ change );
	}
	else if(priceInput == price)
	{
		System.out.println("Thanks for your order ");		
	}
	else {
		{
			System.out.println("Amount paid is less than the bill ");		
		}
	}

	
}
}