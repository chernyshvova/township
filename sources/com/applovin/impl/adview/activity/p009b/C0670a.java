package com.applovin.impl.adview.activity.p009b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0725b;
import com.applovin.impl.adview.C0740d;
import com.applovin.impl.adview.C0752i;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.adview.C0768n;
import com.applovin.impl.adview.activity.C0669b;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1169h;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p026b.C1074b;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1159v;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.AppKilledService;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.C1304n;
import com.applovin.impl.sdk.utils.C1307p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.a */
public abstract class C0670a implements C1074b.C1081a {

    /* renamed from: A */
    public int f221A = 0;

    /* renamed from: B */
    public final ArrayList<Long> f222B = new ArrayList<>();

    /* renamed from: a */
    public final C1057e f223a;

    /* renamed from: b */
    public final C1188m f224b;

    /* renamed from: c */
    public final C1314v f225c;

    /* renamed from: d */
    public final C1101d f226d;

    /* renamed from: e */
    public Activity f227e;

    /* renamed from: f */
    public AppLovinAdView f228f;
    @Nullable

    /* renamed from: g */
    public final C0767m f229g;

    /* renamed from: h */
    public final long f230h = SystemClock.elapsedRealtime();

    /* renamed from: i */
    public long f231i = -1;

    /* renamed from: j */
    public int f232j = 0;

    /* renamed from: k */
    public int f233k = 0;

    /* renamed from: l */
    public int f234l = C1169h.f2109a;

    /* renamed from: m */
    public boolean f235m;

    /* renamed from: n */
    public AppLovinAdClickListener f236n;

    /* renamed from: o */
    public AppLovinAdDisplayListener f237o;

    /* renamed from: p */
    public AppLovinAdVideoPlaybackListener f238p;

    /* renamed from: q */
    public final C1074b f239q;
    @Nullable

    /* renamed from: r */
    public C1304n f240r;
    @Nullable

    /* renamed from: s */
    public C1304n f241s;

    /* renamed from: t */
    public final Handler f242t = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: u */
    public final C1256a f243u;
    @Nullable

    /* renamed from: v */
    public final AppLovinBroadcastManager.Receiver f244v;
    @Nullable

    /* renamed from: w */
    public final C1169h.C1171a f245w;

    /* renamed from: x */
    public final AtomicBoolean f246x = new AtomicBoolean();

    /* renamed from: y */
    public final AtomicBoolean f247y = new AtomicBoolean();

    /* renamed from: z */
    public long f248z;

    /* renamed from: com.applovin.impl.adview.activity.b.a$a */
    public interface C0682a {
        /* renamed from: a */
        void mo9256a(C0670a aVar);

        /* renamed from: a */
        void mo9257a(String str, Throwable th);
    }

    /* renamed from: com.applovin.impl.adview.activity.b.a$b */
    public class C0683b implements View.OnClickListener, AppLovinAdClickListener {
        public C0683b() {
        }

        public void adClicked(AppLovinAd appLovinAd) {
            C0670a.this.f225c.mo11372b("AppLovinFullscreenActivity", "Clicking through graphic");
            C1267j.m2559a(C0670a.this.f236n, appLovinAd);
            C0670a.this.f226d.mo10732b();
            C0670a.this.f233k++;
        }

