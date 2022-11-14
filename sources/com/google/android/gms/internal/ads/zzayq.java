package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayq extends PushbackInputStream {
    public final /* synthetic */ zzayr zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzayq(zzayr zzayr, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzayr;
    }

    public final synchronized void close() throws IOException {
        zzayt.zzb(this.zza.zzc);
        super.close();
    }
}
