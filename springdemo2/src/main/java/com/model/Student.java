package com.model;

//Its a POJO file where will always Strictly follow this standard(private var's,default constructors,getr and setr)
public class Student {
	private int studentId;
	private String studentName;
	private float studentMarks;

	public Student() {
		super();
		System.out.println("Student Constructor");
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public float getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(float studentMarks) {
		this.studentMarks = studentMarks;
	}

	public Student(int studentId, String studentName, float studentMarks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
	}

	public void hello() {
		// Init(bean created)
		System.out.println("InitializingBean() is called!!!");
	}

	public void bye() {
		// logic(bean)is destroyed
		System.out.println("DisposableBean() is called!!!");
	}

	/*
	 * @Override public void afterPropertiesSet() throws Exception {
	 * System.out.println("InitializingBean() is called!!!");// to know the life
	 * cycle of bean i.e whether it is // created or not
	 * 
	 * }
	 * 
	 * @Override public void destroy() throws Exception {
	 * System.out.println("DisposableBean() is called!!!");// to know the life cycle
	 * of bean i.e whether it is
	 */ // distroyed(Disposable) or not
//Still in spring we dont have access to create or destroy the beans thats why spring IOC container
}
