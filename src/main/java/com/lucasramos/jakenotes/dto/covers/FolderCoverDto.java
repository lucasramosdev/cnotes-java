package com.lucasramos.jakenotes.dto.covers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderCoverDto {

    private Long id;
    private String name;
    private int countOfNotes;

}