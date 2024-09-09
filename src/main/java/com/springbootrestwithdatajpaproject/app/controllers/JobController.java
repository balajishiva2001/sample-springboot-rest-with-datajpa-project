package com.springbootrestwithdatajpaproject.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestwithdatajpaproject.app.models.JobPostDto;
import com.springbootrestwithdatajpaproject.app.services.JobService;

@RestController
public class JobController {

	private final JobService jobService;

	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/addJobPost")
	public ResponseEntity<String> createJobPost(@RequestBody JobPostDto jobPostDto) {
		System.out.println(jobPostDto.toString());
		jobService.savePost(jobPostDto);
		return new ResponseEntity<String>("Added new jobPost", HttpStatus.CREATED);
	}

	@GetMapping("/jobPosts")
	public ResponseEntity<List<JobPostDto>> getJobPosts() {
		return new ResponseEntity<List<JobPostDto>>(jobService.getAllJobPosts(), HttpStatus.OK);
	}

	@GetMapping("/jobPost/{postId}")
	public ResponseEntity<JobPostDto> getJobPost(@PathVariable("postId") int postId) {
		return new ResponseEntity<JobPostDto>(jobService.getJobPostById(postId), HttpStatus.OK);
	}

	@PutMapping("/jobPost/{postId}")
	public ResponseEntity<String> updateJobPost(@PathVariable("postId") int postId,
			@RequestBody JobPostDto jobPostDto) {
		jobService.updateJobPost(postId, jobPostDto);
		return new ResponseEntity<String>("Updated the jobPost", HttpStatus.OK);
	}

	@DeleteMapping("/jobPost/{postId}")
	public ResponseEntity<String> deleteJobPost(@PathVariable("postId") int postId) {
		jobService.deleteJobPost(postId);
		return new ResponseEntity<String>("Deleted the jobPost", HttpStatus.OK);
	}

	@GetMapping("/jobPosts/keyword/{keyword}")
	public ResponseEntity<List<JobPostDto>> getJobPostsByKeyword(@PathVariable("keyword") String keyword) {
		return new ResponseEntity<List<JobPostDto>>(jobService.searchByKeyword(keyword), HttpStatus.OK);
	}

	@GetMapping("/jobPost/reqExperience/{reqExperience}")
	public ResponseEntity<JobPostDto> getJobPostByReqExperience(@PathVariable("reqExperience") int reqExperience) {
		return new ResponseEntity<JobPostDto>(jobService.getJobPostByReqExperience(reqExperience), HttpStatus.OK);
	}
}
