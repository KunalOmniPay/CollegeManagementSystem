package com.mindtree.collegeManagementSystem.Entity;

public class College {

	private String name;
	private int strengthOfStudents;

	public College(String name, int strengthOfStudents) {
		super();
		this.name = name;
		this.strengthOfStudents = strengthOfStudents;
	}

	public College() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrengthOfStudents() {
		return strengthOfStudents;
	}

	public void setStrengthOfStudents(int strengthOfStudents) {
		this.strengthOfStudents = strengthOfStudents;
	}

	@Override
	public String toString() {
		return "College [name=" + name + ", strengthOfStudents=" + strengthOfStudents + "]";
	}

}
