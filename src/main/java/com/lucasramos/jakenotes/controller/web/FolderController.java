package com.lucasramos.jakenotes.controller.web;

import com.lucasramos.jakenotes.domain.folder.FolderComponent;
import com.lucasramos.jakenotes.domain.note.NoteComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private FolderComponent folderComponent;

    @Autowired
    private NoteComponent noteComponent;

    @GetMapping("/{id}")
    public String getFolder(Model model, @PathVariable Long id) {

        model.addAttribute("styles", List.of("/css/folder.css"));
        model.addAttribute("content", "folder");
        model.addAttribute("folderName", folderComponent.getFolderById(id).getName());
        model.addAttribute("folders", folderComponent.getSubFolders(id));
        model.addAttribute("notes", noteComponent.getNotesByFolderId(id));
        return "layout";
    }

}