package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.mediation.p010a.C0803c;
import com.applovin.impl.mediation.p010a.C0805e;
import com.applovin.impl.mediation.p010a.C0806f;
import com.applovin.impl.mediation.p010a.C0807g;
import com.applovin.impl.mediation.p010a.C0809h;
import com.applovin.impl.mediation.p011b.C0852d;
import com.applovin.impl.mediation.p011b.C0860f;
import com.applovin.impl.mediation.p011b.C0861g;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public final C1188m f562a;

    /* renamed from: b */
    public final C1314v f563b;

    /* renamed from: c */
    public final AtomicReference<JSONObject> f564c = new AtomicReference<>();

    /* renamed from: com.applovin.impl.mediation.MediationServiceImpl$a */
    public class C0797a implements C0836a.C0837a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

        /* renamed from: b */
        public final C0801a f586b;

        /* renamed from: c */
        public C0836a.C0837a f587c;

        public C0797a(C0801a aVar, C0836a.C0837a aVar2) {
            this.f586b = aVar;
            this.f587c = aVar2;
        }

        /* renamed from: a */
        public void mo9805a(C0836a.C0837a aVar) {
            this.f587c = aVar;
        }

        /* renamed from: a */
        public void mo9806a(MaxAd maxAd, @Nullable Bundle bundle) {
            this.f586b.mo9855s();
            this.f586b.mo9826a(bundle);
            MediationServiceImpl.this.m644b(this.f586b);
            C1267j.m2546a((MaxAdListener) this.f587c, maxAd);
        }

        /* renamed from: b */
        public void mo9807b(MaxAd maxAd, @Nullable Bundle bundle) {
            MediationServiceImpl.this.f563b.mo11372b("MediationService", "Scheduling impression for ad via callback...");
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f586b, this.f587c);
            this.f586b.mo9826a(bundle);
            MediationServiceImpl.this.f562a.mo10969ag().mo10895a(this.f586b, "DID_DISPLAY");
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f562a.mo10966ad().mo11248a((Object) maxAd);
                MediationServiceImpl.this.f562a.mo10974al().mo11017a((Object) maxAd);
            }
            C1267j.m2570b((MaxAdListener) this.f587c, maxAd);
        }

        public void onAdClicked(MaxAd maxAd) {
            MediationServiceImpl.this.m633a(this.f586b, this.f587c);
            C1267j.m2578d(this.f587c, maxAd);
        }

        public void onAdCollapsed(MaxAd maxAd) {
            C1267j.m2586h(this.f587c, maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            MediationServiceImpl.this.m645b(this.f586b, maxError, this.f587c);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof C0803c)) {
                ((C0803c) maxAd).mo9872F();
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            mo9807b(maxAd, (Bundle) null);
        }

        public void onAdExpanded(MaxAd maxAd) {
            C1267j.m2584g(this.f587c, maxAd);
        }

        public void onAdHidden(final MaxAd maxAd) {
            MediationServiceImpl.this.f562a.mo10969ag().mo10895a((C0801a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (maxAd.getFormat().isFullscreenAd()) {
                        MediationServiceImpl.this.f562a.mo10966ad().mo11251b((Object) maxAd);
                        MediationServiceImpl.this.f562a.mo10974al().mo11016a();
                    }
                    C1267j.m2575c(C0797a.this.f587c, maxAd);
                }
            }, maxAd instanceof C0803c ? ((C0803c) maxAd).mo9868B() : 0);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f586b.mo9855s();
            MediationServiceImpl.this.m634a(this.f586b, maxError, (MaxAdListener) this.f587c);
        }

        public void onAdLoaded(MaxAd maxAd) {
            mo9806a(maxAd, (Bundle) null);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            C1267j.m2582f(this.f587c, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            C1267j.m2580e(this.f587c, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            C1267j.m2549a((MaxAdListener) this.f587c, maxAd, maxReward);
            MediationServiceImpl.this.f562a.mo10938S().mo10829a((C1109a) new C0860f((C0803c) maxAd, MediationServiceImpl.this.f562a), C1140o.C1142a.MEDIATION_REWARD);
        }
    }

    public MediationServiceImpl(C1188m mVar) {
        this.f562a = mVar;
        this.f563b = mVar.mo10922B();
        mVar.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    /* renamed from: a */
    private C0951g m624a(C0803c cVar) {
        C0951g g = cVar.mo9834g();
        if (g != null) {
            return g;
        }
        this.f562a.mo10966ad().mo11249a(false);
        C1314v vVar = this.f563b;
        vVar.mo11375d("MediationService", "Failed to show " + cVar + ": adapter not found");
        C1314v.m2663i("MediationService", "There may be an integration problem with the adapter for ad unit id '" + cVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* renamed from: a */
    private void m632a(C0801a aVar) {
        m638a("mpreload", (C0806f) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m633a(C0801a aVar, C0836a.C0837a aVar2) {
        this.f562a.mo10969ag().mo10895a(aVar, "DID_CLICKED");
        this.f562a.mo10969ag().mo10895a(aVar, "DID_CLICK");
        if (aVar.mo9831d().endsWith("click")) {
            this.f562a.mo10969ag().mo10894a(aVar);
            C1267j.m2554a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        m638a("mclick", (C0806f) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m634a(C0801a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        m637a(maxError, aVar);
        destroyAd(aVar);
        C1267j.m2552a(maxAdListener, aVar.getAdUnitId(), maxError);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m635a(C0803c cVar, C0836a.C0837a aVar) {
        this.f562a.mo10966ad().mo11249a(false);
        m636a(cVar, (MaxAdListener) aVar);
        this.f563b.mo11372b("MediationService", "Scheduling impression for ad manually...");
        processRawAdImpressionPostback(cVar, aVar);
    }

    /* renamed from: a */
    private void m636a(C0803c cVar, MaxAdListener maxAdListener) {
        long longValue = ((Long) this.f562a.mo10946a(C1084a.f1499J)).longValue();
        if (longValue > 0) {
            final C0803c cVar2 = cVar;
            final long j = longValue;
            final MaxAdListener maxAdListener2 = maxAdListener;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (!cVar2.mo9856t().get()) {
                        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ad (");
                        outline24.append(cVar2.mo9899Q());
                        outline24.append(") has not been displayed after ");
                        outline24.append(j);
                        outline24.append("ms. Failing ad display...");
                        String sb = outline24.toString();
                        C1314v.m2663i("MediationService", sb);
                        MediationServiceImpl.this.m645b(cVar2, new MaxErrorImpl(-1, sb), maxAdListener2);
                        MediationServiceImpl.this.f562a.mo10966ad().mo11251b((Object) cVar2);
                        MediationServiceImpl.this.f562a.mo10974al().mo11016a();
                    }
                }
            }, longValue);
        }
    }

    /* renamed from: a */
    private void m637a(MaxError maxError, C0801a aVar) {
        long p = aVar.mo9852p();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(p));
        m641a("mlerr", (Map<String, String>) hashMap, maxError, (C0806f) aVar);
    }

    /* renamed from: a */
    private void m638a(String str, C0806f fVar) {
        m641a(str, (Map<String, String>) Collections.EMPTY_MAP, (MaxError) null, fVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m639a(String str, C0809h hVar, C0951g gVar) {
        HashMap hashMap = new HashMap(2);
        Utils.putObjectForStringIfValid("{ADAPTER_VERSION}", gVar.mo10259i(), hashMap);
        Utils.putObjectForStringIfValid("{SDK_VERSION}", gVar.mo10258h(), hashMap);
        m641a("serr", (Map<String, String>) hashMap, (MaxError) new MaxErrorImpl(str), (C0806f) hVar);
    }

    /* renamed from: a */
    private void m640a(String str, Map<String, String> map, C0806f fVar) {
        m641a(str, map, (MaxError) null, fVar);
    }

    /* renamed from: a */
    private void m641a(String str, Map<String, String> map, MaxError maxError, C0806f fVar) {
        HashMap hashMap = new HashMap(map);
        hashMap.put(Utils.PLACEMENT_MACRO, StringUtils.emptyIfNull(fVar.getPlacement()));
        hashMap.put("{CUSTOM_DATA}", StringUtils.emptyIfNull(fVar.mo9918ab()));
        if (fVar instanceof C0801a) {
            hashMap.put("{CREATIVE_ID}", StringUtils.emptyIfNull(((C0801a) fVar).getCreativeId()));
        }
        this.f562a.mo10938S().mo10829a((C1109a) new C0852d(str, hashMap, maxError, fVar, this.f562a), C1140o.C1142a.MEDIATION_POSTBACKS);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m644b(C0801a aVar) {
        this.f562a.mo10969ag().mo10895a(aVar, "DID_LOAD");
        if (aVar.mo9831d().endsWith("load")) {
            this.f562a.mo10969ag().mo10894a(aVar);
        }
        long p = aVar.mo9852p();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(p));
        m640a("load", (Map<String, String>) hashMap, (C0806f) aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m645b(C0801a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        this.f562a.mo10969ag().mo10895a(aVar, "DID_FAIL_DISPLAY");
        processAdDisplayErrorPostback(maxError, aVar);
        if (aVar.mo9856t().compareAndSet(false, true)) {
            C1267j.m2547a(maxAdListener, (MaxAd) aVar, maxError);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m646b(C0803c cVar) {
        if (cVar.getFormat() == MaxAdFormat.REWARDED || cVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            this.f562a.mo10938S().mo10829a((C1109a) new C0861g(cVar, this.f562a), C1140o.C1142a.MEDIATION_REWARD);
        }
    }

    public void collectSignal(MaxAdFormat maxAdFormat, final C0809h hVar, Context context, final C0807g.C0808a aVar) {
        String str;
        C1314v vVar;
        String str2;
        StringBuilder sb;
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar != null) {
            final C0951g a = this.f562a.mo10923C().mo10235a((C0806f) hVar);
            if (a != null) {
                Activity ao = context instanceof Activity ? (Activity) context : this.f562a.mo10977ao();
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m623a(hVar, maxAdFormat);
                if (((Boolean) this.f562a.mo10946a(C1084a.f1513X)).booleanValue()) {
                    this.f562a.mo10924D().mo10228a((C0806f) hVar, ao);
                }
                C07953 r1 = new MaxSignalCollectionListener() {
                    public void onSignalCollected(String str) {
                        aVar.mo9940a(C0807g.m760a(hVar, a, str));
                        a.mo10260j();
                    }

                    public void onSignalCollectionFailed(String str) {
                        MediationServiceImpl.this.m639a(str, hVar, a);
                        aVar.mo9940a(C0807g.m762b(hVar, a, str));
                        a.mo10260j();
                    }
                };
                if (!hVar.mo9825a()) {
                    vVar = this.f563b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for adapter: ";
                } else if (this.f562a.mo10924D().mo10231a((C0806f) hVar)) {
                    vVar = this.f563b;
                    sb = new StringBuilder();
                    str2 = "Collecting signal for now-initialized adapter: ";
                } else {
                    C1314v vVar2 = this.f563b;
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Skip collecting signal for not-initialized adapter: ");
                    outline24.append(a.mo10254d());
                    vVar2.mo11376e("MediationService", outline24.toString());
                    str = "Adapter not initialized yet";
                }
                sb.append(str2);
                sb.append(a.mo10254d());
                vVar.mo11372b("MediationService", sb.toString());
                a.mo10248a((MaxAdapterSignalCollectionParameters) a2, hVar, ao, (MaxSignalCollectionListener) r1);
                return;
            }
            str = "Could not load adapter";
            aVar.mo9940a(C0807g.m761a(hVar, str));
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof C0801a) {
            C1314v vVar = this.f563b;
            vVar.mo11374c("MediationService", "Destroying " + maxAd);
            C0801a aVar = (C0801a) maxAd;
            C0951g g = aVar.mo9834g();
            if (g != null) {
                g.mo10260j();
                aVar.mo9858u();
            }
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return this.f564c.getAndSet((Object) null);
    }

    public void loadAd(String str, @Nullable String str2, MaxAdFormat maxAdFormat, Map<String, Object> map, C1231i iVar, Context context, C0836a.C0837a aVar) {
        String str3 = str;
        C0836a.C0837a aVar2 = aVar;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar2 != null) {
            if (TextUtils.isEmpty(this.f562a.mo11003t())) {
                C1314v.m2663i(AppLovinSdk.TAG, "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
            }
            if (!this.f562a.mo10987d()) {
                C1314v.m2662h(AppLovinSdk.TAG, "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
            }
            this.f562a.mo10949a();
            if (str.length() != 16 && !str.startsWith("test_mode") && !this.f562a.mo11010z().startsWith("05TMD")) {
                StringBuilder outline27 = GeneratedOutlineSupport.outline27("Please double-check the ad unit ", str, " for ");
                outline27.append(maxAdFormat.getLabel());
                outline27.append(" : ");
                outline27.append(Log.getStackTraceString(new Throwable("")));
                C1314v.m2663i("MediationService", outline27.toString());
            }
            MaxAdFormat maxAdFormat2 = maxAdFormat;
            if (this.f562a.mo10962a(maxAdFormat)) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Ad load failed due to disabled ad format ");
                outline24.append(maxAdFormat.getLabel());
                C1314v.m2663i("MediationService", outline24.toString());
                StringBuilder outline242 = GeneratedOutlineSupport.outline24("Disabled ad format ");
                outline242.append(maxAdFormat.getLabel());
                C1267j.m2552a((MaxAdListener) aVar2, str, (MaxError) new MaxErrorImpl(-1, outline242.toString()));
                return;
            }
            this.f562a.mo10929I().mo10031a(str, str2, maxAdFormat, map, iVar, context, aVar);
        } else {
            throw new IllegalArgumentException("No listener specified");
        }
    }

    public void loadThirdPartyMediatedAd(String str, C0801a aVar, Activity activity, C0836a.C0837a aVar2) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        } else if (activity != null) {
            this.f563b.mo11372b("MediationService", "Loading " + aVar + "...");
            this.f562a.mo10969ag().mo10895a(aVar, "WILL_LOAD");
            m632a(aVar);
            C0951g a = this.f562a.mo10923C().mo10235a((C0806f) aVar);
            if (a != null) {
                MaxAdapterParametersImpl a2 = MaxAdapterParametersImpl.m621a(aVar);
                if (((Boolean) this.f562a.mo10946a(C1084a.f1514Y)).booleanValue()) {
                    this.f562a.mo10924D().mo10228a((C0806f) aVar, activity);
                }
                C0801a a3 = aVar.mo9824a(a);
                a.mo10250a(str, a3);
                a3.mo9853q();
                a.mo10251a(str, a2, a3, activity, new C0797a(a3, aVar2));
                return;
            }
            String str2 = "Failed to load " + aVar + ": adapter not loaded";
            C1314v.m2663i("MediationService", str2);
            m634a(aVar, (MaxError) new MaxErrorImpl(-5001, str2), (MaxAdListener) aVar2);
        } else {
            throw new IllegalArgumentException("A valid Activity is required");
        }
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object c = this.f562a.mo10966ad().mo11253c();
            if (c instanceof C0801a) {
                processAdDisplayErrorPostback(MaxAdapterError.WEBVIEW_ERROR, (C0801a) c);
            }
        }
    }

    public void processAdDisplayErrorPostback(MaxError maxError, C0801a aVar) {
        m641a("mierr", (Map<String, String>) Collections.EMPTY_MAP, maxError, (C0806f) aVar);
    }

    public void processAdLossPostback(C0801a aVar, @Nullable Float f) {
        String f2 = f != null ? f.toString() : "";
        HashMap hashMap = new HashMap(1);
        hashMap.put("{MBR}", f2);
        m640a("mloss", (Map<String, String>) hashMap, (C0806f) aVar);
    }

    public void processAdapterInitializationPostback(C0806f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j));
        m641a("minit", (Map<String, String>) hashMap, (MaxError) new MaxErrorImpl(str), fVar);
    }

    public void processCallbackAdImpressionPostback(C0801a aVar, C0836a.C0837a aVar2) {
        if (aVar.mo9831d().endsWith("cimp")) {
            this.f562a.mo10969ag().mo10894a(aVar);
            C1267j.m2554a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        m638a("mcimp", (C0806f) aVar);
    }

    public void processRawAdImpressionPostback(C0801a aVar, C0836a.C0837a aVar2) {
        this.f562a.mo10969ag().mo10895a(aVar, "WILL_DISPLAY");
        if (aVar.mo9831d().endsWith("mimp")) {
            this.f562a.mo10969ag().mo10894a(aVar);
            C1267j.m2554a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        HashMap hashMap = new HashMap(1);
        if (aVar instanceof C0803c) {
            hashMap.put("{TIME_TO_SHOW_MS}", String.valueOf(((C0803c) aVar).mo9883z()));
        }
        m640a("mimp", (Map<String, String>) hashMap, (C0806f) aVar);
    }

    public void processViewabilityAdImpressionPostback(C0805e eVar, long j, C0836a.C0837a aVar) {
        if (eVar.mo9831d().endsWith("vimp")) {
            this.f562a.mo10969ag().mo10894a((C0801a) eVar);
            C1267j.m2554a((MaxAdRevenueListener) aVar, (MaxAd) eVar);
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(eVar.mo9893H()));
        m640a("mvimp", (Map<String, String>) hashMap, (C0806f) eVar);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.f564c.set(jSONObject);
    }

    public void showFullscreenAd(C0803c cVar, Activity activity, C0836a.C0837a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            this.f562a.mo10966ad().mo11249a(true);
            final C0951g a = m624a(cVar);
            long A = cVar.mo9867A();
            C1314v vVar = this.f563b;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing ad ");
            outline24.append(cVar.getAdUnitId());
            outline24.append(" with delay of ");
            outline24.append(A);
            outline24.append("ms...");
            vVar.mo11374c("MediationService", outline24.toString());
            final C0803c cVar2 = cVar;
            final Activity activity2 = activity;
            final C0836a.C0837a aVar2 = aVar;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    MediationServiceImpl.this.m646b(cVar2);
                    a.mo10245a((C0801a) cVar2, activity2);
                    MediationServiceImpl.this.m635a(cVar2, aVar2);
                }
            }, A);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    public void showFullscreenAd(C0803c cVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, C0836a.C0837a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            this.f562a.mo10966ad().mo11249a(true);
            final C0951g a = m624a(cVar);
            long A = cVar.mo9867A();
            C1314v vVar = this.f563b;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Showing ad ");
            outline24.append(cVar.getAdUnitId());
            outline24.append(" with delay of ");
            outline24.append(A);
            outline24.append("ms...");
            vVar.mo11374c("MediationService", outline24.toString());
            final C0803c cVar2 = cVar;
            final ViewGroup viewGroup2 = viewGroup;
            final Lifecycle lifecycle2 = lifecycle;
            final Activity activity2 = activity;
            final C0836a.C0837a aVar2 = aVar;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    MediationServiceImpl.this.m646b(cVar2);
                    a.mo10246a((C0801a) cVar2, viewGroup2, lifecycle2, activity2);
                    MediationServiceImpl.this.m635a(cVar2, aVar2);
                }
            }, A);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }
}
