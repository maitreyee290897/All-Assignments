<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="java.util.ArrayList"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import=" org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import=" com.bean.Emp"%>
<%@ page import=" com.bean.EmpDaoImpl"%>
<%@ page import="java.util.Iterator"%>


<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
<title>Displaying</title>
</head>

<body>
<div class="login-card2">
<% 
		ApplicationContext factory=new ClassPathXmlApplicationContext("bean.xml");
		EmpDaoImpl empDaoImpl =(EmpDaoImpl)factory.getBean("emp");
		ArrayList<Emp> emplist= empDaoImpl.display();
		Iterator<Emp> i = emplist.iterator();
		%>
<table border="1">
        <tr>
            <th>Name</th>
            <th>Password</th>
            <th>Role</th>
            <th>Age</th>
            <th>Email</th>
            <th>Mobile</th>
        </tr>
<%
// Iterating through subjectList
 
if(emplist!= null)  // Null check for the object
{
 Iterator<Emp> iterator = emplist.iterator();  // Iterator interface
 
 while(iterator.hasNext())  // iterate through all the data until the last record
 {
 Emp empDetails = iterator.next(); //assign individual employee record to the employee class object
 %>
 <tr><td><%=empDetails.getName()%></td>
 <td><%=empDetails.getPassword()%></td>
 <td><%=empDetails.getRole()%></td>
 <td><%=empDetails.getAge()%></td>
 <td><%=empDetails.getEmail()%></td>
  <td><%=empDetails.getMobile()%></td>
 </tr>
 <%
 }
}
%>
</table>
</div>
<div class="login" >
<form action="success.jsp" method="post">
<h1><input type="submit" name="s1" value="BACK"></h1>
</form>
</div>
</body>

</html>