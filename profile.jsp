<%@ page session="false" %>
<html>
	<head><title>Profile</title></head>
	<jsp:include page="link.jsp"/>
	<body>	
	<% //start of scriplet
		String profileMessage = (String)request.getAttribute("profileMessage");
		String failMessage = (String)request.getAttribute("failMessage");
		String validateMessage = (String)request.getAttribute("validateMessage");
		String stockTickerMessage = (String)request.getAttribute("stockTickerMessage");
		String stockPriceMessage = (String)request.getAttribute("stockPriceMessage");
		String stockFailMessage = (String)request.getAttribute("stockFailMessage");
		String historyFailMessage = (String)request.getAttribute("historyFailMessage");

		if(profileMessage != null){
			out.print("<h2>" + profileMessage + "</h2>");
			if(validateMessage != null){
				out.print("<p>" + validateMessage + "</p>");
			}//end if statement
	%>
		<p> Please enter a stock to lookup. </p>

		<form method="post" action="LookupController">
			Stock Ticker:<br>
			<input type="text" name="stockTicker"><br>
			<input type="submit" value="Submit">
		</form>

		<form method="get" action="ShowHistory">
			<input type="submit" value="Lookup History">
		</form>
	
	<%
	
		if(stockTickerMessage !=null && stockPriceMessage !=null){
			out.print("<p>" + "Stock Ticker: " + stockTickerMessage + "</p>");
			out.print("<p>" + "Stock Price: " + stockPriceMessage + "</p>");
		}//end if statement
		
		if(stockFailMessage !=null){
			out.print("<p>" + stockFailMessage + "</p>");
		}//end if statement
		
		if(historyFailMessage !=null){
			out.print("<p>" + historyFailMessage + "</p>");
		}//end if statement
	}//end if statement
	
		if(failMessage != null){
			%> <jsp:include page="login.jsp"/> <%
			out.print("<p>" + failMessage + "</p>");			
			%> <jsp:include page="register.jsp"/> <%
		}//end if statement	
	%>
    </body>
</html>

