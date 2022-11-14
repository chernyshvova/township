package com.applovin.impl.p007a;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.utils.C1310q;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.VideoUploader;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.j */
public class C0645j {

    /* renamed from: a */
    public String f140a;

    /* renamed from: b */
    public String f141b;

    /* renamed from: c */
    public String f142c;

    /* renamed from: d */
    public long f143d = -1;

    /* renamed from: e */
    public int f144e = -1;

    /* renamed from: a */
    public static int m137a(String str, C0639e eVar) {
        if (VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE.equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if (!"complete".equalsIgnoreCase(str)) {
            return -1;
        }
        if (eVar != null) {
            return eVar.mo9370h();
        }
        return 95;
    }

    /* renamed from: a */
    public static C0645j m138a(C1310q qVar, C0639e eVar, C1188m mVar) {
        List<String> explode;
        int size;
        TimeUnit timeUnit;
        long seconds;
        if (qVar == null) {
            throw new IllegalArgumentException("No node specified.");
        } else if (mVar != null) {
            try {
                String c = qVar.mo11353c();
                if (StringUtils.isValidString(c)) {
                    C0645j jVar = new C0645j();
                    jVar.f142c = c;
                    jVar.f140a = qVar.mo11351b().get("id");
                    jVar.f141b = qVar.mo11351b().get("event");
                    jVar.f144e = m137a(jVar.mo9389a(), eVar);
                    String str = qVar.mo11351b().get("offset");
                    if (StringUtils.isValidString(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            jVar.f144e = StringUtils.parseInt(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(CertificateUtil.DELIMITER) && (size = explode.size()) > 0) {
                            long j = 0;
                            int i = size - 1;
                            for (int i2 = i; i2 >= 0; i2--) {
                                String str2 = (explode = CollectionUtils.explode(trim, CertificateUtil.DELIMITER)).get(i2);
                                if (StringUtils.isNumeric(str2)) {
                                    int parseInt = Integer.parseInt(str2);
                                    if (i2 == i) {
                                        seconds = (long) parseInt;
                                    } else {
                                        if (i2 == size - 2) {
                                            timeUnit = TimeUnit.MINUTES;
                                        } else if (i2 == size - 3) {
                                            timeUnit = TimeUnit.HOURS;
                                        }
                                        seconds = timeUnit.toSeconds((long) parseInt);
                                    }
                                    j += seconds;
                                }
                            }
                            jVar.f143d = j;
                            jVar.f144e = -1;
                        }
                    }
                    return jVar;
                }
                mVar.mo10922B().mo11376e("VastTracker", "Unable to create tracker. Could not find URL.");
                return null;
            } catch (Throwable th) {
                mVar.mo10922B().mo11373b("VastTracker", "Error occurred while initializing", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* renamed from: a */
    public String mo9389a() {
        return this.f141b;
    }

    /* renamed from: a */
    public boolean mo9390a(long j, int i) {
        boolean z = this.f143d >= 0;
        boolean z2 = j >= this.f143d;
        boolean z3 = this.f144e >= 0;
        boolean z4 = i >= this.f144e;
        if (!z || !z2) {
            return z3 && z4;
        }
        return true;
    }

    /* renamed from: b */
    public String mo9391b() {
        return this.f142c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0645j)) {
            return false;
        }
        C0645j jVar = (C0645j) obj;
        if (this.f143d != jVar.f143d || this.f144e != jVar.f144e) {
            return false;
        }
        String str = this.f140a;
        if (str == null ? jVar.f140a != null : !str.equals(jVar.f140a)) {
            return false;
        }
        String str2 = this.f141b;
        if (str2 == null ? jVar.f141b == null : str2.equals(jVar.f141b)) {
            return this.f142c.equals(jVar.f142c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f140a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f141b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int outline4 = GeneratedOutlineSupport.outline4(this.f142c, (hashCode + i) * 31, 31);
        long j = this.f143d;
        return ((outline4 + ((int) (j ^ (j >>> 32)))) * 31) + this.f144e;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("VastTracker{identifier='");
        GeneratedOutlineSupport.outline33(outline24, this.f140a, '\'', ", event='");
        GeneratedOutlineSupport.outline33(outline24, this.f141b, '\'', ", uriString='");
        GeneratedOutlineSupport.outline33(outline24, this.f142c, '\'', ", offsetSeconds=");
        outline24.append(this.f143d);
        outline24.append(", offsetPercent=");
        outline24.append(this.f144e);
        outline24.append('}');
        return outline24.toString();
    }
}
