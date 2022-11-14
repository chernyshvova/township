package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhn {
    public final Date zza;
    public final String zzb;
    public final List<String> zzc;
    public final int zzd;
    public final Set<String> zze;
    public final Location zzf;
    public final Bundle zzg;
    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzh;
    public final String zzi;
    public final String zzj;
    @NotOnlyInitialized
    @Nullable
    public final SearchAdRequest zzk;
    public final int zzl;
    public final Set<String> zzm;
    public final Bundle zzn;
    public final Set<String> zzo;
    public final boolean zzp;
    public final AdInfo zzq;
    public final String zzr;
    public final int zzs;

    public zzbhn(zzbhm zzbhm, @Nullable SearchAdRequest searchAdRequest) {
        this.zza = zzbhm.zzg;
        this.zzb = zzbhm.zzh;
        this.zzc = zzbhm.zzi;
        this.zzd = zzbhm.zzj;
        this.zze = Collections.unmodifiableSet(zzbhm.zza);
        this.zzf = zzbhm.zzk;
        this.zzg = zzbhm.zzb;
        this.zzh = Collections.unmodifiableMap(zzbhm.zzc);
        this.zzi = zzbhm.zzl;
        this.zzj = zzbhm.zzm;
        this.zzk = searchAdRequest;
        this.zzl = zzbhm.zzn;
        this.zzm = Collections.unmodifiableSet(zzbhm.zzd);
        this.zzn = zzbhm.zze;
        this.zzo = Collections.unmodifiableSet(zzbhm.zzf);
        this.zzp = zzbhm.zzo;
        this.zzq = zzbhm.zzp;
        this.zzr = zzbhm.zzq;
        this.zzs = zzbhm.zzr;
    }

    @Deprecated
    public final Date zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final List<String> zzc() {
        return new ArrayList(this.zzc);
    }

    @Deprecated
    public final int zzd() {
        return this.zzd;
    }

    public final Set<String> zze() {
        return this.zze;
    }

    public final Location zzf() {
        return this.zzf;
    }

    @Deprecated
    @Nullable
    public final <T extends NetworkExtras> T zzg(Class<T> cls) {
        return (NetworkExtras) this.zzh.get(cls);
    }

    @Nullable
    public final Bundle zzh(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzg.getBundle(cls.getName());
    }

    @Nullable
    public final Bundle zzi(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzg.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String zzj() {
        return this.zzi;
    }

    public final String zzk() {
        return this.zzj;
    }

    @Nullable
    public final SearchAdRequest zzl() {
        return this.zzk;
    }

    public final boolean zzm(Context context) {
        RequestConfiguration zzm2 = zzbhv.zza().zzm();
        zzbev.zza();
        String zzt = zzcgl.zzt(context);
        return this.zzm.contains(zzt) || zzm2.getTestDeviceIds().contains(zzt);
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzn() {
        return this.zzh;
    }

    public final Bundle zzo() {
        return this.zzg;
    }

    public final int zzp() {
        return this.zzl;
    }

    public final Bundle zzq() {
        return this.zzn;
    }

    public final Set<String> zzr() {
        return this.zzo;
    }

    @Deprecated
    public final boolean zzs() {
        return this.zzp;
    }

    @Nullable
    public final AdInfo zzt() {
        return this.zzq;
    }

    @Nullable
    public final String zzu() {
        return this.zzr;
    }

    public final int zzv() {
        return this.zzs;
    }
}
