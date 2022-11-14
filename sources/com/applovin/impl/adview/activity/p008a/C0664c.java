package com.applovin.impl.adview.activity.p008a;

import android.app.Activity;
import android.view.View;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.utils.C1257b;

/* renamed from: com.applovin.impl.adview.activity.a.c */
public class C0664c extends C0662a {
    public C0664c(C1057e eVar, Activity activity, C1188m mVar) {
        super(eVar, activity, mVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01e7  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9440a(android.widget.ImageView r20, com.applovin.impl.adview.C0767m r21, com.applovin.impl.adview.C0782t r22, com.applovin.impl.adview.C0653a r23, android.widget.ProgressBar r24, android.view.View r25, com.applovin.adview.AppLovinAdView r26, @androidx.annotation.Nullable android.view.ViewGroup r27) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            com.applovin.impl.sdk.ad.e r9 = r0.f207c
            com.applovin.impl.sdk.ad.e$d r9 = r9.mo10594aI()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.p025ad.C1057e.C1062d.TOP
            r12 = 3
            r13 = 80
            r14 = 48
            r15 = -2
            r11 = -1
            if (r9 != r10) goto L_0x002a
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r9.<init>(r11, r15, r14)
        L_0x0028:
            r10 = 5
            goto L_0x005e
        L_0x002a:
            com.applovin.impl.sdk.ad.e r9 = r0.f207c
            com.applovin.impl.sdk.ad.e$d r9 = r9.mo10594aI()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.p025ad.C1057e.C1062d.BOTTOM
            if (r9 != r10) goto L_0x003a
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r9.<init>(r11, r15, r13)
            goto L_0x0028
        L_0x003a:
            com.applovin.impl.sdk.ad.e r9 = r0.f207c
            com.applovin.impl.sdk.ad.e$d r9 = r9.mo10594aI()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.p025ad.C1057e.C1062d.LEFT
            if (r9 != r10) goto L_0x004a
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r9.<init>(r15, r11, r12)
            goto L_0x0028
        L_0x004a:
            com.applovin.impl.sdk.ad.e r9 = r0.f207c
            com.applovin.impl.sdk.ad.e$d r9 = r9.mo10594aI()
            com.applovin.impl.sdk.ad.e$d r10 = com.applovin.impl.sdk.p025ad.C1057e.C1062d.RIGHT
            if (r9 != r10) goto L_0x005b
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            r10 = 5
            r9.<init>(r15, r11, r10)
            goto L_0x005e
        L_0x005b:
            r10 = 5
            android.widget.FrameLayout$LayoutParams r9 = r0.f209e
        L_0x005e:
            com.applovin.impl.sdk.ad.e r15 = r0.f207c
            boolean r15 = r15.mo10590aE()
            r10 = 4
            r12 = 0
            if (r15 == 0) goto L_0x009d
            android.widget.FrameLayout$LayoutParams r15 = r0.f209e
            r7.setLayoutParams(r15)
            android.view.ViewGroup r15 = r0.f208d
            r15.addView(r7)
            android.view.View r7 = new android.view.View
            android.app.Activity r15 = r0.f206b
            r7.<init>(r15)
            android.widget.FrameLayout$LayoutParams r15 = r0.f209e
            r7.setLayoutParams(r15)
            r15 = 254(0xfe, float:3.56E-43)
            int r15 = android.graphics.Color.argb(r15, r12, r12, r12)
            r7.setBackgroundColor(r15)
            com.applovin.impl.adview.activity.a.c$1 r15 = new com.applovin.impl.adview.activity.a.c$1
            r15.<init>()
            r7.setOnTouchListener(r15)
            android.view.ViewGroup r15 = r0.f208d
            r15.addView(r7)
            r6.setLayoutParams(r9)
            android.view.ViewGroup r7 = r0.f208d
            r7.addView(r6)
            goto L_0x00b2
        L_0x009d:
            r6.setLayoutParams(r9)
            android.view.ViewGroup r9 = r0.f208d
            r9.addView(r6)
            android.widget.FrameLayout$LayoutParams r6 = r0.f209e
            r7.setLayoutParams(r6)
            android.view.ViewGroup r6 = r0.f208d
            r6.addView(r7)
            r7.setVisibility(r10)
        L_0x00b2:
            if (r3 == 0) goto L_0x0151
            com.applovin.impl.sdk.ad.e r6 = r0.f207c
            com.applovin.impl.adview.s r6 = r6.mo10556A()
            int r7 = r6.mo9695a()
            double r11 = (double) r7
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            java.lang.Double.isNaN(r11)
            double r11 = r11 / r16
            int r7 = r6.mo9696b()
            double r13 = (double) r7
            java.lang.Double.isNaN(r13)
            double r13 = r13 / r16
            if (r8 == 0) goto L_0x00dd
            int r7 = r27.getWidth()
            int r16 = r27.getHeight()
            r9 = r16
            goto L_0x00ec
        L_0x00dd:
            android.app.Activity r7 = r0.f206b
            android.graphics.Point r7 = com.applovin.impl.sdk.utils.C1263g.m2503a(r7)
            int r9 = r7.x
            int r7 = r7.y
            r18 = r9
            r9 = r7
            r7 = r18
        L_0x00ec:
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r11
            int r7 = (int) r7
            double r8 = (double) r9
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r13
            int r8 = (int) r8
            android.widget.FrameLayout$LayoutParams r9 = new android.widget.FrameLayout$LayoutParams
            int r11 = r6.mo9698d()
            r9.<init>(r7, r8, r11)
            android.app.Activity r7 = r0.f206b
            int r8 = r6.mo9697c()
            int r7 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r7, r8)
            r9.setMargins(r7, r7, r7, r7)
            android.view.ViewGroup r7 = r0.f208d
            r7.addView(r3, r9)
            float r7 = r6.mo9705i()
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0135
            r3.setVisibility(r10)
            float r7 = r6.mo9705i()
            long r9 = com.applovin.impl.sdk.utils.Utils.secondsToMillisLong(r7)
            long r11 = r6.mo9702g()
            com.applovin.impl.adview.activity.a.c$2 r7 = new com.applovin.impl.adview.activity.a.c$2
            r7.<init>(r3, r11)
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r7, r9)
        L_0x0135:
            float r7 = r6.mo9706j()
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0151
            float r7 = r6.mo9706j()
            long r7 = com.applovin.impl.sdk.utils.Utils.secondsToMillisLong(r7)
            long r9 = r6.mo9703h()
            com.applovin.impl.adview.activity.a.c$3 r6 = new com.applovin.impl.adview.activity.a.c$3
            r6.<init>(r3, r9)
            com.applovin.sdk.AppLovinSdkUtils.runOnUiThreadDelayed(r6, r7)
        L_0x0151:
            if (r2 == 0) goto L_0x016c
            com.applovin.impl.sdk.ad.e r3 = r0.f207c
            boolean r3 = r3.mo10578X()
            if (r3 == 0) goto L_0x015f
            r3 = 48
            r11 = 3
            goto L_0x0162
        L_0x015f:
            r3 = 48
            r11 = 5
        L_0x0162:
            r3 = r3 | r11
            com.applovin.impl.sdk.ad.e r6 = r0.f207c
            com.applovin.impl.sdk.ad.e$c r6 = r6.mo10573S()
            r0.mo9438a(r6, r3, r2)
        L_0x016c:
            if (r1 == 0) goto L_0x01b1
            android.app.Activity r2 = r0.f206b
            com.applovin.impl.sdk.m r3 = r0.f205a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r6 = com.applovin.impl.sdk.p027c.C1085b.f1648cA
            java.lang.Object r3 = r3.mo10946a(r6)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            int r2 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r2, r3)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            com.applovin.impl.sdk.m r6 = r0.f205a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r7 = com.applovin.impl.sdk.p027c.C1085b.f1650cC
            java.lang.Object r6 = r6.mo10946a(r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r3.<init>(r2, r2, r6)
            android.app.Activity r2 = r0.f206b
            com.applovin.impl.sdk.m r6 = r0.f205a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r7 = com.applovin.impl.sdk.p027c.C1085b.f1649cB
            java.lang.Object r6 = r6.mo10946a(r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            int r2 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r2, r6)
            r3.setMargins(r2, r2, r2, r2)
            android.view.ViewGroup r2 = r0.f208d
            r2.addView(r1, r3)
        L_0x01b1:
            if (r4 == 0) goto L_0x01ba
            android.view.ViewGroup r1 = r0.f208d
            android.widget.FrameLayout$LayoutParams r2 = r0.f209e
            r1.addView(r4, r2)
        L_0x01ba:
            if (r5 == 0) goto L_0x01dd
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = 20
            r3 = 80
            r4 = -1
            r1.<init>(r4, r2, r3)
            com.applovin.impl.sdk.m r2 = r0.f205a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r3 = com.applovin.impl.sdk.p027c.C1085b.f1653cF
            java.lang.Object r2 = r2.mo10946a(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = 0
            r1.setMargins(r3, r3, r3, r2)
            android.view.ViewGroup r2 = r0.f208d
            r2.addView(r5, r1)
        L_0x01dd:
            r1 = r27
            if (r1 == 0) goto L_0x01e7
            android.view.ViewGroup r2 = r0.f208d
            r1.addView(r2)
            goto L_0x01ee
        L_0x01e7:
            android.app.Activity r1 = r0.f206b
            android.view.ViewGroup r2 = r0.f208d
            r1.setContentView(r2)
        L_0x01ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.p008a.C0664c.mo9440a(android.widget.ImageView, com.applovin.impl.adview.m, com.applovin.impl.adview.t, com.applovin.impl.adview.a, android.widget.ProgressBar, android.view.View, com.applovin.adview.AppLovinAdView, android.view.ViewGroup):void");
    }

    /* renamed from: a */
    public void mo9441a(C0767m mVar, View view) {
        view.setVisibility(0);
        C1257b.m2485a(this.f208d, view);
        if (mVar != null) {
            mo9438a(this.f207c.mo10573S(), (this.f207c.mo10577W() ? 3 : 5) | 48, mVar);
        }
    }
}
