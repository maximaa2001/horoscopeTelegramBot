package com.maks.bot.horoscope.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public final class TimeUtils {
    private static final DecimalFormat df = new DecimalFormat("#.##");
    private static final String UTC_PLUS_3_ZONE_ID = "UTC+3";

    public static ZoneId getZoneId() {
        return ZoneId.of(UTC_PLUS_3_ZONE_ID);
    }

    public static LocalTime getTimeUTC_3() {
        return LocalTime.now(getZoneId());
    }

    public static LocalTime getTime(int hours) {
        return LocalTime.of(hours, 0, 0);
    }

    public static LocalDateTime getDateTimeUTC_3() {
        return LocalDateTime.now(getZoneId());
    }

    public static float differenceMinutes(LocalDateTime startDate, LocalDateTime finishDate) {
        long seconds = differenceSeconds(startDate, finishDate);
        return (float) seconds / 60;
    }

    public static float roundFloat(float decimal) {
        return Float.parseFloat(df.format(decimal));
    }

    private static long differenceSeconds(LocalDateTime startDate, LocalDateTime finishDate) {
        Timestamp finish = Timestamp.valueOf(finishDate);
        Timestamp start = Timestamp.valueOf(startDate);
        long nano = finish.getTime() - start.getTime();
        return nano / 1000;
    }

}
