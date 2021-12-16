package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Student;

public class StudentTester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Springconfig.xml");
		Student student = (Student) applicationContext.getBean("student");
		System.out.println("Student Id : " + student.getStudentId());
		System.out.println("Student Name : " + student.getStudentName());
		System.out.println("Student Marks : " + student.getStudentMarks());
		((ConfigurableApplicationContext) applicationContext).close();// down casting for configurable class
		System.out.println("The End");
	}

}
