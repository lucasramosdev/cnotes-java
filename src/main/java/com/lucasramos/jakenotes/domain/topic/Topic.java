package com.lucasramos.jakenotes.domain.topic;

import com.lucasramos.jakenotes.domain.note.Note;
import com.lucasramos.jakenotes.infra.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "topics")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Topic extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private String details;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;
}