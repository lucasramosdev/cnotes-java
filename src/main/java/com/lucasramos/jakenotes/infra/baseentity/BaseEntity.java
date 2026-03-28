package com.lucasramos.jakenotes.infra.baseentity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@MappedSuperclass
public class BaseEntity {

    @CreationTimestamp
    @Column(nullable = false, name = "created_at", updatable = false)
    protected OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false, name = "updated_at")
    private OffsetDateTime updatedAt;
}