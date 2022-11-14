package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

@RequiresApi(23)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalv implements Handler.Callback, zzaaf {
    public final /* synthetic */ zzalw zza;
    public final Handler zzb;

    public zzalv(zzalw zzalw, zzabb zzabb, byte[] bArr) {
        this.zza = zzalw;
        Handler zzh = zzalh.zzh(this);
        this.zzb = zzh;
        zzabb.zzl(this, zzh);
    }

    private final void zzb(long j) {
        zzalw zzalw = this.zza;
        if (this == zzalw.zzb) {
            if (j != RecyclerView.FOREVER_NS) {
                try {
                    zzalw.zzZ(j);
                } catch (zzio e) {
                    this.zza.zzaj(e);
                }
            } else {
                zzalw.zzav();
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        zzb(zzalh.zzJ(message.arg1, message.arg2));
        return true;
    }

    public final void zza(zzabb zzabb, long j, long j2) {
        if (zzalh.zza < 30) {
            this.zzb.sendMessageAtFrontOfQueue(Message.obtain(this.zzb, 0, (int) (j >> 32), (int) j));
            return;
        }
        zzb(j);
    }
}
