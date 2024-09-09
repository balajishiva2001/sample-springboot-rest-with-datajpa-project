package com.springbootrestwithdatajpaproject.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestwithdatajpaproject.app.entities.JobPostEntity;
import com.springbootrestwithdatajpaproject.app.models.JobPostDto;
import com.springbootrestwithdatajpaproject.app.repos.JobRepo;
import com.springbootrestwithdatajpaproject.app.utils.ModelMapper;

@Service
public class JobServiceImpl implements JobService {

	private final JobRepo jobRepo;

	private final ModelMapper modelMapper;

	@Autowired
	public JobServiceImpl(JobRepo jobRepo, ModelMapper modelMapper) {
		this.jobRepo = jobRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public void savePost(JobPostDto jobPostDto) {
		jobRepo.save(modelMapper.mapToJobPostEntity(jobPostDto));
	}

	@Override
	public List<JobPostDto> getAllJobPosts() {
		return jobRepo.findAll().stream().map(e -> modelMapper.mapToJobPostDto(e)).toList();
	}

	@Override
	public JobPostDto getJobPostById(int postId) {
		return jobRepo.findById(postId).map(e -> modelMapper.mapToJobPostDto(e)).orElse(new JobPostDto());
	}

	@Override
	public void updateJobPost(int postId, JobPostDto jobPostDto) {
		JobPostEntity jobPostEntity = jobRepo.findById(postId).get();
		jobPostEntity.setPostProfile(jobPostDto.getPostProfile());
		jobPostEntity.setPostDesc(jobPostDto.getPostDesc());
		jobPostEntity.setReqExperience(jobPostDto.getReqExperience());
		jobPostEntity.setPostTechStack(jobPostDto.getPostTechStack());
		jobRepo.save(jobPostEntity);
	}

	@Override
	public void deleteJobPost(int postId) {
		jobRepo.delete(jobRepo.findById(postId).get());

	}

	@Override
	public List<JobPostDto> searchByKeyword(String keyword) {
		return jobRepo.findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(keyword, keyword).stream()
				.map(e -> modelMapper.mapToJobPostDto(e)).toList();
	}

	@Override
	public JobPostDto getJobPostByReqExperience(int reqExperience) {
		JobPostEntity jobPostEntity= jobRepo.findByReqExperience(reqExperience);
		return modelMapper.mapToJobPostDto(jobPostEntity);
	}

}
