package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C2292ag;

/* renamed from: com.google.android.play.core.assetpacks.dl */
public final class C2251dl {

    /* renamed from: a */
    public static final C2292ag f3146a = new C2292ag("PackageStateCache");

    /* renamed from: b */
    public final Context f3147b;

    /* renamed from: c */
    public int f3148c = -1;

    public C2251dl(Context context) {
        this.f3147b = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int mo33237a() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f3148c     // Catch:{ all -> 0x002a }
            r1 = -1
            if (r0 != r1) goto L_0x0026
            r0 = 0
            android.content.Context r1 = r4.f3147b     // Catch:{ NameNotFoundException -> 0x001c }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException -> 0x001c }
            android.content.Context r2 = r4.f3147b     // Catch:{ NameNotFoundException -> 0x001c }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001c }
            android.content.pm.PackageInfo r1 = r2.getPackageInfo(r1, r0)     // Catch:{ NameNotFoundException -> 0x001c }
            int r1 = r1.versionCode     // Catch:{ NameNotFoundException -> 0x001c }
            r4.f3148c = r1     // Catch:{ NameNotFoundException -> 0x001c }
            goto L_0x0026
        L_0x001c:
            com.google.android.play.core.internal.ag r1 = f3146a     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "The current version of the app could not be retrieved"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x002a }
            r3 = 6
            r1.mo33278a((int) r3, (java.lang.String) r2, (java.lang.Object[]) r0)     // Catch:{ all -> 0x002a }
        L_0x0026:
            int r0 = r4.f3148c     // Catch:{ all -> 0x002a }
            monitor-exit(r4)
            return r0
        L_0x002a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C2251dl.mo33237a():int");
    }
}
