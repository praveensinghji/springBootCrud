package com.praveen.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.praveen.cruddemo.DAO.StudentDAO;
import com.praveen.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudent(studentDAO);
//			queryForStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}
	
	
	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting All Students...");
		int noOfLineAffected = studentDAO.deleteAll();
		System.out.println(noOfLineAffected + " lines affected");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//delete Student by id
		int studentId = 3;
		System.out.println("Deleting the Student with id :" + studentId);
		studentDAO.delele(studentId);
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve Student Based on id : Primary Key
		int studentId = 3;
		System.out.println("Getting Student Id with : " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		//change first name to "Nileshwari"
		myStudent.setFirstName("Nileshwari");
		myStudent.setLastName("Shukla");
		myStudent.setEmail("Nileshwari@gmail.com");
		studentDAO.update(myStudent);
		
		//display updated Student
		System.out.println("Updated Student : " + myStudent);
		
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get List of Student
		List<Student> theStudent = studentDAO.findByLastName("Singh");
		
		//display the Students
		for(Student tempStudnet : theStudent) {
			System.out.println(tempStudnet);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get List of Student
		List<Student> theStudent = studentDAO.finAll();
		
		//display the Students
		for(Student tempstudent : theStudent) {
			System.out.println(tempstudent);
		}
	}

	public void createStudent(StudentDAO studentDAO) {
		// Create Student Object
		System.out.println("Creating Student new Object...");
		Student tempStudent = new Student("Sachi", "Singh", "sachi@gmail.com");
		
		//Save the Student Object
		System.out.println("Saving the Student Object...");
		studentDAO.save(tempStudent);
		
		//display id of save student
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());
		
		//All details
		System.out.println("All details: " + tempStudent.toString());
	}
	
	public void createMultipleStudent(StudentDAO studentDAO) {
		//Create Multiple Student Object
		System.out.println("Create Multiple Student Object");
		Student tempStudent1 = new Student("Shivam", "Mishra","shivam@gmail.com");
		Student tempStudent2 = new Student("Ayush", "Srivastva","ayush@gmail.com");
		Student tempStudent3 = new Student("Sandeep", "Singh","sandeep@gmail.com");
		Student tempStudent4 = new Student("Ashok", "Singh","ashok@gmail.com");
		
		
		//Saving Multiple Student Object
		System.out.println("Saving Multiple Student Object...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		
		//Desplay id of Save Multiple Students
		System.out.println("Saved Student. Generated ID: " + tempStudent1.getId());
		System.out.println("Saved Student. Generated ID: " + tempStudent2.getId());
		System.out.println("Saved Student. Generated ID: " + tempStudent3.getId());
		System.out.println("Saved Student. Generated ID: " + tempStudent4.getId());
	}
	
	public void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Object...");
		Student tempStudent = new Student("Shivam", "Mishra","shivam@gmail.com");
		
		//Save the Student Object
		System.out.println("Saving the Student Object...");
		studentDAO.save(tempStudent);
		
		//display id of save student
		System.out.println("Saved Student. Generated ID: " + tempStudent.getId());
		
		
		System.out.println("\nRetrieveing Student with id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());
		System.out.println("Found The Student: " + myStudent);
		
	}
}
