package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzfo extends zzki implements zzad {
    @VisibleForTesting
    public static int zzb = 65535;
    @VisibleForTesting
    public static int zzc = 2;
    public final Map<String, Map<String, String>> zzd = new ArrayMap();
    public final Map<String, Map<String, Boolean>> zze = new ArrayMap();
    public final Map<String, Map<String, Boolean>> zzf = new ArrayMap();
    public final Map<String, zzca.zzb> zzg = new ArrayMap();
    public final Map<String, Map<String, Integer>> zzh = new ArrayMap();
    public final Map<String, String> zzi = new ArrayMap();

    public zzfo(zzkl zzkl) {
        super(zzkl);
    }

    @WorkerThread
    private final void zzi(String str) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] zzd2 = zzi().zzd(str);
            if (zzd2 == null) {
                this.zzd.put(str, (Object) null);
                this.zze.put(str, (Object) null);
                this.zzf.put(str, (Object) null);
                this.zzg.put(str, (Object) null);
                this.zzi.put(str, (Object) null);
                this.zzh.put(str, (Object) null);
                return;
            }
            zzca.zzb.zza zza = (zzca.zzb.zza) zza(str, zzd2).zzbo();
            zza(str, zza);
            this.zzd.put(str, zza((zzca.zzb) ((zzhy) zza.zzy())));
            this.zzg.put(str, (zzca.zzb) ((zzhy) zza.zzy()));
            this.zzi.put(str, (Object) null);
        }
    }

    /* renamed from: f_ */
    public final /* bridge */ /* synthetic */ zzkr mo31422f_() {
        return super.mo31422f_();
    }

    @WorkerThread
    public final zzca.zzb zza(String str) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    @WorkerThread
    public final String zzb(String str) {
        zzc();
        return this.zzi.get(str);
    }

    @WorkerThread
    public final void zzc(String str) {
        zzc();
        this.zzi.put(str, (Object) null);
    }

    @WorkerThread
    public final void zzd(String str) {
        zzc();
        this.zzg.remove(str);
    }

    public final boolean zzd() {
        return false;
    }

    @WorkerThread
    public final boolean zze(String str) {
        zzc();
        zzca.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzh();
    }

    @WorkerThread
    public final long zzf(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzq().zzh().zza("Unable to parse timezone offset. appId", zzeq.zza(str), e);
            return 0;
        }
    }

    public final boolean zzg(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean zzh(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ zzfo zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzr zzh() {
        return super.zzh();
    }

    @WorkerThread
    public final boolean zzb(String str, String str2) {
        Boolean bool;
        zzc();
        zzi(str);
        if (zzg(str) && zzkv.zzd(str2)) {
            return true;
        }
        if (zzh(str) && zzkv.zza(str2)) {
            return true;
        }
        Map map = this.zze.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzc();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = this.zzf.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @WorkerThread
    public final int zzd(String str, String str2) {
        Integer num;
        zzc();
        zzi(str);
        Map map = this.zzh.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @WorkerThread
    public final String zza(String str, String str2) {
        zzc();
        zzi(str);
        Map map = this.zzd.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ zzjr zzf() {
        return super.zzf();
    }

    public static Map<String, String> zza(zzca.zzb zzb2) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzb2 != null) {
            for (zzca.zzc next : zzb2.zze()) {
                arrayMap.put(next.zza(), next.zzb());
            }
        }
        return arrayMap;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    private final void zza(String str, zzca.zzb.zza zza) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zza != null) {
            for (int i = 0; i < zza.zza(); i++) {
                zzca.zza.C3367zza zza2 = (zzca.zza.C3367zza) zza.zza(i).zzbo();
                if (TextUtils.isEmpty(zza2.zza())) {
                    zzq().zzh().zza("EventConfig contained null event name");
                } else {
                    String zza3 = zza2.zza();
                    String zzb2 = zzgv.zzb(zza2.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zza2 = zza2.zza(zzb2);
                        zza.zza(i, zza2);
                    }
                    if (!zzlo.zzb() || !zzs().zza(zzas.zzcm)) {
                        arrayMap.put(zza2.zza(), Boolean.valueOf(zza2.zzb()));
                    } else {
                        arrayMap.put(zza3, Boolean.valueOf(zza2.zzb()));
                    }
                    arrayMap2.put(zza2.zza(), Boolean.valueOf(zza2.zzc()));
                    if (zza2.zzd()) {
                        if (zza2.zze() < zzc || zza2.zze() > zzb) {
                            zzq().zzh().zza("Invalid sampling rate. Event name, sample rate", zza2.zza(), Integer.valueOf(zza2.zze()));
                        } else {
                            arrayMap3.put(zza2.zza(), Integer.valueOf(zza2.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    public final /* bridge */ /* synthetic */ zzaf zzi() {
        return super.zzi();
    }

    @WorkerThread
    public final boolean zza(String str, byte[] bArr, String str2) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        zzca.zzb.zza zza = (zzca.zzb.zza) zza(str, bArr).zzbo();
        if (zza == null) {
            return false;
        }
        zza(str, zza);
        this.zzg.put(str, (zzca.zzb) ((zzhy) zza.zzy()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzca.zzb) ((zzhy) zza.zzy())));
        zzi().zza(str, (List<zzbv.zza>) new ArrayList(zza.zzb()));
        try {
            zza.zzc();
            bArr = ((zzca.zzb) ((zzhy) zza.zzy())).zzbk();
        } catch (RuntimeException e) {
            zzq().zzh().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzeq.zza(str), e);
        }
        zzaf zzi2 = zzi();
        Preconditions.checkNotEmpty(str);
        zzi2.zzc();
        zzi2.zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzi2.mo31260c_().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi2.zzq().zze().zza("Failed to update remote config (got 0). appId", zzeq.zza(str));
            }
        } catch (SQLiteException e2) {
            zzi2.zzq().zze().zza("Error storing remote config. appId", zzeq.zza(str), e2);
        }
        this.zzg.put(str, (zzca.zzb) ((zzhy) zza.zzy()));
        return true;
    }

    @WorkerThread
    private final zzca.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzca.zzb.zzj();
        }
        try {
            zzca.zzb zzb2 = (zzca.zzb) ((zzhy) ((zzca.zzb.zza) zzkr.zza(zzca.zzb.zzi(), bArr)).zzy());
            zzes zzw = zzq().zzw();
            String str2 = null;
            Long valueOf = zzb2.zza() ? Long.valueOf(zzb2.zzb()) : null;
            if (zzb2.zzc()) {
                str2 = zzb2.zzd();
            }
            zzw.zza("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzb2;
        } catch (zzij e) {
            zzq().zzh().zza("Unable to merge remote config. appId", zzeq.zza(str), e);
            return zzca.zzb.zzj();
        } catch (RuntimeException e2) {
            zzq().zzh().zza("Unable to merge remote config. appId", zzeq.zza(str), e2);
            return zzca.zzb.zzj();
        }
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
