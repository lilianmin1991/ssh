package com.ssh.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="tb_user")
	public class User {


		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String name;
		private String mobile;
		private String email;
		private String password;

		
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(Integer id, String name, String mobile, String email, String password) {
			super();
			this.id = id;
			this.name = name;
			this.mobile = mobile;
			this.email = email;
			this.password = password;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
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

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", password="
					+ password + "]";
		}

}
