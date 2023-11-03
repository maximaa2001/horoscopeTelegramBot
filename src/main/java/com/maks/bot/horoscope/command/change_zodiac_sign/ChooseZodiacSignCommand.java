package com.maks.bot.horoscope.command.change_zodiac_sign;

import com.maks.bot.horoscope.command.inline_keyboard.MainReturnInlineKeyboard;
import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.TextConstant;
import com.maks.bot.horoscope.db.entity.User;
import com.maks.bot.horoscope.db.entity.ZodiacSign;
import com.maks.bot.horoscope.usecase.ChooseZodiacSignUseCase;
import com.maks.telegram.command.DynamicCommand;
import com.maks.telegram.command.params.CommandParams;
import com.maks.telegram.command.response.command.CommandResponse;
import com.maks.telegram.command.response.command.edit.EditMessageCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class ChooseZodiacSignCommand extends DynamicCommand {
    private final ChooseZodiacSignUseCase chooseZodiacSignUseCase;

    public ChooseZodiacSignCommand(ChooseZodiacSignUseCase chooseZodiacSignUseCase) {
        super(CommandConstant.CHOOSE_ZODIAC_SIGN_COMMAND);
        this.chooseZodiacSignUseCase = chooseZodiacSignUseCase;
    }

    @Override
    protected CommandResponse transformToCommandResponse(CommandParams commandParams) {
        User user = chooseZodiacSignUseCase.choose(commandParams);
        return new EditMessageCommandResponse.EditMessageCommandResponseBuilder(
                user.getChatId(),
                commandParams.getParam(CommandParams.MESSAGE_ID, Integer.class),
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
