package com.suman.service;

import com.suman.entity.JobResults;
import com.suman.entity.Jobs;
import com.suman.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetJobResultService {

    @Autowired
    private JobsRepository jobsRepository;

    public String getJobResult(String jobId) {
        Optional<Jobs> jobOptional = jobsRepository.findById(Long.valueOf(jobId));
        if (jobOptional.isPresent()) {
            return jobOptional.get().getStatus();
        } else {
            return JobResults.NOT_FOUND;
        }
    }
}
