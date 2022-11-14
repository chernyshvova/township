package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaiv;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaiu<T extends zzaiv> extends Handler implements Runnable {
    public final /* synthetic */ zzaiz zza;
    public final T zzb;
    public final long zzc;
    @Nullable
    public zzais<T> zzd;
    @Nullable
    public IOException zze;
    public int zzf;
    @Nullable
    public Thread zzg;
    public boolean zzh;
    public volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaiu(zzaiz zzaiz, Looper looper, T t, zzais<T> zzais, int i, long j) {
        super(looper);
        this.zza = zzaiz;
        this.zzb = t;
        this.zzd = zzais;
        this.zzc = j;
    }

    private final void zzd() {
        this.zze = null;
        ExecutorService zzl = this.zza.zze;
        zzaiu zzi2 = this.zza.zzf;
        if (zzi2 != null) {
            zzl.execute(zzi2);
            return;
        }
        throw null;
    }

    public final void handleMessage(Message message) {
        long j;
        if (!this.zzi) {
            int i = message.what;
            if (i == 0) {
                zzd();
            } else if (i != 3) {
                zzaiu unused = this.zza.zzf = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime - this.zzc;
                zzais<T> zzais = this.zzd;
                if (zzais == null) {
                    throw null;
                } else if (this.zzh) {
                    zzais.zzy(this.zzb, elapsedRealtime, j2, false);
                } else {
                    int i2 = message.what;
                    if (i2 == 1) {
                        try {
                            zzais.zzz(this.zzb, elapsedRealtime, j2);
                        } catch (RuntimeException e) {
                            zzaka.zzb("LoadTask", "Unexpected exception handling load completed", e);
                            IOException unused2 = this.zza.zzg = new zzaiy(e);
                        }
                    } else if (i2 == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.zze = iOException;
                        int i3 = this.zzf + 1;
                        this.zzf = i3;
                        zzait zzx = zzais.zzx(this.zzb, elapsedRealtime, j2, iOException, i3);
                        if (zzx.zza == 3) {
                            IOException unused3 = this.zza.zzg = this.zze;
                        } else if (zzx.zza != 2) {
                            if (zzx.zza == 1) {
                                this.zzf = 1;
                            }
                            if (zzx.zzb != -9223372036854775807L) {
                                j = zzx.zzb;
                            } else {
                                j = (long) Math.min((this.zzf - 1) * 1000, 5000);
                            }
                            zzb(j);
                        }
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z;
        String str;
        try {
            synchronized (this) {
                z = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z) {
                String simpleName = this.zzb.getClass().getSimpleName();
                if (simpleName.length() != 0) {
                    str = "load:".concat(simpleName);
                } else {
                    str = new String("load:");
                }
                zzalf.zza(str);
                this.zzb.zzc();
                zzalf.zzb();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(2, e).sendToTarget();
            }
        } catch (Exception e2) {
            if (!this.zzi) {
                zzaka.zzb("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new zzaiy(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.zzi) {
                zzaka.zzb("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new zzaiy(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.zzi) {
                zzaka.zzb("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzalf.zzb();
            throw th;
        }
    }

    public final void zza(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzb(long j) {
        zzajg.zzd(this.zza.zzf == null);
        zzaiu unused = this.zza.zzf = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzb();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            zzaiu unused = this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzais<T> zzais = this.zzd;
            if (zzais != null) {
                zzais.zzy(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
                this.zzd = null;
                return;
            }
            throw null;
        }
    }
}
