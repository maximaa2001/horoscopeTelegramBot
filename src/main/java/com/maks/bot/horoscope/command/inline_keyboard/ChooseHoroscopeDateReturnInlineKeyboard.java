package com.maks.bot.horoscope.command.inline_keyboard;

import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.define.HoroscopeDateDefine;
import com.maks.bot.horoscope.util.StringUtils;
import com.maks.telegram.command.DynamicCommand;
import com.maks.telegram.command.ReturnInlineKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Arrays;
import java.util.List;

public class ChooseHoroscopeDateReturnInlineKeyboard implements ReturnInlineKeyboard {
    @Override
    public InlineKeyboardMarkup getNextKeyboard(Long aLong) {
        return createSimpleKeyboard(HoroscopeDateDefine.values().length, 1, aLong);
    }

    @Override
    public List<String> getNextCommandTexts(Long aLong) {
        return Arrays.stream(HoroscopeDateDefine.values())
                .map(HoroscopeDateDefine::getRussianName)
                .toList();
    }

    @Override
    public List<String> getNextCommandCallbacks(Long aLong) {
        return Arrays.stream(HoroscopeDateDefine.values())
                .map(e -> StringUtils.createString(CommandConstant.CHOOSE_HOROSCOPE_DATE, DynamicCommand.DELIMITER, e.getEnglishName()))
                .toList();
    }
}
