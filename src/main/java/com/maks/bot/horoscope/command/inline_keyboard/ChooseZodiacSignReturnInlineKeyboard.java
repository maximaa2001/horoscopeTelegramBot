package com.maks.bot.horoscope.command.inline_keyboard;

import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.define.ZodiacSignDefine;
import com.maks.bot.horoscope.util.StringUtils;
import com.maks.telegram.command.DynamicCommand;
import com.maks.telegram.command.ReturnInlineKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Arrays;
import java.util.List;

public class ChooseZodiacSignReturnInlineKeyboard implements ReturnInlineKeyboard {
    @Override
    public InlineKeyboardMarkup getNextKeyboard(Long aLong) {
        return createSimpleKeyboard(ZodiacSignDefine.values().length, 1, aLong);
    }

    @Override
    public List<String> getNextCommandTexts(Long aLong) {
        return Arrays.stream(ZodiacSignDefine.values())
                .map(ZodiacSignDefine::getRussianName)
                .toList();
    }

    @Override
    public List<String> getNextCommandCallbacks(Long aLong) {
        return Arrays.stream(ZodiacSignDefine.values())
                .map(e -> StringUtils.createString(CommandConstant.CHOOSE_ZODIAC_SIGN_COMMAND, DynamicCommand.DELIMITER, e.getEnglishName()))
                .toList();
    }
}
