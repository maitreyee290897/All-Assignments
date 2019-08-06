<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="styles.css">
<link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
</head>
<body onload="check()">
<h1>WELCOME ADMIN</h1>
<hr>
<div class="login-card" >
<script>
function check()
{
	var Msg ='<%=request.getAttribute("alert")%>';
    if (Msg != "null" && Msg != null) {
 alert(Msg);

 }
    else
    	{

    	}
}
</script>
To add employee <a href="insert.jsp"> CLICK HERE</a><br>
To update an employee <a href="update.jsp"> CLICK HERE</a><br>
To delete an employee <a href="delete.jsp"> CLICK HERE</a><br>
To display all employees <a href="display.jsp"> CLICK HERE</a><br>
</div>
</body>
</html>