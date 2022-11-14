package com.helpshift.providers;

public class CrossModuleDataProvider {
    public static ICampaignsModuleAPIs campaignsModuleAPIs;
    public static ISupportDataProvider supportDataProvider;

    public static ICampaignsModuleAPIs getCampaignModuleAPIs() {
        return campaignsModuleAPIs;
    }

    public static ISupportDataProvider getSupportDataProvider() {
        return supportDataProvider;
    }

    public static void setCampaignsDataProvider(ICampaignsModuleAPIs iCampaignsModuleAPIs) {
        campaignsModuleAPIs = iCampaignsModuleAPIs;
    }

    public static void setSupportDataProvider(ISupportDataProvider iSupportDataProvider) {
        supportDataProvider = iSupportDataProvider;
    }
}
