package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.AppEventsConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaew implements zzadt, zztd, zzais, zzaiw, zzafh {
    public static final Map<String, String> zzb;
    public static final zzkc zzc;
    public boolean zzA;
    public int zzB;
    public boolean zzC;
    public boolean zzD;
    public int zzE;
    public long zzF;
    public long zzG;
    public long zzH;
    public boolean zzI;
    public int zzJ;
    public boolean zzK;
    public boolean zzL;
    public final zzaih zzM;
    public final zzahy zzN;
    public final Uri zzd;
    public final zzaht zze;
    public final zzsi zzf;
    public final zzaee zzg;
    public final zzsd zzh;
    public final zzaes zzi;
    public final long zzj;
    public final zzaiz zzk = new zzaiz("ProgressiveMediaPeriod");
    public final zzaen zzl;
    public final zzajj zzm;
    public final Runnable zzn;
    public final Runnable zzo;
    public final Handler zzp;
    @Nullable
    public zzads zzq;
    @Nullable
    public zzabp zzr;
    public zzafi[] zzs;
    public zzaeu[] zzt;
    public boolean zzu;
    public boolean zzv;
    public boolean zzw;
    public zzaev zzx;
    public zztv zzy;
    public long zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zzb = Collections.unmodifiableMap(hashMap);
        zzkb zzkb = new zzkb();
        zzkb.zza("icy");
        zzkb.zzj("application/x-icy");
        zzc = zzkb.zzD();
    }

    public zzaew(Uri uri, zzaht zzaht, zzaen zzaen, zzsi zzsi, zzsd zzsd, zzaih zzaih, zzaee zzaee, zzaes zzaes, zzahy zzahy, @Nullable String str, int i, byte[] bArr) {
        this.zzd = uri;
        this.zze = zzaht;
        this.zzf = zzsi;
        this.zzh = zzsd;
        this.zzM = zzaih;
        this.zzg = zzaee;
        this.zzi = zzaes;
        this.zzN = zzahy;
        this.zzj = (long) i;
        this.zzl = zzaen;
        this.zzm = new zzajj(zzajh.zza);
        this.zzn = new zzaeo(this);
        this.zzo = new zzaep(this);
        this.zzp = zzalh.zzh((Handler.Callback) null);
        this.zzt = new zzaeu[0];
        this.zzs = new zzafi[0];
        this.zzH = -9223372036854775807L;
        this.zzF = -1;
        this.zzz = -9223372036854775807L;
        this.zzB = 1;
    }

    private final void zzL(int i) {
        zzV();
        zzaev zzaev = this.zzx;
        boolean[] zArr = zzaev.zzd;
        if (!zArr[i]) {
            zzkc zza = zzaev.zza.zza(i).zza(0);
            this.zzg.zzl(zzakg.zzf(zza.zzl), zza, 0, (Object) null, this.zzG);
            zArr[i] = true;
        }
    }

    private final void zzM(int i) {
        zzV();
        boolean[] zArr = this.zzx.zzb;
        if (this.zzI && zArr[i] && !this.zzs[i].zzq(false)) {
            this.zzH = 0;
            this.zzI = false;
            this.zzD = true;
            this.zzG = 0;
            this.zzJ = 0;
            for (zzafi zzh2 : this.zzs) {
                zzh2.zzh(false);
            }
            zzads zzads = this.zzq;
            if (zzads != null) {
                zzads.zzm(this);
                return;
            }
            throw null;
        }
    }

    private final boolean zzN() {
        return this.zzD || zzU();
    }

    private final zztz zzO(zzaeu zzaeu) {
        int length = this.zzs.length;
        for (int i = 0; i < length; i++) {
            if (zzaeu.equals(this.zzt[i])) {
                return this.zzs[i];
            }
        }
        zzahy zzahy = this.zzN;
        Looper looper = this.zzp.getLooper();
        zzsi zzsi = this.zzf;
        zzsd zzsd = this.zzh;
        if (looper == null) {
            throw null;
        } else if (zzsi != null) {
            zzafi zzafi = new zzafi(zzahy, looper, zzsi, zzsd, (byte[]) null);
            zzafi.zzx(this);
            int i2 = length + 1;
            zzaeu[] zzaeuArr = (zzaeu[]) Arrays.copyOf(this.zzt, i2);
            zzaeuArr[length] = zzaeu;
            this.zzt = (zzaeu[]) zzalh.zze(zzaeuArr);
            zzafi[] zzafiArr = (zzafi[]) Arrays.copyOf(this.zzs, i2);
            zzafiArr[length] = zzafi;
            this.zzs = (zzafi[]) zzalh.zze(zzafiArr);
            return zzafi;
        } else {
            throw null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzP */
    public final void zzK() {
        zzabe zzabe;
        if (!this.zzL && !this.zzv && this.zzu && this.zzy != null) {
            zzafi[] zzafiArr = this.zzs;
            int length = zzafiArr.length;
            int i = 0;
            while (i < length) {
                if (zzafiArr[i].zzn() != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.zzm.zzb();
            int length2 = this.zzs.length;
            zzafr[] zzafrArr = new zzafr[length2];
            boolean[] zArr = new boolean[length2];
            int i2 = 0;
            while (i2 < length2) {
                zzkc zzn2 = this.zzs[i2].zzn();
                if (zzn2 != null) {
                    String str = zzn2.zzl;
                    boolean zza = zzakg.zza(str);
                    boolean z = zza || zzakg.zzb(str);
                    zArr[i2] = z;
                    this.zzw = z | this.zzw;
                    zzabp zzabp = this.zzr;
                    if (zzabp != null) {
                        if (zza || this.zzt[i2].zzb) {
                            zzabe zzabe2 = zzn2.zzj;
                            if (zzabe2 == null) {
                                zzabe = new zzabe(zzabp);
                            } else {
                                zzabe = zzabe2.zzd(zzabp);
                            }
                            zzkb zza2 = zzn2.zza();
                            zza2.zzi(zzabe);
                            zzn2 = zza2.zzD();
                        }
                        if (zza && zzn2.zzf == -1 && zzn2.zzg == -1 && zzabp.zza != -1) {
                            zzkb zza3 = zzn2.zza();
                            zza3.zzf(zzabp.zza);
                            zzn2 = zza3.zzD();
                        }
                    }
                    zzafrArr[i2] = new zzafr(zzn2.zzb(this.zzf.zza(zzn2)));
                    i2++;
                } else {
                    throw null;
                }
            }
            this.zzx = new zzaev(new zzaft(zzafrArr), zArr);
            this.zzv = true;
            zzads zzads = this.zzq;
            if (zzads != null) {
                zzads.zzj(this);
                return;
            }
            throw null;
        }
    }

    private final void zzQ(zzaer zzaer) {
        if (this.zzF == -1) {
            this.zzF = zzaer.zzm;
        }
    }

    private final void zzR() {
        zzaer zzaer = new zzaer(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzv) {
            zzajg.zzd(zzU());
            long j = this.zzz;
            if (j == -9223372036854775807L || this.zzH <= j) {
                zztv zztv = this.zzy;
                if (zztv != null) {
                    zzaer.zzi(zzaer, zztv.zzb(this.zzH).zza.zzc, this.zzH);
                    for (zzafi zzi2 : this.zzs) {
                        zzi2.zzi(this.zzH);
                    }
                    this.zzH = -9223372036854775807L;
                } else {
                    throw null;
                }
            } else {
                this.zzK = true;
                this.zzH = -9223372036854775807L;
                return;
            }
        }
        this.zzJ = zzS();
        long zzd2 = this.zzk.zzd(zzaer, this, zzaih.zza(this.zzB));
        zzahx zzf2 = zzaer.zzl;
        this.zzg.zzd(new zzadm(zzaer.zzb, zzf2, zzf2.zza, Collections.emptyMap(), zzd2, 0, 0), 1, -1, (zzkc) null, 0, (Object) null, zzaer.zzk, this.zzz);
    }

    private final int zzS() {
        int i = 0;
        for (zzafi zzj2 : this.zzs) {
            i += zzj2.zzj();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public final long zzT() {
        long j = Long.MIN_VALUE;
        for (zzafi zzo2 : this.zzs) {
            j = Math.max(j, zzo2.zzo());
        }
        return j;
    }

    private final boolean zzU() {
        return this.zzH != -9223372036854775807L;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzV() {
        zzajg.zzd(this.zzv);
        if (this.zzx == null) {
            throw null;
        } else if (this.zzy == null) {
            throw null;
        }
    }

    public final /* synthetic */ void zzA(zztv zztv) {
        zztv zztv2;
        if (this.zzr == null) {
            zztv2 = zztv;
        } else {
            zztv2 = new zztu(-9223372036854775807L, 0);
        }
        this.zzy = zztv2;
        this.zzz = zztv.zzc();
        boolean z = false;
        int i = 1;
        if (this.zzF == -1 && zztv.zzc() == -9223372036854775807L) {
            z = true;
        }
        this.zzA = z;
        if (true == z) {
            i = 7;
        }
        this.zzB = i;
        this.zzi.zzb(this.zzz, zztv.zza(), this.zzA);
        if (!this.zzv) {
            zzK();
        }
    }

    public final /* synthetic */ void zzB() {
        if (!this.zzL) {
            zzads zzads = this.zzq;
            if (zzads != null) {
                zzads.zzm(this);
                return;
            }
            throw null;
        }
    }

    public final zztz zza(int i, int i2) {
        return zzO(new zzaeu(i, false));
    }

    public final void zzb(zzads zzads, long j) {
        this.zzq = zzads;
        this.zzm.zza();
        zzR();
    }

    public final void zzbl() {
        this.zzu = true;
        this.zzp.post(this.zzn);
    }

    public final void zzbm(zztv zztv) {
        this.zzp.post(new zzaeq(this, zztv));
    }

    public final void zzc() throws IOException {
        zzs();
        if (this.zzK && !this.zzv) {
            throw new zzlg("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public final zzaft zzd() {
        zzV();
        return this.zzx.zza;
    }

    public final void zze(long j, boolean z) {
        zzV();
        if (!zzU()) {
            boolean[] zArr = this.zzx.zzc;
            int length = this.zzs.length;
            for (int i = 0; i < length; i++) {
                this.zzs[i].zzv(j, false, zArr[i]);
            }
        }
    }

    public final void zzf(long j) {
    }

    public final long zzg() {
        if (!this.zzD) {
            return -9223372036854775807L;
        }
        if (!this.zzK && zzS() <= this.zzJ) {
            return -9223372036854775807L;
        }
        this.zzD = false;
        return this.zzG;
    }

    public final long zzh() {
        long j;
        zzV();
        boolean[] zArr = this.zzx.zzb;
        if (this.zzK) {
            return Long.MIN_VALUE;
        }
        if (zzU()) {
            return this.zzH;
        }
        if (this.zzw) {
            int length = this.zzs.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.zzs[i].zzp()) {
                    j = Math.min(j, this.zzs[i].zzo());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == RecyclerView.FOREVER_NS) {
            j = zzT();
        }
        return j == Long.MIN_VALUE ? this.zzG : j;
    }

    public final long zzi(long j) {
        zzV();
        boolean[] zArr = this.zzx.zzb;
        if (true != this.zzy.zza()) {
            j = 0;
        }
        this.zzD = false;
        this.zzG = j;
        if (zzU()) {
            this.zzH = j;
            return j;
        }
        if (this.zzB != 7) {
            int length = this.zzs.length;
            int i = 0;
            while (i < length) {
                if (this.zzs[i].zzs(j, false) || (!zArr[i] && this.zzw)) {
                    i++;
                }
            }
            return j;
        }
        this.zzI = false;
        this.zzH = j;
        this.zzK = false;
        if (this.zzk.zze()) {
            for (zzafi zzw2 : this.zzs) {
                zzw2.zzw();
            }
            this.zzk.zzf();
        } else {
            this.zzk.zzc();
            for (zzafi zzh2 : this.zzs) {
                zzh2.zzh(false);
            }
        }
        return j;
    }

    public final void zzj() {
        if (this.zzv) {
            for (zzafi zzk2 : this.zzs) {
                zzk2.zzk();
            }
        }
        this.zzk.zzg(this);
        this.zzp.removeCallbacksAndMessages((Object) null);
        this.zzq = null;
        this.zzL = true;
    }

    public final long zzk(long j, zzme zzme) {
        long j2 = j;
        zzme zzme2 = zzme;
        zzV();
        if (!this.zzy.zza()) {
            return 0;
        }
        zztt zzb2 = this.zzy.zzb(j2);
        long j3 = zzb2.zza.zzb;
        long j4 = zzb2.zzb.zzb;
        long j5 = zzme2.zzf;
        if (j5 == 0 && zzme2.zzg == 0) {
            return j2;
        }
        long j6 = j;
        long zzB2 = zzalh.zzB(j6, j5, Long.MIN_VALUE);
        long zzA2 = zzalh.zzA(j6, zzme2.zzg, RecyclerView.FOREVER_NS);
        boolean z = true;
        boolean z2 = zzB2 <= j3 && j3 <= zzA2;
        if (zzB2 > j4 || j4 > zzA2) {
            z = false;
        }
        if (!z2 || !z) {
            if (!z2) {
                return z ? j4 : zzB2;
            }
        } else if (Math.abs(j3 - j2) > Math.abs(j4 - j2)) {
            return j4;
        }
        return j3;
    }

    public final long zzl() {
        if (this.zzE == 0) {
            return Long.MIN_VALUE;
        }
        return zzh();
    }

    public final void zzm() {
        for (zzafi zzg2 : this.zzs) {
            zzg2.zzg();
        }
        this.zzl.zzb();
    }

    public final boolean zzn(long j) {
        if (this.zzK || this.zzk.zzb() || this.zzI) {
            return false;
        }
        if (this.zzv && this.zzE == 0) {
            return false;
        }
        boolean zza = this.zzm.zza();
        if (this.zzk.zze()) {
            return zza;
        }
        zzR();
        return true;
    }

    public final boolean zzo() {
        return this.zzk.zze() && this.zzm.zze();
    }

    public final boolean zzp(int i) {
        return !zzN() && this.zzs[i].zzq(this.zzK);
    }

    public final long zzq(zzagf[] zzagfArr, boolean[] zArr, zzafj[] zzafjArr, boolean[] zArr2, long j) {
        zzagf zzagf;
        zzV();
        zzaev zzaev = this.zzx;
        zzaft zzaft = zzaev.zza;
        boolean[] zArr3 = zzaev.zzc;
        int i = this.zzE;
        int i2 = 0;
        for (int i3 = 0; i3 < zzagfArr.length; i3++) {
            zzaet zzaet = zzafjArr[i3];
            if (zzaet != null && (zzagfArr[i3] == null || !zArr[i3])) {
                int zza = zzaet.zzb;
                zzajg.zzd(zArr3[zza]);
                this.zzE--;
                zArr3[zza] = false;
                zzafjArr[i3] = null;
            }
        }
        boolean z = !this.zzC ? j != 0 : i == 0;
        for (int i4 = 0; i4 < zzagfArr.length; i4++) {
            if (zzafjArr[i4] == null && (zzagf = zzagfArr[i4]) != null) {
                zzajg.zzd(zzagf.zzc() == 1);
                zzajg.zzd(zzagf.zze(0) == 0);
                int zzb2 = zzaft.zzb(zzagf.zzb());
                zzajg.zzd(!zArr3[zzb2]);
                this.zzE++;
                zArr3[zzb2] = true;
                zzafjArr[i4] = new zzaet(this, zzb2);
                zArr2[i4] = true;
                if (!z) {
                    zzafi zzafi = this.zzs[zzb2];
                    z = !zzafi.zzs(j, true) && zzafi.zzm() != 0;
                }
            }
        }
        if (this.zzE == 0) {
            this.zzI = false;
            this.zzD = false;
            if (this.zzk.zze()) {
                zzafi[] zzafiArr = this.zzs;
                int length = zzafiArr.length;
                while (i2 < length) {
                    zzafiArr[i2].zzw();
                    i2++;
                }
                this.zzk.zzf();
            } else {
                for (zzafi zzh2 : this.zzs) {
                    zzh2.zzh(false);
                }
            }
        } else if (z) {
            j = zzi(j);
            while (i2 < zzafjArr.length) {
                if (zzafjArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.zzC = true;
        return j;
    }

    public final void zzr(int i) throws IOException {
        this.zzs[i].zzl();
        zzs();
    }

    public final void zzs() throws IOException {
        this.zzk.zzh(zzaih.zza(this.zzB));
    }

    public final int zzt(int i, zzkd zzkd, zzrr zzrr, int i2) {
        if (zzN()) {
            return -3;
        }
        zzL(i);
        int zzr2 = this.zzs[i].zzr(zzkd, zzrr, i2, this.zzK);
        if (zzr2 == -3) {
            zzM(i);
        }
        return zzr2;
    }

    public final int zzu(int i, long j) {
        if (zzN()) {
            return 0;
        }
        zzL(i);
        zzafi zzafi = this.zzs[i];
        int zzt2 = zzafi.zzt(j, this.zzK);
        zzafi.zzu(zzt2);
        if (zzt2 != 0) {
            return zzt2;
        }
        zzM(i);
        return 0;
    }

    public final zztz zzv() {
        return zzO(new zzaeu(0, true));
    }

    public final void zzw(zzkc zzkc) {
        this.zzp.post(this.zzn);
    }

    public final /* bridge */ /* synthetic */ zzait zzx(zzaiv zzaiv, long j, long j2, IOException iOException, int i) {
        zzait zza;
        zztv zztv;
        IOException iOException2 = iOException;
        zzaer zzaer = (zzaer) zzaiv;
        zzQ(zzaer);
        zzajc zzd2 = zzaer.zzd;
        zzadm zzadm = new zzadm(zzaer.zzb, zzaer.zzl, zzd2.zzh(), zzd2.zzi(), j, j2, zzd2.zzg());
        new zzadr(1, -1, (zzkc) null, 0, (Object) null, zzig.zza(zzaer.zzk), zzig.zza(this.zzz));
        long min = ((iOException2 instanceof zzlg) || (iOException2 instanceof FileNotFoundException) || (iOException2 instanceof zzail) || (iOException2 instanceof zzaiy)) ? -9223372036854775807L : (long) Math.min((i - 1) * 1000, 5000);
        if (min == -9223372036854775807L) {
            zza = zzaiz.zzd;
        } else {
            int zzS = zzS();
            boolean z = zzS > this.zzJ;
            if (this.zzF != -1 || ((zztv = this.zzy) != null && zztv.zzc() != -9223372036854775807L)) {
                this.zzJ = zzS;
            } else if (!this.zzv || zzN()) {
                this.zzD = this.zzv;
                this.zzG = 0;
                this.zzJ = 0;
                for (zzafi zzh2 : this.zzs) {
                    zzh2.zzh(false);
                }
                zzaer.zzi(zzaer, 0, 0);
            } else {
                this.zzI = true;
                zza = zzaiz.zzc;
            }
            zza = zzaiz.zza(z, min);
        }
        zzait zzait = zza;
        boolean z2 = !zzait.zza();
        this.zzg.zzj(zzadm, 1, -1, (zzkc) null, 0, (Object) null, zzaer.zzk, this.zzz, iOException, z2);
        if (z2) {
            long unused = zzaer.zzb;
        }
        return zzait;
    }

    public final /* bridge */ /* synthetic */ void zzy(zzaiv zzaiv, long j, long j2, boolean z) {
        zzaer zzaer = (zzaer) zzaiv;
        zzajc zzd2 = zzaer.zzd;
        zzadm zzadm = new zzadm(zzaer.zzb, zzaer.zzl, zzd2.zzh(), zzd2.zzi(), j, j2, zzd2.zzg());
        long unused = zzaer.zzb;
        this.zzg.zzh(zzadm, 1, -1, (zzkc) null, 0, (Object) null, zzaer.zzk, this.zzz);
        if (!z) {
            zzQ(zzaer);
            for (zzafi zzh2 : this.zzs) {
                zzh2.zzh(false);
            }
            if (this.zzE > 0) {
                zzads zzads = this.zzq;
                if (zzads != null) {
                    zzads.zzm(this);
                    return;
                }
                throw null;
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzz(zzaiv zzaiv, long j, long j2) {
        zztv zztv;
        if (this.zzz == -9223372036854775807L && (zztv = this.zzy) != null) {
            boolean zza = zztv.zza();
            long zzT = zzT();
            long j3 = zzT == Long.MIN_VALUE ? 0 : zzT + 10000;
            this.zzz = j3;
            this.zzi.zzb(j3, zza, this.zzA);
        }
        zzaer zzaer = (zzaer) zzaiv;
        zzajc zzd2 = zzaer.zzd;
        zzadm zzadm = new zzadm(zzaer.zzb, zzaer.zzl, zzd2.zzh(), zzd2.zzi(), j, j2, zzd2.zzg());
        long unused = zzaer.zzb;
        this.zzg.zzf(zzadm, 1, -1, (zzkc) null, 0, (Object) null, zzaer.zzk, this.zzz);
        zzQ(zzaer);
        this.zzK = true;
        zzads zzads = this.zzq;
        if (zzads != null) {
            zzads.zzm(this);
            return;
        }
        throw null;
    }
}
