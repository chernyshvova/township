package com.google.android.play.core.review;

import android.app.PendingIntent;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* renamed from: com.google.android.play.core.review.a */
public final class C2331a extends ReviewInfo {

    /* renamed from: a */
    public final PendingIntent f3267a;

    public C2331a(PendingIntent pendingIntent) {
        if (pendingIntent != null) {
            this.f3267a = pendingIntent;
            return;
        }
        throw new NullPointerException("Null pendingIntent");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f3267a.equals(((C2331a) ((ReviewInfo) obj)).f3267a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3267a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f3267a);
        return GeneratedOutlineSupport.outline19(new StringBuilder(valueOf.length() + 26), "ReviewInfo{pendingIntent=", valueOf, "}");
    }
}
