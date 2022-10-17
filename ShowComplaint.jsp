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
  		  <%
  		  ComplaintDAO dao = new ComplaintDAO();
  		  List<Complaint> cmplist = dao.showComplaint();
  		  %>
  		  <form method="get" action="ShowComplaint.jsp">
  		   <table border="3" align="center">
  		   	<tr>
  		   		<th>ComplaintId</th>
  		   		<th>ComplaintType</th>
  		   		<th>Description</th>
  		   		<th>ComplaintDate</th>
  		   		<th>Severity</th>
  		   		<th>Status</th>
  		   		<th>Resolve</th>
  		   	</tr>
  		   	<%
  		   	 for(Complaint complaint : cmplist){
  		   	%>
  		   	<tr>
  		   		<td><%=complaint.getComplaintId() %></td>
  		   		<td><%=complaint.getComplaintType()%></td>
  		   		<td><%=complaint.getcDescription() %></td>
  		   		<td><%=complaint.getComplaintDate() %></td>
  		   		<td><%=complaint.getSeverity() %></td>
  		   		<td><%=complaint.getStatus() %></td>
  		   		<td><a href="Resolve.jsp?id=<%=complaint.getComplaintId() %>">Resolved</a></td>
  		   	</tr>
  		   	<%
  		   	 }
  		   	%>
  		   	
  		   </table>
  		  </form>
</body>
</html>