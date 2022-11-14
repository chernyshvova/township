package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public enum zzcv implements zzgee {
    ERROR_ENCODE_SIZE_FAIL(1),
    ERROR_UNKNOWN(3),
    ERROR_NO_SIGNALS(5),
    ERROR_ENCRYPTION(7),
    ERROR_MEMORY(9),
    ERROR_SIMULATOR(11),
    ERROR_SERVICE(13),
    ERROR_THREAD(15),
    PSN_WEB64_FAIL(2),
    PSN_DECRYPT_SIZE_FAIL(4),
    PSN_MD5_CHECK_FAIL(8),
    PSN_MD5_SIZE_FAIL(16),
    PSN_MD5_FAIL(32),
    PSN_DECODE_FAIL(64),
    PSN_SALT_FAIL(128),
    PSN_BITSLICER_FAIL(256),
    PSN_REQUEST_TYPE_FAIL(512),
    PSN_INVALID_ERROR_CODE(1024),
    PSN_TIMESTAMP_EXPIRED(2048),
    PSN_ENCODE_SIZE_FAIL(4096),
    PSN_BLANK_VALUE(8192),
    PSN_INITIALIZATION_FAIL(16384),
    PSN_GASS_CLIENT_FAIL(32768),
    PSN_SIGNALS_TIMEOUT(65536),
    PSN_TINK_FAIL(131072);
    
    public static final zzgef<zzcv> zzz = null;
    public final int zzA;

    /* access modifiers changed from: public */
    static {
        zzz = new zzcu();
    }

    /* access modifiers changed from: public */
    zzcv(int i) {
        this.zzA = i;
    }

    public final String toString() {
        return "<" + zzcv.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzA + " name=" + name() + '>';
    }

    public final int zza() {
        return this.zzA;
    }
}
