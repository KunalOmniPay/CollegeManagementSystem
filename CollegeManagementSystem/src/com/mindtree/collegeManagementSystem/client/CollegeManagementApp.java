package com.mindtree.collegeManagementSystem.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.collegeManagementSystem.Entity.College;
import com.mindtree.collegeManagementSystem.Entity.Student;
import com.mindtree.collegeManagementSystem.exception.ServiceException.CollegeManagementServiceException;
import com.mindtree.collegeManagementSystem.service.CollegeService;
import com.mindtree.collegeManagementSystem.service.StudentService;
import com.mindtree.collegeManagementSystem.service.implementation.CollegeServiceImpl;
import com.mindtree.collegeManagementSystem.service.implementation.StudentServiceImpl;

public class CollegeManagementApp {
	private static Scanner sc = new Scanner(System.in);
	private static CollegeService collegeService = new CollegeServiceImpl();
	private static StudentService studentService = new StudentServiceImpl();
	public static void main(String[] args) {
		boolean exitMenu = false;
		do {
			displayMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter college name");
				String collegeName=sc.nextLine();
				try {
					String message=collegeService.addCollege(collegeName);
					System.out.println(message);
				} catch (CollegeManagementServiceException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 2:
				String message="";
				try {
					message=studentService.addStudent(getStudentData());
				} catch (CollegeManagementServiceException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(message);
				break;
			case 3:
				displayCollegeAndStudentData();
				break;
			case 4:
				displayStudentDataBasedOnCollegeAndSubject();
			
			}
		} while (!exitMenu);
	}

	private static void displayStudentDataBasedOnCollegeAndSubject() {
		System.out.println("ENter college");
		String college = sc.nextLine();
		System.out.println("Enter subject");
		String subject=sc.nextLine();
		try {
			List<Student> studentList= studentService.getStudentDataBasedOnCollegeAndSubject(college, subject);
			studentList=studentService.sortStudentList(studentList);
			displayStudent(studentList);
		
		} catch (CollegeManagementServiceException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void displayStudent(List<Student> studentList) {
		
		System.out.println("Name \t\t Age \t\t Subject \t\t");

		for(Student student : studentList)
		{
			System.out.println(student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getSubject());
		}
	}

	public static void displayCollegeAndStudentData() {
		
		try {
			List<College> collegeList= collegeService.getAllCollege();
			System.out.println(collegeList.size());
			collegeList=collegeService.sortCollegeList(collegeList);
			for(College college : collegeList)
			{	if(college.getStrengthOfStudents()!=0) {
				List<Student>studentList= studentService.getStudentByCollegeName(college.getName(), college.getStrengthOfStudents());
				display(studentList, college);
				System.out.println();
			}
			}
		} catch (CollegeManagementServiceException e) {
		System.out.println(e.getMessage());
		}
		System.out.println("****************************************************************");

		
	}

	private static void display(List<Student> studentList, College college) {
		System.out.println("College Name : " + college.getName());
		System.out.println("Strength : " + college.getStrengthOfStudents());
		System.out.println("Students are - ");
		System.out.println("Name \t\t Age \t\t Subject \t\t");
		for(Student student : studentList)
		{
			System.out.println(student.getName() + "\t\t" + student.getAge() + "\t\t" + student.getSubject());
		}
	}

	public static Student getStudentData() {
		System.out.println("Enter name of student");
		String name =sc.nextLine();
		System.out.println("Enter age");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter college");
		String collegeName=sc.nextLine();
		
		System.out.println("Enter subject");
		String subject = sc.nextLine();
		try {
			collegeService.updateStrength(collegeName);
		} catch (CollegeManagementServiceException e) {
			System.out.println(e.getMessage());
		}
		try {
			College college=collegeService.getCollege(collegeName);
			Student student = new Student(name, subject, age, college);
			return student;

		} catch (CollegeManagementServiceException e) {
			System.out.println(e.getMessage());
		}
		return null;
		
	}

	public static void displayMenu() {
		System.out.println("1.Add college");
		System.out.println("2. Add Student");
		System.out.println("3.Fetch college and student data");
		System.out.println("4.Show student Data for given college and subject");
		System.out.println("-------------------------------------------------------------");
	}
	
}
