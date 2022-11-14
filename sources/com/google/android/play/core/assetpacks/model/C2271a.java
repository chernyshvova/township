package com.google.android.play.core.assetpacks.model;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.model.a */
public final class C2271a {

    /* renamed from: a */
    public static final Map<Integer, String> f3211a = new HashMap();

    /* renamed from: b */
    public static final Map<Integer, String> f3212b = new HashMap();

    static {
        f3211a.put(-1, "The requesting app is unavailable (e.g. unpublished, nonexistent version code).");
        f3211a.put(-2, "The requested pack is not available.");
        f3211a.put(-3, "The request is invalid.");
        f3211a.put(-4, "The requested download is not found.");
        f3211a.put(-5, "The Asset Delivery API is not available.");
        f3211a.put(-6, "Network error. Unable to obtain the asset pack details.");
        f3211a.put(-7, "Download not permitted under current device circumstances (e.g. in background).");
        f3211a.put(-10, "Asset pack download failed due to insufficient storage.");
        f3211a.put(-11, "The Play Store app is either not installed or not the official version.");
        f3211a.put(-12, "Tried to show the cellular data confirmation but no asset packs are waiting for Wi-Fi.");
        f3211a.put(-13, "The app is not owned by any user on this device. An app is \"owned\" if it has been acquired from Play.");
        f3211a.put(-100, "Unknown error downloading an asset pack.");
        f3212b.put(-1, "APP_UNAVAILABLE");
        f3212b.put(-2, "PACK_UNAVAILABLE");
        f3212b.put(-3, "INVALID_REQUEST");
        f3212b.put(-4, "DOWNLOAD_NOT_FOUND");
        f3212b.put(-5, "API_NOT_AVAILABLE");
        f3212b.put(-6, "NETWORK_ERROR");
        f3212b.put(-7, "ACCESS_DENIED");
        f3212b.put(-10, "INSUFFICIENT_STORAGE");
        f3212b.put(-11, "PLAY_STORE_NOT_FOUND");
        f3212b.put(-12, "NETWORK_UNRESTRICTED");
        f3212b.put(-13, "APP_NOT_OWNED");
        f3212b.put(-100, "INTERNAL_ERROR");
    }
}
