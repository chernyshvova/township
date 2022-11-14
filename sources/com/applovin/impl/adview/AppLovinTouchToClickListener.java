package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.sdk.utils.C1263g;

public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* renamed from: a */
    public final long f174a;

    /* renamed from: b */
    public final int f175b;

    /* renamed from: c */
    public final int f176c;

    /* renamed from: d */
    public final ClickRecognitionState f177d;

    /* renamed from: e */
    public long f178e;

    /* renamed from: f */
    public PointF f179f;

    /* renamed from: g */
    public boolean f180g;

    /* renamed from: h */
    public final Context f181h;

    /* renamed from: i */
    public final OnClickListener f182i;

    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    public interface OnClickListener {
        void onClick(View view, PointF pointF);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.applovin.impl.sdk.c.b, com.applovin.impl.sdk.c.b<java.lang.Integer>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppLovinTouchToClickListener(com.applovin.impl.sdk.C1188m r3, com.applovin.impl.sdk.p027c.C1085b<java.lang.Integer> r4, android.content.Context r5, com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener r6) {
        /*
            r2 = this;
            r2.<init>()
            com.applovin.impl.sdk.c.b<java.lang.Long> r0 = com.applovin.impl.sdk.p027c.C1085b.f1560aP
            java.lang.Object r0 = r3.mo10946a(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2.f174a = r0
            com.applovin.impl.sdk.c.b<java.lang.Integer> r0 = com.applovin.impl.sdk.p027c.C1085b.f1561aQ
            java.lang.Object r0 = r3.mo10946a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2.f175b = r0
            com.applovin.impl.sdk.c.b<java.lang.Integer> r0 = com.applovin.impl.sdk.p027c.C1085b.f1564aT
            java.lang.Object r0 = r3.mo10946a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r0 = com.applovin.sdk.AppLovinSdkUtils.dpToPx(r5, r0)
            r2.f176c = r0
            java.lang.Object r3 = r3.mo10946a(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState[] r4 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.values()
            r3 = r4[r3]
            r2.f177d = r3
            r2.f181h = r5
            r2.f182i = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinTouchToClickListener.<init>(com.applovin.impl.sdk.m, com.applovin.impl.sdk.c.b, android.content.Context, com.applovin.impl.adview.AppLovinTouchToClickListener$OnClickListener):void");
    }

    /* renamed from: a */
    private float m178a(float f) {
        return f / this.f181h.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    private float m179a(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return m178a((float) Math.sqrt((double) ((f2 * f2) + (f * f))));
    }

    /* renamed from: a */
    private void m180a(View view, MotionEvent motionEvent) {
        this.f182i.onClick(view, new PointF(motionEvent.getRawX(), motionEvent.getRawY()));
        this.f180g = true;
    }

    /* renamed from: a */
    private boolean m181a(MotionEvent motionEvent) {
        if (this.f176c <= 0) {
            return true;
        }
        Point a = C1263g.m2503a(this.f181h);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = this.f176c;
        return rawX >= ((float) i) && rawY >= ((float) i) && rawX <= ((float) (a.x - i)) && rawY <= ((float) (a.y - i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r2 >= r4) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        if (r0 >= ((float) r2)) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        if (m181a(r11) != false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r9.f177d != com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_POINTER_UP) goto L_0x0086;
     */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            int r0 = r11.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x005e
            if (r0 == r1) goto L_0x0019
            r2 = 6
            if (r0 == r2) goto L_0x000e
            goto L_0x0086
        L_0x000e:
            boolean r0 = r9.f180g
            if (r0 != 0) goto L_0x0086
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f177d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_POINTER_UP
            if (r0 != r2) goto L_0x0086
            goto L_0x006a
        L_0x0019:
            boolean r0 = r9.f180g
            if (r0 != 0) goto L_0x0024
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f177d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_UP
            if (r0 != r2) goto L_0x0024
            goto L_0x006a
        L_0x0024:
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f177d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.DISABLED
            if (r0 != r2) goto L_0x0086
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r9.f178e
            long r2 = r2 - r4
            android.graphics.PointF r0 = r9.f179f
            android.graphics.PointF r4 = new android.graphics.PointF
            float r5 = r11.getX()
            float r6 = r11.getY()
            r4.<init>(r5, r6)
            float r0 = r9.m179a((android.graphics.PointF) r0, (android.graphics.PointF) r4)
            boolean r4 = r9.f180g
            if (r4 != 0) goto L_0x0086
            long r4 = r9.f174a
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0054
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0086
        L_0x0054:
            int r2 = r9.f175b
            if (r2 < 0) goto L_0x006a
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0086
            goto L_0x006a
        L_0x005e:
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f177d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN
            if (r0 != r2) goto L_0x006e
            boolean r0 = r9.m181a((android.view.MotionEvent) r11)
            if (r0 == 0) goto L_0x0086
        L_0x006a:
            r9.m180a((android.view.View) r10, (android.view.MotionEvent) r11)
            goto L_0x0086
        L_0x006e:
            long r2 = android.os.SystemClock.elapsedRealtime()
            r9.f178e = r2
            android.graphics.PointF r10 = new android.graphics.PointF
            float r0 = r11.getX()
            float r11 = r11.getY()
            r10.<init>(r0, r11)
            r9.f179f = r10
            r10 = 0
            r9.f180g = r10
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinTouchToClickListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
