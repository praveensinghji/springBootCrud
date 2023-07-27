package com.praveen.cruddemo.DAO;

import java.util.List;

import com.praveen.cruddemo.entity.Student;

public interface StudentDAO {
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> finAll();
	
	List<Student> findByLastName(String lastName);
	
	void update(Student theStudent);
	
	void delele(Integer id);
	
	int deleteAll();
}
