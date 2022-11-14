package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.internal.ServerProtocol;
import com.vungle.warren.VisionController;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzama {
    public final zzalr zza = new zzalr();
    @Nullable
    public final WindowManager zzb;
    @Nullable
    public final zzalz zzc;
    @Nullable
    public final zzaly zzd;
    public boolean zze;
    @Nullable
    public Surface zzf;
    public float zzg;
    public float zzh;
    public float zzi;
    public float zzj;
    public long zzk;
    public long zzl;
    public long zzm;
    public long zzn;
    public long zzo;
    public long zzp;
    public long zzq;

    public zzama(@Nullable Context context) {
        zzaly zzaly = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.zzb = (WindowManager) context.getSystemService(VisionController.WINDOW);
        } else {
            this.zzb = null;
        }
        if (this.zzb != null) {
            if (zzalh.zza >= 17) {
                if (context != null) {
                    DisplayManager displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
                    if (displayManager != null) {
                        zzaly = new zzaly(this, displayManager);
                    }
                } else {
                    throw null;
                }
            }
            this.zzd = zzaly;
            this.zzc = zzalz.zza();
        } else {
            this.zzd = null;
            this.zzc = null;
        }
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzg = -1.0f;
        this.zzj = 1.0f;
    }

    private final void zzl() {
        this.zzm = 0;
        this.zzp = -1;
        this.zzn = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (java.lang.Math.abs(r0 - r9.zzh) >= r2) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        if (r9.zza.zzd() >= 30) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzm() {
        /*
            r9 = this;
            int r0 = com.google.android.gms.internal.ads.zzalh.zza
            r1 = 30
            if (r0 < r1) goto L_0x006f
            android.view.Surface r0 = r9.zzf
            if (r0 != 0) goto L_0x000b
            goto L_0x006f
        L_0x000b:
            com.google.android.gms.internal.ads.zzalr r0 = r9.zza
            boolean r0 = r0.zzc()
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzalr r0 = r9.zza
            float r0 = r0.zzg()
            goto L_0x001c
        L_0x001a:
            float r0 = r9.zzg
        L_0x001c:
            float r2 = r9.zzh
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0023
            return
        L_0x0023:
            r3 = 1
            r4 = 0
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r6 == 0) goto L_0x0058
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzalr r1 = r9.zza
            boolean r1 = r1.zzc()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzalr r1 = r9.zza
            long r5 = r1.zze()
            r7 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x004b
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L_0x004b:
            float r1 = r9.zzh
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0065
            goto L_0x0066
        L_0x0058:
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzalr r2 = r9.zza
            int r2 = r2.zzd()
            if (r2 < r1) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            if (r3 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            return
        L_0x006a:
            r9.zzh = r0
            r9.zzn(r4)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzama.zzm():void");
    }

    private final void zzn(boolean z) {
        Surface surface;
        if (zzalh.zza >= 30 && (surface = this.zzf) != null) {
            float f = 0.0f;
            if (this.zze) {
                float f2 = this.zzh;
                if (f2 != -1.0f) {
                    f = this.zzj * f2;
                }
            }
            if (z || this.zzi != f) {
                this.zzi = f;
                zzp(surface, f);
            }
        }
    }

    private final void zzo() {
        Surface surface;
        if (zzalh.zza >= 30 && (surface = this.zzf) != null && this.zzi != 0.0f) {
            this.zzi = 0.0f;
            zzp(surface, 0.0f);
        }
    }

    @RequiresApi(30)
    public static void zzp(Surface surface, float f) {
        try {
            surface.setFrameRate(f, f == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            zzaka.zzb("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }

    /* access modifiers changed from: private */
    public final void zzq() {
        WindowManager windowManager = this.zzb;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (defaultDisplay != null) {
                double refreshRate = (double) defaultDisplay.getRefreshRate();
                Double.isNaN(refreshRate);
                long j = (long) (1.0E9d / refreshRate);
                this.zzk = j;
                this.zzl = (j * 80) / 100;
                return;
            }
            Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.zzk = -9223372036854775807L;
            this.zzl = -9223372036854775807L;
            return;
        }
        throw null;
    }

    @TargetApi(17)
    public final void zza() {
        if (this.zzb != null) {
            zzalz zzalz = this.zzc;
            if (zzalz != null) {
                zzalz.zzb();
                zzaly zzaly = this.zzd;
                if (zzaly != null) {
                    zzaly.zza();
                }
                zzq();
                return;
            }
            throw null;
        }
    }

    public final void zzb() {
        this.zze = true;
        zzl();
        zzn(false);
    }

    public final void zzc(@Nullable Surface surface) {
        if (true == (surface instanceof zzalp)) {
            surface = null;
        }
        if (this.zzf != surface) {
            zzo();
            this.zzf = surface;
            zzn(true);
        }
    }

    public final void zzd() {
        zzl();
    }

    public final void zze(float f) {
        this.zzj = f;
        zzl();
        zzn(false);
    }

    public final void zzf(float f) {
        this.zzg = f;
        this.zza.zza();
        zzm();
    }

    public final void zzg(long j) {
        long j2 = this.zzn;
        if (j2 != -1) {
            this.zzp = j2;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zzb(j * 1000);
        zzm();
    }

    public final void zzh() {
        this.zze = false;
        zzo();
    }

    @TargetApi(17)
    public final void zzi() {
        if (this.zzb != null) {
            zzaly zzaly = this.zzd;
            if (zzaly != null) {
                zzaly.zzb();
            }
            zzalz zzalz = this.zzc;
            if (zzalz != null) {
                zzalz.zzc();
                return;
            }
            throw null;
        }
    }

    public final long zzj(long j) {
        long j2;
        if (this.zzp != -1 && this.zza.zzc()) {
            long zzf2 = this.zzq + ((long) (((float) ((this.zzm - this.zzp) * this.zza.zzf())) / this.zzj));
            if (Math.abs(j - zzf2) <= 20000000) {
                j = zzf2;
            } else {
                zzl();
            }
        }
        this.zzn = this.zzm;
        this.zzo = j;
        zzalz zzalz = this.zzc;
        if (zzalz == null || this.zzk == -9223372036854775807L) {
            return j;
        }
        long j3 = zzalz.zza;
        if (j3 == -9223372036854775807L) {
            return j;
        }
        long j4 = this.zzk;
        long j5 = (((j - j3) / j4) * j4) + j3;
        if (j <= j5) {
            j2 = j5 - j4;
        } else {
            j2 = j5;
            j5 = j4 + j5;
        }
        if (j5 - j >= j - j2) {
            j5 = j2;
        }
        return j5 - this.zzl;
    }
}
