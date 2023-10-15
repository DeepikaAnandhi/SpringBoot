package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="job")
@Data
public class Job {
	@Id
	@GeneratedValue
	private Integer jobId;
	
	private String jobName;
	
	
	
	

}
