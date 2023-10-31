package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.JobSeeker;

@Repository
public interface JobSeekerRepo extends JpaRepository<JobSeeker, Integer> {

	@Query("select resumePath from jobseeker where jsId=:id")
	public String getResumePath(Integer id);
}
