package com.main;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Student;
import com.model.Teacher;

public class TeacherTester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
		Teacher teacher = (Teacher) applicationContext.getBean("teacher");
		System.out.println("Teacher Id : " + teacher.getTeacherId());
		System.out.println("Teacher Name : " + teacher.getTeacherName());
		System.out.println("Qualification : " + teacher.getQualification());
		System.out.println("______________________________________________");

		List<Student> students = teacher.getStudents();
		for (Student student : students) {
			System.out.println("Student Id : " + student.getStudentId());
			System.out.println("Student Name : " + student.getStudentName());
			System.out.println("Students Marks : " + student.getStudentMarks());
			System.out.println("______________________________________________");

		}
		((ConfigurableApplicationContext) applicationContext).close();// down casting for configurable class
	}

}
