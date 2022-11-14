package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
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
public final class zzclw extends zzciq implements zzajd, zzaef, zzamn, zzpz, zzlq {
    public static final /* synthetic */ int zzc = 0;
    public final Context zzd;
    public final zzcli zze;
    public final zzma zzf;
    public final zzma zzg;
    public final zzags zzh;
    public final zzciy zzi;
    public final WeakReference<zzciz> zzj;
    public final zzaez zzk;
    public zzir zzl;
    public ByteBuffer zzm;
    public boolean zzn;
    public zzcip zzo;
    public int zzp;
    public int zzq;
    public long zzr;
    public final String zzs;
    public final int zzt;
    public final ArrayList<zzaip> zzu;
    public volatile zzcll zzv;
    public final Set<WeakReference<zzclh>> zzw = new HashSet();

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0117, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzbex.zzc().zzb(com.google.android.gms.internal.ads.zzbjn.zzbj)).booleanValue() == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x011d, code lost:
        if (r8.zzi.zzj == false) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x011f, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0124, code lost:
        if (r8.zzi.zzi <= 0) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0126, code lost:
        r11 = new com.google.android.gms.internal.ads.zzclp(r8, r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x012c, code lost:
        r11 = new com.google.android.gms.internal.ads.zzclq(r8, r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0135, code lost:
        if (r8.zzi.zzj == false) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0137, code lost:
        r11 = new com.google.android.gms.internal.ads.zzclr(r8, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x013d, code lost:
        r9 = r8.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x013f, code lost:
        if (r9 == null) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0145, code lost:
        if (r9.limit() <= 0) goto L_0x015a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0147, code lost:
        r9 = new byte[r8.zzm.limit()];
        r8.zzm.get(r9);
        r11 = new com.google.android.gms.internal.ads.zzcls(r11, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzclw(android.content.Context r9, com.google.android.gms.internal.ads.zzciy r10, com.google.android.gms.internal.ads.zzciz r11) {
        /*
            r8 = this;
            r8.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r8.zzw = r0
            r8.zzd = r9
            r8.zzi = r10
            java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
            r10.<init>(r11)
            r8.zzj = r10
            com.google.android.gms.internal.ads.zzcli r10 = new com.google.android.gms.internal.ads.zzcli
            r10.<init>()
            r8.zze = r10
            com.google.android.gms.internal.ads.zzalw r10 = new com.google.android.gms.internal.ads.zzalw
            android.content.Context r1 = r8.zzd
            com.google.android.gms.internal.ads.zzaal r2 = com.google.android.gms.internal.ads.zzaal.zzb
            com.google.android.gms.internal.ads.zzfjj r5 = com.google.android.gms.ads.internal.util.zzr.zza
            r3 = 0
            r7 = -1
            r0 = r10
            r6 = r8
            r0.<init>(r1, r2, r3, r5, r6, r7)
            r8.zzf = r10
            com.google.android.gms.internal.ads.zzrb r10 = new com.google.android.gms.internal.ads.zzrb
            android.content.Context r0 = r8.zzd
            com.google.android.gms.internal.ads.zzaal r1 = com.google.android.gms.internal.ads.zzaal.zzb
            com.google.android.gms.internal.ads.zzfjj r2 = com.google.android.gms.ads.internal.util.zzr.zza
            r10.<init>(r0, r1, r2, r8)
            r8.zzg = r10
            com.google.android.gms.internal.ads.zzags r10 = new com.google.android.gms.internal.ads.zzags
            com.google.android.gms.internal.ads.zzagm r0 = com.google.android.gms.internal.ads.zzagm.zza
            com.google.android.gms.internal.ads.zzagc r1 = new com.google.android.gms.internal.ads.zzagc
            r1.<init>()
            r2 = 0
            r10.<init>(r0, r1, r2)
            r8.zzh = r10
            boolean r10 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r10 == 0) goto L_0x006e
            java.lang.String r10 = java.lang.String.valueOf(r8)
            int r0 = r10.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 36
            r1.<init>(r0)
            java.lang.String r0 = "OfficialExoPlayerAdapter initialize "
            r1.append(r0)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r10)
        L_0x006e:
            java.util.concurrent.atomic.AtomicInteger r10 = com.google.android.gms.internal.ads.zzciq.zza
            r10.incrementAndGet()
            com.google.android.gms.internal.ads.zziq r10 = new com.google.android.gms.internal.ads.zziq
            android.content.Context r0 = r8.zzd
            r1 = 2
            com.google.android.gms.internal.ads.zzma[] r1 = new com.google.android.gms.internal.ads.zzma[r1]
            com.google.android.gms.internal.ads.zzma r3 = r8.zzg
            r4 = 0
            r1[r4] = r3
            com.google.android.gms.internal.ads.zzma r3 = r8.zzf
            r5 = 1
            r1[r5] = r3
            r10.<init>(r0, r1)
            com.google.android.gms.internal.ads.zzags r0 = r8.zzh
            r10.zza(r0)
            com.google.android.gms.internal.ads.zzcli r0 = r8.zze
            r10.zzb(r0)
            com.google.android.gms.internal.ads.zzir r10 = r10.zzc()
            r8.zzl = r10
            r10.zzf(r8)
            r8.zzp = r4
            r0 = 0
            r8.zzr = r0
            r8.zzq = r4
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r8.zzu = r10
            r8.zzv = r2
            if (r11 == 0) goto L_0x00b8
            java.lang.String r10 = r11.zzn()
            if (r10 == 0) goto L_0x00b8
            java.lang.String r10 = r11.zzn()
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r10 = ""
        L_0x00ba:
            r8.zzs = r10
            if (r11 == 0) goto L_0x00c3
            int r10 = r11.zzp()
            goto L_0x00c4
        L_0x00c3:
            r10 = 0
        L_0x00c4:
            r8.zzt = r10
            com.google.android.gms.internal.ads.zzaez r10 = new com.google.android.gms.internal.ads.zzaez
            com.google.android.gms.ads.internal.util.zzr r0 = com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.internal.ads.zzcgy r11 = r11.zzt()
            java.lang.String r11 = r11.zza
            java.lang.String r9 = r0.zze(r9, r11)
            boolean r11 = r8.zzn
            if (r11 == 0) goto L_0x00f5
            java.nio.ByteBuffer r11 = r8.zzm
            int r11 = r11.limit()
            if (r11 <= 0) goto L_0x00f5
            java.nio.ByteBuffer r9 = r8.zzm
            int r9 = r9.limit()
            byte[] r9 = new byte[r9]
            java.nio.ByteBuffer r11 = r8.zzm
            r11.get(r9)
            com.google.android.gms.internal.ads.zzclo r11 = new com.google.android.gms.internal.ads.zzclo
            r11.<init>(r9)
            goto L_0x015a
        L_0x00f5:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r11 = com.google.android.gms.internal.ads.zzbjn.zzbn
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r11 = r0.zzb(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0119
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r11 = com.google.android.gms.internal.ads.zzbjn.zzbj
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r11 = r0.zzb(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x011f
        L_0x0119:
            com.google.android.gms.internal.ads.zzciy r11 = r8.zzi
            boolean r11 = r11.zzj
            if (r11 != 0) goto L_0x0120
        L_0x011f:
            r4 = 1
        L_0x0120:
            com.google.android.gms.internal.ads.zzciy r11 = r8.zzi
            int r11 = r11.zzi
            if (r11 <= 0) goto L_0x012c
            com.google.android.gms.internal.ads.zzclp r11 = new com.google.android.gms.internal.ads.zzclp
            r11.<init>(r8, r9, r4)
            goto L_0x0131
        L_0x012c:
            com.google.android.gms.internal.ads.zzclq r11 = new com.google.android.gms.internal.ads.zzclq
            r11.<init>(r8, r9, r4)
        L_0x0131:
            com.google.android.gms.internal.ads.zzciy r9 = r8.zzi
            boolean r9 = r9.zzj
            if (r9 == 0) goto L_0x013d
            com.google.android.gms.internal.ads.zzclr r9 = new com.google.android.gms.internal.ads.zzclr
            r9.<init>(r8, r11)
            r11 = r9
        L_0x013d:
            java.nio.ByteBuffer r9 = r8.zzm
            if (r9 == 0) goto L_0x015a
            int r9 = r9.limit()
            if (r9 <= 0) goto L_0x015a
            java.nio.ByteBuffer r9 = r8.zzm
            int r9 = r9.limit()
            byte[] r9 = new byte[r9]
            java.nio.ByteBuffer r0 = r8.zzm
            r0.get(r9)
            com.google.android.gms.internal.ads.zzcls r0 = new com.google.android.gms.internal.ads.zzcls
            r0.<init>(r11, r9)
            r11 = r0
        L_0x015a:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzbjn.zzm
            com.google.android.gms.internal.ads.zzbjl r0 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r9 = r0.zzb(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x016f
            com.google.android.gms.internal.ads.zztg r9 = com.google.android.gms.internal.ads.zzclt.zza
            goto L_0x0171
        L_0x016f:
            com.google.android.gms.internal.ads.zztg r9 = com.google.android.gms.internal.ads.zzclu.zza
        L_0x0171:
            r10.<init>(r11, r9)
            r8.zzk = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclw.<init>(android.content.Context, com.google.android.gms.internal.ads.zzciy, com.google.android.gms.internal.ads.zzciz):void");
    }

    private final boolean zzau() {
        return this.zzv != null && this.zzv.zzl();
    }

    public final void finalize() throws Throwable {
        zzciq.zza.decrementAndGet();
        if (zze.zzc()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(valueOf.length() + 34);
            sb.append("OfficialExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zze.zza(sb.toString());
        }
    }

    public final void zzA(Exception exc) {
    }

    public final void zzB(zzro zzro) {
    }

    public final void zzC(String str, long j, long j2) {
    }

    public final void zzD(zzkc zzkc, @Nullable zzrs zzrs) {
        zzciz zzciz = (zzciz) this.zzj.get();
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && zzkc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("audioMime", zzkc.zzk);
            hashMap.put("audioSampleMime", zzkc.zzl);
            hashMap.put("audioCodec", zzkc.zzi);
            zzciz.zze("onMetadataEvent", hashMap);
        }
    }

    public final void zzE(long j) {
    }

    public final void zzF(int i, long j, long j2) {
    }

    public final void zzG(String str) {
    }

    public final void zzH(zzro zzro) {
    }

    public final void zzI(boolean z) {
    }

    public final void zzJ(Exception exc) {
    }

    public final void zzK(Exception exc) {
    }

    public final void zzL(zzkc zzkc) {
    }

    public final void zzM(zzkc zzkc) {
    }

    public final void zzN(Uri[] uriArr, String str) {
        zzO(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzO(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzadx zzadx;
        if (this.zzl != null) {
            this.zzm = byteBuffer;
            this.zzn = z;
            int length = uriArr.length;
            if (length == 1) {
                zzadx = zzap(uriArr[0]);
            } else {
                zzadx[] zzadxArr = new zzadx[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzadxArr[i] = zzap(uriArr[i]);
                }
                zzadx = new zzael(false, false, zzadxArr);
            }
            this.zzl.zzb(zzadx);
            zzciq.zzb.incrementAndGet();
        }
    }

    public final void zzP(zzcip zzcip) {
        this.zzo = zzcip;
    }

    public final void zzQ() {
        zzir zzir = this.zzl;
        if (zzir != null) {
            zzir.zzg(this);
            this.zzl.zzr();
            this.zzl = null;
            zzciq.zzb.decrementAndGet();
        }
    }

    public final void zzR(Surface surface, boolean z) throws IOException {
        zzir zzir = this.zzl;
        if (zzir != null) {
            zzlx zzc2 = zzir.zzc(this.zzf);
            zzc2.zzb(1);
            zzc2.zzd(surface);
            zzc2.zzg();
            if (z) {
                try {
                    zzc2.zzj();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Google3ExoPlayerAdapter InterruptedException for MSG_SET_VIDEO_OUTPUT message.");
                }
            }
        }
    }

    public final void zzS(float f, boolean z) throws IOException {
        zzir zzir = this.zzl;
        if (zzir != null) {
            zzlx zzc2 = zzir.zzc(this.zzg);
            zzc2.zzb(2);
            zzc2.zzd(Float.valueOf(f));
            zzc2.zzg();
            if (z) {
                try {
                    zzc2.zzj();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Google3ExoPlayerAdapter InterruptedException for MSG_SET_VOLUME message.");
                }
            }
        }
    }

    public final void zzT() {
        ((zzid) this.zzl).zzp(false);
    }

    public final void zzU(long j) {
        zzid zzid = (zzid) this.zzl;
        zzid.zzo(zzid.zzt(), j);
    }

    public final void zzV(int i) {
        this.zze.zzl(i);
    }

    public final void zzW(int i) {
        this.zze.zzm(i);
    }

    public final void zzX(int i) {
        for (WeakReference<zzclh> weakReference : this.zzw) {
            zzclh zzclh = (zzclh) weakReference.get();
            if (zzclh != null) {
                zzclh.zzk(i);
            }
        }
    }

    public final boolean zzY() {
        return this.zzl != null;
    }

    public final int zzZ() {
        return this.zzl.zzi();
    }

    public final void zza(int i, zzadv zzadv, zzadm zzadm, zzadr zzadr) {
    }

    public final long zzaa() {
        return this.zzl.zzv();
    }

    public final boolean zzab() {
        return this.zzl.zzn();
    }

    public final void zzac(boolean z) {
        this.zzl.zzl(z);
    }

    public final void zzad(int i) {
        this.zze.zzj(i);
    }

    public final void zzae(int i) {
        this.zze.zzk(i);
    }

    public final long zzaf() {
        return this.zzl.zzu();
    }

    public final long zzag() {
        if (!zzau()) {
            return (long) this.zzp;
        }
        return 0;
    }

    public final long zzah() {
        if (zzau() && this.zzv.zzm()) {
            return Math.min((long) this.zzp, this.zzv.zzo());
        }
        return 0;
    }

    public final long zzai() {
        if (zzau()) {
            return this.zzv.zzp();
        }
        while (!this.zzu.isEmpty()) {
            long j = this.zzr;
            Map<String, List<String>> zze2 = this.zzu.remove(0).zze();
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
            this.zzr = j + j2;
        }
        return this.zzr;
    }

    public final int zzaj() {
        return this.zzq;
    }

    public final void zzak(boolean z) {
        if (this.zzl != null) {
            int i = 0;
            while (true) {
                this.zzl.zza();
                if (i < 2) {
                    zzags zzags = this.zzh;
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
        return this.zzl.zzw();
    }

    public final long zzam() {
        return (long) this.zzp;
    }

    @VisibleForTesting
    public final zzadx zzap(Uri uri) {
        zzkj zzkj = new zzkj();
        zzkj.zzb(uri);
        zzkq zzc2 = zzkj.zzc();
        zzaez zzaez = this.zzk;
        zzaez.zza(this.zzi.zzg);
        zzafa zzb = zzaez.zzb(zzc2);
        zzb.zzk(zzr.zza, this);
        return zzb;
    }

    public final /* synthetic */ zzaht zzaq(zzahs zzahs) {
        return new zzcll(this.zzd, zzahs.zza(), this.zzs, this.zzt, this, new zzclv(this));
    }

    public final /* synthetic */ void zzar(boolean z, long j) {
        zzcip zzcip = this.zzo;
        if (zzcip != null) {
            zzcip.zzr(z, j);
        }
    }

    public final /* synthetic */ zzaht zzas(String str, boolean z) {
        zzaif zzaif = new zzaif();
        zzaif.zzb(str);
        zzaif.zzf(true != z ? null : this);
        zzaif.zzc(this.zzi.zzd);
        zzaif.zzd(this.zzi.zzf);
        zzaif.zze(true);
        return zzaif.zza();
    }

    public final /* synthetic */ zzaht zzat(String str, boolean z) {
        zzclw zzclw = true != z ? null : this;
        zzciy zzciy = this.zzi;
        zzclh zzclh = new zzclh(str, zzclw, zzciy.zzd, zzciy.zzf, zzciy.zzi);
        this.zzw.add(new WeakReference(zzclh));
        return zzclh;
    }

    public final void zzb(int i, zzadv zzadv, zzadm zzadm, zzadr zzadr) {
    }

    public final void zzbf(int i, zzadv zzadv, zzadm zzadm, zzadr zzadr) {
    }

    public final void zzbg(int i, @Nullable zzadv zzadv, zzadm zzadm, zzadr zzadr, IOException iOException, boolean z) {
        zzcip zzcip = this.zzo;
        if (zzcip == null) {
            return;
        }
        if (this.zzi.zzl) {
            zzcip.zzv("onLoadException", iOException);
        } else {
            zzcip.zzu("onLoadError", iOException);
        }
    }

    public final void zzbh(int i, zzadv zzadv, zzadr zzadr) {
    }

    public final void zzbt(String str, long j, long j2) {
    }

    public final void zzbu(zzkc zzkc, @Nullable zzrs zzrs) {
        zzciz zzciz = (zzciz) this.zzj.get();
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

    public final void zzbv(zzmv zzmv, int i) {
    }

    public final void zzbw(zzkq zzkq, int i) {
    }

    public final void zzc(zzro zzro) {
    }

    public final void zzd(zzaht zzaht, zzahx zzahx, boolean z) {
    }

    public final void zze(zzaht zzaht, zzahx zzahx, boolean z) {
        if (zzaht instanceof zzaip) {
            this.zzu.add((zzaip) zzaht);
        } else if (zzaht instanceof zzcll) {
            this.zzv = (zzcll) zzaht;
            zzciz zzciz = (zzciz) this.zzj.get();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue() && zzciz != null && this.zzv.zzk()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzv.zzm()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzv.zzn()));
                zzr.zza.post(new zzcln(zzciz, hashMap));
            }
        }
    }

    public final void zzf(zzaht zzaht, zzahx zzahx, boolean z, int i) {
        this.zzp += i;
    }

    public final void zzg(zzaht zzaht, zzahx zzahx, boolean z) {
    }

    public final void zzh(zzaft zzaft, zzagx zzagx) {
    }

    public final void zzi(List list) {
    }

    public final void zzj(zzku zzku) {
    }

    public final void zzk(boolean z) {
    }

    public final void zzl(boolean z, int i) {
    }

    public final void zzm(int i) {
        zzcip zzcip = this.zzo;
        if (zzcip != null) {
            zzcip.zzs(i);
        }
    }

    public final void zzn(boolean z, int i) {
    }

    public final void zzo(int i) {
    }

    public final void zzp(boolean z) {
    }

    public final void zzq(zzio zzio) {
        zzcip zzcip = this.zzo;
        if (zzcip != null) {
            zzcip.zzu("onPlayerError", zzio);
        }
    }

    public final void zzr(zzlt zzlt, zzlt zzlt2, int i) {
    }

    public final void zzs(zzll zzll) {
    }

    public final void zzt() {
    }

    public final void zzu(int i, long j) {
        this.zzq += i;
    }

    public final void zzv(zzamp zzamp) {
        zzcip zzcip = this.zzo;
        if (zzcip != null) {
            zzcip.zzt(zzamp.zzb, zzamp.zzc);
        }
    }

    public final void zzw(Object obj, long j) {
        zzcip zzcip = this.zzo;
        if (zzcip != null) {
            zzcip.zzC();
        }
    }

    public final void zzx(String str) {
    }

    public final void zzy(zzro zzro) {
    }

    public final void zzz(long j, int i) {
    }
}
