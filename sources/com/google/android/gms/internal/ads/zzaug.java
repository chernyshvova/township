package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.internal.ads.zzauh;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaug<T extends zzauh> extends Handler implements Runnable {
    public final int zza;
    public final /* synthetic */ zzauj zzb;
    public final T zzc;
    public final zzauf<T> zzd;
    public final long zze;
    public IOException zzf;
    public int zzg;
    public volatile Thread zzh;
    public volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaug(zzauj zzauj, Looper looper, T t, zzauf<T> zzauf, int i, long j) {
        super(looper);
        this.zzb = zzauj;
        this.zzc = t;
        this.zzd = zzauf;
        this.zza = i;
        this.zze = j;
    }

    private final void zzd() {
        this.zzf = null;
        this.zzb.zza.execute(this.zzb.zzb);
    }

    public final void handleMessage(Message message) {
        if (!this.zzi) {
            int i = message.what;
            if (i == 0) {
                zzd();
            } else if (i != 4) {
                zzaug unused = this.zzb.zzb = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.zze;
                if (this.zzc.zzc()) {
                    this.zzd.zzr(this.zzc, elapsedRealtime, j, false);
                    return;
                }
                int i2 = message.what;
                int i3 = 1;
                if (i2 == 1) {
                    this.zzd.zzr(this.zzc, elapsedRealtime, j, false);
                } else if (i2 == 2) {
                    this.zzd.zzs(this.zzc, elapsedRealtime, j);
                } else if (i2 == 3) {
                    IOException iOException = (IOException) message.obj;
                    this.zzf = iOException;
                    int zzq = this.zzd.zzq(this.zzc, elapsedRealtime, j, iOException);
                    if (zzq == 3) {
                        IOException unused2 = this.zzb.zzc = this.zzf;
                    } else if (zzq != 2) {
                        if (zzq != 1) {
                            i3 = 1 + this.zzg;
                        }
                        this.zzg = i3;
                        zzb((long) Math.min((i3 - 1) * 1000, 5000));
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        String str;
        try {
            this.zzh = Thread.currentThread();
            if (!this.zzc.zzc()) {
                String simpleName = this.zzc.getClass().getSimpleName();
                if (simpleName.length() != 0) {
                    str = "load:".concat(simpleName);
                } else {
                    str = new String("load:");
                }
                zzauy.zza(str);
                this.zzc.zzd();
                zzauy.zzb();
            }
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException unused) {
            zzaul.zzd(this.zzc.zzc());
            if (!this.zzi) {
                sendEmptyMessage(2);
            }
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (!this.zzi) {
                obtainMessage(3, new zzaui(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (!this.zzi) {
                obtainMessage(3, new zzaui(e3)).sendToTarget();
            }
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.zzi) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            zzauy.zzb();
            throw th;
        }
    }

    public final void zza(int i) throws IOException {
        IOException iOException = this.zzf;
        if (iOException != null && this.zzg > i) {
            throw iOException;
        }
    }

    public final void zzb(long j) {
        zzaul.zzd(this.zzb.zzb == null);
        zzaug unused = this.zzb.zzb = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zzf = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
                return;
            }
        } else {
            this.zzc.zzb();
            if (this.zzh != null) {
                this.zzh.interrupt();
            }
            if (!z) {
                return;
            }
        }
        zzaug unused = this.zzb.zzb = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.zzd.zzr(this.zzc, elapsedRealtime, elapsedRealtime - this.zze, true);
    }
}
