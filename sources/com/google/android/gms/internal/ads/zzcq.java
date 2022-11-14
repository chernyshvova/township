package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzcq implements zzgee {
    DEBUGGER_STATE_UNSPECIFIED(0),
    DEBUGGER_STATE_NOT_INSTALLED(1),
    DEBUGGER_STATE_INSTALLED(2),
    DEBUGGER_STATE_ACTIVE(3),
    DEBUGGER_STATE_ENVVAR(4),
    DEBUGGER_STATE_MACHPORT(5),
    DEBUGGER_STATE_ENVVAR_MACHPORT(6);
    
    public static final zzgef<zzcq> zzh = null;
    public final int zzi;

    /* access modifiers changed from: public */
    static {
        zzh = new zzco();
    }

    /* access modifiers changed from: public */
    zzcq(int i) {
        this.zzi = i;
    }

    public static zzcq zza(int i) {
        switch (i) {
            case 0:
                return DEBUGGER_STATE_UNSPECIFIED;
            case 1:
                return DEBUGGER_STATE_NOT_INSTALLED;
            case 2:
                return DEBUGGER_STATE_INSTALLED;
            case 3:
                return DEBUGGER_STATE_ACTIVE;
            case 4:
                return DEBUGGER_STATE_ENVVAR;
            case 5:
                return DEBUGGER_STATE_MACHPORT;
            case 6:
                return DEBUGGER_STATE_ENVVAR_MACHPORT;
            default:
                return null;
        }
    }

    public static zzgeg zzb() {
        return zzcp.zza;
    }

    public final String toString() {
        return "<" + zzcq.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
    }
}
