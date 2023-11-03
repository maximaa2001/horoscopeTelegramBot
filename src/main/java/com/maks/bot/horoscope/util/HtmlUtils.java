package com.maks.bot.horoscope.util;

import com.maks.bot.horoscope.exception.HtmlGetException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HtmlUtils {
    private static final String ELEMENT_ID = "content_wrapper";
    private static final String TAG = "p";

    public static String parse(String url) throws HtmlGetException {
        try {
            Document document = Jsoup.connect(url).get();
            Element contentWrapper = document.getElementById(ELEMENT_ID);
            Elements p = contentWrapper.getElementsByTag(TAG);
            return p.text();
        } catch (IOException e) {
            throw new HtmlGetException(StringUtils.createString("Failed to get html from ", url), e);
        }
    }
}
