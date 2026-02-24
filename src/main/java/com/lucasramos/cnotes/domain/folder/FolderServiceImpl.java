package com.lucasramos.cnotes.domain.folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderRepository folderRepository;

    public List<Folder> getTopFiveFolders() {
        return folderRepository.findFirst5ByOrderByNotesCountDesc();
    }
}