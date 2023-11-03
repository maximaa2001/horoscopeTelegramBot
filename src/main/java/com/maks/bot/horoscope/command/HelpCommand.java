package com.maks.bot.horoscope.command;

import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.TextConstant;
import com.maks.telegram.command.AbstractMenuCommand;
import com.maks.telegram.command.params.CommandParams;
import com.maks.telegram.command.response.command.CommandResponse;
import com.maks.telegram.command.response.command.MessageCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand extends AbstractMenuCommand {
    public HelpCommand() {
        super(CommandConstant.HELP_COMMAND_NAME, CommandConstant.HELP_COMMAND_DESCRIPTION);
    }

    @Override
    protected CommandResponse transformToCommandResponse(CommandParams commandParams) {
        return new MessageCommandResponse.MessageCommandResponseBuilder(
                commandParams.getParam(CommandParams.CHAT_ID, Long.class),
                TextConstant.HELP_TEXT
        ).build();
    }
}
