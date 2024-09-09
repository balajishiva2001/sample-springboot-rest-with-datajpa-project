package com.springbootrestwithdatajpaproject.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootrestwithdatajpaproject.app.entities.JobPostEntity;

@Repository
public interface JobRepo extends JpaRepository<JobPostEntity, Integer> {
	
	/*
	 * To some extent we can create JPA Query using Domain Specific Language
	 */
	List<JobPostEntity> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String postProfile, String postDesc);
	
	/*
	 * Using Native Query=> use the database name and related fields to refer
	 * @Query(value = "select * from job_post_details s where s.req_experience= ?1",nativeQuery = true)
	 * @Query(value = "select * from job_post_details s where s.req_experience= :reqExperience",nativeQuery = true)
	 */
	
	/*
	 * Using JPQL=> use the entity name and related fields to refer
	 * Jakarta Persistence Query Language (JPQL; formerly Java Persistence Query Language)
	 * @Query("select s from JobPostEntity s where s.reqExperience= :reqExperience")
	 * @Query("select s from JobPostEntity s where s.reqExperience= ?1")
	 */

	@Query("select s from JobPostEntity s where s.reqExperience= ?1")
	JobPostEntity findByReqExperience(int reqExperience);
}
