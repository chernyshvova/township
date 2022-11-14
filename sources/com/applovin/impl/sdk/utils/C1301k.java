package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.p010a.C0801a;
import com.applovin.impl.p007a.C0631a;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vungle.warren.model.Placement;

/* renamed from: com.applovin.impl.sdk.utils.k */
public class C1301k {

    /* renamed from: a */
    public final StringBuilder f2536a = new StringBuilder();

    /* renamed from: a */
    public C1301k mo11316a() {
        this.f2536a.append("\n========================================");
        return this;
    }

    /* renamed from: a */
    public C1301k mo11317a(Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        for (String str : bundle.keySet()) {
            mo11323a(str, bundle.get(str));
        }
        return this;
    }

    /* renamed from: a */
    public C1301k mo11318a(AppLovinAdView appLovinAdView) {
        return mo11323a("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).mo11323a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).mo11323a("Visibility", C1307p.m2633b(appLovinAdView.getVisibility()));
    }

    /* renamed from: a */
    public C1301k mo11319a(C0801a aVar) {
        return mo11323a("Network", aVar.mo9899Q()).mo11323a("Format", aVar.getFormat().getLabel()).mo11323a("Ad Unit ID", aVar.getAdUnitId()).mo11323a(Placement.TAG, aVar.getPlacement()).mo11323a("Network Placement", aVar.mo9849m()).mo11323a("Serve ID", aVar.mo9833f()).mo11323a("Creative ID", StringUtils.isValidString(aVar.getCreativeId()) ? aVar.getCreativeId() : "None").mo11323a("Server Parameters", aVar.mo9906X());
    }

    /* renamed from: a */
    public C1301k mo11320a(C1057e eVar) {
        boolean z = eVar instanceof C0631a;
        mo11323a("Format", eVar.getAdZone().mo10549b() != null ? eVar.getAdZone().mo10549b().getLabel() : null).mo11323a("Ad ID", Long.valueOf(eVar.getAdIdNumber())).mo11323a("Zone ID", eVar.getAdZone().mo10548a()).mo11323a("Source", eVar.getSource()).mo11323a("Ad Class", z ? "VastAd" : "AdServerAd");
        String dspName = eVar.getDspName();
        if (StringUtils.isValidString(dspName)) {
            mo11323a("DSP Name", dspName);
        }
        if (z) {
            mo11323a("VAST DSP", ((C0631a) eVar).mo9328l());
        }
        return this;
    }

    /* renamed from: a */
    public C1301k mo11321a(C1188m mVar) {
        return mo11323a("Muted", Boolean.valueOf(mVar.mo10999p().isMuted())).mo11323a("ExoPlayer", Boolean.valueOf(Utils.checkExoPlayerEligibility(mVar)));
    }

    /* renamed from: a */
    public C1301k mo11322a(String str) {
        StringBuilder sb = this.f2536a;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    /* renamed from: a */
    public C1301k mo11323a(String str, Object obj) {
        return mo11324a(str, obj, "");
    }

    /* renamed from: a */
    public C1301k mo11324a(String str, Object obj, String str2) {
        StringBuilder sb = this.f2536a;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    /* renamed from: b */
    public C1301k mo11325b(C1057e eVar) {
        mo11323a("Target", eVar.mo10624n()).mo11323a("close_style", eVar.mo10629s()).mo11324a("close_delay_graphic", Long.valueOf(eVar.mo10627q()), AnalyticsEventKey.SEARCH_QUERY);
        if (eVar instanceof C1052a) {
            C1052a aVar = (C1052a) eVar;
            mo11323a("HTML", aVar.mo9311b().substring(0, Math.min(aVar.mo9311b().length(), 64)));
        }
        if (eVar.hasVideoUrl()) {
            mo11324a("close_delay", Long.valueOf(eVar.mo10625o()), AnalyticsEventKey.SEARCH_QUERY).mo11323a("skip_style", eVar.mo10631u()).mo11323a("Streaming", Boolean.valueOf(eVar.mo9314e())).mo11323a("Video Location", eVar.mo9312c()).mo11323a("video_button_properties", eVar.mo10556A());
        }
        return this;
    }

    /* renamed from: b */
    public C1301k mo11326b(String str) {
        this.f2536a.append(str);
        return this;
    }

    public String toString() {
        return this.f2536a.toString();
    }
}
