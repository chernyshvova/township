package com.helpshift.model;

import androidx.annotation.NonNull;
import com.helpshift.storage.CachedKeyValueStorage;
import com.helpshift.storage.StorageFactory;
import com.helpshift.util.HelpshiftContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InfoModelFactory {
    public final AppInfoModel appInfoModel;
    public final SdkInfoModel sdkInfoModel;

    public static final class LazyHolder {
        public static final InfoModelFactory INSTANCE = new InfoModelFactory();
    }

    public InfoModelFactory() {
        CachedKeyValueStorage cachedKeyValueStorage = new CachedKeyValueStorage(StorageFactory.getInstance().keyValueStorage, getCacheWhitelistKeys());
        this.appInfoModel = new AppInfoModel(cachedKeyValueStorage);
        this.sdkInfoModel = new SdkInfoModel(cachedKeyValueStorage, HelpshiftContext.getPlatform());
    }

    @NonNull
    private Set<String> getCacheWhitelistKeys() {
        return new HashSet(Arrays.asList(new String[]{SdkInfoModel.SDK_LANGUAGE, SdkInfoModel.SDK_THEME, "disableHelpshiftBranding", AppInfoModel.SCREEN_ORIENTATION_KEY}));
    }

    public static InfoModelFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}
