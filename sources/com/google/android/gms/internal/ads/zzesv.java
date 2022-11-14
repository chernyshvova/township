package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzesv implements zzgjg<zzeqs<JSONObject>> {
    public static zzeqs<JSONObject> zza(zzcfu zzcfu, Object obj, zzerk zzerk, zzesi zzesi, zzgja<zzere> zzgja, zzgja<zzern> zzgja2, zzgja<zzert> zzgja3, zzgja<zzerx> zzgja4, zzgja<zzese> zzgja5, zzgja<zzesl> zzgja6, zzgja<zzesx> zzgja7, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzesb) obj);
        hashSet.add(zzerk);
        hashSet.add(zzesi);
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdY)).booleanValue()) {
            hashSet.add(zzgja.zzb());
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdZ)).booleanValue()) {
            hashSet.add(zzgja2.zzb());
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzea)).booleanValue()) {
            hashSet.add(zzgja3.zzb());
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeb)).booleanValue()) {
            hashSet.add(zzgja4.zzb());
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzef)).booleanValue()) {
            hashSet.add(zzgja6.zzb());
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeg)).booleanValue()) {
            hashSet.add(zzgja7.zzb());
        }
        return new zzeqs<>(executor, hashSet);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
