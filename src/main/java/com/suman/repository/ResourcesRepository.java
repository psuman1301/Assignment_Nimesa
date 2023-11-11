package com.suman.repository;

import com.suman.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources, Long> {

    List<Resources> findByResourceType(String resourceType);

    List<Resources> findByResourceName(String resourceName);

    List<Resources> findByRegion(String region);
}
