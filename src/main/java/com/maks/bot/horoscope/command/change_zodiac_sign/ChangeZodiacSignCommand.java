package com.maks.bot.horoscope.command.change_zodiac_sign;

import com.maks.bot.horoscope.command.inline_keyboard.ChooseZodiacSignReturnInlineKeyboard;
import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.TextConstant;
import com.maks.telegram.command.AbstractCommand;
import com.maks.telegram.command.params.CommandParams;
import com.maks.telegram.command.response.command.CommandResponse;
import com.maks.telegram.command.response.command.edit.EditMessageCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class ChangeZodiacSignCommand extends AbstractCommand {
    public ChangeZodiacSignCommand() {
        super(CommandConstant.CHANGE_ZODIAC_SIGN_COMMAND);
    }

    @Override
    protected CommandResponse transformToCommandResponse(CommandParams commandParams) {
        return new EditMessageCommandResponse.EditMessageCommandResponseBuilder(
                commandParams.getParam(CommandParams.CHAT_ID, Long.class),
                commandParams.getParam(CommandParams.MESSAGE_ID, Integer.class),
                TextConstant.CHOOSE_ZODIAC_SIGN
        ).returnInlineKeyboard(new ChooseZodiacSignReturnInlineKeyboard()).build();
    }
}
