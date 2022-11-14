package com.applovin.impl.p007a;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p025ad.C1053b;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.a.e */
public class C0639e {

    /* renamed from: c */
    public static final List<String> f103c = Arrays.asList(new String[]{"video/mp4", "video/webm", "video/3gpp", "video/x-matroska"});

    /* renamed from: a */
    public List<C1310q> f104a = new ArrayList();

    /* renamed from: b */
    public final C1188m f105b;

    /* renamed from: d */
    public final JSONObject f106d;

    /* renamed from: e */
    public final JSONObject f107e;

    /* renamed from: f */
    public final C1053b f108f;

    /* renamed from: g */
    public final long f109g = System.currentTimeMillis();

    public C0639e(JSONObject jSONObject, JSONObject jSONObject2, C1053b bVar, C1188m mVar) {
        this.f105b = mVar;
        this.f106d = jSONObject;
        this.f107e = jSONObject2;
        this.f108f = bVar;
    }

    /* renamed from: a */
    public int mo9363a() {
        return this.f104a.size();
    }

    /* renamed from: b */
    public List<C1310q> mo9364b() {
        return this.f104a;
    }

    /* renamed from: c */
    public JSONObject mo9365c() {
        return this.f106d;
    }

    /* renamed from: d */
    public JSONObject mo9366d() {
        return this.f107e;
    }

    /* renamed from: e */
    public C1053b mo9367e() {
        return this.f108f;
    }

    /* renamed from: f */
    public long mo9368f() {
        return this.f109g;
    }

    /* renamed from: g */
    public List<String> mo9369g() {
        List<String> explode = CollectionUtils.explode(JsonUtils.getString(this.f106d, "vast_preferred_video_types", (String) null));
        return !explode.isEmpty() ? explode : f103c;
    }

    /* renamed from: h */
    public int mo9370h() {
        return Utils.getVideoCompletionPercent(this.f106d);
    }
}
