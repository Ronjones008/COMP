<%@page import="java.sql.Date"%>
<%@page import="com.infinite.demo.Complaint"%>
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
	
	<form method="get" action="AddComplaint.jsp">
		<center>
			Complaint Type  : 
			<input type='text' name='complaintType' /> <br/><br/> 
			Complaint Description : 
			<input type="text" name="cDescription" /> <br/><Br/> 
			Severity : 
			<input type="text" name='severity' /> <br/><br/>
			
			<input type="submit" value="Insert" /> 
		</center>
	</form>
	
	<%
	if(request.getParameter("complaintType") != null){
		
		ComplaintDAO dao = new ComplaintDAO();
		Complaint complaint = new Complaint();
		complaint.setComplaintType(request.getParameter("complaintType"));
		complaint.setcDescription(request.getParameter("cDescription"));
		complaint.setSeverity(request.getParameter("severity"));
		//complaint.setComplaintDate(Date.valueOf(request.getParameter("complaintDate")));
		//complaint.setStatus(request.getParameter("status"));
		dao.addComplaint(complaint);
		
		
	}
	%>
</body>
</html>