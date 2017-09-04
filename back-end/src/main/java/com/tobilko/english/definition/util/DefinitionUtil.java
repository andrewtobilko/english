package com.tobilko.english.definition.util;

/**
 * Created by Andrew Tobilko on 9/4/17.
 */
public final class DefinitionUtil {

    public static String replaceWordWithinTemplate(String template) {
        return template.replace(template, DefinitionConstant.WORD_TO_SEARCH_URL_TEMPLATE);
    }

    private DefinitionUtil() {}

}
