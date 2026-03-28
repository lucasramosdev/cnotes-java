package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.domain.folder.Folder;
import com.lucasramos.jakenotes.domain.topic.Topic;
import com.lucasramos.jakenotes.enums.EpochsForNoteCover;
import com.lucasramos.jakenotes.infra.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "notes")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    @Column(nullable = false)
    private String title;

    @Column
    private String summary;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "notes_tags", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "tag_value", nullable = false)
    @Builder.Default
    private List<String> tags = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "note")
    @Builder.Default
    private List<Topic> topics = new ArrayList<>();

    @JsonIgnore
    public String getCreatedAtForNoteCover() {
        OffsetDateTime now = OffsetDateTime.now();
        Long seconds = ChronoUnit.SECONDS.between(this.createdAt, now);

        if(seconds <= EpochsForNoteCover.DAY.multiply(2L)) {
            return HoursForNoteCoverChain.getAboutHour(seconds);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.of("pt", "BR"));
        return this.createdAt.format(formatter);
    }
}