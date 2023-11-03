package com.maks.bot.horoscope.usecase;

import com.maks.bot.horoscope.constant.TextConstant;
import com.maks.bot.horoscope.constant.define.HoroscopeDateDefine;
import com.maks.bot.horoscope.db.entity.User;
import com.maks.bot.horoscope.db.repo.UserRepo;
import com.maks.bot.horoscope.service.HoroscopeInfo;
import com.maks.bot.horoscope.service.cache.HoroscopeCache;
import com.maks.telegram.command.params.CommandParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetHoroscopeUseCase {
    private final UserRepo userRepo;
    private final HoroscopeCache horoscopeCache;

    public String getHoroscope(CommandParams commandParams) {
        User user = userRepo.findByChatId(commandParams.getParam(CommandParams.CHAT_ID, Long.class)).orElse(null);
        log.info("user {} wants to get horoscope", user);
        if (user != null && user.getZodiacSign() != null) {
            HoroscopeInfo horoscope = horoscopeCache.getHoroscope(user.getZodiacSign().getName(),
                    HoroscopeDateDefine.of(commandParams.getParam(CommandParams.DYNAMIC_DATA, String.class)));
            return horoscope.initMessage(user.getZodiacSign().getName());
        }
        return TextConstant.ZODIAC_SIGN_NOT_DEFINED;
    }
}
