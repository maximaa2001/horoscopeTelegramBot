package com.maks.bot.horoscope.constant.define;

import com.maks.bot.horoscope.db.entity.ZodiacSign;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ZodiacSignDefine {
    ARIES((short) 1, "ARIES", "Овен", '\u2648'),
    TAURUS((short) 2, "TAURUS", "Телец", '\u2649'),
    GEMINI((short) 3, "GEMINI", "Близнецы", '\u264A'),
    CANCER((short) 4, "CANCER", "Рак", '\u264B'),
    LEO((short) 5, "LEO", "Лев", '\u264C'),
    VIRGO((short) 6, "VIRGO", "Дева", '\u264D'),
    LIBRA((short) 7, "LIBRA", "Весы", '\u264E'),
    SCORPIO((short) 8, "SCORPIO", "Скорпион", '\u264F'),
    SAGITTARIUS((short) 9, "SAGITTARIUS", "Стрелец", '\u2650'),
    CAPRICORN((short) 10, "CAPRICORN", "Козерог", '\u2651'),
    AQUARIUS((short) 11, "AQUARIUS", "Водолей", '\u2652'),
    PISCES((short) 12, "PISCES", "Рыбы", '\u2653');

    private final Short id;
    private final String englishName;
    private final String russianName;
    private final char emoji;

    public static List<ZodiacSign> getAll() {
        return Arrays.stream(ZodiacSignDefine.values())
                .map(ZodiacSign::new)
                .toList();
    }

    public static ZodiacSignDefine of(String englishName) {
        return Arrays.stream(ZodiacSignDefine.values())
                .filter(e -> e.getEnglishName().equals(englishName))
                .findAny().orElse(null);
    }
}
