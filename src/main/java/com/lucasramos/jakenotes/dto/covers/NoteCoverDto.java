package com.lucasramos.jakenotes.dto.covers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteCoverDto {

    private Long id;
    private String title;
    private String summary;
    private String createdAt;
    private List<String> tags;
    private String folderName;
}