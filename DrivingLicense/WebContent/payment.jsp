<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment</title>
</head>
<body>
<body bgcolor="skyblue">
<form action=payment method="post">
<h1>Enter Card Details </h1><br><br>

<b>Select card type: </b> 
<select> 

<option value="credit">Credit</option>
<option value="debit">Debit</option> 
</select><br><br>


<b>card number :  </b> <input type="text" name="number"><br><br>
<b>card name   :    </b> <input type="text" name="name"><br><br>
<b>expiry date :  </b> <input type="text" name="date"><br><br>
<input type="submit" value="proceed">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</center>
<% 
			if(request.getAttribute("paymenterror")!=null){
			String msg=(String)request.getAttribute("paymenterror");
			out.print("<font style='color:red'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+ msg);
			out.print("</font><br/>");
			}
							%>
</form>
</body>
</html>