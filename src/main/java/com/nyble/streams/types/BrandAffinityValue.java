package com.nyble.streams.types;


public class BrandAffinityValue {
    int systemId;
    int consumerId;
    int brandId;
    int deltaScore;

    public BrandAffinityValue(int systemId, int consumerId, int brandId, int deltaScore) {
        this.systemId = systemId;
        this.consumerId = consumerId;
        this.brandId = brandId;
        this.deltaScore = deltaScore;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getDeltaScore() {
        return deltaScore;
    }

    public void setDeltaScore(int deltaScore) {
        this.deltaScore = deltaScore;
    }

    public void add(int actionScore) {
        deltaScore+=actionScore;
    }
}
