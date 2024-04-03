package com.sud.fsbd.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.sud.fsbd.model.Student;

@Configuration
public interface StudentServiceIfc {

	public Student saveStudent(Student st);
	
	public List<com.sud.fsbd.entity.Student> listOfStudent();

	public com.sud.fsbd.entity.Student studentBasedOnRollNo(int rollNo) throws Exception;

	public com.sud.fsbd.entity.Student deleteStudentBasedOnRollNo(int rollNo);
	
	public List<com.sud.fsbd.entity.Student> findByName(String name);
	
}
