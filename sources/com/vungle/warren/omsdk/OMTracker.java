package com.vungle.warren.omsdk;

import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.android.billingclient.api.zzam;
import com.iab.omid.library.vungle.Omid;
import com.iab.omid.library.vungle.adsession.AdSession;
import com.iab.omid.library.vungle.adsession.AdSessionConfiguration;
import com.iab.omid.library.vungle.adsession.AdSessionContext;
import com.iab.omid.library.vungle.adsession.AdSessionContextType;
import com.iab.omid.library.vungle.adsession.C2889a;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import com.iab.omid.library.vungle.adsession.Partner;
import com.iab.omid.library.vungle.adsession.VerificationScriptResource;
import com.iab.omid.library.vungle.p050a.C2887d;
import com.iab.omid.library.vungle.p051b.C2891a;
import com.iab.omid.library.vungle.p051b.C2892b;
import com.iab.omid.library.vungle.p051b.C2896e;
import com.iab.omid.library.vungle.p051b.C2898f;
import com.iab.omid.library.vungle.p054e.C2905a;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.walking.TreeWalker;
import com.iab.omid.library.vungle.walking.p055a.C2921d;
import com.vungle.warren.BuildConfig;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OMTracker implements WebViewObserver {
    @VisibleForTesting
    public static final long DESTROY_DELAY_MS = TimeUnit.SECONDS.toMillis(1);
    public AdSession adSession;
    public final boolean enabled;
    public boolean started;

    public static class Factory {
        public OMTracker make(boolean z) {
            return new OMTracker(z);
        }
    }

    public void onPageFinished(@NonNull WebView webView) {
        if (this.started && this.adSession == null) {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
            Owner owner = Owner.JAVASCRIPT;
            zzam.m25a((Object) creativeType, "CreativeType is null");
            zzam.m25a((Object) impressionType, "ImpressionType is null");
            zzam.m25a((Object) owner, "Impression owner is null");
            AdSessionConfiguration adSessionConfiguration = new AdSessionConfiguration(creativeType, impressionType, owner, owner, false);
            if (TextUtils.isEmpty(BuildConfig.OMSDK_PARTNER_NAME)) {
                throw new IllegalArgumentException("Name is null or empty");
            } else if (!TextUtils.isEmpty(BuildConfig.VERSION_NAME)) {
                Partner partner = new Partner(BuildConfig.OMSDK_PARTNER_NAME, BuildConfig.VERSION_NAME);
                zzam.m25a((Object) partner, "Partner is null");
                zzam.m25a((Object) webView, "WebView is null");
                AdSessionContext adSessionContext = new AdSessionContext(partner, webView, (String) null, (List<VerificationScriptResource>) null, (String) null, (String) null, AdSessionContextType.HTML);
                if (Omid.INSTANCE.f3500a) {
                    zzam.m25a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
                    zzam.m25a((Object) adSessionContext, "AdSessionContext is null");
                    C2889a aVar = new C2889a(adSessionConfiguration, adSessionContext);
                    this.adSession = aVar;
                    C2889a aVar2 = aVar;
                    if (!aVar2.f3498h) {
                        zzam.m25a((Object) webView, "AdView is null");
                        if (aVar2.mo36836d() != webView) {
                            aVar2.f3495e = new C2905a(webView);
                            AdSessionStatePublisher adSessionStatePublisher = aVar2.f3496f;
                            if (adSessionStatePublisher != null) {
                                adSessionStatePublisher.f3528e = System.nanoTime();
                                adSessionStatePublisher.f3527d = AdSessionStatePublisher.C2907a.AD_STATE_IDLE;
                                Collection<C2889a> b = C2891a.f3501a.mo36837b();
                                if (b != null && !b.isEmpty()) {
                                    for (C2889a next : b) {
                                        if (next != aVar2 && next.mo36836d() == webView) {
                                            next.f3495e.clear();
                                        }
                                    }
                                }
                            } else {
                                throw null;
                            }
                        }
                    }
                    C2889a aVar3 = (C2889a) this.adSession;
                    if (!aVar3.f3497g) {
                        aVar3.f3497g = true;
                        C2891a aVar4 = C2891a.f3501a;
                        boolean d = aVar4.mo36839d();
                        aVar4.f3503c.add(aVar3);
                        if (!d) {
                            C2898f a = C2898f.m3490a();
                            if (a != null) {
                                C2892b bVar = C2892b.f3504a;
                                bVar.f3507d = a;
                                bVar.f3505b = true;
                                bVar.f3506c = false;
                                bVar.mo36841e();
                                TreeWalker.f3539a.mo36860a();
                                C2887d dVar = a.f3517e;
                                dVar.f3492e = dVar.mo36829c();
                                dVar.mo36830d();
                                dVar.f3488a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, dVar);
                            } else {
                                throw null;
                            }
                        }
                        aVar3.f3496f.mo36854a(C2898f.m3490a().f3514b);
                        aVar3.f3496f.mo36855a(aVar3, aVar3.f3493b);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Method called before OM SDK activation");
            } else {
                throw new IllegalArgumentException("Version is null or empty");
            }
        }
    }

    public void start() {
        if (this.enabled && Omid.INSTANCE.f3500a) {
            this.started = true;
        }
    }

    public long stop() {
        long j;
        AdSession adSession2;
        if (!this.started || (adSession2 = this.adSession) == null) {
            j = 0;
        } else {
            C2889a aVar = (C2889a) adSession2;
            if (!aVar.f3498h) {
                aVar.f3495e.clear();
                if (!aVar.f3498h) {
                    aVar.f3494d.clear();
                }
                aVar.f3498h = true;
                C2896e.f3510a.mo36849a(aVar.f3496f.getWebView(), "finishSession", new Object[0]);
                C2891a aVar2 = C2891a.f3501a;
                boolean d = aVar2.mo36839d();
                aVar2.f3502b.remove(aVar);
                aVar2.f3503c.remove(aVar);
                if (d && !aVar2.mo36839d()) {
                    C2898f a = C2898f.m3490a();
                    if (a != null) {
                        TreeWalker treeWalker = TreeWalker.f3539a;
                        if (treeWalker != null) {
                            Handler handler = TreeWalker.f3541c;
                            if (handler != null) {
                                handler.removeCallbacks(TreeWalker.f3543k);
                                TreeWalker.f3541c = null;
                            }
                            treeWalker.f3544d.clear();
                            TreeWalker.f3540b.post(new Runnable() {
                                public void run() {
                                    C2924b bVar = TreeWalker.this.f3548h;
                                    bVar.f3571b.mo36870b(new C2921d(bVar));
                                }
                            });
                            C2892b bVar = C2892b.f3504a;
                            bVar.f3505b = false;
                            bVar.f3506c = false;
                            bVar.f3507d = null;
                            C2887d dVar = a.f3517e;
                            dVar.f3488a.getContentResolver().unregisterContentObserver(dVar);
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                }
                aVar.f3496f.mo36857b();
                aVar.f3496f = null;
            }
            j = DESTROY_DELAY_MS;
        }
        this.started = false;
        this.adSession = null;
        return j;
    }

    public OMTracker(boolean z) {
        this.enabled = z;
    }
}
