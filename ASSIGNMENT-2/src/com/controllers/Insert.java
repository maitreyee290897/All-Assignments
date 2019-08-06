package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Emp;
import com.bean.EmpDaoImpl;


public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext factory=new ClassPathXmlApplicationContext("bean.xml");
		EmpDaoImpl empDaoImpl =(EmpDaoImpl)factory.getBean("emp");
		Emp emp=new Emp();
		emp.setName(request.getParameter("name"));
		emp.setPassword(request.getParameter("password"));
		emp.setRole(request.getParameter("role"));
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		emp.setEmail(request.getParameter("email"));
		emp.setMobile(Integer.parseInt(request.getParameter("mobile")));
		//empDaoImpl.connectDatabase();
		boolean ret=empDaoImpl.insert(emp);
		if(ret==true)
		{	
			request.setAttribute("alert", "Inserted successfully!");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			
		
		}
		else
		{
			
			 request.setAttribute("alert","Insertion failed ,try again!!");
				RequestDispatcher rd=request.getRequestDispatcher("insert.jsp");
				rd.forward(request, response);
			
		}
		/*
		
		if(result==true)
		{
			response.sendRedirect("success.jsp");
			
		}
		else {
			//out.println("Invalid login");
		}*/
		
	}

}