<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<title>Home Page</title>
<script language="javascript" type="text/javascript" src="datetimepicker.js">  
  <script type="text/javascript">
	</script>
</head>
<body bgcolor="skyblue">
<h1 align="center"><font size="+3" color="#6600FF" face="Courier New, Courier, mono">
<b>License Registration</b></font></h1>

<form name=register action=register method=post>
	
	  <tr> 
        <td width="258" height="116">
		<table align="center">
		<tr>
		<td colspan="2" align="center" > <strong><font face="mono"  size="+3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SIGN UP</font></strong></td>
		
		</tr>
		
		<tr>
		<td><font size="+2" face="Helvetica">Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		<td><input type="text" name="name"></td>
		
		</tr>
		<tr>
		<td><font size="+2" face="Helvetica">User Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		<td><input type="text" name="uname"></td>
		
		</tr>
		
		<tr>
		<td><font size="+2" face="Helvetica">Email-Id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		<td><input type="text" name="eid"></td>
		
		</tr>
		
		<tr>
		<td><font size="+2" face="Helvetica">Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		<td><input type="password" name="pass"></td>
		
		</tr>
		<tr>
		<td><font size="+2" face="Helvetica">Confirm Password :</font></td>
		<td><input type="password" name="cpass"></td>
		
		</tr>
		<tr>
		<td><font size="+2" face="Helvetica">Data Of Birth &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		 <td><input id="demo2" type="text" size="20" name="dob"><a href="javascript:NewCal('demo2','ddmmyyyy')"><img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td></tr>
		
		
		<tr>
		<td><font size="+2" face="Helvetica">Mobile Number &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		<td><input type="text" name="mno"></td>
		
		</tr>
		
		<tr>
		<td><font size="+2" face="Helvetica">Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		<td><input type="text" name="address"></td>
		
		</tr>
		<tr>
		<td><font size="+2" face="Helvetica">Test Date &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		 <td  ><input id="demo1" type="text" size="20" name="td"><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a></td></tr>
		
		
		
		<tr>
		<td><font size="+2" face="Helvetica">Gender&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</font></td>
		<td><font size="+1" face="mono"><input type="radio" name="gender" value="Male">&nbsp;&nbsp;Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="gender" value="Female">&nbsp;&nbsp;Female</font></td>
		</tr>
		
		<tr>
		<td></td><td><input type="submit" name="s" value="SUBMIT"></td>
		<td></td><td><input type="reset" name="s" value="RESET"></td>
		</tr>
	</table>       
    </td>
    </tr>
    
    <% 
			if(request.getAttribute("registererror")!=null){
			String msg=(String)request.getAttribute("registererror");
			out.print("<font style='color:red'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
			+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ msg);
			out.print("</font><br/>");
			}
							%>
    
    </form>

</body>
</html>