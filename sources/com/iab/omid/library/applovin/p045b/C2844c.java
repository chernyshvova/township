package com.iab.omid.library.applovin.p045b;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.applovin.p048e.C2862a;

/* renamed from: com.iab.omid.library.applovin.b.c */
public class C2844c {

    /* renamed from: a */
    public final C2862a f3400a;

    /* renamed from: b */
    public final String f3401b;

    /* renamed from: c */
    public final FriendlyObstructionPurpose f3402c;

    /* renamed from: d */
    public final String f3403d;

    public C2844c(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f3400a = new C2862a(view);
        this.f3401b = view.getClass().getCanonicalName();
        this.f3402c = friendlyObstructionPurpose;
        this.f3403d = str;
    }

    /* renamed from: a */
    public C2862a mo36728a() {
        return this.f3400a;
    }

    /* renamed from: b */
    public String mo36729b() {
        return this.f3401b;
    }

    /* renamed from: c */
    public FriendlyObstructionPurpose mo36730c() {
        return this.f3402c;
    }

    /* renamed from: d */
    public String mo36731d() {
        return this.f3403d;
    }
}
