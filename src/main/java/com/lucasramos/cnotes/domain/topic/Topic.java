package com.lucasramos.cnotes.domain.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;

@Entity
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private Long note;

    @CreatedDate
    @Column(nullable = false, name = "created_at")
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private OffsetDateTime updatedAt;

}