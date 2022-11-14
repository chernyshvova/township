package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfig {
    @VisibleForTesting
    public final File zza;
    public final File zzb;
    public final SharedPreferences zzc;
    public final zzhl zzd;

    public zzfig(@NonNull Context context, zzhl zzhl) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfih.zzd(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfih.zzd(dir2, true);
        this.zza = dir2;
        this.zzd = zzhl;
    }

    @VisibleForTesting
    public static String zzb(@NonNull zzhr zzhr) {
        return Hex.bytesToStringLowercase(zzhr.zzan().zzz());
    }

    private final File zze() {
        File file = new File(this.zzb, Integer.toString(this.zzd.zza()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zzf() {
        return GeneratedOutlineSupport.outline9(17, "FBAMTD", this.zzd.zza());
    }

    private final String zzg() {
        return GeneratedOutlineSupport.outline9(17, "LATMTD", this.zzd.zza());
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzho r8, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzfim r9) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzhr r0 = r8.zza()
            java.lang.String r0 = r0.zza()
            com.google.android.gms.internal.ads.zzgcz r1 = r8.zzc()
            byte[] r1 = r1.zzz()
            com.google.android.gms.internal.ads.zzgcz r2 = r8.zzd()
            byte[] r2 = r2.zzz()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r4 = 0
            if (r3 != 0) goto L_0x017d
            if (r2 == 0) goto L_0x017d
            int r3 = r2.length
            if (r3 != 0) goto L_0x0026
            goto L_0x017d
        L_0x0026:
            java.io.File r3 = r7.zza
            com.google.android.gms.internal.ads.zzfih.zze(r3)
            java.io.File r3 = r7.zza
            r3.mkdirs()
            java.io.File r3 = r7.zza
            java.io.File r3 = com.google.android.gms.internal.ads.zzfih.zzc(r0, r3)
            r3.mkdirs()
            java.io.File r3 = r7.zza
            java.lang.String r5 = "pcam.jar"
            java.io.File r3 = com.google.android.gms.internal.ads.zzfih.zza(r0, r5, r3)
            if (r1 == 0) goto L_0x004c
            int r6 = r1.length
            if (r6 <= 0) goto L_0x004c
            boolean r1 = com.google.android.gms.internal.ads.zzfih.zzb(r3, r1)
            if (r1 == 0) goto L_0x017d
        L_0x004c:
            java.io.File r1 = r7.zza
            java.lang.String r3 = "pcbc"
            java.io.File r0 = com.google.android.gms.internal.ads.zzfih.zza(r0, r3, r1)
            boolean r0 = com.google.android.gms.internal.ads.zzfih.zzb(r0, r2)
            if (r0 == 0) goto L_0x017d
            com.google.android.gms.internal.ads.zzhr r0 = r8.zza()
            java.lang.String r0 = r0.zza()
            java.io.File r1 = r7.zza
            java.io.File r0 = com.google.android.gms.internal.ads.zzfih.zza(r0, r5, r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0078
            if (r9 == 0) goto L_0x0078
            boolean r9 = r9.zza(r0)
            if (r9 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            return r4
        L_0x0078:
            com.google.android.gms.internal.ads.zzhr r9 = r8.zza()
            java.lang.String r9 = r9.zza()
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 1
            if (r0 == 0) goto L_0x008a
        L_0x0087:
            r8 = 0
            goto L_0x0137
        L_0x008a:
            java.io.File r0 = r7.zza
            java.io.File r0 = com.google.android.gms.internal.ads.zzfih.zza(r9, r5, r0)
            java.io.File r2 = r7.zza
            java.io.File r2 = com.google.android.gms.internal.ads.zzfih.zza(r9, r3, r2)
            java.io.File r6 = r7.zze()
            java.io.File r5 = com.google.android.gms.internal.ads.zzfih.zza(r9, r5, r6)
            java.io.File r6 = r7.zze()
            java.io.File r9 = com.google.android.gms.internal.ads.zzfih.zza(r9, r3, r6)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x00b3
            boolean r0 = r0.renameTo(r5)
            if (r0 != 0) goto L_0x00b3
            goto L_0x0087
        L_0x00b3:
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x0087
            boolean r9 = r2.renameTo(r9)
            if (r9 == 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzhq r9 = com.google.android.gms.internal.ads.zzhr.zzi()
            com.google.android.gms.internal.ads.zzhr r0 = r8.zza()
            java.lang.String r0 = r0.zza()
            r9.zza(r0)
            com.google.android.gms.internal.ads.zzhr r0 = r8.zza()
            java.lang.String r0 = r0.zzc()
            r9.zzb(r0)
            com.google.android.gms.internal.ads.zzhr r0 = r8.zza()
            long r2 = r0.zze()
            r9.zzd(r2)
            com.google.android.gms.internal.ads.zzhr r0 = r8.zza()
            long r2 = r0.zzf()
            r9.zze(r2)
            com.google.android.gms.internal.ads.zzhr r8 = r8.zza()
            long r2 = r8.zzd()
            r9.zzc(r2)
            com.google.android.gms.internal.ads.zzgec r8 = r9.zzah()
            com.google.android.gms.internal.ads.zzhr r8 = (com.google.android.gms.internal.ads.zzhr) r8
            com.google.android.gms.internal.ads.zzhr r9 = r7.zzd(r1)
            android.content.SharedPreferences r0 = r7.zzc
            android.content.SharedPreferences$Editor r0 = r0.edit()
            if (r9 == 0) goto L_0x0125
            java.lang.String r2 = r8.zza()
            java.lang.String r3 = r9.zza()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0125
            java.lang.String r2 = r7.zzf()
            java.lang.String r9 = zzb(r9)
            r0.putString(r2, r9)
        L_0x0125:
            java.lang.String r9 = r7.zzg()
            java.lang.String r8 = zzb(r8)
            r0.putString(r9, r8)
            boolean r8 = r0.commit()
            if (r8 == 0) goto L_0x0087
            r8 = 1
        L_0x0137:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            com.google.android.gms.internal.ads.zzhr r0 = r7.zzd(r1)
            if (r0 == 0) goto L_0x0149
            java.lang.String r0 = r0.zza()
            r9.add(r0)
        L_0x0149:
            r0 = 2
            com.google.android.gms.internal.ads.zzhr r0 = r7.zzd(r0)
            if (r0 == 0) goto L_0x0157
            java.lang.String r0 = r0.zza()
            r9.add(r0)
        L_0x0157:
            java.io.File r0 = r7.zze()
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
        L_0x0160:
            if (r4 >= r1) goto L_0x017c
            r2 = r0[r4]
            java.lang.String r2 = r2.getName()
            boolean r3 = r9.contains(r2)
            if (r3 != 0) goto L_0x0179
            java.io.File r3 = r7.zze()
            java.io.File r2 = com.google.android.gms.internal.ads.zzfih.zzc(r2, r3)
            com.google.android.gms.internal.ads.zzfih.zze(r2)
        L_0x0179:
            int r4 = r4 + 1
            goto L_0x0160
        L_0x017c:
            return r8
        L_0x017d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfig.zza(com.google.android.gms.internal.ads.zzho, com.google.android.gms.internal.ads.zzfim):boolean");
    }

    public final zzfif zzc(int i) {
        zzhr zzd2 = zzd(1);
        if (zzd2 == null) {
            return null;
        }
        String zza2 = zzd2.zza();
        File zza3 = zzfih.zza(zza2, "pcam.jar", zze());
        if (!zza3.exists()) {
            zza3 = zzfih.zza(zza2, "pcam", zze());
        }
        return new zzfif(zzd2, zza3, zzfih.zza(zza2, "pcbc", zze()), zzfih.zza(zza2, "pcopt", zze()));
    }

    @VisibleForTesting
    public final zzhr zzd(int i) {
        String str;
        if (i == 1) {
            str = this.zzc.getString(zzg(), (String) null);
        } else {
            str = this.zzc.getString(zzf(), (String) null);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            zzhr zzg = zzhr.zzg(zzgcz.zzt(Hex.stringToBytes(str)));
            String zza2 = zzg.zza();
            File zza3 = zzfih.zza(zza2, "pcam.jar", zze());
            if (!zza3.exists()) {
                zza3 = zzfih.zza(zza2, "pcam", zze());
            }
            File zza4 = zzfih.zza(zza2, "pcbc", zze());
            if (!zza3.exists() || !zza4.exists()) {
                return null;
            }
            return zzg;
        } catch (zzgeo unused) {
        }
    }
}
