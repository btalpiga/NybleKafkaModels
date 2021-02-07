package com.nyble.streams.types;

import java.util.Objects;

public class SubcampaignesValue {
    int systemId;
    String subcampaignId;
    int brandId;

    public SubcampaignesValue(int systemId, String subcampaignId, int brandId) {
        this.systemId = systemId;
        this.subcampaignId = subcampaignId;
        this.brandId = brandId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public String getSubcampaignId() {
        return subcampaignId;
    }

    public void setSubcampaignId(String subcampaignId) {
        this.subcampaignId = subcampaignId;
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
        if (!(o instanceof SubcampaignesValue)) return false;
        SubcampaignesValue that = (SubcampaignesValue) o;
        return systemId == that.systemId &&
                brandId == that.brandId &&
                subcampaignId.equals(that.subcampaignId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemId, subcampaignId, brandId);
    }
}

