package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzciq {
    @VisibleForTesting
    public static final AtomicInteger zza = new AtomicInteger(0);
    @VisibleForTesting
    public static final AtomicInteger zzb = new AtomicInteger(0);

    public static int zzan() {
        return zza.get();
    }

    public static int zzao() {
        return zzb.get();
    }

    public abstract void zzN(Uri[] uriArr, String str);

    public abstract void zzO(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z);

    public abstract void zzP(zzcip zzcip);

    public abstract void zzQ();

    public abstract void zzR(Surface surface, boolean z) throws IOException;

    public abstract void zzS(float f, boolean z) throws IOException;

    public abstract void zzT();

    public abstract void zzU(long j);

    public abstract void zzV(int i);

    public abstract void zzW(int i);

    public abstract void zzX(int i);

    public abstract boolean zzY();

    public abstract int zzZ();

    public abstract long zzaa();

    public abstract boolean zzab();

    public abstract void zzac(boolean z);

    public abstract void zzad(int i);

    public abstract void zzae(int i);

    public abstract long zzaf();

    public abstract long zzag();

    public abstract long zzah();

    public abstract long zzai();

    public abstract int zzaj();

    public abstract void zzak(boolean z);

    public abstract long zzal();

    public abstract long zzam();
}
