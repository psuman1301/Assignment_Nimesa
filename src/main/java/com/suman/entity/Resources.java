package com.suman.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RESOURCES")
public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESOURCE_ID")
    private Long resourceId;
    @Column(name = "RESOURCE_TYPE")
    private String resourceType;
    @Column(name = "RESOURCE_NAME")
    private String resourceName;
    @Column(name = "REGION")
    private String region;
}
