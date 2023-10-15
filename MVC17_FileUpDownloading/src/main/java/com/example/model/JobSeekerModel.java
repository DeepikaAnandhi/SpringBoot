package com.example.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class JobSeekerModel implements Serializable {
	
	private Integer jsId;
	
	private String jsName;
		
	private String jsAddress;
	
	private String qualification;
	
	private MultipartFile resume;
	
	private MultipartFile photo;
}
