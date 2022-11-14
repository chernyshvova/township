package com.google.android.datatransport.cct.p032a;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.datatransport.cct.p032a.zzt;
import java.util.Arrays;

/* renamed from: com.google.android.datatransport.cct.a.zzi */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzi extends zzt {
    public final long zza;
    public final int zzb;
    public final long zzc;
    public final byte[] zzd;
    public final String zze;
    public final long zzf;
    public final zzy zzg;

    /* renamed from: com.google.android.datatransport.cct.a.zzi$zza */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zza extends zzt.zza {
        public Long zza;
        public Integer zzb;
        public Long zzc;
        public byte[] zzd;
        public String zze;
        public Long zzf;
        public zzy zzg;

        public zzt.zza zza(int i) {
            this.zzb = Integer.valueOf(i);
            return this;
        }
    }

    public /* synthetic */ zzi(long j, int i, long j2, byte[] bArr, String str, long j3, zzy zzy) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = j3;
        this.zzg = zzy;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zzt = (zzt) obj;
        zzi zzi = (zzi) zzt;
        if (this.zza == zzi.zza && this.zzb == zzi.zzb && this.zzc == zzi.zzc) {
            byte[] bArr2 = this.zzd;
            if (zzt instanceof zzi) {
                bArr = zzi.zzd;
            } else {
                bArr = zzi.zzd;
            }
            if (Arrays.equals(bArr2, bArr) && ((str = this.zze) != null ? str.equals(zzi.zze) : zzi.zze == null) && this.zzf == zzi.zzf) {
                zzy zzy = this.zzg;
                if (zzy == null) {
                    if (zzi.zzg == null) {
                        return true;
                    }
                } else if (zzy.equals(zzi.zzg)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.zza;
        long j2 = this.zzc;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.zzd)) * 1000003;
        String str = this.zze;
        int i = 0;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.zzf;
        int i2 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        zzy zzy = this.zzg;
        if (zzy != null) {
            i = zzy.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("LogEvent{eventTimeMs=");
        outline24.append(this.zza);
        outline24.append(", eventCode=");
        outline24.append(this.zzb);
        outline24.append(", eventUptimeMs=");
        outline24.append(this.zzc);
        outline24.append(", sourceExtension=");
        outline24.append(Arrays.toString(this.zzd));
        outline24.append(", sourceExtensionJsonProto3=");
        outline24.append(this.zze);
        outline24.append(", timezoneOffsetSeconds=");
        outline24.append(this.zzf);
        outline24.append(", networkConnectionInfo=");
        outline24.append(this.zzg);
        outline24.append("}");
        return outline24.toString();
    }
}
