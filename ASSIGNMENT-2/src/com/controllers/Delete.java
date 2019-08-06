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

import com.bean.EmpDaoImpl;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete() {
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
		if(empDaoImpl.delete(request.getParameter("name"))==true)
		{
			request.setAttribute("alert", "Deleted successfully!");
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}else
		{
			request.setAttribute("alert", "Deletion failed, try again!");
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
		}
	}

}
