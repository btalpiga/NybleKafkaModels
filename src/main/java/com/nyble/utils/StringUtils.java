package com.nyble.utils;

public class StringUtils {

    public String removeWhiteSpaces(String s){
        return s.replace(" ", "");
    }

    public String removeExtraCharsAndDuplicates(String s){
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c == '_' || c =='-' || c=='\'' || c == '"'){
                c = ' ';
            }
            if(sb.length()>0 && c == sb.charAt(sb.length()-1)) continue;
            sb.append(c);
        }
        return sb.toString();
    }

    public String replaceDiacritics (String s){
        return s.replaceAll("\u00c2", "A")
                .replaceAll("\u00c3", "A")
                .replaceAll("\u0102", "A")
                .replaceAll("\u0100", "A")
                .replaceAll("\u00ce", "I")
                .replaceAll("\u020a", "I")
                .replaceAll("\u015e", "S")
                .replaceAll("\u0218", "S")
                .replaceAll("\u0162", "T")
                .replaceAll("\u021a", "T");
    }


    public static boolean isNumerical(String s){
        for(Character c : s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
