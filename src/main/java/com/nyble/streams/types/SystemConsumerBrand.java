package com.nyble.streams.types;

import java.util.Objects;

public class SystemConsumerBrand {
    private int systemId;
    private int consumerId;
    private int brandId;

    public SystemConsumerBrand(int systemId, int consumerId, int brandId) {
        this.systemId = systemId;
        this.consumerId = consumerId;
        this.brandId = brandId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemConsumerBrand)) return false;
        SystemConsumerBrand that = (SystemConsumerBrand) o;
        return systemId == that.systemId &&
                consumerId == that.consumerId &&
                brandId == that.brandId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemId, consumerId, brandId);
    }
}

