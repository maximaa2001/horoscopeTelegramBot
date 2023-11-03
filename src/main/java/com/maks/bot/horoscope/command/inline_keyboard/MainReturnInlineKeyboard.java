package com.maks.bot.horoscope.command.inline_keyboard;

import com.maks.bot.horoscope.constant.CommandConstant;
import com.maks.bot.horoscope.constant.TextConstant;
import com.maks.telegram.command.ReturnInlineKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.List;

public class MainReturnInlineKeyboard implements ReturnInlineKeyboard {

    @Override
    public InlineKeyboardMarkup getNextKeyboard(Long chatId) {
        return createSimpleKeyboard(2,1, chatId);
    }

    @Override
    public List<String> getNextCommandTexts(Long aLong) {
        return List.of(TextConstant.CHANGE_ZODIAC_SIGN_TEXT, TextConstant.SHOW_HOROSCOPE_TEXT);
    }

    @Override
    public List<String> getNextCommandCallbacks(Long aLong) {
        return List.of(CommandConstant.CHANGE_ZODIAC_SIGN_COMMAND, CommandConstant.SHOW_HOROSCOPE_COMMAND);
    }
}
