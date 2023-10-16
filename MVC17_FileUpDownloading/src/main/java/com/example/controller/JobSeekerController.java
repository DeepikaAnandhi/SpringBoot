package com.example.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.JobSeeker;
import com.example.model.JobSeekerModel;
import com.example.service.JobSeekerService;

@Controller
public class JobSeekerController {
	@Autowired
	private JobSeekerService service;

	@Autowired
	private Environment env;

	@GetMapping("/")
	public String showHome() {
		return "index";
	}

	@GetMapping("/js_register")
	public String registerForm(@ModelAttribute("js") JobSeekerModel jobSeekerModel) {
		return "registrationForm";
	}
	
	@PostMapping("/js_register")
	public String registerJs(Map<String, Object> map, @ModelAttribute("js") JobSeekerModel jobSeekerModel)
			throws Exception {

//Get folder location of file uploading from application.properties file
		String storeLocation = env.getRequiredProperty("upload.location");

// Create storeLocation Folder if its not already there
		File storeLocationFolder = new File(storeLocation);

		if (!storeLocationFolder.exists()) {
			storeLocationFolder.mkdir(); // Create Folder
		}

//Get MultipartFile Object 	representing the uploaded file
		MultipartFile resumeFile = jobSeekerModel.getResume();
		MultipartFile photoFile = jobSeekerModel.getPhoto();

//Create input Stream from the MultipartFile Object
		InputStream resumeFIS = resumeFile.getInputStream();
		InputStream photoFIS = photoFile.getInputStream();

//Get Original file name
		String resumeOriFName = resumeFile.getOriginalFilename();
		String photoOriFName = photoFile.getOriginalFilename();

//Create output stream having destination file names
		OutputStream resumeFOS = new FileOutputStream(storeLocationFolder.getAbsolutePath() + "/" + resumeOriFName);
		OutputStream photoFOS = new FileOutputStream(storeLocationFolder.getAbsolutePath() + "/" + photoOriFName);

//copy the content of uploaded files to Dest files
		IOUtils.copy(resumeFIS, resumeFOS);
		IOUtils.copy(photoFIS, photoFOS);

//Close the Streams
		resumeFIS.close();
		resumeFOS.close();
		photoFIS.close();
		photoFIS.close();

//Create entity class object having content of model class object
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setJsName(jobSeekerModel.getJsName());
		jobSeeker.setJsAddress(jobSeekerModel.getJsAddress());
		jobSeeker.setQualification(jobSeekerModel.getQualification());
		jobSeeker.setPhotoPath(storeLocationFolder.getAbsolutePath() + "/" + resumeOriFName);
		jobSeeker.setResumePath(storeLocationFolder.getAbsolutePath() + "/" + photoOriFName);
		
		
		String resultMsg = service.saveJobSeeker(jobSeeker);
		map.put("photoOriFName",photoOriFName );
		map.put("resumeOriFName", resumeOriFName);
		map.put("resultMsg", resultMsg);

		return "show_result";

	}

}
