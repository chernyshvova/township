package com.google.android.play.core.common;

import android.os.Bundle;
import android.os.Process;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PlayCoreVersion {

    /* renamed from: c */
    public static final Map<String, Map<String, Integer>> f3226c = new HashMap();

    static {
        new HashSet(Arrays.asList(new String[]{"review"}));
        new HashSet(Arrays.asList(new String[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "unity"}));
        StringBuilder outline22 = GeneratedOutlineSupport.outline22(39, "UID: [", Process.myUid(), "]  PID: [", Process.myPid());
        outline22.append("] ");
        String valueOf = String.valueOf(outline22.toString());
        if ("PlayCoreVersion".length() != 0) {
            valueOf.concat("PlayCoreVersion");
        } else {
            new String(valueOf);
        }
    }

    /* renamed from: a */
    public static Bundle m2971a() {
        Map map;
        Bundle bundle = new Bundle();
        synchronized (PlayCoreVersion.class) {
            if (!f3226c.containsKey("review")) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 10802);
                f3226c.put("review", hashMap);
            }
            map = f3226c.get("review");
        }
        bundle.putInt("playcore_version_code", ((Integer) map.get("java")).intValue());
        if (map.containsKey(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            bundle.putInt("playcore_native_version", ((Integer) map.get(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)).intValue());
        }
        if (map.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", ((Integer) map.get("unity")).intValue());
        }
        return bundle;
    }
}
