<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.User" %>
    <%@ page import="dao.DaoImple" %>
    <%@ page import="servicelayer.ServiceImple" %>
    <%@ page import="servicelayer.ServiceInf" %>
    <%@ page import="java.util.List" %>
    <%@ page import="dto.Role" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String user =  (String)request.getParameter("login");
String pass =  (String)request.getParameter("password");
String role =  (String)request.getParameter("role");
String manage =  (String)request.getParameter("manage");
String bls = null;
	User us = new User();
	us.setUsername(user);
	us.setPassword(pass);
	us.setRole(role);
	ServiceInf sinf = new ServiceImple();
	bls=sinf.storeUser(us);
	List lst=sinf.getRoleList();
	Role rl = new Role();
	request.setAttribute("role",lst.toString());
%>
<%	
	if(bls.equals("insert successfull"))
	{
		if(!(role.contentEquals("Admin")))
		{%>
			<jsp:forward page="postlogin1.html"/>
						
		<%}%>
		else
		{
		<jsp:forward page= "postlogin.html"/>
		}
	<% } %>
	
</body>
</html>