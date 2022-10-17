<%@page import="com.infinite.demo.Complaint"%>
<%@page import="java.util.List"%>
<%@page import="com.infinite.demo.ComplaintDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="get" action="Searchcomp.jsp">
 <center>
 
 Enter Complaint Id :
 <input type="text" name="compId" /><br/><br/>
 <input type="submit" value="Search" />
 </center>
 </form>
 <%
 if(request.getParameter("compId") != null){
    ComplaintDAO dao = new ComplaintDAO();
    String id = request.getParameter("compId"); 
    Complaint complaint =dao.searhComplaint(id);
    %>
    
    <table border="3" align="center">
  		   	<tr>
  		   		<th>ComplaintId</th>
  		   		<th>ComplaintType</th>
  		   		<th>Description</th>
  		   		<th>ComplaintDate</th>
  		   		<th>Severity</th>
  		   		<th>Status</th>
  		   	</tr>
  		   	<tr>
  		   		<td><%=complaint.getComplaintId() %></td>
  		   		<td><%=complaint.getComplaintType()%></td>
  		   		<td><%=complaint.getcDescription() %></td>
  		   		<td><%=complaint.getComplaintDate() %></td>
  		   		<td><%=complaint.getSeverity() %></td>
  		   		<td><%=complaint.getStatus() %></td>
  		   	</tr>
  		   </table>
    
 <%   
 }
 
 %>
 
 
</html>