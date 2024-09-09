package com.springbootrestwithdatajpaproject.app.entities;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_post_details")
public class JobPostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	private String postProfile;

	private String postDesc;

	private int reqExperience;
	
	private String[] postTechStack;

	public JobPostEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobPostEntity(int postId, String postProfile, String postDesc, int reqExperience, String[] postTechStack) {
		super();
		this.postId = postId;
		this.postProfile = postProfile;
		this.postDesc = postDesc;
		this.reqExperience = reqExperience;
		this.postTechStack = postTechStack;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostProfile() {
		return postProfile;
	}

	public void setPostProfile(String postProfile) {
		this.postProfile = postProfile;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

	public int getReqExperience() {
		return reqExperience;
	}

	public void setReqExperience(int reqExperience) {
		this.reqExperience = reqExperience;
	}

	public String[] getPostTechStack() {
		return postTechStack;
	}

	public void setPostTechStack(String[] postTechStack) {
		this.postTechStack = postTechStack;
	}

	@Override
	public String toString() {
		return "JobPostEntity [postId=" + postId + ", postProfile=" + postProfile + ", postDesc=" + postDesc
				+ ", reqExperience=" + reqExperience + ", postTechStack=" + Arrays.toString(postTechStack) + "]";
	}
	
	
}
