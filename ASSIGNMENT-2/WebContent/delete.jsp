<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.ArrayList"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import=" org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import=" com.bean.Emp"%>
<%@ page import=" com.bean.EmpDaoImpl"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="styles.css">
<title>Insert title here</title>
</head>
<body  onload="check()">
<script>
function check()
{
	var Msg ='<%=request.getAttribute("alert")%>';
    if (Msg != "null") {
 alert(Msg);

 }
    else
    	{
	
    	}
}
</script>

<div class="login-card">
<form action="" method="post">
Name: <input type="text" name="name">
<input type="submit" name="s1" value="submit">
</form>
</div>

	<%!
		Emp emp = null;
		int track=1;
	%>
	<%
	
		ApplicationContext factory=new ClassPathXmlApplicationContext("bean.xml");
		EmpDaoImpl empDaoImpl =(EmpDaoImpl)factory.getBean("emp");
		emp=empDaoImpl.search(request.getParameter("name"));
		track=0;
		if(emp==null && track==1)
		{%>
		<h1> Record doesn't exist, try again!!</h1>
	<% 

	
	}
		else if(emp!=null)
		{
%>
<div class="login-card3">
<form action="delete " method="post">
<input type="hidden" name="name" value="<%= request.getParameter("name") %>" />
		<h2><br>
<table border="1">
        <tr>
            <th>Name</th>
            <th>Password</th>
            <th>Role</th>
            <th>Age</th>
            <th>Email</th>
            <th>Mobile</th>
        </tr>
		 <tr><td><%=emp.getName()%></td>
 <td><%=emp.getPassword()%></td>
 <td><%=emp.getRole()%></td>
 <td><%=emp.getAge()%></td>
 <td><%=emp.getEmail()%></td>
  <td><%=emp.getMobile()%></td>
 </tr>
 </table>
		</h2>
		<input type="submit" name="d1" value="DELETE">
</form>
</div>
<%} %>
<div class="login" >
<form action="success.jsp" method="post">
<h1><input type="submit" name="s1" value="BACK"></h1>
</form>
</div>
</body>
</html>