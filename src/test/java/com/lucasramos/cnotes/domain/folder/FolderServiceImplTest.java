package com.lucasramos.cnotes.domain.folder;


import com.lucasramos.cnotes.domain.note.Note;
import com.lucasramos.cnotes.domain.note.NoteRepository;
import com.lucasramos.cnotes.shared.CNotesIntegrationTest;
import com.lucasramos.cnotes.mock.MockFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FolderServiceImplTest extends CNotesIntegrationTest {

    @Autowired
    private MockFactory mockFactory;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private FolderService folderService;

    private void saveFolderWithNotes(String name, int numOfNotes) {
        Folder folder = folderRepository.save(mockFactory.buildFolder(name));
        for (int i = 0; i < numOfNotes; i++) {
            noteRepository.save(mockFactory.buildNote(folder.getId(), String.valueOf(i)));
        }
    }

    @Nested
    class Given_list_of_folders extends CNotesIntegrationTest {

        private List<Folder> listOfFolders = new ArrayList<>();

        @Nested
        class When_get_the_top_five_folders_with_more_notes extends CNotesIntegrationTest {

            private final int NUMBER_OF_FOLDERS = 5;

            @BeforeEach
            void setUp() {
                listOfFolders.clear();
                folderRepository.deleteAll();
                folderRepository.save(mockFactory.buildFolder("First Folder"));
                saveFolderWithNotes("Second Folder", 3);
                saveFolderWithNotes("Third Folder", 2);
                saveFolderWithNotes("Fourth Folder", 1);
                saveFolderWithNotes("Fifth Folder", 5);
                saveFolderWithNotes("Sixth Folder", 4);
                listOfFolders = folderService.getTopFiveFolders();
            }

            @Test
            void Then_should_return_folders_sorted_by_number_of_notes_desc() {
                assertEquals(5, listOfFolders.getFirst().getNotes().size());
                assertEquals(1, listOfFolders.getLast().getNotes().size());
            }

            @Test
            void Then_should_return_only_five_folders() {
                assertEquals(NUMBER_OF_FOLDERS, listOfFolders.size());
            }

        }
    }
}