        public void onClick(View view) {
            C0670a aVar = C0670a.this;
            if (view != aVar.f229g || !((Boolean) aVar.f224b.mo10946a(C1085b.f1692cs)).booleanValue()) {
                C1314v vVar = C0670a.this.f225c;
                vVar.mo11376e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                return;
            }
            C0670a.m209c(C0670a.this);
            if (C0670a.this.f223a.mo10571Q()) {
                C0670a aVar2 = C0670a.this;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("javascript:al_onCloseButtonTapped(");
                outline24.append(C0670a.this.f221A);
                outline24.append(",");
                outline24.append(C0670a.this.f232j);
                outline24.append(",");
                outline24.append(C0670a.this.f233k);
                outline24.append(");");
                aVar2.mo9459b(outline24.toString());
            }
            List<Integer> r = C0670a.this.f223a.mo10628r();
            C1314v vVar2 = C0670a.this.f225c;
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Handling close button tap ");
            outline242.append(C0670a.this.f221A);
            outline242.append(" with multi close delay: ");
            outline242.append(r);
            vVar2.mo11372b("AppLovinFullscreenActivity", outline242.toString());
            if (r == null || r.size() <= C0670a.this.f221A) {
                C0670a.this.mo9466h();
                return;
            }
            C0670a.this.f222B.add(Long.valueOf(SystemClock.elapsedRealtime() - C0670a.this.f231i));
            List<C0752i.C0753a> t = C0670a.this.f223a.mo10630t();
            if (t != null && t.size() > C0670a.this.f221A) {
                C0670a aVar3 = C0670a.this;
                aVar3.f229g.mo9674a(t.get(aVar3.f221A));
            }
            C1314v vVar3 = C0670a.this.f225c;
            StringBuilder outline243 = GeneratedOutlineSupport.outline24("Scheduling next close button with delay: ");
            outline243.append(r.get(C0670a.this.f221A));
            vVar3.mo11372b("AppLovinFullscreenActivity", outline243.toString());
            C0670a.this.f229g.setVisibility(8);
            C0670a aVar4 = C0670a.this;
            aVar4.mo9452a(aVar4.f229g, (long) r.get(aVar4.f221A).intValue(), new Runnable() {
                public void run() {
                    C0670a.this.f231i = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    public C0670a(final C1057e eVar, Activity activity, final C1188m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f223a = eVar;
        this.f224b = mVar;
        this.f225c = mVar.mo10922B();
        this.f227e = activity;
        this.f236n = appLovinAdClickListener;
        this.f237o = appLovinAdDisplayListener;
        this.f238p = appLovinAdVideoPlaybackListener;
        C1074b bVar = new C1074b(activity, mVar);
        this.f239q = bVar;
        bVar.mo10657a((C1074b.C1081a) this);
        this.f226d = new C1101d(eVar, mVar);
        C0683b bVar2 = new C0683b();
        C0768n nVar = new C0768n(mVar.mo10944Y(), AppLovinAdSize.INTERSTITIAL, activity);
        this.f228f = nVar;
        nVar.setAdClickListener(bVar2);
        this.f228f.setAdDisplayListener(new AppLovinAdDisplayListener() {
            public void adDisplayed(AppLovinAd appLovinAd) {
                C0670a.this.f225c.mo11372b("AppLovinFullscreenActivity", "Web content rendered");
            }

            public void adHidden(AppLovinAd appLovinAd) {
                C0670a.this.f225c.mo11372b("AppLovinFullscreenActivity", "Closing from WebView");
                C0670a.this.mo9466h();
            }
        });
        C0725b controller = this.f228f.getController();
        controller.mo9571a(this.f226d);
        controller.mo9596s().setIsShownOutOfContext(eVar.mo10602ah());
        mVar.mo11005u().trackImpression(eVar);
        List<Integer> r = eVar.mo10628r();
        if (eVar.mo10627q() >= 0 || r != null) {
            C0767m mVar2 = new C0767m(eVar.mo10629s(), activity);
            this.f229g = mVar2;
            mVar2.setVisibility(8);
            this.f229g.setOnClickListener(bVar2);
        } else {
            this.f229g = null;
        }
        if (((Boolean) mVar.mo10946a(C1085b.f1694cu)).booleanValue()) {
            this.f244v = new AppLovinBroadcastManager.Receiver() {
                public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
                    mVar.mo11005u().trackAppKilled(eVar);
                    mVar.mo10972aj().unregisterReceiver(this);
                }
            };
            mVar.mo10972aj().registerReceiver(this.f244v, new IntentFilter(AppKilledService.ACTION_APP_KILLED));
        } else {
            this.f244v = null;
        }
        if (eVar.mo10601ag()) {
            this.f245w = new C1169h.C1171a() {
                /* renamed from: a */
                public void mo9481a(int i) {
                    String str;
                    C0670a aVar = C0670a.this;
                    if (aVar.f234l != C1169h.f2109a) {
                        aVar.f235m = true;
                    }
                    C0740d s = C0670a.this.f228f.getController().mo9596s();
                    if (!C1169h.m1994a(i) || C1169h.m1994a(C0670a.this.f234l)) {
                        if (i == 2) {
                            str = "javascript:al_muteSwitchOff();";
                        }
                        C0670a.this.f234l = i;
                    }
                    str = "javascript:al_muteSwitchOn();";
                    s.mo9615a(str);
                    C0670a.this.f234l = i;
                }
            };
            mVar.mo10971ai().mo10888a(this.f245w);
        } else {
            this.f245w = null;
        }
        if (((Boolean) mVar.mo10946a(C1085b.f1758eG)).booleanValue()) {
            this.f243u = new C1256a() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    if (!C0670a.this.f247y.get()) {
                        if (activity.getClass().getName().equals(Utils.retrieveLauncherActivityFullyQualifiedName(activity.getApplicationContext()))) {
                            mVar.mo10938S().mo10829a((C1109a) new C1166z(mVar, new Runnable() {
                                public void run() {
                                    C1314v.m2663i("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
                                    C0670a.this.mo9466h();
                                }
                            }), C1140o.C1142a.MAIN);
                        }
                    }
                }
            };
            mVar.mo10967ae().mo10435a(this.f243u);
            return;
        }
        this.f243u = null;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.applovin.impl.adview.activity.b.a] */
    /* JADX WARNING: type inference failed for: r1v23, types: [com.applovin.impl.adview.activity.b.b] */
    /* JADX WARNING: type inference failed for: r1v24, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v25, types: [com.applovin.impl.adview.activity.b.f] */
    /* JADX WARNING: type inference failed for: r1v26, types: [com.applovin.impl.adview.activity.b.e] */
    /* JADX WARNING: type inference failed for: r1v27, types: [com.applovin.impl.adview.activity.b.g] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v29, types: [com.applovin.impl.adview.activity.b.d] */
    /* JADX WARNING: type inference failed for: r1v30, types: [com.applovin.impl.adview.activity.b.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m207a(com.applovin.impl.sdk.p025ad.C1057e r15, com.applovin.sdk.AppLovinAdClickListener r16, com.applovin.sdk.AppLovinAdDisplayListener r17, com.applovin.sdk.AppLovinAdVideoPlaybackListener r18, com.applovin.impl.sdk.C1188m r19, android.app.Activity r20, com.applovin.impl.adview.activity.p009b.C0670a.C0682a r21) {
        /*
            r8 = r19
            r9 = r21
            boolean r0 = r15.mo10589aD()
            if (r0 == 0) goto L_0x0012
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkExoPlayerEligibility(r19)
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            r10 = r15
            boolean r1 = r10 instanceof com.applovin.impl.p007a.C0631a
            java.lang.String r11 = "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter."
            java.lang.String r12 = "AppLovinFullscreenActivity"
            java.lang.String r13 = " and throwable: "
            if (r1 == 0) goto L_0x008c
            java.lang.String r14 = "Failed to create FullscreenVastVideoAdPresenter with sdk: "
            if (r0 == 0) goto L_0x0072
            com.applovin.impl.adview.activity.b.c r0 = new com.applovin.impl.adview.activity.b.c     // Catch:{ all -> 0x0035 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0035 }
            goto L_0x011e
        L_0x0035:
            r0 = move-exception
            com.applovin.impl.sdk.v r1 = r19.mo10922B()
            r1.mo11371a((java.lang.String) r12, (java.lang.String) r11, (java.lang.Throwable) r0)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            com.applovin.impl.sdk.utils.Utils.isExoPlayerEligible = r0
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x0054 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0054 }
            goto L_0x011e
        L_0x0054:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x005a:
            r1.append(r14)
        L_0x005d:
            r1.append(r8)
            r1.append(r13)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r9.mo9257a(r1, r0)
            return
        L_0x0072:
            com.applovin.impl.adview.activity.b.d r0 = new com.applovin.impl.adview.activity.b.d     // Catch:{ all -> 0x0085 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0085 }
            goto L_0x011e
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x005a
        L_0x008c:
            boolean r1 = r15.hasVideoUrl()
            if (r1 == 0) goto L_0x010d
            boolean r1 = r15.mo10593aH()
            if (r1 == 0) goto L_0x00b7
            com.applovin.impl.adview.activity.b.g r0 = new com.applovin.impl.adview.activity.b.g     // Catch:{ all -> 0x00ab }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00ab }
            goto L_0x011e
        L_0x00ab:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenWebVideoAdPresenter with sdk: "
        L_0x00b3:
            r1.append(r2)
            goto L_0x005d
        L_0x00b7:
            if (r0 == 0) goto L_0x00f2
            com.applovin.impl.adview.activity.b.e r0 = new com.applovin.impl.adview.activity.b.e     // Catch:{ all -> 0x00cb }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00cb }
            goto L_0x011e
        L_0x00cb:
            r0 = move-exception
            com.applovin.impl.sdk.v r1 = r19.mo10922B()
            r1.mo11371a((java.lang.String) r12, (java.lang.String) r11, (java.lang.Throwable) r0)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            com.applovin.impl.sdk.utils.Utils.isExoPlayerEligible = r0
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x00e9 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00e9 }
            goto L_0x011e
        L_0x00e9:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: "
            goto L_0x00b3
        L_0x00f2:
            com.applovin.impl.adview.activity.b.f r0 = new com.applovin.impl.adview.activity.b.f     // Catch:{ all -> 0x0104 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0104 }
            goto L_0x011e
        L_0x0104:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenVideoAdPresenter with sdk: "
            goto L_0x00b3
        L_0x010d:
            com.applovin.impl.adview.activity.b.b r0 = new com.applovin.impl.adview.activity.b.b     // Catch:{ all -> 0x0122 }
            r1 = r0
            r2 = r15
            r3 = r20
            r4 = r19
            r5 = r16
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0122 }
        L_0x011e:
            r9.mo9256a(r0)
            return
        L_0x0122:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to create FullscreenGraphicAdPresenter with sdk: "
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.p009b.C0670a.m207a(com.applovin.impl.sdk.ad.e, com.applovin.sdk.AppLovinAdClickListener, com.applovin.sdk.AppLovinAdDisplayListener, com.applovin.sdk.AppLovinAdVideoPlaybackListener, com.applovin.impl.sdk.m, android.app.Activity, com.applovin.impl.adview.activity.b.a$a):void");
    }

    /* renamed from: c */
    public static /* synthetic */ int m209c(C0670a aVar) {
        int i = aVar.f221A;
        aVar.f221A = i + 1;
        return i;
    }

    /* renamed from: a */
    public void mo9447a(int i, KeyEvent keyEvent) {
        C1314v vVar = this.f225c;
        if (vVar != null) {
            vVar.mo11374c("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i + RESTClient.COMMA_SEPARATOR + keyEvent);
        }
    }

    /* renamed from: a */
    public void mo9448a(int i, boolean z, boolean z2, long j) {
        int i2 = i;
        if (this.f246x.compareAndSet(false, true)) {
            if (this.f223a.hasVideoUrl() || mo9478t()) {
                C1267j.m2565a(this.f238p, (AppLovinAd) this.f223a, (double) i2, z2);
            }
            if (this.f223a.hasVideoUrl()) {
                this.f226d.mo10735c((long) i2);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f230h;
            this.f224b.mo11005u().trackVideoEnd(this.f223a, TimeUnit.MILLISECONDS.toSeconds(elapsedRealtime), i, z);
            long j2 = -1;
            if (this.f231i != -1) {
                j2 = SystemClock.elapsedRealtime() - this.f231i;
            }
            this.f224b.mo11005u().trackFullScreenAdClosed(this.f223a, j2, this.f222B, j, this.f235m, this.f234l);
            C1314v vVar = this.f225c;
            vVar.mo11372b("AppLovinFullscreenActivity", "Video ad ended at percent: " + i2 + "%, elapsedTime: " + elapsedRealtime + "ms, skipTimeMillis: " + j + "ms, closeTimeMillis: " + j2 + "ms");
        }
    }

    /* renamed from: a */
    public abstract void mo9449a(long j);

    /* renamed from: a */
    public void mo9450a(Configuration configuration) {
        C1314v vVar = this.f225c;
        vVar.mo11374c("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
    }

    /* renamed from: a */
    public abstract void mo9451a(@Nullable ViewGroup viewGroup);

    /* renamed from: a */
    public void mo9452a(final C0767m mVar, long j, final Runnable runnable) {
        if (j < ((Long) this.f224b.mo10946a(C1085b.f1691cr)).longValue()) {
            C06787 r0 = new Runnable() {
                public void run() {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            C1307p.m2629a((View) mVar, 400, (Runnable) new Runnable() {
                                public void run() {
                                    mVar.bringToFront();
                                    runnable.run();
                                }
                            });
                        }
                    });
                }
            };
            if (((Boolean) this.f224b.mo10946a(C1085b.f1658cK)).booleanValue()) {
                this.f241s = C1304n.m2612a(TimeUnit.SECONDS.toMillis(j), this.f224b, r0);
            } else {
                this.f224b.mo10938S().mo10831a((C1109a) new C1166z(this.f224b, r0), C1140o.C1142a.MAIN, TimeUnit.SECONDS.toMillis(j), true);
            }
        }
    }

    /* renamed from: a */
    public void mo9453a(Runnable runnable, long j) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j, this.f242t);
    }

