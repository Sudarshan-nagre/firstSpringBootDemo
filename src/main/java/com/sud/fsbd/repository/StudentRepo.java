package com.sud.fsbd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sud.fsbd.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	@Query(value = "Select * from Student s where s.name=?1", nativeQuery = true)
	public List<Student> findByName(String name);
	
	@Query(value = "Select * from Student s where s.name=?1 or s.email=?1 or s.address=?1", nativeQuery = true)
	public List<Student> findResult(String name);
}
