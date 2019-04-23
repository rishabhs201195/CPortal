package com.namanraj.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namanraj.demo.model.Student;

public interface UserRepo extends JpaRepository<Student , String> {

}
