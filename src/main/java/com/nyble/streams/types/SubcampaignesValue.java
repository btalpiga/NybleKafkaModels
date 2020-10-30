package com.nyble.streams.types;

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
}

