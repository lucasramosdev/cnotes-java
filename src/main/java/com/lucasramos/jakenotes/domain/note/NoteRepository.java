package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.domain.folder.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByFolderId(Long folderId);
}