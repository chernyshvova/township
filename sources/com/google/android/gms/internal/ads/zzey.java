package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzey implements zzex {
    public static volatile zzfy zza;
    public MotionEvent zzb;
    public final LinkedList<MotionEvent> zzc = new LinkedList<>();
    public long zzd = 0;
    public long zze = 0;
    public long zzf = 0;
    public long zzg = 0;
    public long zzh = 0;
    public long zzi = 0;
    public long zzj = 0;
    public double zzk;
    public float zzl;
    public float zzm;
    public float zzn;
    public float zzo;
    public boolean zzp = false;
    public DisplayMetrics zzq;
    public double zzr;
    public double zzs;
    public boolean zzt = false;

    public zzey(Context context) {
        try {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbN)).booleanValue()) {
                zzeb.zza();
            } else {
                zzfz.zza(zza);
            }
            this.zzq = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final void zzm() {
        this.zzh = 0;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzj = 0;
        if (this.zzc.size() > 0) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        } else {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzb = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bc A[SYNTHETIC, Splitter:B:47:0x00bc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzn(android.content.Context r20, java.lang.String r21, int r22, android.view.View r23, android.app.Activity r24, byte[] r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r22
            r3 = r23
            r4 = r24
            long r5 = java.lang.System.currentTimeMillis()
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzbjn.zzbD
            com.google.android.gms.internal.ads.zzbjl r8 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r7 = r8.zzb(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzfy r10 = zza
            if (r10 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzfy r10 = zza
            com.google.android.gms.internal.ads.zzew r10 = r10.zzi()
            goto L_0x002e
        L_0x002d:
            r10 = r9
        L_0x002e:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r11 = com.google.android.gms.internal.ads.zzbjn.zzbN
            com.google.android.gms.internal.ads.zzbjl r12 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r11 = r12.zzb(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r8 == r11) goto L_0x0043
            java.lang.String r11 = "te"
            goto L_0x0048
        L_0x0043:
            java.lang.String r11 = "be"
            goto L_0x0048
        L_0x0046:
            r10 = r9
            r11 = r10
        L_0x0048:
            r15 = 2
            r14 = 3
            if (r2 != r14) goto L_0x005f
            com.google.android.gms.internal.ads.zzcn r9 = r1.zzb(r0, r3, r4)     // Catch:{ Exception -> 0x005c }
            r1.zzt = r8     // Catch:{ Exception -> 0x0057 }
            r0 = 1002(0x3ea, float:1.404E-42)
            r13 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0074
        L_0x0057:
            r0 = move-exception
            r18 = r0
            r8 = 3
            goto L_0x0091
        L_0x005c:
            r0 = move-exception
            r8 = 3
            goto L_0x008f
        L_0x005f:
            if (r2 != r15) goto L_0x006b
            com.google.android.gms.internal.ads.zzcn r0 = r1.zzc(r0, r3, r4)     // Catch:{ Exception -> 0x005c }
            r3 = 1008(0x3f0, float:1.413E-42)
            r9 = r0
            r13 = 1008(0x3f0, float:1.413E-42)
            goto L_0x0074
        L_0x006b:
            com.google.android.gms.internal.ads.zzcn r0 = r1.zza(r0, r9)     // Catch:{ Exception -> 0x005c }
            r3 = 1000(0x3e8, float:1.401E-42)
            r9 = r0
            r13 = 1000(0x3e8, float:1.401E-42)
        L_0x0074:
            if (r7 == 0) goto L_0x008c
            if (r10 == 0) goto L_0x008c
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005c }
            long r3 = r3 - r5
            r0 = -1
            r18 = 0
            r12 = r10
            r8 = 3
            r14 = r0
            r15 = r3
            r17 = r11
            r12.zza(r13, r14, r15, r17, r18)     // Catch:{ Exception -> 0x008a }
            goto L_0x008d
        L_0x008a:
            r0 = move-exception
            goto L_0x008f
        L_0x008c:
            r8 = 3
        L_0x008d:
            r3 = 2
            goto L_0x00b6
        L_0x008f:
            r18 = r0
        L_0x0091:
            if (r7 == 0) goto L_0x008d
            if (r10 == 0) goto L_0x008d
            if (r2 != r8) goto L_0x009d
            r0 = 1003(0x3eb, float:1.406E-42)
            r3 = 2
            r13 = 1003(0x3eb, float:1.406E-42)
            goto L_0x00aa
        L_0x009d:
            r3 = 2
            if (r2 != r3) goto L_0x00a5
            r0 = 1009(0x3f1, float:1.414E-42)
            r13 = 1009(0x3f1, float:1.414E-42)
            goto L_0x00aa
        L_0x00a5:
            r0 = 1001(0x3e9, float:1.403E-42)
            r2 = 1
            r13 = 1001(0x3e9, float:1.403E-42)
        L_0x00aa:
            r14 = -1
            long r15 = java.lang.System.currentTimeMillis()
            long r15 = r15 - r5
            r12 = r10
            r17 = r11
            r12.zza(r13, r14, r15, r17, r18)
        L_0x00b6:
            long r4 = java.lang.System.currentTimeMillis()
            if (r9 == 0) goto L_0x00fd
            com.google.android.gms.internal.ads.zzgec r0 = r9.zzah()     // Catch:{ Exception -> 0x0103 }
            com.google.android.gms.internal.ads.zzdc r0 = (com.google.android.gms.internal.ads.zzdc) r0     // Catch:{ Exception -> 0x0103 }
            int r0 = r0.zzaw()     // Catch:{ Exception -> 0x0103 }
            if (r0 != 0) goto L_0x00c9
            goto L_0x00fd
        L_0x00c9:
            com.google.android.gms.internal.ads.zzgec r0 = r9.zzah()     // Catch:{ Exception -> 0x0103 }
            com.google.android.gms.internal.ads.zzdc r0 = (com.google.android.gms.internal.ads.zzdc) r0     // Catch:{ Exception -> 0x0103 }
            r6 = r21
            java.lang.String r0 = com.google.android.gms.internal.ads.zzeb.zzb(r0, r6)     // Catch:{ Exception -> 0x0103 }
            if (r7 == 0) goto L_0x012e
            if (r10 == 0) goto L_0x012e
            if (r2 != r8) goto L_0x00e0
            r6 = 1006(0x3ee, float:1.41E-42)
            r13 = 1006(0x3ee, float:1.41E-42)
            goto L_0x00eb
        L_0x00e0:
            if (r2 != r3) goto L_0x00e7
            r6 = 1010(0x3f2, float:1.415E-42)
            r13 = 1010(0x3f2, float:1.415E-42)
            goto L_0x00eb
        L_0x00e7:
            r6 = 1004(0x3ec, float:1.407E-42)
            r13 = 1004(0x3ec, float:1.407E-42)
        L_0x00eb:
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0103 }
            long r16 = r14 - r4
            r14 = -1
            r18 = 0
            r12 = r10
            r15 = r16
            r17 = r11
            r12.zza(r13, r14, r15, r17, r18)     // Catch:{ Exception -> 0x0103 }
            goto L_0x012e
        L_0x00fd:
            r0 = 5
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x0103 }
            goto L_0x012e
        L_0x0103:
            r0 = move-exception
            r18 = r0
            r0 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)
            if (r7 == 0) goto L_0x012e
            if (r10 == 0) goto L_0x012e
            if (r2 != r8) goto L_0x0116
            r2 = 1007(0x3ef, float:1.411E-42)
            r13 = 1007(0x3ef, float:1.411E-42)
            goto L_0x0121
        L_0x0116:
            if (r2 != r3) goto L_0x011d
            r2 = 1011(0x3f3, float:1.417E-42)
            r13 = 1011(0x3f3, float:1.417E-42)
            goto L_0x0121
        L_0x011d:
            r2 = 1005(0x3ed, float:1.408E-42)
            r13 = 1005(0x3ed, float:1.408E-42)
        L_0x0121:
            r14 = -1
            long r2 = java.lang.System.currentTimeMillis()
            long r15 = r2 - r4
            r12 = r10
            r17 = r11
            r12.zza(r13, r14, r15, r17, r18)
        L_0x012e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzey.zzn(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    public abstract zzcn zza(Context context, zzce zzce);

    public abstract zzcn zzb(Context context, View view, Activity activity);

    public abstract zzcn zzc(Context context, View view, Activity activity);

    public final void zzd(MotionEvent motionEvent) {
        Long l;
        if (this.zzt) {
            zzm();
            this.zzt = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = RoundRectDrawableWithShadow.COS_45;
            this.zzr = (double) motionEvent.getRawX();
            this.zzs = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d = this.zzr;
            Double.isNaN(rawX);
            double d2 = rawX - d;
            double d3 = this.zzs;
            Double.isNaN(rawY);
            double d4 = rawY - d3;
            this.zzk = Math.sqrt((d4 * d4) + (d2 * d2)) + this.zzk;
            this.zzr = rawX;
            this.zzs = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzb = obtain;
            this.zzc.add(obtain);
            if (this.zzc.size() > 6) {
                this.zzc.remove().recycle();
            }
            this.zzf++;
            this.zzh = zzl(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zze += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzga zzk2 = zzk(motionEvent);
                Long l2 = zzk2.zzd;
                if (!(l2 == null || zzk2.zzg == null)) {
                    this.zzi = l2.longValue() + zzk2.zzg.longValue() + this.zzi;
                }
                if (!(this.zzq == null || (l = zzk2.zze) == null || zzk2.zzh == null)) {
                    this.zzj = l.longValue() + zzk2.zzh.longValue() + this.zzj;
                }
            } catch (zzfp unused) {
            }
        } else if (action2 == 3) {
            this.zzg++;
        }
        this.zzp = true;
    }

    public final void zze(int i, int i2, int i3) {
        MotionEvent motionEvent;
        if (this.zzb != null) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbB)).booleanValue()) {
                zzm();
            } else {
                this.zzb.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzq;
        if (displayMetrics != null) {
            float f = displayMetrics.density;
            motionEvent = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * f, ((float) i2) * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            motionEvent = null;
        }
        this.zzb = motionEvent;
        this.zzp = false;
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        return zzn(context, str, 3, view, activity, (byte[]) null);
    }

    public final String zzg(Context context, String str, View view) {
        return zzn(context, str, 3, view, (Activity) null, (byte[]) null);
    }

    public void zzh(View view) {
    }

    public final String zzi(Context context, View view, Activity activity) {
        return zzn(context, (String) null, 2, view, (Activity) null, (byte[]) null);
    }

    public final String zzj(Context context) {
        if (!zzgb.zzf()) {
            return zzn(context, (String) null, 1, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public abstract zzga zzk(MotionEvent motionEvent) throws zzfp;

    public abstract long zzl(StackTraceElement[] stackTraceElementArr) throws zzfp;
}
