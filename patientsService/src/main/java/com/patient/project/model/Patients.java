package com.patient.project.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="Patients")
public class Patients implements Serializable{
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
		
		@Column(name="name")
	    private String name;
		
		@Column(name="age")
	    private int age;
		
		@Column(name="gender")
	    private String gender;
		

	    
       public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Patients [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
		}

		

}


