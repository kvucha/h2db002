package com.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rest.model.Student;
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
