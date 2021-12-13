package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.HelloWorld;

public class SpringDemo {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");
		HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
		obj.getMessage();

	}
}
