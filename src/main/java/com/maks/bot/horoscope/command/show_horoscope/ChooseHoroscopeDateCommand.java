package com.maks.bot.horoscope.command.show_horoscope;

import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.usecase.GetHoroscopeUseCase;
import com.maks.telegram.command.DynamicCommand;
import com.maks.telegram.command.params.CommandParams;
import com.maks.telegram.command.response.command.CommandResponse;
import com.maks.telegram.command.response.command.edit.EditMessageCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class ChooseHoroscopeDateCommand extends DynamicCommand {
    private final GetHoroscopeUseCase getHoroscopeUseCase;

    public ChooseHoroscopeDateCommand(GetHoroscopeUseCase getHoroscopeUseCase) {
        super(CommandConstant.CHOOSE_HOROSCOPE_DATE);
        this.getHoroscopeUseCase = getHoroscopeUseCase;
    }

    @Override
    protected CommandResponse transformToCommandResponse(CommandParams commandParams) {
        String horoscope = getHoroscopeUseCase.getHoroscope(commandParams);
        return new EditMessageCommandResponse.EditMessageCommandResponseBuilder(
                commandParams.getParam(CommandParams.CHAT_ID, Long.class),
                commandParams.getParam(CommandParams.MESSAGE_ID, Integer.class),
                horoscope
        ).build();
    }
}
