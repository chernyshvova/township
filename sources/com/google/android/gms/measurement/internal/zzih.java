package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzih extends zzki {
    public zzih(zzkl zzkl) {
        super(zzkl);
    }

    @WorkerThread
    public final byte[] zza(@NonNull zzaq zzaq, @Size(min = 1) String str) {
        zzkw zzkw;
        Bundle bundle;
        zzcd.zzf.zza zza;
        zzcd.zzg.zza zza2;
        zzf zzf;
        byte[] bArr;
        Bundle bundle2;
        zzam zzam;
        long j;
        zzaq zzaq2 = zzaq;
        String str2 = str;
        zzc();
        this.zzy.zzad();
        Preconditions.checkNotNull(zzaq);
        Preconditions.checkNotEmpty(str);
        if (!zzs().zze(str2, zzas.zzav)) {
            zzq().zzv().zza("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzaq2.zza) || "_iapx".equals(zzaq2.zza)) {
            zzcd.zzf.zza zzb = zzcd.zzf.zzb();
            zzi().zze();
            zzf zzb2 = zzi().zzb(str2);
            if (zzb2 == null) {
                zzq().zzv().zza("Log and bundle not available. package_name", str2);
                byte[] bArr2 = new byte[0];
                zzi().zzg();
                return bArr2;
            } else if (!zzb2.zzr()) {
                zzq().zzv().zza("Log and bundle disabled. package_name", str2);
                byte[] bArr3 = new byte[0];
                zzi().zzg();
                return bArr3;
            } else {
                zzcd.zzg.zza zza3 = zzcd.zzg.zzbh().zza(1).zza("android");
                if (!TextUtils.isEmpty(zzb2.zzc())) {
                    zza3.zzf(zzb2.zzc());
                }
                if (!TextUtils.isEmpty(zzb2.zzn())) {
                    zza3.zze(zzb2.zzn());
                }
                if (!TextUtils.isEmpty(zzb2.zzl())) {
                    zza3.zzg(zzb2.zzl());
                }
                if (zzb2.zzm() != -2147483648L) {
                    zza3.zzh((int) zzb2.zzm());
                }
                zza3.zzf(zzb2.zzo()).zzk(zzb2.zzq());
                if (!zznv.zzb() || !zzs().zze(zzb2.zzc(), zzas.zzbi)) {
                    if (!TextUtils.isEmpty(zzb2.zze())) {
                        zza3.zzk(zzb2.zze());
                    } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                        zza3.zzo(zzb2.zzf());
                    }
                } else if (!TextUtils.isEmpty(zzb2.zze())) {
                    zza3.zzk(zzb2.zze());
                } else if (!TextUtils.isEmpty(zzb2.zzg())) {
                    zza3.zzp(zzb2.zzg());
                } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                    zza3.zzo(zzb2.zzf());
                }
                zzac zza4 = this.zza.zza(str2);
                zza3.zzh(zzb2.zzp());
                if (this.zzy.zzaa() && zzs().zzh(zza3.zzj())) {
                    if (!zzml.zzb() || !zzs().zza(zzas.zzci)) {
                        zza3.zzj();
                        if (!TextUtils.isEmpty((CharSequence) null)) {
                            zza3.zzn((String) null);
                        }
                    } else if (zza4.zzc() && !TextUtils.isEmpty((CharSequence) null)) {
                        zza3.zzn((String) null);
                    }
                }
                if (zzml.zzb() && zzs().zza(zzas.zzci)) {
                    zza3.zzq(zza4.zza());
                }
                if (!zzml.zzb() || !zzs().zza(zzas.zzci) || zza4.zzc()) {
                    Pair<String, Boolean> zza5 = zzf().zza(zzb2.zzc(), zza4);
                    if (zzb2.zzaf() && zza5 != null && !TextUtils.isEmpty((CharSequence) zza5.first)) {
                        try {
                            zza3.zzh(zza((String) zza5.first, Long.toString(zzaq2.zzd)));
                            if (zza5.second != null) {
                                zza3.zza(((Boolean) zza5.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzq().zzv().zza("Resettable device id encryption failed", e.getMessage());
                            return new byte[0];
                        } finally {
                            zzi().zzg();
                        }
                    }
                }
                zzk().zzab();
                zzcd.zzg.zza zzc = zza3.zzc(Build.MODEL);
                zzk().zzab();
                zzc.zzb(Build.VERSION.RELEASE).zzf((int) zzk().zze()).zzd(zzk().zzf());
                try {
                    if (!zzml.zzb() || !zzs().zza(zzas.zzci) || zza4.zze()) {
                        zza3.zzi(zza(zzb2.zzd(), Long.toString(zzaq2.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzb2.zzi())) {
                        zza3.zzl(zzb2.zzi());
                    }
                    String zzc2 = zzb2.zzc();
                    List<zzkw> zza6 = zzi().zza(zzc2);
                    Iterator<zzkw> it = zza6.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzkw = null;
                            break;
                        }
                        zzkw = it.next();
                        if ("_lte".equals(zzkw.zzc)) {
                            break;
                        }
                    }
                    if (zzkw == null || zzkw.zze == null) {
                        zzkw zzkw2 = new zzkw(zzc2, "auto", "_lte", zzl().currentTimeMillis(), 0L);
                        zza6.add(zzkw2);
                        zzi().zza(zzkw2);
                    }
                    zzkr f_ = mo31422f_();
                    f_.zzq().zzw().zza("Checking account type status for ad personalization signals");
                    if (f_.zzk().zzi()) {
                        String zzc3 = zzb2.zzc();
                        if (zzb2.zzaf() && f_.zzj().zze(zzc3)) {
                            f_.zzq().zzv().zza("Turning off ad personalization due to account type");
                            Iterator<zzkw> it2 = zza6.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(it2.next().zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            zza6.add(new zzkw(zzc3, "auto", "_npa", f_.zzl().currentTimeMillis(), 1L));
                        }
                    }
                    zzcd.zzk[] zzkArr = new zzcd.zzk[zza6.size()];
                    for (int i = 0; i < zza6.size(); i++) {
                        zzcd.zzk.zza zza7 = zzcd.zzk.zzj().zza(zza6.get(i).zzc).zza(zza6.get(i).zzd);
                        mo31422f_().zza(zza7, zza6.get(i).zze);
                        zzkArr[i] = (zzcd.zzk) ((zzhy) zza7.zzy());
                    }
                    zza3.zzb((Iterable<? extends zzcd.zzk>) Arrays.asList(zzkArr));
                    if (!zznw.zzb() || !zzs().zza(zzas.zzbz) || !zzs().zza(zzas.zzca)) {
                        bundle = zzaq2.zzb.zzb();
                    } else {
                        zzeu zza8 = zzeu.zza(zzaq);
                        zzo().zza(zza8.zzb, zzi().zzi(str2));
                        zzo().zza(zza8, zzs().zza(str2));
                        bundle = zza8.zzb;
                    }
                    Bundle bundle3 = bundle;
                    bundle3.putLong("_c", 1);
                    zzq().zzv().zza("Marking in-app purchase as real-time");
                    bundle3.putLong("_r", 1);
                    bundle3.putString("_o", zzaq2.zzc);
                    if (zzo().zze(zza3.zzj())) {
                        zzo().zza(bundle3, "_dbg", (Object) 1L);
                        zzo().zza(bundle3, "_r", (Object) 1L);
                    }
                    zzam zza9 = zzi().zza(str2, zzaq2.zza);
                    if (zza9 == null) {
                        zzf = zzb2;
                        zza2 = zza3;
                        zza = zzb;
                        bundle2 = bundle3;
                        bArr = null;
                        zzam = new zzam(str, zzaq2.zza, 0, 0, zzaq2.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j = 0;
                    } else {
                        zza2 = zza3;
                        zzf = zzb2;
                        zza = zzb;
                        bundle2 = bundle3;
                        bArr = null;
                        j = zza9.zzf;
                        zzam = zza9.zza(zzaq2.zzd);
                    }
                    zzi().zza(zzam);
                    zzan zzan = new zzan(this.zzy, zzaq2.zzc, str, zzaq2.zza, zzaq2.zzd, j, bundle2);
                    zzcd.zzc.zza zzb3 = zzcd.zzc.zzj().zza(zzan.zzc).zza(zzan.zzb).zzb(zzan.zzd);
                    Iterator<String> it3 = zzan.zze.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        zzcd.zze.zza zza10 = zzcd.zze.zzm().zza(next);
                        mo31422f_().zza(zza10, zzan.zze.zza(next));
                        zzb3.zza(zza10);
                    }
                    zzcd.zzg.zza zza11 = zza2;
                    zza11.zza(zzb3).zza(zzcd.zzh.zza().zza(zzcd.zzd.zza().zza(zzam.zzc).zza(zzaq2.zza)));
                    zza11.zzc((Iterable<? extends zzcd.zza>) zzh().zza(zzf.zzc(), Collections.emptyList(), zza11.zzd(), Long.valueOf(zzb3.zzf()), Long.valueOf(zzb3.zzf())));
                    if (zzb3.zze()) {
                        zza11.zzb(zzb3.zzf()).zzc(zzb3.zzf());
                    }
                    long zzk = zzf.zzk();
                    if (zzk != 0) {
                        zza11.zze(zzk);
                    }
                    long zzj = zzf.zzj();
                    if (zzj != 0) {
                        zza11.zzd(zzj);
                    } else if (zzk != 0) {
                        zza11.zzd(zzk);
                    }
                    zzf.zzv();
                    zza11.zzg((int) zzf.zzs()).zzg(33025).zza(zzl().currentTimeMillis()).zzb(true);
                    zzcd.zzf.zza zza12 = zza;
                    zza12.zza(zza11);
                    zzf zzf2 = zzf;
                    zzf2.zza(zza11.zzf());
                    zzf2.zzb(zza11.zzg());
                    zzi().zza(zzf2);
                    zzi().mo31259b_();
                    try {
                        return mo31422f_().zzc(((zzcd.zzf) ((zzhy) zza12.zzy())).zzbk());
                    } catch (IOException e2) {
                        zzq().zze().zza("Data loss. Failed to bundle and serialize. appId", zzeq.zza(str), e2);
                        return bArr;
                    }
                } catch (SecurityException e3) {
                    zzq().zzv().zza("app instance id encryption failed", e3.getMessage());
                    byte[] bArr4 = new byte[0];
                    zzi().zzg();
                    return bArr4;
                }
            }
        } else {
            zzq().zzv().zza("Generating a payload for this event is not available. package_name, event_name", str2, zzaq2.zza);
            return null;
        }
    }

    public final boolean zzd() {
        return false;
    }

    public static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
