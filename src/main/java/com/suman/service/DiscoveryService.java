package com.suman.service;

import com.suman.entity.Resources;
import com.suman.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class DiscoveryService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    public String getDiscoverServices(List<String> services) {
        String jobId = UUID.randomUUID().toString();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            List<Resources> ec2Instances = discoverEC2Instances("mumbai");
            persistResourcesToDB(ec2Instances, "EC2");
        });

        executorService.submit(() -> {
            List<Resources> s3Buckets = discoverS3Buckets();
            persistResourcesToDB(s3Buckets, "S3");
        });

        return jobId;
    }

    private List<Resources> discoverEC2Instances(String region) {
        return new ArrayList<>();
    }

    private List<Resources> discoverS3Buckets() {
        return new ArrayList<>();
    }

    private void persistResourcesToDB(List<Resources> resources, String resourceType) {
        resources.forEach(resource -> {
            resource.setResourceType(resourceType);
            resourcesRepository.save(resource);
        });
    }
}
