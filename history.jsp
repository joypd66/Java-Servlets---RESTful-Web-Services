<%@ page session="false" %>
<html>
	<jsp:include page="link.jsp" />

	<body>
		<h2>Lookup History</h2>
		
		<% //start of scriplet
		String historyMessage = (String)request.getAttribute("historyMessage");
		String noHistoryMessage = (String)request.getAttribute("noHistoryMessage");
		
		if(historyMessage != null){
			out.print("<p>" + historyMessage + "</p>");
		}//end if statement

		if(noHistoryMessage != null){
			out.print("<p>" + noHistoryMessage + "</p>");
		}//end if statement
		%>
	</body>
</html>

