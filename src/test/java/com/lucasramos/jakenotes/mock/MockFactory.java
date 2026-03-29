package com.lucasramos.jakenotes.mock;

import com.lucasramos.jakenotes.domain.folder.Folder;
import com.lucasramos.jakenotes.domain.note.Note;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockFactory {

    public Folder buildFolder(String name) {
        return Folder.builder().name(name).build();
    }

    public Note buildNoteForFolder(Folder folder, String name) {
        String title = String.format("Note %s for Folder %d", name, folder.getId());
        return Note.builder().title(title).folder(folder).build();
    }

    public Note buildNote(String title) {
        return Note.builder().title(title).build();
    }

    public Note buildNote(String title, List<String> tags) {
        return Note.builder().title(title).tags(tags).build();
    }
}