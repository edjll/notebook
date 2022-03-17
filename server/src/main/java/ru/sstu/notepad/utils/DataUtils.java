package ru.sstu.notepad.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DataUtils {
    public static final ZoneId SARATOV_ZONE = ZoneId.of("Europe/Saratov");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_INSTANT.withZone(SARATOV_ZONE);


    /**
     * <h2>Проверка вхожения первого периода firstDate в secondDate</h2>
     * @param firstStartDate дата начала первого периода
     * @param firstEndDate дата оканчания первого периода
     * @param secondStartDate дата начала второго периода
     * @param secondEndDate дата оканчания первого периода
     * @return true - secondDate входит в firstDate, иначе false
     */
    public static boolean isIncludedInPeriods(LocalDateTime firstStartDate,
                                              LocalDateTime firstEndDate,
                                              LocalDateTime secondStartDate,
                                              LocalDateTime secondEndDate){
        return isIncludeInPeriod(firstStartDate, firstEndDate, secondStartDate) ||
                isIncludeInPeriod(firstStartDate, firstEndDate, secondEndDate);
    }

    /**
     * <h2>Проверка вхожения даты в период</h2>
     * @param startDate дата начала периода
     * @param endDate дата оканчания периода
     * @param currentDate проверяемая дата
     * @return true - currentDate входит в [startDate; endDate], иначе false
     */
    public static boolean isIncludeInPeriod(LocalDateTime startDate,
                                            LocalDateTime endDate,
                                            LocalDateTime currentDate){
        return currentDate.isAfter(startDate) && currentDate.isBefore(endDate);
    }
}
