package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzcq extends zzdp {
    public final Context zza;
    public final zzec<zzdy<zzdd>> zzb;

    public zzcq(Context context, @Nullable zzec<zzdy<zzdd>> zzec) {
        if (context != null) {
            this.zza = context;
            this.zzb = zzec;
            return;
        }
        throw new NullPointerException("Null context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.internal.measurement.zzdp
            r2 = 0
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzdp r5 = (com.google.android.gms.internal.measurement.zzdp) r5
            android.content.Context r1 = r4.zza
            android.content.Context r3 = r5.zza()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.measurement.zzec<com.google.android.gms.internal.measurement.zzdy<com.google.android.gms.internal.measurement.zzdd>> r1 = r4.zzb
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.internal.measurement.zzec r5 = r5.zzb()
            if (r5 != 0) goto L_0x002d
            goto L_0x002c
        L_0x0022:
            com.google.android.gms.internal.measurement.zzec r5 = r5.zzb()
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x002d
        L_0x002c:
            return r0
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcq.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzec<zzdy<zzdd>> zzec = this.zzb;
        return hashCode ^ (zzec == null ? 0 : zzec.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder outline23 = GeneratedOutlineSupport.outline23(valueOf2.length() + valueOf.length() + 46, "FlagsContext{context=", valueOf, ", hermeticFileOverrides=", valueOf2);
        outline23.append("}");
        return outline23.toString();
    }

    public final Context zza() {
        return this.zza;
    }

    @Nullable
    public final zzec<zzdy<zzdd>> zzb() {
        return this.zzb;
    }
}