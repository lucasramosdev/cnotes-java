package com.lucasramos.jakenotes.dto;

import com.lucasramos.jakenotes.domain.folder.Folder;
import com.lucasramos.jakenotes.domain.note.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderDto implements Serializable {

    private Long id;
    private String name;
    private Long parent;
    private List<FolderDto> children = new ArrayList<>();

}