package com.model;

import java.util.List;

//to implement one to one relation == has
public class Teacher {
	private int teacherId;
	private String teacherName;
	private String qualification;
	private List<Student> students;// one to many relation(teacher can have many students)

	public Teacher(int teacherId, String teacherName, String qualification) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.qualification = qualification;

	}

	public Teacher() {
		super();
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
