package com.lucasramos.jakenotes.domain.folder;


import com.lucasramos.jakenotes.dto.FolderDto;
import com.lucasramos.jakenotes.dto.covers.FolderCoverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public FolderDto getFolderById(Long id) {
        Folder folder = folderService.getFolder(id);
        return folderMapper.toFolderDto(folder);
    }

    public List<FolderCoverDto> getSubFolders(Long mainFolderId) {
        Folder folder = folderService.getFolder(mainFolderId);
        return folder.getChildren().stream().map(folderMapper::toFolderCoverDto).toList();
    }
}