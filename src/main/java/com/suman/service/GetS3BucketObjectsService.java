package com.suman.service;

import com.suman.entity.Objects;
import com.suman.repository.ObjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
public class GetS3BucketObjectsService {

    @Autowired
    private ObjectsRepository objectsRepository;

    public String discoverS3BucketObjects(String bucketName) {
        String jobId = UUID.randomUUID().toString();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(() -> {
            List<Objects> s3Objects = discoverS3BucketObjects1(bucketName);
            persistS3ObjectsToDB(s3Objects);
        });

        return jobId;
    }

    private List<Objects> discoverS3BucketObjects1(String bucketName) {
        // Implement S3 bucket object discovery logic here
        return new ArrayList<>();
    }

    private void persistS3ObjectsToDB(List<Objects> objects) {
        objects.forEach(object -> objectsRepository.save(object));
    }

    public int getS3BucketObjectCount(String bucketName) {
        return objectsRepository.findByBucketName(bucketName).size();
    }

    public List<String> getS3BucketObjectLike(String bucketName, String pattern) {
        return objectsRepository.findByBucketNameAndObjectNameLike(bucketName, pattern)
                .stream()
                .map(Objects::getObjectName)
                .collect(Collectors.toList());
    }
}
