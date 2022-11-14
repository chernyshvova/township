package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgt extends zzhg {
    public static volatile String zzi;
    public static final Object zzj = new Object();

    public zzgt(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "QusX5FxCSt7YALporGf+YBQ7+D9RItA2wCGYVD5mk8FUIvZ7EQ6LwVnumJjBeUBd", "rfyFxeBVRrcpHOkzoebVIka/58kwozJ0Dt9pVZcWCXE=", zzcn, i, 1);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zza("E");
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (String) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zza(zzi);
        }
    }
}
