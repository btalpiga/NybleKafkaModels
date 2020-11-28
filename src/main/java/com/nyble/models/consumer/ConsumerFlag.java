package com.nyble.models.consumer;

public enum ConsumerFlag {

    OPT_IN_SMS(0), OPT_IN_EMAIL(1), OPT_IN_POSTALADDRESS(2), OPT_IN_MARKET_ANALYSIS(3), OPT_IN(4),
    IS_ACTIVE(5), IS_PHONE_VALID(6), IS_EMAIL_VALID(7),
    WEB_USER(8), WEB_ACCOUNT_BANNED(9), GDPR_APPROVAL(10), SMS_CONFIRMED(11), EMAIL_CONFIRMED(12);

    private final int bitPosition;
    ConsumerFlag(int bitPos){
        this.bitPosition = bitPos;
    }

    public int getBitPosition(){return bitPosition;}
}
