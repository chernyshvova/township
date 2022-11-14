package com.facebook.share.internal;

import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.SharePhoto;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.-$$Lambda$V2ZpSeTx2J6GGFG5YyNXvJIqlJU  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$V2ZpSeTx2J6GGFG5YyNXvJIqlJU implements OpenGraphJSONUtility.PhotoJSONProcessor {
    public static final /* synthetic */ $$Lambda$V2ZpSeTx2J6GGFG5YyNXvJIqlJU INSTANCE = new $$Lambda$V2ZpSeTx2J6GGFG5YyNXvJIqlJU();

    private /* synthetic */ $$Lambda$V2ZpSeTx2J6GGFG5YyNXvJIqlJU() {
    }

    public final JSONObject toJSONObject(SharePhoto sharePhoto) {
        return ShareInternalUtility.m3671toJSONObjectForWeb$lambda6(sharePhoto);
    }
}
