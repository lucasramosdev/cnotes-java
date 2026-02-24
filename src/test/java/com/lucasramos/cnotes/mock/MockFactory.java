package com.lucasramos.cnotes.mock;

import com.lucasramos.cnotes.domain.folder.Folder;
import com.lucasramos.cnotes.domain.note.Note;
import org.springframework.stereotype.Component;

@Component
public class MockFactory {

    public Folder buildFolder(String name) {
        return Folder.builder().name(name).build();
    }

    public Note buildNote(Long folderId, String name) {
        String title = String.format("Note %s for Folder %d", name, folderId);
        return Note.builder().title(title).folder(folderId).build();
    }
}