<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="styles.css">
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
	<form action="insert" method="post">
		<h2><br>
			Username : <input type="text" name="name"> <br>
			Password : <input type="password" name="password"><br>
			Role : <input type="text" name="role"> <br>
		    Age : <input type="text" name="age"><br>
			Email : <input type="text" name="email"> <br>	
			Mobile : <input type="text" name="mobile"><br>
		    <input type="submit" name="b1" value="INSERT"><br><br><br>
		
		</h2>
		</form>
		</div>
</body>
</html>