package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawo {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final zzaxd zze;
    public final zzaxl zzf;
    public final Object zzg = new Object();
    public final ArrayList<String> zzh = new ArrayList<>();
    public final ArrayList<String> zzi = new ArrayList<>();
    public final ArrayList<zzawz> zzj = new ArrayList<>();
    public int zzk = 0;
    public int zzl = 0;
    public int zzm = 0;
    public int zzn;
    public String zzo = "";
    public String zzp = "";
    public String zzq = "";

    public zzawo(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z;
        this.zze = new zzaxd(i4);
        this.zzf = new zzaxl(i5, i6, i7);
    }

    private final void zzp(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzc) {
            synchronized (this.zzg) {
                this.zzh.add(str);
                this.zzk += str.length();
                if (z) {
                    this.zzi.add(str);
                    this.zzj.add(new zzawz(f, f2, f3, f4, this.zzi.size() - 1));
                }
            }
        }
    }

    public static final String zzq(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            sb.append(arrayList.get(i2));
            sb.append(' ');
            i2++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzawo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzawo) obj).zzo;
        return str != null && str.equals(this.zzo);
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        int i = this.zzl;
        int i2 = this.zzn;
        int i3 = this.zzk;
        String zzq2 = zzq(this.zzh, 100);
        String zzq3 = zzq(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        int length = String.valueOf(zzq2).length();
        int length2 = String.valueOf(zzq3).length();
        int length3 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 165 + length2 + length3 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zzq2);
        GeneratedOutlineSupport.outline34(sb, "\n viewableText", zzq3, "\n signture: ", str);
        return GeneratedOutlineSupport.outline20(sb, "\n viewableSignture: ", str2, "\n viewableSignatureForVertical: ", str3);
    }

    public final boolean zza() {
        boolean z;
        synchronized (this.zzg) {
            z = this.zzm == 0;
        }
        return z;
    }

    public final String zzb() {
        return this.zzo;
    }

    public final String zzc() {
        return this.zzp;
    }

    public final String zzd() {
        return this.zzq;
    }

    public final void zze() {
        synchronized (this.zzg) {
            this.zzn -= 100;
        }
    }

    public final void zzf() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzg() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzh(String str, boolean z, float f, float f2, float f3, float f4) {
        zzp(str, z, f, f2, f3, f4);
        synchronized (this.zzg) {
            if (this.zzm < 0) {
                zzcgs.zzd("ActivityContent: negative number of WebViews.");
            }
            zzk();
        }
    }

    public final void zzi(String str, boolean z, float f, float f2, float f3, float f4) {
        zzp(str, z, f, f2, f3, f4);
    }

    public final void zzj() {
        synchronized (this.zzg) {
            int zzl2 = zzl(this.zzk, this.zzl);
            if (zzl2 > this.zzn) {
                this.zzn = zzl2;
            }
        }
    }

    public final void zzk() {
        synchronized (this.zzg) {
            int zzl2 = zzl(this.zzk, this.zzl);
            if (zzl2 > this.zzn) {
                this.zzn = zzl2;
                if (!zzs.zzg().zzl().zzd()) {
                    this.zzo = this.zze.zza(this.zzh);
                    this.zzp = this.zze.zza(this.zzi);
                }
                if (!zzs.zzg().zzl().zzh()) {
                    this.zzq = this.zzf.zza(this.zzi, this.zzj);
                }
            }
        }
    }

    @VisibleForTesting
    public final int zzl(int i, int i2) {
        if (this.zzd) {
            return this.zzb;
        }
        return (i2 * this.zzb) + (i * this.zza);
    }

    public final int zzm() {
        return this.zzn;
    }

    public final void zzn(int i) {
        this.zzl = i;
    }

    @VisibleForTesting
    public final int zzo() {
        return this.zzk;
    }
}
