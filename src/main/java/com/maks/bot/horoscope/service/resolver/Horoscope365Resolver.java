package com.maks.bot.horoscope.service.resolver;

import com.maks.bot.horoscope.service.url.Horoscope365UrlBuilder;
import org.springframework.stereotype.Service;

@Service
public class Horoscope365Resolver extends HoroscopeResolver {

    public Horoscope365Resolver() {
        super(new Horoscope365UrlBuilder());
    }
}
