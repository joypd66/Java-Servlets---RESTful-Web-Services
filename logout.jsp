<%@ page session="false" %>
<html>
	<jsp:include page="link.jsp" />

	<body>
		<h2>Logout</h2>
		<% //start of scriptlet
		String logout = (String)request.getAttribute("logout");
		
		//if there is a logout message.
		if(logout != null){
			out.print("<p>" + logout + "</p>");
		%><!-- end scriptlet -->
	
		<TABLE BORDER="0"><TR>
			<TD><form method="get" action="loginRegister.jsp">
				<button type="submit">Login/Register</button>
	    		</form></TD>
		</TR></TABLE>
		
		<%//resume scriptlet
		}//end if statement
		
		//if there is no logout message
		else{
		//end scriptlet
		%><!-- end scriptlet -->
		
		<TABLE BORDER="0"><TR>
			<TD><form method="get" action="Logout">
				<button type="submit">Logout</button>
	    		</form></TD>
		</TR></TABLE>
		
		<%//resume scriptlet
		}//end else statement
		%><!-- end scriptlet -->
	</body>
</html>

