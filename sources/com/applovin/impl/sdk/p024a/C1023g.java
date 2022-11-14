package com.applovin.impl.sdk.p024a;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.p007a.C0636b;
import com.applovin.impl.p007a.C0640f;
import com.applovin.impl.p007a.C0641g;
import com.applovin.impl.p007a.C0645j;
import com.applovin.impl.p007a.C0647l;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.StringUtils;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ErrorType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.sdk.a.g */
public class C1023g extends C1010b {

    /* renamed from: h */
    public static final /* synthetic */ boolean f1327h = (!C1023g.class.desiredAssertionStatus());

    /* renamed from: i */
    public final C0631a f1328i;

    /* renamed from: j */
    public final AtomicBoolean f1329j = new AtomicBoolean();

    /* renamed from: k */
    public MediaEvents f1330k;

    /* renamed from: l */
    public final VastProperties f1331l;

    /* renamed from: m */
    public final AtomicBoolean f1332m = new AtomicBoolean();

    /* renamed from: n */
    public final AtomicBoolean f1333n = new AtomicBoolean();

    /* renamed from: o */
    public final AtomicBoolean f1334o = new AtomicBoolean();

    /* renamed from: p */
    public final AtomicBoolean f1335p = new AtomicBoolean();

    public C1023g(C0631a aVar) {
        super(aVar);
        this.f1328i = aVar;
        this.f1331l = aVar.mo9316f() == -1 ? VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE) : VastProperties.createVastPropertiesForSkippableMedia((float) aVar.mo9316f(), true, Position.STANDALONE);
    }

    @Nullable
    /* renamed from: a */
    public AdSessionConfiguration mo10448a() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false);
        } catch (Throwable th) {
            this.f1302c.mo11373b(this.f1303d, "Failed to create ad session configuration", th);
            return null;
        }
    }

    @Nullable
    /* renamed from: a */
    public AdSessionContext mo10449a(@Nullable WebView webView) {
        Set<C0645j> d;
        C0640f fVar;
        if (f1327h || this.f1328i.mo9309aQ() != null) {
            ArrayList arrayList = new ArrayList();
            for (C0636b next : this.f1328i.mo9309aQ().mo9352a()) {
                List<C0641g> b = next.mo9346b();
                if (!b.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (C0641g next2 : b) {
                        if ("omid".equalsIgnoreCase(next2.mo9372a())) {
                            arrayList2.add(next2);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        d = next.mo9348d();
                        fVar = C0640f.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED;
                        C0647l.m154a(d, fVar, this.f1301b);
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            try {
                                arrayList3.add(new URL(((C0641g) it.next()).mo9373b()));
                            } catch (Throwable th) {
                                this.f1302c.mo11373b(this.f1303d, "Failed to parse JavaScript resource url", th);
                            }
                        }
                        if (!arrayList3.isEmpty()) {
                            String c = next.mo9347c();
                            String a = next.mo9345a();
                            if (!StringUtils.isValidString(c) || StringUtils.isValidString(a)) {
                                Iterator it2 = arrayList3.iterator();
                                while (it2.hasNext()) {
                                    URL url = (URL) it2.next();
                                    arrayList.add(StringUtils.isValidString(c) ? VerificationScriptResource.createVerificationScriptResourceWithParameters(a, url, c) : VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                                }
                            }
                        }
                    }
                }
                d = next.mo9348d();
                fVar = C0640f.FAILED_TO_LOAD_RESOURCE;
                C0647l.m154a(d, fVar, this.f1301b);
            }
            String e = this.f1301b.mo10975am().mo10477e();
            if (TextUtils.isEmpty(e)) {
                this.f1302c.mo11376e(this.f1303d, "JavaScript SDK content not loaded successfully");
                return null;
            }
            try {
                return AdSessionContext.createNativeAdSessionContext(this.f1301b.mo10975am().mo10476d(), e, arrayList, this.f1328i.getOpenMeasurementContentUrl(), this.f1328i.getOpenMeasurementCustomReferenceData());
            } catch (Throwable th2) {
                this.f1302c.mo11373b(this.f1303d, "Failed to create ad session context", th2);
                return null;
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo10479a(final float f, final boolean z) {
        if (this.f1332m.compareAndSet(false, true)) {
            mo10454a("track started", (Runnable) new Runnable() {
                public void run() {
                    C1023g.this.f1330k.start(f, z ? 0.0f : 1.0f);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo10451a(final View view, final List<C1019d> list) {
        mo10454a("update main view: " + view, (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1305f.registerAdView(view);
                C1023g.this.f1305f.removeAllFriendlyObstructions();
                for (C1019d dVar : list) {
                    if (dVar.mo10467a() != null) {
                        try {
                            C1023g.this.f1305f.addFriendlyObstruction(dVar.mo10467a(), dVar.mo10468b(), dVar.mo10469c());
                        } catch (Throwable th) {
                            C1023g gVar = C1023g.this;
                            C1314v vVar = gVar.f1302c;
                            String str = gVar.f1303d;
                            vVar.mo11373b(str, "Failed to add friendly obstruction (" + dVar + ")", th);
                        }
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public void mo10452a(AdSession adSession) {
        try {
            this.f1330k = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th) {
            this.f1302c.mo11373b(this.f1303d, "Failed to create media events", th);
        }
    }

    /* renamed from: a */
    public void mo10453a(final String str) {
        mo10454a("track error", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1305f.error(ErrorType.VIDEO, str);
            }
        });
    }

    /* renamed from: a */
    public void mo10480a(final boolean z) {
        mo10454a("track volume changed", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1330k.volumeChange(z ? 0.0f : 1.0f);
            }
        });
    }

    /* renamed from: c */
    public void mo10457c() {
        mo10454a("track loaded", (Runnable) new Runnable() {
            public void run() {
                C1023g gVar = C1023g.this;
                gVar.f1306g.loaded(gVar.f1331l);
            }
        });
    }

    /* renamed from: d */
    public void mo10458d() {
        mo10454a("track impression event", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1306g.impressionOccurred();
            }
        });
    }

    /* renamed from: e */
    public void mo10459e() {
        mo10454a("stop session", (Runnable) new Runnable() {
            public void run() {
                C1023g gVar = C1023g.this;
                gVar.f1304e = false;
                gVar.f1305f.finish();
                C1023g.this.f1305f = null;
            }
        });
    }

    /* renamed from: f */
    public void mo10481f() {
        if (this.f1333n.compareAndSet(false, true)) {
            mo10454a("track first quartile", (Runnable) new Runnable() {
                public void run() {
                    C1023g.this.f1330k.firstQuartile();
                }
            });
        }
    }

    /* renamed from: g */
    public void mo10482g() {
        if (this.f1334o.compareAndSet(false, true)) {
            mo10454a("track midpoint", (Runnable) new Runnable() {
                public void run() {
                    C1023g.this.f1330k.midpoint();
                }
            });
        }
    }

    /* renamed from: h */
    public void mo10483h() {
        if (this.f1335p.compareAndSet(false, true)) {
            mo10454a("track third quartile", (Runnable) new Runnable() {
                public void run() {
                    C1023g.this.f1330k.thirdQuartile();
                }
            });
        }
    }

    /* renamed from: i */
    public void mo10484i() {
        mo10454a("track completed", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1330k.complete();
            }
        });
    }

    /* renamed from: j */
    public void mo10485j() {
        mo10454a("track paused", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1330k.pause();
            }
        });
    }

    /* renamed from: k */
    public void mo10486k() {
        mo10454a("track resumed", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1330k.resume();
            }
        });
    }

    /* renamed from: l */
    public void mo10487l() {
        if (this.f1329j.compareAndSet(false, true)) {
            mo10454a("buffer started", (Runnable) new Runnable() {
                public void run() {
                    C1023g.this.f1330k.bufferStart();
                }
            });
        }
    }

    /* renamed from: m */
    public void mo10488m() {
        if (this.f1329j.compareAndSet(true, false)) {
            mo10454a("buffer finished", (Runnable) new Runnable() {
                public void run() {
                    C1023g.this.f1330k.bufferFinish();
                }
            });
        }
    }

    /* renamed from: n */
    public void mo10489n() {
        mo10454a("track skipped", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1330k.skipped();
            }
        });
    }

    /* renamed from: o */
    public void mo10490o() {
        mo10454a("track clicked", (Runnable) new Runnable() {
            public void run() {
                C1023g.this.f1330k.adUserInteraction(InteractionType.CLICK);
            }
        });
    }
}
