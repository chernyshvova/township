package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.playrix.engine.EglContextManager;

@RequiresApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzajo implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int[] zza = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    public final Handler zzb;
    public final int[] zzc = new int[1];
    @Nullable
    public EGLDisplay zzd;
    @Nullable
    public EGLContext zze;
    @Nullable
    public EGLSurface zzf;
    @Nullable
    public SurfaceTexture zzg;

    public zzajo(Handler handler, @Nullable zzajn zzajn) {
        this.zzb = handler;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzb.post(this);
    }

    public final void run() {
        SurfaceTexture surfaceTexture = this.zzg;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }

    public final void zza(int i) {
        EGLConfig eGLConfig;
        EGLSurface eGLSurface;
        String str;
        int[] iArr;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr2 = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr2, 0, iArr2, 1)) {
                this.zzd = eglGetDisplay;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr3 = new int[1];
                boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, zza, 0, eGLConfigArr, 0, 1, iArr3, 0);
                if (!eglChooseConfig || iArr3[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
                    throw new zzajm(zzalh.zzv("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr3[0]), eGLConfigArr[0]), (zzajl) null);
                }
                EGLContext eglCreateContext = EGL14.eglCreateContext(this.zzd, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{EglContextManager.EGL_CONTEXT_CLIENT_VERSION, 2, 12344} : new int[]{EglContextManager.EGL_CONTEXT_CLIENT_VERSION, 2, 12992, 1, 12344}, 0);
                if (eglCreateContext != null) {
                    this.zze = eglCreateContext;
                    EGLDisplay eGLDisplay = this.zzd;
                    if (i == 1) {
                        eGLSurface = EGL14.EGL_NO_SURFACE;
                    } else {
                        if (i == 2) {
                            iArr = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                        } else {
                            iArr = new int[]{12375, 1, 12374, 1, 12344};
                        }
                        eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr, 0);
                        if (eGLSurface == null) {
                            throw new zzajm("eglCreatePbufferSurface failed", (zzajl) null);
                        }
                    }
                    if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eglCreateContext)) {
                        this.zzf = eGLSurface;
                        GLES20.glGenTextures(1, this.zzc, 0);
                        while (true) {
                            int glGetError = GLES20.glGetError();
                            if (glGetError != 0) {
                                String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
                                if (valueOf.length() != 0) {
                                    str = "glError ".concat(valueOf);
                                } else {
                                    str = new String("glError ");
                                }
                                Log.e("GlUtil", str);
                            } else {
                                SurfaceTexture surfaceTexture = new SurfaceTexture(this.zzc[0]);
                                this.zzg = surfaceTexture;
                                surfaceTexture.setOnFrameAvailableListener(this);
                                return;
                            }
                        }
                    } else {
                        throw new zzajm("eglMakeCurrent failed", (zzajl) null);
                    }
                } else {
                    throw new zzajm("eglCreateContext failed", (zzajl) null);
                }
            } else {
                throw new zzajm("eglInitialize failed", (zzajl) null);
            }
        } else {
            throw new zzajm("eglGetDisplay failed", (zzajl) null);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void zzb() {
        this.zzb.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.zzg;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.zzc, 0);
            }
            EGLDisplay eGLDisplay = this.zzd;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.zzd;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.zzf;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.zzd, this.zzf);
            }
            EGLContext eGLContext = this.zze;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.zzd, eGLContext);
            }
            if (zzalh.zza >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.zzd;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.zzd);
            }
            this.zzd = null;
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
        } catch (Throwable th) {
            EGLDisplay eGLDisplay4 = this.zzd;
            if (eGLDisplay4 != null && !eGLDisplay4.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay5 = this.zzd;
                EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay5, eGLSurface3, eGLSurface3, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface4 = this.zzf;
            if (eGLSurface4 != null && !eGLSurface4.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.zzd, this.zzf);
            }
            EGLContext eGLContext2 = this.zze;
            if (eGLContext2 != null) {
                EGL14.eglDestroyContext(this.zzd, eGLContext2);
            }
            if (zzalh.zza >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay6 = this.zzd;
            if (eGLDisplay6 != null && !eGLDisplay6.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.zzd);
            }
            this.zzd = null;
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            throw th;
        }
    }

    public final SurfaceTexture zzc() {
        SurfaceTexture surfaceTexture = this.zzg;
        if (surfaceTexture != null) {
            return surfaceTexture;
        }
        throw null;
    }
}
