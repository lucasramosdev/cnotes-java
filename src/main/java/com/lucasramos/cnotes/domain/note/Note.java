package com.lucasramos.cnotes.domain.note;

import com.lucasramos.cnotes.domain.topic.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes")
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long folder;

    @Column(nullable = false)
    private String title;

    @Column
    private String summary;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "notes_tags", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "value", nullable = false)
    private List<String> tags = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topic> topics = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, name = "created_at")
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private OffsetDateTime updatedAt;
}