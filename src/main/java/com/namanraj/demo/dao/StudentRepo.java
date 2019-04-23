package com.namanraj.demo.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.namanraj.demo.model.Student;


public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	public Student findByRoll(String roll); 
	
	public Student findByRollAndPassword(String roll , String password); 
	
	public Student findByRollAndRoom(String roll , int room); 
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE student s set s.password = ?1 , s.email = ?2 , s.name = ?3 WHERE s.roll=?4 ", nativeQuery=true)
	void updateStudent(String password , String email , String name ,  String roll);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE student s set s.password = ?1 WHERE s.roll=?2 ", nativeQuery=true)
	void updatePassword(String password , String roll);

}
