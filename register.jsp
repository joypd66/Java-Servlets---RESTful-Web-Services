<%@ page session="false" %>
<html>
    <body>
	<h2>User Registration</h2>
       	<form method="post" action="Register">
        Username:<input type="text" name="username" /><br/><br/>
        Password:<input type="text" name="password" /><br/><br/>
        Confirm Password:<input type="text" name="confirm" /><br/><br/>
        <input type="submit" value="Register" />
        </form>    

	<% //start of scriplet
		String uValue = (String)request.getAttribute("uValue");
		String uLength = (String)request.getAttribute("uLength");
		String pValue = (String)request.getAttribute("pValue");
		String pLength = (String)request.getAttribute("pLength");
		String equals = (String)request.getAttribute("equals");
		String uExists = (String)request.getAttribute("uExists");
		String success = (String)request.getAttribute("success");
		String failed = (String)request.getAttribute("failed");
		String tableCreate = (String)request.getAttribute("tableCreate");
		if(uValue != null){
			out.print("<p>" + uValue + "</p>");
		}//end for loop
		
		if(uLength != null){
			out.print("<p>" + uLength + "</p>");
		}//end for loop

		if(pValue != null){
			out.print("<p>" + pValue + "</p>");
		}//end for loop
		
		if(pLength != null){
			out.print("<p>" + pLength + "</p>");
		}//end for loop
		
		if(equals != null){
			out.print("<p>" + equals + "</p>");
		}//end for loop
		
		if(uExists != null){
			out.print("<p>" + uExists + "</p>");
		}//end for loop
		
		if(success != null){
			out.print("<p>" + success + "</p>");
		}//end for loop
		
		if(failed != null){
			out.print("<p>" + failed + "</p>");
		}//end for loop
			
		if(tableCreate != null){
			out.print("<p>" + tableCreate + "</p>");
		}//end for loop
	%>
    </body>
</html>
