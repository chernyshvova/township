package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.ads.internal.util.zzbp;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdoi {
    public final zzbp zza;
    public final Clock zzb;
    public final Executor zzc;

    public zzdoi(zzbp zzbp, Clock clock, Executor executor) {
        this.zza = zzbp;
        this.zzb = clock;
        this.zzc = executor;
    }

    public static /* synthetic */ Bitmap zzb(zzdoi zzdoi, byte[] bArr, double d, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzet)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzdoi.zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i - 1) / ((Integer) zzbex.zzc().zzb(zzbjn.zzeu)).intValue())) / 2);
            }
        }
        return zzdoi.zzc(bArr, options);
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        long elapsedRealtime = this.zzb.elapsedRealtime();
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.zzb.elapsedRealtime();
        if (decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j = elapsedRealtime2 - elapsedRealtime;
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z = true;
            }
            StringBuilder outline22 = GeneratedOutlineSupport.outline22(108, "Decoded image w: ", width, " h:", height);
            outline22.append(" bytes: ");
            outline22.append(allocationByteCount);
            outline22.append(" time: ");
            outline22.append(j);
            outline22.append(" on ui thread: ");
            outline22.append(z);
            zze.zza(outline22.toString());
        }
        return decodeByteArray;
    }

    public final zzfqn<Bitmap> zza(String str, double d, boolean z) {
        return zzfqe.zzj(this.zza.zza(str), new zzdoh(this, d, z), this.zzc);
    }
}
