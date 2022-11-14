package com.applovin.impl.adview.activity;

import android.app.Activity;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.activity.b */
public class C0669b {

    /* renamed from: a */
    public final Activity f217a;

    /* renamed from: b */
    public final int f218b;

    /* renamed from: c */
    public final int f219c;

    /* renamed from: d */
    public final boolean f220d;

    public C0669b(Activity activity) {
        this.f217a = activity;
        this.f219c = Utils.getRotation(activity);
        boolean isTablet = AppLovinSdkUtils.isTablet(activity);
        this.f220d = isTablet;
        this.f218b = m202a(this.f219c, isTablet);
    }

    /* renamed from: a */
    private int m202a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        }
    }

    /* renamed from: a */
    private void m203a(int i) {
        try {
            this.f217a.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r6 == 2) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r6 == 1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r6 != 3) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r6 != 1) goto L_0x001a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m204a(com.applovin.impl.sdk.p025ad.C1057e.C1060b r5, int r6, boolean r7) {
        /*
            r4 = this;
            com.applovin.impl.sdk.ad.e$b r0 = com.applovin.impl.sdk.p025ad.C1057e.C1060b.ACTIVITY_PORTRAIT
            r1 = 3
            r2 = 2
            r3 = 1
            if (r5 != r0) goto L_0x0024
            r5 = 9
            if (r7 == 0) goto L_0x0016
            if (r6 == r3) goto L_0x0010
            if (r6 == r1) goto L_0x0010
            goto L_0x001a
        L_0x0010:
            if (r6 != r3) goto L_0x001a
        L_0x0012:
            r4.m203a((int) r5)
            goto L_0x0042
        L_0x0016:
            if (r6 == 0) goto L_0x001e
            if (r6 == r2) goto L_0x001e
        L_0x001a:
            r4.m203a((int) r3)
            goto L_0x0042
        L_0x001e:
            if (r6 != 0) goto L_0x0021
            goto L_0x001a
        L_0x0021:
            r3 = 9
            goto L_0x001a
        L_0x0024:
            com.applovin.impl.sdk.ad.e$b r0 = com.applovin.impl.sdk.p025ad.C1057e.C1060b.ACTIVITY_LANDSCAPE
            if (r5 != r0) goto L_0x0042
            r5 = 8
            r0 = 0
            if (r7 == 0) goto L_0x0037
            if (r6 == 0) goto L_0x0032
            if (r6 == r2) goto L_0x0032
            goto L_0x003b
        L_0x0032:
            if (r6 != r2) goto L_0x0035
            goto L_0x0012
        L_0x0035:
            r5 = 0
            goto L_0x0012
        L_0x0037:
            if (r6 == r3) goto L_0x003f
            if (r6 == r1) goto L_0x003f
        L_0x003b:
            r4.m203a((int) r0)
            goto L_0x0042
        L_0x003f:
            if (r6 != r3) goto L_0x0012
            goto L_0x0035
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.C0669b.m204a(com.applovin.impl.sdk.ad.e$b, int, boolean):void");
    }

    /* renamed from: a */
    public void mo9446a(C1057e eVar) {
        int i;
        if (!eVar.mo10557C() || (i = this.f218b) == -1) {
            m204a(eVar.mo10624n(), this.f219c, this.f220d);
        } else {
            m203a(i);
        }
    }
}
