package com.mindtree.collegeManagementSystem.Entity;

public class Student {

	private String name, subject;
	private int age;
	private College college;

	public Student(String name, String subject, int age, College college) {
		super();
		this.name = name;
		this.subject = subject;
		this.age = age;
		this.college=college;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", subject=" + subject + ", age=" + age + "]";
	}

}
