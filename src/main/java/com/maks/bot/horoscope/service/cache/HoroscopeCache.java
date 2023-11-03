package com.maks.bot.horoscope.service.cache;

import com.maks.bot.horoscope.constant.define.HoroscopeDateDefine;
import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import com.maks.bot.horoscope.service.HoroscopeInfo;

public interface HoroscopeCache {
    HoroscopeInfo getHoroscope(ZodiacSignDefine zodiacSign, HoroscopeDateDefine horoscopeDate);
}