    /* renamed from: a */
    public void mo9454a(String str) {
        if (this.f223a.mo10572R()) {
            mo9455a(str, 0);
        }
    }

    /* renamed from: a */
    public void mo9455a(final String str, long j) {
        if (j >= 0) {
            mo9453a((Runnable) new Runnable() {
                public void run() {
                    C0740d s;
                    if (StringUtils.isValidString(str) && (s = C0670a.this.f228f.getController().mo9596s()) != null) {
                        s.mo9615a(str);
                    }
                }
            }, j);
        }
    }

    /* renamed from: a */
    public void mo9456a(boolean z) {
        List<Uri> checkCachedResourcesExist = Utils.checkCachedResourcesExist(z, this.f223a, this.f224b, this.f227e);
        if (checkCachedResourcesExist.isEmpty()) {
            return;
        }
        if (!((Boolean) this.f224b.mo10946a(C1085b.f1762eK)).booleanValue()) {
            this.f223a.mo9300a();
            return;
        }
        throw new IllegalStateException("Missing cached resource(s): " + checkCachedResourcesExist);
    }

    /* renamed from: a */
    public void mo9457a(boolean z, long j) {
        if (this.f223a.mo10570P()) {
            mo9455a(z ? "javascript:al_mute();" : "javascript:al_unmute();", j);
        }
    }

