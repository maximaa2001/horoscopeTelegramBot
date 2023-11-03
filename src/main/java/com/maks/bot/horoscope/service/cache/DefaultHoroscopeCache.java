package com.maks.bot.horoscope.service.cache;

import com.maks.bot.horoscope.constant.define.HoroscopeDateDefine;
import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import com.maks.bot.horoscope.service.HoroscopeInfo;
import com.maks.bot.horoscope.service.resolver.HoroscopeResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultHoroscopeCache implements HoroscopeCache {
    private static final Map<ZodiacSignDefine, Map<HoroscopeDateDefine, HoroscopeInfo>> cache = new HashMap<>();
    private final HoroscopeResolver horoscopeResolver;

    @Override
    public synchronized HoroscopeInfo getHoroscope(ZodiacSignDefine zodiacSign, HoroscopeDateDefine horoscopeDate) {
        Map<HoroscopeDateDefine, HoroscopeInfo> dateMap = cache.get(zodiacSign);
        if (dateMap != null) {
            HoroscopeInfo horoscopeInfo = dateMap.get(horoscopeDate);
            if (horoscopeInfo != null) {
                return horoscopeInfo;
            }
            HoroscopeInfo newHoroscopeInfo = horoscopeResolver.resolve(zodiacSign, horoscopeDate);
            dateMap.put(horoscopeDate, newHoroscopeInfo);
            return newHoroscopeInfo;
        }
        HashMap<HoroscopeDateDefine, HoroscopeInfo> newDateMap = new HashMap<>();
        HoroscopeInfo newHoroscopeInfo = horoscopeResolver.resolve(zodiacSign, horoscopeDate);
        newDateMap.put(horoscopeDate, newHoroscopeInfo);
        cache.put(zodiacSign, newDateMap);
        return newHoroscopeInfo;
    }

    @Scheduled(zone = "Europe/Minsk", cron = "0 0 0 * * *")
    public synchronized void clear() {
        cache.clear();
        log.info("cache cleared");
    }
}
