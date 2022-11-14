package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzvz {
    public final int zzd;

    public zzvz(int i) {
        this.zzd = i;
    }

    public static int zze(int i) {
        return (i >> 24) & 255;
    }

    public static String zzf(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return zzf(this.zzd);
    }
}
