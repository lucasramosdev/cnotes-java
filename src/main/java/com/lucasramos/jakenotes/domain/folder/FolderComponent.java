package com.lucasramos.jakenotes.domain.folder;


import com.lucasramos.jakenotes.dto.covers.FolderCoverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FolderComponent {

    @Autowired
    private FolderService folderService;

    @Autowired
    private FolderMapper folderMapper;

    public List<FolderCoverDto> getTopFiveFolders() {
        List<Folder> folders = folderService.getTopFiveFolders();
        return folders.stream().map(folderMapper::toFolderCoverDto).toList();
    }
}
