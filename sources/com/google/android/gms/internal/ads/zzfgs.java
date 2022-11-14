package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgs extends zzfgo {
    public String zza;
    public Boolean zzb;
    public Boolean zzc;

    public final zzfgo zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    public final zzfgo zzb(boolean z) {
        this.zzb = Boolean.valueOf(z);
        return this;
    }

    public final zzfgo zzc(boolean z) {
        this.zzc = Boolean.TRUE;
        return this;
    }

    public final zzfgp zzd() {
        Boolean bool;
        String str = this.zza;
        if (str != null && (bool = this.zzb) != null && this.zzc != null) {
            return new zzfgt(str, bool.booleanValue(), this.zzc.booleanValue(), (zzfgr) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" clientVersion");
        }
        if (this.zzb == null) {
            sb.append(" shouldGetAdvertisingId");
        }
        if (this.zzc == null) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        String valueOf = String.valueOf(sb);
        throw new IllegalStateException(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 28), "Missing required properties:", valueOf));
    }
}
