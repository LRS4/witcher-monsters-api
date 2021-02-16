package com.example.monsters.util;

public final class StringUtils {

    private StringUtils() {

    }

    public static String capitalise(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

}
