package com.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dao.StudentRepo;
import com.rest.model.Student;

@RestController
public class StudentController
{
	
	@Autowired
	StudentRepo repo;
	
	
	@PostMapping(path="/student" ,consumes= {"application/json"})
	public Student addStudent(@RequestBody Student student) {
		repo.save(student);
		return student;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		return repo.findAll();
	}
	
	@GetMapping("/student/{sid}")
	public Optional<Student> getStudent(@PathVariable("sid") int sid)
	{
		return repo.findById(sid);
	}	
	
}
