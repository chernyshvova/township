package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzac<T> implements Comparable<zzac<T>> {
    public final zzan zza;
    public final int zzb;
    public final String zzc;
    public final int zzd;
    public final Object zze;
    @GuardedBy("mLock")
    @Nullable
    public final zzag zzf;
    public Integer zzg;
    public zzaf zzh;
    @GuardedBy("mLock")
    public boolean zzi;
    @Nullable
    public zzl zzj;
    @GuardedBy("mLock")
    public zzab zzk;
    public final zzq zzl;

    public zzac(int i, String str, @Nullable zzag zzag) {
        Uri parse;
        String host;
        this.zza = zzan.zza ? new zzan() : null;
        this.zze = new Object();
        int i2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzag;
        this.zzl = new zzq();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzd = i2;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzac) obj).zzg.intValue();
    }

    public final String toString() {
        String str;
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        if (valueOf.length() != 0) {
            str = "0x".concat(valueOf);
        } else {
            str = new String("0x");
        }
        zzl();
        String str2 = this.zzc;
        String valueOf2 = String.valueOf(this.zzg);
        int length = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 7 + String.valueOf(str).length() + 6 + valueOf2.length());
        GeneratedOutlineSupport.outline34(sb, "[ ] ", str2, " ", str);
        return GeneratedOutlineSupport.outline18(sb, " NORMAL ", valueOf2);
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final void zzc(String str) {
        if (zzan.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzd(String str) {
        zzaf zzaf = this.zzh;
        if (zzaf != null) {
            zzaf.zzc(this);
        }
        if (zzan.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzaa(this, str, id));
                return;
            }
            this.zza.zza(str, id);
            this.zza.zzb(toString());
        }
    }

    public final void zze(int i) {
        zzaf zzaf = this.zzh;
        if (zzaf != null) {
            zzaf.zzd(this, i);
        }
    }

    public final zzac<?> zzf(zzaf zzaf) {
        this.zzh = zzaf;
        return this;
    }

    public final zzac<?> zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        String str = this.zzc;
        if (this.zzb == 0) {
            return str;
        }
        String num = Integer.toString(1);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final zzac<?> zzj(zzl zzl2) {
        this.zzj = zzl2;
        return this;
    }

    @Nullable
    public final zzl zzk() {
        return this.zzj;
    }

    public final boolean zzl() {
        synchronized (this.zze) {
        }
        return false;
    }

    public Map<String, String> zzm() throws zzk {
        return Collections.emptyMap();
    }

    public byte[] zzn() throws zzk {
        return null;
    }

    public final int zzo() {
        return this.zzl.zza();
    }

    public final void zzp() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final boolean zzq() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public abstract zzai<T> zzr(zzy zzy);

    public abstract void zzs(T t);

    public final void zzt(zzal zzal) {
        zzag zzag;
        synchronized (this.zze) {
            zzag = this.zzf;
        }
        if (zzag != null) {
            zzag.zza(zzal);
        }
    }

    public final void zzu(zzab zzab) {
        synchronized (this.zze) {
            this.zzk = zzab;
        }
    }

    public final void zzv(zzai<?> zzai) {
        zzab zzab;
        synchronized (this.zze) {
            zzab = this.zzk;
        }
        if (zzab != null) {
            zzab.zza(this, zzai);
        }
    }

    public final void zzw() {
        zzab zzab;
        synchronized (this.zze) {
            zzab = this.zzk;
        }
        if (zzab != null) {
            zzab.zzb(this);
        }
    }

    public final zzq zzy() {
        return this.zzl;
    }
}
