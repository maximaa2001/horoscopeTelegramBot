package com.maks.bot.horoscope.service.url;

import com.maks.bot.horoscope.constant.define.HoroscopeDateDefine;
import com.maks.bot.horoscope.constant.define.HoroscopeTypeDefine;
import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;

import java.util.Map;

public interface HoroscopeUrlBuilder {
    Map<HoroscopeTypeDefine, String> buildUrl(ZodiacSignDefine zodiacSign, HoroscopeDateDefine horoscopeDate);
}
