package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadi implements zzaeg {
    public final zzahs zza;
    public final SparseArray<zzaeg> zzb;
    public final int[] zzc;

    public zzadi(zzahs zzahs, zztg zztg) {
        Class<zzahs> cls = zzahs.class;
        Class<zzaeg> cls2 = zzaeg.class;
        this.zza = zzahs;
        SparseArray<zzaeg> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (zzaeg) Class.forName("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{zzahs}));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (zzaeg) Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{zzahs}));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (zzaeg) Class.forName("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{zzahs}));
        } catch (Exception unused3) {
        }
        try {
            sparseArray.put(3, (zzaeg) Class.forName("com.google.android.exoplayer2.source.rtsp.RtspMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception unused4) {
        }
        sparseArray.put(4, new zzaez(zzahs, zztg));
        this.zzb = sparseArray;
        this.zzc = new int[sparseArray.size()];
        for (int i = 0; i < this.zzb.size(); i++) {
            this.zzc[i] = this.zzb.keyAt(i);
        }
    }
}
