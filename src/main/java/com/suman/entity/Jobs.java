package com.suman.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "JOBS")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_ID")
    private Long jobId;
    @Column(name = "JOB_TYPE")
    private String jobType;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "CREATION_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private
    Date creationTime;
    @Column(name = "COMPLETION_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completionTime;

}
