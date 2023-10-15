package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.JobSeeker;
import com.example.repository.JobSeekerRepo;

@Service
public class JobSeekerService {
	
	@Autowired
	private JobSeekerRepo repo;
	
	
	public String saveJobSeeker(JobSeeker jobSeeker) {
		Integer id = repo.save(jobSeeker).getJsId();
		return "You are registered with an ID: " + id;
	}
}
