package com.lucasramos.cnotes.domain.folder;

import com.lucasramos.cnotes.domain.note.Note;
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
@Table(name = "folders")
@NoArgsConstructor
@AllArgsConstructor
public class Folder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Long parent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Folder> children = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> notes = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, name = "created_at")
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private OffsetDateTime updatedAt;

}