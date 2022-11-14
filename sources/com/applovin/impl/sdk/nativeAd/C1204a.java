package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1247r;
import com.applovin.impl.sdk.p028d.C1102e;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.File;
import java.util.Collections;

/* renamed from: com.applovin.impl.sdk.nativeAd.a */
public class C1204a extends C1109a {

    /* renamed from: a */
    public final C1247r f2246a;

    /* renamed from: c */
    public final C1102e f2247c = new C1102e();

    /* renamed from: d */
    public final AppLovinNativeAdImpl f2248d;

    /* renamed from: e */
    public final C1205a f2249e;

    /* renamed from: com.applovin.impl.sdk.nativeAd.a$a */
    public interface C1205a {
        /* renamed from: a */
        void mo11083a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public C1204a(AppLovinNativeAdImpl appLovinNativeAdImpl, C1188m mVar, C1205a aVar) {
        super("TaskCacheNativeAd", mVar);
        this.f2248d = appLovinNativeAdImpl;
        this.f2249e = aVar;
        this.f2246a = mVar.mo10963aa();
    }

    @Nullable
    /* renamed from: a */
    private Uri m2179a(Uri uri) {
        String str;
        if (uri == null) {
            return null;
        }
        mo10768a("Attempting to cache resource: " + uri);
        String a = this.f2246a.mo11241a(mo10775f(), uri.toString(), (String) null, Collections.emptyList(), false, this.f2247c);
        String cachePrefix = this.f2248d.getCachePrefix();
        if (StringUtils.isValidString(cachePrefix)) {
            a = GeneratedOutlineSupport.outline16(cachePrefix, a);
        }
        if (StringUtils.isValidString(a)) {
            File a2 = this.f2246a.mo11240a(a, mo10775f());
            if (a2 != null) {
                Uri fromFile = Uri.fromFile(a2);
                if (fromFile != null) {
                    return fromFile;
                }
                str = "Unable to extract Uri from image file";
            } else {
                str = GeneratedOutlineSupport.outline16("Unable to retrieve File from cached image filename = ", a);
            }
            mo10773d(str);
        }
        return null;
    }

    public void run() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Begin caching ad #");
        outline24.append(this.f2248d.getAdIdNumber());
        outline24.append("...");
        mo10768a(outline24.toString());
        Uri a = m2179a(this.f2248d.getIconUri());
        if (a != null) {
            this.f2248d.setIconUri(a);
        }
        Uri a2 = m2179a(this.f2248d.getMainImageUri());
        if (a2 != null) {
            this.f2248d.setMainImageUri(a2);
        }
        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Finished caching ad #");
        outline242.append(this.f2248d.getAdIdNumber());
        mo10768a(outline242.toString());
        this.f2249e.mo11083a(this.f2248d);
    }
}
