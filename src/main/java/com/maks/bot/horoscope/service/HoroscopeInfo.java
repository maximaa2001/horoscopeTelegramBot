package com.maks.bot.horoscope.service;

import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HoroscopeInfo {
    private String commonHoroscope;
    private String loveHoroscope;
    private String workHoroscope;

    public String initMessage(ZodiacSignDefine zodiacSign) {
        String a = "\uuD83D\uDCBC";
        return String.format("Общий %s:\n%s\n\nЛюбовный \u2665:\n%s\n\nРабочий \uD83D\uDCBC:\n%s\n\n",zodiacSign.getEmoji(), commonHoroscope, loveHoroscope, workHoroscope);
    }
}
