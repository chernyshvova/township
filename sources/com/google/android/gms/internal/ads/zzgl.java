package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgl extends zzhg {
    public static volatile Long zzi;
    public static final Object zzj = new Object();

    public zzgl(zzfy zzfy, String str, String str2, zzcn zzcn, int i, int i2) {
        super(zzfy, "lJImmJcZfYR8hdrMtfVgK5wxyzq2Tz1kfG0dB54yhkfwwl7Exs4yXjgCxWvlOEKN", "xAGN8erZZwMSW/Fu3r0voEWCBbBpqzcnOOBzjHGoZvo=", zzcn, i, 44);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzB(zzi.longValue());
        }
    }
}
