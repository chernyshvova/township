package com.applovin.impl.sdk.p024a;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* renamed from: com.applovin.impl.sdk.a.d */
public class C1019d {

    /* renamed from: a */
    public final View f1320a;

    /* renamed from: b */
    public final FriendlyObstructionPurpose f1321b;

    /* renamed from: c */
    public final String f1322c;

    public C1019d(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f1320a = view;
        this.f1321b = friendlyObstructionPurpose;
        this.f1322c = str;
    }

    /* renamed from: a */
    public View mo10467a() {
        return this.f1320a;
    }

    /* renamed from: b */
    public FriendlyObstructionPurpose mo10468b() {
        return this.f1321b;
    }

    /* renamed from: c */
    public String mo10469c() {
        return this.f1322c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1019d.class != obj.getClass()) {
            return false;
        }
        C1019d dVar = (C1019d) obj;
        View view = this.f1320a;
        if (view == null ? dVar.f1320a != null : !view.equals(dVar.f1320a)) {
            return false;
        }
        if (this.f1321b != dVar.f1321b) {
            return false;
        }
        String str = this.f1322c;
        String str2 = dVar.f1322c;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        View view = this.f1320a;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.f1321b;
        int hashCode2 = (hashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.f1322c;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }
}
