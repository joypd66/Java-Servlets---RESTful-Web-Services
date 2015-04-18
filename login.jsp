<%@ page session="false" %>
<html>
    <body>
	<h2>User Login</h2>
	<form method="post" action="Login">
	    Username:<input type="text" name="userName"/> <br/><br/>
	    Password:<input type="text" name="password"/> <br/><br/>
	    <input type="submit" value="Login"/>
        </form>
	
	<% //start of scriplet
		String validateMessage = (String)request.getAttribute("validateMessage");

		if(validateMessage != null){
			out.print("<p>" + validateMessage + "</p>");
		}//end for loop
	%>
    </body>
</html>

