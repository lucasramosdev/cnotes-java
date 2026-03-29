package com.lucasramos.jakenotes.domain.folder;

import com.lucasramos.jakenotes.dto.FolderDto;
import com.lucasramos.jakenotes.dto.covers.FolderCoverDto;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public FolderDto toFolderDto(Folder entity) {
        if (isNull(entity)) return null;
        List<FolderDto>  children = entity.getChildren().stream().map(this::toFolderDto).toList();
        return FolderDto.builder()
                .id(entity.getId())
                .parent(entity.getParent())
                .children(children)
                .name(entity.getName())
                .build();
    }

}