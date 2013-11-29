<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="servicelayer.ServiceImple" %>
   <%@ page import="servicelayer.ServiceInf" %>
   <%@ page import="java.util.List" %>
    <%@page import="java.util.Iterator"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<script>

</script>
<style>
body {
  font: 13px/20px "Lucida Grande", Tahoma, Verdana, sans-serif;
  color: #404040;
  background:#0088cc; 
}

.login {
  position: relative;
  margin: 50px auto;
  padding: 20px 20px 20px;
  width: 310px;
  background: white;
  border-radius: 3px;
 }


.login h1 {
   margin: -20px -20px 21px;
  line-height: 40px;
  font-size: 15px;
  font-weight: bold;
  color: #555;
  text-align: center;
  text-shadow: 0 1px white;
  background: #f3f3f3;
  border-bottom: 1px solid #cfcfcf;
  border-radius: 3px 3px 0 0; 
  
}
.login p.submit {
  text-align: right;
} 

input[type=text], input[type=password] {
  margin: 5px;
  padding: 0 10px;
  width: 200px;
  height: 34px;
  color: #404040;
  background: white;
  border: 1px solid;
  border-color: #c4c4c4 #d1d1d1 #d4d4d4;
  border-radius: 2px;
  outline: 5px solid #eff4f7;
  
}
 input[type=submit] {
  padding: 0 18px;
  height: 29px;
  font-size: 12px;
  font-weight: bold;
  color: #527881;
  text-shadow: 0 1px #e3f1f1;
  background: #cde5ef;
  border: 1px solid;
  border-color: #b4ccce #b3c0c8 #9eb9c2;
  border-radius: 16px;
  outline: 0;
} 
#myList
{
  margin: 5px;
  
  width: 223px;
  height: 25px;
  color: #404040;
  background: white;
  border: 1px solid;
  border-color: #c4c4c4 #d1d1d1 #d4d4d4;
  border-radius: 2px;
  outline: 5px solid #eff4f7;
}
</style>
<body>
  <div class="login">
    <h1>DevOps Dashboard Login</h1>
    <form method="post" action="login">
      <p><label>Username or Email Id</label><input type="text" name="username" value="" ></p>
      <p><label>Password</label></br><input type="password" name="password" value="" ></p>
    <p><label>Role</label></br>
    
     <select id = "myList" name="role">
               <option value ="">Select</option>
               <%
               Iterator itr;
               ServiceInf sinf = new ServiceImple();
                 List list = sinf.getRoleList();
                 for(itr=list.iterator(); itr.hasNext();)
                 {%>
                   <option value=""><%=itr.next()%></option>
                 <%}
				%>
               
             </select>
          </p>
	
      <p class="submit"><input type="submit" name="commit" value="Login"></p>
    </form>
  </div>

</body>
</html>