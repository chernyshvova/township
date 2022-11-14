package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import com.vungle.warren.downloader.AssetDownloader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public class zzkl implements zzgt {
    public static volatile zzkl zza;
    public final zzky zzaa;
    public zzfo zzb;
    public zzex zzc;
    public zzaf zzd;
    public zzfa zze;
    public zzkh zzf;
    public zzr zzg;
    public final zzkr zzh;
    public zzih zzi;
    public zzjr zzj;
    public final zzfu zzk;
    public boolean zzl;
    public boolean zzm;
    @VisibleForTesting
    public long zzn;
    public List<Runnable> zzo;
    public int zzp;
    public int zzq;
    public boolean zzr;
    public boolean zzs;
    public boolean zzt;
    public FileLock zzu;
    public FileChannel zzv;
    public List<Long> zzw;
    public List<Long> zzx;
    public long zzy;
    public final Map<String, zzac> zzz;

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public class zza implements zzah {
        public zzcd.zzg zza;
        public List<Long> zzb;
        public List<zzcd.zzc> zzc;
        public long zzd;

        public zza() {
        }

        public final void zza(zzcd.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public /* synthetic */ zza(zzkl zzkl, zzkk zzkk) {
            this();
        }

        public final boolean zza(long j, zzcd.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbp = this.zzd + ((long) zzc2.zzbp());
            if (zzbp >= ((long) Math.max(0, zzas.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbp;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzas.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        public static long zza(zzcd.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }
    }

    public zzkl(zzks zzks) {
        this(zzks, (zzfu) null);
    }

    public static zzkl zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkl.class) {
                if (zza == null) {
                    zza = new zzkl(new zzks(context));
                }
            }
        }
        return zza;
    }

    private final boolean zzaa() {
        zzx();
        zzn();
        return zze().zzx() || !TextUtils.isEmpty(zze().mo31261d_());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01aa  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzab() {
        /*
            r21 = this;
            r0 = r21
            r21.zzx()
            r21.zzn()
            long r1 = r0.zzn
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzn
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzw()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzfa r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkh r1 = r21.zzw()
            r1.zze()
            return
        L_0x004b:
            r0.zzn = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            boolean r1 = r1.zzaf()
            if (r1 == 0) goto L_0x0255
            boolean r1 = r21.zzaa()
            if (r1 != 0) goto L_0x005d
            goto L_0x0255
        L_0x005d:
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzas.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzaf r5 = r21.zze()
            boolean r5 = r5.zzy()
            if (r5 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzaf r5 = r21.zze()
            boolean r5 = r5.mo31262e_()
            if (r5 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r5 = 0
            goto L_0x0090
        L_0x008f:
            r5 = 1
        L_0x0090:
            if (r5 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzfu r10 = r0.zzk
            com.google.android.gms.measurement.internal.zzab r10 = r10.zza()
            java.lang.String r10 = r10.zzw()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00bb
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00bb
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzas.zzu
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzas.zzt
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00dc
        L_0x00cc:
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzas.zzs
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzfu r12 = r0.zzk
            com.google.android.gms.measurement.internal.zzfc r12 = r12.zzb()
            com.google.android.gms.measurement.internal.zzfg r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzfu r14 = r0.zzk
            com.google.android.gms.measurement.internal.zzfc r14 = r14.zzb()
            com.google.android.gms.measurement.internal.zzfg r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzaf r16 = r21.zze()
            r17 = r10
            long r9 = r16.zzv()
            com.google.android.gms.measurement.internal.zzaf r11 = r21.zze()
            r19 = r7
            long r6 = r11.zzw()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0113
        L_0x0110:
            r10 = r3
            goto L_0x0188
        L_0x0113:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x0139
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0139
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x0139:
            com.google.android.gms.measurement.internal.zzkr r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.zza((long) r8, (long) r12)
            if (r5 != 0) goto L_0x0147
            long r10 = r8 + r12
        L_0x0147:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0188
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0188
            r5 = 0
        L_0x0150:
            r6 = 20
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzas.zzab
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 0
            int r7 = java.lang.Math.max(r9, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0110
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzas.zzaa
            java.lang.Object r12 = r12.zza(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r10 = r10 + r12
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            int r5 = r5 + 1
            goto L_0x0150
        L_0x0188:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01aa
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzw()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfa r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkh r1 = r21.zzw()
            r1.zze()
            return
        L_0x01aa:
            com.google.android.gms.measurement.internal.zzex r1 = r21.zzd()
            boolean r1 = r1.zze()
            if (r1 != 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzw()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfa r1 = r21.zzv()
            r1.zza()
            com.google.android.gms.measurement.internal.zzkh r1 = r21.zzw()
            r1.zze()
            return
        L_0x01d2:
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfc r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzfg r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzas.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkr r7 = r21.zzh()
            boolean r7 = r7.zza((long) r1, (long) r5)
            if (r7 != 0) goto L_0x01fe
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x01fe:
            com.google.android.gms.measurement.internal.zzfa r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.common.util.Clock r1 = r1.zzl()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x023a
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzas.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfc r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzfg r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzfu r2 = r0.zzk
            com.google.android.gms.common.util.Clock r2 = r2.zzl()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x023a:
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzw()
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzkh r1 = r21.zzw()
            r1.zza(r10)
            return
        L_0x0255:
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzw()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfa r1 = r21.zzv()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkh r1 = r21.zzw()
            r1.zze()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzab():void");
    }

    @WorkerThread
    private final void zzac() {
        zzx();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzk.zzq().zzw().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzk.zzq().zzw().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzo.clear();
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzad() {
        FileLock fileLock;
        zzx();
        if (!this.zzk.zza().zza(zzas.zzbh) || (fileLock = this.zzu) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzk.zzm().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzv = channel;
                FileLock tryLock = channel.tryLock();
                this.zzu = tryLock;
                if (tryLock != null) {
                    this.zzk.zzq().zzw().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzk.zzq().zze().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzk.zzq().zze().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzk.zzq().zze().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzk.zzq().zzh().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzk.zzq().zzw().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final zzfa zzv() {
        zzfa zzfa = this.zze;
        if (zzfa != null) {
            return zzfa;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkh zzw() {
        zzb((zzki) this.zzf);
        return this.zzf;
    }

    @WorkerThread
    private final void zzx() {
        this.zzk.zzp().zzc();
    }

    private final long zzy() {
        long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
        zzfc zzb2 = this.zzk.zzb();
        zzb2.zzab();
        zzb2.zzc();
        long zza2 = zzb2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzb2.zzo().zzg().nextInt(86400000));
            zzb2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    @Deprecated
    private final String zzz() {
        byte[] bArr = new byte[16];
        this.zzk.zzh().zzg().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final zzab zzb() {
        return this.zzk.zza();
    }

    public final zzfo zzc() {
        zzb((zzki) this.zzb);
        return this.zzb;
    }

    public final zzex zzd() {
        zzb((zzki) this.zzc);
        return this.zzc;
    }

    public final zzaf zze() {
        zzb((zzki) this.zzd);
        return this.zzd;
    }

    public final zzr zzf() {
        zzb((zzki) this.zzg);
        return this.zzg;
    }

    public final zzih zzg() {
        zzb((zzki) this.zzi);
        return this.zzi;
    }

    public final zzkr zzh() {
        zzb((zzki) this.zzh);
        return this.zzh;
    }

    public final zzjr zzi() {
        return this.zzj;
    }

    public final zzeo zzj() {
        return this.zzk.zzi();
    }

    public final zzkv zzk() {
        return this.zzk.zzh();
    }

    public final Clock zzl() {
        return this.zzk.zzl();
    }

    public final Context zzm() {
        return this.zzk.zzm();
    }

    public final void zzn() {
        if (!this.zzl) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:136|137) */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r1.zzk.zzq().zze().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzeq.zza(r5), r0);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:136:0x0372 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x022e A[Catch:{ all -> 0x03ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02c2 A[Catch:{ all -> 0x03ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02d3 A[Catch:{ all -> 0x03ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02f7 A[Catch:{ MalformedURLException -> 0x0372 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02f9 A[Catch:{ MalformedURLException -> 0x0372 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0301 A[Catch:{ MalformedURLException -> 0x0372 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0311 A[Catch:{ MalformedURLException -> 0x0372 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0329 A[Catch:{ MalformedURLException -> 0x0372 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0227 A[Catch:{ all -> 0x03ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0228 A[Catch:{ all -> 0x03ae }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzo() {
        /*
            r17 = this;
            r1 = r17
            r17.zzx()
            r17.zzn()
            r0 = 1
            r1.zzt = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzir r3 = r3.zzv()     // Catch:{ all -> 0x03ae }
            java.lang.Boolean r3 = r3.zzaf()     // Catch:{ all -> 0x03ae }
            if (r3 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzh()     // Catch:{ all -> 0x03ae }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zza(r3)     // Catch:{ all -> 0x03ae }
            r1.zzt = r2
            r17.zzac()
            return
        L_0x002d:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x03ae }
            if (r3 == 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()     // Catch:{ all -> 0x03ae }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zza(r3)     // Catch:{ all -> 0x03ae }
            r1.zzt = r2
            r17.zzac()
            return
        L_0x0048:
            long r3 = r1.zzn     // Catch:{ all -> 0x03ae }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0059
            r17.zzab()     // Catch:{ all -> 0x03ae }
            r1.zzt = r2
            r17.zzac()
            return
        L_0x0059:
            r17.zzx()     // Catch:{ all -> 0x03ae }
            java.util.List<java.lang.Long> r3 = r1.zzw     // Catch:{ all -> 0x03ae }
            if (r3 == 0) goto L_0x0062
            r3 = 1
            goto L_0x0063
        L_0x0062:
            r3 = 0
        L_0x0063:
            if (r3 == 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzw()     // Catch:{ all -> 0x03ae }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zza(r3)     // Catch:{ all -> 0x03ae }
            r1.zzt = r2
            r17.zzac()
            return
        L_0x007a:
            com.google.android.gms.measurement.internal.zzex r3 = r17.zzd()     // Catch:{ all -> 0x03ae }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x03ae }
            if (r3 != 0) goto L_0x009c
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzw()     // Catch:{ all -> 0x03ae }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zza(r3)     // Catch:{ all -> 0x03ae }
            r17.zzab()     // Catch:{ all -> 0x03ae }
            r1.zzt = r2
            r17.zzac()
            return
        L_0x009c:
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.common.util.Clock r3 = r3.zzl()     // Catch:{ all -> 0x03ae }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzas.zzap     // Catch:{ all -> 0x03ae }
            r9 = 0
            int r7 = r7.zzb(r9, r8)     // Catch:{ all -> 0x03ae }
            long r10 = com.google.android.gms.measurement.internal.zzab.zzv()     // Catch:{ all -> 0x03ae }
            long r10 = r3 - r10
            r8 = 0
        L_0x00ba:
            if (r8 >= r7) goto L_0x00c5
            boolean r12 = r1.zza((java.lang.String) r9, (long) r10)     // Catch:{ all -> 0x03ae }
            if (r12 == 0) goto L_0x00c5
            int r8 = r8 + 1
            goto L_0x00ba
        L_0x00c5:
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzfc r7 = r7.zzb()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzfg r7 = r7.zzc     // Catch:{ all -> 0x03ae }
            long r7 = r7.zza()     // Catch:{ all -> 0x03ae }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzeq r5 = r5.zzq()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzv()     // Catch:{ all -> 0x03ae }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x03ae }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x03ae }
            r5.zza(r6, r7)     // Catch:{ all -> 0x03ae }
        L_0x00ee:
            com.google.android.gms.measurement.internal.zzaf r5 = r17.zze()     // Catch:{ all -> 0x03ae }
            java.lang.String r5 = r5.mo31261d_()     // Catch:{ all -> 0x03ae }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x03ae }
            r7 = -1
            if (r6 != 0) goto L_0x0386
            long r10 = r1.zzy     // Catch:{ all -> 0x03ae }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x010e
            com.google.android.gms.measurement.internal.zzaf r6 = r17.zze()     // Catch:{ all -> 0x03ae }
            long r6 = r6.zzz()     // Catch:{ all -> 0x03ae }
            r1.zzy = r6     // Catch:{ all -> 0x03ae }
        L_0x010e:
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r6 = r6.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzas.zzf     // Catch:{ all -> 0x03ae }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzas.zzg     // Catch:{ all -> 0x03ae }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x03ae }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzaf r8 = r17.zze()     // Catch:{ all -> 0x03ae }
            java.util.List r6 = r8.zza((java.lang.String) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x03ae }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x03ae }
            if (r7 != 0) goto L_0x03a8
            boolean r7 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x03ae }
            if (r7 == 0) goto L_0x0156
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x03ae }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r8)     // Catch:{ all -> 0x03ae }
            if (r7 == 0) goto L_0x0156
            com.google.android.gms.measurement.internal.zzac r7 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x03ae }
            boolean r7 = r7.zzc()     // Catch:{ all -> 0x03ae }
            if (r7 == 0) goto L_0x01a9
        L_0x0156:
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x03ae }
        L_0x015a:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x03ae }
            if (r8 == 0) goto L_0x0179
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x03ae }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x03ae }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzg r8 = (com.google.android.gms.internal.measurement.zzcd.zzg) r8     // Catch:{ all -> 0x03ae }
            java.lang.String r10 = r8.zzad()     // Catch:{ all -> 0x03ae }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x03ae }
            if (r10 != 0) goto L_0x015a
            java.lang.String r7 = r8.zzad()     // Catch:{ all -> 0x03ae }
            goto L_0x017a
        L_0x0179:
            r7 = r9
        L_0x017a:
            if (r7 == 0) goto L_0x01a9
            r8 = 0
        L_0x017d:
            int r10 = r6.size()     // Catch:{ all -> 0x03ae }
            if (r8 >= r10) goto L_0x01a9
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x03ae }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x03ae }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = (com.google.android.gms.internal.measurement.zzcd.zzg) r10     // Catch:{ all -> 0x03ae }
            java.lang.String r11 = r10.zzad()     // Catch:{ all -> 0x03ae }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x03ae }
            if (r11 != 0) goto L_0x01a6
            java.lang.String r10 = r10.zzad()     // Catch:{ all -> 0x03ae }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x03ae }
            if (r10 != 0) goto L_0x01a6
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x03ae }
            goto L_0x01a9
        L_0x01a6:
            int r8 = r8 + 1
            goto L_0x017d
        L_0x01a9:
            com.google.android.gms.internal.measurement.zzcd$zzf$zza r7 = com.google.android.gms.internal.measurement.zzcd.zzf.zzb()     // Catch:{ all -> 0x03ae }
            int r8 = r6.size()     // Catch:{ all -> 0x03ae }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x03ae }
            int r11 = r6.size()     // Catch:{ all -> 0x03ae }
            r10.<init>(r11)     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()     // Catch:{ all -> 0x03ae }
            boolean r11 = r11.zzh(r5)     // Catch:{ all -> 0x03ae }
            if (r11 == 0) goto L_0x01e6
            boolean r11 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x03ae }
            if (r11 == 0) goto L_0x01e4
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x03ae }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r12)     // Catch:{ all -> 0x03ae }
            if (r11 == 0) goto L_0x01e4
            com.google.android.gms.measurement.internal.zzac r11 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x03ae }
            boolean r11 = r11.zzc()     // Catch:{ all -> 0x03ae }
            if (r11 == 0) goto L_0x01e6
        L_0x01e4:
            r11 = 1
            goto L_0x01e7
        L_0x01e6:
            r11 = 0
        L_0x01e7:
            boolean r12 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x03ae }
            if (r12 == 0) goto L_0x0208
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r12 = r12.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x03ae }
            boolean r12 = r12.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r13)     // Catch:{ all -> 0x03ae }
            if (r12 == 0) goto L_0x0208
            com.google.android.gms.measurement.internal.zzac r12 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x03ae }
            boolean r12 = r12.zzc()     // Catch:{ all -> 0x03ae }
            if (r12 == 0) goto L_0x0206
            goto L_0x0208
        L_0x0206:
            r12 = 0
            goto L_0x0209
        L_0x0208:
            r12 = 1
        L_0x0209:
            boolean r13 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x03ae }
            if (r13 == 0) goto L_0x022a
            com.google.android.gms.measurement.internal.zzfu r13 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r13 = r13.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x03ae }
            boolean r13 = r13.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r14)     // Catch:{ all -> 0x03ae }
            if (r13 == 0) goto L_0x022a
            com.google.android.gms.measurement.internal.zzac r13 = r1.zza((java.lang.String) r5)     // Catch:{ all -> 0x03ae }
            boolean r13 = r13.zze()     // Catch:{ all -> 0x03ae }
            if (r13 == 0) goto L_0x0228
            goto L_0x022a
        L_0x0228:
            r13 = 0
            goto L_0x022b
        L_0x022a:
            r13 = 1
        L_0x022b:
            r14 = 0
        L_0x022c:
            if (r14 >= r8) goto L_0x02b3
            java.lang.Object r15 = r6.get(r14)     // Catch:{ all -> 0x03ae }
            android.util.Pair r15 = (android.util.Pair) r15     // Catch:{ all -> 0x03ae }
            java.lang.Object r15 = r15.first     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzg r15 = (com.google.android.gms.internal.measurement.zzcd.zzg) r15     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzhy$zzb r15 = r15.zzbo()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r15 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r15     // Catch:{ all -> 0x03ae }
            java.lang.Object r16 = r6.get(r14)     // Catch:{ all -> 0x03ae }
            r0 = r16
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x03ae }
            java.lang.Object r0 = r0.second     // Catch:{ all -> 0x03ae }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x03ae }
            r10.add(r0)     // Catch:{ all -> 0x03ae }
            r16 = r10
            r9 = 33025(0x8101, double:1.63165E-319)
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r9 = r15.zzg((long) r9)     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r9 = r9.zza((long) r3)     // Catch:{ all -> 0x03ae }
            r9.zzb((boolean) r2)     // Catch:{ all -> 0x03ae }
            if (r11 != 0) goto L_0x0262
            r15.zzr()     // Catch:{ all -> 0x03ae }
        L_0x0262:
            boolean r9 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x03ae }
            if (r9 == 0) goto L_0x0283
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r9 = r9.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x03ae }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r10)     // Catch:{ all -> 0x03ae }
            if (r9 == 0) goto L_0x0283
            if (r12 != 0) goto L_0x027e
            r15.zzk()     // Catch:{ all -> 0x03ae }
            r15.zzl()     // Catch:{ all -> 0x03ae }
        L_0x027e:
            if (r13 != 0) goto L_0x0283
            r15.zzm()     // Catch:{ all -> 0x03ae }
        L_0x0283:
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzab r9 = r9.zza()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzas.zzaw     // Catch:{ all -> 0x03ae }
            boolean r9 = r9.zze(r5, r10)     // Catch:{ all -> 0x03ae }
            if (r9 == 0) goto L_0x02a8
            com.google.android.gms.internal.measurement.zzjj r9 = r15.zzy()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzg r9 = (com.google.android.gms.internal.measurement.zzcd.zzg) r9     // Catch:{ all -> 0x03ae }
            byte[] r9 = r9.zzbk()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzkr r10 = r17.zzh()     // Catch:{ all -> 0x03ae }
            long r9 = r10.zza((byte[]) r9)     // Catch:{ all -> 0x03ae }
            r15.zzl((long) r9)     // Catch:{ all -> 0x03ae }
        L_0x02a8:
            r7.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r15)     // Catch:{ all -> 0x03ae }
            int r14 = r14 + 1
            r10 = r16
            r0 = 1
            r9 = 0
            goto L_0x022c
        L_0x02b3:
            r16 = r10
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()     // Catch:{ all -> 0x03ae }
            r9 = 2
            boolean r6 = r6.zza((int) r9)     // Catch:{ all -> 0x03ae }
            if (r6 == 0) goto L_0x02d3
            com.google.android.gms.measurement.internal.zzkr r6 = r17.zzh()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzjj r9 = r7.zzy()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzf r9 = (com.google.android.gms.internal.measurement.zzcd.zzf) r9     // Catch:{ all -> 0x03ae }
            java.lang.String r6 = r6.zza((com.google.android.gms.internal.measurement.zzcd.zzf) r9)     // Catch:{ all -> 0x03ae }
            goto L_0x02d4
        L_0x02d3:
            r6 = 0
        L_0x02d4:
            r17.zzh()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzjj r9 = r7.zzy()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x03ae }
            com.google.android.gms.internal.measurement.zzcd$zzf r9 = (com.google.android.gms.internal.measurement.zzcd.zzf) r9     // Catch:{ all -> 0x03ae }
            byte[] r14 = r9.zzbk()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzej<java.lang.String> r9 = com.google.android.gms.measurement.internal.zzas.zzp     // Catch:{ all -> 0x03ae }
            r0 = 0
            java.lang.Object r0 = r9.zza(r0)     // Catch:{ all -> 0x03ae }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x03ae }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0372 }
            r13.<init>(r0)     // Catch:{ MalformedURLException -> 0x0372 }
            boolean r9 = r16.isEmpty()     // Catch:{ MalformedURLException -> 0x0372 }
            if (r9 != 0) goto L_0x02f9
            r9 = 1
            goto L_0x02fa
        L_0x02f9:
            r9 = 0
        L_0x02fa:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r9)     // Catch:{ MalformedURLException -> 0x0372 }
            java.util.List<java.lang.Long> r9 = r1.zzw     // Catch:{ MalformedURLException -> 0x0372 }
            if (r9 == 0) goto L_0x0311
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzeq r9 = r9.zzq()     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zze()     // Catch:{ MalformedURLException -> 0x0372 }
            java.lang.String r10 = "Set uploading progress before finishing the previous upload"
            r9.zza(r10)     // Catch:{ MalformedURLException -> 0x0372 }
            goto L_0x031a
        L_0x0311:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x0372 }
            r10 = r16
            r9.<init>(r10)     // Catch:{ MalformedURLException -> 0x0372 }
            r1.zzw = r9     // Catch:{ MalformedURLException -> 0x0372 }
        L_0x031a:
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzfc r9 = r9.zzb()     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzfg r9 = r9.zzd     // Catch:{ MalformedURLException -> 0x0372 }
            r9.zza(r3)     // Catch:{ MalformedURLException -> 0x0372 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0331
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r7.zza((int) r2)     // Catch:{ MalformedURLException -> 0x0372 }
            java.lang.String r3 = r3.zzx()     // Catch:{ MalformedURLException -> 0x0372 }
        L_0x0331:
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzeq r4 = r4.zzq()     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzw()     // Catch:{ MalformedURLException -> 0x0372 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x0372 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x0372 }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x0372 }
            r3 = 1
            r1.zzs = r3     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzex r11 = r17.zzd()     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzkn r3 = new com.google.android.gms.measurement.internal.zzkn     // Catch:{ MalformedURLException -> 0x0372 }
            r3.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x0372 }
            r11.zzc()     // Catch:{ MalformedURLException -> 0x0372 }
            r11.zzaj()     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzfr r4 = r11.zzp()     // Catch:{ MalformedURLException -> 0x0372 }
            com.google.android.gms.measurement.internal.zzfb r6 = new com.google.android.gms.measurement.internal.zzfb     // Catch:{ MalformedURLException -> 0x0372 }
            r15 = 0
            r10 = r6
            r12 = r5
            r16 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x0372 }
            r4.zzc((java.lang.Runnable) r6)     // Catch:{ MalformedURLException -> 0x0372 }
            goto L_0x03a8
        L_0x0372:
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x03ae }
            java.lang.String r4 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r5)     // Catch:{ all -> 0x03ae }
            r3.zza(r4, r5, r0)     // Catch:{ all -> 0x03ae }
            goto L_0x03a8
        L_0x0386:
            r1.zzy = r7     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzaf r0 = r17.zze()     // Catch:{ all -> 0x03ae }
            long r5 = com.google.android.gms.measurement.internal.zzab.zzv()     // Catch:{ all -> 0x03ae }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zza((long) r3)     // Catch:{ all -> 0x03ae }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x03ae }
            if (r3 != 0) goto L_0x03a8
            com.google.android.gms.measurement.internal.zzaf r3 = r17.zze()     // Catch:{ all -> 0x03ae }
            com.google.android.gms.measurement.internal.zzf r0 = r3.zzb(r0)     // Catch:{ all -> 0x03ae }
            if (r0 == 0) goto L_0x03a8
            r1.zza((com.google.android.gms.measurement.internal.zzf) r0)     // Catch:{ all -> 0x03ae }
        L_0x03a8:
            r1.zzt = r2
            r17.zzac()
            return
        L_0x03ae:
            r0 = move-exception
            r1.zzt = r2
            r17.zzac()
            goto L_0x03b6
        L_0x03b5:
            throw r0
        L_0x03b6:
            goto L_0x03b5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzo():void");
    }

    public final zzfr zzp() {
        return this.zzk.zzp();
    }

    public final zzeq zzq() {
        return this.zzk.zzq();
    }

    @WorkerThread
    @VisibleForTesting
    public final void zzr() {
        zzx();
        zzn();
        if (!this.zzm) {
            this.zzm = true;
            if (zzad()) {
                int zza2 = zza(this.zzv);
                int zzae = this.zzk.zzx().zzae();
                zzx();
                if (zza2 > zzae) {
                    this.zzk.zzq().zze().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                } else if (zza2 >= zzae) {
                } else {
                    if (zza(zzae, this.zzv)) {
                        this.zzk.zzq().zzw().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    } else {
                        this.zzk.zzq().zze().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    }
                }
            }
        }
    }

    public final void zzs() {
        this.zzq++;
    }

    public final zzw zzt() {
        return this.zzk.zzt();
    }

    public final zzfu zzu() {
        return this.zzk;
    }

    public zzkl(zzks zzks, zzfu zzfu) {
        this.zzl = false;
        this.zzaa = new zzko(this);
        Preconditions.checkNotNull(zzks);
        this.zzk = zzfu.zza(zzks.zza, (zzae) null, (Long) null);
        this.zzy = -1;
        zzkr zzkr = new zzkr(this);
        zzkr.zzak();
        this.zzh = zzkr;
        zzex zzex = new zzex(this);
        zzex.zzak();
        this.zzc = zzex;
        zzfo zzfo = new zzfo(this);
        zzfo.zzak();
        this.zzb = zzfo;
        this.zzz = new HashMap();
        this.zzk.zzp().zza((Runnable) new zzkk(this, zzks));
    }

    public static void zzb(zzki zzki) {
        if (zzki == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzki.zzai()) {
            String valueOf = String.valueOf(zzki.getClass());
            StringBuilder sb = new StringBuilder(valueOf.length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:299:0x092d, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02f2 A[Catch:{ SQLiteException -> 0x0281, all -> 0x09be }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0351 A[Catch:{ SQLiteException -> 0x0281, all -> 0x09be }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016a A[Catch:{ SQLiteException -> 0x0281, all -> 0x09be }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0172 A[Catch:{ SQLiteException -> 0x0281, all -> 0x09be }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02b9 A[Catch:{ SQLiteException -> 0x0281, all -> 0x09be }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.measurement.internal.zzaq r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r3 = r28
            java.lang.String r4 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r26.zzx()
            r26.zzn()
            java.lang.String r15 = r3.zza
            r26.zzh()
            boolean r7 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.measurement.internal.zzaq) r27, (com.google.android.gms.measurement.internal.zzn) r28)
            if (r7 != 0) goto L_0x0026
            return
        L_0x0026:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002e
            r1.zzc(r3)
            return
        L_0x002e:
            com.google.android.gms.measurement.internal.zzfo r7 = r26.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            if (r7 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzh()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzk
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzi()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfo r3 = r26.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzfo r3 = r26.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r3 = 0
            goto L_0x0074
        L_0x0073:
            r3 = 1
        L_0x0074:
            if (r3 != 0) goto L_0x0094
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0094
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzk
            com.google.android.gms.measurement.internal.zzkv r7 = r4.zzh()
            com.google.android.gms.measurement.internal.zzky r8 = r1.zzaa
            r10 = 11
            java.lang.String r12 = r2.zza
            r2 = 0
            java.lang.String r11 = "_ev"
            r9 = r15
            r4 = r13
            r13 = r2
            r7.zza((com.google.android.gms.measurement.internal.zzky) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)
            goto L_0x0095
        L_0x0094:
            r4 = r13
        L_0x0095:
            if (r3 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00de
            long r5 = r2.zzu()
            long r7 = r2.zzt()
            long r5 = java.lang.Math.max(r5, r7)
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk
            com.google.android.gms.common.util.Clock r3 = r3.zzl()
            long r7 = r3.currentTimeMillis()
            long r7 = r7 - r5
            long r5 = java.lang.Math.abs(r7)
            com.google.android.gms.measurement.internal.zzej<java.lang.Long> r3 = com.google.android.gms.measurement.internal.zzas.zzy
            java.lang.Object r3 = r3.zza(r4)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzv()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza((com.google.android.gms.measurement.internal.zzf) r2)
        L_0x00de:
            return
        L_0x00df:
            boolean r7 = com.google.android.gms.internal.measurement.zzmg.zzb()
            if (r7 == 0) goto L_0x010e
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzbv
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r8)
            if (r7 == 0) goto L_0x010e
            com.google.android.gms.measurement.internal.zzeu r2 = com.google.android.gms.measurement.internal.zzeu.zza(r27)
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk
            com.google.android.gms.measurement.internal.zzkv r7 = r7.zzh()
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk
            com.google.android.gms.measurement.internal.zzab r8 = r8.zza()
            int r8 = r8.zza((java.lang.String) r15)
            r7.zza((com.google.android.gms.measurement.internal.zzeu) r2, (int) r8)
            com.google.android.gms.measurement.internal.zzaq r2 = r2.zza()
        L_0x010e:
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk
            com.google.android.gms.measurement.internal.zzeq r7 = r7.zzq()
            r8 = 2
            boolean r7 = r7.zza((int) r8)
            if (r7 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk
            com.google.android.gms.measurement.internal.zzeq r7 = r7.zzq()
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzw()
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk
            com.google.android.gms.measurement.internal.zzeo r9 = r9.zzi()
            java.lang.String r9 = r9.zza((com.google.android.gms.measurement.internal.zzaq) r2)
            java.lang.String r10 = "Logging event"
            r7.zza(r10, r9)
        L_0x0134:
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()
            r7.zze()
            r1.zzc(r3)     // Catch:{ all -> 0x09be }
            java.lang.String r7 = "ecommerce_purchase"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x09be }
            java.lang.String r9 = "refund"
            if (r7 != 0) goto L_0x015f
            java.lang.String r7 = "purchase"
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x015f
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x015d
            goto L_0x015f
        L_0x015d:
            r7 = 0
            goto L_0x0160
        L_0x015f:
            r7 = 1
        L_0x0160:
            java.lang.String r10 = "_iap"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x09be }
            if (r10 != 0) goto L_0x016f
            if (r7 == 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r10 = 0
            goto L_0x0170
        L_0x016f:
            r10 = 1
        L_0x0170:
            if (r10 == 0) goto L_0x0301
            com.google.android.gms.measurement.internal.zzap r10 = r2.zzb     // Catch:{ all -> 0x09be }
            java.lang.String r11 = "currency"
            java.lang.String r10 = r10.zzd(r11)     // Catch:{ all -> 0x09be }
            java.lang.String r11 = "value"
            if (r7 == 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.zzap r7 = r2.zzb     // Catch:{ all -> 0x09be }
            java.lang.Double r7 = r7.zzc(r11)     // Catch:{ all -> 0x09be }
            double r17 = r7.doubleValue()     // Catch:{ all -> 0x09be }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r7 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r7 != 0) goto L_0x01a5
            com.google.android.gms.measurement.internal.zzap r7 = r2.zzb     // Catch:{ all -> 0x09be }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x09be }
            long r12 = r7.longValue()     // Catch:{ all -> 0x09be }
            double r11 = (double) r12
            java.lang.Double.isNaN(r11)
            double r17 = r11 * r19
        L_0x01a5:
            r11 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01bf
            r11 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r7 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01bf
            long r11 = java.lang.Math.round(r17)     // Catch:{ all -> 0x09be }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x01e6
            long r11 = -r11
            goto L_0x01e6
        L_0x01bf:
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r7 = r7.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzh()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r15)     // Catch:{ all -> 0x09be }
            java.lang.Double r10 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x09be }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x09be }
            r23 = r5
            r5 = 0
            r11 = 0
            goto L_0x02f0
        L_0x01dc:
            com.google.android.gms.measurement.internal.zzap r7 = r2.zzb     // Catch:{ all -> 0x09be }
            java.lang.Long r7 = r7.zzb(r11)     // Catch:{ all -> 0x09be }
            long r11 = r7.longValue()     // Catch:{ all -> 0x09be }
        L_0x01e6:
            boolean r7 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x02ec
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ all -> 0x09be }
            java.lang.String r7 = r10.toUpperCase(r7)     // Catch:{ all -> 0x09be }
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r7.matches(r9)     // Catch:{ all -> 0x09be }
            if (r9 == 0) goto L_0x02ec
            java.lang.String r9 = "_ltv_"
            int r10 = r7.length()     // Catch:{ all -> 0x09be }
            if (r10 == 0) goto L_0x0207
            java.lang.String r7 = r9.concat(r7)     // Catch:{ all -> 0x09be }
            goto L_0x020c
        L_0x0207:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x09be }
            r7.<init>(r9)     // Catch:{ all -> 0x09be }
        L_0x020c:
            r10 = r7
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzc(r15, r10)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x0248
            java.lang.Object r9 = r7.zze     // Catch:{ all -> 0x09be }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x09be }
            if (r9 != 0) goto L_0x021e
            goto L_0x0248
        L_0x021e:
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x09be }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x09be }
            long r7 = r7.longValue()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkw r17 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x09be }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r13 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.common.util.Clock r13 = r13.zzl()     // Catch:{ all -> 0x09be }
            long r18 = r13.currentTimeMillis()     // Catch:{ all -> 0x09be }
            long r7 = r7 + r11
            java.lang.Long r13 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09be }
            r7 = r17
            r8 = r15
            r23 = r5
            r5 = 0
            r6 = 1
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09be }
        L_0x0245:
            r6 = r17
            goto L_0x02af
        L_0x0248:
            r23 = r5
            r5 = 0
            r6 = 1
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r9 = r9.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r13 = com.google.android.gms.measurement.internal.zzas.zzad     // Catch:{ all -> 0x09be }
            int r9 = r9.zzb(r15, r13)     // Catch:{ all -> 0x09be }
            int r9 = r9 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x09be }
            r7.zzc()     // Catch:{ all -> 0x09be }
            r7.zzaj()     // Catch:{ all -> 0x09be }
            android.database.sqlite.SQLiteDatabase r13 = r7.mo31260c_()     // Catch:{ SQLiteException -> 0x0281 }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0281 }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x0281 }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x0281 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0281 }
            r16 = 2
            r6[r16] = r9     // Catch:{ SQLiteException -> 0x0281 }
            r13.execSQL(r8, r6)     // Catch:{ SQLiteException -> 0x0281 }
            goto L_0x0294
        L_0x0281:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzeq r7 = r7.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r15)     // Catch:{ all -> 0x09be }
            r7.zza(r8, r9, r6)     // Catch:{ all -> 0x09be }
        L_0x0294:
            com.google.android.gms.measurement.internal.zzkw r17 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x09be }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.common.util.Clock r6 = r6.zzl()     // Catch:{ all -> 0x09be }
            long r18 = r6.currentTimeMillis()     // Catch:{ all -> 0x09be }
            java.lang.Long r13 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x09be }
            r7 = r17
            r8 = r15
            r11 = r18
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x09be }
            goto L_0x0245
        L_0x02af:
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzkw) r6)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x02ef
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r7 = r7.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r15)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r10 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeo r10 = r10.zzi()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r6.zzc     // Catch:{ all -> 0x09be }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x09be }
            java.lang.Object r6 = r6.zze     // Catch:{ all -> 0x09be }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r7 = r6.zzh()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzky r8 = r1.zzaa     // Catch:{ all -> 0x09be }
            r10 = 9
            r11 = 0
            r12 = 0
            r13 = 0
            r9 = r15
            r7.zza((com.google.android.gms.measurement.internal.zzky) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)     // Catch:{ all -> 0x09be }
            goto L_0x02ef
        L_0x02ec:
            r23 = r5
            r5 = 0
        L_0x02ef:
            r11 = 1
        L_0x02f0:
            if (r11 != 0) goto L_0x0304
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()     // Catch:{ all -> 0x09be }
            r2.mo31259b_()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()
            r2.zzg()
            return
        L_0x0301:
            r23 = r5
            r5 = 0
        L_0x0304:
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r6 = com.google.android.gms.measurement.internal.zzkv.zza((java.lang.String) r6)     // Catch:{ all -> 0x09be }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r18 = r14.equals(r7)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            r7.zzh()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzap r7 = r2.zzb     // Catch:{ all -> 0x09be }
            long r7 = com.google.android.gms.measurement.internal.zzkv.zza((com.google.android.gms.measurement.internal.zzap) r7)     // Catch:{ all -> 0x09be }
            r19 = 1
            long r11 = r7 + r19
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            long r8 = r26.zzy()     // Catch:{ all -> 0x09be }
            r13 = 1
            r16 = 0
            r17 = 0
            r10 = r15
            r14 = r6
            r27 = r15
            r15 = r16
            r16 = r18
            com.google.android.gms.measurement.internal.zzae r7 = r7.zza(r8, r10, r11, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x09be }
            long r8 = r7.zzb     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzas.zzj     // Catch:{ all -> 0x09be }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x09be }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x09be }
            int r10 = r10.intValue()     // Catch:{ all -> 0x09be }
            long r10 = (long) r10     // Catch:{ all -> 0x09be }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            int r15 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x037e
            long r8 = r8 % r10
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x036f
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r27)     // Catch:{ all -> 0x09be }
            long r5 = r7.zzb     // Catch:{ all -> 0x09be }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09be }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09be }
        L_0x036f:
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()     // Catch:{ all -> 0x09be }
            r2.mo31259b_()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()
            r2.zzg()
            return
        L_0x037e:
            if (r6 == 0) goto L_0x03d5
            long r8 = r7.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r15 = com.google.android.gms.measurement.internal.zzas.zzl     // Catch:{ all -> 0x09be }
            java.lang.Object r15 = r15.zza(r14)     // Catch:{ all -> 0x09be }
            java.lang.Integer r15 = (java.lang.Integer) r15     // Catch:{ all -> 0x09be }
            int r15 = r15.intValue()     // Catch:{ all -> 0x09be }
            long r14 = (long) r15     // Catch:{ all -> 0x09be }
            long r8 = r8 - r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x03d5
            long r8 = r8 % r10
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x03b2
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r27)     // Catch:{ all -> 0x09be }
            long r6 = r7.zza     // Catch:{ all -> 0x09be }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x09be }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x09be }
        L_0x03b2:
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r7 = r3.zzh()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzky r8 = r1.zzaa     // Catch:{ all -> 0x09be }
            r10 = 16
            java.lang.String r11 = "_ev"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x09be }
            r13 = 0
            r9 = r27
            r7.zza((com.google.android.gms.measurement.internal.zzky) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()     // Catch:{ all -> 0x09be }
            r2.mo31259b_()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()
            r2.zzg()
            return
        L_0x03d5:
            if (r18 == 0) goto L_0x0424
            long r8 = r7.zzd     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r10 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r10 = r10.zza()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzas.zzk     // Catch:{ all -> 0x09be }
            int r10 = r10.zzb(r11, r14)     // Catch:{ all -> 0x09be }
            r11 = 1000000(0xf4240, float:1.401298E-39)
            int r10 = java.lang.Math.min(r11, r10)     // Catch:{ all -> 0x09be }
            int r10 = java.lang.Math.max(r5, r10)     // Catch:{ all -> 0x09be }
            long r10 = (long) r10     // Catch:{ all -> 0x09be }
            long r8 = r8 - r10
            int r10 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0424
            int r2 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0415
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r27)     // Catch:{ all -> 0x09be }
            long r5 = r7.zzd     // Catch:{ all -> 0x09be }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x09be }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x09be }
        L_0x0415:
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()     // Catch:{ all -> 0x09be }
            r2.mo31259b_()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()
            r2.zzg()
            return
        L_0x0424:
            com.google.android.gms.measurement.internal.zzap r7 = r2.zzb     // Catch:{ all -> 0x09be }
            android.os.Bundle r14 = r7.zzb()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r7 = r7.zzh()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09be }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r7 = r7.zzh()     // Catch:{ all -> 0x09be }
            r15 = r27
            boolean r7 = r7.zze(r15)     // Catch:{ all -> 0x09be }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x0463
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r7 = r7.zzh()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = "_dbg"
            java.lang.Long r9 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09be }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r7 = r7.zzh()     // Catch:{ all -> 0x09be }
            java.lang.Long r8 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x09be }
            r7.zza((android.os.Bundle) r14, (java.lang.String) r11, (java.lang.Object) r8)     // Catch:{ all -> 0x09be }
        L_0x0463:
            java.lang.String r7 = "_s"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x09be }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x048a
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkw r7 = r7.zzc(r8, r4)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x048a
            java.lang.Object r8 = r7.zze     // Catch:{ all -> 0x09be }
            boolean r8 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x048a
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r8 = r8.zzh()     // Catch:{ all -> 0x09be }
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x09be }
            r8.zza((android.os.Bundle) r14, (java.lang.String) r4, (java.lang.Object) r7)     // Catch:{ all -> 0x09be }
        L_0x048a:
            com.google.android.gms.measurement.internal.zzaf r4 = r26.zze()     // Catch:{ all -> 0x09be }
            long r7 = r4.zzc(r15)     // Catch:{ all -> 0x09be }
            int r4 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x04ad
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r4 = r4.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzh()     // Catch:{ all -> 0x09be }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r15)     // Catch:{ all -> 0x09be }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x09be }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x09be }
        L_0x04ad:
            com.google.android.gms.measurement.internal.zzan r4 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x09be }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x09be }
            long r12 = r2.zzd     // Catch:{ all -> 0x09be }
            r18 = 0
            r7 = r4
            r2 = r10
            r10 = r15
            r5 = r11
            r11 = r2
            r16 = r14
            r2 = r15
            r25 = 0
            r14 = r18
            r7.<init>((com.google.android.gms.measurement.internal.zzfu) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r4.zzb     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzam r7 = r7.zza((java.lang.String) r2, (java.lang.String) r8)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x054d
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            long r7 = r7.zzh(r2)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r9 = r9.zza()     // Catch:{ all -> 0x09be }
            int r9 = r9.zzb(r2)     // Catch:{ all -> 0x09be }
            long r9 = (long) r9     // Catch:{ all -> 0x09be }
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0533
            if (r6 == 0) goto L_0x0533
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r2)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzi()     // Catch:{ all -> 0x09be }
            java.lang.String r4 = r4.zzb     // Catch:{ all -> 0x09be }
            java.lang.String r4 = r7.zza((java.lang.String) r4)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza()     // Catch:{ all -> 0x09be }
            int r7 = r7.zzb(r2)     // Catch:{ all -> 0x09be }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x09be }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkv r7 = r3.zzh()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzky r8 = r1.zzaa     // Catch:{ all -> 0x09be }
            r10 = 8
            r11 = 0
            r12 = 0
            r13 = 0
            r9 = r2
            r7.zza((com.google.android.gms.measurement.internal.zzky) r8, (java.lang.String) r9, (int) r10, (java.lang.String) r11, (java.lang.String) r12, (int) r13)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()
            r2.zzg()
            return
        L_0x0533:
            com.google.android.gms.measurement.internal.zzam r6 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x09be }
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x09be }
            r10 = 0
            r12 = 0
            long r14 = r4.zzc     // Catch:{ all -> 0x09be }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r6
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x09be }
            goto L_0x055b
        L_0x054d:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x09be }
            long r8 = r7.zzf     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzan r4 = r4.zza(r2, r8)     // Catch:{ all -> 0x09be }
            long r8 = r4.zzc     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzam r6 = r7.zza(r8)     // Catch:{ all -> 0x09be }
        L_0x055b:
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()     // Catch:{ all -> 0x09be }
            r2.zza((com.google.android.gms.measurement.internal.zzam) r6)     // Catch:{ all -> 0x09be }
            r26.zzx()     // Catch:{ all -> 0x09be }
            r26.zzn()     // Catch:{ all -> 0x09be }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x09be }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)     // Catch:{ all -> 0x09be }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x09be }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x09be }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x09be }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x09be }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x09be }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = com.google.android.gms.internal.measurement.zzcd.zzg.zzbh()     // Catch:{ all -> 0x09be }
            r6 = 1
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r2.zza((int) r6)     // Catch:{ all -> 0x09be }
            java.lang.String r7 = "android"
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r2.zza((java.lang.String) r7)     // Catch:{ all -> 0x09be }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x059a
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09be }
            r2.zzf((java.lang.String) r7)     // Catch:{ all -> 0x09be }
        L_0x059a:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x05a7
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x09be }
            r2.zze((java.lang.String) r7)     // Catch:{ all -> 0x09be }
        L_0x05a7:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x05b4
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x09be }
            r2.zzg((java.lang.String) r7)     // Catch:{ all -> 0x09be }
        L_0x05b4:
            long r7 = r3.zzj     // Catch:{ all -> 0x09be }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x05c3
            long r7 = r3.zzj     // Catch:{ all -> 0x09be }
            int r8 = (int) r7     // Catch:{ all -> 0x09be }
            r2.zzh((int) r8)     // Catch:{ all -> 0x09be }
        L_0x05c3:
            long r7 = r3.zze     // Catch:{ all -> 0x09be }
            r2.zzf((long) r7)     // Catch:{ all -> 0x09be }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x05d5
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x09be }
            r2.zzk((java.lang.String) r7)     // Catch:{ all -> 0x09be }
        L_0x05d5:
            boolean r7 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x0600
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x09be }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r8)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x0600
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzac r7 = r1.zza((java.lang.String) r7)     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r3.zzw     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzac r8 = com.google.android.gms.measurement.internal.zzac.zza((java.lang.String) r8)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzb((com.google.android.gms.measurement.internal.zzac) r8)     // Catch:{ all -> 0x09be }
            java.lang.String r7 = r7.zza()     // Catch:{ all -> 0x09be }
            r2.zzq(r7)     // Catch:{ all -> 0x09be }
        L_0x0600:
            boolean r7 = com.google.android.gms.internal.measurement.zznv.zzb()     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x064f
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r7 = r7.zza()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzas.zzbi     // Catch:{ all -> 0x09be }
            boolean r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x064f
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x062d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x062d
            java.lang.String r7 = r3.zzv     // Catch:{ all -> 0x09be }
            r2.zzp(r7)     // Catch:{ all -> 0x09be }
        L_0x062d:
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x0666
            java.lang.String r7 = r2.zzs()     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09be }
            r2.zzo(r7)     // Catch:{ all -> 0x09be }
            goto L_0x0666
        L_0x064f:
            java.lang.String r7 = r2.zzo()     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x0666
            java.lang.String r7 = r3.zzr     // Catch:{ all -> 0x09be }
            r2.zzo(r7)     // Catch:{ all -> 0x09be }
        L_0x0666:
            long r7 = r3.zzf     // Catch:{ all -> 0x09be }
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0673
            long r7 = r3.zzf     // Catch:{ all -> 0x09be }
            r2.zzh((long) r7)     // Catch:{ all -> 0x09be }
        L_0x0673:
            long r7 = r3.zzt     // Catch:{ all -> 0x09be }
            r2.zzk((long) r7)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkr r7 = r26.zzh()     // Catch:{ all -> 0x09be }
            java.util.List r7 = r7.zze()     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x0685
            r2.zzd((java.lang.Iterable<? extends java.lang.Integer>) r7)     // Catch:{ all -> 0x09be }
        L_0x0685:
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzac r7 = r1.zza((java.lang.String) r7)     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r3.zzw     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzac r8 = com.google.android.gms.measurement.internal.zzac.zza((java.lang.String) r8)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzb((com.google.android.gms.measurement.internal.zzac) r8)     // Catch:{ all -> 0x09be }
            boolean r8 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x06af
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r8 = r8.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x09be }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r11)     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x06af
            boolean r8 = r7.zzc()     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x0757
        L_0x06af:
            com.google.android.gms.measurement.internal.zzjr r8 = r1.zzj     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09be }
            android.util.Pair r8 = r8.zza(r11, r7)     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x06df
            java.lang.Object r11 = r8.first     // Catch:{ all -> 0x09be }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x09be }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x09be }
            if (r11 != 0) goto L_0x06df
            boolean r11 = r3.zzo     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0757
            java.lang.Object r11 = r8.first     // Catch:{ all -> 0x09be }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x09be }
            r2.zzh((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            java.lang.Object r11 = r8.second     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0757
            java.lang.Object r8 = r8.second     // Catch:{ all -> 0x09be }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x09be }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x09be }
            r2.zza((boolean) r8)     // Catch:{ all -> 0x09be }
            goto L_0x0757
        L_0x06df:
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzw()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            android.content.Context r11 = r11.zzm()     // Catch:{ all -> 0x09be }
            boolean r8 = r8.zza(r11)     // Catch:{ all -> 0x09be }
            if (r8 != 0) goto L_0x0757
            boolean r8 = r3.zzp     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x0757
            boolean r8 = com.google.android.gms.internal.measurement.zzoz.zzb()     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x070b
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r8 = r8.zza()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzcf     // Catch:{ all -> 0x09be }
            boolean r8 = r8.zze(r11, r12)     // Catch:{ all -> 0x09be }
            if (r8 != 0) goto L_0x0757
        L_0x070b:
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            android.content.Context r8 = r8.zzm()     // Catch:{ all -> 0x09be }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = "android_id"
            java.lang.String r8 = android.provider.Settings.Secure.getString(r8, r11)     // Catch:{ all -> 0x09be }
            if (r8 != 0) goto L_0x0737
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r8 = r8.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzh()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = "null secure ID. appId"
            java.lang.String r12 = r2.zzj()     // Catch:{ all -> 0x09be }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r12)     // Catch:{ all -> 0x09be }
            r8.zza(r11, r12)     // Catch:{ all -> 0x09be }
            java.lang.String r8 = "null"
            goto L_0x0754
        L_0x0737:
            boolean r11 = r8.isEmpty()     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0754
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r11 = r11.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r11 = r11.zzh()     // Catch:{ all -> 0x09be }
            java.lang.String r12 = "empty secure ID. appId"
            java.lang.String r13 = r2.zzj()     // Catch:{ all -> 0x09be }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r13)     // Catch:{ all -> 0x09be }
            r11.zza(r12, r13)     // Catch:{ all -> 0x09be }
        L_0x0754:
            r2.zzm(r8)     // Catch:{ all -> 0x09be }
        L_0x0757:
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzak r8 = r8.zzw()     // Catch:{ all -> 0x09be }
            r8.zzab()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ all -> 0x09be }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r8 = r2.zzc((java.lang.String) r8)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzak r11 = r11.zzw()     // Catch:{ all -> 0x09be }
            r11.zzab()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x09be }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r8 = r8.zzb((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzak r11 = r11.zzw()     // Catch:{ all -> 0x09be }
            long r11 = r11.zze()     // Catch:{ all -> 0x09be }
            int r12 = (int) r11     // Catch:{ all -> 0x09be }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r8 = r8.zzf((int) r12)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzak r11 = r11.zzw()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r11.zzf()     // Catch:{ all -> 0x09be }
            r8.zzd((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r8 = r8.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzas.zzbx     // Catch:{ all -> 0x09be }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r11)     // Catch:{ all -> 0x09be }
            if (r8 != 0) goto L_0x07a4
            long r11 = r3.zzl     // Catch:{ all -> 0x09be }
            r2.zzj((long) r11)     // Catch:{ all -> 0x09be }
        L_0x07a4:
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            boolean r8 = r8.zzaa()     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x07d2
            boolean r8 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x07c4
            com.google.android.gms.measurement.internal.zzfu r8 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r8 = r8.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x09be }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r11)     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x07c4
            r2.zzj()     // Catch:{ all -> 0x09be }
            goto L_0x07c7
        L_0x07c4:
            r2.zzj()     // Catch:{ all -> 0x09be }
        L_0x07c7:
            boolean r8 = android.text.TextUtils.isEmpty(r25)     // Catch:{ all -> 0x09be }
            if (r8 != 0) goto L_0x07d2
            r8 = r25
            r2.zzn(r8)     // Catch:{ all -> 0x09be }
        L_0x07d2:
            com.google.android.gms.measurement.internal.zzaf r8 = r26.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzf r8 = r8.zzb(r11)     // Catch:{ all -> 0x09be }
            if (r8 != 0) goto L_0x087f
            com.google.android.gms.measurement.internal.zzf r8 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x09be }
            r8.<init>(r11, r12)     // Catch:{ all -> 0x09be }
            boolean r11 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0803
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x09be }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0803
            java.lang.String r11 = r1.zza((com.google.android.gms.measurement.internal.zzac) r7)     // Catch:{ all -> 0x09be }
            r8.zza((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            goto L_0x080a
        L_0x0803:
            java.lang.String r11 = r26.zzz()     // Catch:{ all -> 0x09be }
            r8.zza((java.lang.String) r11)     // Catch:{ all -> 0x09be }
        L_0x080a:
            java.lang.String r11 = r3.zzk     // Catch:{ all -> 0x09be }
            r8.zzf((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r3.zzb     // Catch:{ all -> 0x09be }
            r8.zzb((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            boolean r11 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x082e
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x09be }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x082e
            boolean r11 = r7.zzc()     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0839
        L_0x082e:
            com.google.android.gms.measurement.internal.zzjr r11 = r1.zzj     // Catch:{ all -> 0x09be }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r11.zza(r12)     // Catch:{ all -> 0x09be }
            r8.zze((java.lang.String) r11)     // Catch:{ all -> 0x09be }
        L_0x0839:
            r8.zzg((long) r9)     // Catch:{ all -> 0x09be }
            r8.zza((long) r9)     // Catch:{ all -> 0x09be }
            r8.zzb((long) r9)     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r3.zzc     // Catch:{ all -> 0x09be }
            r8.zzg((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            long r11 = r3.zzj     // Catch:{ all -> 0x09be }
            r8.zzc((long) r11)     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r3.zzd     // Catch:{ all -> 0x09be }
            r8.zzh((java.lang.String) r11)     // Catch:{ all -> 0x09be }
            long r11 = r3.zze     // Catch:{ all -> 0x09be }
            r8.zzd((long) r11)     // Catch:{ all -> 0x09be }
            long r11 = r3.zzf     // Catch:{ all -> 0x09be }
            r8.zze((long) r11)     // Catch:{ all -> 0x09be }
            boolean r11 = r3.zzh     // Catch:{ all -> 0x09be }
            r8.zza((boolean) r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzbx     // Catch:{ all -> 0x09be }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09be }
            if (r11 != 0) goto L_0x0873
            long r11 = r3.zzl     // Catch:{ all -> 0x09be }
            r8.zzp(r11)     // Catch:{ all -> 0x09be }
        L_0x0873:
            long r11 = r3.zzt     // Catch:{ all -> 0x09be }
            r8.zzf((long) r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r11 = r26.zze()     // Catch:{ all -> 0x09be }
            r11.zza((com.google.android.gms.measurement.internal.zzf) r8)     // Catch:{ all -> 0x09be }
        L_0x087f:
            boolean r11 = com.google.android.gms.internal.measurement.zzml.zzb()     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0899
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzci     // Catch:{ all -> 0x09be }
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r12)     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x0899
            boolean r7 = r7.zze()     // Catch:{ all -> 0x09be }
            if (r7 == 0) goto L_0x08aa
        L_0x0899:
            java.lang.String r7 = r8.zzd()     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x08aa
            java.lang.String r7 = r8.zzd()     // Catch:{ all -> 0x09be }
            r2.zzi((java.lang.String) r7)     // Catch:{ all -> 0x09be }
        L_0x08aa:
            java.lang.String r7 = r8.zzi()     // Catch:{ all -> 0x09be }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x09be }
            if (r7 != 0) goto L_0x08bb
            java.lang.String r7 = r8.zzi()     // Catch:{ all -> 0x09be }
            r2.zzl((java.lang.String) r7)     // Catch:{ all -> 0x09be }
        L_0x08bb:
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x09be }
            java.util.List r3 = r7.zza((java.lang.String) r3)     // Catch:{ all -> 0x09be }
            r11 = 0
        L_0x08c6:
            int r7 = r3.size()     // Catch:{ all -> 0x09be }
            if (r11 >= r7) goto L_0x08fd
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = com.google.android.gms.internal.measurement.zzcd.zzk.zzj()     // Catch:{ all -> 0x09be }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkw r8 = (com.google.android.gms.measurement.internal.zzkw) r8     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r8.zzc     // Catch:{ all -> 0x09be }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = r7.zza((java.lang.String) r8)     // Catch:{ all -> 0x09be }
            java.lang.Object r8 = r3.get(r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkw r8 = (com.google.android.gms.measurement.internal.zzkw) r8     // Catch:{ all -> 0x09be }
            long r12 = r8.zzd     // Catch:{ all -> 0x09be }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r7 = r7.zza((long) r12)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkr r8 = r26.zzh()     // Catch:{ all -> 0x09be }
            java.lang.Object r12 = r3.get(r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzkw r12 = (com.google.android.gms.measurement.internal.zzkw) r12     // Catch:{ all -> 0x09be }
            java.lang.Object r12 = r12.zze     // Catch:{ all -> 0x09be }
            r8.zza((com.google.android.gms.internal.measurement.zzcd.zzk.zza) r7, (java.lang.Object) r12)     // Catch:{ all -> 0x09be }
            r2.zza((com.google.android.gms.internal.measurement.zzcd.zzk.zza) r7)     // Catch:{ all -> 0x09be }
            int r11 = r11 + 1
            goto L_0x08c6
        L_0x08fd:
            com.google.android.gms.measurement.internal.zzaf r3 = r26.zze()     // Catch:{ IOException -> 0x0972 }
            com.google.android.gms.internal.measurement.zzjj r7 = r2.zzy()     // Catch:{ IOException -> 0x0972 }
            com.google.android.gms.internal.measurement.zzhy r7 = (com.google.android.gms.internal.measurement.zzhy) r7     // Catch:{ IOException -> 0x0972 }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = (com.google.android.gms.internal.measurement.zzcd.zzg) r7     // Catch:{ IOException -> 0x0972 }
            long r2 = r3.zza((com.google.android.gms.internal.measurement.zzcd.zzg) r7)     // Catch:{ IOException -> 0x0972 }
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zze()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzap r8 = r4.zze     // Catch:{ all -> 0x09be }
            if (r8 == 0) goto L_0x0968
            com.google.android.gms.measurement.internal.zzap r8 = r4.zze     // Catch:{ all -> 0x09be }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x09be }
        L_0x091b:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x092f
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x09be }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x09be }
            boolean r11 = r5.equals(r11)     // Catch:{ all -> 0x09be }
            if (r11 == 0) goto L_0x091b
        L_0x092d:
            r11 = 1
            goto L_0x0969
        L_0x092f:
            com.google.android.gms.measurement.internal.zzfo r5 = r26.zzc()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r4.zza     // Catch:{ all -> 0x09be }
            java.lang.String r11 = r4.zzb     // Catch:{ all -> 0x09be }
            boolean r5 = r5.zzc(r8, r11)     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r11 = r26.zze()     // Catch:{ all -> 0x09be }
            long r12 = r26.zzy()     // Catch:{ all -> 0x09be }
            java.lang.String r14 = r4.zza     // Catch:{ all -> 0x09be }
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            com.google.android.gms.measurement.internal.zzae r8 = r11.zza(r12, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x09be }
            if (r5 == 0) goto L_0x0968
            long r11 = r8.zze     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzab r5 = r5.zza()     // Catch:{ all -> 0x09be }
            java.lang.String r8 = r4.zza     // Catch:{ all -> 0x09be }
            int r5 = r5.zzc(r8)     // Catch:{ all -> 0x09be }
            long r13 = (long) r5     // Catch:{ all -> 0x09be }
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0968
            goto L_0x092d
        L_0x0968:
            r11 = 0
        L_0x0969:
            boolean r2 = r7.zza((com.google.android.gms.measurement.internal.zzan) r4, (long) r2, (boolean) r11)     // Catch:{ all -> 0x09be }
            if (r2 == 0) goto L_0x098b
            r1.zzn = r9     // Catch:{ all -> 0x09be }
            goto L_0x098b
        L_0x0972:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzk     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzeq r4 = r4.zzq()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zze()     // Catch:{ all -> 0x09be }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzj()     // Catch:{ all -> 0x09be }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r2)     // Catch:{ all -> 0x09be }
            r4.zza(r5, r2, r3)     // Catch:{ all -> 0x09be }
        L_0x098b:
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()     // Catch:{ all -> 0x09be }
            r2.mo31259b_()     // Catch:{ all -> 0x09be }
            com.google.android.gms.measurement.internal.zzaf r2 = r26.zze()
            r2.zzg()
            r26.zzab()
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzw()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x09be:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzaf r3 = r26.zze()
            r3.zzg()
            goto L_0x09c9
        L_0x09c8:
            throw r2
        L_0x09c9:
            goto L_0x09c8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzc(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzn):void");
    }

    private final boolean zze(zzn zzn2) {
        return (!zznv.zzb() || !this.zzk.zza().zze(zzn2.zza, zzas.zzbi)) ? !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzr) : !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzv) || !TextUtils.isEmpty(zzn2.zzr);
    }

    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzk.zzp().zza(new zzkp(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzk.zzq().zze().zza("Failed to get app instance id. appId", zzeq.zza(zzn2.zza), e);
            return null;
        }
    }

    @WorkerThread
    private final void zzb(zzaq zzaq, zzn zzn2) {
        if (zznw.zzb() && this.zzk.zza().zza(zzas.zzbz)) {
            zzeu zza2 = zzeu.zza(zzaq);
            this.zzk.zzh().zza(zza2.zzb, zze().zzi(zzn2.zza));
            this.zzk.zzh().zza(zza2, this.zzk.zza().zza(zzn2.zza));
            zzaq = zza2.zza();
        }
        if (this.zzk.zza().zza(zzas.zzbd) && "_cmp".equals(zzaq.zza) && "referrer API v2".equals(zzaq.zzb.zzd("_cis"))) {
            String zzd2 = zzaq.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zza(new zzku("_lgclid", zzaq.zzd, zzd2, "auto"), zzn2);
            }
        }
        zza(zzaq, zzn2);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzks zzks) {
        this.zzk.zzp().zzc();
        zzaf zzaf = new zzaf(this);
        zzaf.zzak();
        this.zzd = zzaf;
        this.zzk.zza().zza((zzad) this.zzb);
        zzjr zzjr = new zzjr(this);
        zzjr.zzak();
        this.zzj = zzjr;
        zzr zzr2 = new zzr(this);
        zzr2.zzak();
        this.zzg = zzr2;
        zzih zzih = new zzih(this);
        zzih.zzak();
        this.zzi = zzih;
        zzkh zzkh = new zzkh(this);
        zzkh.zzak();
        this.zzf = zzkh;
        this.zze = new zzfa(this);
        if (this.zzp != this.zzq) {
            this.zzk.zzq().zze().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzl = true;
    }

    private final void zzb(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkr.zza((zzcd.zzc) ((zzhy) zza2.zzy()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzcd.zze zza5 = zzkr.zza((zzcd.zzc) ((zzhy) zza3.zzy()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh();
            zzkr.zza(zza3, "_et", (Object) Long.valueOf(zzf2));
            zzh();
            zzkr.zza(zza2, "_fr", (Object) 1L);
        }
    }

    @WorkerThread
    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzm() != -2147483648L) {
                if (zzf2.zzm() == ((long) Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionName;
                if (zzf2.zzl() != null && zzf2.zzl().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    public final void zza() {
        this.zzk.zzp().zzc();
        zze().zzu();
        if (this.zzk.zzb().zzc.zza() == 0) {
            this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
        }
        zzab();
    }

    @WorkerThread
    public final void zza(String str, zzac zzac) {
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            this.zzz.put(str, zzac);
            zzaf zze2 = zze();
            if (zzml.zzb() && zze2.zzs().zza(zzas.zzci)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzac);
                zze2.zzc();
                zze2.zzaj();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzac.zza());
                try {
                    if (zze2.mo31260c_().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                        zze2.zzq().zze().zza("Failed to insert/update consent setting (got -1). appId", zzeq.zza(str));
                    }
                } catch (SQLiteException e) {
                    zze2.zzq().zze().zza("Error storing consent setting. appId, error", zzeq.zza(str), e);
                }
            }
        }
    }

    @WorkerThread
    public final void zzb(zzku zzku, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (!"_npa".equals(zzku.zza) || zzn2.zzs == null) {
                this.zzk.zzq().zzv().zza("Removing user property", this.zzk.zzi().zzc(zzku.zza));
                zze().zze();
                try {
                    zzc(zzn2);
                    zze().zzb(zzn2.zza, zzku.zza);
                    zze().mo31259b_();
                    this.zzk.zzq().zzv().zza("User property removed", this.zzk.zzi().zzc(zzku.zza));
                } finally {
                    zze().zzg();
                }
            } else {
                this.zzk.zzq().zzv().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzku("_npa", this.zzk.zzl().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), "auto"), zzn2);
            }
        }
    }

    @WorkerThread
    public final zzac zza(String str) {
        zzac zzac = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            zzac = this.zzz.get(str);
            if (zzac == null) {
                zzac = zze().zzj(str);
                if (zzac == null) {
                    zzac = zzac.zza;
                }
                zza(str, zzac);
            }
        }
        return zzac;
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x0483 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01d2 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0206 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0208 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x020c A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x022f A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0235 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0242 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0255 A[Catch:{ SQLiteException -> 0x01bd, all -> 0x04af }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzx()
            r21.zzn()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            boolean r7 = r21.zze(r22)
            if (r7 != 0) goto L_0x0023
            return
        L_0x0023:
            com.google.android.gms.measurement.internal.zzaf r7 = r21.zze()
            java.lang.String r8 = r2.zza
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzb(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0056
            java.lang.String r10 = r7.zze()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0056
            java.lang.String r10 = r2.zzb
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0056
            r7.zzh((long) r8)
            com.google.android.gms.measurement.internal.zzaf r10 = r21.zze()
            r10.zza((com.google.android.gms.measurement.internal.zzf) r7)
            com.google.android.gms.measurement.internal.zzfo r7 = r21.zzc()
            java.lang.String r10 = r2.zza
            r7.zzd(r10)
        L_0x0056:
            boolean r7 = r2.zzh
            if (r7 != 0) goto L_0x005e
            r21.zzc(r22)
            return
        L_0x005e:
            long r10 = r2.zzm
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk
            com.google.android.gms.common.util.Clock r7 = r7.zzl()
            long r10 = r7.currentTimeMillis()
        L_0x006e:
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzw()
            r7.zzh()
            int r7 = r2.zzn
            r15 = 1
            if (r7 == 0) goto L_0x0098
            if (r7 == r15) goto L_0x0098
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzk
            com.google.android.gms.measurement.internal.zzeq r12 = r12.zzq()
            com.google.android.gms.measurement.internal.zzes r12 = r12.zzh()
            java.lang.String r13 = r2.zza
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zza(r14, r13, r7)
            r7 = 0
        L_0x0098:
            com.google.android.gms.measurement.internal.zzaf r12 = r21.zze()
            r12.zze()
            com.google.android.gms.measurement.internal.zzaf r12 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzkw r14 = r12.zzc(r13, r14)     // Catch:{ all -> 0x04af }
            if (r14 == 0) goto L_0x00bc
            java.lang.String r12 = "auto"
            java.lang.String r13 = r14.zzb     // Catch:{ all -> 0x04af }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x04af }
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            r18 = r3
            r3 = 1
            goto L_0x010f
        L_0x00bc:
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04af }
            if (r12 == 0) goto L_0x00f9
            com.google.android.gms.measurement.internal.zzku r13 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ all -> 0x04af }
            java.lang.String r18 = "_npa"
            java.lang.Boolean r12 = r2.zzs     // Catch:{ all -> 0x04af }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x04af }
            if (r12 == 0) goto L_0x00cf
            r19 = 1
            goto L_0x00d1
        L_0x00cf:
            r19 = r8
        L_0x00d1:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x04af }
            java.lang.String r20 = "auto"
            r8 = 1
            r12 = r13
            r8 = r13
            r13 = r18
            r18 = r3
            r9 = r14
            r3 = 1
            r14 = r10
            r16 = r19
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04af }
            if (r9 == 0) goto L_0x00f5
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x04af }
            java.lang.Long r12 = r8.zzc     // Catch:{ all -> 0x04af }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x04af }
            if (r9 != 0) goto L_0x010f
        L_0x00f5:
            r1.zza((com.google.android.gms.measurement.internal.zzku) r8, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x010f
        L_0x00f9:
            r18 = r3
            r9 = r14
            r3 = 1
            if (r9 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzku r8 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "_npa"
            r16 = 0
            java.lang.String r17 = "auto"
            r12 = r8
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzku) r8, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
        L_0x010f:
            com.google.android.gms.measurement.internal.zzaf r8 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzf r8 = r8.zzb(r9)     // Catch:{ all -> 0x04af }
            if (r8 == 0) goto L_0x01d0
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzk     // Catch:{ all -> 0x04af }
            r12.zzh()     // Catch:{ all -> 0x04af }
            java.lang.String r12 = r2.zzb     // Catch:{ all -> 0x04af }
            java.lang.String r13 = r8.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r14 = r2.zzr     // Catch:{ all -> 0x04af }
            java.lang.String r15 = r8.zzf()     // Catch:{ all -> 0x04af }
            boolean r12 = com.google.android.gms.measurement.internal.zzkv.zza((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x04af }
            if (r12 == 0) goto L_0x01d0
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzeq r12 = r12.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzes r12 = r12.zzh()     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r8.zzc()     // Catch:{ all -> 0x04af }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r14)     // Catch:{ all -> 0x04af }
            r12.zza(r13, r14)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzaf r12 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r8 = r8.zzc()     // Catch:{ all -> 0x04af }
            r12.zzaj()     // Catch:{ all -> 0x04af }
            r12.zzc()     // Catch:{ all -> 0x04af }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x04af }
            android.database.sqlite.SQLiteDatabase r13 = r12.mo31260c_()     // Catch:{ SQLiteException -> 0x01bd }
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01bd }
            r15 = 0
            r14[r15] = r8     // Catch:{ SQLiteException -> 0x01bd }
            java.lang.String r9 = "events"
            int r9 = r13.delete(r9, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "apps"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r15
            java.lang.String r15 = "consent_settings"
            int r0 = r13.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01bd }
            int r9 = r9 + r0
            if (r9 <= 0) goto L_0x01cf
            com.google.android.gms.measurement.internal.zzeq r0 = r12.zzq()     // Catch:{ SQLiteException -> 0x01bd }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzw()     // Catch:{ SQLiteException -> 0x01bd }
            java.lang.String r13 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ SQLiteException -> 0x01bd }
            r0.zza(r13, r8, r9)     // Catch:{ SQLiteException -> 0x01bd }
            goto L_0x01cf
        L_0x01bd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeq r9 = r12.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r8)     // Catch:{ all -> 0x04af }
            r9.zza(r12, r8, r0)     // Catch:{ all -> 0x04af }
        L_0x01cf:
            r8 = 0
        L_0x01d0:
            if (r8 == 0) goto L_0x022f
            long r12 = r8.zzm()     // Catch:{ all -> 0x04af }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x01ea
            long r12 = r8.zzm()     // Catch:{ all -> 0x04af }
            r9 = r4
            long r3 = r2.zzj     // Catch:{ all -> 0x04af }
            int r0 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01eb
            r0 = 1
            goto L_0x01ec
        L_0x01ea:
            r9 = r4
        L_0x01eb:
            r0 = 0
        L_0x01ec:
            long r3 = r8.zzm()     // Catch:{ all -> 0x04af }
            int r12 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x0208
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04af }
            if (r3 == 0) goto L_0x0208
            java.lang.String r3 = r8.zzl()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zzc     // Catch:{ all -> 0x04af }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04af }
            if (r3 != 0) goto L_0x0208
            r14 = 1
            goto L_0x0209
        L_0x0208:
            r14 = 0
        L_0x0209:
            r0 = r0 | r14
            if (r0 == 0) goto L_0x0230
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r0.<init>()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r8.zzl()     // Catch:{ all -> 0x04af }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzap r14 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x04af }
            r14.<init>(r0)     // Catch:{ all -> 0x04af }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x0230
        L_0x022f:
            r9 = r4
        L_0x0230:
            r21.zzc(r22)     // Catch:{ all -> 0x04af }
            if (r7 != 0) goto L_0x0242
            com.google.android.gms.measurement.internal.zzaf r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.zzam r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x04af }
            goto L_0x0253
        L_0x0242:
            r3 = 1
            if (r7 != r3) goto L_0x0252
            com.google.android.gms.measurement.internal.zzaf r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.zzam r0 = r0.zza((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x04af }
            goto L_0x0253
        L_0x0252:
            r0 = 0
        L_0x0253:
            if (r0 != 0) goto L_0x0483
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r12 = r10 / r3
            r14 = 1
            long r12 = r12 + r14
            long r12 = r12 * r3
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r4 = "_c"
            java.lang.String r8 = "_et"
            if (r7 != 0) goto L_0x03e1
            com.google.android.gms.measurement.internal.zzku r7 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ all -> 0x04af }
            java.lang.String r14 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04af }
            java.lang.String r17 = "auto"
            r12 = r7
            r13 = r14
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzku) r7, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            r21.zzx()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzfu r7 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzfl r7 = r7.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04af }
            r7.zza(r12)     // Catch:{ all -> 0x04af }
            r21.zzx()     // Catch:{ all -> 0x04af }
            r21.zzn()     // Catch:{ all -> 0x04af }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r7.<init>()     // Catch:{ all -> 0x04af }
            r12 = 1
            r7.putLong(r4, r12)     // Catch:{ all -> 0x04af }
            r7.putLong(r3, r12)     // Catch:{ all -> 0x04af }
            r3 = 0
            r7.putLong(r6, r3)     // Catch:{ all -> 0x04af }
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04af }
            r7.putLong(r9, r3)     // Catch:{ all -> 0x04af }
            r14 = r18
            r7.putLong(r14, r3)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzab r3 = r3.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzas     // Catch:{ all -> 0x04af }
            boolean r3 = r3.zze(r4, r12)     // Catch:{ all -> 0x04af }
            if (r3 == 0) goto L_0x02c3
            r3 = 1
            r7.putLong(r8, r3)     // Catch:{ all -> 0x04af }
            goto L_0x02c5
        L_0x02c3:
            r3 = 1
        L_0x02c5:
            boolean r12 = r2.zzq     // Catch:{ all -> 0x04af }
            if (r12 == 0) goto L_0x02cc
            r7.putLong(r0, r3)     // Catch:{ all -> 0x04af }
        L_0x02cc:
            com.google.android.gms.measurement.internal.zzaf r0 = r21.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x04af }
            r0.zzc()     // Catch:{ all -> 0x04af }
            r0.zzaj()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzh(r3, r4)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x04af }
            android.content.Context r0 = r0.zzm()     // Catch:{ all -> 0x04af }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04af }
            if (r0 != 0) goto L_0x0306
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzeq r0 = r0.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r6 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r9)     // Catch:{ all -> 0x04af }
            r0.zza(r6, r9)     // Catch:{ all -> 0x04af }
        L_0x0302:
            r12 = 0
            goto L_0x03c5
        L_0x0306:
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ NameNotFoundException -> 0x0318 }
            android.content.Context r0 = r0.zzm()     // Catch:{ NameNotFoundException -> 0x0318 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0318 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0318 }
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0318 }
            goto L_0x032f
        L_0x0318:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzeq r12 = r12.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzes r12 = r12.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r15)     // Catch:{ all -> 0x04af }
            r12.zza(r13, r15, r0)     // Catch:{ all -> 0x04af }
            r0 = 0
        L_0x032f:
            if (r0 == 0) goto L_0x0381
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04af }
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0381
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x04af }
            r18 = r14
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x04af }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0364
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzab r0 = r0.zza()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzas.zzbm     // Catch:{ all -> 0x04af }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r12)     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x035d
            r12 = 0
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0362
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04af }
            goto L_0x0362
        L_0x035d:
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04af }
        L_0x0362:
            r14 = 0
            goto L_0x0365
        L_0x0364:
            r14 = 1
        L_0x0365:
            com.google.android.gms.measurement.internal.zzku r0 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "_fi"
            if (r14 == 0) goto L_0x036e
            r14 = 1
            goto L_0x0370
        L_0x036e:
            r14 = 0
        L_0x0370:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x04af }
            java.lang.String r17 = "auto"
            r12 = r0
            r6 = r18
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzku) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x0382
        L_0x0381:
            r6 = r14
        L_0x0382:
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ NameNotFoundException -> 0x0394 }
            android.content.Context r0 = r0.zzm()     // Catch:{ NameNotFoundException -> 0x0394 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0394 }
            java.lang.String r12 = r2.zza     // Catch:{ NameNotFoundException -> 0x0394 }
            r13 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r12, r13)     // Catch:{ NameNotFoundException -> 0x0394 }
            goto L_0x03ab
        L_0x0394:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzeq r12 = r12.zzq()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzes r12 = r12.zze()     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x04af }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r14)     // Catch:{ all -> 0x04af }
            r12.zza(r13, r14, r0)     // Catch:{ all -> 0x04af }
            r0 = 0
        L_0x03ab:
            if (r0 == 0) goto L_0x0302
            int r12 = r0.flags     // Catch:{ all -> 0x04af }
            r13 = 1
            r12 = r12 & r13
            if (r12 == 0) goto L_0x03b8
            r12 = 1
            r7.putLong(r9, r12)     // Catch:{ all -> 0x04af }
        L_0x03b8:
            int r0 = r0.flags     // Catch:{ all -> 0x04af }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0302
            r12 = 1
            r7.putLong(r6, r12)     // Catch:{ all -> 0x04af }
            goto L_0x0302
        L_0x03c5:
            int r0 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x03cc
            r7.putLong(r5, r3)     // Catch:{ all -> 0x04af }
        L_0x03cc:
            com.google.android.gms.measurement.internal.zzaq r0 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzap r14 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x04af }
            r14.<init>(r7)     // Catch:{ all -> 0x04af }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzaq) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x043d
        L_0x03e1:
            r5 = 1
            if (r7 != r5) goto L_0x043d
            com.google.android.gms.measurement.internal.zzku r5 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ all -> 0x04af }
            java.lang.String r6 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x04af }
            java.lang.String r17 = "auto"
            r12 = r5
            r13 = r6
            r14 = r10
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x04af }
            r1.zza((com.google.android.gms.measurement.internal.zzku) r5, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            r21.zzx()     // Catch:{ all -> 0x04af }
            r21.zzn()     // Catch:{ all -> 0x04af }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r5.<init>()     // Catch:{ all -> 0x04af }
            r6 = 1
            r5.putLong(r4, r6)     // Catch:{ all -> 0x04af }
            r5.putLong(r3, r6)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzab r3 = r3.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzas     // Catch:{ all -> 0x04af }
            boolean r3 = r3.zze(r4, r6)     // Catch:{ all -> 0x04af }
            if (r3 == 0) goto L_0x0420
            r3 = 1
            r5.putLong(r8, r3)     // Catch:{ all -> 0x04af }
            goto L_0x0422
        L_0x0420:
            r3 = 1
        L_0x0422:
            boolean r6 = r2.zzq     // Catch:{ all -> 0x04af }
            if (r6 == 0) goto L_0x0429
            r5.putLong(r0, r3)     // Catch:{ all -> 0x04af }
        L_0x0429:
            com.google.android.gms.measurement.internal.zzaq r0 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzap r14 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x04af }
            r14.<init>(r5)     // Catch:{ all -> 0x04af }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzaq) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
        L_0x043d:
            com.google.android.gms.measurement.internal.zzfu r0 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzab r0 = r0.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x04af }
            boolean r0 = r0.zze(r3, r4)     // Catch:{ all -> 0x04af }
            if (r0 != 0) goto L_0x04a0
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r0.<init>()     // Catch:{ all -> 0x04af }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzfu r3 = r1.zzk     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzab r3 = r3.zza()     // Catch:{ all -> 0x04af }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzas.zzas     // Catch:{ all -> 0x04af }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x04af }
            if (r3 == 0) goto L_0x046e
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04af }
        L_0x046e:
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzap r14 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x04af }
            r14.<init>(r0)     // Catch:{ all -> 0x04af }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
            goto L_0x04a0
        L_0x0483:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04af }
            if (r0 == 0) goto L_0x04a0
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04af }
            r0.<init>()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x04af }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzap r14 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x04af }
            r14.<init>(r0)     // Catch:{ all -> 0x04af }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x04af }
            r1.zzb((com.google.android.gms.measurement.internal.zzaq) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04af }
        L_0x04a0:
            com.google.android.gms.measurement.internal.zzaf r0 = r21.zze()     // Catch:{ all -> 0x04af }
            r0.mo31259b_()     // Catch:{ all -> 0x04af }
            com.google.android.gms.measurement.internal.zzaf r0 = r21.zze()
            r0.zzg()
            return
        L_0x04af:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzaf r2 = r21.zze()
            r2.zzg()
            goto L_0x04b9
        L_0x04b8:
            throw r0
        L_0x04b9:
            goto L_0x04b8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00df  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.measurement.internal.zzaq r36, java.lang.String r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r3 = r37
            com.google.android.gms.measurement.internal.zzaf r2 = r35.zze()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzb(r3)
            if (r2 == 0) goto L_0x0112
            java.lang.String r4 = r2.zzl()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x001c
            goto L_0x0112
        L_0x001c:
            java.lang.Boolean r4 = r0.zzb((com.google.android.gms.measurement.internal.zzf) r2)
            if (r4 != 0) goto L_0x0040
            java.lang.String r4 = r1.zza
            java.lang.String r5 = "_ui"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfu r4 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r4 = r4.zzq()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzh()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r37)
            java.lang.String r6 = "Could not find package. appId"
            r4.zza(r6, r5)
            goto L_0x005a
        L_0x0040:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r37)
            java.lang.String r3 = "App version does not match; dropping event. appId"
            r1.zza(r3, r2)
            return
        L_0x005a:
            com.google.android.gms.measurement.internal.zzn r15 = new com.google.android.gms.measurement.internal.zzn
            java.lang.String r4 = r2.zze()
            java.lang.String r5 = r2.zzl()
            long r6 = r2.zzm()
            java.lang.String r8 = r2.zzn()
            long r9 = r2.zzo()
            long r11 = r2.zzp()
            boolean r14 = r2.zzr()
            r16 = 0
            java.lang.String r17 = r2.zzi()
            long r18 = r2.zzae()
            r20 = 0
            r22 = 0
            boolean r23 = r2.zzaf()
            boolean r24 = r2.zzag()
            r25 = 0
            java.lang.String r26 = r2.zzf()
            java.lang.Boolean r27 = r2.zzah()
            long r28 = r2.zzq()
            java.util.List r30 = r2.zzai()
            boolean r31 = com.google.android.gms.internal.measurement.zznv.zzb()
            if (r31 == 0) goto L_0x00bf
            com.google.android.gms.measurement.internal.zzfu r13 = r0.zzk
            com.google.android.gms.measurement.internal.zzab r13 = r13.zza()
            java.lang.String r1 = r2.zzc()
            r32 = r14
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzas.zzbi
            boolean r1 = r13.zze(r1, r14)
            if (r1 == 0) goto L_0x00c1
            java.lang.String r1 = r2.zzg()
            goto L_0x00c2
        L_0x00bf:
            r32 = r14
        L_0x00c1:
            r1 = 0
        L_0x00c2:
            boolean r2 = com.google.android.gms.internal.measurement.zzml.zzb()
            if (r2 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzfu r2 = r0.zzk
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r13)
            if (r2 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzac r2 = r0.zza((java.lang.String) r3)
            java.lang.String r2 = r2.zza()
            goto L_0x00e1
        L_0x00df:
            java.lang.String r2 = ""
        L_0x00e1:
            r33 = r2
            r2 = r15
            r3 = r37
            r13 = 0
            r14 = r32
            r34 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r19 = r20
            r21 = r22
            r22 = r23
            r23 = r24
            r24 = r25
            r25 = r26
            r26 = r27
            r27 = r28
            r29 = r30
            r30 = r1
            r31 = r33
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (long) r6, (java.lang.String) r8, (long) r9, (long) r11, (java.lang.String) r13, (boolean) r14, (boolean) r15, (java.lang.String) r16, (long) r17, (long) r19, (int) r21, (boolean) r22, (boolean) r23, (boolean) r24, (java.lang.String) r25, (java.lang.Boolean) r26, (long) r27, (java.util.List<java.lang.String>) r29, (java.lang.String) r30, (java.lang.String) r31)
            r1 = r36
            r2 = r34
            r0.zzb((com.google.android.gms.measurement.internal.zzaq) r1, (com.google.android.gms.measurement.internal.zzn) r2)
            return
        L_0x0112:
            com.google.android.gms.measurement.internal.zzfu r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzv()
            java.lang.String r2 = "No app data available; dropping event"
            r1.zza(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzaq, java.lang.String):void");
    }

    @WorkerThread
    public final void zza(zzaq zzaq, zzn zzn2) {
        List<zzz> list;
        List<zzz> list2;
        List<zzz> list3;
        zzaq zzaq2 = zzaq;
        zzn zzn3 = zzn2;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn3.zza);
        zzx();
        zzn();
        String str = zzn3.zza;
        long j = zzaq2.zzd;
        zzh();
        if (zzkr.zza(zzaq, zzn2)) {
            if (!zzn3.zzh) {
                zzc(zzn3);
                return;
            }
            List<String> list4 = zzn3.zzu;
            if (list4 != null) {
                if (list4.contains(zzaq2.zza)) {
                    Bundle zzb2 = zzaq2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzaq2 = new zzaq(zzaq2.zza, new zzap(zzb2), zzaq2.zzc, zzaq2.zzd);
                } else {
                    this.zzk.zzq().zzv().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaq2.zza, zzaq2.zzc);
                    return;
                }
            }
            zze().zze();
            try {
                zzaf zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzc();
                zze2.zzaj();
                if (j < 0) {
                    zze2.zzq().zzh().zza("Invalid time querying timed out conditional properties", zzeq.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz next : list) {
                    if (next != null) {
                        this.zzk.zzq().zzw().zza("User property timed out", next.zza, this.zzk.zzi().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                            zzc(new zzaq(next.zzg, j), zzn3);
                        }
                        zze().zze(str, next.zzc.zza);
                    }
                }
                zzaf zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzc();
                zze3.zzaj();
                if (j < 0) {
                    zze3.zzq().zzh().zza("Invalid time querying expired conditional properties", zzeq.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzz next2 : list2) {
                    if (next2 != null) {
                        this.zzk.zzq().zzw().zza("User property expired", next2.zza, this.zzk.zzi().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().zzb(str, next2.zzc.zza);
                        if (next2.zzk != null) {
                            arrayList.add(next2.zzk);
                        }
                        zze().zze(str, next2.zzc.zza);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzc(new zzaq((zzaq) obj, j), zzn3);
                }
                zzaf zze4 = zze();
                String str2 = zzaq2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzc();
                zze4.zzaj();
                if (j < 0) {
                    zze4.zzq().zzh().zza("Invalid time querying triggered conditional properties", zzeq.zza(str), zze4.zzn().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzz next3 : list3) {
                    if (next3 != null) {
                        zzku zzku = next3.zzc;
                        zzkw zzkw = r4;
                        zzkw zzkw2 = new zzkw(next3.zza, next3.zzb, zzku.zza, j, zzku.zza());
                        if (zze().zza(zzkw)) {
                            this.zzk.zzq().zzw().zza("User property triggered", next3.zza, this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        } else {
                            this.zzk.zzq().zze().zza("Too many active user properties, ignoring", zzeq.zza(next3.zza), this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        }
                        if (next3.zzi != null) {
                            arrayList2.add(next3.zzi);
                        }
                        next3.zzc = new zzku(zzkw);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                zzc(zzaq2, zzn3);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    zzc(new zzaq((zzaq) obj2, j), zzn3);
                }
                zze().mo31259b_();
            } finally {
                zze().zzg();
            }
        }
    }

    @WorkerThread
    private final String zza(zzac zzac) {
        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zze()) {
            return zzz();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x024e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x024f, code lost:
        r5 = r1;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0254, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0255, code lost:
        r25 = "";
        r4 = r0;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:610:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x024e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x026d A[SYNTHETIC, Splitter:B:128:0x026d] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0274 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0282 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0459 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x045b A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x045e A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x045f A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x047e A[SYNTHETIC, Splitter:B:216:0x047e] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x051c A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x057e A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0582 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x05e8 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0618 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0637 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x072b A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x08b9 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x08d1 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:355:0x08eb A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:486:0x0c6e A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:487:0x0c81 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:489:0x0c84 A[Catch:{ IOException -> 0x0228, all -> 0x1015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:490:0x0cab A[SYNTHETIC, Splitter:B:490:0x0cab] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011a A[Catch:{ SQLiteException -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:601:0x0ff8  */
    /* JADX WARNING: Removed duplicated region for block: B:609:0x100f A[SYNTHETIC, Splitter:B:609:0x100f] */
    /* JADX WARNING: Removed duplicated region for block: B:625:0x04e1 A[EDGE_INSN: B:625:0x04e1->B:225:0x04e1 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012f A[SYNTHETIC, Splitter:B:62:0x012f] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r43, long r44) {
        /*
            r42 = this;
            r1 = r42
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            java.lang.String r4 = ""
            com.google.android.gms.measurement.internal.zzaf r5 = r42.zze()
            r5.zze()
            com.google.android.gms.measurement.internal.zzkl$zza r5 = new com.google.android.gms.measurement.internal.zzkl$zza     // Catch:{ all -> 0x1015 }
            r6 = 0
            r5.<init>(r1, r6)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzaf r7 = r42.zze()     // Catch:{ all -> 0x1015 }
            long r8 = r1.zzy     // Catch:{ all -> 0x1015 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x1015 }
            r7.zzc()     // Catch:{ all -> 0x1015 }
            r7.zzaj()     // Catch:{ all -> 0x1015 }
            r11 = -1
            r13 = 2
            r14 = 0
            r15 = 1
            android.database.sqlite.SQLiteDatabase r10 = r7.mo31260c_()     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            boolean r16 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            if (r16 == 0) goto L_0x0095
            int r16 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r16 == 0) goto L_0x0046
            java.lang.String[] r6 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            java.lang.String r16 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            r6[r14] = r16     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            java.lang.String r16 = java.lang.String.valueOf(r44)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            r6[r15] = r16     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            goto L_0x004e
        L_0x0046:
            java.lang.String[] r6 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            java.lang.String r16 = java.lang.String.valueOf(r44)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            r6[r14] = r16     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
        L_0x004e:
            int r16 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r16 == 0) goto L_0x0057
            java.lang.String r16 = "rowid <= ? and "
            r44 = r16
            goto L_0x0059
        L_0x0057:
            r44 = r4
        L_0x0059:
            int r13 = r44.length()     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            int r13 = r13 + 148
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            r11.<init>(r13)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            java.lang.String r12 = "select app_id, metadata_fingerprint from raw_events where "
            r11.append(r12)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            r12 = r44
            r11.append(r12)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            java.lang.String r12 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r11.append(r12)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            java.lang.String r11 = r11.toString()     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            android.database.Cursor r6 = r10.rawQuery(r11, r6)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            boolean r11 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x0091 }
            if (r11 != 0) goto L_0x0085
            r6.close()     // Catch:{ all -> 0x1015 }
            goto L_0x00e6
        L_0x0085:
            java.lang.String r11 = r6.getString(r14)     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r12 = r6.getString(r15)     // Catch:{ SQLiteException -> 0x0244 }
            r6.close()     // Catch:{ SQLiteException -> 0x0244 }
            goto L_0x00f2
        L_0x0091:
            r0 = move-exception
            r25 = r4
            goto L_0x00aa
        L_0x0095:
            int r6 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x00ae
            r6 = 2
            java.lang.String[] r11 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            r6 = 0
            r11[r14] = r6     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            java.lang.String r6 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            r11[r15] = r6     // Catch:{ SQLiteException -> 0x00a6, all -> 0x024e }
            goto L_0x00b3
        L_0x00a6:
            r0 = move-exception
            r25 = r4
            r6 = 0
        L_0x00aa:
            r11 = 0
        L_0x00ab:
            r4 = r0
            goto L_0x025a
        L_0x00ae:
            r6 = 0
            java.lang.String[] r11 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
        L_0x00b3:
            r12 = -1
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x00bc
            java.lang.String r6 = " and rowid <= ?"
            goto L_0x00bd
        L_0x00bc:
            r6 = r4
        L_0x00bd:
            int r12 = r6.length()     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            int r12 = r12 + 84
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            r13.<init>(r12)     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            java.lang.String r12 = "select metadata_fingerprint from raw_events where app_id = ?"
            r13.append(r12)     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            r13.append(r6)     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            java.lang.String r6 = " order by rowid limit 1;"
            r13.append(r6)     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            java.lang.String r6 = r13.toString()     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            android.database.Cursor r6 = r10.rawQuery(r6, r11)     // Catch:{ SQLiteException -> 0x0254, all -> 0x024e }
            boolean r11 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x0249 }
            if (r11 != 0) goto L_0x00ea
            r6.close()     // Catch:{ all -> 0x1015 }
        L_0x00e6:
            r25 = r4
            goto L_0x0270
        L_0x00ea:
            java.lang.String r12 = r6.getString(r14)     // Catch:{ SQLiteException -> 0x0249 }
            r6.close()     // Catch:{ SQLiteException -> 0x0249 }
            r11 = 0
        L_0x00f2:
            java.lang.String r17 = "raw_events_metadata"
            java.lang.String r13 = "metadata"
            java.lang.String[] r18 = new java.lang.String[]{r13}     // Catch:{ SQLiteException -> 0x0244 }
            java.lang.String r19 = "app_id = ? and metadata_fingerprint = ?"
            r13 = 2
            java.lang.String[] r15 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0244 }
            r15[r14] = r11     // Catch:{ SQLiteException -> 0x0244 }
            r13 = 1
            r15[r13] = r12     // Catch:{ SQLiteException -> 0x0244 }
            r21 = 0
            r22 = 0
            java.lang.String r23 = "rowid"
            java.lang.String r24 = "2"
            r16 = r10
            r20 = r15
            android.database.Cursor r6 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0244 }
            boolean r13 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x0244 }
            if (r13 != 0) goto L_0x012f
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x0244 }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zze()     // Catch:{ SQLiteException -> 0x0244 }
            java.lang.String r9 = "Raw event metadata record is missing. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0244 }
            r8.zza(r9, r10)     // Catch:{ SQLiteException -> 0x0244 }
            r6.close()     // Catch:{ all -> 0x1015 }
            goto L_0x00e6
        L_0x012f:
            byte[] r13 = r6.getBlob(r14)     // Catch:{ SQLiteException -> 0x0244 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r15 = com.google.android.gms.internal.measurement.zzcd.zzg.zzbh()     // Catch:{ IOException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzji r13 = com.google.android.gms.measurement.internal.zzkr.zza(r15, (byte[]) r13)     // Catch:{ IOException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r13     // Catch:{ IOException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzjj r13 = r13.zzy()     // Catch:{ IOException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzhy r13 = (com.google.android.gms.internal.measurement.zzhy) r13     // Catch:{ IOException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzcd$zzg r13 = (com.google.android.gms.internal.measurement.zzcd.zzg) r13     // Catch:{ IOException -> 0x0228 }
            boolean r15 = r6.moveToNext()     // Catch:{ SQLiteException -> 0x0244 }
            if (r15 == 0) goto L_0x015f
            com.google.android.gms.measurement.internal.zzeq r15 = r7.zzq()     // Catch:{ SQLiteException -> 0x0244 }
            com.google.android.gms.measurement.internal.zzes r15 = r15.zzh()     // Catch:{ SQLiteException -> 0x0244 }
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            r25 = r4
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0241 }
            r15.zza(r14, r4)     // Catch:{ SQLiteException -> 0x0241 }
            goto L_0x0161
        L_0x015f:
            r25 = r4
        L_0x0161:
            r6.close()     // Catch:{ SQLiteException -> 0x0241 }
            r5.zza((com.google.android.gms.internal.measurement.zzcd.zzg) r13)     // Catch:{ SQLiteException -> 0x0241 }
            r13 = -1
            int r4 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0184
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0241 }
            r13 = 0
            r14[r13] = r11     // Catch:{ SQLiteException -> 0x0241 }
            r13 = 1
            r14[r13] = r12     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0241 }
            r9 = 2
            r14[r9] = r8     // Catch:{ SQLiteException -> 0x0241 }
            r19 = r4
            r20 = r14
            goto L_0x0193
        L_0x0184:
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            r8 = 2
            java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0241 }
            r8 = 0
            r9[r8] = r11     // Catch:{ SQLiteException -> 0x0241 }
            r8 = 1
            r9[r8] = r12     // Catch:{ SQLiteException -> 0x0241 }
            r19 = r4
            r20 = r9
        L_0x0193:
            java.lang.String r17 = "raw_events"
            java.lang.String r4 = "rowid"
            java.lang.String r8 = "name"
            java.lang.String r9 = "timestamp"
            java.lang.String r12 = "data"
            java.lang.String[] r18 = new java.lang.String[]{r4, r8, r9, r12}     // Catch:{ SQLiteException -> 0x0241 }
            r21 = 0
            r22 = 0
            java.lang.String r23 = "rowid"
            r24 = 0
            r16 = r10
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x0241 }
            boolean r6 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            if (r6 != 0) goto L_0x01cb
            com.google.android.gms.measurement.internal.zzeq r6 = r7.zzq()     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzh()     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r6.zza(r8, r9)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r4.close()     // Catch:{ all -> 0x1015 }
            goto L_0x0270
        L_0x01cb:
            r6 = 0
            long r8 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r6 = 3
            byte[] r10 = r4.getBlob(r6)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r6 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch:{ IOException -> 0x0203 }
            com.google.android.gms.internal.measurement.zzji r6 = com.google.android.gms.measurement.internal.zzkr.zza(r6, (byte[]) r10)     // Catch:{ IOException -> 0x0203 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r6 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r6     // Catch:{ IOException -> 0x0203 }
            r10 = 1
            java.lang.String r12 = r4.getString(r10)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r10 = r6.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r12 = 2
            long r13 = r4.getLong(r12)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r10.zza((long) r13)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            com.google.android.gms.internal.measurement.zzjj r6 = r6.zzy()     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            com.google.android.gms.internal.measurement.zzhy r6 = (com.google.android.gms.internal.measurement.zzhy) r6     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            com.google.android.gms.internal.measurement.zzcd$zzc r6 = (com.google.android.gms.internal.measurement.zzcd.zzc) r6     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            boolean r6 = r5.zza(r8, r6)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            if (r6 != 0) goto L_0x0216
            r4.close()     // Catch:{ all -> 0x1015 }
            goto L_0x0270
        L_0x0203:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zze()     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            java.lang.String r9 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            r8.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
        L_0x0216:
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0224, all -> 0x0220 }
            if (r6 != 0) goto L_0x01cb
            r4.close()     // Catch:{ all -> 0x1015 }
            goto L_0x0270
        L_0x0220:
            r0 = move-exception
            r5 = r1
            r6 = r4
            goto L_0x0251
        L_0x0224:
            r0 = move-exception
            r6 = r4
            goto L_0x00ab
        L_0x0228:
            r0 = move-exception
            r25 = r4
            r4 = r0
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zze()     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r9 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0241 }
            r8.zza(r9, r10, r4)     // Catch:{ SQLiteException -> 0x0241 }
            r6.close()     // Catch:{ all -> 0x1015 }
            goto L_0x0270
        L_0x0241:
            r0 = move-exception
            goto L_0x00ab
        L_0x0244:
            r0 = move-exception
            r25 = r4
            goto L_0x00ab
        L_0x0249:
            r0 = move-exception
            r25 = r4
            r4 = r0
            goto L_0x0259
        L_0x024e:
            r0 = move-exception
            r5 = r1
            r6 = 0
        L_0x0251:
            r1 = r0
            goto L_0x100d
        L_0x0254:
            r0 = move-exception
            r25 = r4
            r4 = r0
            r6 = 0
        L_0x0259:
            r11 = 0
        L_0x025a:
            com.google.android.gms.measurement.internal.zzeq r7 = r7.zzq()     // Catch:{ all -> 0x1009 }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zze()     // Catch:{ all -> 0x1009 }
            java.lang.String r8 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r11)     // Catch:{ all -> 0x1009 }
            r7.zza(r8, r9, r4)     // Catch:{ all -> 0x1009 }
            if (r6 == 0) goto L_0x0270
            r6.close()     // Catch:{ all -> 0x1015 }
        L_0x0270:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r4 = r5.zzc     // Catch:{ all -> 0x1015 }
            if (r4 == 0) goto L_0x027f
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r4 = r5.zzc     // Catch:{ all -> 0x1015 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x1015 }
            if (r4 == 0) goto L_0x027d
            goto L_0x027f
        L_0x027d:
            r4 = 0
            goto L_0x0280
        L_0x027f:
            r4 = 1
        L_0x0280:
            if (r4 != 0) goto L_0x0ff8
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.zza     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r4 = r4.zzbo()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = (com.google.android.gms.internal.measurement.zzcd.zzg.zza) r4     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r4 = r4.zzc()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r6 = r6.zza()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzas.zzat     // Catch:{ all -> 0x1015 }
            boolean r6 = r6.zze(r7, r8)     // Catch:{ all -> 0x1015 }
            r7 = -1
            r8 = -1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x02a9:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r9 = r5.zzc     // Catch:{ all -> 0x1015 }
            int r9 = r9.size()     // Catch:{ all -> 0x1015 }
            r18 = r13
            java.lang.String r13 = "_fr"
            r19 = r2
            java.lang.String r2 = "_et"
            r20 = r14
            java.lang.String r14 = "_e"
            r21 = r6
            r22 = r7
            if (r12 >= r9) goto L_0x0948
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r9 = r5.zzc     // Catch:{ all -> 0x1015 }
            java.lang.Object r9 = r9.get(r12)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r9 = r9.zzbo()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfo r6 = r42.zzc()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1015 }
            r26 = r12
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r6 = r6.zzb(r7, r12)     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = "_err"
            if (r6 == 0) goto L_0x0368
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r12)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r13 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeo r13 = r13.zzi()     // Catch:{ all -> 0x1015 }
            java.lang.String r14 = r9.zzd()     // Catch:{ all -> 0x1015 }
            java.lang.String r13 = r13.zza((java.lang.String) r14)     // Catch:{ all -> 0x1015 }
            r2.zza(r6, r12, r13)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfo r2 = r42.zzc()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.zzg(r6)     // Catch:{ all -> 0x1015 }
            if (r2 != 0) goto L_0x0331
            com.google.android.gms.measurement.internal.zzfo r2 = r42.zzc()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.zzh(r6)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x032f
            goto L_0x0331
        L_0x032f:
            r2 = 0
            goto L_0x0332
        L_0x0331:
            r2 = 1
        L_0x0332:
            if (r2 != 0) goto L_0x035b
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x1015 }
            if (r2 != 0) goto L_0x035b
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzkv r27 = r2.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzky r2 = r1.zzaa     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r29 = r6.zzx()     // Catch:{ all -> 0x1015 }
            r30 = 11
            java.lang.String r31 = "_ev"
            java.lang.String r32 = r9.zzd()     // Catch:{ all -> 0x1015 }
            r33 = 0
            r28 = r2
            r27.zza((com.google.android.gms.measurement.internal.zzky) r28, (java.lang.String) r29, (int) r30, (java.lang.String) r31, (java.lang.String) r32, (int) r33)     // Catch:{ all -> 0x1015 }
        L_0x035b:
            r27 = r15
            r13 = r18
            r14 = r20
            r6 = r26
            r7 = 3
            r16 = r3
            goto L_0x093a
        L_0x0368:
            boolean r6 = com.google.android.gms.internal.measurement.zzlo.zzb()     // Catch:{ all -> 0x1015 }
            if (r6 == 0) goto L_0x03f8
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r6 = r6.zza()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1015 }
            r27 = r15
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzas.zzcl     // Catch:{ all -> 0x1015 }
            boolean r6 = r6.zze(r12, r15)     // Catch:{ all -> 0x1015 }
            if (r6 == 0) goto L_0x03fa
            java.lang.String r6 = r9.zzd()     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = com.google.android.gms.measurement.internal.zzgv.zza(r3)     // Catch:{ all -> 0x1015 }
            boolean r6 = r6.equals(r12)     // Catch:{ all -> 0x1015 }
            if (r6 == 0) goto L_0x03fa
            r9.zza((java.lang.String) r3)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzw()     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = "Renaming ad_impression to _ai"
            r6.zza(r12)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r6 = r6.zzq()     // Catch:{ all -> 0x1015 }
            r12 = 5
            boolean r6 = r6.zza((int) r12)     // Catch:{ all -> 0x1015 }
            if (r6 == 0) goto L_0x03fa
            r6 = 0
        L_0x03b2:
            int r12 = r9.zzb()     // Catch:{ all -> 0x1015 }
            if (r6 >= r12) goto L_0x03fa
            java.lang.String r12 = "ad_platform"
            com.google.android.gms.internal.measurement.zzcd$zze r15 = r9.zza((int) r6)     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = r15.zzb()     // Catch:{ all -> 0x1015 }
            boolean r12 = r12.equals(r15)     // Catch:{ all -> 0x1015 }
            if (r12 == 0) goto L_0x03f5
            com.google.android.gms.internal.measurement.zzcd$zze r12 = r9.zza((int) r6)     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r12.zzd()     // Catch:{ all -> 0x1015 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x1015 }
            if (r12 != 0) goto L_0x03f5
            java.lang.String r12 = "admob"
            com.google.android.gms.internal.measurement.zzcd$zze r15 = r9.zza((int) r6)     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = r15.zzd()     // Catch:{ all -> 0x1015 }
            boolean r12 = r12.equalsIgnoreCase(r15)     // Catch:{ all -> 0x1015 }
            if (r12 == 0) goto L_0x03f5
            com.google.android.gms.measurement.internal.zzfu r12 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r12 = r12.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r12 = r12.zzj()     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = "AdMob ad impression logged from app. Potentially duplicative."
            r12.zza(r15)     // Catch:{ all -> 0x1015 }
        L_0x03f5:
            int r6 = r6 + 1
            goto L_0x03b2
        L_0x03f8:
            r27 = r15
        L_0x03fa:
            com.google.android.gms.measurement.internal.zzfo r6 = r42.zzc()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r6 = r6.zzc(r12, r15)     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = "_c"
            if (r6 != 0) goto L_0x046b
            r42.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x1015 }
            r16 = r3
            int r3 = r15.hashCode()     // Catch:{ all -> 0x1015 }
            r29 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r3 == r10) goto L_0x0446
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r3 == r10) goto L_0x043c
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r3 == r10) goto L_0x0432
            goto L_0x0450
        L_0x0432:
            java.lang.String r3 = "_ui"
            boolean r3 = r15.equals(r3)     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x0450
            r3 = 1
            goto L_0x0451
        L_0x043c:
            java.lang.String r3 = "_ug"
            boolean r3 = r15.equals(r3)     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x0450
            r3 = 2
            goto L_0x0451
        L_0x0446:
            java.lang.String r3 = "_in"
            boolean r3 = r15.equals(r3)     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x0450
            r3 = 0
            goto L_0x0451
        L_0x0450:
            r3 = -1
        L_0x0451:
            if (r3 == 0) goto L_0x045b
            r10 = 1
            if (r3 == r10) goto L_0x045b
            r10 = 2
            if (r3 == r10) goto L_0x045b
            r3 = 0
            goto L_0x045c
        L_0x045b:
            r3 = 1
        L_0x045c:
            if (r3 == 0) goto L_0x045f
            goto L_0x046f
        L_0x045f:
            r30 = r2
            r31 = r4
            r32 = r11
            r10 = r13
            r11 = r14
        L_0x0467:
            r13 = r18
            goto L_0x0652
        L_0x046b:
            r16 = r3
            r29 = r10
        L_0x046f:
            r30 = r2
            r3 = 0
            r10 = 0
            r15 = 0
        L_0x0474:
            int r2 = r9.zzb()     // Catch:{ all -> 0x1015 }
            r31 = r4
            java.lang.String r4 = "_r"
            if (r15 >= r2) goto L_0x04e1
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1015 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x1015 }
            boolean r2 = r12.equals(r2)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r2 = r2.zzbo()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r2     // Catch:{ all -> 0x1015 }
            r3 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r3)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = (com.google.android.gms.internal.measurement.zzcd.zze) r2     // Catch:{ all -> 0x1015 }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzcd.zze) r2)     // Catch:{ all -> 0x1015 }
            r32 = r11
            r3 = 1
            goto L_0x04da
        L_0x04ab:
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1015 }
            java.lang.String r2 = r2.zzb()     // Catch:{ all -> 0x1015 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x04d8
            com.google.android.gms.internal.measurement.zzcd$zze r2 = r9.zza((int) r15)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r2 = r2.zzbo()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r2     // Catch:{ all -> 0x1015 }
            r32 = r11
            r10 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r10)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = (com.google.android.gms.internal.measurement.zzcd.zze) r2     // Catch:{ all -> 0x1015 }
            r9.zza((int) r15, (com.google.android.gms.internal.measurement.zzcd.zze) r2)     // Catch:{ all -> 0x1015 }
            r10 = 1
            goto L_0x04da
        L_0x04d8:
            r32 = r11
        L_0x04da:
            int r15 = r15 + 1
            r4 = r31
            r11 = r32
            goto L_0x0474
        L_0x04e1:
            r32 = r11
            if (r3 != 0) goto L_0x0518
            if (r6 == 0) goto L_0x0518
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzw()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeo r11 = r11.zzi()     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = r9.zzd()     // Catch:{ all -> 0x1015 }
            java.lang.String r11 = r11.zza((java.lang.String) r15)     // Catch:{ all -> 0x1015 }
            r2.zza(r3, r11)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = com.google.android.gms.internal.measurement.zzcd.zze.zzm()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((java.lang.String) r12)     // Catch:{ all -> 0x1015 }
            r3 = r13
            r11 = r14
            r13 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r13)     // Catch:{ all -> 0x1015 }
            r9.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r2)     // Catch:{ all -> 0x1015 }
            goto L_0x051a
        L_0x0518:
            r3 = r13
            r11 = r14
        L_0x051a:
            if (r10 != 0) goto L_0x054a
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzw()     // Catch:{ all -> 0x1015 }
            java.lang.String r10 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfu r13 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeo r13 = r13.zzi()     // Catch:{ all -> 0x1015 }
            java.lang.String r14 = r9.zzd()     // Catch:{ all -> 0x1015 }
            java.lang.String r13 = r13.zza((java.lang.String) r14)     // Catch:{ all -> 0x1015 }
            r2.zza(r10, r13)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = com.google.android.gms.internal.measurement.zzcd.zze.zzm()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((java.lang.String) r4)     // Catch:{ all -> 0x1015 }
            r13 = 1
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = r2.zza((long) r13)     // Catch:{ all -> 0x1015 }
            r9.zza((com.google.android.gms.internal.measurement.zzcd.zze.zza) r2)     // Catch:{ all -> 0x1015 }
        L_0x054a:
            com.google.android.gms.measurement.internal.zzaf r33 = r42.zze()     // Catch:{ all -> 0x1015 }
            long r34 = r42.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r2 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r36 = r2.zzx()     // Catch:{ all -> 0x1015 }
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 1
            com.google.android.gms.measurement.internal.zzae r2 = r33.zza(r34, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x1015 }
            long r13 = r2.zze     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r10 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x1015 }
            int r2 = r2.zzc(r10)     // Catch:{ all -> 0x1015 }
            r10 = r3
            long r2 = (long) r2     // Catch:{ all -> 0x1015 }
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 <= 0) goto L_0x0582
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (java.lang.String) r4)     // Catch:{ all -> 0x1015 }
            goto L_0x0584
        L_0x0582:
            r18 = 1
        L_0x0584:
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zza((java.lang.String) r2)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x0467
            if (r6 == 0) goto L_0x0467
            com.google.android.gms.measurement.internal.zzaf r33 = r42.zze()     // Catch:{ all -> 0x1015 }
            long r34 = r42.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r2 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r36 = r2.zzx()     // Catch:{ all -> 0x1015 }
            r37 = 0
            r38 = 0
            r39 = 1
            r40 = 0
            r41 = 0
            com.google.android.gms.measurement.internal.zzae r2 = r33.zza(r34, r36, r37, r38, r39, r40, r41)     // Catch:{ all -> 0x1015 }
            long r2 = r2.zzc     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r4 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r4 = r4.zza()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r13 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r13 = r13.zzx()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzas.zzm     // Catch:{ all -> 0x1015 }
            int r4 = r4.zzb(r13, r14)     // Catch:{ all -> 0x1015 }
            long r13 = (long) r4     // Catch:{ all -> 0x1015 }
            int r4 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0467
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r4)     // Catch:{ all -> 0x1015 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x1015 }
            r2 = -1
            r3 = 0
            r4 = 0
            r13 = 0
        L_0x05e2:
            int r14 = r9.zzb()     // Catch:{ all -> 0x1015 }
            if (r13 >= r14) goto L_0x060d
            com.google.android.gms.internal.measurement.zzcd$zze r14 = r9.zza((int) r13)     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = r14.zzb()     // Catch:{ all -> 0x1015 }
            boolean r15 = r12.equals(r15)     // Catch:{ all -> 0x1015 }
            if (r15 == 0) goto L_0x05ff
            com.google.android.gms.internal.measurement.zzhy$zzb r2 = r14.zzbo()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r2     // Catch:{ all -> 0x1015 }
            r3 = r2
            r2 = r13
            goto L_0x060a
        L_0x05ff:
            java.lang.String r14 = r14.zzb()     // Catch:{ all -> 0x1015 }
            boolean r14 = r7.equals(r14)     // Catch:{ all -> 0x1015 }
            if (r14 == 0) goto L_0x060a
            r4 = 1
        L_0x060a:
            int r13 = r13 + 1
            goto L_0x05e2
        L_0x060d:
            if (r4 == 0) goto L_0x0616
            if (r3 == 0) goto L_0x0616
            r9.zzb((int) r2)     // Catch:{ all -> 0x1015 }
            goto L_0x0467
        L_0x0616:
            if (r3 == 0) goto L_0x0637
            java.lang.Object r3 = r3.clone()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r3 = (com.google.android.gms.internal.measurement.zzhy.zzb) r3     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r3 = (com.google.android.gms.internal.measurement.zzcd.zze.zza) r3     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze$zza r3 = r3.zza((java.lang.String) r7)     // Catch:{ all -> 0x1015 }
            r13 = 10
            com.google.android.gms.internal.measurement.zzcd$zze$zza r3 = r3.zza((long) r13)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r3 = (com.google.android.gms.internal.measurement.zzhy) r3     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ all -> 0x1015 }
            r9.zza((int) r2, (com.google.android.gms.internal.measurement.zzcd.zze) r3)     // Catch:{ all -> 0x1015 }
            goto L_0x0467
        L_0x0637:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r4)     // Catch:{ all -> 0x1015 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x1015 }
            goto L_0x0467
        L_0x0652:
            if (r6 == 0) goto L_0x0715
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x1015 }
            java.util.List r3 = r9.zza()     // Catch:{ all -> 0x1015 }
            r2.<init>(r3)     // Catch:{ all -> 0x1015 }
            r3 = 0
            r4 = -1
            r6 = -1
        L_0x0660:
            int r7 = r2.size()     // Catch:{ all -> 0x1015 }
            java.lang.String r14 = "currency"
            java.lang.String r15 = "value"
            if (r3 >= r7) goto L_0x0690
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = (com.google.android.gms.internal.measurement.zzcd.zze) r7     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x1015 }
            boolean r7 = r15.equals(r7)     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x067c
            r4 = r3
            goto L_0x068d
        L_0x067c:
            java.lang.Object r7 = r2.get(r3)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = (com.google.android.gms.internal.measurement.zzcd.zze) r7     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x1015 }
            boolean r7 = r14.equals(r7)     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x068d
            r6 = r3
        L_0x068d:
            int r3 = r3 + 1
            goto L_0x0660
        L_0x0690:
            r3 = -1
            if (r4 == r3) goto L_0x0716
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ all -> 0x1015 }
            boolean r3 = r3.zze()     // Catch:{ all -> 0x1015 }
            if (r3 != 0) goto L_0x06c6
            java.lang.Object r3 = r2.get(r4)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch:{ all -> 0x1015 }
            boolean r3 = r3.zzi()     // Catch:{ all -> 0x1015 }
            if (r3 != 0) goto L_0x06c6
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzj()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "Value must be specified with a numeric type."
            r2.zza(r3)     // Catch:{ all -> 0x1015 }
            r9.zzb((int) r4)     // Catch:{ all -> 0x1015 }
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x1015 }
            r2 = 18
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (int) r2, (java.lang.String) r15)     // Catch:{ all -> 0x1015 }
            goto L_0x0715
        L_0x06c6:
            r3 = -1
            if (r6 != r3) goto L_0x06cc
            r2 = 1
            r7 = 3
            goto L_0x06f8
        L_0x06cc:
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = (com.google.android.gms.internal.measurement.zzcd.zze) r2     // Catch:{ all -> 0x1015 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x1015 }
            int r6 = r2.length()     // Catch:{ all -> 0x1015 }
            r7 = 3
            if (r6 == r7) goto L_0x06df
        L_0x06dd:
            r2 = 1
            goto L_0x06f8
        L_0x06df:
            r6 = 0
        L_0x06e0:
            int r15 = r2.length()     // Catch:{ all -> 0x1015 }
            if (r6 >= r15) goto L_0x06f7
            int r15 = r2.codePointAt(r6)     // Catch:{ all -> 0x1015 }
            boolean r17 = java.lang.Character.isLetter(r15)     // Catch:{ all -> 0x1015 }
            if (r17 != 0) goto L_0x06f1
            goto L_0x06dd
        L_0x06f1:
            int r15 = java.lang.Character.charCount(r15)     // Catch:{ all -> 0x1015 }
            int r6 = r6 + r15
            goto L_0x06e0
        L_0x06f7:
            r2 = 0
        L_0x06f8:
            if (r2 == 0) goto L_0x0717
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzj()     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r6)     // Catch:{ all -> 0x1015 }
            r9.zzb((int) r4)     // Catch:{ all -> 0x1015 }
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (java.lang.String) r12)     // Catch:{ all -> 0x1015 }
            r2 = 19
            zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (int) r2, (java.lang.String) r14)     // Catch:{ all -> 0x1015 }
            goto L_0x0717
        L_0x0715:
            r3 = -1
        L_0x0716:
            r7 = 3
        L_0x0717:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzas     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.zze(r4, r6)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x08b9
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x0788
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r2, (java.lang.String) r10)     // Catch:{ all -> 0x1015 }
            if (r2 != 0) goto L_0x0783
            if (r32 == 0) goto L_0x0779
            long r14 = r32.zzf()     // Catch:{ all -> 0x1015 }
            long r17 = r9.zzf()     // Catch:{ all -> 0x1015 }
            long r14 = r14 - r17
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1015 }
            r17 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r2 > 0) goto L_0x0779
            java.lang.Object r2 = r32.clone()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r2 = (com.google.android.gms.internal.measurement.zzhy.zzb) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ all -> 0x1015 }
            boolean r4 = r1.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x1015 }
            if (r4 == 0) goto L_0x0779
            r4 = r31
            r4.zza((int) r8, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x1015 }
            r10 = r22
            r6 = r30
        L_0x0773:
            r29 = 0
            r32 = 0
            goto L_0x08bf
        L_0x0779:
            r4 = r31
            r29 = r9
            r10 = r20
        L_0x077f:
            r6 = r30
            goto L_0x08bf
        L_0x0783:
            r4 = r31
            r10 = r22
            goto L_0x077f
        L_0x0788:
            r4 = r31
            java.lang.String r2 = "_vs"
            java.lang.String r6 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x07df
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1015 }
            r6 = r30
            com.google.android.gms.internal.measurement.zzcd$zze r2 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r2, (java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            if (r2 != 0) goto L_0x07db
            if (r29 == 0) goto L_0x07d3
            long r14 = r29.zzf()     // Catch:{ all -> 0x1015 }
            long r17 = r9.zzf()     // Catch:{ all -> 0x1015 }
            long r14 = r14 - r17
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1015 }
            r17 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r2 > 0) goto L_0x07d3
            java.lang.Object r2 = r29.clone()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r2 = (com.google.android.gms.internal.measurement.zzhy.zzb) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ all -> 0x1015 }
            boolean r10 = r1.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9)     // Catch:{ all -> 0x1015 }
            if (r10 == 0) goto L_0x07d3
            r10 = r22
            r4.zza((int) r10, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x1015 }
            goto L_0x0773
        L_0x07d3:
            r10 = r22
            r32 = r9
            r8 = r20
            goto L_0x08bf
        L_0x07db:
            r10 = r22
            goto L_0x08bf
        L_0x07df:
            r10 = r22
            r6 = r30
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzas.zzbl     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.zze(r12, r14)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x08bf
            java.lang.String r2 = "_ab"
            java.lang.String r12 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x08bf
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r2 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r2, (java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            if (r2 != 0) goto L_0x08bf
            if (r29 == 0) goto L_0x08bf
            long r14 = r29.zzf()     // Catch:{ all -> 0x1015 }
            long r17 = r9.zzf()     // Catch:{ all -> 0x1015 }
            long r14 = r14 - r17
            long r14 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x1015 }
            r17 = 4000(0xfa0, double:1.9763E-320)
            int r2 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r2 > 0) goto L_0x08bf
            java.lang.Object r2 = r29.clone()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy$zzb r2 = (com.google.android.gms.internal.measurement.zzhy.zzb) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch:{ all -> 0x1015 }
            r1.zzb((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9)     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r2.zzd()     // Catch:{ all -> 0x1015 }
            boolean r12 = r11.equals(r12)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r12)     // Catch:{ all -> 0x1015 }
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r12 = r2.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r12 = (com.google.android.gms.internal.measurement.zzhy) r12     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r12 = (com.google.android.gms.internal.measurement.zzcd.zzc) r12     // Catch:{ all -> 0x1015 }
            java.lang.String r14 = "_sn"
            com.google.android.gms.internal.measurement.zzcd$zze r12 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r12, (java.lang.String) r14)     // Catch:{ all -> 0x1015 }
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r14 = r2.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r14 = (com.google.android.gms.internal.measurement.zzhy) r14     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r14 = (com.google.android.gms.internal.measurement.zzcd.zzc) r14     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = "_sc"
            com.google.android.gms.internal.measurement.zzcd$zze r14 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r14, (java.lang.String) r15)     // Catch:{ all -> 0x1015 }
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r15 = r2.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r15 = (com.google.android.gms.internal.measurement.zzhy) r15     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r15 = (com.google.android.gms.internal.measurement.zzcd.zzc) r15     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "_si"
            com.google.android.gms.internal.measurement.zzcd$zze r3 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r15, (java.lang.String) r3)     // Catch:{ all -> 0x1015 }
            if (r12 == 0) goto L_0x087a
            java.lang.String r12 = r12.zzd()     // Catch:{ all -> 0x1015 }
            goto L_0x087c
        L_0x087a:
            r12 = r25
        L_0x087c:
            boolean r15 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x1015 }
            if (r15 != 0) goto L_0x088a
            r42.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r15 = "_sn"
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (java.lang.String) r15, (java.lang.Object) r12)     // Catch:{ all -> 0x1015 }
        L_0x088a:
            if (r14 == 0) goto L_0x0891
            java.lang.String r12 = r14.zzd()     // Catch:{ all -> 0x1015 }
            goto L_0x0893
        L_0x0891:
            r12 = r25
        L_0x0893:
            boolean r14 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x1015 }
            if (r14 != 0) goto L_0x08a1
            r42.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r14 = "_sc"
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (java.lang.String) r14, (java.lang.Object) r12)     // Catch:{ all -> 0x1015 }
        L_0x08a1:
            if (r3 == 0) goto L_0x08b3
            r42.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = "_si"
            long r14 = r3.zzf()     // Catch:{ all -> 0x1015 }
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9, (java.lang.String) r12, (java.lang.Object) r3)     // Catch:{ all -> 0x1015 }
        L_0x08b3:
            r4.zza((int) r10, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2)     // Catch:{ all -> 0x1015 }
            r29 = 0
            goto L_0x08bf
        L_0x08b9:
            r10 = r22
            r6 = r30
            r4 = r31
        L_0x08bf:
            if (r21 != 0) goto L_0x0920
            java.lang.String r2 = r9.zzd()     // Catch:{ all -> 0x1015 }
            boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x0920
            int r2 = r9.zzb()     // Catch:{ all -> 0x1015 }
            if (r2 != 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            r2.zza(r3, r6)     // Catch:{ all -> 0x1015 }
            goto L_0x0920
        L_0x08eb:
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r2 = r9.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch:{ all -> 0x1015 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzkr.zzb(r2, r6)     // Catch:{ all -> 0x1015 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x1015 }
            if (r2 != 0) goto L_0x0918
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            r2.zza(r3, r6)     // Catch:{ all -> 0x1015 }
            goto L_0x0920
        L_0x0918:
            long r2 = r2.longValue()     // Catch:{ all -> 0x1015 }
            long r2 = r27 + r2
            r27 = r2
        L_0x0920:
            java.util.List<com.google.android.gms.internal.measurement.zzcd$zzc> r2 = r5.zzc     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r3 = r9.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r3 = (com.google.android.gms.internal.measurement.zzhy) r3     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r3 = (com.google.android.gms.internal.measurement.zzcd.zzc) r3     // Catch:{ all -> 0x1015 }
            r6 = r26
            r2.set(r6, r3)     // Catch:{ all -> 0x1015 }
            int r14 = r20 + 1
            r4.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r9)     // Catch:{ all -> 0x1015 }
            r22 = r10
            r10 = r29
            r11 = r32
        L_0x093a:
            int r12 = r6 + 1
            r3 = r16
            r2 = r19
            r6 = r21
            r7 = r22
            r15 = r27
            goto L_0x02a9
        L_0x0948:
            r6 = r2
            r10 = r13
            r11 = r14
            r27 = r15
            if (r21 == 0) goto L_0x09a4
            r14 = r20
            r15 = r27
            r2 = 0
        L_0x0954:
            if (r2 >= r14) goto L_0x09a2
            com.google.android.gms.internal.measurement.zzcd$zzc r3 = r4.zzb((int) r2)     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = r3.zzc()     // Catch:{ all -> 0x1015 }
            boolean r7 = r11.equals(r7)     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x0975
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r7 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r3, (java.lang.String) r10)     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x0975
            r4.zzc((int) r2)     // Catch:{ all -> 0x1015 }
            int r14 = r14 + -1
            int r2 = r2 + -1
            goto L_0x099f
        L_0x0975:
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r3 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc) r3, (java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x099f
            boolean r7 = r3.zze()     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x098d
            long r7 = r3.zzf()     // Catch:{ all -> 0x1015 }
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x1015 }
            goto L_0x098e
        L_0x098d:
            r3 = 0
        L_0x098e:
            if (r3 == 0) goto L_0x099f
            long r7 = r3.longValue()     // Catch:{ all -> 0x1015 }
            r12 = 0
            int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r9 <= 0) goto L_0x099f
            long r7 = r3.longValue()     // Catch:{ all -> 0x1015 }
            long r15 = r15 + r7
        L_0x099f:
            r3 = 1
            int r2 = r2 + r3
            goto L_0x0954
        L_0x09a2:
            r2 = r15
            goto L_0x09a6
        L_0x09a4:
            r2 = r27
        L_0x09a6:
            r6 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r4, (long) r2, (boolean) r6)     // Catch:{ all -> 0x1015 }
            java.util.List r6 = r4.zza()     // Catch:{ all -> 0x1015 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x1015 }
        L_0x09b2:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x09cc
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r7 = (com.google.android.gms.internal.measurement.zzcd.zzc) r7     // Catch:{ all -> 0x1015 }
            java.lang.String r8 = "_s"
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x1015 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x09b2
            r6 = 1
            goto L_0x09cd
        L_0x09cc:
            r6 = 0
        L_0x09cd:
            java.lang.String r7 = "_se"
            if (r6 == 0) goto L_0x09dc
            com.google.android.gms.measurement.internal.zzaf r6 = r42.zze()     // Catch:{ all -> 0x1015 }
            java.lang.String r8 = r4.zzj()     // Catch:{ all -> 0x1015 }
            r6.zzb((java.lang.String) r8, (java.lang.String) r7)     // Catch:{ all -> 0x1015 }
        L_0x09dc:
            java.lang.String r6 = "_sid"
            int r6 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r4, (java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            if (r6 < 0) goto L_0x09e6
            r6 = 1
            goto L_0x09e7
        L_0x09e6:
            r6 = 0
        L_0x09e7:
            if (r6 == 0) goto L_0x09ee
            r6 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r4, (long) r2, (boolean) r6)     // Catch:{ all -> 0x1015 }
            goto L_0x0a10
        L_0x09ee:
            int r2 = com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzg.zza) r4, (java.lang.String) r7)     // Catch:{ all -> 0x1015 }
            if (r2 < 0) goto L_0x0a10
            r4.zze((int) r2)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r2 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            r2.zza(r3, r6)     // Catch:{ all -> 0x1015 }
        L_0x0a10:
            com.google.android.gms.measurement.internal.zzkr r2 = r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r3 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzw()     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r3.zza(r6)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfo r3 = r2.zzj()     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = r4.zzj()     // Catch:{ all -> 0x1015 }
            boolean r3 = r3.zze(r6)     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x0aa1
            com.google.android.gms.measurement.internal.zzaf r3 = r2.zzi()     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = r4.zzj()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzf r3 = r3.zzb(r6)     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x0aa1
            boolean r3 = r3.zzaf()     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x0aa1
            com.google.android.gms.measurement.internal.zzak r3 = r2.zzk()     // Catch:{ all -> 0x1015 }
            boolean r3 = r3.zzi()     // Catch:{ all -> 0x1015 }
            if (r3 == 0) goto L_0x0aa1
            com.google.android.gms.measurement.internal.zzeq r3 = r2.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzv()     // Catch:{ all -> 0x1015 }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r3.zza(r6)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r3 = com.google.android.gms.internal.measurement.zzcd.zzk.zzj()     // Catch:{ all -> 0x1015 }
            r6 = r19
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r3 = r3.zza((java.lang.String) r6)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzak r2 = r2.zzk()     // Catch:{ all -> 0x1015 }
            long r7 = r2.zzg()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r2 = r3.zza((long) r7)     // Catch:{ all -> 0x1015 }
            r7 = 1
            com.google.android.gms.internal.measurement.zzcd$zzk$zza r2 = r2.zzb((long) r7)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzk r2 = (com.google.android.gms.internal.measurement.zzcd.zzk) r2     // Catch:{ all -> 0x1015 }
            r3 = 0
        L_0x0a7f:
            int r7 = r4.zze()     // Catch:{ all -> 0x1015 }
            if (r3 >= r7) goto L_0x0a9b
            com.google.android.gms.internal.measurement.zzcd$zzk r7 = r4.zzd((int) r3)     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x1015 }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x1015 }
            if (r7 == 0) goto L_0x0a98
            r4.zza((int) r3, (com.google.android.gms.internal.measurement.zzcd.zzk) r2)     // Catch:{ all -> 0x1015 }
            r3 = 1
            goto L_0x0a9c
        L_0x0a98:
            int r3 = r3 + 1
            goto L_0x0a7f
        L_0x0a9b:
            r3 = 0
        L_0x0a9c:
            if (r3 != 0) goto L_0x0aa1
            r4.zza((com.google.android.gms.internal.measurement.zzcd.zzk) r2)     // Catch:{ all -> 0x1015 }
        L_0x0aa1:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r4.zzb((long) r2)     // Catch:{ all -> 0x1015 }
            r6 = -9223372036854775808
            r2.zzc((long) r6)     // Catch:{ all -> 0x1015 }
            r2 = 0
        L_0x0ab0:
            int r3 = r4.zzb()     // Catch:{ all -> 0x1015 }
            if (r2 >= r3) goto L_0x0ae3
            com.google.android.gms.internal.measurement.zzcd$zzc r3 = r4.zzb((int) r2)     // Catch:{ all -> 0x1015 }
            long r6 = r3.zze()     // Catch:{ all -> 0x1015 }
            long r8 = r4.zzf()     // Catch:{ all -> 0x1015 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0acd
            long r6 = r3.zze()     // Catch:{ all -> 0x1015 }
            r4.zzb((long) r6)     // Catch:{ all -> 0x1015 }
        L_0x0acd:
            long r6 = r3.zze()     // Catch:{ all -> 0x1015 }
            long r8 = r4.zzg()     // Catch:{ all -> 0x1015 }
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0ae0
            long r6 = r3.zze()     // Catch:{ all -> 0x1015 }
            r4.zzc((long) r6)     // Catch:{ all -> 0x1015 }
        L_0x0ae0:
            int r2 = r2 + 1
            goto L_0x0ab0
        L_0x0ae3:
            boolean r2 = com.google.android.gms.internal.measurement.zzoz.zzb()     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x0afe
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = r4.zzj()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzas.zzcf     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.zze(r3, r6)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x0afe
            r4.zzq()     // Catch:{ all -> 0x1015 }
        L_0x0afe:
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r2 = r4.zzp()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzr r6 = r42.zzf()     // Catch:{ all -> 0x1015 }
            java.lang.String r7 = r4.zzj()     // Catch:{ all -> 0x1015 }
            java.util.List r8 = r4.zza()     // Catch:{ all -> 0x1015 }
            java.util.List r9 = r4.zzd()     // Catch:{ all -> 0x1015 }
            long r10 = r4.zzf()     // Catch:{ all -> 0x1015 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x1015 }
            long r11 = r4.zzg()     // Catch:{ all -> 0x1015 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x1015 }
            java.util.List r3 = r6.zza(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x1015 }
            r2.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zza>) r3)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x1015 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x1015 }
            if (r2 == 0) goto L_0x0e68
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0ff4 }
            r2.<init>()     // Catch:{ all -> 0x0ff4 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0ff4 }
            r3.<init>()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzfu r6 = r1.zzk     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzkv r6 = r6.zzh()     // Catch:{ all -> 0x0ff4 }
            java.security.SecureRandom r6 = r6.zzg()     // Catch:{ all -> 0x0ff4 }
            r7 = 0
        L_0x0b50:
            int r8 = r4.zzb()     // Catch:{ all -> 0x0ff4 }
            if (r7 >= r8) goto L_0x0e2f
            com.google.android.gms.internal.measurement.zzcd$zzc r8 = r4.zzb((int) r7)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzhy$zzb r8 = r8.zzbo()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8     // Catch:{ all -> 0x0ff4 }
            java.lang.String r9 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0ff4 }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0be2
            r42.zzh()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1015 }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzkr.zzb(r9, r11)     // Catch:{ all -> 0x1015 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x1015 }
            java.lang.Object r11 = r2.get(r9)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzam r11 = (com.google.android.gms.measurement.internal.zzam) r11     // Catch:{ all -> 0x1015 }
            if (r11 != 0) goto L_0x0b9a
            com.google.android.gms.measurement.internal.zzaf r11 = r42.zze()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza((java.lang.String) r12, (java.lang.String) r9)     // Catch:{ all -> 0x1015 }
            r2.put(r9, r11)     // Catch:{ all -> 0x1015 }
        L_0x0b9a:
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x1015 }
            if (r9 != 0) goto L_0x0bd7
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x1015 }
            long r12 = r9.longValue()     // Catch:{ all -> 0x1015 }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0bb2
            r42.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ all -> 0x1015 }
        L_0x0bb2:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x1015 }
            if (r9 == 0) goto L_0x0bcc
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x1015 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x1015 }
            if (r9 == 0) goto L_0x0bcc
            r42.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r9, (java.lang.Object) r12)     // Catch:{ all -> 0x1015 }
        L_0x0bcc:
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1015 }
            r3.add(r9)     // Catch:{ all -> 0x1015 }
        L_0x0bd7:
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1015 }
        L_0x0bda:
            r9 = r2
            r43 = r5
            r15 = r6
            r5 = 1
            goto L_0x0e25
        L_0x0be2:
            com.google.android.gms.measurement.internal.zzfo r9 = r42.zzc()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzg r11 = r5.zza     // Catch:{ all -> 0x0ff4 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0ff4 }
            long r11 = r9.zzf(r11)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzfu r9 = r1.zzk     // Catch:{ all -> 0x0ff4 }
            r9.zzh()     // Catch:{ all -> 0x0ff4 }
            long r13 = r8.zzf()     // Catch:{ all -> 0x0ff4 }
            long r13 = com.google.android.gms.measurement.internal.zzkv.zza((long) r13, (long) r11)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzy()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x0ff4 }
            java.lang.String r15 = "_dbg"
            r19 = r11
            r16 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0ff4 }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0ff4 }
            if (r12 != 0) goto L_0x0c6b
            if (r11 != 0) goto L_0x0c18
            goto L_0x0c6b
        L_0x0c18:
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x1015 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x1015 }
        L_0x0c20:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x1015 }
            if (r12 == 0) goto L_0x0c6b
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zze r12 = (com.google.android.gms.internal.measurement.zzcd.zze) r12     // Catch:{ all -> 0x1015 }
            r43 = r9
            java.lang.String r9 = r12.zzb()     // Catch:{ all -> 0x1015 }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x1015 }
            if (r9 == 0) goto L_0x0c68
            long r15 = r12.zzf()     // Catch:{ all -> 0x1015 }
            java.lang.Long r9 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x1015 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x1015 }
            if (r9 != 0) goto L_0x0c66
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x1015 }
            if (r9 == 0) goto L_0x0c54
            java.lang.String r9 = r12.zzd()     // Catch:{ all -> 0x1015 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x1015 }
            if (r9 != 0) goto L_0x0c66
        L_0x0c54:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x1015 }
            if (r9 == 0) goto L_0x0c6b
            double r15 = r12.zzj()     // Catch:{ all -> 0x1015 }
            java.lang.Double r9 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x1015 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x1015 }
            if (r9 == 0) goto L_0x0c6b
        L_0x0c66:
            r9 = 1
            goto L_0x0c6c
        L_0x0c68:
            r9 = r43
            goto L_0x0c20
        L_0x0c6b:
            r9 = 0
        L_0x0c6c:
            if (r9 != 0) goto L_0x0c81
            com.google.android.gms.measurement.internal.zzfo r9 = r42.zzc()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzg r11 = r5.zza     // Catch:{ all -> 0x1015 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x1015 }
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x1015 }
            int r9 = r9.zzd(r11, r12)     // Catch:{ all -> 0x1015 }
            goto L_0x0c82
        L_0x0c81:
            r9 = 1
        L_0x0c82:
            if (r9 > 0) goto L_0x0cab
            com.google.android.gms.measurement.internal.zzfu r10 = r1.zzk     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzeq r10 = r10.zzq()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzh()     // Catch:{ all -> 0x1015 }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r8.zzd()     // Catch:{ all -> 0x1015 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x1015 }
            r10.zza(r11, r12, r9)     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzy()     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x1015 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x1015 }
            r3.add(r9)     // Catch:{ all -> 0x1015 }
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x1015 }
            goto L_0x0bda
        L_0x0cab:
            java.lang.String r11 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzam r11 = (com.google.android.gms.measurement.internal.zzam) r11     // Catch:{ all -> 0x0ff4 }
            if (r11 != 0) goto L_0x0d09
            com.google.android.gms.measurement.internal.zzaf r11 = r42.zze()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzg r12 = r5.zza     // Catch:{ all -> 0x0ff4 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0ff4 }
            java.lang.String r15 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza((java.lang.String) r12, (java.lang.String) r15)     // Catch:{ all -> 0x0ff4 }
            if (r11 != 0) goto L_0x0d09
            com.google.android.gms.measurement.internal.zzfu r11 = r1.zzk     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzeq r11 = r11.zzq()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzes r11 = r11.zzh()     // Catch:{ all -> 0x0ff4 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzcd$zzg r15 = r5.zza     // Catch:{ all -> 0x0ff4 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0ff4 }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            r11.zza(r12, r15, r1)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzam r11 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzg r1 = r5.zza     // Catch:{ all -> 0x0ff4 }
            java.lang.String r26 = r1.zzx()     // Catch:{ all -> 0x0ff4 }
            java.lang.String r27 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            r28 = 1
            r30 = 1
            r32 = 1
            long r34 = r8.zzf()     // Catch:{ all -> 0x0ff4 }
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r25 = r11
            r25.<init>(r26, r27, r28, r30, r32, r34, r36, r38, r39, r40, r41)     // Catch:{ all -> 0x0ff4 }
        L_0x0d09:
            r42.zzh()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzy()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1     // Catch:{ all -> 0x0ff4 }
            java.lang.String r12 = "_eid"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzkr.zzb(r1, r12)     // Catch:{ all -> 0x0ff4 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0ff4 }
            if (r1 == 0) goto L_0x0d20
            r12 = 1
            goto L_0x0d21
        L_0x0d20:
            r12 = 0
        L_0x0d21:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0ff4 }
            r15 = 1
            if (r9 != r15) goto L_0x0d56
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzy()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1     // Catch:{ all -> 0x0ff4 }
            r3.add(r1)     // Catch:{ all -> 0x0ff4 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0ff4 }
            if (r1 == 0) goto L_0x0d51
            java.lang.Long r1 = r11.zzi     // Catch:{ all -> 0x0ff4 }
            if (r1 != 0) goto L_0x0d45
            java.lang.Long r1 = r11.zzj     // Catch:{ all -> 0x0ff4 }
            if (r1 != 0) goto L_0x0d45
            java.lang.Boolean r1 = r11.zzk     // Catch:{ all -> 0x0ff4 }
            if (r1 == 0) goto L_0x0d51
        L_0x0d45:
            r1 = 0
            com.google.android.gms.measurement.internal.zzam r9 = r11.zza(r1, r1, r1)     // Catch:{ all -> 0x0ff4 }
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            r2.put(r1, r9)     // Catch:{ all -> 0x0ff4 }
        L_0x0d51:
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x0ff4 }
            goto L_0x0bda
        L_0x0d56:
            int r15 = r6.nextInt(r9)     // Catch:{ all -> 0x0ff4 }
            if (r15 != 0) goto L_0x0d98
            r42.zzh()     // Catch:{ all -> 0x0ff4 }
            r43 = r5
            r15 = r6
            long r5 = (long) r9     // Catch:{ all -> 0x0ff4 }
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r1)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzjj r1 = r8.zzy()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzc r1 = (com.google.android.gms.internal.measurement.zzcd.zzc) r1     // Catch:{ all -> 0x0ff4 }
            r3.add(r1)     // Catch:{ all -> 0x0ff4 }
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0ff4 }
            if (r1 == 0) goto L_0x0d84
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ff4 }
            r5 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza(r5, r1, r5)     // Catch:{ all -> 0x0ff4 }
        L_0x0d84:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            long r5 = r8.zzf()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzam r5 = r11.zza(r5, r13)     // Catch:{ all -> 0x0ff4 }
            r2.put(r1, r5)     // Catch:{ all -> 0x0ff4 }
            r9 = r2
            r5 = 1
            goto L_0x0e22
        L_0x0d98:
            r43 = r5
            r15 = r6
            java.lang.Long r5 = r11.zzh     // Catch:{ all -> 0x0ff4 }
            if (r5 == 0) goto L_0x0daa
            java.lang.Long r5 = r11.zzh     // Catch:{ all -> 0x0ff4 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0ff4 }
            r17 = r1
            r16 = r2
            goto L_0x0dbf
        L_0x0daa:
            r5 = r42
            com.google.android.gms.measurement.internal.zzfu r6 = r5.zzk     // Catch:{ all -> 0x0ff4 }
            r6.zzh()     // Catch:{ all -> 0x0ff4 }
            long r5 = r8.zzg()     // Catch:{ all -> 0x0ff4 }
            r17 = r1
            r16 = r2
            r1 = r19
            long r5 = com.google.android.gms.measurement.internal.zzkv.zza((long) r5, (long) r1)     // Catch:{ all -> 0x0ff4 }
        L_0x0dbf:
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x0e0a
            r42.zzh()     // Catch:{ all -> 0x0ff4 }
            java.lang.String r1 = "_efs"
            r5 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0ff4 }
            r42.zzh()     // Catch:{ all -> 0x0ff4 }
            long r1 = (long) r9     // Catch:{ all -> 0x0ff4 }
            java.lang.Long r9 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzkr.zza((com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8, (java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzjj r9 = r8.zzy()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzhy r9 = (com.google.android.gms.internal.measurement.zzhy) r9     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.internal.measurement.zzcd$zzc r9 = (com.google.android.gms.internal.measurement.zzcd.zzc) r9     // Catch:{ all -> 0x0ff4 }
            r3.add(r9)     // Catch:{ all -> 0x0ff4 }
            boolean r9 = r12.booleanValue()     // Catch:{ all -> 0x0ff4 }
            if (r9 == 0) goto L_0x0df8
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ff4 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0ff4 }
            r9 = 0
            com.google.android.gms.measurement.internal.zzam r11 = r11.zza(r9, r1, r2)     // Catch:{ all -> 0x0ff4 }
        L_0x0df8:
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            long r9 = r8.zzf()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzam r2 = r11.zza(r9, r13)     // Catch:{ all -> 0x0ff4 }
            r9 = r16
            r9.put(r1, r2)     // Catch:{ all -> 0x0ff4 }
            goto L_0x0e22
        L_0x0e0a:
            r9 = r16
            r5 = 1
            boolean r1 = r12.booleanValue()     // Catch:{ all -> 0x0ff4 }
            if (r1 == 0) goto L_0x0e22
            java.lang.String r1 = r8.zzd()     // Catch:{ all -> 0x0ff4 }
            r2 = r17
            r10 = 0
            com.google.android.gms.measurement.internal.zzam r2 = r11.zza(r2, r10, r10)     // Catch:{ all -> 0x0ff4 }
            r9.put(r1, r2)     // Catch:{ all -> 0x0ff4 }
        L_0x0e22:
            r4.zza((int) r7, (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r8)     // Catch:{ all -> 0x0ff4 }
        L_0x0e25:
            int r7 = r7 + 1
            r1 = r42
            r5 = r43
            r2 = r9
            r6 = r15
            goto L_0x0b50
        L_0x0e2f:
            r9 = r2
            r43 = r5
            int r1 = r3.size()     // Catch:{ all -> 0x0ff4 }
            int r2 = r4.zzb()     // Catch:{ all -> 0x0ff4 }
            if (r1 >= r2) goto L_0x0e43
            com.google.android.gms.internal.measurement.zzcd$zzg$zza r1 = r4.zzc()     // Catch:{ all -> 0x0ff4 }
            r1.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzcd.zzc>) r3)     // Catch:{ all -> 0x0ff4 }
        L_0x0e43:
            java.util.Set r1 = r9.entrySet()     // Catch:{ all -> 0x0ff4 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0ff4 }
        L_0x0e4b:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0ff4 }
            if (r2 == 0) goto L_0x0e65
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0ff4 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzaf r3 = r42.zze()     // Catch:{ all -> 0x0ff4 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzam r2 = (com.google.android.gms.measurement.internal.zzam) r2     // Catch:{ all -> 0x0ff4 }
            r3.zza((com.google.android.gms.measurement.internal.zzam) r2)     // Catch:{ all -> 0x0ff4 }
            goto L_0x0e4b
        L_0x0e65:
            r1 = r43
            goto L_0x0e69
        L_0x0e68:
            r1 = r5
        L_0x0e69:
            com.google.android.gms.internal.measurement.zzcd$zzg r2 = r1.zza     // Catch:{ all -> 0x0ff4 }
            java.lang.String r2 = r2.zzx()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzaf r3 = r42.zze()     // Catch:{ all -> 0x0ff4 }
            com.google.android.gms.measurement.internal.zzf r3 = r3.zzb(r2)     // Catch:{ all -> 0x0ff4 }
            if (r3 != 0) goto L_0x0e95
            r5 = r42
            com.google.android.gms.measurement.internal.zzfu r3 = r5.zzk     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x1013 }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r1.zza     // Catch:{ all -> 0x1013 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1013 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r7)     // Catch:{ all -> 0x1013 }
            r3.zza(r6, r7)     // Catch:{ all -> 0x1013 }
            goto L_0x0ef2
        L_0x0e95:
            r5 = r42
            int r6 = r4.zzb()     // Catch:{ all -> 0x1013 }
            if (r6 <= 0) goto L_0x0ef2
            long r6 = r3.zzk()     // Catch:{ all -> 0x1013 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0eab
            r4.zze((long) r6)     // Catch:{ all -> 0x1013 }
            goto L_0x0eae
        L_0x0eab:
            r4.zzi()     // Catch:{ all -> 0x1013 }
        L_0x0eae:
            long r8 = r3.zzj()     // Catch:{ all -> 0x1013 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0eb9
            goto L_0x0eba
        L_0x0eb9:
            r6 = r8
        L_0x0eba:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0ec2
            r4.zzd((long) r6)     // Catch:{ all -> 0x1013 }
            goto L_0x0ec5
        L_0x0ec2:
            r4.zzh()     // Catch:{ all -> 0x1013 }
        L_0x0ec5:
            r3.zzv()     // Catch:{ all -> 0x1013 }
            long r6 = r3.zzs()     // Catch:{ all -> 0x1013 }
            int r7 = (int) r6     // Catch:{ all -> 0x1013 }
            r4.zzg((int) r7)     // Catch:{ all -> 0x1013 }
            long r6 = r4.zzf()     // Catch:{ all -> 0x1013 }
            r3.zza((long) r6)     // Catch:{ all -> 0x1013 }
            long r6 = r4.zzg()     // Catch:{ all -> 0x1013 }
            r3.zzb((long) r6)     // Catch:{ all -> 0x1013 }
            java.lang.String r6 = r3.zzad()     // Catch:{ all -> 0x1013 }
            if (r6 == 0) goto L_0x0ee8
            r4.zzj((java.lang.String) r6)     // Catch:{ all -> 0x1013 }
            goto L_0x0eeb
        L_0x0ee8:
            r4.zzn()     // Catch:{ all -> 0x1013 }
        L_0x0eeb:
            com.google.android.gms.measurement.internal.zzaf r6 = r42.zze()     // Catch:{ all -> 0x1013 }
            r6.zza((com.google.android.gms.measurement.internal.zzf) r3)     // Catch:{ all -> 0x1013 }
        L_0x0ef2:
            int r3 = r4.zzb()     // Catch:{ all -> 0x1013 }
            if (r3 <= 0) goto L_0x0f53
            com.google.android.gms.measurement.internal.zzfo r3 = r42.zzc()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.internal.measurement.zzcd$zzg r6 = r1.zza     // Catch:{ all -> 0x1013 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.internal.measurement.zzca$zzb r3 = r3.zza((java.lang.String) r6)     // Catch:{ all -> 0x1013 }
            if (r3 == 0) goto L_0x0f17
            boolean r6 = r3.zza()     // Catch:{ all -> 0x1013 }
            if (r6 != 0) goto L_0x0f0f
            goto L_0x0f17
        L_0x0f0f:
            long r6 = r3.zzb()     // Catch:{ all -> 0x1013 }
            r4.zzi((long) r6)     // Catch:{ all -> 0x1013 }
            goto L_0x0f42
        L_0x0f17:
            com.google.android.gms.internal.measurement.zzcd$zzg r3 = r1.zza     // Catch:{ all -> 0x1013 }
            java.lang.String r3 = r3.zzam()     // Catch:{ all -> 0x1013 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x1013 }
            if (r3 == 0) goto L_0x0f29
            r6 = -1
            r4.zzi((long) r6)     // Catch:{ all -> 0x1013 }
            goto L_0x0f42
        L_0x0f29:
            com.google.android.gms.measurement.internal.zzfu r3 = r5.zzk     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zzh()     // Catch:{ all -> 0x1013 }
            java.lang.String r6 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzcd$zzg r7 = r1.zza     // Catch:{ all -> 0x1013 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x1013 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r7)     // Catch:{ all -> 0x1013 }
            r3.zza(r6, r7)     // Catch:{ all -> 0x1013 }
        L_0x0f42:
            com.google.android.gms.measurement.internal.zzaf r3 = r42.zze()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.internal.measurement.zzjj r4 = r4.zzy()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.internal.measurement.zzhy r4 = (com.google.android.gms.internal.measurement.zzhy) r4     // Catch:{ all -> 0x1013 }
            com.google.android.gms.internal.measurement.zzcd$zzg r4 = (com.google.android.gms.internal.measurement.zzcd.zzg) r4     // Catch:{ all -> 0x1013 }
            r13 = r18
            r3.zza((com.google.android.gms.internal.measurement.zzcd.zzg) r4, (boolean) r13)     // Catch:{ all -> 0x1013 }
        L_0x0f53:
            com.google.android.gms.measurement.internal.zzaf r3 = r42.zze()     // Catch:{ all -> 0x1013 }
            java.util.List<java.lang.Long> r1 = r1.zzb     // Catch:{ all -> 0x1013 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch:{ all -> 0x1013 }
            r3.zzc()     // Catch:{ all -> 0x1013 }
            r3.zzaj()     // Catch:{ all -> 0x1013 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x1013 }
            java.lang.String r6 = "rowid in ("
            r4.<init>(r6)     // Catch:{ all -> 0x1013 }
            r6 = 0
        L_0x0f6a:
            int r7 = r1.size()     // Catch:{ all -> 0x1013 }
            if (r6 >= r7) goto L_0x0f87
            if (r6 == 0) goto L_0x0f77
            java.lang.String r7 = ","
            r4.append(r7)     // Catch:{ all -> 0x1013 }
        L_0x0f77:
            java.lang.Object r7 = r1.get(r6)     // Catch:{ all -> 0x1013 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x1013 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x1013 }
            r4.append(r7)     // Catch:{ all -> 0x1013 }
            int r6 = r6 + 1
            goto L_0x0f6a
        L_0x0f87:
            java.lang.String r6 = ")"
            r4.append(r6)     // Catch:{ all -> 0x1013 }
            android.database.sqlite.SQLiteDatabase r6 = r3.mo31260c_()     // Catch:{ all -> 0x1013 }
            java.lang.String r7 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x1013 }
            r8 = 0
            int r4 = r6.delete(r7, r4, r8)     // Catch:{ all -> 0x1013 }
            int r6 = r1.size()     // Catch:{ all -> 0x1013 }
            if (r4 == r6) goto L_0x0fba
            com.google.android.gms.measurement.internal.zzeq r3 = r3.zzq()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch:{ all -> 0x1013 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x1013 }
            int r1 = r1.size()     // Catch:{ all -> 0x1013 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x1013 }
            r3.zza(r6, r4, r1)     // Catch:{ all -> 0x1013 }
        L_0x0fba:
            com.google.android.gms.measurement.internal.zzaf r1 = r42.zze()     // Catch:{ all -> 0x1013 }
            android.database.sqlite.SQLiteDatabase r3 = r1.mo31260c_()     // Catch:{ all -> 0x1013 }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0fd1 }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0fd1 }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0fd1 }
            r3.execSQL(r4, r6)     // Catch:{ SQLiteException -> 0x0fd1 }
            goto L_0x0fe4
        L_0x0fd1:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch:{ all -> 0x1013 }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r2)     // Catch:{ all -> 0x1013 }
            r1.zza(r4, r2, r3)     // Catch:{ all -> 0x1013 }
        L_0x0fe4:
            com.google.android.gms.measurement.internal.zzaf r1 = r42.zze()     // Catch:{ all -> 0x1013 }
            r1.mo31259b_()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzaf r1 = r42.zze()
            r1.zzg()
            r1 = 1
            return r1
        L_0x0ff4:
            r0 = move-exception
            r5 = r42
            goto L_0x1017
        L_0x0ff8:
            r5 = r1
            com.google.android.gms.measurement.internal.zzaf r1 = r42.zze()     // Catch:{ all -> 0x1013 }
            r1.mo31259b_()     // Catch:{ all -> 0x1013 }
            com.google.android.gms.measurement.internal.zzaf r1 = r42.zze()
            r1.zzg()
            r1 = 0
            return r1
        L_0x1009:
            r0 = move-exception
            r5 = r1
            goto L_0x0251
        L_0x100d:
            if (r6 == 0) goto L_0x1012
            r6.close()     // Catch:{ all -> 0x1013 }
        L_0x1012:
            throw r1     // Catch:{ all -> 0x1013 }
        L_0x1013:
            r0 = move-exception
            goto L_0x1017
        L_0x1015:
            r0 = move-exception
            r5 = r1
        L_0x1017:
            r1 = r0
            com.google.android.gms.measurement.internal.zzaf r2 = r42.zze()
            r2.zzg()
            goto L_0x1021
        L_0x1020:
            throw r1
        L_0x1021:
            goto L_0x1020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(java.lang.String, long):boolean");
    }

    @WorkerThread
    private final zzn zzb(String str) {
        String str2 = str;
        zzf zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zznv.zzb() || !this.zzk.zza().zze(str2, zzas.zzbi)) ? null : zzb2.zzg(), (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza());
        }
        this.zzk.zzq().zze().zza("App version does not match; dropping. appId", zzeq.zza(str));
        return null;
    }

    @WorkerThread
    public final void zzb(zzz zzz2) {
        zzn zzb2 = zzb(zzz2.zza);
        if (zzb2 != null) {
            zzb(zzz2, zzb2);
        }
    }

    @WorkerThread
    public final void zzb(zzz zzz2, zzn zzn2) {
        Preconditions.checkNotNull(zzz2);
        Preconditions.checkNotEmpty(zzz2.zza);
        Preconditions.checkNotNull(zzz2.zzc);
        Preconditions.checkNotEmpty(zzz2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zze().zze();
            try {
                zzc(zzn2);
                zzz zzd2 = zze().zzd(zzz2.zza, zzz2.zzc.zza);
                if (zzd2 != null) {
                    this.zzk.zzq().zzv().zza("Removing conditional user property", zzz2.zza, this.zzk.zzi().zzc(zzz2.zzc.zza));
                    zze().zze(zzz2.zza, zzz2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzz2.zza, zzz2.zzc.zza);
                    }
                    if (zzz2.zzk != null) {
                        Bundle bundle = null;
                        if (zzz2.zzk.zzb != null) {
                            bundle = zzz2.zzk.zzb.zzb();
                        }
                        zzc(this.zzk.zzh().zza(zzz2.zza, zzz2.zzk.zza, bundle, zzd2.zzb, zzz2.zzk.zzd, true, false, zzlo.zzb() && this.zzk.zza().zza(zzas.zzcl)), zzn2);
                    }
                } else {
                    this.zzk.zzq().zzh().zza("Conditional user property doesn't exist", zzeq.zza(zzz2.zza), this.zzk.zzi().zzc(zzz2.zzc.zza));
                }
                zze().mo31259b_();
            } finally {
                zze().zzg();
            }
        }
    }

    @WorkerThread
    public final zzf zzc(zzn zzn2) {
        String str;
        zzx();
        zzn();
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzf zzb2 = zze().zzb(zzn2.zza);
        zzac zzac = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzac = zza(zzn2.zza).zzb(zzac.zza(zzn2.zzw));
        }
        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zzc()) {
            str = this.zzj.zza(zzn2.zza);
        } else {
            str = "";
        }
        if (!zzne.zzb() || !this.zzk.zza().zza(zzas.zzbn)) {
            return zza(zzn2, zzb2, str);
        }
        if (zzb2 == null) {
            zzb2 = new zzf(this.zzk, zzn2.zza);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzb2.zza(zzz());
                zzb2.zze(str);
            } else {
                if (zzac.zze()) {
                    zzb2.zza(zza(zzac));
                }
                if (zzac.zzc()) {
                    zzb2.zze(str);
                }
            }
        } else if ((!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zzc()) && !str.equals(zzb2.zzh())) {
            zzb2.zze(str);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzb2.zza(zzz());
            } else {
                zzb2.zza(zza(zzac));
            }
        } else if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && TextUtils.isEmpty(zzb2.zzd()) && zzac.zze()) {
            zzb2.zza(zza(zzac));
        }
        zzb2.zzb(zzn2.zzb);
        zzb2.zzc(zzn2.zzr);
        if (zznv.zzb() && this.zzk.zza().zze(zzb2.zzc(), zzas.zzbi)) {
            zzb2.zzd(zzn2.zzv);
        }
        if (!TextUtils.isEmpty(zzn2.zzk)) {
            zzb2.zzf(zzn2.zzk);
        }
        long j = zzn2.zze;
        if (j != 0) {
            zzb2.zzd(j);
        }
        if (!TextUtils.isEmpty(zzn2.zzc)) {
            zzb2.zzg(zzn2.zzc);
        }
        zzb2.zzc(zzn2.zzj);
        String str2 = zzn2.zzd;
        if (str2 != null) {
            zzb2.zzh(str2);
        }
        zzb2.zze(zzn2.zzf);
        zzb2.zza(zzn2.zzh);
        if (!TextUtils.isEmpty(zzn2.zzg)) {
            zzb2.zzi(zzn2.zzg);
        }
        if (!this.zzk.zza().zza(zzas.zzbx)) {
            zzb2.zzp(zzn2.zzl);
        }
        zzb2.zzb(zzn2.zzo);
        zzb2.zzc(zzn2.zzp);
        zzb2.zza(zzn2.zzs);
        zzb2.zzf(zzn2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    @VisibleForTesting
    private final void zza(zzcd.zzg.zza zza2, long j, boolean z) {
        zzkw zzkw;
        String str = z ? "_se" : "_lte";
        zzkw zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzkw = new zzkw(zza2.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkw = new zzkw(zza2.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzcd.zzk zzk2 = (zzcd.zzk) ((zzhy) zzcd.zzk.zzj().zza(str).zza(this.zzk.zzl().currentTimeMillis()).zzb(((Long) zzkw.zze).longValue()).zzy());
        boolean z2 = false;
        int zza3 = zzkr.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkw);
            this.zzk.zzq().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkw.zze);
        }
    }

    private final boolean zza(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkr.zza((zzcd.zzc) ((zzhy) zza2.zzy()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzd();
        }
        zzh();
        zzcd.zze zza5 = zzkr.zza((zzcd.zzc) ((zzhy) zza3.zzy()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    @VisibleForTesting
    public static void zza(zzcd.zzc.zza zza2, @NonNull String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    @VisibleForTesting
    public static void zza(zzcd.zzc.zza zza2, int i, String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzcd.zze) ((zzhy) zzcd.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzy())).zza((zzcd.zze) ((zzhy) zzcd.zze.zzm().zza("_ev").zzb(str).zzy()));
    }

    /* JADX INFO: finally extract failed */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzaf zze2;
        zzx();
        zzn();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzs = false;
                zzac();
                throw th2;
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
                this.zzk.zzb().zzd.zza(0);
                zzab();
                this.zzk.zzq().zzw().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zze();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzc();
                            zze2.zzaj();
                            if (zze2.mo31260c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzq().zze().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzx == null || !this.zzx.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().mo31259b_();
                    zze().zzg();
                    this.zzx = null;
                    if (!zzd().zze() || !zzaa()) {
                        this.zzy = -1;
                        zzab();
                    } else {
                        zzo();
                    }
                    this.zzn = 0;
                } catch (Throwable th3) {
                    zze().zzg();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzk.zzq().zze().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzn = this.zzk.zzl().elapsedRealtime();
                this.zzk.zzq().zzw().zza("Disable upload, time", Long.valueOf(this.zzn));
            }
        } else {
            this.zzk.zzq().zzw().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzb().zzd.zza(this.zzk.zzl().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzk.zzb().zze.zza(this.zzk.zzl().currentTimeMillis());
            }
            zze().zza(list);
            zzab();
        }
        this.zzs = false;
        zzac();
    }

    @WorkerThread
    private final void zza(zzf zzf2) {
        ArrayMap arrayMap;
        zzx();
        if (!zznv.zzb() || !this.zzk.zza().zze(zzf2.zzc(), zzas.zzbi)) {
            if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzf())) {
                zza(zzf2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzg()) && TextUtils.isEmpty(zzf2.zzf())) {
            zza(zzf2.zzc(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String zza2 = this.zzk.zza().zza(zzf2);
        try {
            URL url = new URL(zza2);
            this.zzk.zzq().zzw().zza("Fetching remote configuration", zzf2.zzc());
            zzca.zzb zza3 = zzc().zza(zzf2.zzc());
            String zzb2 = zzc().zzb(zzf2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(AssetDownloader.IF_MODIFIED_SINCE, zzb2);
                arrayMap = arrayMap2;
            }
            this.zzr = true;
            zzex zzd2 = zzd();
            String zzc2 = zzf2.zzc();
            zzkm zzkm = new zzkm(this);
            zzd2.zzc();
            zzd2.zzaj();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkm);
            zzd2.zzp().zzc((Runnable) new zzfb(zzd2, zzc2, url, (byte[]) null, arrayMap, zzkm));
        } catch (MalformedURLException unused) {
            this.zzk.zzq().zze().zza("Failed to parse config URL. Not fetching. appId", zzeq.zza(zzf2.zzc()), zza2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0172 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0176 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    @androidx.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzx()
            r6.zzn()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfu r1 = r6.zzk     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeq r1 = r1.zzq()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzw()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzaf r1 = r6.zze()     // Catch:{ all -> 0x0196 }
            r1.zze()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzaf r1 = r6.zze()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzb(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfu r8 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeq r8 = r8.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzh()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeq.zza((java.lang.String) r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzfu r10 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzl()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzi((long) r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzaf r10 = r6.zze()     // Catch:{ all -> 0x018d }
            r10.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfu r10 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeq r10 = r10.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzw()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfo r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            r9.zzc(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfu r7 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfc r7 = r7.zzb()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfg r7 = r7.zzd     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfu r9 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzl()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzfu r7 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfc r7 = r7.zzb()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfg r7 = r7.zze     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfu r8 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzl()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzab()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfo r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzaf r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzg()     // Catch:{ all -> 0x0196 }
            r6.zzr = r0
            r6.zzac()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfo r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzca$zzb r11 = r11.zza((java.lang.String) r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfo r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzaf r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzg()     // Catch:{ all -> 0x0196 }
            r6.zzr = r0
            r6.zzac()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzfu r9 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzl()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzh((long) r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzaf r9 = r6.zze()     // Catch:{ all -> 0x018d }
            r9.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfu r8 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeq r8 = r8.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzj()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzfu r7 = r6.zzk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeq r7 = r7.zzq()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzw()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzex r7 = r6.zzd()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zze()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzaa()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.zzo()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.zzab()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.zzaf r7 = r6.zze()     // Catch:{ all -> 0x018d }
            r7.mo31259b_()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzaf r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzg()     // Catch:{ all -> 0x0196 }
            r6.zzr = r0
            r6.zzac()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzaf r8 = r6.zze()     // Catch:{ all -> 0x0196 }
            r8.zzg()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.zzr = r0
            r6.zzac()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    @WorkerThread
    public final void zza(Runnable runnable) {
        zzx();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzk.zzq().zzh().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to read from channel", e);
            return 0;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.zzk.zza().zza(zzas.zzbr) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzk.zzq().zze().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to write to channel", e);
            return false;
        }
    }

    @WorkerThread
    @VisibleForTesting
    public final void zza(zzn zzn2) {
        if (this.zzw != null) {
            ArrayList arrayList = new ArrayList();
            this.zzx = arrayList;
            arrayList.addAll(this.zzw);
        }
        zzaf zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzc();
        zze2.zzaj();
        try {
            SQLiteDatabase c_ = zze2.mo31260c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr) + c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzq().zzw().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzq().zze().zza("Error resetting analytics data. appId, error", zzeq.zza(str), e);
        }
        if (zzn2.zzh) {
            zzb(zzn2);
        }
    }

    @WorkerThread
    public final void zza(zzku zzku, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            int zzb2 = this.zzk.zzh().zzb(zzku.zza);
            if (zzb2 != 0) {
                this.zzk.zzh();
                String zza2 = zzkv.zza(zzku.zza, 24, true);
                String str = zzku.zza;
                this.zzk.zzh().zza(this.zzaa, zzn2.zza, zzb2, "_ev", zza2, str != null ? str.length() : 0);
                return;
            }
            int zzb3 = this.zzk.zzh().zzb(zzku.zza, zzku.zza());
            if (zzb3 != 0) {
                this.zzk.zzh();
                String zza3 = zzkv.zza(zzku.zza, 24, true);
                Object zza4 = zzku.zza();
                this.zzk.zzh().zza(this.zzaa, zzn2.zza, zzb3, "_ev", zza3, (zza4 == null || (!(zza4 instanceof String) && !(zza4 instanceof CharSequence))) ? 0 : String.valueOf(zza4).length());
                return;
            }
            Object zzc2 = this.zzk.zzh().zzc(zzku.zza, zzku.zza());
            if (zzc2 != null) {
                if ("_sid".equals(zzku.zza)) {
                    long j = zzku.zzb;
                    String str2 = zzku.zze;
                    long j2 = 0;
                    zzkw zzc3 = zze().zzc(zzn2.zza, "_sno");
                    if (zzc3 != null) {
                        Object obj = zzc3.zze;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                            zza(new zzku("_sno", j, Long.valueOf(j2 + 1), str2), zzn2);
                        }
                    }
                    if (zzc3 != null) {
                        this.zzk.zzq().zzh().zza("Retrieved last session number from database does not contain a valid (long) value", zzc3.zze);
                    }
                    zzam zza5 = zze().zza(zzn2.zza, "_s");
                    if (zza5 != null) {
                        j2 = zza5.zzc;
                        this.zzk.zzq().zzw().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                    zza(new zzku("_sno", j, Long.valueOf(j2 + 1), str2), zzn2);
                }
                zzkw zzkw = new zzkw(zzn2.zza, zzku.zze, zzku.zza, zzku.zzb, zzc2);
                this.zzk.zzq().zzw().zza("Setting user property", this.zzk.zzi().zzc(zzkw.zzc), zzc2);
                zze().zze();
                try {
                    zzc(zzn2);
                    boolean zza6 = zze().zza(zzkw);
                    zze().mo31259b_();
                    if (!zza6) {
                        this.zzk.zzq().zze().zza("Too many unique user properties are set. Ignoring user property", this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        this.zzk.zzh().zza(this.zzaa, zzn2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzg();
                }
            }
        }
    }

    public final void zza(zzki zzki) {
        this.zzp++;
    }

    @WorkerThread
    public final void zza(zzz zzz2) {
        zzn zzb2 = zzb(zzz2.zza);
        if (zzb2 != null) {
            zza(zzz2, zzb2);
        }
    }

    @WorkerThread
    public final void zza(zzz zzz2, zzn zzn2) {
        Preconditions.checkNotNull(zzz2);
        Preconditions.checkNotEmpty(zzz2.zza);
        Preconditions.checkNotNull(zzz2.zzb);
        Preconditions.checkNotNull(zzz2.zzc);
        Preconditions.checkNotEmpty(zzz2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zzz zzz3 = new zzz(zzz2);
            boolean z = false;
            zzz3.zze = false;
            zze().zze();
            try {
                zzz zzd2 = zze().zzd(zzz3.zza, zzz3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzz3.zzb)) {
                    this.zzk.zzq().zzh().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzz3.zzb = zzd2.zzb;
                    zzz3.zzd = zzd2.zzd;
                    zzz3.zzh = zzd2.zzh;
                    zzz3.zzf = zzd2.zzf;
                    zzz3.zzi = zzd2.zzi;
                    zzz3.zze = zzd2.zze;
                    zzz3.zzc = new zzku(zzz3.zzc.zza, zzd2.zzc.zzb, zzz3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzz3.zzf)) {
                    zzz3.zzc = new zzku(zzz3.zzc.zza, zzz3.zzd, zzz3.zzc.zza(), zzz3.zzc.zze);
                    zzz3.zze = true;
                    z = true;
                }
                if (zzz3.zze) {
                    zzku zzku = zzz3.zzc;
                    zzkw zzkw = new zzkw(zzz3.zza, zzz3.zzb, zzku.zza, zzku.zzb, zzku.zza());
                    if (zze().zza(zzkw)) {
                        this.zzk.zzq().zzv().zza("User property updated immediately", zzz3.zza, this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                    } else {
                        this.zzk.zzq().zze().zza("(2)Too many active user properties, ignoring", zzeq.zza(zzz3.zza), this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                    }
                    if (z && zzz3.zzi != null) {
                        zzc(new zzaq(zzz3.zzi, zzz3.zzd), zzn2);
                    }
                }
                if (zze().zza(zzz3)) {
                    this.zzk.zzq().zzv().zza("Conditional property added", zzz3.zza, this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                } else {
                    this.zzk.zzq().zze().zza("Too many conditional properties, ignoring", zzeq.zza(zzz3.zza), this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                }
                zze().mo31259b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0202  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzac r0 = com.google.android.gms.measurement.internal.zzac.zza
            boolean r1 = com.google.android.gms.internal.measurement.zzml.zzb()
            if (r1 == 0) goto L_0x0026
            com.google.android.gms.measurement.internal.zzfu r1 = r8.zzk
            com.google.android.gms.measurement.internal.zzab r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r2)
            if (r1 == 0) goto L_0x0026
            java.lang.String r0 = r9.zza
            com.google.android.gms.measurement.internal.zzac r0 = r8.zza((java.lang.String) r0)
            java.lang.String r1 = r9.zzw
            com.google.android.gms.measurement.internal.zzac r1 = com.google.android.gms.measurement.internal.zzac.zza((java.lang.String) r1)
            com.google.android.gms.measurement.internal.zzac r0 = r0.zzb((com.google.android.gms.measurement.internal.zzac) r1)
        L_0x0026:
            r1 = 1
            if (r10 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzf r10 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzfu r2 = r8.zzk
            java.lang.String r3 = r9.zza
            r10.<init>(r2, r3)
            boolean r2 = com.google.android.gms.internal.measurement.zzml.zzb()
            if (r2 == 0) goto L_0x005d
            com.google.android.gms.measurement.internal.zzfu r2 = r8.zzk
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x005d
            boolean r2 = r0.zze()
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = r8.zza((com.google.android.gms.measurement.internal.zzac) r0)
            r10.zza((java.lang.String) r2)
        L_0x0053:
            boolean r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            r10.zze((java.lang.String) r11)
            goto L_0x0067
        L_0x005d:
            java.lang.String r0 = r8.zzz()
            r10.zza((java.lang.String) r0)
            r10.zze((java.lang.String) r11)
        L_0x0067:
            r11 = 1
            goto L_0x00e8
        L_0x006a:
            boolean r2 = com.google.android.gms.internal.measurement.zzml.zzb()
            if (r2 == 0) goto L_0x0084
            com.google.android.gms.measurement.internal.zzfu r2 = r8.zzk
            com.google.android.gms.measurement.internal.zzab r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0084
            boolean r2 = r0.zzc()
            if (r2 == 0) goto L_0x00bb
        L_0x0084:
            java.lang.String r2 = r10.zzh()
            boolean r2 = r11.equals(r2)
            if (r2 != 0) goto L_0x00bb
            r10.zze((java.lang.String) r11)
            boolean r11 = com.google.android.gms.internal.measurement.zzml.zzb()
            if (r11 == 0) goto L_0x00b3
            com.google.android.gms.measurement.internal.zzfu r11 = r8.zzk
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r2)
            if (r11 == 0) goto L_0x00b3
            boolean r11 = r0.zze()
            if (r11 == 0) goto L_0x0067
            java.lang.String r11 = r8.zza((com.google.android.gms.measurement.internal.zzac) r0)
            r10.zza((java.lang.String) r11)
            goto L_0x0067
        L_0x00b3:
            java.lang.String r11 = r8.zzz()
            r10.zza((java.lang.String) r11)
            goto L_0x0067
        L_0x00bb:
            boolean r11 = com.google.android.gms.internal.measurement.zzml.zzb()
            if (r11 == 0) goto L_0x00e7
            com.google.android.gms.measurement.internal.zzfu r11 = r8.zzk
            com.google.android.gms.measurement.internal.zzab r11 = r11.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzci
            boolean r11 = r11.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r2)
            if (r11 == 0) goto L_0x00e7
            java.lang.String r11 = r10.zzd()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x00e7
            boolean r11 = r0.zze()
            if (r11 == 0) goto L_0x00e7
            java.lang.String r11 = r8.zza((com.google.android.gms.measurement.internal.zzac) r0)
            r10.zza((java.lang.String) r11)
            goto L_0x0067
        L_0x00e7:
            r11 = 0
        L_0x00e8:
            java.lang.String r0 = r9.zzb
            java.lang.String r2 = r10.zze()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x00fa
            java.lang.String r11 = r9.zzb
            r10.zzb((java.lang.String) r11)
            r11 = 1
        L_0x00fa:
            java.lang.String r0 = r9.zzr
            java.lang.String r2 = r10.zzf()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x010c
            java.lang.String r11 = r9.zzr
            r10.zzc((java.lang.String) r11)
            r11 = 1
        L_0x010c:
            boolean r0 = com.google.android.gms.internal.measurement.zznv.zzb()
            if (r0 == 0) goto L_0x0136
            com.google.android.gms.measurement.internal.zzfu r0 = r8.zzk
            com.google.android.gms.measurement.internal.zzab r0 = r0.zza()
            java.lang.String r2 = r10.zzc()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbi
            boolean r0 = r0.zze(r2, r3)
            if (r0 == 0) goto L_0x0136
            java.lang.String r0 = r9.zzv
            java.lang.String r2 = r10.zzg()
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 != 0) goto L_0x0136
            java.lang.String r11 = r9.zzv
            r10.zzd((java.lang.String) r11)
            r11 = 1
        L_0x0136:
            java.lang.String r0 = r9.zzk
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0150
            java.lang.String r0 = r9.zzk
            java.lang.String r2 = r10.zzi()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0150
            java.lang.String r11 = r9.zzk
            r10.zzf((java.lang.String) r11)
            r11 = 1
        L_0x0150:
            long r2 = r9.zze
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0166
            long r6 = r10.zzo()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0166
            long r2 = r9.zze
            r10.zzd((long) r2)
            r11 = 1
        L_0x0166:
            java.lang.String r0 = r9.zzc
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0180
            java.lang.String r0 = r9.zzc
            java.lang.String r2 = r10.zzl()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0180
            java.lang.String r11 = r9.zzc
            r10.zzg((java.lang.String) r11)
            r11 = 1
        L_0x0180:
            long r2 = r9.zzj
            long r6 = r10.zzm()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0190
            long r2 = r9.zzj
            r10.zzc((long) r2)
            r11 = 1
        L_0x0190:
            java.lang.String r0 = r9.zzd
            if (r0 == 0) goto L_0x01a4
            java.lang.String r2 = r10.zzn()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01a4
            java.lang.String r11 = r9.zzd
            r10.zzh((java.lang.String) r11)
            r11 = 1
        L_0x01a4:
            long r2 = r9.zzf
            long r6 = r10.zzp()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01b4
            long r2 = r9.zzf
            r10.zze((long) r2)
            r11 = 1
        L_0x01b4:
            boolean r0 = r9.zzh
            boolean r2 = r10.zzr()
            if (r0 == r2) goto L_0x01c2
            boolean r11 = r9.zzh
            r10.zza((boolean) r11)
            r11 = 1
        L_0x01c2:
            java.lang.String r0 = r9.zzg
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01dc
            java.lang.String r0 = r9.zzg
            java.lang.String r2 = r10.zzac()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            java.lang.String r11 = r9.zzg
            r10.zzi((java.lang.String) r11)
            r11 = 1
        L_0x01dc:
            com.google.android.gms.measurement.internal.zzfu r0 = r8.zzk
            com.google.android.gms.measurement.internal.zzab r0 = r0.zza()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzbx
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzej<java.lang.Boolean>) r2)
            if (r0 != 0) goto L_0x01fa
            long r2 = r9.zzl
            long r6 = r10.zzae()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01fa
            long r2 = r9.zzl
            r10.zzp(r2)
            r11 = 1
        L_0x01fa:
            boolean r0 = r9.zzo
            boolean r2 = r10.zzaf()
            if (r0 == r2) goto L_0x0208
            boolean r11 = r9.zzo
            r10.zzb((boolean) r11)
            r11 = 1
        L_0x0208:
            boolean r0 = r9.zzp
            boolean r2 = r10.zzag()
            if (r0 == r2) goto L_0x0216
            boolean r11 = r9.zzp
            r10.zzc((boolean) r11)
            r11 = 1
        L_0x0216:
            java.lang.Boolean r0 = r9.zzs
            java.lang.Boolean r2 = r10.zzah()
            if (r0 == r2) goto L_0x0224
            java.lang.Boolean r11 = r9.zzs
            r10.zza((java.lang.Boolean) r11)
            r11 = 1
        L_0x0224:
            long r2 = r9.zzt
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0238
            long r4 = r10.zzq()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0238
            long r2 = r9.zzt
            r10.zzf((long) r2)
            goto L_0x0239
        L_0x0238:
            r1 = r11
        L_0x0239:
            if (r1 == 0) goto L_0x0242
            com.google.android.gms.measurement.internal.zzaf r9 = r8.zze()
            r9.zza((com.google.android.gms.measurement.internal.zzf) r10)
        L_0x0242:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public final void zza(boolean z) {
        zzab();
    }
}
