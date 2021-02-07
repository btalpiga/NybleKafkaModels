package com.nyble.streams.types;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrandAffinityValue)) return false;
        BrandAffinityValue that = (BrandAffinityValue) o;
        return systemId == that.systemId &&
                consumerId == that.consumerId &&
                brandId == that.brandId &&
                deltaScore == that.deltaScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemId, consumerId, brandId, deltaScore);
    }
}
