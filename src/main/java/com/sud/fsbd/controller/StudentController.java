package com.sud.fsbd.controller;

import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sud.fsbd.model.Student;
import com.sud.fsbd.service.StudentServiceIfc;

@RestController
@RequestMapping("/student")
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentServiceIfc studentServiceIfc;

	@Value("${aws.userName}")
	private String userName;

	@Value("${aws.password}")
	private String pwd;

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student st) {
		return studentServiceIfc.saveStudent(st);
	}

	@GetMapping("/list")
	public List<com.sud.fsbd.entity.Student> listOfStudents() {
		logger.info("This is simple logger info test");
		logger.trace("This is trace test");
		logger.debug("This is debug");
		logger.error("This is error");
		logger.warn("This is warning");
		logger.info("AWS UserName : {} Password : {}", new String(Base64.getDecoder().decode(userName)), pwd);
		return studentServiceIfc.listOfStudent();
	}
	/*
	 * @GetMapping("/find/{rollNo}") public com.sud.fsbd.entity.Studentm
	 * studentBasedOnRollNo(@PathVariable int rollNo) { return
	 * studentServiceIfc.studentBasedOnRollNo(rollNo); }
	 */

	@GetMapping("/find")
	public com.sud.fsbd.entity.Student findStudentBasedOnRollNo(@RequestParam int rollNo) throws Exception {
		return studentServiceIfc.studentBasedOnRollNo(rollNo);
	}

	@DeleteMapping("/delete")
	public com.sud.fsbd.entity.Student deleteStudentBasedOnRollNo(@RequestParam int rollNo) {
		return studentServiceIfc.deleteStudentBasedOnRollNo(rollNo);
	}

	@GetMapping("/find/{name}")
	public List<com.sud.fsbd.entity.Student> findByName(@PathVariable String name) {
		return studentServiceIfc.findByName(name);
	}
}

//swagger doc -> open documnen
