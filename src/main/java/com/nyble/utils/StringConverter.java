package com.nyble.utils;

import java.util.Objects;

public class StringConverter {

    private String value;

    public StringConverter(String v){
        value = v;
    }

    public String get(){
        return value;
    }

    public StringConverter nullIf(String equals){
        if(Objects.equals(value, equals)){
            value = null;
        }
        return this;
    }

    public StringConverter nullIfIgnoreCase(String equals){
        if(value !=null && value.equalsIgnoreCase(equals)){
            value = null;
        }
        return this;
    }

    public StringConverter trim(){
        if(value != null) value = value.trim();
        return this;
    }

    public StringConverter consumerAttributeNullEquivalence(){
        if(value == null) {return this;}
        String compare = value.trim();
        if(compare.isEmpty() || compare.equalsIgnoreCase("null") ||
                compare.equalsIgnoreCase("undefined") || compare.equalsIgnoreCase("N/A")
                ||compare.equals("-")){
            value = null;
        }
        return this;
    }

    public StringConverter coalesce(String newVal){
        if(value == null){
            value = newVal;
        }
        return this;
    }
}
