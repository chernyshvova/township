package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavf extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
    public final int[] zza = new int[1];
    public Handler zzb;
    public SurfaceTexture zzc;
    public Error zzd;
    public RuntimeException zze;
    public zzavg zzf;

    public zzavf() {
        super("dummySurface");
    }

    public final boolean handleMessage(Message message) {
        Message message2 = message;
        int i = message2.what;
        if (i == 1) {
            try {
                boolean z = message2.arg1 != 0;
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                zzaul.zze(eglGetDisplay != null, "eglGetDisplay failed");
                int[] iArr = new int[2];
                zzaul.zze(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                EGLConfig[] eGLConfigArr2 = eGLConfigArr;
                zzaul.zze(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr2[0] != null, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr2[0];
                EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                zzaul.zze(eglCreateContext != null, "eglCreateContext failed");
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, z ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                zzaul.zze(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                zzaul.zze(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.zza, 0);
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.zza[0]);
                this.zzc = surfaceTexture;
                surfaceTexture.setOnFrameAvailableListener(this);
                this.zzf = new zzavg(this, this.zzc, z, (zzave) null);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e);
                this.zze = e;
                synchronized (this) {
                    notify();
                }
            } catch (Error e2) {
                try {
                    Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                    this.zzd = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
            return true;
        } else if (i == 2) {
            this.zzc.updateTexImage();
            return true;
        } else if (i != 3) {
            return true;
        } else {
            try {
                this.zzc.release();
                this.zzf = null;
                this.zzc = null;
                GLES20.glDeleteTextures(1, this.zza, 0);
            } catch (Throwable th2) {
                try {
                    Log.e("DummySurface", "Failed to release dummy surface", th2);
                } catch (Throwable th3) {
                    quit();
                    throw th3;
                }
            }
            quit();
            return true;
        }
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzb.sendEmptyMessage(2);
    }

    public final zzavg zza(boolean z) {
        boolean z2;
        start();
        this.zzb = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.zzb.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.zzf == null && this.zze == null && this.zzd == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zze;
        if (runtimeException == null) {
            Error error = this.zzd;
            if (error == null) {
                return this.zzf;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        this.zzb.sendEmptyMessage(3);
    }
}
