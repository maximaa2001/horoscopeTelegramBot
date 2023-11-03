package com.maks.bot.horoscope.constant.define;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum HoroscopeDateDefine {
    TODAY((short) 1, "TODAY", "Сегодня"),
    TOMORROW((short) 2, "TOMORROW", "Завтра");

    private final Short id;
    private final String englishName;
    private final String russianName;

    public static HoroscopeDateDefine of(String englishName) {
        return Arrays.stream(HoroscopeDateDefine.values())
                .filter(e -> e.getEnglishName().equals(englishName))
                .findAny().orElse(null);
    }
}
