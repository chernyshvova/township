package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagn extends zzagz {
    public boolean zzA;
    public zzfml<String> zzB;
    public boolean zzC;
    public boolean zzD;
    public boolean zzE;
    public boolean zzF;
    public boolean zzG;
    public final SparseArray<Map<zzaft, zzagp>> zzH;
    public final SparseBooleanArray zzI;
    public int zzg;
    public int zzh;
    public int zzi;
    public int zzj;
    public int zzk;
    public int zzl;
    public int zzm;
    public int zzn;
    public boolean zzo;
    public boolean zzp;
    public boolean zzq;
    public int zzr;
    public int zzs;
    public boolean zzt;
    public zzfml<String> zzu;
    public int zzv;
    public int zzw;
    public boolean zzx;
    public boolean zzy;
    public boolean zzz;

    @Deprecated
    public zzagn() {
        zzc();
        this.zzH = new SparseArray<>();
        this.zzI = new SparseBooleanArray();
    }

    @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioMimeTypes"})
    private final void zzc() {
        this.zzg = Integer.MAX_VALUE;
        this.zzh = Integer.MAX_VALUE;
        this.zzi = Integer.MAX_VALUE;
        this.zzj = Integer.MAX_VALUE;
        this.zzo = true;
        this.zzp = false;
        this.zzq = true;
        this.zzr = Integer.MAX_VALUE;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = true;
        this.zzu = zzfml.zzi();
        this.zzv = Integer.MAX_VALUE;
        this.zzw = Integer.MAX_VALUE;
        this.zzx = true;
        this.zzy = false;
        this.zzz = false;
        this.zzA = false;
        this.zzB = zzfml.zzi();
        this.zzC = false;
        this.zzD = false;
        this.zzE = true;
        this.zzF = false;
        this.zzG = true;
    }

    public final zzagn zza(int i, boolean z) {
        if (this.zzI.get(i) == z) {
            return this;
        }
        if (z) {
            this.zzI.put(i, true);
        } else {
            this.zzI.delete(i);
        }
        return this;
    }

    public final zzagm zzb() {
        return new zzagm(this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu, this.zza, this.zzb, this.zzv, this.zzw, this.zzx, this.zzy, this.zzz, this.zzA, this.zzB, this.zzc, this.zzd, this.zze, this.zzf, this.zzC, this.zzD, this.zzE, this.zzF, this.zzG, this.zzH, this.zzI);
    }

    public zzagn(Context context) {
        CaptioningManager captioningManager;
        int i = zzalh.zza;
        if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
            this.zzd = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzc = zzfml.zzj(zzalh.zzp(locale));
            }
        }
        zzc();
        this.zzH = new SparseArray<>();
        this.zzI = new SparseBooleanArray();
        Point zzW = zzalh.zzW(context);
        int i2 = zzW.x;
        int i3 = zzW.y;
        this.zzr = i2;
        this.zzs = i3;
        this.zzt = true;
    }

    public /* synthetic */ zzagn(zzagm zzagm, zzagi zzagi) {
        super(zzagm);
        this.zzg = zzagm.zzb;
        this.zzh = zzagm.zzc;
        this.zzi = zzagm.zzd;
        this.zzj = zzagm.zze;
        this.zzk = zzagm.zzf;
        this.zzl = zzagm.zzg;
        this.zzm = zzagm.zzh;
        this.zzn = zzagm.zzi;
        this.zzo = zzagm.zzj;
        this.zzp = zzagm.zzk;
        this.zzq = zzagm.zzl;
        this.zzr = zzagm.zzm;
        this.zzs = zzagm.zzn;
        this.zzt = zzagm.zzo;
        this.zzu = zzagm.zzp;
        this.zzv = zzagm.zzq;
        this.zzw = zzagm.zzr;
        this.zzx = zzagm.zzs;
        this.zzy = zzagm.zzt;
        this.zzz = zzagm.zzu;
        this.zzA = zzagm.zzv;
        this.zzB = zzagm.zzw;
        this.zzC = zzagm.zzx;
        this.zzD = zzagm.zzy;
        this.zzE = zzagm.zzz;
        this.zzF = zzagm.zzA;
        this.zzG = zzagm.zzB;
        SparseArray zzf = zzagm.zzK;
        SparseArray<Map<zzaft, zzagp>> sparseArray = new SparseArray<>();
        for (int i = 0; i < zzf.size(); i++) {
            sparseArray.put(zzf.keyAt(i), new HashMap((Map) zzf.valueAt(i)));
        }
        this.zzH = sparseArray;
        this.zzI = zzagm.zzL.clone();
    }
}