    /* renamed from: b */
    public void mo9458b(long j) {
        C1314v vVar = this.f225c;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Scheduling report reward in ");
        outline24.append(TimeUnit.MILLISECONDS.toSeconds(j));
        outline24.append(" seconds...");
        vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
        this.f240r = C1304n.m2612a(j, this.f224b, new Runnable() {
            public void run() {
                if (!C0670a.this.f223a.mo10596ab().getAndSet(true)) {
                    C0670a aVar = C0670a.this;
                    C0670a.this.f224b.mo10938S().mo10829a((C1109a) new C1159v(aVar.f223a, aVar.f224b), C1140o.C1142a.REWARD);
                }
            }
        });
    }

    /* renamed from: b */
    public void mo9459b(String str) {
        mo9455a(str, 0);
    }

    /* renamed from: b */
    public void mo9460b(boolean z) {
        mo9457a(z, ((Long) this.f224b.mo10946a(C1085b.f1655cH)).longValue());
        C1267j.m2560a(this.f237o, (AppLovinAd) this.f223a);
        this.f224b.mo10966ad().mo11248a((Object) this.f223a);
        this.f224b.mo10974al().mo11017a((Object) this.f223a);
        if (this.f223a.hasVideoUrl() || mo9478t()) {
            C1267j.m2564a(this.f238p, (AppLovinAd) this.f223a);
        }
        new C0669b(this.f227e).mo9446a(this.f223a);
        this.f226d.mo10730a();
        this.f223a.setHasShown(true);
    }

