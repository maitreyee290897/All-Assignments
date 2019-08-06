package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Emp;
import com.bean.EmpDaoImpl;


@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext factory=new ClassPathXmlApplicationContext("bean.xml");
		EmpDaoImpl empDaoImpl =(EmpDaoImpl)factory.getBean("emp");
		Emp emp=new Emp();
		emp.setName(request.getParameter("name"));
		emp.setPassword(request.getParameter("password"));
		emp.setRole(request.getParameter("role"));
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		emp.setEmail(request.getParameter("email"));
		emp.setMobile(Integer.parseInt(request.getParameter("mobile")));
		try
		{
		empDaoImpl.update(emp);

		
				request.setAttribute("alert", "Updated successfully!");
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);

		}catch(Exception e)
		{
			request.setAttribute("alert", "Updation failed, try again!");
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
	}

}
