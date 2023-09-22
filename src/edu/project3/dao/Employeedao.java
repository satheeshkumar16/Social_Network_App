package edu.project3.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

import edu.project3.dto.Employee1;
import edu.project3.dto.Status;

public class Employeedao {
static Scanner s=new Scanner(System.in);
static String driver="com.mysql.cj.jdbc.Driver";
static String url="jdbc:mysql://localhost:3306/project1";
static String user="root";
static String password="root";
public String status;
public Date date;
public Time time;
//login
public Employee1 profile(String email) {
	try {
		Class.forName(driver);
		Connection c=DriverManager.getConnection(url,user,password);
		PreparedStatement ps=c.prepareStatement("select * from employee where email=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			long contact=rs.getLong(1);
			String firstname=rs.getString(2);
			String lastname=rs.getString(3);
			String dob=rs.getString(4);
			String email1=rs.getString(5);
			String password=rs.getString(6);
			String gender=rs.getString(7);
			
			Employee1 e=new Employee1();
			e.setContact(contact);
			e.setFirstname(firstname);
			e.setLastname(lastname);
			e.setDob(dob);
			e.setEmail(email1);
			e.setPassword(password);
			e.setGender(gender);
			c.close();
			return e;
		}
		c.close();
		return new Employee1();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
//signup
public void signup(Employee1 e) {
	try {
		Class.forName(driver);
		Connection c=DriverManager.getConnection(url,user,password);
		PreparedStatement ps=c.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
		ps.setLong(1,e.getContact());
		ps.setString(2,e.getFirstname());
		ps.setString(3,e.getLastname());
		ps.setString(4,e.getDob());
		ps.setString(5,e.getEmail());
		ps.setString(6,e.getPassword());
		ps.setString(7,e.getGender());
		int affected=ps.executeUpdate();
		if(affected!=0) {
			System.out.println("signup successfully");
		}else {
			System.out.println("signup failed");
		}
		c.close();
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
public static void status(String email) {
try {
	Class.forName(driver);
	Connection c=DriverManager.getConnection(url,user,password);
	PreparedStatement ps=c.prepareStatement("insert into status values(?,?,?,?)");
	java.util.Date date=new java.util.Date();
	Date date1=new Date(date.getTime());
	Time time=new Time(date.getTime());
	System.out.println("type status");
	String status=s.next();
	ps.setString(1, email);
	ps.setString(2, status);
	ps.setDate(3, date1);
	ps.setTime(4, time);
	int affected=ps.executeUpdate();
	if (affected!=0) {
		System.out.println("posted ur status");
	} else {
		System.out.println("no row affected");
	}
	c.close();
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public ArrayList<Status> viewpost(String email) {
	try {
		Class.forName(driver);
		Connection c=DriverManager.getConnection(url,user,password);
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select status,date,time from status");
		ArrayList<Status> arraylist=new ArrayList<>();
		while(rs.next()) {
			String status=rs.getString(1);
			Date date=rs.getDate(2);
			Time time=rs.getTime(3);
			Status status1=new Status();
			status1.setEmail(email);
			status1.setStatus(status);
			status1.setDate(date);
			status1.setTime(time);
			arraylist.add(status1);
		}
		c.close();
		return arraylist;
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public Employee1 updateprofile(Employee1 e) {
	try {
		Class.forName(driver);
		Connection c=DriverManager.getConnection(url,user,password);
		PreparedStatement ps=c.prepareStatement("update employee set contact=?,firstname=?,lastname=?,dob=?,email=?,password=?,gender=?");
		ps.setLong(1,e.getContact());
		ps.setString(2,e.getFirstname());
		ps.setString(3,e.getLastname());
		ps.setString(4,e.getDob());
		ps.setString(5,e.getEmail());
		ps.setString(6,e.getPassword());
		ps.setString(7,e.getGender());
		int affected=ps.executeUpdate();
		if(affected!=0) {
			System.out.println("user details updated");
		}else {
			System.out.println("updation failed");
		}
		c.close();
		return e;
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		return null;
	}
	
}
}
