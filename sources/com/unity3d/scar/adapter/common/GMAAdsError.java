package com.unity3d.scar.adapter.common;

import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public class GMAAdsError extends WebViewAdsError {
    public GMAAdsError(GMAEvent gMAEvent, Object... objArr) {
        super(gMAEvent, (String) null, objArr);
    }

    public static GMAAdsError InternalLoadError(ScarAdMetadata scarAdMetadata) {
        return InternalLoadError(scarAdMetadata, String.format("Missing queryInfoMetadata for ad %s", new Object[]{scarAdMetadata._placementId}));
    }

    public static GMAAdsError InternalShowError(ScarAdMetadata scarAdMetadata) {
        return InternalShowError(scarAdMetadata, String.format("Cannot show ad that is not loaded for placement %s", new Object[]{scarAdMetadata._placementId}));
    }

    public String getDomain() {
        return "GMA";
    }

    public GMAAdsError(GMAEvent gMAEvent, String str, Object... objArr) {
        super(gMAEvent, str, objArr);
    }

    public static GMAAdsError InternalLoadError(ScarAdMetadata scarAdMetadata, String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_LOAD_ERROR, str, scarAdMetadata._placementId, scarAdMetadata._queryId, str);
    }

    public static GMAAdsError InternalShowError(ScarAdMetadata scarAdMetadata, String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_SHOW_ERROR, str, scarAdMetadata._placementId, scarAdMetadata._queryId, str);
    }
}
