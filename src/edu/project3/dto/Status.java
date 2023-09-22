package edu.project3.dto;

import java.sql.Date;
import java.sql.Time;

public class Status {
private String email;
private String status;
private Time time;
private Date date;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Time getTime() {
	return time;
}
public void setTime(Time time) {
	this.time = time;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "Status [email=" + email + ", status=" + status + ", time=" + time + ", date=" + date + "]";
}

}
