package com.springbootrestwithdatajpaproject.app.utils;

import org.springframework.stereotype.Component;

import com.springbootrestwithdatajpaproject.app.entities.JobPostEntity;
import com.springbootrestwithdatajpaproject.app.models.JobPostDto;

@Component
public class ModelMapper {

	public JobPostDto mapToJobPostDto(JobPostEntity jobPostEntity) {
		JobPostDto jobPostDto = new JobPostDto();
		jobPostDto.setPostId(jobPostEntity.getPostId());
		jobPostDto.setPostProfile(jobPostEntity.getPostProfile());
		jobPostDto.setPostDesc(jobPostEntity.getPostDesc());
		jobPostDto.setReqExperience(jobPostEntity.getReqExperience());
		jobPostDto.setPostTechStack(jobPostEntity.getPostTechStack());
		return jobPostDto;
	}

	public JobPostEntity mapToJobPostEntity(JobPostDto jobPostDto) {
		JobPostEntity jobPostEntity = new JobPostEntity();
		jobPostEntity.setPostId(jobPostDto.getPostId());
		jobPostEntity.setPostProfile(jobPostDto.getPostProfile());
		jobPostEntity.setPostDesc(jobPostDto.getPostDesc());
		jobPostEntity.setReqExperience(jobPostDto.getReqExperience());
		jobPostEntity.setPostTechStack(jobPostDto.getPostTechStack());
		return jobPostEntity;
	}
}
