package com.example.springbootdemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyRestController {
	// Request handler
	// @RequestMapping
	@GetMapping(value = "one", produces = MediaType.APPLICATION_JSON_VALUE)
	public String firstFunction() {
		return "Welcome to SpringBoot";

	}
}
