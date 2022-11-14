package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzasr implements zzasn {
    public final zzasn[] zza;
    public final ArrayList<zzasn> zzb;
    public final zzanu zzc = new zzanu();
    public zzasm zzd;
    public zzanv zze;
    public int zzf = -1;
    public zzasq zzg;

    public zzasr(zzasn... zzasnArr) {
        this.zza = zzasnArr;
        this.zzb = new ArrayList<>(Arrays.asList(zzasnArr));
    }

    public static /* synthetic */ void zzf(zzasr zzasr, int i, zzanv zzanv, Object obj) {
        zzasq zzasq;
        if (zzasr.zzg == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                zzanv.zzg(i2, zzasr.zzc, false);
            }
            int i3 = zzasr.zzf;
            if (i3 == -1) {
                zzasr.zzf = 1;
            } else if (i3 != 1) {
                zzasq = new zzasq(1);
                zzasr.zzg = zzasq;
            }
            zzasq = null;
            zzasr.zzg = zzasq;
        }
        if (zzasr.zzg == null) {
            zzasr.zzb.remove(zzasr.zza[i]);
            if (i == 0) {
                zzasr.zze = zzanv;
            }
            if (zzasr.zzb.isEmpty()) {
                zzasr.zzd.zzi(zzasr.zze, (Object) null);
            }
        }
    }

    public final void zza(zzana zzana, boolean z, zzasm zzasm) {
        this.zzd = zzasm;
        int i = 0;
        while (true) {
            zzasn[] zzasnArr = this.zza;
            if (i < zzasnArr.length) {
                zzasnArr[i].zza(zzana, false, new zzasp(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzb() throws IOException {
        zzasq zzasq = this.zzg;
        if (zzasq == null) {
            for (zzasn zzb2 : this.zza) {
                zzb2.zzb();
            }
            return;
        }
        throw zzasq;
    }

    public final void zzc(zzasl zzasl) {
        zzaso zzaso = (zzaso) zzasl;
        int i = 0;
        while (true) {
            zzasn[] zzasnArr = this.zza;
            if (i < zzasnArr.length) {
                zzasnArr[i].zzc(zzaso.zza[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzd() {
        for (zzasn zzd2 : this.zza) {
            zzd2.zzd();
        }
    }

    public final zzasl zze(int i, zzaty zzaty) {
        int length = this.zza.length;
        zzasl[] zzaslArr = new zzasl[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzaslArr[i2] = this.zza[i2].zze(i, zzaty);
        }
        return new zzaso(zzaslArr);
    }
}
