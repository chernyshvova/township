package com.google.android.gms.internal.drive;

import java.io.IOException;

public final class zzli<K, V> {
    public static <K, V> void zza(zzjr zzjr, zzlj<K, V> zzlj, K k, V v) throws IOException {
        zzkb.zza(zzjr, zzlj.zztu, 1, k);
        zzkb.zza(zzjr, zzlj.zztw, 2, v);
    }

    public static <K, V> int zza(zzlj<K, V> zzlj, K k, V v) {
        return zzkb.zza(zzlj.zztw, 2, v) + zzkb.zza(zzlj.zztu, 1, k);
    }
}
