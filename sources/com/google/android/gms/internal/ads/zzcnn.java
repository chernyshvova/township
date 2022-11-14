package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.CollectionUtils;
import com.swrve.sdk.conversations.engine.model.UserInputResult;
import com.vungle.warren.analytics.AnalyticsEvent;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcnn extends zzbhf {
    public final zzciz zza;
    public final Object zzb = new Object();
    public final boolean zzc;
    public final boolean zzd;
    @GuardedBy("lock")
    public int zze;
    @GuardedBy("lock")
    public zzbhj zzf;
    @GuardedBy("lock")
    public boolean zzg;
    @GuardedBy("lock")
    public boolean zzh = true;
    @GuardedBy("lock")
    public float zzi;
    @GuardedBy("lock")
    public float zzj;
    @GuardedBy("lock")
    public float zzk;
    @GuardedBy("lock")
    public boolean zzl;
    @GuardedBy("lock")
    public boolean zzm;
    @GuardedBy("lock")
    public zzbnq zzn;

    public zzcnn(zzciz zzciz, float f, boolean z, boolean z2) {
        this.zza = zzciz;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzw(String str, @Nullable Map<String, String> map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("action", str);
        zzche.zze.execute(new zzcnl(this, hashMap));
    }

    private final void zzx(int i, int i2, boolean z, boolean z2) {
        zzche.zze.execute(new zzcnm(this, i, i2, z, z2));
    }

    public final void zzc(zzbiv zzbiv) {
        boolean z = zzbiv.zza;
        boolean z2 = zzbiv.zzb;
        boolean z3 = zzbiv.zzc;
        synchronized (this.zzb) {
            this.zzl = z2;
            this.zzm = z3;
        }
        zzw("initialState", CollectionUtils.mapOf("muteStart", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES, "customControlsRequested", true != z2 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES, "clickToExpandRequested", true != z3 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES));
    }

    public final void zzd(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    public final void zze() {
        zzw(UserInputResult.TYPE_VIDEO_PLAY, (Map<String, String>) null);
    }

    public final void zzf() {
        zzw("pause", (Map<String, String>) null);
    }

    public final void zzg(boolean z) {
        zzw(true != z ? AnalyticsEvent.C1956Ad.unmute : AnalyticsEvent.C1956Ad.mute, (Map<String, String>) null);
    }

    public final boolean zzh() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    public final int zzi() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    public final float zzj() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    public final float zzk() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    public final void zzl(zzbhj zzbhj) {
        synchronized (this.zzb) {
            this.zzf = zzbhj;
        }
    }

    public final float zzm() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    public final boolean zzn() {
        boolean z;
        synchronized (this.zzb) {
            z = false;
            if (this.zzc && this.zzl) {
                z = true;
            }
        }
        return z;
    }

    public final zzbhj zzo() throws RemoteException {
        zzbhj zzbhj;
        synchronized (this.zzb) {
            zzbhj = this.zzf;
        }
        return zzbhj;
    }

    public final boolean zzp() {
        boolean z;
        boolean zzn2 = zzn();
        synchronized (this.zzb) {
            z = false;
            if (!zzn2) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public final void zzq() {
        zzw("stop", (Map<String, String>) null);
    }

    public final void zzr() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzx(i, 3, z, z);
    }

    public final void zzs(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            z2 = true;
            if (f2 == this.zzi) {
                if (f3 == this.zzk) {
                    z2 = false;
                }
            }
            this.zzi = f2;
            this.zzj = f;
            z3 = this.zzh;
            this.zzh = z;
            i2 = this.zze;
            this.zze = i;
            float f4 = this.zzk;
            this.zzk = f3;
            if (Math.abs(f3 - f4) > 1.0E-4f) {
                this.zza.zzH().invalidate();
            }
        }
        if (z2) {
            try {
                zzbnq zzbnq = this.zzn;
                if (zzbnq != null) {
                    zzbnq.zze();
                }
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
        zzx(i2, i, z3, z);
    }

    public final /* synthetic */ void zzt(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3;
        boolean z4;
        zzbhj zzbhj;
        zzbhj zzbhj2;
        zzbhj zzbhj3;
        synchronized (this.zzb) {
            boolean z5 = this.zzg;
            boolean z6 = false;
            if (z5 || i2 != 1) {
                i3 = i2;
                z3 = false;
            } else {
                i3 = 1;
                z3 = true;
            }
            if (i == i2 || i3 != 1) {
                z4 = false;
            } else {
                i3 = 1;
                z4 = true;
            }
            boolean z7 = i != i2 && i3 == 2;
            boolean z8 = i != i2 && i3 == 3;
            if (z5 || z3) {
                z6 = true;
            }
            this.zzg = z6;
            if (z3) {
                try {
                    zzbhj zzbhj4 = this.zzf;
                    if (zzbhj4 != null) {
                        zzbhj4.zze();
                    }
                } catch (RemoteException e) {
                    zzcgs.zzl("#007 Could not call remote method.", e);
                }
            }
            if (z4 && (zzbhj3 = this.zzf) != null) {
                zzbhj3.zzf();
            }
            if (z7 && (zzbhj2 = this.zzf) != null) {
                zzbhj2.zzg();
            }
            if (z8) {
                zzbhj zzbhj5 = this.zzf;
                if (zzbhj5 != null) {
                    zzbhj5.zzh();
                }
                this.zza.zzA();
            }
            if (!(z == z2 || (zzbhj = this.zzf) == null)) {
                zzbhj.zzi(z2);
            }
        }
    }

    public final /* synthetic */ void zzu(Map map) {
        this.zza.zze("pubVideoCmd", map);
    }

    public final void zzv(zzbnq zzbnq) {
        synchronized (this.zzb) {
            this.zzn = zzbnq;
        }
    }
}
