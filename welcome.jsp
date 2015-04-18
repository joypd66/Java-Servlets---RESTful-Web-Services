<%@ page session="false" %>
<html>
	<jsp:include page="link.jsp" />

	<body>
		<h2>Welcome!</h2>
		
		<%
			String loginMessage = (String)request.getAttribute("loginMessage");
			String registerMessage = (String)request.getAttribute("registerMessage");
		
			if(loginMessage != null){
				out.print("<p>" + loginMessage + "</p>");
			}//end if statement
			
			if(registerMessage != null){
				out.print("<p>" + registerMessage + "</p>");
			}//end if statement		
		%>
		<TABLE BORDER="0"><TR>
			<TD><form method="get" action="index.jsp">
				<button type="submit">View Profile</button>
	    		</form></TD>

	    		<TD><form method="get" action="Logout">
				<button type="submit">Logout</button>
	    		</form></TD>
		</TR></TABLE>
	</body>
</html>

