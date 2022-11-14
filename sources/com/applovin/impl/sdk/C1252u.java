package com.applovin.impl.sdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1263g;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.u */
public class C1252u {

    /* renamed from: a */
    public final C1188m f2423a;

    /* renamed from: b */
    public final LocationManager f2424b;

    /* renamed from: c */
    public C1251t f2425c;

    public C1252u(C1188m mVar) {
        this.f2423a = mVar;
        this.f2424b = (LocationManager) mVar.mo10932L().getSystemService(FirebaseAnalytics.Param.LOCATION);
    }

    @SuppressLint({"MissingPermission"})
    @Nullable
    /* renamed from: a */
    private Location m2474a(String str, String str2) {
        StringBuilder sb;
        C1314v vVar;
        String str3;
        if (!C1263g.m2505a(str2, this.f2423a.mo10932L())) {
            return null;
        }
        try {
            return this.f2424b.getLastKnownLocation(str);
        } catch (SecurityException e) {
            th = e;
            vVar = this.f2423a.mo10922B();
            sb = GeneratedOutlineSupport.outline26("Failed to retrieve location from ", str);
            str3 = ": access denied.";
            sb.append(str3);
            vVar.mo11373b("LocationManager", sb.toString(), th);
            return null;
        } catch (IllegalArgumentException e2) {
            th = e2;
            vVar = this.f2423a.mo10922B();
            sb = GeneratedOutlineSupport.outline26("Failed to retrieve location from ", str);
            str3 = ": device does not support this location provider.";
            sb.append(str3);
            vVar.mo11373b("LocationManager", sb.toString(), th);
            return null;
        } catch (NullPointerException e3) {
            th = e3;
            vVar = this.f2423a.mo10922B();
            sb = GeneratedOutlineSupport.outline26("Failed to retrieve location from ", str);
            str3 = ": location provider is not available.";
            sb.append(str3);
            vVar.mo11373b("LocationManager", sb.toString(), th);
            return null;
        } catch (Throwable th) {
            th = th;
            vVar = this.f2423a.mo10922B();
            sb = GeneratedOutlineSupport.outline26("Failed to retrieve location from ", str);
            str3 = CodelessMatcher.CURRENT_CLASS_NAME;
            sb.append(str3);
            vVar.mo11373b("LocationManager", sb.toString(), th);
            return null;
        }
    }

    /* renamed from: a */
    public boolean mo11259a() {
        return C1263g.m2505a("android.permission.ACCESS_COARSE_LOCATION", this.f2423a.mo10932L());
    }

    /* renamed from: b */
    public boolean mo11260b() {
        return C1263g.m2511g() ? this.f2424b.isLocationEnabled() : !C1263g.m2507c() || Settings.Secure.getInt(this.f2423a.mo10932L().getContentResolver(), "location_mode", 0) != 0;
    }

    @Nullable
    /* renamed from: c */
    public C1251t mo11261c() {
        if (!this.f2423a.mo10999p().isLocationCollectionEnabled() || !((Boolean) this.f2423a.mo10946a(C1085b.f1725dZ)).booleanValue()) {
            return null;
        }
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f2423a.mo10946a(C1085b.f1778ea)).longValue());
        if (this.f2425c != null && System.currentTimeMillis() - this.f2425c.mo11258c() < millis) {
            return this.f2425c;
        }
        Location a = m2474a("gps", "android.permission.ACCESS_FINE_LOCATION");
        if (a == null) {
            a = m2474a("network", "android.permission.ACCESS_COARSE_LOCATION");
        }
        if (a != null) {
            this.f2425c = new C1251t(a.getLatitude(), a.getLongitude(), System.currentTimeMillis());
        }
        return this.f2425c;
    }
}
