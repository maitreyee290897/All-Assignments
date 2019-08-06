package com.controllers;
import com.bean.*;
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


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		Emp emp=new Emp();
		emp.setName(name);
		emp.setPassword(pwd);
		
		ApplicationContext factory=new ClassPathXmlApplicationContext("bean.xml");
		EmpDaoImpl empDaoImpl =(EmpDaoImpl)factory.getBean("emp");
		//empDaoImpl.connectDatabase();
		boolean result=empDaoImpl.checkAdmin(emp);
		if(result==true)
		{
			 
			request.setAttribute("alert", "Logged in successfully");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			
		}
		else {
			
			response.sendRedirect("index.html");
		}
		
	}

}