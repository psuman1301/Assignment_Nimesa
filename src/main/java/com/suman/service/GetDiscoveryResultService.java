package com.suman.service;

import com.suman.entity.Resources;
import com.suman.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetDiscoveryResultService {

    @Autowired
    private ResourcesRepository resourcesRepository;

    public List<String> getDiscoveryResults(String service) {
        if (service.equals("S3")) {
            List<Resources> s3Buckets = resourcesRepository.findByResourceType("S3");
            List<String> bucketNames = s3Buckets.stream().map(Resources::getResourceName).collect(Collectors.toList());
            return bucketNames;
        } else if (service.equals("EC2")) {
            List<Resources> ec2Instances = resourcesRepository.findByResourceType("EC2");
            List<String> instanceIds = ec2Instances.stream().map(Resources::getResourceName).collect(Collectors.toList());
            return instanceIds;
        } else {
            return new ArrayList<>();
        }
    }
}