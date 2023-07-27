package com.praveen.cruddemo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.praveen.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> finAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		//Create Query
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student Where lastName = :theData", Student.class);
		
		//set Query Parameter
		theQuery.setParameter("theData", theLastName);
		
		//return query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delele(Integer id) {
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
		
	}

	@Override
	@Transactional
	public int deleteAll() {
		int noOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return noOfRowsDeleted;
	}

}
