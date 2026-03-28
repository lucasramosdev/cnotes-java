package com.lucasramos.jakenotes.domain.folder;

import com.lucasramos.jakenotes.dto.covers.FolderCoverDto;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;


@Component
public class FolderMapper {

    public FolderCoverDto toFolderCoverDto(Folder entity) {
        if (isNull(entity)) return null;
        return FolderCoverDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .countOfNotes(entity.getNotes().size())
                .build();
    }

}