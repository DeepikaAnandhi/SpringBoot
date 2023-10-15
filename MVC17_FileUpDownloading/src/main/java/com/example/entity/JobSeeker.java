package com.example.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Job_Seeker")
@Data
public class JobSeeker implements Serializable {
	@Id	
	@GeneratedValue
	private Integer jsId;
	
	@Column(length=20)
	private String jsName;
	
	@Column(length=20)
	private String jsAddress;
	
	@Column(length=20)
	private String qualification;
	
	@Column(length=150)
	private String resumePath;
	
	@Column(length=150)
	private String photoPath;
}
