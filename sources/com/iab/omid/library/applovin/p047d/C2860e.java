package com.iab.omid.library.applovin.p047d;

import android.text.TextUtils;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

/* renamed from: com.iab.omid.library.applovin.d.e */
public class C2860e {
    /* renamed from: a */
    public static void m3376a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m3377a(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    /* renamed from: a */
    public static void m3378a(C2839a aVar) {
        if (aVar.mo36680g()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public static void m3379a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m3380a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m3381a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m3382b(C2839a aVar) {
        if (aVar.mo36681h()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m3383c(C2839a aVar) {
        m3388h(aVar);
        m3382b(aVar);
    }

    /* renamed from: d */
    public static void m3384d(C2839a aVar) {
        if (aVar.getAdSessionStatePublisher().mo36777c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: e */
    public static void m3385e(C2839a aVar) {
        if (aVar.getAdSessionStatePublisher().mo36778d() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    /* renamed from: f */
    public static void m3386f(C2839a aVar) {
        if (!aVar.mo36682i()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: g */
    public static void m3387g(C2839a aVar) {
        if (!aVar.mo36683j()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    /* renamed from: h */
    public static void m3388h(C2839a aVar) {
        if (!aVar.mo36680g()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
