package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.enums.EpochsForNoteCover;

public class HoursForNoteCoverChain {

    public static String getAboutHour(Long seconds) {
        if (seconds <= EpochsForNoteCover.HOUR.getSeconds()) {
            return "Menos de uma hora atrás";
        }

        return getHours(seconds);
    }

    public static String getHours(Long seconds) {
        if(seconds <= EpochsForNoteCover.DAY.getSeconds()) {
            Long hours = seconds / EpochsForNoteCover.HOUR.getSeconds();
            if (hours == 1) {
                return "Uma hora atrás";
            }

            return hours + " horas atrás";
        }

        return "Ontem";
    }
}