    /* renamed from: c */
    public void mo9461c(boolean z) {
        C1314v vVar = this.f225c;
        vVar.mo11374c("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z);
        mo9454a("javascript:al_onWindowFocusChanged( " + z + " );");
        C1304n nVar = this.f241s;
        if (nVar == null) {
            return;
        }
        if (z) {
            nVar.mo11335c();
        } else {
            nVar.mo11334b();
        }
    }

    /* renamed from: d */
    public abstract void mo9462d();

    /* renamed from: e */
    public abstract void mo9463e();

    /* renamed from: f */
    public void mo9464f() {
        this.f225c.mo11374c("AppLovinFullscreenActivity", "onResume()");
        this.f226d.mo10737d(SystemClock.elapsedRealtime() - this.f248z);
        mo9454a("javascript:al_onAppResumed();");
        mo9475q();
        if (this.f239q.mo10659c()) {
            this.f239q.mo10655a();
        }
    }

    /* renamed from: g */
    public void mo9465g() {
        this.f225c.mo11374c("AppLovinFullscreenActivity", "onPause()");
        this.f248z = SystemClock.elapsedRealtime();
        mo9454a("javascript:al_onAppPaused();");
        this.f239q.mo10655a();
        mo9474p();
    }

    /* renamed from: h */
    public void mo9466h() {
        this.f225c.mo11374c("AppLovinFullscreenActivity", "dismiss()");
        this.f242t.removeCallbacksAndMessages((Object) null);
        mo9455a("javascript:al_onPoststitialDismiss();", (long) this.f223a.mo10569O());
        mo9472n();
        this.f226d.mo10734c();
        if (this.f244v != null) {
            C1304n.m2612a(TimeUnit.SECONDS.toMillis(2), this.f224b, new Runnable() {
                public void run() {
                    C0670a.this.f227e.stopService(new Intent(C0670a.this.f227e.getApplicationContext(), AppKilledService.class));
                    C0670a.this.f224b.mo10972aj().unregisterReceiver(C0670a.this.f244v);
                }
            });
        }
        if (this.f245w != null) {
            this.f224b.mo10971ai().mo10889b(this.f245w);
        }
        if (this.f243u != null) {
            this.f224b.mo10967ae().mo10437b(this.f243u);
        }
        if (mo9473o()) {
            this.f227e.finish();
            return;
        }
        this.f224b.mo10922B().mo11372b("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        mo9468j();
    }

    /* renamed from: i */
    public void mo9467i() {
        this.f225c.mo11374c("AppLovinFullscreenActivity", "onStop()");
    }

    /* renamed from: j */
    public void mo9468j() {
        AppLovinAdView appLovinAdView = this.f228f;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.f228f.destroy();
            this.f228f = null;
            if ((parent instanceof ViewGroup) && mo9473o()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        mo9471m();
        mo9472n();
        this.f236n = null;
        this.f237o = null;
        this.f238p = null;
        this.f227e = null;
    }

    /* renamed from: k */
    public void mo9469k() {
        C1314v.m2663i("AppLovinFullscreenActivity", "---low memory detected - running garbage collection---");
        System.gc();
    }

    /* renamed from: l */
    public void mo9470l() {
        this.f225c.mo11374c("AppLovinFullscreenActivity", "onBackPressed()");
        if (this.f223a.mo10571Q()) {
            mo9459b("javascript:onBackPressed();");
        }
    }

    /* renamed from: m */
    public abstract void mo9471m();

    /* renamed from: n */
    public void mo9472n() {
        if (this.f247y.compareAndSet(false, true)) {
            C1267j.m2572b(this.f237o, (AppLovinAd) this.f223a);
            this.f224b.mo10966ad().mo11251b((Object) this.f223a);
            this.f224b.mo10974al().mo11016a();
        }
    }

    /* renamed from: o */
    public boolean mo9473o() {
        return this.f227e instanceof AppLovinFullscreenActivity;
    }

    /* renamed from: p */
    public void mo9474p() {
        C1304n nVar = this.f240r;
        if (nVar != null) {
            nVar.mo11334b();
        }
    }

    /* renamed from: q */
    public void mo9475q() {
        C1304n nVar = this.f240r;
        if (nVar != null) {
            nVar.mo11335c();
        }
    }

    /* renamed from: r */
    public abstract boolean mo9476r();

    /* renamed from: s */
    public abstract boolean mo9477s();

    /* renamed from: t */
    public boolean mo9478t() {
        return AppLovinAdType.INCENTIVIZED == this.f223a.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.f223a.getType();
    }

    /* renamed from: u */
    public abstract void mo9479u();
}
