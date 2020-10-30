package com.nyble.streams.types;

public class SubcampaignesKey {
    public int systemId;
    public Integer subcampaignId;

    public SubcampaignesKey(int systemId, int subcampaignId) {
        this.systemId = systemId;
        this.subcampaignId = subcampaignId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public Integer getSubcampaignId() {
        return subcampaignId;
    }

    public void setSubcampaignId(int subcampaignId) {
        this.subcampaignId = subcampaignId;
    }
}

