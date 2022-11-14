package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.C0839b;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.sdk.C1065b;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.C1304n;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MaxFullscreenAdImpl extends C0836a implements C1065b.C1067a {

    /* renamed from: a */
    public final C0826a f649a;

    /* renamed from: b */
    public final C1065b f650b;

    /* renamed from: c */
    public final C0839b f651c;

    /* renamed from: d */
    public C1304n f652d;

    /* renamed from: e */
    public final Object f653e = new Object();

    /* renamed from: f */
    public C0803c f654f = null;

    /* renamed from: g */
    public C0832c f655g = C0832c.IDLE;

    /* renamed from: h */
    public final AtomicBoolean f656h = new AtomicBoolean();
    public final C0827b listenerWrapper;

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$a */
    public interface C0826a {
        Activity getActivity();
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$b */
    public class C0827b implements C0836a.C0837a, MaxAdListener, MaxAdRevenueListener, MaxRewardedAdListener {
        public C0827b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            C1267j.m2579d(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError maxError) {
            MaxFullscreenAdImpl.this.m813a(C0832c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.f650b.mo10641a();
                    MaxFullscreenAdImpl.this.m810a();
                    MaxFullscreenAdImpl.this.sdk.mo10926F().mo11379b((C0801a) maxAd);
                    MaxFullscreenAdImpl.this.m822b("ad failed to display");
                    C1267j.m2548a(MaxFullscreenAdImpl.this.adListener, maxAd, maxError, true);
                }
            });
        }

        public void onAdDisplayed(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f650b.mo10641a();
            C1267j.m2571b(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onAdHidden(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.f651c.mo9995a(maxAd);
            MaxFullscreenAdImpl.this.m813a(C0832c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m810a();
                    MaxFullscreenAdImpl.this.sdk.mo10926F().mo11379b((C0801a) maxAd);
                    MaxFullscreenAdImpl.this.m822b("ad was hidden");
                    C1267j.m2576c(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                }
            });
        }

        public void onAdLoadFailed(final String str, final MaxError maxError) {
            MaxFullscreenAdImpl.this.m820b();
            MaxFullscreenAdImpl.this.m813a(C0832c.IDLE, (Runnable) new Runnable() {
                public void run() {
                    C1267j.m2553a(MaxFullscreenAdImpl.this.adListener, str, maxError, true);
                }
            });
        }

        public void onAdLoaded(final MaxAd maxAd) {
            MaxFullscreenAdImpl.this.m811a((C0803c) maxAd);
            if (MaxFullscreenAdImpl.this.f656h.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.loadRequestBuilder.mo11203c("expired_ad_ad_unit_id");
            } else {
                MaxFullscreenAdImpl.this.m813a(C0832c.READY, (Runnable) new Runnable() {
                    public void run() {
                        C1267j.m2551a(MaxFullscreenAdImpl.this.adListener, maxAd, true);
                    }
                });
            }
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            C1267j.m2554a(MaxFullscreenAdImpl.this.revenueListener, maxAd);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1267j.m2583f(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1267j.m2581e(MaxFullscreenAdImpl.this.adListener, maxAd, true);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1267j.m2550a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true);
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c */
    public enum C0832c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, C0826a aVar, String str2, C1188m mVar) {
        super(str, maxAdFormat, str2, mVar);
        this.f649a = aVar;
        this.listenerWrapper = new C0827b();
        this.f650b = new C1065b(mVar, this);
        this.f651c = new C0839b(mVar, this.listenerWrapper);
        C1314v.m2660f(str2, "Created new " + str2 + " (" + this + ")");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m810a() {
        C0803c cVar;
        synchronized (this.f653e) {
            cVar = this.f654f;
            this.f654f = null;
        }
        this.sdk.mo10925E().destroyAd(cVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m811a(C0803c cVar) {
        long v = cVar.mo9862v() - (SystemClock.elapsedRealtime() - cVar.mo9854r());
        if (v > TimeUnit.SECONDS.toMillis(2)) {
            this.f654f = cVar;
            C1314v vVar = this.logger;
            String str = this.tag;
            vVar.mo11372b(str, "Handle ad loaded for regular ad: " + cVar);
            C1314v vVar2 = this.logger;
            String str2 = this.tag;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Scheduling ad expiration ");
            outline24.append(TimeUnit.MILLISECONDS.toSeconds(v));
            outline24.append(" seconds from now for ");
            outline24.append(getAdUnitId());
            outline24.append("...");
            vVar2.mo11372b(str2, outline24.toString());
            this.f650b.mo10642a(v);
            return;
        }
        this.logger.mo11372b(this.tag, "Loaded an expired ad, running expire logic...");
        onAdExpired();
    }

    /* renamed from: a */
    private void m812a(C0803c cVar, Context context, final Runnable runnable) {
        if (!cVar.mo9874H() || C1264h.m2521a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(cVar.mo9875I()).setMessage(cVar.mo9876J()).setPositiveButton(cVar.mo9877K(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0151  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m813a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c r7, java.lang.Runnable r8) {
        /*
            r6 = this;
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = r6.f655g
            java.lang.Object r1 = r6.f653e
            monitor-enter(r1)
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.IDLE     // Catch:{ all -> 0x017c }
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0039
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0011
            goto L_0x0125
        L_0x0011:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0017
            goto L_0x0125
        L_0x0017:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0020
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "No ad is loading or loaded"
            goto L_0x004b
        L_0x0020:
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
        L_0x0035:
            r0.mo11376e(r2, r3)     // Catch:{ all -> 0x017c }
            goto L_0x004e
        L_0x0039:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.LOADING     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x007c
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.IDLE     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0043
            goto L_0x0125
        L_0x0043:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0051
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "An ad is already loading"
        L_0x004b:
            com.applovin.impl.sdk.C1314v.m2663i(r0, r2)     // Catch:{ all -> 0x017c }
        L_0x004e:
            r3 = 0
            goto L_0x0125
        L_0x0051:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.READY     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0057
            goto L_0x0125
        L_0x0057:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0060
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "An ad is not ready to be shown yet"
            goto L_0x004b
        L_0x0060:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0066
            goto L_0x0125
        L_0x0066:
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x007c:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.READY     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x00bd
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.IDLE     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x0086
            goto L_0x0125
        L_0x0086:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x008f
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "An ad is already loaded"
            goto L_0x004b
        L_0x008f:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.READY     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x009a
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r3 = "An ad is already marked as ready"
            goto L_0x0035
        L_0x009a:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00a0
            goto L_0x0125
        L_0x00a0:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00a6
            goto L_0x0125
        L_0x00a6:
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x00bd:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.SHOWING     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x0102
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.IDLE     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00c6
            goto L_0x0125
        L_0x00c6:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.LOADING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00d0
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "Can not load another ad while the ad is showing"
            goto L_0x004b
        L_0x00d0:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.READY     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00dc
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r3 = "An ad is already showing, ignoring"
            goto L_0x0035
        L_0x00dc:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.SHOWING     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00e6
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "The ad is already showing, not showing another one"
            goto L_0x004b
        L_0x00e6:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r7 != r0) goto L_0x00eb
            goto L_0x0125
        L_0x00eb:
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unable to transition to: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            r3.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x0102:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.C0832c.DESTROYED     // Catch:{ all -> 0x017c }
            if (r0 != r2) goto L_0x010c
            java.lang.String r0 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.String r2 = "No operations are allowed on a destroyed instance"
            goto L_0x004b
        L_0x010c:
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r3.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Unknown state: "
            r3.append(r5)     // Catch:{ all -> 0x017c }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f655g     // Catch:{ all -> 0x017c }
            r3.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x017c }
            goto L_0x0035
        L_0x0125:
            if (r3 == 0) goto L_0x0151
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Transitioning from "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f655g     // Catch:{ all -> 0x017c }
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "..."
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x017c }
            r0.mo11372b(r2, r4)     // Catch:{ all -> 0x017c }
            r6.f655g = r7     // Catch:{ all -> 0x017c }
            goto L_0x0173
        L_0x0151:
            com.applovin.impl.sdk.v r0 = r6.logger     // Catch:{ all -> 0x017c }
            java.lang.String r2 = r6.tag     // Catch:{ all -> 0x017c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            r4.<init>()     // Catch:{ all -> 0x017c }
            java.lang.String r5 = "Not allowed transition from "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r5 = r6.f655g     // Catch:{ all -> 0x017c }
            r4.append(r5)     // Catch:{ all -> 0x017c }
            java.lang.String r5 = " to "
            r4.append(r5)     // Catch:{ all -> 0x017c }
            r4.append(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x017c }
            r0.mo11375d(r2, r7)     // Catch:{ all -> 0x017c }
        L_0x0173:
            monitor-exit(r1)     // Catch:{ all -> 0x017c }
            if (r3 == 0) goto L_0x017b
            if (r8 == 0) goto L_0x017b
            r8.run()
        L_0x017b:
            return
        L_0x017c:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x017c }
            goto L_0x0180
        L_0x017f:
            throw r7
        L_0x0180:
            goto L_0x017f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.m813a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c, java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m817a(String str) {
        this.f651c.mo9996b(this.f654f);
        this.f654f.mo9928d(str);
        this.f654f.mo9929e(this.customPostbackData);
        C1314v vVar = this.logger;
        String str2 = this.tag;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing ad for '");
        outline24.append(this.adUnitId);
        outline24.append("'; loaded ad: ");
        outline24.append(this.f654f);
        outline24.append("...");
        vVar.mo11372b(str2, outline24.toString());
        mo9986a(this.f654f);
    }

    /* renamed from: a */
    private boolean m818a(Activity activity) {
        if (activity == null) {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        } else if (!isReady()) {
            String outline18 = GeneratedOutlineSupport.outline18(GeneratedOutlineSupport.outline24("Attempting to show ad before it is ready - please check ad readiness using "), this.tag, "#isReady()");
            C1314v.m2663i(this.tag, outline18);
            C1267j.m2548a(this.adListener, (MaxAd) this.f654f, (MaxError) new MaxErrorImpl(-24, outline18), true);
            return false;
        } else {
            if (Utils.getAlwaysFinishActivitiesSetting(activity) != 0) {
                if (Utils.isPubInDebugMode(activity)) {
                    throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                } else if (((Boolean) this.sdk.mo10946a(C1084a.f1515Z)).booleanValue()) {
                    C1314v.m2663i(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    C1267j.m2548a(this.adListener, (MaxAd) this.f654f, (MaxError) new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!"), true);
                    return false;
                }
            }
            if (((Boolean) this.sdk.mo10946a(C1084a.f1495F)).booleanValue() && (this.sdk.mo10966ad().mo11250a() || this.sdk.mo10966ad().mo11252b())) {
                C1314v.m2663i(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
                C1267j.m2548a(this.adListener, (MaxAd) this.f654f, (MaxError) new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing"), true);
                return false;
            } else if (!((Boolean) this.sdk.mo10946a(C1084a.f1496G)).booleanValue() || C1264h.m2521a((Context) activity)) {
                return true;
            } else {
                C1314v.m2663i(this.tag, "Attempting to show ad with no internet connection");
                C1267j.m2548a(this.adListener, (MaxAd) this.f654f, (MaxError) new MaxErrorImpl(-1009), true);
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m820b() {
        C0803c cVar;
        if (this.f656h.compareAndSet(true, false)) {
            synchronized (this.f653e) {
                cVar = this.f654f;
                this.f654f = null;
            }
            this.sdk.mo10925E().destroyAd(cVar);
            this.loadRequestBuilder.mo11203c("expired_ad_ad_unit_id");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m822b(final String str) {
        final long intValue = (long) ((Integer) this.sdk.mo10946a(C1084a.f1492C)).intValue();
        if (intValue > 0) {
            this.f652d = C1304n.m2612a(TimeUnit.SECONDS.toMillis(intValue), this.sdk, new Runnable() {
                public void run() {
                    String str = MaxFullscreenAdImpl.this.tag;
                    C1314v.m2662h(str, intValue + " second(s) elapsed without an ad load attempt after " + MaxFullscreenAdImpl.this.adFormat.getDisplayName().toLowerCase() + " " + str + ". Please ensure that you are re-loading ads correctly! (Ad Unit ID: " + MaxFullscreenAdImpl.this.adUnitId + ")");
                }
            });
        }
    }

    public void destroy() {
        m813a(C0832c.DESTROYED, (Runnable) new Runnable() {
            public void run() {
                synchronized (MaxFullscreenAdImpl.this.f653e) {
                    if (MaxFullscreenAdImpl.this.f654f != null) {
                        C1314v vVar = MaxFullscreenAdImpl.this.logger;
                        String str = MaxFullscreenAdImpl.this.tag;
                        vVar.mo11372b(str, "Destroying ad for '" + MaxFullscreenAdImpl.this.adUnitId + "'; current ad: " + MaxFullscreenAdImpl.this.f654f + "...");
                        MaxFullscreenAdImpl.this.sdk.mo10925E().destroyAd(MaxFullscreenAdImpl.this.f654f);
                    }
                }
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                maxFullscreenAdImpl.adListener = null;
                maxFullscreenAdImpl.revenueListener = null;
            }
        });
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.f653e) {
            z = this.f654f != null && this.f654f.mo9832e() && this.f655g == C0832c.READY;
        }
        return z;
    }

    public void loadAd(final Activity activity) {
        C1314v vVar = this.logger;
        String str = this.tag;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Loading ad for '");
        outline24.append(this.adUnitId);
        outline24.append("'...");
        vVar.mo11372b(str, outline24.toString());
        C1304n nVar = this.f652d;
        if (nVar != null) {
            nVar.mo11336d();
        }
        if (isReady()) {
            C1314v vVar2 = this.logger;
            String str2 = this.tag;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("An ad is already loaded for '");
            outline242.append(this.adUnitId);
            outline242.append("'");
            vVar2.mo11372b(str2, outline242.toString());
            C1267j.m2551a(this.adListener, (MaxAd) this.f654f, true);
            return;
        }
        m813a(C0832c.LOADING, (Runnable) new Runnable() {
            public void run() {
                Activity activity = activity;
                if (activity == null) {
                    activity = MaxFullscreenAdImpl.this.sdk.mo10977ao();
                }
                Activity activity2 = activity;
                MediationServiceImpl E = MaxFullscreenAdImpl.this.sdk.mo10925E();
                MaxFullscreenAdImpl maxFullscreenAdImpl = MaxFullscreenAdImpl.this;
                E.loadAd(maxFullscreenAdImpl.adUnitId, (String) null, maxFullscreenAdImpl.adFormat, maxFullscreenAdImpl.localExtraParameters, maxFullscreenAdImpl.loadRequestBuilder.mo11201a(), activity2, MaxFullscreenAdImpl.this.listenerWrapper);
            }
        });
    }

    public void onAdExpired() {
        C1314v vVar = this.logger;
        String str = this.tag;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ad expired ");
        outline24.append(getAdUnitId());
        vVar.mo11372b(str, outline24.toString());
        this.f656h.set(true);
        Activity activity = this.f649a.getActivity();
        if (activity == null && (activity = this.sdk.mo10967ae().mo10434a()) == null) {
            m820b();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, new MaxErrorImpl(-5601, "No Activity found"));
            return;
        }
        this.loadRequestBuilder.mo11200a("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.mo10925E().loadAd(this.adUnitId, (String) null, this.adFormat, this.localExtraParameters, this.loadRequestBuilder.mo11201a(), activity, this.listenerWrapper);
    }

    public void showAd(final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        if (viewGroup == null || lifecycle == null) {
            C1314v.m2663i(this.tag, "Attempting to show ad with null containerView or lifecycle.");
            C1267j.m2548a(this.adListener, (MaxAd) this.f654f, (MaxError) new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle."), true);
            return;
        }
        if (activity == null) {
            activity = this.sdk.mo10977ao();
        }
        if (m818a(activity)) {
            m812a(this.f654f, (Context) activity, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m813a(C0832c.SHOWING, (Runnable) new Runnable() {
                        public void run() {
                            MaxFullscreenAdImpl.this.m817a((String) null);
                            MediationServiceImpl E = MaxFullscreenAdImpl.this.sdk.mo10925E();
                            C0803c b = MaxFullscreenAdImpl.this.f654f;
                            C08224 r0 = C08224.this;
                            E.showFullscreenAd(b, viewGroup, lifecycle, activity, MaxFullscreenAdImpl.this.listenerWrapper);
                        }
                    });
                }
            });
        }
    }

    public void showAd(final String str, final Activity activity) {
        if (activity == null) {
            activity = this.sdk.mo10977ao();
        }
        if (m818a(activity)) {
            m812a(this.f654f, (Context) activity, (Runnable) new Runnable() {
                public void run() {
                    MaxFullscreenAdImpl.this.m813a(C0832c.SHOWING, (Runnable) new Runnable() {
                        public void run() {
                            C08203 r0 = C08203.this;
                            MaxFullscreenAdImpl.this.m817a(str);
                            MediationServiceImpl E = MaxFullscreenAdImpl.this.sdk.mo10925E();
                            C0803c b = MaxFullscreenAdImpl.this.f654f;
                            C08203 r2 = C08203.this;
                            E.showFullscreenAd(b, activity, MaxFullscreenAdImpl.this.listenerWrapper);
                        }
                    });
                }
            });
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tag);
        sb.append("{adUnitId='");
        GeneratedOutlineSupport.outline33(sb, this.adUnitId, '\'', ", adListener=");
        sb.append(this.adListener);
        sb.append(", revenueListener=");
        sb.append(this.revenueListener);
        sb.append(", isReady=");
        sb.append(isReady());
        sb.append('}');
        return sb.toString();
    }
}
