package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalo extends HandlerThread implements Handler.Callback {
    public zzajo zza;
    public Handler zzb;
    @Nullable
    public Error zzc;
    @Nullable
    public RuntimeException zzd;
    @Nullable
    public zzalp zze;

    public zzalo() {
        super("ExoPlayer:DummySurface");
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            try {
                int i2 = message.arg1;
                zzajo zzajo = this.zza;
                if (zzajo != null) {
                    zzajo.zza(i2);
                    this.zze = new zzalp(this, this.zza.zzc(), i2 != 0, (zzaln) null);
                    synchronized (this) {
                        notify();
                    }
                    return true;
                }
                throw null;
            } catch (RuntimeException e) {
                zzaka.zzb("DummySurface", "Failed to initialize dummy surface", e);
                this.zzd = e;
                synchronized (this) {
                    notify();
                }
            } catch (Error e2) {
                try {
                    zzaka.zzb("DummySurface", "Failed to initialize dummy surface", e2);
                    this.zzc = e2;
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
        } else if (i != 2) {
            return true;
        } else {
            try {
                zzajo zzajo2 = this.zza;
                if (zzajo2 != null) {
                    zzajo2.zzb();
                    quit();
                    return true;
                }
                throw null;
            } catch (Throwable th2) {
                quit();
                throw th2;
            }
        }
    }

    public final zzalp zza(int i) {
        boolean z;
        start();
        Handler handler = new Handler(getLooper(), this);
        this.zzb = handler;
        this.zza = new zzajo(handler, (zzajn) null);
        synchronized (this) {
            z = false;
            this.zzb.obtainMessage(1, i, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException == null) {
            Error error = this.zzc;
            if (error == null) {
                zzalp zzalp = this.zze;
                if (zzalp != null) {
                    return zzalp;
                }
                throw null;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        if (handler != null) {
            handler.sendEmptyMessage(2);
            return;
        }
        throw null;
    }
}
