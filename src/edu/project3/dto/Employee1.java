package edu.project3.dto;
	public class Employee1 {
		private String firstname;
		private String lastname;
		private String dob;
		private String email;
		private String password;
		private long contact;
		private String gender;
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public long getContact() {
			return contact;
		}
		public void setContact(long contact) {
			this.contact = contact;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		@Override
		public String toString() {
			return "Appdto [firstname=" + firstname + ", lastnmae=" + lastname + ", dob=" + dob + ", email=" + email
					+ ", password=" + password + ", contact=" + contact + ", gender=" + gender + "]";
		}

		}

