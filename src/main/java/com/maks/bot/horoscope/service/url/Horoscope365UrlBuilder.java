package com.maks.bot.horoscope.service.url;

import com.maks.bot.horoscope.constant.define.HoroscopeDateDefine;
import com.maks.bot.horoscope.constant.define.HoroscopeTypeDefine;
import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import com.maks.bot.horoscope.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Horoscope365UrlBuilder implements HoroscopeUrlBuilder {
    private static final String HOROSCOPE_365_HOST = "https://goroskop365.ru";
    private static final String COMMON_TYPE_URL_PART = "";
    private static final String LOVE_TYPE_URL_PART = "/lyubov";
    private static final String WORK_TYPE_URL_PART = "/biznes";


    @Override
    public Map<HoroscopeTypeDefine, String> buildUrl(ZodiacSignDefine zodiacSign, HoroscopeDateDefine horoscopeDate) {
        Map<HoroscopeTypeDefine, String> map = new HashMap<>();
        String datePath = resolveHoroscopeDatePath(horoscopeDate);
        String zodiacPath = resolveHoroscopeZodiacSignPath(zodiacSign);
        map.put(HoroscopeTypeDefine.COMMON, createUrl(datePath, HoroscopeTypeDefine.COMMON, zodiacPath));
        map.put(HoroscopeTypeDefine.LOVE, createUrl(datePath, HoroscopeTypeDefine.LOVE, zodiacPath));
        map.put(HoroscopeTypeDefine.WORK, createUrl(datePath, HoroscopeTypeDefine.WORK, zodiacPath));
        return map;
    }

    private String createUrl(String datePath, HoroscopeTypeDefine horoscopeType, String zodiacPath) {
        return StringUtils.createString(HOROSCOPE_365_HOST, datePath, resolveHoroscopeHoroscopeTypePath(horoscopeType), zodiacPath);
    }

    private String resolveHoroscopeDatePath(HoroscopeDateDefine horoscopeDate) {
        return (horoscopeDate.equals(HoroscopeDateDefine.TODAY)) ? "" : "/zavtra";
    }

    private String resolveHoroscopeHoroscopeTypePath(HoroscopeTypeDefine horoscopeType) {
        return switch (horoscopeType) {
            case COMMON -> COMMON_TYPE_URL_PART;
            case LOVE -> LOVE_TYPE_URL_PART;
            case WORK -> WORK_TYPE_URL_PART;
        };
    }


    private String resolveHoroscopeZodiacSignPath(ZodiacSignDefine zodiacSign) {
        return switch (zodiacSign) {
            case ARIES -> "/aries";
            case TAURUS -> "/taurus";
            case GEMINI -> "/gemini";
            case CANCER -> "/cancer";
            case LEO -> "/leo";
            case VIRGO -> "/virgo";
            case LIBRA -> "/libra";
            case SCORPIO -> "/scorpio";
            case SAGITTARIUS -> "/sagittarius";
            case CAPRICORN -> "/capricorn";
            case AQUARIUS -> "/aquarius";
            case PISCES -> "/pisces";
        };
    }
}
