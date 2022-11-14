package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1231i;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.p025ad.C1056d;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.e.j */
public class C1131j extends C1132k {

    /* renamed from: c */
    public final List<String> f1999c;

    public C1131j(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener, C1188m mVar) {
        super(C1056d.m1473a(m1892a(list)), (C1231i) null, appLovinAdLoadListener, "TaskFetchMultizoneAd", mVar);
        this.f1999c = Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    public static String m1892a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        throw new IllegalArgumentException("No zone identifiers specified");
    }

    /* renamed from: a */
    public Map<String, String> mo10806a() {
        HashMap hashMap = new HashMap(1);
        List<String> list = this.f1999c;
        hashMap.put("zone_ids", CollectionUtils.implode(list, list.size()));
        return hashMap;
    }

    /* renamed from: h */
    public C1053b mo10811h() {
        return C1053b.APPLOVIN_MULTIZONE;
    }
}
