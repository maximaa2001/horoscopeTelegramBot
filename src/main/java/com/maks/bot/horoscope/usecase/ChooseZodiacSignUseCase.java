package com.maks.bot.horoscope.usecase;

import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import com.maks.bot.horoscope.db.entity.User;
import com.maks.bot.horoscope.db.entity.ZodiacSign;
import com.maks.bot.horoscope.db.repo.UserRepo;
import com.maks.telegram.command.params.CommandParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChooseZodiacSignUseCase {
    private final UserRepo userRepo;

    @Transactional
    public User choose(CommandParams commandParams) {
        User user = userRepo.findByChatId(commandParams.getParam(CommandParams.CHAT_ID, Long.class)).orElse(null);
        String zodiacSign = commandParams.getParam(CommandParams.DYNAMIC_DATA, String.class);
        log.info("user {} chose the next zodiac sign {}", user, zodiacSign);
        if (user != null) {
            user.setZodiacSign(new ZodiacSign(ZodiacSignDefine.of(zodiacSign)));
        }
        return user;
    }
}
