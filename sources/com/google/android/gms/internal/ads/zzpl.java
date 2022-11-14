package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzpl {
    public static final zzpl zza = new zzpl(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzpl(int i, int i2, int i3) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = zzalh.zzN(i3) ? zzalh.zzQ(i3, i2) : -1;
    }

    public final String toString() {
        int i = this.zzb;
        int i2 = this.zzc;
        int i3 = this.zzd;
        StringBuilder outline22 = GeneratedOutlineSupport.outline22(83, "AudioFormat[sampleRate=", i, ", channelCount=", i2);
        outline22.append(", encoding=");
        outline22.append(i3);
        outline22.append(']');
        return outline22.toString();
    }
}
