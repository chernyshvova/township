package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfin {
    public static final Object zzf = new Object();
    public final Context zza;
    public final SharedPreferences zzb;
    public final String zzc;
    public final zzfhu zzd;
    public boolean zze = false;

    public zzfin(@NonNull Context context, @NonNull zzhl zzhl, @NonNull zzfhu zzfhu, boolean z) {
        this.zza = context;
        this.zzc = Integer.toString(zzhl.zza());
        this.zzb = context.getSharedPreferences("pcvmspf", 0);
        this.zzd = zzfhu;
        this.zze = z;
    }

    private final File zze(@NonNull String str) {
        return new File(new File(this.zza.getDir("pccache", 0), this.zzc), str);
    }

    private final String zzf() {
        String valueOf = String.valueOf(this.zzc);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    private final String zzg() {
        String valueOf = String.valueOf(this.zzc);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    public static String zzh(@NonNull zzho zzho) {
        zzhq zzi = zzhr.zzi();
        zzi.zza(zzho.zza().zza());
        zzi.zzb(zzho.zza().zzc());
        zzi.zzd(zzho.zza().zze());
        zzi.zze(zzho.zza().zzf());
        zzi.zzc(zzho.zza().zzd());
        return Hex.bytesToStringLowercase(((zzhr) zzi.zzah()).zzan().zzz());
    }

    private final void zzi(int i, long j) {
        zzfhu zzfhu = this.zzd;
        if (zzfhu != null) {
            zzfhu.zza(i, j);
        }
    }

    private final void zzj(int i, long j, String str) {
        zzfhu zzfhu = this.zzd;
        if (zzfhu != null) {
            zzfhu.zzb(i, j, str);
        }
    }

    private final zzhr zzk(int i) {
        String str;
        zzgdo zzgdo;
        if (i == 1) {
            str = this.zzb.getString(zzg(), (String) null);
        } else {
            str = this.zzb.getString(zzf(), (String) null);
        }
        if (str == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzgcz zzt = zzgcz.zzt(Hex.stringToBytes(str));
            if (this.zze) {
                zzgdo = zzgdo.zza();
            } else {
                zzgdo = zzgdo.zzb();
            }
            return zzhr.zzh(zzt, zzgdo);
        } catch (zzgeo unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, currentTimeMillis);
            return null;
        }
    }

    public final boolean zza(@NonNull zzho zzho, @Nullable zzfim zzfim) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzhr zzk = zzk(1);
            String zza2 = zzho.zza().zza();
            if (zzk == null || !zzk.zza().equals(zza2)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File zze2 = zze(zza2);
                if (zze2.exists()) {
                    boolean isDirectory = zze2.isDirectory();
                    String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    if (true != isDirectory) {
                        str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    boolean isFile = zze2.isFile();
                    String str3 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    if (true != isFile) {
                        str3 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    StringBuilder sb = new StringBuilder(str2.length() + 5 + str3.length());
                    sb.append("d:");
                    sb.append(str2);
                    sb.append(",f:");
                    sb.append(str3);
                    zzj(4023, currentTimeMillis2, sb.toString());
                    zzi(4015, currentTimeMillis2);
                } else if (!zze2.mkdirs()) {
                    boolean canWrite = zze2.canWrite();
                    String str4 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    if (true != canWrite) {
                        str4 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    if (str4.length() != 0) {
                        str = "cw:".concat(str4);
                    } else {
                        str = new String("cw:");
                    }
                    zzj(4024, currentTimeMillis2, str);
                    zzi(4015, currentTimeMillis2);
                    return false;
                }
                File zze3 = zze(zza2);
                File file = new File(zze3, "pcam.jar");
                File file2 = new File(zze3, "pcbc");
                if (!zzfih.zzb(file, zzho.zzc().zzz())) {
                    zzi(4016, currentTimeMillis);
                    return false;
                } else if (!zzfih.zzb(file2, zzho.zzd().zzz())) {
                    zzi(4017, currentTimeMillis);
                    return false;
                } else if (zzfim == null || zzfim.zza(file)) {
                    String zzh = zzh(zzho);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String string = this.zzb.getString(zzg(), (String) null);
                    SharedPreferences.Editor edit = this.zzb.edit();
                    edit.putString(zzg(), zzh);
                    if (string != null) {
                        edit.putString(zzf(), string);
                    }
                    if (!edit.commit()) {
                        zzi(4019, currentTimeMillis3);
                        return false;
                    }
                    HashSet hashSet = new HashSet();
                    zzhr zzk2 = zzk(1);
                    if (zzk2 != null) {
                        hashSet.add(zzk2.zza());
                    }
                    zzhr zzk3 = zzk(2);
                    if (zzk3 != null) {
                        hashSet.add(zzk3.zza());
                    }
                    for (File file3 : new File(this.zza.getDir("pccache", 0), this.zzc).listFiles()) {
                        if (!hashSet.contains(file3.getName())) {
                            zzfih.zze(file3);
                        }
                    }
                    zzi(5014, currentTimeMillis);
                    return true;
                } else {
                    zzi(4018, currentTimeMillis);
                    zzfih.zze(zze3);
                    return false;
                }
            } else {
                zzi(4014, currentTimeMillis);
                return false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzho r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = zzf
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzhr r3 = r7.zza()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zza()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.zze(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzgcz r3 = r7.zzd()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.zzz()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.android.gms.internal.ads.zzfih.zzb(r4, r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.zzi(r7, r0)     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            r7 = 0
            return r7
        L_0x0030:
            java.lang.String r7 = zzh(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.zzb     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.zzg()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfin.zzb(com.google.android.gms.internal.ads.zzho):boolean");
    }

    @Nullable
    public final zzfif zzc(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzhr zzk = zzk(1);
            if (zzk == null) {
                zzi(4022, currentTimeMillis);
                return null;
            }
            File zze2 = zze(zzk.zza());
            File file = new File(zze2, "pcam.jar");
            if (!file.exists()) {
                file = new File(zze2, "pcam");
            }
            File file2 = new File(zze2, "pcbc");
            File file3 = new File(zze2, "pcopt");
            zzi(5016, currentTimeMillis);
            zzfif zzfif = new zzfif(zzk, file, file2, file3);
            return zzfif;
        }
    }

    public final boolean zzd(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            zzhr zzk = zzk(1);
            if (zzk == null) {
                zzi(4025, currentTimeMillis);
                return false;
            }
            File zze2 = zze(zzk.zza());
            if (!new File(zze2, "pcam.jar").exists()) {
                zzi(4026, currentTimeMillis);
                return false;
            } else if (!new File(zze2, "pcbc").exists()) {
                zzi(4027, currentTimeMillis);
                return false;
            } else {
                zzi(5019, currentTimeMillis);
                return true;
            }
        }
    }
}
