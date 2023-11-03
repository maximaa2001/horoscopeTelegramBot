package com.maks.bot.horoscope.usecase;

import com.maks.bot.horoscope.db.entity.User;
import com.maks.bot.horoscope.db.repo.UserRepo;
import com.maks.bot.horoscope.util.TimeUtils;
import com.maks.telegram.command.params.CommandParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationUseCase {
    private final UserRepo userRepo;


    @Transactional
    public User registration(CommandParams commandParams) {
        User user = userRepo.findByChatId(commandParams.getParam(CommandParams.CHAT_ID, Long.class)).orElse(null);
        if (user == null) {
            user = userRepo.save(createNewUser(commandParams));
            log.info("registration new user {}", user);
        }
        return user;
    }

    private User createNewUser(CommandParams commandParams) {
        org.telegram.telegrambots.meta.api.objects.User apiUser = commandParams.getParam(CommandParams.FROM_USER, org.telegram.telegrambots.meta.api.objects.User.class);
        return User.builder()
                .chatId(commandParams.getParam(CommandParams.CHAT_ID, Long.class))
                .firstName(apiUser.getFirstName())
                .lastName(apiUser.getLastName())
                .username(apiUser.getUserName())
                .registrationDate(TimeUtils.getDateTimeUTC_3())
                .build();
    }
}
