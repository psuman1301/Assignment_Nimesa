package com.suman.controller;

import com.suman.entity.JobResults;
import com.suman.service.DiscoveryService;
import com.suman.service.GetDiscoveryResultService;
import com.suman.service.GetJobResultService;
import com.suman.service.GetS3BucketObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryService discoveryService;

    @Autowired
    private GetJobResultService getJobResultService;

    @Autowired
    private GetDiscoveryResultService getDiscoveryResultService;

    @Autowired
    private GetS3BucketObjectsService getS3BucketObjectsService;

    @PostMapping(value = "/discoverServices")
    public ResponseEntity<String> discoverServices(@RequestBody List<String> services) {

        String jobId=discoveryService.getDiscoverServices(services);

        return new ResponseEntity<>(jobId, HttpStatus.CREATED);
    }

    @GetMapping("/jobResult/{jobId}")
    public ResponseEntity<String> getJobResult(@PathVariable String jobId) {
        String jobResult = getJobResultService.getJobResult(jobId);
        return ResponseEntity.ok(jobResult);
    }

    @GetMapping("/results/{service}")
    public ResponseEntity<List<String>> getDiscoveryResult(@PathVariable String service) {
        List<String> discoveryResults = getDiscoveryResultService.getDiscoveryResults(service);
        return ResponseEntity.ok(discoveryResults);
    }

    @PostMapping("/s3Objects/{bucketName}")
    public ResponseEntity<String> getS3BucketObjects(@PathVariable String bucketName) {
        String jobId = getS3BucketObjectsService.discoverS3BucketObjects(bucketName).toString();
        return ResponseEntity.ok(jobId);
    }

    @GetMapping("/s3ObjectsCount/{bucketName}")
    public ResponseEntity<Integer> getS3BucketObjectCount(@PathVariable String bucketName) {
        int objectCount = getS3BucketObjectsService.getS3BucketObjectCount(bucketName);
        return ResponseEntity.ok(objectCount);
    }

    @GetMapping("/s3ObjectsLike/{bucketName}/{pattern}")
    public ResponseEntity<List<String>> getS3BucketObjectLike(@PathVariable String bucketName, @PathVariable String pattern) {
        List<String> objectNames = getS3BucketObjectsService.getS3BucketObjectLike(bucketName, pattern);
        return ResponseEntity.ok(objectNames);
    }
}
