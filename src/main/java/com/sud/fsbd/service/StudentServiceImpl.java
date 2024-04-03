package com.sud.fsbd.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sud.fsbd.exceptionHandler.RecordNotFoundException;
import com.sud.fsbd.model.Student;
import com.sud.fsbd.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentServiceIfc{
	
	private Logger logger = LoggerFactory.getLogger("StudentServiceImpl");
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student st) {
		
		var stud = new com.sud.fsbd.entity.Student();
		stud.setRollNo(st.rollNo());
		stud.setName(st.name());
		stud.setAddress(st.address());
		stud.setEmail(st.email());
		stud.setMobile(st.mobile());
		
		studentRepo.save(stud);
		System.out.println("Data saved success !!!");
		return st;
	}

	@Override
	public List<com.sud.fsbd.entity.Student> listOfStudent() {
		logger.info("StudentServiceImpl : listOfStudent : inside");
		List<com.sud.fsbd.entity.Student> st = studentRepo.findAll();
		logger.info("List of Student : "+st);
		return st;
	}

	@Override
	public com.sud.fsbd.entity.Student studentBasedOnRollNo(int rollNo) throws Exception {
		
		Optional<com.sud.fsbd.entity.Student> st = studentRepo.findById(rollNo);
		
		if(st.isPresent()) {
			return st.get();
		}else {
			throw new RecordNotFoundException("Record not found for given rollNo : "+rollNo);	
		}
	}

	@Override
	public com.sud.fsbd.entity.Student deleteStudentBasedOnRollNo(int rollNo) {
		//studentsList.remove(studentsList.stream().filter(st->st.rollNo()==rollNo).findAny().get());
		var st = studentRepo.findById(rollNo).get();
		studentRepo.delete(st);
		return st;
	}

	@Override
	public List<com.sud.fsbd.entity.Student> findByName(String name) {
		return studentRepo.findResult(name);
	}

}
