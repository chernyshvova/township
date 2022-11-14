package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Map;

/* renamed from: com.appsflyer.internal.bh */
public abstract class C1443bh extends C1480h {
    public final boolean onAppOpenAttributionNative;
    public final boolean onAttributionFailureNative;
    public boolean onConversionDataSuccess;

    public C1443bh() {
        this((String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    public String AFLogger$LogLevel() {
        return C1482k.values((Map<String, ?>) valueOf()).toString();
    }

    public final boolean AppsFlyer2dXConversionCallback() {
        return this.onConversionDataSuccess;
    }

    public final boolean getLevel() {
        return this.onAppOpenAttributionNative;
    }

    public final boolean init() {
        return this.onAttributionFailureNative;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1443bh(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z = true;
        this.onAttributionFailureNative = bool != null ? bool.booleanValue() : true;
        this.onAppOpenAttributionNative = bool2 != null ? bool2.booleanValue() : z;
    }
}
