package com.infinite.demo;

import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) {
		
		ComplaintDAO dao = new ComplaintDAO();
		 Complaint complaint = new Complaint();
		 
		 System.out.println(complaint.getComplaintDate());
		
	}

}