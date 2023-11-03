package com.maks.bot.horoscope.command.show_horoscope;

import com.maks.bot.horoscope.command.inline_keyboard.ChooseHoroscopeDateReturnInlineKeyboard;
import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.TextConstant;
import com.maks.telegram.command.AbstractCommand;
import com.maks.telegram.command.params.CommandParams;
import com.maks.telegram.command.response.command.CommandResponse;
import com.maks.telegram.command.response.command.edit.EditMessageCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class ShowHoroscopeCommand extends AbstractCommand {
    public ShowHoroscopeCommand() {
        super(CommandConstant.SHOW_HOROSCOPE_COMMAND);
    }

    @Override
    protected CommandResponse transformToCommandResponse(CommandParams commandParams) {
        return new EditMessageCommandResponse.EditMessageCommandResponseBuilder(
                commandParams.getParam(CommandParams.CHAT_ID, Long.class),
                commandParams.getParam(CommandParams.MESSAGE_ID, Integer.class),
                TextConstant.CHOOSE_HOROSCOPE_DATE
        ).returnInlineKeyboard(new ChooseHoroscopeDateReturnInlineKeyboard()).build();
    }
}
