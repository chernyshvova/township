package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzfkj extends zzfjl<String> {
    public final CharSequence zzb;
    public final zzfjr zzc;
    public int zzd = 0;
    public int zze;

    public zzfkj(zzfkk zzfkk, CharSequence charSequence) {
        this.zzc = zzfkk.zza;
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    @CheckForNull
    public final /* bridge */ /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzd;
        while (true) {
            int i3 = this.zzd;
            if (i3 != -1) {
                int zzc2 = zzc(i3);
                if (zzc2 == -1) {
                    zzc2 = this.zzb.length();
                    this.zzd = -1;
                    i = -1;
                } else {
                    i = zzd(zzc2);
                    this.zzd = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zzd = i4;
                    if (i4 > this.zzb.length()) {
                        this.zzd = -1;
                    }
                } else {
                    if (i2 < zzc2) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzc2) {
                        this.zzb.charAt(zzc2 - 1);
                    }
                    int i5 = this.zze;
                    if (i5 == 1) {
                        zzc2 = this.zzb.length();
                        this.zzd = -1;
                        if (zzc2 > i2) {
                            this.zzb.charAt(zzc2 - 1);
                        }
                    } else {
                        this.zze = i5 - 1;
                    }
                    return this.zzb.subSequence(i2, zzc2).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    public abstract int zzc(int i);

    public abstract int zzd(int i);
}
