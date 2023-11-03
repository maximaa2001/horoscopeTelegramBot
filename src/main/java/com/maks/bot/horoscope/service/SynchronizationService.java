package com.maks.bot.horoscope.service;

import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import com.maks.bot.horoscope.db.entity.ZodiacSign;
import com.maks.bot.horoscope.db.repo.ZodiacSignRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "app.synchronization", havingValue = "true")
public class SynchronizationService {
    private final ZodiacSignRepo zodiacSignRepo;

    @PostConstruct
    public void init() {
        List<ZodiacSign> allZodiacSigns = ZodiacSignDefine.getAll();
        zodiacSignRepo.saveAll(allZodiacSigns);
    }
}
