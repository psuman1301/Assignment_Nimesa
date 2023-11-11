package com.suman.repository;

import com.suman.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {

    List<Jobs> findByJobType(String jobType);

    List<Jobs> findByStatus(String status);

    List<Jobs> findByCreationTimeBetween(Date fromTime, Date toTime);
}
