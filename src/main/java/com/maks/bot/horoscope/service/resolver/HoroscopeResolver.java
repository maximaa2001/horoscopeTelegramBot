package com.maks.bot.horoscope.service.resolver;

import com.maks.bot.horoscope.constant.define.HoroscopeDateDefine;
import com.maks.bot.horoscope.constant.define.HoroscopeTypeDefine;
import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import com.maks.bot.horoscope.exception.HtmlGetException;
import com.maks.bot.horoscope.service.HoroscopeInfo;
import com.maks.bot.horoscope.service.url.HoroscopeUrlBuilder;
import com.maks.bot.horoscope.util.HtmlUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Map;

@Slf4j
public abstract class HoroscopeResolver {
    private final HoroscopeUrlBuilder horoscopeUrlBuilder;

    public HoroscopeResolver(HoroscopeUrlBuilder horoscopeUrlBuilder) {
        this.horoscopeUrlBuilder = horoscopeUrlBuilder;
    }

    public HoroscopeInfo resolve(ZodiacSignDefine zodiacSign, HoroscopeDateDefine horoscopeDate) {
        HoroscopeInfo horoscopeInfo = new HoroscopeInfo();
        log.info("try to resolve {} {}", zodiacSign.getEnglishName(), horoscopeDate.getEnglishName());
        Map<HoroscopeTypeDefine, String> typeToUrl = horoscopeUrlBuilder.buildUrl(zodiacSign, horoscopeDate);
        for (Map.Entry<HoroscopeTypeDefine, String> next : typeToUrl.entrySet()) {
            try {
                String horoscopeText = HtmlUtils.parse(next.getValue());
                setText(horoscopeInfo, next.getKey(), horoscopeText);
            } catch (HtmlGetException e) {
                log.error(e.getMessage(), e.getCause());
            }
        }
        return horoscopeInfo;
    }

    private void setText(HoroscopeInfo horoscopeInfo, HoroscopeTypeDefine horoscopeType, String text) {
        switch (horoscopeType) {
            case COMMON -> horoscopeInfo.setCommonHoroscope(text);
            case LOVE -> horoscopeInfo.setLoveHoroscope(text);
            case WORK -> horoscopeInfo.setWorkHoroscope(text);
        }
    }
}
