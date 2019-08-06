package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class EmpDaoImpl implements EmpDao{
Connection c;
	


	public void connectDatabase() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "Sapient123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 catch (SQLException e) {
				e.printStackTrace();
			} 
		
		
	}

	public boolean insert(Emp emp) {
		try {
			
			
			PreparedStatement preparedStatement=c.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			preparedStatement.setString(1, emp.getName());
			preparedStatement.setString(2, emp.getPassword());
			preparedStatement.setString(3, emp.getRole());
			preparedStatement.setInt(4,emp.getAge());
			preparedStatement.setString(5, emp.getEmail());
			preparedStatement.setInt(6, emp.getMobile());			
			int i=preparedStatement.executeUpdate();
			if(i>0)
			{
				System.out.println("You are successfully registered");
				return true;
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		// TODO Auto-generated method stub
		
	}


	public ArrayList<Emp> display() {
        Statement st;
        ArrayList<Emp> emplist= new ArrayList<Emp>();
        int age, mobile;
        String name, password, role,email;
		try {
			
			
			st = c.createStatement();
			ResultSet rs=st.executeQuery("select * from employee;");
			while(rs.next())
			{
				Emp emp=new Emp();
				emp.setName(rs.getString(1));
				emp.setPassword(rs.getString(2));
				emp.setRole(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setEmail(rs.getString(5));
				emp.setMobile(rs.getInt(6));
				emplist.add(emp);
		
			}
			
				// TODO Auto-generated method stub
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return emplist;
		
	}

	
	public Emp search(String name) {
		try {
			PreparedStatement p=c.prepareStatement("select * from  employee where name=?;");
			p.setString(1, name);
			ResultSet rs = p.executeQuery();
			if(rs.next())
			{
				Emp emp=new Emp();
				emp.setName(rs.getString(1));
				emp.setPassword(rs.getString(2));
				emp.setRole(rs.getString(3));
				emp.setAge(rs.getInt(4));
				emp.setEmail(rs.getString(5));
				emp.setMobile(rs.getInt(6));
				System.out.println(emp);
				return emp;
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}


	public boolean update(Emp emp) {
		String update = "update employee set name = ?, password = ?, role = ?, age = ?, email = ?, mobile = ? where name = ?";
		try {
			
		PreparedStatement preparedStatement = c.prepareStatement(update);
		preparedStatement.setString(1, emp.getName());
		preparedStatement.setString(2, emp.getPassword());
		preparedStatement.setString(3, emp.getRole());
		preparedStatement.setInt(4, emp.getAge());
		preparedStatement.setString(5, emp.getEmail());
		preparedStatement.setInt(6, emp.getMobile());
		preparedStatement.setString(7, emp.getName());

		
			if(preparedStatement.execute())
				return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	
	public boolean delete(String emp) {
		System.out.println(emp);
		String del = "delete from employee where name = ?";
		try
		{
		PreparedStatement preparedStatement = c.prepareStatement(del);
		preparedStatement.setString(1, emp);
		preparedStatement.execute();
		}
		catch(Exception e)
		{
			return false;
			
		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean checkAdmin(Emp emp) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				 try {
					 
						//Class.forName("com.mysql.jdbc.Driver");
						 
						String name=emp.getName();
						String pwd=emp.getPassword();
						
							//c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "Sapient123");
							PreparedStatement ps = c.prepareStatement("select name,password from employee where name=? and password=?");
							ps.setString(1, name);
							ps.setString(2, pwd);
							 System.out.println(name);
							 System.out.println(pwd);
							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								System.out.println("Account match");
								return true;
							}
						 //PreparedStatement ps = c.prepareStatement("select uname,pwd from login where uname=? and pwd=?");
					
						 System.out.println("dao");
					 } 
				 catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					return false;
				
		
	}

}