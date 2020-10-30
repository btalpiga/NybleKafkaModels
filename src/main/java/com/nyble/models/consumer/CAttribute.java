package com.nyble.models.consumer;

import java.util.Date;
import java.util.Map;

public class CAttribute {
    private String value;
    private String lut; //lastUpdateTime

    public CAttribute(){}

    public CAttribute(String value, String lut) {
        this.value = value;
        this.lut = lut;
    }
    public String getValue() {
        return value;
    }

    public String getLut() {
        return lut;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLut(String lut) {
        this.lut = lut;
    }
}
