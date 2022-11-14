package com.swrve.sdk;

import com.swrve.sdk.config.SwrveConfigBase;
import com.swrve.sdk.messaging.SwrveButton;
import com.swrve.sdk.messaging.SwrveMessageFormat;
import java.io.File;
import java.util.Date;
import java.util.Set;

public interface ISwrveCampaignManager {
    void buttonWasPressedByUser(SwrveButton swrveButton);

    String getAppStoreURLForApp(int i);

    Set<String> getAssetsOnDisk();

    File getCacheDir();

    SwrveConfigBase getConfig();

    Date getInitialisedTime();

    Date getNow();

    void messageWasShownToUser(SwrveMessageFormat swrveMessageFormat);
}
