package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdo {
    public static final zzbdo zza = new zzbdo();

    public final zzbdk zza(Context context, zzbhn zzbhn) {
        List list;
        Context context2;
        zzbdb zzbdb;
        String str;
        zzbhn zzbhn2 = zzbhn;
        Date zza2 = zzbhn.zza();
        long time = zza2 != null ? zza2.getTime() : -1;
        String zzb = zzbhn.zzb();
        int zzd = zzbhn.zzd();
        Set<String> zze = zzbhn.zze();
        if (!zze.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(zze));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean zzm = zzbhn2.zzm(context2);
        Location zzf = zzbhn.zzf();
        Bundle zzh = zzbhn2.zzh(AdMobAdapter.class);
        AdInfo zzt = zzbhn.zzt();
        if (zzt != null) {
            QueryInfo queryInfo = zzt.getQueryInfo();
            zzbdb = new zzbdb(zzbhn.zzt().getAdString(), queryInfo != null ? queryInfo.zza().zzd() : "");
        } else {
            zzbdb = null;
        }
        String zzj = zzbhn.zzj();
        SearchAdRequest zzl = zzbhn.zzl();
        zzbir zzbir = zzl != null ? new zzbir(zzl) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzbev.zza();
            str = zzcgl.zzl(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzs = zzbhn.zzs();
        RequestConfiguration zzm2 = zzbhv.zza().zzm();
        return new zzbdk(8, time, zzh, zzd, list, zzm, Math.max(zzbhn.zzp(), zzm2.getTagForChildDirectedTreatment()), false, zzj, zzbir, zzf, zzb, zzbhn.zzo(), zzbhn.zzq(), Collections.unmodifiableList(new ArrayList(zzbhn.zzr())), zzbhn.zzk(), str, zzs, zzbdb, Math.max(-1, zzm2.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(new String[]{null, zzm2.getMaxAdContentRating()}), zzbdn.zza), zzbhn.zzc(), zzbhn.zzv(), zzbhn.zzu());
    }
}
