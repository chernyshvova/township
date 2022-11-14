package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzfkg extends zzfkj {
    public final /* synthetic */ zzfkh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfkg(zzfkh zzfkh, zzfkk zzfkk, CharSequence charSequence) {
        super(zzfkk, charSequence);
        this.zza = zzfkh;
    }

    public final int zzc(int i) {
        zzfjr zzfjr = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfke.zzf(i, length, "index");
        while (i < length) {
            if (zzfjr.zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final int zzd(int i) {
        return i + 1;
    }
}
