package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.common.util.VisibleForTesting;
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
public final class zzcmh extends zzciq implements zzajd, zzow {
    public static final /* synthetic */ int zzc = 0;
    public final Context zzd;
    public final zzcli zze;
    public final zzags zzf;
    public final zzciy zzg;
    public final WeakReference<zzciz> zzh;
    public final zzaez zzi;
    public zzmj zzj;
    public ByteBuffer zzk;
    public boolean zzl;
    public zzcip zzm;
    public int zzn;
    public int zzo;
    public long zzp;
    public final String zzq;
    public final int zzr;
    public final ArrayList<zzaip> zzs;
    public volatile zzcll zzt;
    public final Set<WeakReference<zzclh>> zzu = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00f2, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzbj)).booleanValue() == false) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00f8, code lost:
        if (r3.zzg.zzj == false) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00fa, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ff, code lost:
        if (r3.zzg.zzi <= 0) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0101, code lost:
        r6 = new com.google.android.gms.internal.ads.zzclz(r3, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0107, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcma(r3, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0110, code lost:
        if (r3.zzg.zzj == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0112, code lost:
        r6 = new com.google.android.gms.internal.ads.zzcmb(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0118, code lost:
        r4 = r3.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x011a, code lost:
        if (r4 == null) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0120, code lost:
        if (r4.limit() <= 0) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0122, code lost:
        r4 = new byte[r3.zzk.limit()];
        r3.zzk.get(r4);
        r6 = new com.google.android.gms.internal.ads.zzcmc(r6, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcmh(android.content.Context r4, com.google.android.gms.internal.ads.zzciy r5, com.google.android.gms.internal.ads.zzciz r6) {
        /*
            r3 = this;
            r3.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r3.zzu = r0
            r3.zzd = r4
            r3.zzg = r5
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r6)
            r3.zzh = r5
            com.google.android.gms.internal.ads.zzcli r5 = new com.google.android.gms.internal.ads.zzcli
            r5.<init>()
            r3.zze = r5
            com.google.android.gms.internal.ads.zzags r5 = new com.google.android.gms.internal.ads.zzags
            android.content.Context r0 = r3.zzd
            r5.<init>(r0)
            r3.zzf = r5
            boolean r5 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r5 == 0) goto L_0x0049
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r0 = r5.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 42
            r1.<init>(r0)
            java.lang.String r0 = "OfficialSimpleExoPlayerAdapter initialize "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r5)
        L_0x0049:
            java.util.concurrent.atomic.AtomicInteger r5 = com.google.android.gms.internal.ads.zzciq.zza
            r5.incrementAndGet()
            com.google.android.gms.internal.ads.zzmg r5 = new com.google.android.gms.internal.ads.zzmg
            android.content.Context r0 = r3.zzd
            com.google.android.gms.internal.ads.zzcmd r1 = new com.google.android.gms.internal.ads.zzcmd
            r1.<init>(r3)
            r5.<init>(r0, r1)
            com.google.android.gms.internal.ads.zzags r0 = r3.zzf
            r5.zza(r0)
            com.google.android.gms.internal.ads.zzcli r0 = r3.zze
            r5.zzb(r0)
            com.google.android.gms.internal.ads.zzmj r5 = r5.zzc()
            r3.zzj = r5
            r0 = 0
            r5.zzq(r0)
            com.google.android.gms.internal.ads.zzmj r5 = r3.zzj
            r5.zzh(r3)
            r3.zzn = r0
            r1 = 0
            r3.zzp = r1
            r3.zzo = r0
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r3.zzs = r5
            r5 = 0
            r3.zzt = r5
            if (r6 == 0) goto L_0x0092
            java.lang.String r5 = r6.zzn()
            if (r5 == 0) goto L_0x0092
            java.lang.String r5 = r6.zzn()
            goto L_0x0094
        L_0x0092:
            java.lang.String r5 = ""
        L_0x0094:
            r3.zzq = r5
            if (r6 == 0) goto L_0x009d
            int r5 = r6.zzp()
            goto L_0x009e
        L_0x009d:
            r5 = 0
        L_0x009e:
            r3.zzr = r5
            com.google.android.gms.internal.ads.zzaez r5 = new com.google.android.gms.internal.ads.zzaez
            com.google.android.gms.ads.internal.util.zzr r1 = com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.internal.ads.zzcgy r6 = r6.zzt()
            java.lang.String r6 = r6.zza
            java.lang.String r4 = r1.zze(r4, r6)
            boolean r6 = r3.zzl
            if (r6 == 0) goto L_0x00cf
            java.nio.ByteBuffer r6 = r3.zzk
            int r6 = r6.limit()
            if (r6 <= 0) goto L_0x00cf
            java.nio.ByteBuffer r4 = r3.zzk
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r6 = r3.zzk
            r6.get(r4)
            com.google.android.gms.internal.ads.zzcly r6 = new com.google.android.gms.internal.ads.zzcly
            r6.<init>(r4)
            goto L_0x0135
        L_0x00cf:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzbjn.zzbn
            com.google.android.gms.internal.ads.zzbjl r1 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r6 = r1.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r1 = 1
            if (r6 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzbjn.zzbj
            com.google.android.gms.internal.ads.zzbjl r2 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r6 = r2.zzb(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x00fa
        L_0x00f4:
            com.google.android.gms.internal.ads.zzciy r6 = r3.zzg
            boolean r6 = r6.zzj
            if (r6 != 0) goto L_0x00fb
        L_0x00fa:
            r0 = 1
        L_0x00fb:
            com.google.android.gms.internal.ads.zzciy r6 = r3.zzg
            int r6 = r6.zzi
            if (r6 <= 0) goto L_0x0107
            com.google.android.gms.internal.ads.zzclz r6 = new com.google.android.gms.internal.ads.zzclz
            r6.<init>(r3, r4, r0)
            goto L_0x010c
        L_0x0107:
            com.google.android.gms.internal.ads.zzcma r6 = new com.google.android.gms.internal.ads.zzcma
            r6.<init>(r3, r4, r0)
        L_0x010c:
            com.google.android.gms.internal.ads.zzciy r4 = r3.zzg
            boolean r4 = r4.zzj
            if (r4 == 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzcmb r4 = new com.google.android.gms.internal.ads.zzcmb
            r4.<init>(r3, r6)
            r6 = r4
        L_0x0118:
            java.nio.ByteBuffer r4 = r3.zzk
            if (r4 == 0) goto L_0x0135
            int r4 = r4.limit()
            if (r4 <= 0) goto L_0x0135
            java.nio.ByteBuffer r4 = r3.zzk
            int r4 = r4.limit()
            byte[] r4 = new byte[r4]
            java.nio.ByteBuffer r0 = r3.zzk
            r0.get(r4)
            com.google.android.gms.internal.ads.zzcmc r0 = new com.google.android.gms.internal.ads.zzcmc
            r0.<init>(r6, r4)
            r6 = r0
        L_0x0135:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzbjn.zzm
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r4 = r0.zzb(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x014a
            com.google.android.gms.internal.ads.zztg r4 = com.google.android.gms.internal.ads.zzcme.zza
            goto L_0x014c
        L_0x014a:
            com.google.android.gms.internal.ads.zztg r4 = com.google.android.gms.internal.ads.zzcmf.zza
        L_0x014c:
            r5.<init>(r6, r4)
            r3.zzi = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcmh.<init>(android.content.Context, com.google.android.gms.internal.ads.zzciy, com.google.android.gms.internal.ads.zzciz):void");
    }

    private final boolean zzo() {
        return this.zzt != null && this.zzt.zzl();
    }

    public final void finalize() {
        zzciq.zza.decrementAndGet();
        if (zze.zzc()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 40);
            sb.append("OfficialSimpleExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zze.zza(sb.toString());
        }
    }

    public final void zzN(Uri[] uriArr, String str) {
        zzO(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzO(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzadx zzadx;
        if (this.zzj != null) {
            this.zzk = byteBuffer;
            this.zzl = z;
            int length = uriArr.length;
            if (length == 1) {
                zzadx = zzi(uriArr[0]);
            } else {
                zzadx[] zzadxArr = new zzadx[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzadxArr[i] = zzi(uriArr[i]);
                }
                zzadx = new zzael(false, false, zzadxArr);
            }
            this.zzj.zzm(zzadx);
            this.zzj.zzk();
            zzciq.zzb.incrementAndGet();
        }
    }

    public final void zzP(zzcip zzcip) {
        this.zzm = zzcip;
    }

    public final void zzQ() {
        zzmj zzmj = this.zzj;
        if (zzmj != null) {
            zzmj.zzj(this);
            this.zzj.zzr();
            this.zzj = null;
            zzciq.zzb.decrementAndGet();
        }
    }

    public final void zzR(Surface surface, boolean z) {
        zzmj zzmj = this.zzj;
        if (zzmj != null) {
            zzmj.zzd(surface);
        }
    }

    public final void zzS(float f, boolean z) {
        zzmj zzmj = this.zzj;
        if (zzmj != null) {
            zzmj.zze(f);
        }
    }

    public final void zzT() {
        this.zzj.zzp(false);
    }

    public final void zzU(long j) {
        zzmj zzmj = this.zzj;
        zzmj.zzo(zzmj.zzt(), j);
    }

    public final void zzV(int i) {
        this.zze.zzl(i);
    }

    public final void zzW(int i) {
        this.zze.zzm(i);
    }

    public final void zzX(int i) {
        for (WeakReference<zzclh> weakReference : this.zzu) {
            zzclh zzclh = (zzclh) weakReference.get();
            if (zzclh != null) {
                zzclh.zzk(i);
            }
        }
    }

    public final boolean zzY() {
        return this.zzj != null;
    }

    public final int zzZ() {
        return this.zzj.zzi();
    }

    public final void zza(zzov zzov, int i) {
        zzcip zzcip = this.zzm;
        if (zzcip != null) {
            zzcip.zzs(i);
        }
    }

    public final long zzaa() {
        return this.zzj.zzv();
    }

    public final boolean zzab() {
        return this.zzj.zzn();
    }

    public final void zzac(boolean z) {
        this.zzj.zzl(z);
    }

    public final void zzad(int i) {
        this.zze.zzj(i);
    }

    public final void zzae(int i) {
        this.zze.zzk(i);
    }

    public final long zzaf() {
        return this.zzj.zzu();
    }

    public final long zzag() {
        if (!zzo()) {
            return (long) this.zzn;
        }
        return 0;
    }

    public final long zzah() {
        if (zzo() && this.zzt.zzm()) {
            return Math.min((long) this.zzn, this.zzt.zzo());
        }
        return 0;
    }

    public final long zzai() {
        if (zzo()) {
            return this.zzt.zzp();
        }
        while (!this.zzs.isEmpty()) {
            long j = this.zzp;
            Map<String, List<String>> zze2 = this.zzs.remove(0).zze();
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
            this.zzp = j + j2;
        }
        return this.zzp;
    }

    public final int zzaj() {
        return this.zzo;
    }

    public final void zzak(boolean z) {
        if (this.zzj != null) {
            int i = 0;
            while (true) {
                this.zzj.zza();
                if (i < 2) {
                    zzags zzags = this.zzf;
                    zzagn zze2 = zzags.zzb().zze();
                    zze2.zza(i, !z);
                    zzags.zza(zze2.zzb());
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final long zzal() {
        return this.zzj.zzw();
    }

    public final long zzam() {
        return (long) this.zzn;
    }

    public final void zzb(zzov zzov, zzio zzio) {
        zzcip zzcip = this.zzm;
        if (zzcip != null) {
            zzcip.zzu("onPlayerError", zzio);
        }
    }

    public final void zzbA(zzov zzov, zzkc zzkc, @Nullable zzrs zzrs) {
        zzciz zzciz = (zzciz) this.zzh.get();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && zzkc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzkc.zzk);
            hashMap.put("audioSampleMime", zzkc.zzl);
            hashMap.put("audioCodec", zzkc.zzi);
            zzciz.zze("onMetadataEvent", hashMap);
        }
    }

    public final void zzbx(zzov zzov, zzkc zzkc, @Nullable zzrs zzrs) {
        zzciz zzciz = (zzciz) this.zzh.get();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && zzkc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzkc.zzs));
            hashMap.put("bitRate", String.valueOf(zzkc.zzh));
            int i = zzkc.zzq;
            int i2 = zzkc.zzr;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            hashMap.put("resolution", sb.toString());
            hashMap.put("videoMime", zzkc.zzk);
            hashMap.put("videoSampleMime", zzkc.zzl);
            hashMap.put("videoCodec", zzkc.zzi);
            zzciz.zze("onMetadataEvent", hashMap);
        }
    }

    public final void zzby(zzov zzov, int i, long j) {
        this.zzo += i;
    }

    public final void zzbz(zzov zzov, Object obj, long j) {
        zzcip zzcip = this.zzm;
        if (zzcip != null) {
            zzcip.zzC();
        }
    }

    public final void zzc(zzov zzov, zzadm zzadm, zzadr zzadr, IOException iOException, boolean z) {
        zzcip zzcip = this.zzm;
        if (zzcip == null) {
            return;
        }
        if (this.zzg.zzl) {
            zzcip.zzv("onLoadException", iOException);
        } else {
            zzcip.zzu("onLoadError", iOException);
        }
    }

    public final void zzd(zzaht zzaht, zzahx zzahx, boolean z) {
    }

    public final void zze(zzaht zzaht, zzahx zzahx, boolean z) {
        if (zzaht instanceof zzaip) {
            this.zzs.add((zzaip) zzaht);
        } else if (zzaht instanceof zzcll) {
            this.zzt = (zzcll) zzaht;
            zzciz zzciz = (zzciz) this.zzh.get();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && this.zzt.zzk()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzm()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzn()));
                zzr.zza.post(new zzclx(zzciz, hashMap));
            }
        }
    }

    public final void zzf(zzaht zzaht, zzahx zzahx, boolean z, int i) {
        this.zzn += i;
    }

    public final void zzg(zzaht zzaht, zzahx zzahx, boolean z) {
    }

    public final void zzh(zzov zzov, zzamp zzamp) {
        zzcip zzcip = this.zzm;
        if (zzcip != null) {
            zzcip.zzt(zzamp.zzb, zzamp.zzc);
        }
    }

    @VisibleForTesting
    public final zzadx zzi(Uri uri) {
        zzkj zzkj = new zzkj();
        zzkj.zzb(uri);
        zzkq zzc2 = zzkj.zzc();
        zzaez zzaez = this.zzi;
        zzaez.zza(this.zzg.zzg);
        return zzaez.zzb(zzc2);
    }

    public final /* synthetic */ zzma[] zzj(Handler handler, zzamn zzamn, zzpz zzpz, zzafz zzafz, zzabf zzabf) {
        return new zzma[]{new zzrb(this.zzd, zzaal.zzb, handler, zzpz), new zzalw(this.zzd, zzaal.zzb, 0, handler, zzamn, -1)};
    }

    public final /* synthetic */ zzaht zzk(zzahs zzahs) {
        return new zzcll(this.zzd, zzahs.zza(), this.zzq, this.zzr, this, new zzcmg(this));
    }

    public final /* synthetic */ void zzl(boolean z, long j) {
        zzcip zzcip = this.zzm;
        if (zzcip != null) {
            zzcip.zzr(z, j);
        }
    }

    public final /* synthetic */ zzaht zzm(String str, boolean z) {
        zzaif zzaif = new zzaif();
        zzaif.zzb(str);
        zzaif.zzf(true != z ? null : this);
        zzaif.zzc(this.zzg.zzd);
        zzaif.zzd(this.zzg.zzf);
        zzaif.zze(true);
        return zzaif.zza();
    }

    public final /* synthetic */ zzaht zzn(String str, boolean z) {
        zzcmh zzcmh = true != z ? null : this;
        zzciy zzciy = this.zzg;
        zzclh zzclh = new zzclh(str, zzcmh, zzciy.zzd, zzciy.zzf, zzciy.zzi);
        this.zzu.add(new WeakReference(zzclh));
        return zzclh;
    }
}
