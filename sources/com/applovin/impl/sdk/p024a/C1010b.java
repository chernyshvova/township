package com.applovin.impl.sdk.p024a;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.security.CertificateUtil;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.a.b */
public abstract class C1010b {

    /* renamed from: a */
    public final AppLovinAdBase f1300a;

    /* renamed from: b */
    public final C1188m f1301b;

    /* renamed from: c */
    public final C1314v f1302c;

    /* renamed from: d */
    public final String f1303d;

    /* renamed from: e */
    public boolean f1304e;

    /* renamed from: f */
    public AdSession f1305f;

    /* renamed from: g */
    public AdEvents f1306g;

    public C1010b(AppLovinAdBase appLovinAdBase) {
        this.f1300a = appLovinAdBase;
        this.f1301b = appLovinAdBase.getSdk();
        this.f1302c = appLovinAdBase.getSdk().mo10922B();
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AdEventTracker:");
        outline24.append(appLovinAdBase.getAdIdNumber());
        outline24.append(CertificateUtil.DELIMITER);
        outline24.append(appLovinAdBase.getDspName());
        this.f1303d = outline24.toString();
    }

    @Nullable
    /* renamed from: a */
    public abstract AdSessionConfiguration mo10448a();

    @Nullable
    /* renamed from: a */
    public abstract AdSessionContext mo10449a(@Nullable WebView webView);

    /* renamed from: a */
    public void mo10450a(View view) {
        mo10451a(view, (List<C1019d>) Collections.emptyList());
    }

    /* renamed from: a */
    public void mo10451a(final View view, final List<C1019d> list) {
        mo10454a("update main view: " + view, (Runnable) new Runnable() {
            public void run() {
                C1010b.this.f1305f.registerAdView(view);
                C1010b.this.f1305f.removeAllFriendlyObstructions();
                for (C1019d dVar : list) {
                    if (dVar.mo10467a() != null) {
                        try {
                            C1010b.this.f1305f.addFriendlyObstruction(dVar.mo10467a(), dVar.mo10468b(), dVar.mo10469c());
                        } catch (Throwable th) {
                            C1010b bVar = C1010b.this;
                            C1314v vVar = bVar.f1302c;
                            String str = bVar.f1303d;
                            vVar.mo11373b(str, "Failed to add friendly obstruction (" + dVar + ")", th);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo10452a(AdSession adSession) {
    }

    /* renamed from: a */
    public void mo10453a(final String str) {
        mo10454a("track error", (Runnable) new Runnable() {
            public void run() {
                C1010b.this.f1305f.error(ErrorType.VIDEO, str);
            }
        });
    }

    /* renamed from: a */
    public void mo10454a(final String str, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C1010b.this.f1304e) {
                        C1314v vVar = C1010b.this.f1302c;
                        String str = C1010b.this.f1303d;
                        vVar.mo11372b(str, "Running operation: " + str);
                        runnable.run();
                    }
                } catch (Throwable th) {
                    C1010b bVar = C1010b.this;
                    C1314v vVar2 = bVar.f1302c;
                    String str2 = bVar.f1303d;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Failed to run operation: ");
                    outline24.append(str);
                    vVar2.mo11373b(str2, outline24.toString(), th);
                }
            }
        });
    }

    /* renamed from: b */
    public void mo10455b() {
        mo10456b((WebView) null);
    }

    /* renamed from: b */
    public void mo10456b(@Nullable final WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AdSessionContext a;
                if (!C1010b.this.f1300a.isOpenMeasurementEnabled()) {
                    C1010b bVar = C1010b.this;
                    bVar.f1302c.mo11374c(bVar.f1303d, "Skip starting session - Open Measurement disabled");
                    return;
                }
                C1010b bVar2 = C1010b.this;
                if (bVar2.f1305f != null) {
                    C1314v vVar = bVar2.f1302c;
                    String str = bVar2.f1303d;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Attempting to start session again for ad: ");
                    outline24.append(C1010b.this.f1300a);
                    vVar.mo11375d(str, outline24.toString());
                    return;
                }
                bVar2.f1302c.mo11372b(bVar2.f1303d, "Starting session");
                AdSessionConfiguration a2 = C1010b.this.mo10448a();
                if (a2 != null && (a = C1010b.this.mo10449a(webView)) != null) {
                    try {
                        C1010b.this.f1305f = AdSession.createAdSession(a2, a);
                        try {
                            C1010b.this.f1306g = AdEvents.createAdEvents(C1010b.this.f1305f);
                            C1010b bVar3 = C1010b.this;
                            bVar3.mo10452a(bVar3.f1305f);
                            C1010b.this.f1305f.start();
                            C1010b bVar4 = C1010b.this;
                            bVar4.f1304e = true;
                            bVar4.f1302c.mo11372b(bVar4.f1303d, "Session started");
                        } catch (Throwable th) {
                            C1010b bVar5 = C1010b.this;
                            bVar5.f1302c.mo11373b(bVar5.f1303d, "Failed to create ad events", th);
                        }
                    } catch (Throwable th2) {
                        C1010b bVar6 = C1010b.this;
                        bVar6.f1302c.mo11373b(bVar6.f1303d, "Failed to create session", th2);
                    }
                }
            }
        });
    }

    /* renamed from: c */
    public void mo10457c() {
        mo10454a("track loaded", (Runnable) new Runnable() {
            public void run() {
                C1010b.this.f1306g.loaded();
            }
        });
    }

    /* renamed from: d */
    public void mo10458d() {
        mo10454a("track impression event", (Runnable) new Runnable() {
            public void run() {
                C1010b.this.f1306g.impressionOccurred();
            }
        });
    }

    /* renamed from: e */
    public void mo10459e() {
        mo10454a("stop session", (Runnable) new Runnable() {
            public void run() {
                C1010b bVar = C1010b.this;
                bVar.f1304e = false;
                bVar.f1305f.finish();
                C1010b.this.f1305f = null;
            }
        });
    }
}
