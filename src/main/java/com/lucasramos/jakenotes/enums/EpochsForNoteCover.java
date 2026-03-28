package com.lucasramos.jakenotes.enums;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EpochsForNoteCover {

    HOUR(3600L),
    DAY(86400L),
    YEAR(31104000L);

    private Long seconds;

    public Long multiply(Long numberToMultiply) {
        return this.seconds * numberToMultiply;
    }
}
