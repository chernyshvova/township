package com.google.android.gms.internal.ads;

import androidx.room.RoomDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzhl implements zzgee {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(RoomDatabase.MAX_BIND_PARAMETER_CNT);
    
    public static final zzgef<zzhl> zzg = null;
    public final int zzh;

    /* access modifiers changed from: public */
    static {
        zzg = new zzhk();
    }

    /* access modifiers changed from: public */
    zzhl(int i) {
        this.zzh = i;
    }

    public final String toString() {
        return "<" + zzhl.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzh;
    }
}
