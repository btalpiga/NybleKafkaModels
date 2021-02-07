package com.nyble.streams.types;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubcampaignesKey)) return false;
        SubcampaignesKey that = (SubcampaignesKey) o;
        return systemId == that.systemId &&
                subcampaignId.equals(that.subcampaignId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemId, subcampaignId);
    }

    public void setSubcampaignId(int subcampaignId) {
        this.subcampaignId = subcampaignId;
    }


}

