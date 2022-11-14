package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalp extends Surface {
    public static int zza;
    public static boolean zzb;
    public final zzalo zzc;
    public boolean zzd;

    public /* synthetic */ zzalp(zzalo zzalo, SurfaceTexture surfaceTexture, boolean z, zzaln zzaln) {
        super(surfaceTexture);
        this.zzc = zzalo;
    }

    public static synchronized boolean zza(Context context) {
        int i;
        synchronized (zzalp.class) {
            if (!zzb) {
                int i2 = 2;
                if (zzalh.zza >= 24) {
                    if (zzalh.zza < 26) {
                        if (!"samsung".equals(zzalh.zzc)) {
                            if ("XT1650".equals(zzalh.zzd)) {
                            }
                        }
                    }
                    if (zzalh.zza >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
                        String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                        if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                            if (zzalh.zza >= 17) {
                                String eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                                if (eglQueryString2 != null && eglQueryString2.contains("EGL_KHR_surfaceless_context")) {
                                    i2 = 1;
                                }
                            }
                            zza = i2;
                            zzb = true;
                        }
                    }
                }
                i2 = 0;
                zza = i2;
                zzb = true;
            }
            i = zza;
        }
        return i != 0;
    }

    public static zzalp zzb(Context context, boolean z) {
        int i = 0;
        boolean z2 = true;
        if (z && !zza(context)) {
            z2 = false;
        }
        zzajg.zzd(z2);
        zzalo zzalo = new zzalo();
        if (z) {
            i = zza;
        }
        return zzalo.zza(i);
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
