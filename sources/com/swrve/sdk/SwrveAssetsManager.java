package com.swrve.sdk;

import java.io.File;
import java.util.Set;

public interface SwrveAssetsManager {
    void downloadAssets(Set<SwrveAssetsQueueItem> set, SwrveAssetsCompleteCallback swrveAssetsCompleteCallback);

    Set<String> getAssetsOnDisk();

    File getStorageDir();

    void setCdnFonts(String str);

    void setCdnImages(String str);

    void setStorageDir(File file);
}
