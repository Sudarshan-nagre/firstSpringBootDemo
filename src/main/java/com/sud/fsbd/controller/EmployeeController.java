package com.sud.fsbd.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sud.fsbd.model.Student;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student st) {
		return null;
	}
}
