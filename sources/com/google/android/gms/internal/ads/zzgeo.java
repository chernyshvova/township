package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzgeo extends IOException {
    public zzgfk zza = null;
    public boolean zzb;

    public zzgeo(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public static zzgeo zzd() {
        return new zzgeo("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzgeo zze() {
        return new zzgeo("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzgeo zzf() {
        return new zzgeo("CodedInputStream encountered a malformed varint.");
    }

    public static zzgeo zzg() {
        return new zzgeo("Protocol message contained an invalid tag (zero).");
    }

    public static zzgeo zzh() {
        return new zzgeo("Protocol message end-group tag did not match expected tag.");
    }

    public static zzgen zzi() {
        return new zzgen("Protocol message tag had invalid wire type.");
    }

    public static zzgeo zzj() {
        return new zzgeo("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static zzgeo zzk() {
        return new zzgeo("Failed to parse the message.");
    }

    public static zzgeo zzl() {
        return new zzgeo("Protocol message had invalid UTF-8.");
    }

    public final zzgeo zza(zzgfk zzgfk) {
        this.zza = zzgfk;
        return this;
    }

    public final void zzb() {
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public zzgeo(String str) {
        super(str);
    }
}
