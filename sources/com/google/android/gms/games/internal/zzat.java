package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.GmsLogger;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzat {
    public static final GmsLogger zza = new GmsLogger("Games");

    public static void zza(String str, String str2) {
        zza.mo17105d(zzi(str), str2);
    }

    public static void zzb(String str, String str2, Throwable th) {
        zza.mo17106d(zzi("GamesApiManager"), "Authentication task failed", th);
    }

    public static void zzc(String str, String str2) {
        zza.mo17107e(zzi(str), str2);
    }

    public static void zzd(String str, String str2, Throwable th) {
        zza.mo17108e(zzi(str), str2, th);
    }

    public static void zze(String str, String str2, Throwable th) {
        zza.mo17111i(zzi("SnapshotContentsEntity"), "Failed to write snapshot data", th);
    }

    public static void zzf(String str, String str2) {
        zza.mo17114v(zzi(str), str2);
    }

    public static void zzg(String str, String str2) {
        zza.mo17116w(zzi(str), str2);
    }

    public static void zzh(String str, String str2, Throwable th) {
        zza.mo17117w(zzi(str), str2, th);
    }

    public static String zzi(String str) {
        return String.format("%s[%s]", new Object[]{"PlayGamesServices", str});
    }
}
