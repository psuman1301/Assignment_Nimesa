package com.suman.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "OBJECTS")
public class Objects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OBJECT_ID")
    private Long objectId;

    @Column(name = "BUCKET_NAME")
    private String bucketName;

    @Column(name = "OBJECT_NAME")
    private String objectName;

    @Column(name = "SIZE")
    private Long size;

    @Column(name = "LAST_MODIFIED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTime;
}