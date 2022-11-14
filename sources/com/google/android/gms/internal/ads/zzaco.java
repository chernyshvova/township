package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaco extends zzacg {
    public static final Parcelable.Creator<zzaco> CREATOR = new zzacn();
    @Nullable
    public final String zza;
    public final String zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaco(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzalh.zza
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.zza = r0
            java.lang.String r3 = r3.readString()
            r2.zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaco.<init>(android.os.Parcel):void");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaco.class == obj.getClass()) {
            zzaco zzaco = (zzaco) obj;
            return zzalh.zzc(this.zzf, zzaco.zzf) && zzalh.zzc(this.zza, zzaco.zza) && zzalh.zzc(this.zzb, zzaco.zzb);
        }
    }

    public final int hashCode() {
        int outline4 = GeneratedOutlineSupport.outline4(this.zzf, 527, 31);
        String str = this.zza;
        int i = 0;
        int hashCode = (outline4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        StringBuilder sb = new StringBuilder(GeneratedOutlineSupport.outline1(String.valueOf(str).length(), 22, String.valueOf(str2).length(), String.valueOf(str3).length()));
        GeneratedOutlineSupport.outline34(sb, str, ": description=", str2, ": value=");
        sb.append(str3);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzkt r5) {
        /*
            r4 = this;
            java.lang.String r0 = r4.zzf
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 1
            switch(r1) {
                case 82815: goto L_0x0069;
                case 83253: goto L_0x005f;
                case 83254: goto L_0x0055;
                case 83341: goto L_0x004a;
                case 83378: goto L_0x0040;
                case 2567331: goto L_0x0036;
                case 2575251: goto L_0x002c;
                case 2581512: goto L_0x0022;
                case 2581513: goto L_0x0018;
                case 2583398: goto L_0x000d;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0073
        L_0x000d:
            java.lang.String r1 = "TRCK"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 9
            goto L_0x0074
        L_0x0018:
            java.lang.String r1 = "TPE2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 5
            goto L_0x0074
        L_0x0022:
            java.lang.String r1 = "TPE1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 3
            goto L_0x0074
        L_0x002c:
            java.lang.String r1 = "TIT2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 1
            goto L_0x0074
        L_0x0036:
            java.lang.String r1 = "TALB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 7
            goto L_0x0074
        L_0x0040:
            java.lang.String r1 = "TT2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 0
            goto L_0x0074
        L_0x004a:
            java.lang.String r1 = "TRK"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 8
            goto L_0x0074
        L_0x0055:
            java.lang.String r1 = "TP2"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 4
            goto L_0x0074
        L_0x005f:
            java.lang.String r1 = "TP1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 2
            goto L_0x0074
        L_0x0069:
            java.lang.String r1 = "TAL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            r0 = 6
            goto L_0x0074
        L_0x0073:
            r0 = -1
        L_0x0074:
            switch(r0) {
                case 0: goto L_0x00b2;
                case 1: goto L_0x00b2;
                case 2: goto L_0x00ac;
                case 3: goto L_0x00ac;
                case 4: goto L_0x00a6;
                case 5: goto L_0x00a6;
                case 6: goto L_0x00a0;
                case 7: goto L_0x00a0;
                case 8: goto L_0x0078;
                case 9: goto L_0x0078;
                default: goto L_0x0077;
            }
        L_0x0077:
            return
        L_0x0078:
            java.lang.String r0 = r4.zzb
            java.lang.String r1 = "/"
            java.lang.String[] r0 = com.google.android.gms.internal.ads.zzalh.zzt(r0, r1)
            r1 = r0[r2]     // Catch:{ NumberFormatException -> 0x009f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x009f }
            int r2 = r0.length     // Catch:{ NumberFormatException -> 0x009f }
            if (r2 <= r3) goto L_0x0094
            r0 = r0[r3]     // Catch:{ NumberFormatException -> 0x009f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x009f }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x009f }
            goto L_0x0095
        L_0x0094:
            r0 = 0
        L_0x0095:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x009f }
            r5.zzf(r1)     // Catch:{ NumberFormatException -> 0x009f }
            r5.zzg(r0)     // Catch:{ NumberFormatException -> 0x009f }
        L_0x009f:
            return
        L_0x00a0:
            java.lang.String r0 = r4.zzb
            r5.zzc(r0)
            return
        L_0x00a6:
            java.lang.String r0 = r4.zzb
            r5.zzd(r0)
            return
        L_0x00ac:
            java.lang.String r0 = r4.zzb
            r5.zzb(r0)
            return
        L_0x00b2:
            java.lang.String r0 = r4.zzb
            r5.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaco.zza(com.google.android.gms.internal.ads.zzkt):void");
    }

    public zzaco(String str, @Nullable String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }
}
