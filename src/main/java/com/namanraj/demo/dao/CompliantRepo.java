package com.namanraj.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.namanraj.demo.model.Complaint;

@Repository
public interface CompliantRepo extends JpaRepository<Complaint , Integer> 
{
	List<Complaint> findByCtype(String ctype);
	
	List<Complaint> findByRoll(String roll);
	
	@Query(value = "SELECT * FROM complaint t WHERE t.ctype = 'mess'", nativeQuery=true)
	List<Complaint> findByFcom();
	
	@Query(value = "SELECT * FROM complaint t WHERE t.ctype = 'sac'", nativeQuery=true)
	List<Complaint> findBySac();
	
	@Query(value = "SELECT * FROM complaint t WHERE t.ctype = 'sac' and t.hostel = 'Bhaskara'", nativeQuery=true)
	List<Complaint> findByWardenAndMen();
	
	@Query(value = "SELECT * FROM complaint t WHERE t.ctype = 'sac' and t.hostel = 'Lilavati'", nativeQuery=true)
	List<Complaint> findByWardenAndWomen();
	
	@Query(value = "SELECT * FROM complaint t WHERE t.ctype = 'sport'", nativeQuery=true)
	List<Complaint> findByScom();
	
	@Query(value = "SELECT * FROM complaint t WHERE t.ctype = 'net'", nativeQuery=true)
	List<Complaint> findByNetcom();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE complaint t set t.status = ?1 , t.message = ?2 WHERE t.id=?3 ", nativeQuery=true)
	int updateComplaint(String status , String message ,  int id);
	


}
