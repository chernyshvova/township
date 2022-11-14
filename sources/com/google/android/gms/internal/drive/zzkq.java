package com.google.android.gms.internal.drive;

import java.io.IOException;

public class zzkq extends IOException {
    public zzlq zzsq = null;

    public zzkq(String str) {
        super(str);
    }

    public static zzkq zzdi() {
        return new zzkq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static zzkq zzdj() {
        return new zzkq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzkq zzdk() {
        return new zzkq("Protocol message contained an invalid tag (zero).");
    }

    public static zzkr zzdl() {
        return new zzkr("Protocol message tag had invalid wire type.");
    }

    public static zzkq zzdm() {
        return new zzkq("Failed to parse the message.");
    }

    public static zzkq zzdn() {
        return new zzkq("Protocol message had invalid UTF-8.");
    }

    public final zzkq zzg(zzlq zzlq) {
        this.zzsq = zzlq;
        return this;
    }
}
