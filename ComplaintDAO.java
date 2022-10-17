package com.infinite.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ComplaintDAO {
	
	Connection connection;
	PreparedStatement pst;

	
	//searchCompalint
	
	public Complaint searhComplaint(String compId) throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		String sql = "select * from  Complaint where ComplaintId=?";
		pst = connection.prepareStatement(sql);
		pst.setString(1, compId);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		if(rs.next()) {	
			complaint = new Complaint();
			complaint .setComplaintId(rs.getString("complaintId"));
			complaint.setComplaintType(rs.getString("complaintType"));
			complaint.setcDescription(rs.getString("cDescription"));
			complaint.setComplaintDate(rs.getDate("complaintDate"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("status"));
		}
		return complaint;
	}
	
	
	//showComplaint
	
	public List<Complaint> showComplaint() throws ClassNotFoundException, SQLException{
		
		connection = ConnectionHelper.getConnection();
		String sql = "select * from Complaint";
		pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		Complaint complaint = null;
		List<Complaint> cmplist = new ArrayList<Complaint>();
		while(rs.next()) {
			complaint = new Complaint();
			complaint .setComplaintId(rs.getString("complaintId"));
			complaint.setComplaintType(rs.getString("complaintType"));
			complaint.setcDescription(rs.getString("cDescription"));
			complaint.setComplaintDate(rs.getDate("complaintDate"));
			complaint.setSeverity(rs.getString("severity"));
			complaint.setStatus(rs.getString("status"));
			cmplist.add(complaint);
		}
		return cmplist;
		
	}
	
	//ResolveShow
	
	public List<Resolve> showResolve() throws ClassNotFoundException, SQLException{
		
		connection = ConnectionHelper.getConnection();
		String sql = "select * from Resolve";
		pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		Resolve resolve = null;
		List<Resolve> reslist = new ArrayList<Resolve>();
		while(rs.next()) {
			resolve = new Resolve();
			resolve.setComplaintId(rs.getString("complaintId"));
			resolve.setComplaintDate(rs.getDate("complaintDate"));
			resolve.setResolveDate(rs.getDate("resolveDate"));
			resolve.setResolvedBy(rs.getString("resolvedBy"));
			resolve.setComments(rs.getString("comments"));
			reslist.add(resolve);
		}
		return reslist;
		
	}
	
	//Resolve

	public String addResolve(Resolve resolve) throws ClassNotFoundException, SQLException {
		
		String sql = "insert into Resolve(ComplaintID, ResolvedBy, Comments) values(?,?,?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setString(1, resolve.getComplaintId());
		//pst.setDate(2, resolve.getComplaintDate());
		pst.setString(2, resolve.getResolvedBy());
		pst.setString(3, resolve.getComments());
		pst.executeUpdate();
		return "Resolved";
	}
	
	//AddComplaint
	
	public String addComplaint(Complaint complaint) throws ClassNotFoundException, SQLException {
		
		String compId = generateCompId();
		complaint.setComplaintId(compId);
		String sql="insert into Complaint(ComplaintID, ComplaintType, CDescription, Severity) values(?,?,?,?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(sql);
		pst.setString(1, compId);
		pst.setString(2, complaint.getComplaintType());
		pst.setString(3, complaint.getcDescription());
		pst.setString(4, complaint.getSeverity());
		pst.executeUpdate();
		return "Complaint Added";
		
	}
	
	//generating complaintID
	
	public String generateCompId() throws ClassNotFoundException, SQLException {
		Complaint complaint = new Complaint();
		connection = ConnectionHelper.getConnection();
		String cmpId;
		System.out.println("hii");
		if(complaint.getComplaintId() != null) {
		String sql ="select case when max(ComplaintID) is NULL then \"C001\" end ComplaintId from Complaint";
		System.out.println("iffff");
		pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();
	    cmpId= rs.getString("ComplaintId");
		}
		else {
			System.out.println("else");
			String sql = "select max(ComplaintId) ComplaintId from Complaint";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			rs.next();
		    cmpId= rs.getString("ComplaintId");
			int id = Integer.parseInt(cmpId.substring(1));
			id++;
			System.out.println("Id  =  "+id);
			cmpId = String.format("C%03d", id);
			
			System.out.println("cpmId = "+cmpId);
		}
		System.out.println("end");
		return cmpId;
		
	}

}

