package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavg extends Surface {
    public static boolean zza;
    public static boolean zzb;
    public final zzavf zzc;
    public boolean zzd;

    public /* synthetic */ zzavg(zzavf zzavf, SurfaceTexture surfaceTexture, boolean z, zzave zzave) {
        super(surfaceTexture);
        this.zzc = zzavf;
    }

    public static synchronized boolean zza(Context context) {
        boolean z;
        synchronized (zzavg.class) {
            if (!zzb) {
                if (zzava.zza >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (zzava.zza != 24 || ((!zzava.zzd.startsWith("SM-G950") && !zzava.zzd.startsWith("SM-G955")) || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zza = z2;
                }
                zzb = true;
            }
            z = zza;
        }
        return z;
    }

    public static zzavg zzb(Context context, boolean z) {
        if (zzava.zza >= 17) {
            boolean z2 = true;
            if (z && !zza(context)) {
                z2 = false;
            }
            zzaul.zzd(z2);
            return new zzavf().zza(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    public final void release() {
        super.release();
        synchronized (this.zzc) {
            if (!this.zzd) {
                this.zzc.zzb();
                this.zzd = true;
            }
        }
    }
}
