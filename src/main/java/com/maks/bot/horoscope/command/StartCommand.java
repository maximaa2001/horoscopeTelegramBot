package com.maks.bot.horoscope.command;

import com.maks.bot.horoscope.command.inline_keyboard.MainReturnInlineKeyboard;
import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.TextConstant;
import com.maks.bot.horoscope.db.entity.User;
import com.maks.bot.horoscope.db.entity.ZodiacSign;
import com.maks.bot.horoscope.usecase.RegistrationUseCase;
import com.maks.telegram.command.AbstractMenuCommand;
import com.maks.telegram.command.params.CommandParams;
import com.maks.telegram.command.response.command.CommandResponse;
import com.maks.telegram.command.response.command.MessageCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class StartCommand extends AbstractMenuCommand {
    private final RegistrationUseCase registrationUseCase;

    public StartCommand(RegistrationUseCase registrationUseCase) {
        super(CommandConstant.START_COMMAND_NAME, CommandConstant.START_COMMAND_DESCRIPTION);
        this.registrationUseCase = registrationUseCase;
    }

    @Override
    protected CommandResponse transformToCommandResponse(CommandParams commandParams) {
        User user = registrationUseCase.registration(commandParams);
        return new MessageCommandResponse.MessageCommandResponseBuilder(
                user.getChatId(),
                getText(user.getZodiacSign())
        ).returnInlineKeyboard(new MainReturnInlineKeyboard()).build();
    }

    private String getText(ZodiacSign zodiacSign) {
        if (zodiacSign == null) {
            return TextConstant.ZODIAC_SIGN_NOT_DEFINED;
        }
        return String.format(TextConstant.ZODIAC_SIGN_DEFINED, zodiacSign.getName().getRussianName(), zodiacSign.getName().getEmoji());
    }
}
