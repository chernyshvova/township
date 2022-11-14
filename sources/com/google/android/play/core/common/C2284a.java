package com.google.android.play.core.common;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.common.a */
public final class C2284a {

    /* renamed from: a */
    public final Map<String, Object> f3227a = new HashMap();

    /* renamed from: a */
    public final synchronized boolean mo33275a() {
        Object obj = this.f3227a.get("usingExtractorStream");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
