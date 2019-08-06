package com.bean;

import java.util.ArrayList;

public interface EmpDao {
	
	public  boolean checkAdmin(Emp emp);
	public void connectDatabase();
	public boolean insert(Emp emp);
	public boolean update(Emp emp);
	public boolean delete(String emp);
	public ArrayList<Emp> display();
	public Emp search(String name);
	

}