<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
String counter1 = (String) request.getAttribute("counter");
//int counter = Integer.parseInt(counter1);
%>
<body>
<form method="get" action="ApiTestRest">
<input type="text" name="regd"/>
<input type="submit"/>
</form>
<%
if(counter1==null || counter1.equals("")) {
%>
No DATA
<%
}
else {
%>
Counter = <%=counter1 %>
<%
}
%>
<br>
<a href="index.html">Index</a>
</body>
</html>