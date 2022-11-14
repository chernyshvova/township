package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckg extends zzciq implements zzauk, zzasi, zzavu, zzaoh, zzamx {
    public static final /* synthetic */ int zzc = 0;
    public final Context zzd;
    public final zzcjw zze;
    public final zzanp zzf;
    public final zzanp zzg;
    public final zzatm zzh;
    public final zzciy zzi;
    public zzana zzj;
    public ByteBuffer zzk;
    public boolean zzl;
    public final WeakReference<zzciz> zzm;
    public zzcip zzn;
    public int zzo;
    public int zzp;
    public long zzq;
    public final String zzr;
    public final int zzs;
    public final ArrayList<zzaue> zzt;
    public volatile zzcjv zzu;
    public final Set<WeakReference<zzcjs>> zzv = new HashSet();

    public zzckg(Context context, zzciy zzciy, zzciz zzciz) {
        this.zzd = context;
        this.zzi = zzciy;
        this.zzm = new WeakReference<>(zzciz);
        this.zze = new zzcjw();
        this.zzf = new zzavj(this.zzd, zzarg.zza, 0, zzr.zza, this, -1);
        this.zzg = new zzaou(zzarg.zza, (zzapi) null, true, zzr.zza, this);
        this.zzh = new zzati((zzatn) null);
        if (zze.zzc()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 34);
            sb.append("ForkedExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zze.zza(sb.toString());
        }
        zzciq.zza.incrementAndGet();
        int i = 0;
        zzana zza = zzanb.zza(new zzanp[]{this.zzg, this.zzf}, this.zzh, this.zze);
        this.zzj = zza;
        zza.zza(this);
        this.zzo = 0;
        this.zzq = 0;
        this.zzp = 0;
        this.zzt = new ArrayList<>();
        this.zzu = null;
        this.zzr = (zzciz == null || zzciz.zzn() == null) ? "" : zzciz.zzn();
        this.zzs = zzciz != null ? zzciz.zzp() : i;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzn)).booleanValue()) {
            this.zzj.zzo();
        }
        if (zzciz != null && zzciz.zzD() > 0) {
            this.zzj.zzp(zzciz.zzD());
        }
        if (zzciz != null && zzciz.zzE() > 0) {
            this.zzj.zzq(zzciz.zzE());
        }
    }

    private final boolean zzw() {
        return this.zzu != null && this.zzu.zzf();
    }

    public final void finalize() throws Throwable {
        zzciq.zza.decrementAndGet();
        if (zze.zzc()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 32);
            sb.append("ForkedExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zze.zza(sb.toString());
        }
    }

    public final void zzN(Uri[] uriArr, String str) {
        zzO(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzO(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzasn zzasn;
        if (this.zzj != null) {
            this.zzk = byteBuffer;
            this.zzl = z;
            int length = uriArr.length;
            if (length == 1) {
                zzasn = zzr(uriArr[0], str);
            } else {
                zzasn[] zzasnArr = new zzasn[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzasnArr[i] = zzr(uriArr[i], str);
                }
                zzasn = new zzasr(zzasnArr);
            }
            this.zzj.zzd(zzasn);
            zzciq.zzb.incrementAndGet();
        }
    }

    public final void zzP(zzcip zzcip) {
        this.zzn = zzcip;
    }

    public final void zzQ() {
        zzana zzana = this.zzj;
        if (zzana != null) {
            zzana.zzb(this);
            this.zzj.zzi();
            this.zzj = null;
            zzciq.zzb.decrementAndGet();
        }
    }

    public final void zzR(Surface surface, boolean z) {
        if (this.zzj != null) {
            zzamz zzamz = new zzamz(this.zzf, 1, surface);
            if (z) {
                this.zzj.zzk(zzamz);
                return;
            }
            this.zzj.zzj(zzamz);
        }
    }

    public final void zzS(float f, boolean z) {
        if (this.zzj != null) {
            zzamz zzamz = new zzamz(this.zzg, 2, Float.valueOf(f));
            if (z) {
                this.zzj.zzk(zzamz);
                return;
            }
            this.zzj.zzj(zzamz);
        }
    }

    public final void zzT() {
        this.zzj.zzh();
    }

    public final void zzU(long j) {
        this.zzj.zzg(j);
    }

    public final void zzV(int i) {
        this.zze.zzi(i);
    }

    public final void zzW(int i) {
        this.zze.zzj(i);
    }

    public final void zzX(int i) {
        for (WeakReference<zzcjs> weakReference : this.zzv) {
            zzcjs zzcjs = (zzcjs) weakReference.get();
            if (zzcjs != null) {
                zzcjs.zzf(i);
            }
        }
    }

    public final boolean zzY() {
        return this.zzj != null;
    }

    public final int zzZ() {
        return this.zzj.zzc();
    }

    public final void zza(zzanv zzanv, Object obj) {
    }

    public final long zzaa() {
        return this.zzj.zzm();
    }

    public final boolean zzab() {
        return this.zzj.zzf();
    }

    public final void zzac(boolean z) {
        this.zzj.zze(z);
    }

    public final void zzad(int i) {
        this.zze.zzg(i);
    }

    public final void zzae(int i) {
        this.zze.zzh(i);
    }

    public final long zzaf() {
        return this.zzj.zzl();
    }

    public final long zzag() {
        if (!zzw()) {
            return (long) this.zzo;
        }
        return 0;
    }

    public final long zzah() {
        if (zzw() && this.zzu.zzg()) {
            return Math.min((long) this.zzo, this.zzu.zzi());
        }
        return 0;
    }

    public final long zzai() {
        if (zzw()) {
            return this.zzu.zzj();
        }
        while (!this.zzt.isEmpty()) {
            long j = this.zzq;
            Map<String, List<String>> zze2 = this.zzt.remove(0).zze();
            long j2 = 0;
            if (zze2 != null) {
                Iterator<Map.Entry<String, List<String>>> it = zze2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next = it.next();
                    if (next != null) {
                        try {
                            if (!(next.getKey() == null || !zzfjm.zze("content-length", (CharSequence) next.getKey()) || next.getValue() == null || ((List) next.getValue()).get(0) == null)) {
                                j2 = Long.parseLong((String) ((List) next.getValue()).get(0));
                                break;
                            }
                        } catch (NumberFormatException unused) {
                            continue;
                        }
                    }
                }
            }
            this.zzq = j + j2;
        }
        return this.zzq;
    }

    public final int zzaj() {
        return this.zzp;
    }

    public final void zzak(boolean z) {
        if (this.zzj != null) {
            for (int i = 0; i < 2; i++) {
                this.zzh.zzc(i, !z);
            }
        }
    }

    public final long zzal() {
        return this.zzj.zzn();
    }

    public final long zzam() {
        return (long) this.zzo;
    }

    public final void zzb(zzatc zzatc, zzato zzato) {
    }

    public final void zzc(boolean z) {
    }

    public final void zzd(boolean z, int i) {
        zzcip zzcip = this.zzn;
        if (zzcip != null) {
            zzcip.zzs(i);
        }
    }

    public final void zze(zzamw zzamw) {
        zzcip zzcip = this.zzn;
        if (zzcip != null) {
            zzcip.zzu("onPlayerError", zzamw);
        }
    }

    public final void zzf() {
    }

    public final void zzg(zzano zzano) {
    }

    public final void zzh(zzank zzank) {
        zzciz zzciz = (zzciz) this.zzm.get();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && zzank != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzank.zze);
            hashMap.put("audioSampleMime", zzank.zzf);
            hashMap.put("audioCodec", zzank.zzc);
            zzciz.zze("onMetadataEvent", hashMap);
        }
    }

    public final void zzi(IOException iOException) {
        zzcip zzcip = this.zzn;
        if (zzcip == null) {
            return;
        }
        if (this.zzi.zzl) {
            zzcip.zzv("onLoadException", iOException);
        } else {
            zzcip.zzu("onLoadError", iOException);
        }
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i) {
        this.zzo += i;
    }

    public final void zzl(zzank zzank) {
        zzciz zzciz = (zzciz) this.zzm.get();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && zzank != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzank.zzl));
            hashMap.put("bitRate", String.valueOf(zzank.zzb));
            int i = zzank.zzj;
            int i2 = zzank.zzk;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            hashMap.put("resolution", sb.toString());
            hashMap.put("videoMime", zzank.zze);
            hashMap.put("videoSampleMime", zzank.zzf);
            hashMap.put("videoCodec", zzank.zzc);
            zzciz.zze("onMetadataEvent", hashMap);
        }
    }

    public final void zzm(int i, long j) {
        this.zzp += i;
    }

    public final void zzn(int i, int i2, int i3, float f) {
        zzcip zzcip = this.zzn;
        if (zzcip != null) {
            zzcip.zzt(i, i2);
        }
    }

    public final void zzo(Surface surface) {
        zzcip zzcip = this.zzn;
        if (zzcip != null) {
            zzcip.zzC();
        }
    }

    /* renamed from: zzp */
    public final void zzj(zzatv zzatv, zzatx zzatx) {
        if (zzatv instanceof zzaue) {
            this.zzt.add((zzaue) zzatv);
        } else if (zzatv instanceof zzcjv) {
            this.zzu = (zzcjv) zzatv;
            zzciz zzciz = (zzciz) this.zzm.get();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && this.zzu.zze()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzu.zzg()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzu.zzh()));
                zzr.zza.post(new zzcjx(zzciz, hashMap));
            }
        }
    }

    public final void zzq(zzatv zzatv, int i) {
        this.zzo += i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0045, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzbj)).booleanValue() == false) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzasn zzr(android.net.Uri r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzasj r9 = new com.google.android.gms.internal.ads.zzasj
            boolean r0 = r10.zzl
            if (r0 == 0) goto L_0x0022
            java.nio.ByteBuffer r0 = r10.zzk
            int r0 = r0.limit()
            if (r0 <= 0) goto L_0x0022
            java.nio.ByteBuffer r12 = r10.zzk
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r0 = r10.zzk
            r0.get(r12)
            com.google.android.gms.internal.ads.zzcjy r0 = new com.google.android.gms.internal.ads.zzcjy
            r0.<init>(r12)
        L_0x0020:
            r2 = r0
            goto L_0x0089
        L_0x0022:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzbn
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            if (r0 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzbjn.zzbj
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x004f
        L_0x0047:
            com.google.android.gms.internal.ads.zzciy r0 = r10.zzi
            boolean r0 = r0.zzj
            if (r0 != 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r1 = 0
        L_0x004f:
            com.google.android.gms.internal.ads.zzciy r0 = r10.zzi
            int r0 = r0.zzi
            if (r0 <= 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzcjz r0 = new com.google.android.gms.internal.ads.zzcjz
            r0.<init>(r10, r12, r1)
            goto L_0x0060
        L_0x005b:
            com.google.android.gms.internal.ads.zzcka r0 = new com.google.android.gms.internal.ads.zzcka
            r0.<init>(r10, r12, r1)
        L_0x0060:
            com.google.android.gms.internal.ads.zzciy r12 = r10.zzi
            boolean r12 = r12.zzj
            if (r12 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzckb r12 = new com.google.android.gms.internal.ads.zzckb
            r12.<init>(r10, r0)
            r0 = r12
        L_0x006c:
            java.nio.ByteBuffer r12 = r10.zzk
            if (r12 == 0) goto L_0x0020
            int r12 = r12.limit()
            if (r12 <= 0) goto L_0x0020
            java.nio.ByteBuffer r12 = r10.zzk
            int r12 = r12.limit()
            byte[] r12 = new byte[r12]
            java.nio.ByteBuffer r1 = r10.zzk
            r1.get(r12)
            com.google.android.gms.internal.ads.zzckc r1 = new com.google.android.gms.internal.ads.zzckc
            r1.<init>(r0, r12)
            r2 = r1
        L_0x0089:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r12 = com.google.android.gms.internal.ads.zzbjn.zzm
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r12 = r0.zzb(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzapn r12 = com.google.android.gms.internal.ads.zzckd.zza
            goto L_0x00a0
        L_0x009e:
            com.google.android.gms.internal.ads.zzapn r12 = com.google.android.gms.internal.ads.zzcke.zza
        L_0x00a0:
            r3 = r12
            com.google.android.gms.internal.ads.zzciy r12 = r10.zzi
            int r4 = r12.zzk
            com.google.android.gms.internal.ads.zzfjj r5 = com.google.android.gms.ads.internal.util.zzr.zza
            r7 = 0
            int r8 = r12.zzg
            r0 = r9
            r1 = r11
            r6 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckg.zzr(android.net.Uri, java.lang.String):com.google.android.gms.internal.ads.zzasn");
    }

    public final /* synthetic */ zzatv zzs(zzatu zzatu) {
        return new zzcjv(this.zzd, zzatu.zza(), this.zzr, this.zzs, this, new zzckf(this));
    }

    public final /* synthetic */ void zzt(boolean z, long j) {
        zzcip zzcip = this.zzn;
        if (zzcip != null) {
            zzcip.zzr(z, j);
        }
    }

    public final /* synthetic */ zzatv zzu(String str, boolean z) {
        zzckg zzckg = true != z ? null : this;
        zzciy zzciy = this.zzi;
        return new zzatz(str, (zzauv<String>) null, zzckg, zzciy.zzd, zzciy.zzf, true, (zzaud) null);
    }

    public final /* synthetic */ zzatv zzv(String str, boolean z) {
        zzckg zzckg = true != z ? null : this;
        zzciy zzciy = this.zzi;
        zzcjs zzcjs = new zzcjs(str, zzckg, zzciy.zzd, zzciy.zzf, zzciy.zzi);
        this.zzv.add(new WeakReference(zzcjs));
        return zzcjs;
    }
}
