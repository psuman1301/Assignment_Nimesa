package com.suman.repository;

import com.suman.entity.Objects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectsRepository extends JpaRepository<Objects, Long> {

    List<Objects> findByBucketName(String bucketName);

    List<Objects> findByNameLike(String pattern);

    List<Objects> findBySizeGreaterThan(Long size);

    List<Objects> findByBucketNameAndObjectNameLike(String bucketName, String pattern);

}
