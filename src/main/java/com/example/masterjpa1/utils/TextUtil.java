package com.example.masterjpa1.utils;

public class TextUtil {

    public String sanitize(String stringToSanitize){
        return stringToSanitize.replaceAll("\\s+"," ");
    }
}
