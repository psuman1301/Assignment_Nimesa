package com.suman.repository;

import com.suman.entity.JobResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobResultsRepository extends JpaRepository<JobResults, Long> {

    List<JobResults> findByJobId(Long jobId);

    List<JobResults> findByJobIdAndResourceType(Long jobId, String resourceType);

    List<JobResults> findByResourceId(Long resourceId);
}