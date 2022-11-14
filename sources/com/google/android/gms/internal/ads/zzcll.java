package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcll extends zzahm {
    public final Context zza;
    public final zzaht zzb;
    public final zzclk zzc;
    public final String zzd;
    public final int zze;
    public final boolean zzf = ((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue();
    public InputStream zzg;
    public boolean zzh;
    public Uri zzi;
    public volatile zzayj zzj;
    public boolean zzk = false;
    public boolean zzl = false;
    public boolean zzm = false;
    public boolean zzn = false;
    public long zzo = 0;
    public zzfqn<Long> zzp = null;
    public final AtomicLong zzq = new AtomicLong(-1);

    public zzcll(Context context, zzaht zzaht, String str, int i, zzajd zzajd, zzclk zzclk) {
        super(false);
        this.zza = context;
        this.zzb = zzaht;
        this.zzc = zzclk;
        this.zzd = str;
        this.zze = i;
        if (zzajd != null) {
            zzb(zzajd);
        }
    }

    private final boolean zzr() {
        if (!this.zzf) {
            return false;
        }
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzcG)).booleanValue() && !this.zzm) {
            return true;
        }
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzcH)).booleanValue() || this.zzn) {
            return false;
        }
        return true;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.zzh) {
            InputStream inputStream = this.zzg;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.zzb.zza(bArr, i, i2);
            }
            if (!this.zzf || this.zzg != null) {
                zzi(i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed GcacheDataSource.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e0  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x010b=Splitter:B:34:0x010b, B:39:0x012c=Splitter:B:39:0x012c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzc(com.google.android.gms.internal.ads.zzahx r15) throws java.io.IOException {
        /*
            r14 = this;
            java.lang.String r0 = "ms"
            java.lang.String r1 = "Cache connection took "
            boolean r2 = r14.zzh
            if (r2 != 0) goto L_0x0200
            r2 = 1
            r14.zzh = r2
            android.net.Uri r3 = r15.zza
            r14.zzi = r3
            boolean r3 = r14.zzf
            if (r3 != 0) goto L_0x0016
            r14.zzh(r15)
        L_0x0016:
            android.net.Uri r3 = r15.zza
            com.google.android.gms.internal.ads.zzayj r3 = com.google.android.gms.internal.ads.zzayj.zza(r3)
            r14.zzj = r3
            com.google.android.gms.internal.ads.zzbjf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzbjn.zzcD
            com.google.android.gms.internal.ads.zzbjl r4 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r4.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = -1
            r6 = 0
            if (r3 == 0) goto L_0x017e
            com.google.android.gms.internal.ads.zzayj r3 = r14.zzj
            if (r3 == 0) goto L_0x01da
            com.google.android.gms.internal.ads.zzayj r3 = r14.zzj
            long r7 = r15.zzf
            r3.zzh = r7
            com.google.android.gms.internal.ads.zzayj r3 = r14.zzj
            java.lang.String r7 = r14.zzd
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfkm.zza(r7)
            r3.zzi = r7
            com.google.android.gms.internal.ads.zzayj r3 = r14.zzj
            int r7 = r14.zze
            r3.zzj = r7
            com.google.android.gms.internal.ads.zzayj r3 = r14.zzj
            boolean r3 = r3.zzg
            if (r3 == 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzbjn.zzcF
            com.google.android.gms.internal.ads.zzbjl r7 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r7.zzb(r3)
            java.lang.Long r3 = (java.lang.Long) r3
            goto L_0x006c
        L_0x0060:
            com.google.android.gms.internal.ads.zzbjf<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzbjn.zzcE
            com.google.android.gms.internal.ads.zzbjl r7 = com.google.android.gms.internal.ads.zzbex.zzc()
            java.lang.Object r3 = r7.zzb(r3)
            java.lang.Long r3 = (java.lang.Long) r3
        L_0x006c:
            long r7 = r3.longValue()
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r9 = r3.elapsedRealtime()
            com.google.android.gms.ads.internal.zzs.zzw()
            android.content.Context r3 = r14.zza
            com.google.android.gms.internal.ads.zzayj r11 = r14.zzj
            java.util.concurrent.Future r3 = com.google.android.gms.internal.ads.zzayu.zza(r3, r11)
            r11 = 44
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x012b, InterruptedException -> 0x010a, all -> 0x0107 }
            java.lang.Object r7 = r3.get(r7, r12)     // Catch:{ ExecutionException | TimeoutException -> 0x012b, InterruptedException -> 0x010a, all -> 0x0107 }
            com.google.android.gms.internal.ads.zzayv r7 = (com.google.android.gms.internal.ads.zzayv) r7     // Catch:{ ExecutionException | TimeoutException -> 0x012b, InterruptedException -> 0x010a, all -> 0x0107 }
            boolean r8 = r7.zzc()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzk = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r8 = r7.zzd()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzm = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r8 = r7.zzf()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzn = r8     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            long r12 = r7.zze()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzo = r12     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r8 = r14.zzr()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            if (r8 != 0) goto L_0x00de
            java.io.InputStream r7 = r7.zzb()     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            r14.zzg = r7     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            boolean r7 = r14.zzf     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
            if (r7 == 0) goto L_0x00b8
            r14.zzh(r15)     // Catch:{ ExecutionException | TimeoutException -> 0x0105, InterruptedException -> 0x0103, all -> 0x0101 }
        L_0x00b8:
            com.google.android.gms.common.util.Clock r15 = com.google.android.gms.ads.internal.zzs.zzj()
            long r6 = r15.elapsedRealtime()
            long r6 = r6 - r9
            com.google.android.gms.internal.ads.zzclk r15 = r14.zzc
            r15.zza(r2, r6)
            r14.zzl = r2
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            r15.append(r1)
            r15.append(r6)
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r15)
            return r4
        L_0x00de:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzclk r5 = r14.zzc
            r5.zza(r2, r3)
            r14.zzl = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            goto L_0x0151
        L_0x0101:
            r15 = move-exception
            goto L_0x0158
        L_0x0103:
            r4 = 1
            goto L_0x010b
        L_0x0105:
            r4 = 1
            goto L_0x012c
        L_0x0107:
            r15 = move-exception
            r2 = 0
            goto L_0x0158
        L_0x010a:
            r4 = 0
        L_0x010b:
            r3.cancel(r2)     // Catch:{ all -> 0x0156 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0156 }
            r2.interrupt()     // Catch:{ all -> 0x0156 }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzs.zzj()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzclk r5 = r14.zzc
            r5.zza(r4, r2)
            r14.zzl = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            goto L_0x0144
        L_0x012b:
            r4 = 0
        L_0x012c:
            r3.cancel(r2)     // Catch:{ all -> 0x0156 }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzs.zzj()
            long r2 = r2.elapsedRealtime()
            long r2 = r2 - r9
            com.google.android.gms.internal.ads.zzclk r5 = r14.zzc
            r5.zza(r4, r2)
            r14.zzl = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
        L_0x0144:
            r4.append(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
        L_0x0151:
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            goto L_0x01da
        L_0x0156:
            r15 = move-exception
            r2 = r4
        L_0x0158:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzs.zzj()
            long r3 = r3.elapsedRealtime()
            long r3 = r3 - r9
            com.google.android.gms.internal.ads.zzclk r5 = r14.zzc
            r5.zza(r2, r3)
            r14.zzl = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r1)
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            throw r15
        L_0x017e:
            com.google.android.gms.internal.ads.zzayj r0 = r14.zzj
            if (r0 == 0) goto L_0x01a3
            com.google.android.gms.internal.ads.zzayj r0 = r14.zzj
            long r7 = r15.zzf
            r0.zzh = r7
            com.google.android.gms.internal.ads.zzayj r0 = r14.zzj
            java.lang.String r1 = r14.zzd
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfkm.zza(r1)
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzayj r0 = r14.zzj
            int r1 = r14.zze
            r0.zzj = r1
            com.google.android.gms.internal.ads.zzayf r0 = com.google.android.gms.ads.internal.zzs.zzi()
            com.google.android.gms.internal.ads.zzayj r1 = r14.zzj
            com.google.android.gms.internal.ads.zzayg r0 = r0.zzc(r1)
            goto L_0x01a4
        L_0x01a3:
            r0 = 0
        L_0x01a4:
            if (r0 == 0) goto L_0x01da
            boolean r1 = r0.zza()
            if (r1 == 0) goto L_0x01da
            boolean r1 = r0.zzd()
            r14.zzk = r1
            boolean r1 = r0.zzg()
            r14.zzm = r1
            boolean r1 = r0.zze()
            r14.zzn = r1
            long r7 = r0.zzf()
            r14.zzo = r7
            r14.zzl = r2
            boolean r1 = r14.zzr()
            if (r1 != 0) goto L_0x01da
            java.io.InputStream r0 = r0.zzb()
            r14.zzg = r0
            boolean r0 = r14.zzf
            if (r0 == 0) goto L_0x01d9
            r14.zzh(r15)
        L_0x01d9:
            return r4
        L_0x01da:
            r14.zzl = r6
            com.google.android.gms.internal.ads.zzayj r0 = r14.zzj
            if (r0 == 0) goto L_0x01f9
            com.google.android.gms.internal.ads.zzahx r0 = new com.google.android.gms.internal.ads.zzahx
            com.google.android.gms.internal.ads.zzayj r1 = r14.zzj
            java.lang.String r1 = r1.zza
            android.net.Uri r2 = android.net.Uri.parse(r1)
            long r4 = r15.zze
            long r6 = r15.zzf
            long r8 = r15.zzg
            r3 = 0
            r10 = 0
            int r11 = r15.zzi
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r15 = r0
        L_0x01f9:
            com.google.android.gms.internal.ads.zzaht r0 = r14.zzb
            long r0 = r0.zzc(r15)
            return r0
        L_0x0200:
            java.io.IOException r15 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open GcacheDataSource."
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcll.zzc(com.google.android.gms.internal.ads.zzahx):long");
    }

    public final Uri zzd() {
        return this.zzi;
    }

    public final void zzf() throws IOException {
        if (this.zzh) {
            boolean z = false;
            this.zzh = false;
            this.zzi = null;
            if (!this.zzf || this.zzg != null) {
                z = true;
            }
            InputStream inputStream = this.zzg;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzg = null;
            } else {
                this.zzb.zzf();
            }
            if (z) {
                zzj();
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed GcacheDataSource.");
    }

    public final boolean zzk() {
        return this.zzk;
    }

    public final boolean zzl() {
        return this.zzl;
    }

    public final boolean zzm() {
        return this.zzm;
    }

    public final boolean zzn() {
        return this.zzn;
    }

    public final long zzo() {
        return this.zzo;
    }

    public final long zzp() {
        if (this.zzj == null) {
            return -1;
        }
        if (this.zzq.get() != -1) {
            return this.zzq.get();
        }
        synchronized (this) {
            if (this.zzp == null) {
                this.zzp = zzche.zza.zzb(new zzclj(this));
            }
        }
        if (!this.zzp.isDone()) {
            return -1;
        }
        try {
            this.zzq.compareAndSet(-1, this.zzp.get().longValue());
            return this.zzq.get();
        } catch (InterruptedException | ExecutionException unused) {
            return -1;
        }
    }

    public final /* synthetic */ Long zzq() throws Exception {
        return Long.valueOf(zzs.zzi().zzd(this.zzj));
    }
}
