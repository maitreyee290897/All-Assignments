
package com.bawarchi.model;
import java.util.Objects;



public class Dish implements Comparable<Dish>{
	
	private int dishId;
	private String name;
	private int calories;
	private double price;
	
	public Dish(int dishId,String name,double price, int calories)
	{
		this.dishId=dishId;
		this.name=name;
		this.calories=calories;
		this.price=price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj.getClass() != Dish.class)
			return false;
		Dish dish1=(Dish)obj;
		
		// TODO Auto-generated method stub
		return Objects.equals(this.dishId,dish1.dishId) && Objects.equals(this.name, dish1.name);
	}

	 @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.dishId,this.name);
	}

	@Override
	public int compareTo(Dish o) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.dishId).compareTo(o.dishId);
		
	}
	
	public String toString()
	{
		String string= "Dish Id: "+ this.dishId+" ,name: "+this.name+" ,price: "+this.price+" ,calories: "+this.calories;
		return string;
	}


	

}
