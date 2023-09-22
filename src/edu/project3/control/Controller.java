package edu.project3.control;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import edu.project3.dao.Employeedao;
import edu.project3.dto.Employee1;
import edu.project3.dto.Status;

public class Controller {
static boolean loop=true;
static Scanner s=new Scanner(System.in);
public static void main(String[] args) {
	while(loop) {
		System.out.println("**********Alpha Book****************\n1.Login\n2.Signup\n3.Exit");
		int opt =s.nextInt();
				switch(opt) {
		case 1:{
			Employeedao emp=new Employeedao();
			System.out.println("enter the email");
			String email=s.next();
			Employee1 e1=emp.profile(email);
			String existing1_email=e1.getEmail();
			if(existing1_email!=null) {
				System.out.println("enter password");
				for (int i = 2; i >= 0; i--) {
					String existing_pass=e1.getPassword();
					String user_password=s.next();
					if(user_password.equals(existing_pass)) {
						System.out.println("*********Welcome Username********");
						i=0;
						System.out.println("firstname:="+e1.getFirstname()+"\nLastname:="+e1.getLastname());
						System.out.println("\n***************");
						List<Status> list=emp.viewpost(email);
						ListIterator li=list.listIterator();
						for (int j = 1; li.hasNext(); j++) {
						System.out.println("old status:"+j);
						System.out.println("\n"+li.next());
						System.out.println("\n*****************");
						}
					System.out.println("1.post status \n2.logout\nEnter your choice");
					System.out.println("\n************************");
					int user=s.nextInt();
					if(user==1) {
						emp.status(email);
					}else if(user==2) {
						break;
					}else {
						System.out.println("invalid choice");
						break;
					}
					}else {
					System.out.println("\nInvalid password");
					System.out.println(i+"attempts remaining");
					System.out.println("re-enter password");
				}	
			}
		}else {
				System.out.println("user doesn't exist");
				break;
			}
			break;
		}
		case 2:{
		System.out.println("**************Alpha Book************************");
		System.out.println("first Name\t:");
		String firstname=s.next();
		System.out.println("\nLast Name\t:");
		String lastname=s.next();
		System.out.println("\nGender\t:");
		String gender=s.next();
		System.out.println("\nContact\t:");
		long contact=s.nextLong();
		System.out.println("\nDob\t:");
		String dob=s.next();
		System.out.println("\nEmail\t:");
		String email1=s.next();
		System.out.println("\nPassword\t:");
		String password=s.next();
		System.out.println("\n\t1.Submit\n\t2.Cancel\n\tEnter your Choice:");
		System.out.println("*********************************");
		int user=s.nextInt();
		if (user==1) {
			Employeedao emp=new Employeedao();
			Employee1 e1=emp.profile(email1);
			String existing1_email=e1.getEmail();
			if(existing1_email!=null) {
				System.out.println("user already exist");
				break;
			}
			Employee1 s=new Employee1();
			s.setContact(contact);
			s.setFirstname(firstname);
			s.setLastname(lastname);
			s.setDob(dob);
			s.setEmail(email1);
			s.setPassword(password);
			s.setGender(gender);
			Employeedao emp1=new Employeedao();
			emp1.signup(s);
		}
		else {
			loop=false;
			}
break;	
		}
		case 3:{
			loop=false;
			System.out.println("thank you");
			break;
		}
			
		}
	}
}
}