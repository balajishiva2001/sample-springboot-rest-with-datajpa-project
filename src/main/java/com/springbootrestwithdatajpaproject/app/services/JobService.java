package com.springbootrestwithdatajpaproject.app.services;

import java.util.List;

import com.springbootrestwithdatajpaproject.app.models.JobPostDto;

public interface JobService {

	void savePost(JobPostDto jobPostDto);
	
	List<JobPostDto> getAllJobPosts();
	
	JobPostDto getJobPostById(int postId);
	
	void updateJobPost(int postId, JobPostDto jobPostDto);
	
	void deleteJobPost(int postId);
	
	List<JobPostDto> searchByKeyword(String keyword);
	
	JobPostDto getJobPostByReqExperience(int reqExperience);
}
