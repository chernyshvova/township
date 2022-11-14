package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.playrix.gplay.billing.Base64;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzaaj extends zzie {
    public static final byte[] zzb = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    @Nullable
    public ArrayDeque<zzaah> zzA;
    @Nullable
    public zzaai zzB;
    @Nullable
    public zzaah zzC;
    public int zzD;
    public boolean zzE;
    public boolean zzF;
    public boolean zzG;
    public boolean zzH;
    public boolean zzI;
    public boolean zzJ;
    public boolean zzK;
    public boolean zzL;
    public boolean zzM;
    public boolean zzN;
    @Nullable
    public zzaac zzO;
    public long zzP;
    public int zzQ;
    public int zzR;
    @Nullable
    public ByteBuffer zzS;
    public boolean zzT;
    public boolean zzU;
    public boolean zzV;
    public boolean zzW;
    public boolean zzX;
    public boolean zzY;
    public int zzZ;
    public zzro zza;
    public int zzaa;
    public int zzab;
    public boolean zzac;
    public boolean zzad;
    public boolean zzae;
    public long zzaf;
    public long zzag;
    public boolean zzah;
    public boolean zzai;
    public boolean zzaj;
    public boolean zzak;
    @Nullable
    public zzio zzal;
    public long zzam;
    public long zzan;
    public int zzao;
    @Nullable
    public zzabb zzap;
    @Nullable
    public zzsj zzaq;
    @Nullable
    public zzsj zzar;
    public final zzaae zzc;
    public final zzaal zzd;
    public final float zze;
    public final zzrr zzf;
    public final zzrr zzg;
    public final zzrr zzh;
    public final zzaab zzi;
    public final zzald<zzkc> zzj;
    public final ArrayList<Long> zzk;
    public final MediaCodec.BufferInfo zzl;
    public final long[] zzm;
    public final long[] zzn;
    public final long[] zzo;
    @Nullable
    public zzkc zzp;
    @Nullable
    public zzkc zzq;
    @Nullable
    public MediaCrypto zzr;
    public boolean zzs;
    public long zzt;
    public float zzu;
    public float zzv;
    @Nullable
    public zzkc zzw;
    @Nullable
    public MediaFormat zzx;
    public boolean zzy;
    public float zzz;

    public zzaaj(int i, zzaae zzaae, zzaal zzaal, boolean z, float f) {
        super(i);
        this.zzc = zzaae;
        if (zzaal != null) {
            this.zzd = zzaal;
            this.zze = f;
            this.zzf = new zzrr(0, 0);
            this.zzg = new zzrr(0, 0);
            this.zzh = new zzrr(2, 0);
            this.zzi = new zzaab();
            this.zzj = new zzald<>(10);
            this.zzk = new ArrayList<>();
            this.zzl = new MediaCodec.BufferInfo();
            this.zzu = 1.0f;
            this.zzv = 1.0f;
            this.zzt = -9223372036854775807L;
            this.zzm = new long[10];
            this.zzn = new long[10];
            this.zzo = new long[10];
            this.zzam = -9223372036854775807L;
            this.zzan = -9223372036854775807L;
            this.zzi.zzi(0);
            this.zzi.zzb.order(ByteOrder.nativeOrder());
            this.zzz = -1.0f;
            this.zzD = 0;
            this.zzZ = 0;
            this.zzQ = -1;
            this.zzR = -1;
            this.zzP = -9223372036854775807L;
            this.zzaf = -9223372036854775807L;
            this.zzag = -9223372036854775807L;
            this.zzaa = 0;
            this.zzab = 0;
            return;
        }
        throw null;
    }

    private final void zzZ() {
        this.zzX = false;
        this.zzi.zza();
        this.zzh.zza();
        this.zzW = false;
        this.zzV = false;
    }

    private final boolean zzaA() {
        return this.zzR >= 0;
    }

    private final void zzaB() {
        this.zzQ = -1;
        this.zzg.zzb = null;
    }

    private final void zzaC() {
        this.zzR = -1;
        this.zzS = null;
    }

    private final boolean zzaD() throws zzio {
        zzabb zzabb = this.zzap;
        if (zzabb == null || this.zzaa == 2 || this.zzah) {
            return false;
        }
        if (this.zzQ < 0) {
            int zza2 = zzabb.zza();
            this.zzQ = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzb = this.zzap.zzd(zza2);
            this.zzg.zza();
        }
        if (this.zzaa == 1) {
            if (!this.zzN) {
                this.zzad = true;
                this.zzap.zzf(this.zzQ, 0, 0, 0, 4);
                zzaB();
            }
            this.zzaa = 2;
            return false;
        } else if (this.zzL) {
            this.zzL = false;
            this.zzg.zzb.put(zzb);
            this.zzap.zzf(this.zzQ, 0, 38, 0, 0);
            zzaB();
            this.zzac = true;
            return true;
        } else {
            if (this.zzZ == 1) {
                for (int i = 0; i < this.zzw.zzn.size(); i++) {
                    this.zzg.zzb.put(this.zzw.zzn.get(i));
                }
                this.zzZ = 2;
            }
            int position = this.zzg.zzb.position();
            zzkd zzB2 = zzB();
            try {
                int zzF2 = zzF(zzB2, this.zzg, 0);
                if (zzj()) {
                    this.zzag = this.zzaf;
                }
                if (zzF2 == -3) {
                    return false;
                }
                if (zzF2 == -5) {
                    if (this.zzZ == 2) {
                        this.zzg.zza();
                        this.zzZ = 1;
                    }
                    zzX(zzB2);
                    return true;
                } else if (this.zzg.zzc()) {
                    if (this.zzZ == 2) {
                        this.zzg.zza();
                        this.zzZ = 1;
                    }
                    this.zzah = true;
                    if (!this.zzac) {
                        zzaH();
                        return false;
                    }
                    try {
                        if (!this.zzN) {
                            this.zzad = true;
                            this.zzap.zzf(this.zzQ, 0, 0, 0, 4);
                            zzaB();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e) {
                        throw zzE(e, this.zzp, false);
                    }
                } else if (this.zzac || this.zzg.zzd()) {
                    boolean zzj2 = this.zzg.zzj();
                    if (zzj2) {
                        this.zzg.zza.zzc(position);
                    }
                    if (this.zzE && !zzj2) {
                        ByteBuffer byteBuffer = this.zzg.zzb;
                        byte[] bArr = zzakj.zza;
                        int position2 = byteBuffer.position();
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            int i4 = i2 + 1;
                            if (i4 >= position2) {
                                byteBuffer.clear();
                                break;
                            }
                            byte b = byteBuffer.get(i2) & Base64.EQUALS_SIGN_ENC;
                            if (i3 == 3) {
                                if (b == 1) {
                                    if ((byteBuffer.get(i4) & 31) == 7) {
                                        ByteBuffer duplicate = byteBuffer.duplicate();
                                        duplicate.position(i2 - 3);
                                        duplicate.limit(position2);
                                        byteBuffer.position(0);
                                        byteBuffer.put(duplicate);
                                        break;
                                    }
                                    b = 1;
                                }
                            } else if (b == 0) {
                                i3++;
                            }
                            if (b != 0) {
                                i3 = 0;
                            }
                            i2 = i4;
                        }
                        if (this.zzg.zzb.position() == 0) {
                            return true;
                        }
                        this.zzE = false;
                    }
                    zzrr zzrr = this.zzg;
                    long j = zzrr.zzd;
                    zzaac zzaac = this.zzO;
                    if (zzaac != null) {
                        j = zzaac.zzb(this.zzp, zzrr);
                    }
                    long j2 = j;
                    if (this.zzg.zzb()) {
                        this.zzk.add(Long.valueOf(j2));
                    }
                    if (this.zzaj) {
                        this.zzj.zza(j2, this.zzp);
                        this.zzaj = false;
                    }
                    if (this.zzO != null) {
                        this.zzaf = Math.max(this.zzaf, this.zzg.zzd);
                    } else {
                        this.zzaf = Math.max(this.zzaf, j2);
                    }
                    this.zzg.zzk();
                    if (this.zzg.zze()) {
                        zzas(this.zzg);
                    }
                    zzaa(this.zzg);
                    if (zzj2) {
                        try {
                            this.zzap.zzg(this.zzQ, 0, this.zzg.zza, j2, 0);
                        } catch (MediaCodec.CryptoException e2) {
                            throw zzE(e2, this.zzp, false);
                        }
                    } else {
                        this.zzap.zzf(this.zzQ, 0, this.zzg.zzb.limit(), j2, 0);
                    }
                    zzaB();
                    this.zzac = true;
                    this.zzZ = 0;
                    this.zza.zzc++;
                    return true;
                } else {
                    this.zzg.zza();
                    if (this.zzZ == 2) {
                        this.zzZ = 1;
                    }
                    return true;
                }
            } catch (zzrq e3) {
                zzW(e3);
                throw zzE(zzar(e3, this.zzC), this.zzp, false);
            }
        }
    }

    private final boolean zzaE(zzkc zzkc) throws zzio {
        if (!(zzalh.zza < 23 || this.zzap == null || this.zzab == 3 || zze() == 0)) {
            float zzT2 = zzT(this.zzv, zzkc, zzC());
            float f = this.zzz;
            if (f == zzT2) {
                return true;
            }
            if (zzT2 == -1.0f) {
                zzaG();
                return false;
            } else if (f == -1.0f && zzT2 <= this.zze) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", zzT2);
                this.zzap.zzn(bundle);
                this.zzz = zzT2;
            }
        }
        return true;
    }

    @TargetApi(23)
    private final boolean zzaF() throws zzio {
        if (this.zzac) {
            this.zzaa = 1;
            if (this.zzF || this.zzH) {
                this.zzab = 3;
                return false;
            }
            this.zzab = 2;
        } else {
            zzaI();
        }
        return true;
    }

    private final void zzaG() throws zzio {
        if (this.zzac) {
            this.zzaa = 1;
            this.zzab = 3;
            return;
        }
        zzam();
        zzag();
    }

    @TargetApi(23)
    private final void zzaH() throws zzio {
        int i = this.zzab;
        if (i == 1) {
            zzad();
        } else if (i == 2) {
            zzad();
            zzaI();
        } else if (i != 3) {
            this.zzai = true;
            zzac();
        } else {
            zzam();
            zzag();
        }
    }

    @RequiresApi(23)
    private final void zzaI() throws zzio {
        try {
            throw null;
        } catch (MediaCryptoException e) {
            throw zzE(e, this.zzp, false);
        }
    }

    private final void zzad() {
        try {
            this.zzap.zzj();
        } finally {
            zzap();
        }
    }

    private final boolean zzae(int i) throws zzio {
        zzkd zzB2 = zzB();
        this.zzf.zza();
        int zzF2 = zzF(zzB2, this.zzf, i | 4);
        if (zzF2 == -5) {
            zzX(zzB2);
            return true;
        } else if (zzF2 != -4 || !this.zzf.zzc()) {
            return false;
        } else {
            this.zzah = true;
            zzaH();
            return false;
        }
    }

    public static boolean zzax(zzkc zzkc) {
        Class cls = zzkc.zzE;
        return cls == null || zzsk.class.equals(cls);
    }

    private final boolean zzaz(long j) {
        return this.zzt == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.zzt;
    }

    public void zzA() {
        try {
            zzZ();
            zzam();
        } finally {
            this.zzar = null;
        }
    }

    public void zzI(float f, float f2) throws zzio {
        this.zzu = f;
        this.zzv = f2;
        zzaE(this.zzw);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: com.google.android.gms.internal.ads.zzabb} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v18, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v35, resolved type: com.google.android.gms.internal.ads.zzkc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v37, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v38, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v43, resolved type: com.google.android.gms.internal.ads.zzkc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v44, resolved type: com.google.android.gms.internal.ads.zzaaj} */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:173|174|175|176|177|(1:179)|180|181|268|(1:203)|207|218|219) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:100|101|(1:103)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x017a, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        zzaH();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x017f, code lost:
        if (r15.zzai != false) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0181, code lost:
        zzam();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02c2, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:?, code lost:
        zzaH();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02c5, code lost:
        r15 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02c7, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02c9, code lost:
        if (r15.zzai != false) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02cb, code lost:
        zzam();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02ce, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02cf, code lost:
        r2 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x02d2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0347, code lost:
        r0 = e;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ee, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x017a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:173:0x02c2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0194 A[Catch:{ IllegalStateException -> 0x036c }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01d6 A[Catch:{ IllegalStateException -> 0x036c }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0328 A[Catch:{ IllegalStateException -> 0x0369 }, LOOP:2: B:91:0x0163->B:201:0x0328, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0332 A[Catch:{ IllegalStateException -> 0x0369 }, LOOP:4: B:203:0x0332->B:206:0x033c, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x032f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0327 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzK(long r24, long r26) throws com.google.android.gms.internal.ads.zzio {
        /*
            r23 = this;
            r15 = r23
            boolean r0 = r15.zzak
            r14 = 0
            if (r0 == 0) goto L_0x000c
            r15.zzak = r14
            r23.zzaH()
        L_0x000c:
            com.google.android.gms.internal.ads.zzio r0 = r15.zzal
            r13 = 0
            if (r0 != 0) goto L_0x03bb
            r11 = 1
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x001a
            r23.zzac()     // Catch:{ IllegalStateException -> 0x036c }
            return
        L_0x001a:
            com.google.android.gms.internal.ads.zzkc r0 = r15.zzp     // Catch:{ IllegalStateException -> 0x036c }
            r12 = 2
            if (r0 != 0) goto L_0x0027
            boolean r0 = r15.zzae(r12)     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            return
        L_0x0027:
            r23.zzag()     // Catch:{ IllegalStateException -> 0x036c }
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0154
            java.lang.String r0 = "bypassRender"
            com.google.android.gms.internal.ads.zzalf.zza(r0)     // Catch:{ IllegalStateException -> 0x0150 }
        L_0x0033:
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0150 }
            r0 = r0 ^ r11
            com.google.android.gms.internal.ads.zzajg.zzd(r0)     // Catch:{ IllegalStateException -> 0x0150 }
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0150 }
            boolean r0 = r0.zzo()     // Catch:{ IllegalStateException -> 0x0150 }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            java.nio.ByteBuffer r7 = r0.zzb     // Catch:{ IllegalStateException -> 0x036c }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x036c }
            int r10 = r0.zzn()     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            long r4 = r0.zzd     // Catch:{ IllegalStateException -> 0x036c }
            r6 = 0
            r9 = 0
            boolean r0 = r0.zzb()     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzaab r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            boolean r16 = r1.zzc()     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzkc r12 = r15.zzq     // Catch:{ IllegalStateException -> 0x036c }
            r1 = r23
            r2 = r24
            r17 = r4
            r4 = r26
            r19 = r12
            r11 = r17
            r13 = r0
            r14 = r16
            r15 = r19
            boolean r0 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x008b }
            if (r0 == 0) goto L_0x0085
            r15 = r23
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            long r0 = r0.zzm()     // Catch:{ IllegalStateException -> 0x036c }
            r15.zzat(r0)     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            r0.zza()     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x0091
        L_0x0085:
            r15 = r23
            r13 = 0
            r14 = 1
            goto L_0x0143
        L_0x008b:
            r0 = move-exception
            r2 = 1
            r19 = 0
            goto L_0x02d4
        L_0x0091:
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x009b
            r14 = 1
            r15.zzai = r14     // Catch:{ IllegalStateException -> 0x036c }
            r13 = 0
            goto L_0x0143
        L_0x009b:
            r14 = 1
            boolean r0 = r15.zzW     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x00af
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzrr r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x036c }
            boolean r0 = r0.zzp(r1)     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzajg.zzd(r0)     // Catch:{ IllegalStateException -> 0x036c }
            r13 = 0
            r15.zzW = r13     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x00b0
        L_0x00af:
            r13 = 0
        L_0x00b0:
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x00ce
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            boolean r0 = r0.zzo()     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 != 0) goto L_0x00c9
            r23.zzZ()     // Catch:{ IllegalStateException -> 0x036c }
            r15.zzX = r13     // Catch:{ IllegalStateException -> 0x036c }
            r23.zzag()     // Catch:{ IllegalStateException -> 0x036c }
            boolean r0 = r15.zzV     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0143
            goto L_0x00ce
        L_0x00c9:
            r11 = 1
            r13 = 0
        L_0x00cb:
            r14 = 0
            goto L_0x0033
        L_0x00ce:
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x036c }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzajg.zzd(r0)     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzkd r0 = r23.zzB()     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzrr r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x036c }
            r1.zza()     // Catch:{ IllegalStateException -> 0x036c }
        L_0x00dd:
            com.google.android.gms.internal.ads.zzrr r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x036c }
            r1.zza()     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzrr r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x036c }
            int r1 = r15.zzF(r0, r1, r13)     // Catch:{ IllegalStateException -> 0x036c }
            r2 = -5
            if (r1 == r2) goto L_0x0121
            r2 = -4
            if (r1 == r2) goto L_0x00f0
        L_0x00ee:
            r2 = 0
            goto L_0x0125
        L_0x00f0:
            com.google.android.gms.internal.ads.zzrr r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x036c }
            boolean r1 = r1.zzc()     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 == 0) goto L_0x00fb
            r15.zzah = r14     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x00ee
        L_0x00fb:
            boolean r1 = r15.zzaj     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 == 0) goto L_0x010e
            com.google.android.gms.internal.ads.zzkc r1 = r15.zzp     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 == 0) goto L_0x010c
            r15.zzq = r1     // Catch:{ IllegalStateException -> 0x036c }
            r2 = 0
            r15.zzY(r1, r2)     // Catch:{ IllegalStateException -> 0x036c }
            r15.zzaj = r13     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x010f
        L_0x010c:
            r2 = 0
            throw r2     // Catch:{ IllegalStateException -> 0x036c }
        L_0x010e:
            r2 = 0
        L_0x010f:
            com.google.android.gms.internal.ads.zzrr r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x036c }
            r1.zzk()     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzaab r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzrr r3 = r15.zzh     // Catch:{ IllegalStateException -> 0x036c }
            boolean r1 = r1.zzp(r3)     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 != 0) goto L_0x00dd
            r15.zzW = r14     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x0125
        L_0x0121:
            r2 = 0
            r15.zzX(r0)     // Catch:{ IllegalStateException -> 0x036c }
        L_0x0125:
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            boolean r0 = r0.zzo()     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            r0.zzk()     // Catch:{ IllegalStateException -> 0x036c }
        L_0x0132:
            com.google.android.gms.internal.ads.zzaab r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x036c }
            boolean r0 = r0.zzo()     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 != 0) goto L_0x014c
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 != 0) goto L_0x014c
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0143
            goto L_0x014c
        L_0x0143:
            com.google.android.gms.internal.ads.zzalf.zzb()     // Catch:{ IllegalStateException -> 0x036c }
            r1 = r15
            r2 = 1
            r19 = 0
            goto L_0x0361
        L_0x014c:
            r13 = r2
            r11 = 1
            goto L_0x00cb
        L_0x0150:
            r0 = move-exception
            r13 = 0
            goto L_0x036d
        L_0x0154:
            r13 = 0
            r14 = 1
            com.google.android.gms.internal.ads.zzabb r0 = r15.zzap     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x034f
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x034a }
            java.lang.String r0 = "drainAndFeed"
            com.google.android.gms.internal.ads.zzalf.zza(r0)     // Catch:{ IllegalStateException -> 0x034a }
        L_0x0163:
            boolean r0 = r23.zzaA()     // Catch:{ IllegalStateException -> 0x034a }
            if (r0 != 0) goto L_0x0280
            boolean r0 = r15.zzI     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x018a
            boolean r0 = r15.zzad     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x018a
            com.google.android.gms.internal.ads.zzabb r0 = r15.zzap     // Catch:{ IllegalStateException -> 0x017a }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x017a }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x017a }
            goto L_0x0192
        L_0x017a:
            r23.zzaH()     // Catch:{ IllegalStateException -> 0x036c }
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0184
            r23.zzam()     // Catch:{ IllegalStateException -> 0x036c }
        L_0x0184:
            r2 = r10
            r1 = r15
            r19 = 0
            goto L_0x0332
        L_0x018a:
            com.google.android.gms.internal.ads.zzabb r0 = r15.zzap     // Catch:{ IllegalStateException -> 0x036c }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x036c }
        L_0x0192:
            if (r0 >= 0) goto L_0x01d6
            r1 = -2
            if (r0 != r1) goto L_0x01c6
            r15.zzae = r14     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzabb r0 = r15.zzap     // Catch:{ IllegalStateException -> 0x036c }
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ IllegalStateException -> 0x036c }
            int r1 = r15.zzD     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 == 0) goto L_0x01b8
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x036c }
            r2 = 32
            if (r1 != r2) goto L_0x01b8
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 != r2) goto L_0x01b8
            r15.zzM = r14     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x01e1
        L_0x01b8:
            boolean r1 = r15.zzK     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 == 0) goto L_0x01c1
            java.lang.String r1 = "channel-count"
            r0.setInteger(r1, r14)     // Catch:{ IllegalStateException -> 0x036c }
        L_0x01c1:
            r15.zzx = r0     // Catch:{ IllegalStateException -> 0x036c }
            r15.zzy = r14     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x01e1
        L_0x01c6:
            boolean r0 = r15.zzN     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0184
            boolean r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 != 0) goto L_0x01d2
            int r0 = r15.zzaa     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 != r12) goto L_0x0184
        L_0x01d2:
            r23.zzaH()     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x0184
        L_0x01d6:
            boolean r1 = r15.zzM     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 == 0) goto L_0x01e8
            r15.zzM = r13     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzabb r1 = r15.zzap     // Catch:{ IllegalStateException -> 0x036c }
            r1.zzh(r0, r13)     // Catch:{ IllegalStateException -> 0x036c }
        L_0x01e1:
            r2 = r10
            r1 = r15
            r0 = 2
            r19 = 0
            goto L_0x0321
        L_0x01e8:
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            int r1 = r1.size     // Catch:{ IllegalStateException -> 0x036c }
            if (r1 != 0) goto L_0x01fa
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            int r1 = r1.flags     // Catch:{ IllegalStateException -> 0x036c }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x01fa
            r23.zzaH()     // Catch:{ IllegalStateException -> 0x036c }
            goto L_0x0184
        L_0x01fa:
            r15.zzR = r0     // Catch:{ IllegalStateException -> 0x036c }
            com.google.android.gms.internal.ads.zzabb r1 = r15.zzap     // Catch:{ IllegalStateException -> 0x036c }
            java.nio.ByteBuffer r0 = r1.zze(r0)     // Catch:{ IllegalStateException -> 0x036c }
            r15.zzS = r0     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x021b
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x036c }
            r0.position(r1)     // Catch:{ IllegalStateException -> 0x036c }
            java.nio.ByteBuffer r0 = r15.zzS     // Catch:{ IllegalStateException -> 0x036c }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x036c }
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            int r2 = r2.size     // Catch:{ IllegalStateException -> 0x036c }
            int r1 = r1 + r2
            r0.limit(r1)     // Catch:{ IllegalStateException -> 0x036c }
        L_0x021b:
            boolean r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x036c }
            if (r0 == 0) goto L_0x0240
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x036c }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0240
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x036c }
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0240
            long r0 = r15.zzaf     // Catch:{ IllegalStateException -> 0x036c }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0240
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            r2.presentationTimeUs = r0     // Catch:{ IllegalStateException -> 0x036c }
        L_0x0240:
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x036c }
            java.util.ArrayList<java.lang.Long> r2 = r15.zzk     // Catch:{ IllegalStateException -> 0x036c }
            int r2 = r2.size()     // Catch:{ IllegalStateException -> 0x036c }
            r3 = 0
        L_0x024b:
            if (r3 >= r2) goto L_0x0267
            java.util.ArrayList<java.lang.Long> r4 = r15.zzk     // Catch:{ IllegalStateException -> 0x036c }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalStateException -> 0x036c }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IllegalStateException -> 0x036c }
            long r4 = r4.longValue()     // Catch:{ IllegalStateException -> 0x036c }
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x0264
            java.util.ArrayList<java.lang.Long> r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x036c }
            r0.remove(r3)     // Catch:{ IllegalStateException -> 0x036c }
            r0 = 1
            goto L_0x0268
        L_0x0264:
            int r3 = r3 + 1
            goto L_0x024b
        L_0x0267:
            r0 = 0
        L_0x0268:
            r15.zzT = r0     // Catch:{ IllegalStateException -> 0x036c }
            long r0 = r15.zzag     // Catch:{ IllegalStateException -> 0x036c }
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x036c }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0276
            r0 = 1
            goto L_0x0277
        L_0x0276:
            r0 = 0
        L_0x0277:
            r15.zzU = r0     // Catch:{ IllegalStateException -> 0x036c }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x036c }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x036c }
            r15.zzak(r0)     // Catch:{ IllegalStateException -> 0x036c }
        L_0x0280:
            boolean r0 = r15.zzI     // Catch:{ IllegalStateException -> 0x034a }
            if (r0 == 0) goto L_0x02dd
            boolean r0 = r15.zzad     // Catch:{ IllegalStateException -> 0x02d8 }
            if (r0 == 0) goto L_0x02dd
            com.google.android.gms.internal.ads.zzabb r6 = r15.zzap     // Catch:{ IllegalStateException -> 0x02be }
            java.nio.ByteBuffer r7 = r15.zzS     // Catch:{ IllegalStateException -> 0x02be }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x02be }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x02be }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x02be }
            r0 = 1
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x02be }
            long r4 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x02be }
            boolean r2 = r15.zzT     // Catch:{ IllegalStateException -> 0x02be }
            boolean r3 = r15.zzU     // Catch:{ IllegalStateException -> 0x02be }
            com.google.android.gms.internal.ads.zzkc r1 = r15.zzq     // Catch:{ IllegalStateException -> 0x02be }
            r16 = r1
            r1 = r23
            r17 = r2
            r18 = r3
            r2 = r24
            r19 = r4
            r4 = r26
            r21 = r10
            r10 = r0
            r0 = 2
            r11 = r19
            r19 = 0
            r13 = r17
            r14 = r18
            r15 = r16
            boolean r1 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x02c2 }
            goto L_0x0305
        L_0x02be:
            r21 = r10
            r19 = 0
        L_0x02c2:
            r23.zzaH()     // Catch:{ IllegalStateException -> 0x02d2 }
            r15 = r23
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0347 }
            if (r0 == 0) goto L_0x02ce
            r23.zzam()     // Catch:{ IllegalStateException -> 0x0347 }
        L_0x02ce:
            r1 = r15
        L_0x02cf:
            r2 = r21
            goto L_0x0332
        L_0x02d2:
            r0 = move-exception
            r2 = 1
        L_0x02d4:
            r1 = r23
            goto L_0x0371
        L_0x02d8:
            r0 = move-exception
            r19 = 0
            goto L_0x0348
        L_0x02dd:
            r21 = r10
            r0 = 2
            r19 = 0
            com.google.android.gms.internal.ads.zzabb r6 = r15.zzap     // Catch:{ IllegalStateException -> 0x0347 }
            java.nio.ByteBuffer r7 = r15.zzS     // Catch:{ IllegalStateException -> 0x0347 }
            int r8 = r15.zzR     // Catch:{ IllegalStateException -> 0x0347 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0347 }
            int r9 = r1.flags     // Catch:{ IllegalStateException -> 0x0347 }
            r10 = 1
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0347 }
            long r11 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0347 }
            boolean r13 = r15.zzT     // Catch:{ IllegalStateException -> 0x0347 }
            boolean r14 = r15.zzU     // Catch:{ IllegalStateException -> 0x0347 }
            com.google.android.gms.internal.ads.zzkc r4 = r15.zzq     // Catch:{ IllegalStateException -> 0x0347 }
            r1 = r23
            r2 = r24
            r16 = r4
            r4 = r26
            r15 = r16
            boolean r1 = r1.zzaf(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0343 }
        L_0x0305:
            if (r1 == 0) goto L_0x032f
            r1 = r23
            android.media.MediaCodec$BufferInfo r2 = r1.zzl     // Catch:{ IllegalStateException -> 0x0369 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0369 }
            r1.zzat(r2)     // Catch:{ IllegalStateException -> 0x0369 }
            android.media.MediaCodec$BufferInfo r2 = r1.zzl     // Catch:{ IllegalStateException -> 0x0369 }
            int r2 = r2.flags     // Catch:{ IllegalStateException -> 0x0369 }
            r23.zzaC()     // Catch:{ IllegalStateException -> 0x0369 }
            r2 = r2 & 4
            if (r2 == 0) goto L_0x031f
            r23.zzaH()     // Catch:{ IllegalStateException -> 0x0369 }
            goto L_0x02cf
        L_0x031f:
            r2 = r21
        L_0x0321:
            boolean r4 = r1.zzaz(r2)     // Catch:{ IllegalStateException -> 0x0369 }
            if (r4 != 0) goto L_0x0328
            goto L_0x0332
        L_0x0328:
            r15 = r1
            r10 = r2
            r12 = 2
            r13 = 0
            r14 = 1
            goto L_0x0163
        L_0x032f:
            r1 = r23
            goto L_0x02cf
        L_0x0332:
            boolean r0 = r23.zzaD()     // Catch:{ IllegalStateException -> 0x0369 }
            if (r0 == 0) goto L_0x033e
            boolean r0 = r1.zzaz(r2)     // Catch:{ IllegalStateException -> 0x0369 }
            if (r0 != 0) goto L_0x0332
        L_0x033e:
            com.google.android.gms.internal.ads.zzalf.zzb()     // Catch:{ IllegalStateException -> 0x0369 }
            r2 = 1
            goto L_0x0361
        L_0x0343:
            r0 = move-exception
            r1 = r23
            goto L_0x036a
        L_0x0347:
            r0 = move-exception
        L_0x0348:
            r1 = r15
            goto L_0x036a
        L_0x034a:
            r0 = move-exception
            r1 = r15
            r19 = 0
            goto L_0x036a
        L_0x034f:
            r1 = r15
            r19 = 0
            com.google.android.gms.internal.ads.zzro r0 = r1.zza     // Catch:{ IllegalStateException -> 0x0369 }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x0369 }
            int r3 = r23.zzG(r24)     // Catch:{ IllegalStateException -> 0x0369 }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x0369 }
            r2 = 1
            r1.zzae(r2)     // Catch:{ IllegalStateException -> 0x0367 }
        L_0x0361:
            com.google.android.gms.internal.ads.zzro r0 = r1.zza     // Catch:{ IllegalStateException -> 0x0367 }
            r0.zza()     // Catch:{ IllegalStateException -> 0x0367 }
            return
        L_0x0367:
            r0 = move-exception
            goto L_0x0371
        L_0x0369:
            r0 = move-exception
        L_0x036a:
            r2 = 1
            goto L_0x0371
        L_0x036c:
            r0 = move-exception
        L_0x036d:
            r1 = r15
            r2 = 1
            r19 = 0
        L_0x0371:
            int r3 = com.google.android.gms.internal.ads.zzalh.zza
            r4 = 21
            if (r3 < r4) goto L_0x037c
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x037c
            goto L_0x0391
        L_0x037c:
            java.lang.StackTraceElement[] r3 = r0.getStackTrace()
            int r5 = r3.length
            if (r5 <= 0) goto L_0x03ba
            r3 = r3[r19]
            java.lang.String r3 = r3.getClassName()
            java.lang.String r5 = "android.media.MediaCodec"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x03ba
        L_0x0391:
            r1.zzW(r0)
            int r3 = com.google.android.gms.internal.ads.zzalh.zza
            if (r3 < r4) goto L_0x03a7
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x03a7
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x03a7
            r14 = 1
            goto L_0x03a8
        L_0x03a7:
            r14 = 0
        L_0x03a8:
            if (r14 == 0) goto L_0x03ad
            r23.zzam()
        L_0x03ad:
            com.google.android.gms.internal.ads.zzaah r2 = r1.zzC
            com.google.android.gms.internal.ads.zzaag r0 = r1.zzar(r0, r2)
            com.google.android.gms.internal.ads.zzkc r2 = r1.zzp
            com.google.android.gms.internal.ads.zzio r0 = r1.zzE(r0, r2, r14)
            throw r0
        L_0x03ba:
            throw r0
        L_0x03bb:
            r2 = r13
            r1 = r15
            r1.zzal = r2
            goto L_0x03c1
        L_0x03c0:
            throw r0
        L_0x03c1:
            goto L_0x03c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaj.zzK(long, long):void");
    }

    public boolean zzL() {
        if (this.zzp != null) {
            if (zzH() || zzaA()) {
                return true;
            }
            if (this.zzP == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.zzP) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean zzM() {
        return this.zzai;
    }

    public final int zzN(zzkc zzkc) throws zzio {
        try {
            return zzO(this.zzd, zzkc);
        } catch (zzaas e) {
            throw zzE(e, zzkc, false);
        }
    }

    public abstract int zzO(zzaal zzaal, zzkc zzkc) throws zzaas;

    public abstract List<zzaah> zzP(zzaal zzaal, zzkc zzkc, boolean z) throws zzaas;

    public boolean zzQ(zzkc zzkc) {
        return false;
    }

    @Nullable
    public abstract zzaad zzR(zzaah zzaah, zzkc zzkc, @Nullable MediaCrypto mediaCrypto, float f);

    public zzrs zzS(zzaah zzaah, zzkc zzkc, zzkc zzkc2) {
        throw null;
    }

    public float zzT(float f, zzkc zzkc, zzkc[] zzkcArr) {
        throw null;
    }

    public void zzU(String str, long j, long j2) {
        throw null;
    }

    public void zzV(String str) {
        throw null;
    }

    public void zzW(Exception exc) {
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        if (zzaF() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
        if (zzaF() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009a, code lost:
        if (zzaF() == false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf A[RETURN] */
    @androidx.annotation.CallSuper
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzrs zzX(com.google.android.gms.internal.ads.zzkd r13) throws com.google.android.gms.internal.ads.zzio {
        /*
            r12 = this;
            r0 = 1
            r12.zzaj = r0
            com.google.android.gms.internal.ads.zzkc r4 = r13.zza
            r1 = 0
            if (r4 == 0) goto L_0x0105
            java.lang.String r2 = r4.zzl
            r3 = 0
            if (r2 == 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzsj r13 = r13.zzb
            r12.zzar = r13
            r12.zzp = r4
            boolean r2 = r12.zzV
            if (r2 == 0) goto L_0x001a
            r12.zzX = r0
            return r1
        L_0x001a:
            com.google.android.gms.internal.ads.zzabb r2 = r12.zzap
            if (r2 != 0) goto L_0x0024
            r12.zzA = r1
            r12.zzag()
            return r1
        L_0x0024:
            com.google.android.gms.internal.ads.zzaah r1 = r12.zzC
            com.google.android.gms.internal.ads.zzkc r5 = r12.zzw
            com.google.android.gms.internal.ads.zzsj r6 = r12.zzaq
            r7 = 23
            if (r6 != r13) goto L_0x00d0
            if (r13 == r6) goto L_0x0037
            int r8 = com.google.android.gms.internal.ads.zzalh.zza
            if (r8 < r7) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r7 = 0
            goto L_0x0038
        L_0x0037:
            r7 = 1
        L_0x0038:
            com.google.android.gms.internal.ads.zzajg.zzd(r7)
            com.google.android.gms.internal.ads.zzrs r7 = r12.zzS(r1, r5, r4)
            int r8 = r7.zzd
            r9 = 3
            r10 = 16
            r11 = 2
            if (r8 == 0) goto L_0x00b3
            if (r8 == r0) goto L_0x0089
            if (r8 == r11) goto L_0x005d
            boolean r0 = r12.zzaE(r4)
            if (r0 != 0) goto L_0x0052
            goto L_0x008f
        L_0x0052:
            r12.zzw = r4
            if (r13 == r6) goto L_0x00b6
            boolean r13 = r12.zzaF()
            if (r13 != 0) goto L_0x00b6
            goto L_0x009c
        L_0x005d:
            boolean r8 = r12.zzaE(r4)
            if (r8 != 0) goto L_0x0064
            goto L_0x008f
        L_0x0064:
            r12.zzY = r0
            r12.zzZ = r0
            int r8 = r12.zzD
            if (r8 == r11) goto L_0x007c
            if (r8 != r0) goto L_0x007b
            int r8 = r4.zzq
            int r10 = r5.zzq
            if (r8 != r10) goto L_0x007b
            int r8 = r4.zzr
            int r10 = r5.zzr
            if (r8 != r10) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r0 = 0
        L_0x007c:
            r12.zzL = r0
            r12.zzw = r4
            if (r13 == r6) goto L_0x00b6
            boolean r13 = r12.zzaF()
            if (r13 != 0) goto L_0x00b6
            goto L_0x009c
        L_0x0089:
            boolean r8 = r12.zzaE(r4)
            if (r8 != 0) goto L_0x0092
        L_0x008f:
            r6 = 16
            goto L_0x00b7
        L_0x0092:
            r12.zzw = r4
            if (r13 == r6) goto L_0x009e
            boolean r13 = r12.zzaF()
            if (r13 != 0) goto L_0x00b6
        L_0x009c:
            r6 = 2
            goto L_0x00b7
        L_0x009e:
            boolean r13 = r12.zzac
            if (r13 == 0) goto L_0x00b6
            r12.zzaa = r0
            boolean r13 = r12.zzF
            if (r13 != 0) goto L_0x00b0
            boolean r13 = r12.zzH
            if (r13 == 0) goto L_0x00ad
            goto L_0x00b0
        L_0x00ad:
            r12.zzab = r0
            goto L_0x00b6
        L_0x00b0:
            r12.zzab = r9
            goto L_0x009c
        L_0x00b3:
            r12.zzaG()
        L_0x00b6:
            r6 = 0
        L_0x00b7:
            int r13 = r7.zzd
            if (r13 == 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzabb r13 = r12.zzap
            if (r13 != r2) goto L_0x00c3
            int r13 = r12.zzab
            if (r13 != r9) goto L_0x00cf
        L_0x00c3:
            com.google.android.gms.internal.ads.zzrs r13 = new com.google.android.gms.internal.ads.zzrs
            java.lang.String r2 = r1.zza
            r0 = 0
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00cf:
            return r7
        L_0x00d0:
            if (r13 == 0) goto L_0x00ea
            if (r6 != 0) goto L_0x00d5
            goto L_0x00ea
        L_0x00d5:
            int r13 = com.google.android.gms.internal.ads.zzalh.zza
            if (r13 < r7) goto L_0x00ea
            java.util.UUID r13 = com.google.android.gms.internal.ads.zzig.zze
            java.util.UUID r0 = com.google.android.gms.internal.ads.zzig.zza
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ea
            java.util.UUID r13 = com.google.android.gms.internal.ads.zzig.zze
            java.util.UUID r0 = com.google.android.gms.internal.ads.zzig.zza
            r13.equals(r0)
        L_0x00ea:
            r12.zzaG()
            com.google.android.gms.internal.ads.zzrs r13 = new com.google.android.gms.internal.ads.zzrs
            java.lang.String r2 = r1.zza
            r0 = 0
            r6 = 128(0x80, float:1.794E-43)
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00fb:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>()
            com.google.android.gms.internal.ads.zzio r13 = r12.zzE(r13, r4, r3)
            throw r13
        L_0x0105:
            goto L_0x0107
        L_0x0106:
            throw r1
        L_0x0107:
            goto L_0x0106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaj.zzX(com.google.android.gms.internal.ads.zzkd):com.google.android.gms.internal.ads.zzrs");
    }

    public void zzY(zzkc zzkc, @Nullable MediaFormat mediaFormat) throws zzio {
        throw null;
    }

    public void zzaa(zzrr zzrr) throws zzio {
        throw null;
    }

    public void zzab() {
    }

    public void zzac() throws zzio {
    }

    public abstract boolean zzaf(long j, long j2, @Nullable zzabb zzabb, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzkc zzkc) throws zzio;

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [com.google.android.gms.internal.ads.zzaaz, android.media.MediaCrypto] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01e1 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e3 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0218 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0232 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0234 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x023b A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0266 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x027e A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0280 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02d5 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02d7 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02ec A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02ee A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02f7 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x033c A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x033d A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0351 A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x035f A[Catch:{ Exception -> 0x0389, zzaas -> 0x0090, zzaai -> 0x03e4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzag() throws com.google.android.gms.internal.ads.zzio {
        /*
            r16 = this;
            r7 = r16
            com.google.android.gms.internal.ads.zzabb r0 = r7.zzap
            if (r0 != 0) goto L_0x03ed
            boolean r0 = r7.zzV
            if (r0 != 0) goto L_0x03ed
            com.google.android.gms.internal.ads.zzkc r0 = r7.zzp
            if (r0 != 0) goto L_0x0010
            goto L_0x03ed
        L_0x0010:
            com.google.android.gms.internal.ads.zzsj r1 = r7.zzar
            r8 = 1
            if (r1 != 0) goto L_0x004a
            boolean r0 = r7.zzQ(r0)
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzkc r0 = r7.zzp
            r16.zzZ()
            java.lang.String r0 = r0.zzl
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0040
            java.lang.String r1 = "audio/mpeg"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0040
            java.lang.String r1 = "audio/opus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0040
            com.google.android.gms.internal.ads.zzaab r0 = r7.zzi
            r0.zzl(r8)
            goto L_0x0047
        L_0x0040:
            com.google.android.gms.internal.ads.zzaab r0 = r7.zzi
            r1 = 32
            r0.zzl(r1)
        L_0x0047:
            r7.zzV = r8
            return
        L_0x004a:
            com.google.android.gms.internal.ads.zzsj r0 = r7.zzar
            r7.zzaq = r0
            com.google.android.gms.internal.ads.zzkc r1 = r7.zzp
            java.lang.String r1 = r1.zzl
            r9 = 0
            if (r0 == 0) goto L_0x0065
            boolean r1 = com.google.android.gms.internal.ads.zzsk.zza
            if (r1 != 0) goto L_0x005a
            goto L_0x0065
        L_0x005a:
            com.google.android.gms.internal.ads.zzsb r0 = r0.zza()
            com.google.android.gms.internal.ads.zzkc r1 = r7.zzp
            com.google.android.gms.internal.ads.zzio r0 = r7.zzE(r0, r1, r9)
            throw r0
        L_0x0065:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaah> r0 = r7.zzA     // Catch:{ zzaai -> 0x03e4 }
            r10 = 0
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzaal r0 = r7.zzd     // Catch:{ zzaas -> 0x0090 }
            com.google.android.gms.internal.ads.zzkc r1 = r7.zzp     // Catch:{ zzaas -> 0x0090 }
            java.util.List r0 = r7.zzP(r0, r1, r9)     // Catch:{ zzaas -> 0x0090 }
            r0.isEmpty()     // Catch:{ zzaas -> 0x0090 }
            java.util.ArrayDeque r1 = new java.util.ArrayDeque     // Catch:{ zzaas -> 0x0090 }
            r1.<init>()     // Catch:{ zzaas -> 0x0090 }
            r7.zzA = r1     // Catch:{ zzaas -> 0x0090 }
            boolean r1 = r0.isEmpty()     // Catch:{ zzaas -> 0x0090 }
            if (r1 != 0) goto L_0x008d
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaah> r1 = r7.zzA     // Catch:{ zzaas -> 0x0090 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ zzaas -> 0x0090 }
            com.google.android.gms.internal.ads.zzaah r0 = (com.google.android.gms.internal.ads.zzaah) r0     // Catch:{ zzaas -> 0x0090 }
            r1.add(r0)     // Catch:{ zzaas -> 0x0090 }
        L_0x008d:
            r7.zzB = r10     // Catch:{ zzaas -> 0x0090 }
            goto L_0x009c
        L_0x0090:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzaai r1 = new com.google.android.gms.internal.ads.zzaai     // Catch:{ zzaai -> 0x03e4 }
            com.google.android.gms.internal.ads.zzkc r2 = r7.zzp     // Catch:{ zzaai -> 0x03e4 }
            r3 = -49998(0xffffffffffff3cb2, float:NaN)
            r1.<init>((com.google.android.gms.internal.ads.zzkc) r2, (java.lang.Throwable) r0, (boolean) r9, (int) r3)     // Catch:{ zzaai -> 0x03e4 }
            throw r1     // Catch:{ zzaai -> 0x03e4 }
        L_0x009c:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaah> r0 = r7.zzA     // Catch:{ zzaai -> 0x03e4 }
            boolean r0 = r0.isEmpty()     // Catch:{ zzaai -> 0x03e4 }
            if (r0 != 0) goto L_0x03d7
        L_0x00a4:
            com.google.android.gms.internal.ads.zzabb r0 = r7.zzap     // Catch:{ zzaai -> 0x03e4 }
            if (r0 != 0) goto L_0x03d3
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaah> r0 = r7.zzA     // Catch:{ zzaai -> 0x03e4 }
            java.lang.Object r0 = r0.peekFirst()     // Catch:{ zzaai -> 0x03e4 }
            r11 = r0
            com.google.android.gms.internal.ads.zzaah r11 = (com.google.android.gms.internal.ads.zzaah) r11     // Catch:{ zzaai -> 0x03e4 }
            boolean r0 = r7.zzah(r11)     // Catch:{ zzaai -> 0x03e4 }
            if (r0 != 0) goto L_0x00b8
            return
        L_0x00b8:
            java.lang.String r2 = r11.zza     // Catch:{ Exception -> 0x0389 }
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3 = 23
            if (r0 >= r3) goto L_0x00c5
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x00d1
        L_0x00c5:
            float r0 = r7.zzv     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzkc r4 = r7.zzp     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzkc[] r5 = r16.zzC()     // Catch:{ Exception -> 0x0389 }
            float r0 = r7.zzT(r0, r4, r5)     // Catch:{ Exception -> 0x0389 }
        L_0x00d1:
            float r4 = r7.zze     // Catch:{ Exception -> 0x0389 }
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r1 = r0
        L_0x00d9:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0389 }
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0389 }
            int r6 = r0.length()     // Catch:{ Exception -> 0x0389 }
            java.lang.String r12 = "createCodec:"
            if (r6 == 0) goto L_0x00ee
            java.lang.String r0 = r12.concat(r0)     // Catch:{ Exception -> 0x0389 }
            goto L_0x00f3
        L_0x00ee:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0389 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x0389 }
        L_0x00f3:
            com.google.android.gms.internal.ads.zzalf.zza(r0)     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzkc r0 = r7.zzp     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzaad r0 = r7.zzR(r11, r0, r10, r1)     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzaah r6 = r0.zza     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            if (r6 == 0) goto L_0x037d
            java.lang.String r6 = r6.zza     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            java.lang.String r13 = java.lang.String.valueOf(r6)     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            int r14 = r13.length()     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            if (r14 == 0) goto L_0x0111
            java.lang.String r12 = r12.concat(r13)     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            goto L_0x0117
        L_0x0111:
            java.lang.String r13 = new java.lang.String     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            r13.<init>(r12)     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            r12 = r13
        L_0x0117:
            com.google.android.gms.internal.ads.zzalf.zza(r12)     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            android.media.MediaCodec r6 = android.media.MediaCodec.createByCodecName(r6)     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            com.google.android.gms.internal.ads.zzalf.zzb()     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
            java.lang.String r12 = "configureCodec"
            com.google.android.gms.internal.ads.zzalf.zza(r12)     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            android.media.MediaFormat r12 = r0.zzb     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            android.view.Surface r0 = r0.zzd     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            r6.configure(r12, r0, r10, r9)     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            com.google.android.gms.internal.ads.zzalf.zzb()     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            java.lang.String r0 = "startCodec"
            com.google.android.gms.internal.ads.zzalf.zza(r0)     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            r6.start()     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            com.google.android.gms.internal.ads.zzalf.zzb()     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            com.google.android.gms.internal.ads.zzabb r0 = new com.google.android.gms.internal.ads.zzabb     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            r0.<init>(r6, r10)     // Catch:{ IOException -> 0x037b, RuntimeException -> 0x0379 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0389 }
            r7.zzap = r0     // Catch:{ Exception -> 0x0389 }
            r7.zzC = r11     // Catch:{ Exception -> 0x0389 }
            r7.zzz = r1     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzkc r0 = r7.zzp     // Catch:{ Exception -> 0x0389 }
            r7.zzw = r0     // Catch:{ Exception -> 0x0389 }
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            java.lang.String r1 = "OMX.Exynos.avc.dec.secure"
            r6 = 25
            if (r0 > r6) goto L_0x0186
            boolean r0 = r1.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x0186
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzd     // Catch:{ Exception -> 0x0389 }
            java.lang.String r15 = "SM-T585"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0184
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzd     // Catch:{ Exception -> 0x0389 }
            java.lang.String r15 = "SM-A510"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0184
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzd     // Catch:{ Exception -> 0x0389 }
            java.lang.String r15 = "SM-A520"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0184
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzd     // Catch:{ Exception -> 0x0389 }
            java.lang.String r15 = "SM-J700"
            boolean r0 = r0.startsWith(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x0186
        L_0x0184:
            r0 = 2
            goto L_0x01c7
        L_0x0186:
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            r15 = 24
            if (r0 >= r15) goto L_0x01c6
            java.lang.String r0 = "OMX.Nvidia.h264.decode"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x019c
            java.lang.String r0 = "OMX.Nvidia.h264.decode.secure"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x01c6
        L_0x019c:
            java.lang.String r0 = "flounder"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x01c4
            java.lang.String r0 = "flounder_lte"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x01c4
            java.lang.String r0 = "grouper"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x01c4
            java.lang.String r0 = "tilapia"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r15)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x01c6
        L_0x01c4:
            r0 = 1
            goto L_0x01c7
        L_0x01c6:
            r0 = 0
        L_0x01c7:
            r7.zzD = r0     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzkc r0 = r7.zzw     // Catch:{ Exception -> 0x0389 }
            int r15 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            r9 = 21
            if (r15 >= r9) goto L_0x01e3
            java.util.List<byte[]> r0 = r0.zzn     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x01e3
            java.lang.String r0 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x01e3
            r0 = 1
            goto L_0x01e4
        L_0x01e3:
            r0 = 0
        L_0x01e4:
            r7.zzE = r0     // Catch:{ Exception -> 0x0389 }
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            r15 = 19
            r10 = 18
            if (r0 < r10) goto L_0x0221
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r0 != r10) goto L_0x0202
            java.lang.String r0 = "OMX.SEC.avc.dec"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0221
            java.lang.String r0 = "OMX.SEC.avc.dec.secure"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0221
        L_0x0202:
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r0 != r15) goto L_0x021f
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzd     // Catch:{ Exception -> 0x0389 }
            java.lang.String r14 = "SM-G800"
            boolean r0 = r0.startsWith(r14)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x021f
            java.lang.String r0 = "OMX.Exynos.avc.dec"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0221
            boolean r0 = r1.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x021f
            goto L_0x0221
        L_0x021f:
            r0 = 0
            goto L_0x0222
        L_0x0221:
            r0 = 1
        L_0x0222:
            r7.zzF = r0     // Catch:{ Exception -> 0x0389 }
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            r1 = 29
            if (r0 != r1) goto L_0x0234
            java.lang.String r0 = "c2.android.aac.decoder"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x0234
            r0 = 1
            goto L_0x0235
        L_0x0234:
            r0 = 0
        L_0x0235:
            r7.zzG = r0     // Catch:{ Exception -> 0x0389 }
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r0 > r3) goto L_0x0246
            java.lang.String r0 = "OMX.google.vorbis.decoder"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0244
            goto L_0x0246
        L_0x0244:
            r0 = 1
            goto L_0x0270
        L_0x0246:
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r0 > r15) goto L_0x026f
            java.lang.String r0 = "hb2000"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x025e
            java.lang.String r0 = "stvm8"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x026f
        L_0x025e:
            java.lang.String r0 = "OMX.amlogic.avc.decoder.awesome"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0244
            java.lang.String r0 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x026f
            goto L_0x0244
        L_0x026f:
            r0 = 0
        L_0x0270:
            r7.zzH = r0     // Catch:{ Exception -> 0x0389 }
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r0 != r9) goto L_0x0280
            java.lang.String r0 = "OMX.google.aac.decoder"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x0280
            r0 = 1
            goto L_0x0281
        L_0x0280:
            r0 = 0
        L_0x0281:
            r7.zzI = r0     // Catch:{ Exception -> 0x0389 }
            int r0 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r0 >= r9) goto L_0x02d7
            java.lang.String r0 = "OMX.SEC.mp3.dec"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x02d7
            java.lang.String r0 = "samsung"
            java.lang.String r3 = com.google.android.gms.internal.ads.zzalh.zzc     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x02d7
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            java.lang.String r3 = "baffin"
            boolean r0 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x02d5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            java.lang.String r3 = "grand"
            boolean r0 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x02d5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            java.lang.String r3 = "fortuna"
            boolean r0 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x02d5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            java.lang.String r3 = "gprimelte"
            boolean r0 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x02d5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            java.lang.String r3 = "j2y18lte"
            boolean r0 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x02d5
            java.lang.String r0 = com.google.android.gms.internal.ads.zzalh.zzb     // Catch:{ Exception -> 0x0389 }
            java.lang.String r3 = "ms01"
            boolean r0 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x02d7
        L_0x02d5:
            r0 = 1
            goto L_0x02d8
        L_0x02d7:
            r0 = 0
        L_0x02d8:
            r7.zzJ = r0     // Catch:{ Exception -> 0x0389 }
            com.google.android.gms.internal.ads.zzkc r0 = r7.zzw     // Catch:{ Exception -> 0x0389 }
            int r3 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r3 > r10) goto L_0x02ee
            int r0 = r0.zzy     // Catch:{ Exception -> 0x0389 }
            if (r0 != r8) goto L_0x02ee
            java.lang.String r0 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x02ee
            r0 = 1
            goto L_0x02ef
        L_0x02ee:
            r0 = 0
        L_0x02ef:
            r7.zzK = r0     // Catch:{ Exception -> 0x0389 }
            java.lang.String r0 = r11.zza     // Catch:{ Exception -> 0x0389 }
            int r3 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r3 > r6) goto L_0x0302
            java.lang.String r3 = "OMX.rk.video_decoder.avc"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0389 }
            if (r3 != 0) goto L_0x0300
            goto L_0x0302
        L_0x0300:
            r0 = 1
            goto L_0x0345
        L_0x0302:
            int r3 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            r6 = 17
            if (r3 > r6) goto L_0x0310
            java.lang.String r3 = "OMX.allwinner.video.decoder.avc"
            boolean r3 = r3.equals(r0)     // Catch:{ Exception -> 0x0389 }
            if (r3 != 0) goto L_0x0300
        L_0x0310:
            int r3 = com.google.android.gms.internal.ads.zzalh.zza     // Catch:{ Exception -> 0x0389 }
            if (r3 > r1) goto L_0x0324
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel"
            boolean r1 = r1.equals(r0)     // Catch:{ Exception -> 0x0389 }
            if (r1 != 0) goto L_0x0300
            java.lang.String r1 = "OMX.broadcom.video_decoder.tunnel.secure"
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0389 }
            if (r0 != 0) goto L_0x0300
        L_0x0324:
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzalh.zzc     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x033d
            java.lang.String r0 = "AFTS"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzalh.zzd     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x033d
            boolean r0 = r11.zzf     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x033d
            goto L_0x0300
        L_0x033d:
            boolean r0 = r16.zzai()     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x0344
            goto L_0x0300
        L_0x0344:
            r0 = 0
        L_0x0345:
            r7.zzN = r0     // Catch:{ Exception -> 0x0389 }
            java.lang.String r0 = "c2.android.mp3.decoder"
            java.lang.String r1 = r11.zza     // Catch:{ Exception -> 0x0389 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0389 }
            if (r0 == 0) goto L_0x0358
            com.google.android.gms.internal.ads.zzaac r0 = new com.google.android.gms.internal.ads.zzaac     // Catch:{ Exception -> 0x0389 }
            r0.<init>()     // Catch:{ Exception -> 0x0389 }
            r7.zzO = r0     // Catch:{ Exception -> 0x0389 }
        L_0x0358:
            int r0 = r16.zze()     // Catch:{ Exception -> 0x0389 }
            r1 = 2
            if (r0 != r1) goto L_0x0368
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0389 }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r9
            r7.zzP = r0     // Catch:{ Exception -> 0x0389 }
        L_0x0368:
            com.google.android.gms.internal.ads.zzro r0 = r7.zza     // Catch:{ Exception -> 0x0389 }
            int r1 = r0.zza     // Catch:{ Exception -> 0x0389 }
            int r1 = r1 + r8
            r0.zza = r1     // Catch:{ Exception -> 0x0389 }
            long r9 = r12 - r4
            r1 = r16
            r3 = r12
            r5 = r9
            r1.zzU(r2, r3, r5)     // Catch:{ Exception -> 0x0389 }
            goto L_0x03cc
        L_0x0379:
            r0 = move-exception
            goto L_0x0383
        L_0x037b:
            r0 = move-exception
            goto L_0x0383
        L_0x037d:
            r1 = r10
            throw r1     // Catch:{ IOException -> 0x0381, RuntimeException -> 0x037f }
        L_0x037f:
            r0 = move-exception
            goto L_0x0382
        L_0x0381:
            r0 = move-exception
        L_0x0382:
            r6 = 0
        L_0x0383:
            if (r6 == 0) goto L_0x0388
            r6.release()     // Catch:{ Exception -> 0x0389 }
        L_0x0388:
            throw r0     // Catch:{ Exception -> 0x0389 }
        L_0x0389:
            r0 = move-exception
            java.lang.String r1 = "MediaCodecRenderer"
            java.lang.String r2 = java.lang.String.valueOf(r11)     // Catch:{ zzaai -> 0x03e4 }
            int r3 = r2.length()     // Catch:{ zzaai -> 0x03e4 }
            int r3 = r3 + 30
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzaai -> 0x03e4 }
            r4.<init>(r3)     // Catch:{ zzaai -> 0x03e4 }
            java.lang.String r3 = "Failed to initialize decoder: "
            r4.append(r3)     // Catch:{ zzaai -> 0x03e4 }
            r4.append(r2)     // Catch:{ zzaai -> 0x03e4 }
            java.lang.String r2 = r4.toString()     // Catch:{ zzaai -> 0x03e4 }
            com.google.android.gms.internal.ads.zzaka.zza(r1, r2, r0)     // Catch:{ zzaai -> 0x03e4 }
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaah> r1 = r7.zzA     // Catch:{ zzaai -> 0x03e4 }
            r1.removeFirst()     // Catch:{ zzaai -> 0x03e4 }
            com.google.android.gms.internal.ads.zzaai r1 = new com.google.android.gms.internal.ads.zzaai     // Catch:{ zzaai -> 0x03e4 }
            com.google.android.gms.internal.ads.zzkc r2 = r7.zzp     // Catch:{ zzaai -> 0x03e4 }
            r3 = 0
            r1.<init>((com.google.android.gms.internal.ads.zzkc) r2, (java.lang.Throwable) r0, (boolean) r3, (com.google.android.gms.internal.ads.zzaah) r11)     // Catch:{ zzaai -> 0x03e4 }
            com.google.android.gms.internal.ads.zzaai r0 = r7.zzB     // Catch:{ zzaai -> 0x03e4 }
            if (r0 != 0) goto L_0x03be
            r7.zzB = r1     // Catch:{ zzaai -> 0x03e4 }
            goto L_0x03c4
        L_0x03be:
            com.google.android.gms.internal.ads.zzaai r0 = com.google.android.gms.internal.ads.zzaai.zza(r0, r1)     // Catch:{ zzaai -> 0x03e4 }
            r7.zzB = r0     // Catch:{ zzaai -> 0x03e4 }
        L_0x03c4:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaah> r0 = r7.zzA     // Catch:{ zzaai -> 0x03e4 }
            boolean r0 = r0.isEmpty()     // Catch:{ zzaai -> 0x03e4 }
            if (r0 != 0) goto L_0x03d0
        L_0x03cc:
            r9 = 0
            r10 = 0
            goto L_0x00a4
        L_0x03d0:
            com.google.android.gms.internal.ads.zzaai r0 = r7.zzB     // Catch:{ zzaai -> 0x03e4 }
            throw r0     // Catch:{ zzaai -> 0x03e4 }
        L_0x03d3:
            r1 = r10
            r7.zzA = r1     // Catch:{ zzaai -> 0x03e4 }
            return
        L_0x03d7:
            com.google.android.gms.internal.ads.zzaai r0 = new com.google.android.gms.internal.ads.zzaai     // Catch:{ zzaai -> 0x03e4 }
            com.google.android.gms.internal.ads.zzkc r1 = r7.zzp     // Catch:{ zzaai -> 0x03e4 }
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r3 = 0
            r4 = 0
            r0.<init>((com.google.android.gms.internal.ads.zzkc) r1, (java.lang.Throwable) r3, (boolean) r4, (int) r2)     // Catch:{ zzaai -> 0x03e4 }
            throw r0     // Catch:{ zzaai -> 0x03e4 }
        L_0x03e4:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzkc r1 = r7.zzp
            r2 = 0
            com.google.android.gms.internal.ads.zzio r0 = r7.zzE(r0, r1, r2)
            throw r0
        L_0x03ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaj.zzag():void");
    }

    public boolean zzah(zzaah zzaah) {
        return true;
    }

    public boolean zzai() {
        return false;
    }

    public final void zzaj(zzio zzio) {
        this.zzal = zzio;
    }

    public final void zzak(long j) throws zzio {
        zzkc zze2 = this.zzj.zze(j);
        if (zze2 == null && this.zzy) {
            zze2 = this.zzj.zzd();
        }
        if (zze2 != null) {
            this.zzq = zze2;
        } else if (!this.zzy || this.zzq == null) {
            return;
        }
        zzY(this.zzq, this.zzx);
        this.zzy = false;
    }

    @Nullable
    public final zzaah zzal() {
        return this.zzC;
    }

    public final void zzam() {
        try {
            zzabb zzabb = this.zzap;
            if (zzabb != null) {
                zzabb.zzk();
                this.zza.zzb++;
                zzV(this.zzC.zza);
            }
        } finally {
            this.zzap = null;
            this.zzr = null;
            this.zzaq = null;
            zzaq();
        }
    }

    public final boolean zzan() throws zzio {
        boolean zzao2 = zzao();
        if (zzao2) {
            zzag();
        }
        return zzao2;
    }

    public final boolean zzao() {
        if (this.zzap == null) {
            return false;
        }
        if (this.zzab == 3 || this.zzF || ((this.zzG && !this.zzae) || (this.zzH && this.zzad))) {
            zzam();
            return true;
        }
        zzad();
        return false;
    }

    @CallSuper
    public void zzap() {
        zzaB();
        zzaC();
        this.zzP = -9223372036854775807L;
        this.zzad = false;
        this.zzac = false;
        this.zzL = false;
        this.zzM = false;
        this.zzT = false;
        this.zzU = false;
        this.zzk.clear();
        this.zzaf = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
        zzaac zzaac = this.zzO;
        if (zzaac != null) {
            zzaac.zza();
        }
        this.zzaa = 0;
        this.zzab = 0;
        this.zzZ = this.zzY ? 1 : 0;
    }

    @CallSuper
    public final void zzaq() {
        zzap();
        this.zzal = null;
        this.zzO = null;
        this.zzA = null;
        this.zzC = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = false;
        this.zzae = false;
        this.zzz = -1.0f;
        this.zzD = 0;
        this.zzE = false;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzN = false;
        this.zzY = false;
        this.zzZ = 0;
        this.zzs = false;
    }

    public zzaag zzar(Throwable th, @Nullable zzaah zzaah) {
        return new zzaag(th, zzaah);
    }

    public void zzas(zzrr zzrr) throws zzio {
    }

    @CallSuper
    public void zzat(long j) {
        while (true) {
            int i = this.zzao;
            if (i != 0 && j >= this.zzo[0]) {
                long[] jArr = this.zzm;
                this.zzam = jArr[0];
                this.zzan = this.zzn[0];
                int i2 = i - 1;
                this.zzao = i2;
                System.arraycopy(jArr, 1, jArr, 0, i2);
                long[] jArr2 = this.zzn;
                System.arraycopy(jArr2, 1, jArr2, 0, this.zzao);
                long[] jArr3 = this.zzo;
                System.arraycopy(jArr3, 1, jArr3, 0, this.zzao);
                zzab();
            } else {
                return;
            }
        }
    }

    public final float zzau() {
        return this.zzu;
    }

    public final void zzav() {
        this.zzak = true;
    }

    public final long zzaw() {
        return this.zzan;
    }

    @Nullable
    public final zzabb zzay() {
        return this.zzap;
    }

    public final int zzs() {
        return 8;
    }

    public void zzu(boolean z, boolean z2) throws zzio {
        this.zza = new zzro();
    }

    public final void zzv(zzkc[] zzkcArr, long j, long j2) throws zzio {
        boolean z = true;
        if (this.zzan == -9223372036854775807L) {
            if (this.zzam != -9223372036854775807L) {
                z = false;
            }
            zzajg.zzd(z);
            this.zzam = j;
            this.zzan = j2;
            return;
        }
        int i = this.zzao;
        if (i == 10) {
            long j3 = this.zzn[9];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j3);
            Log.w("MediaCodecRenderer", sb.toString());
        } else {
            this.zzao = i + 1;
        }
        long[] jArr = this.zzm;
        int i2 = this.zzao - 1;
        jArr[i2] = j;
        this.zzn[i2] = j2;
        this.zzo[i2] = this.zzaf;
    }

    public void zzw(long j, boolean z) throws zzio {
        this.zzah = false;
        this.zzai = false;
        this.zzak = false;
        if (this.zzV) {
            this.zzi.zza();
            this.zzh.zza();
            this.zzW = false;
        } else {
            zzan();
        }
        if (this.zzj.zzc() > 0) {
            this.zzaj = true;
        }
        this.zzj.zzb();
        int i = this.zzao;
        if (i != 0) {
            int i2 = i - 1;
            this.zzan = this.zzn[i2];
            this.zzam = this.zzm[i2];
            this.zzao = 0;
        }
    }

    public void zzz() {
        this.zzp = null;
        this.zzam = -9223372036854775807L;
        this.zzan = -9223372036854775807L;
        this.zzao = 0;
        if (this.zzar == null && this.zzaq == null) {
            zzao();
        } else {
            zzA();
        }
    }
}
