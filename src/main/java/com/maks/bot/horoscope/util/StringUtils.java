package com.maks.bot.horoscope.util;

public final class StringUtils {
    public static String createString(String... lines) {
        StringBuilder builder = new StringBuilder();
        for (String str : lines) {
            builder.append(str);
        }
        return builder.toString();
    }

}
