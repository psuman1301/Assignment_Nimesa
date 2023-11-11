package com.suman.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;

@Data
@Entity
@Table(name = "JOB_RESULTS")
public class JobResults {

    public static final String NOT_FOUND = ChangeSetPersister.ID_KEY;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_RESULT_ID")
    private Long jobResultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID")
    private Jobs jobs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESOURCE_ID")
    private Resources resources;

    @Column(name = "RESULT")
    private String result;
}