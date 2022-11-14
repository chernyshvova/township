package com.google.android.gms.internal.measurement;

import androidx.cardview.widget.RoundRectDrawableWithShadow;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.measurement.zzhy;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzcd {

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zza extends zzhy<zza, C3368zza> implements zzjl {
        public static final zza zzh;
        public static volatile zzjs<zza> zzi;
        public int zzc;
        public int zzd;
        public zzi zze;
        public zzi zzf;
        public boolean zzg;

        /* renamed from: com.google.android.gms.internal.measurement.zzcd$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class C3368zza extends zzhy.zzb<zza, C3368zza> implements zzjl {
            public C3368zza() {
                super(zza.zzh);
            }

            public final C3368zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i);
                return this;
            }

            public /* synthetic */ C3368zza(zzcf zzcf) {
                this();
            }

            public final C3368zza zza(zzi.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zzi) ((zzhy) zza.zzy()));
                return this;
            }

            public final C3368zza zza(zzi zzi) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(zzi);
                return this;
            }

            public final C3368zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(z);
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzhy.zza(zza.class, zza);
        }

        public static C3368zza zzh() {
            return (C3368zza) zzh.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final zzi zzc() {
            zzi zzi2 = this.zze;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zzi2 = this.zzf;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzi zzi2) {
            zzi2.getClass();
            this.zzf = zzi2;
            this.zzc |= 4;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zze = zzi2;
            this.zzc |= 2;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3368zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjs<zza> zzjs = zzi;
                    if (zzjs == null) {
                        synchronized (zza.class) {
                            zzjs = zzi;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzh);
                                zzi = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzb extends zzhy<zzb, zza> implements zzjl {
        public static final zzb zzf;
        public static volatile zzjs<zzb> zzg;
        public int zzc;
        public int zzd;
        public long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzb, zza> implements zzjl {
            public zza() {
                super(zzb.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i);
                return this;
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzf = zzb;
            zzhy.zza(zzb.class, zzb);
        }

        public static zza zze() {
            return (zza) zzf.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzb> zzjs = zzg;
                    if (zzjs == null) {
                        synchronized (zzb.class) {
                            zzjs = zzg;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzf);
                                zzg = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzc extends zzhy<zzc, zza> implements zzjl {
        public static final zzc zzi;
        public static volatile zzjs<zzc> zzj;
        public int zzc;
        public zzig<zze> zzd = zzhy.zzbs();
        public String zze = "";
        public long zzf;
        public long zzg;
        public int zzh;

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzc, zza> implements zzjl {
            public zza() {
                super(zzc.zzi);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzm();
                return this;
            }

            public final String zzd() {
                return ((zzc) this.zza).zzc();
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzd();
            }

            public final long zzf() {
                return ((zzc) this.zza).zze();
            }

            public final long zzg() {
                return ((zzc) this.zza).zzg();
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(i);
                return this;
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final zza zza(int i, zze zze) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, zze);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(j);
                return this;
            }

            public final zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, (zze) ((zzhy) zza.zzy()));
                return this;
            }

            public final zza zza(zze zze) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(zze);
                return this;
            }

            public final zza zza(zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zze) ((zzhy) zza.zzy()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzi = zzc2;
            zzhy.zza(zzc.class, zzc2);
        }

        public static zza zzj() {
            return (zza) zzi.zzbm();
        }

        private final void zzl() {
            zzig<zze> zzig = this.zzd;
            if (!zzig.zza()) {
                this.zzd = zzhy.zza(zzig);
            }
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzhy.zzbs();
        }

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            zzl();
            this.zzd.remove(i);
        }

        public final zze zza(int i) {
            return this.zzd.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.set(i, zze2);
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzl();
            zzgg.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjs<zzc> zzjs = zzj;
                    if (zzjs == null) {
                        synchronized (zzc.class) {
                            zzjs = zzj;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzi);
                                zzj = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zze extends zzhy<zze, zza> implements zzjl {
        public static final zze zzj;
        public static volatile zzjs<zze> zzk;
        public int zzc;
        public String zzd = "";
        public String zze = "";
        public long zzf;
        public float zzg;
        public double zzh;
        public zzig<zze> zzi = zzhy.zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zze, zza> implements zzjl {
            public zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzq();
                return this;
            }

            public final int zzd() {
                return ((zze) this.zza).zzl();
            }

            public final zza zze() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzs();
                return this;
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzo();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzp();
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(j);
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(d);
                return this;
            }

            public final zza zza(zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zze((zze) ((zzhy) zza.zzy()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzhy.zza(zze.class, zze2);
        }

        public static zza zzm() {
            return (zza) zzj.zzbm();
        }

        /* access modifiers changed from: private */
        public final void zzo() {
            this.zzc &= -3;
            this.zze = zzj.zze;
        }

        /* access modifiers changed from: private */
        public final void zzp() {
            this.zzc &= -5;
            this.zzf = 0;
        }

        /* access modifiers changed from: private */
        public final void zzq() {
            this.zzc &= -17;
            this.zzh = RoundRectDrawableWithShadow.COS_45;
        }

        private final void zzr() {
            zzig<zze> zzig = this.zzi;
            if (!zzig.zza()) {
                this.zzi = zzhy.zza(zzig);
            }
        }

        /* access modifiers changed from: private */
        public final void zzs() {
            this.zzi = zzhy.zzbs();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final String zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final long zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final float zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final double zzj() {
            return this.zzh;
        }

        public final List<zze> zzk() {
            return this.zzi;
        }

        public final int zzl() {
            return this.zzi.size();
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zze(zze zze2) {
            zze2.getClass();
            zzr();
            this.zzi.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 16;
            this.zzh = d;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzr();
            zzgg.zza(iterable, this.zzi);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            Class<zze> cls = zze.class;
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", cls});
                case 4:
                    return zzj;
                case 5:
                    zzjs<zze> zzjs = zzk;
                    if (zzjs == null) {
                        synchronized (cls) {
                            zzjs = zzk;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzj);
                                zzk = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzf extends zzhy<zzf, zza> implements zzjl {
        public static final zzf zzd;
        public static volatile zzjs<zzf> zze;
        public zzig<zzg> zzc = zzhy.zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzf, zza> implements zzjl {
            public zza() {
                super(zzf.zzd);
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzg) ((zzhy) zza.zzy()));
                return this;
            }
        }

        static {
            zzf zzf = new zzf();
            zzd = zzf;
            zzhy.zza(zzf.class, zzf);
        }

        public static zza zzb() {
            return (zza) zzd.zzbm();
        }

        public final List<zzg> zza() {
            return this.zzc;
        }

        public final zzg zza(int i) {
            return this.zzc.get(0);
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            zzig<zzg> zzig = this.zzc;
            if (!zzig.zza()) {
                this.zzc = zzhy.zza(zzig);
            }
            this.zzc.add(zzg);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzjs<zzf> zzjs = zze;
                    if (zzjs == null) {
                        synchronized (zzf.class) {
                            zzjs = zze;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzd);
                                zze = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzg extends zzhy<zzg, zza> implements zzjl {
        public static final zzg zzax;
        public static volatile zzjs<zzg> zzay;
        public int zzaa;
        public String zzab = "";
        public String zzac = "";
        public boolean zzad;
        public zzig<zza> zzae = zzhy.zzbs();
        public String zzaf = "";
        public int zzag;
        public int zzah;
        public int zzai;
        public String zzaj = "";
        public long zzak;
        public long zzal;
        public String zzam = "";
        public String zzan = "";
        public int zzao;
        public String zzap = "";
        public zzh zzaq;
        public zzie zzar = zzhy.zzbq();
        public long zzas;
        public long zzat;
        public String zzau = "";
        public String zzav = "";
        public int zzaw;
        public int zzc;
        public int zzd;
        public int zze;
        public zzig<zzc> zzf = zzhy.zzbs();
        public zzig<zzk> zzg = zzhy.zzbs();
        public long zzh;
        public long zzi;
        public long zzj;
        public long zzk;
        public long zzl;
        public String zzm = "";
        public String zzn = "";
        public String zzo = "";
        public String zzp = "";
        public int zzq;
        public String zzr = "";
        public String zzs = "";
        public String zzt = "";
        public long zzu;
        public long zzv;
        public String zzw = "";
        public boolean zzx;
        public String zzy = "";
        public long zzz;

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzg, zza> implements zzjl {
            public zza() {
                super(zzg.zzax);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(1);
                return this;
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbx();
                return this;
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzh() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbz();
                return this;
            }

            public final zza zzi() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzca();
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzk() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcb();
                return this;
            }

            public final zza zzl() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcc();
                return this;
            }

            public final zza zzm() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcd();
                return this;
            }

            public final zza zzn() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzce();
                return this;
            }

            public final String zzo() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzp() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcf();
                return this;
            }

            public final zza zzq() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcg();
                return this;
            }

            public final zza zzr() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzch();
                return this;
            }

            public final String zzs() {
                return ((zzg) this.zza).zzbe();
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zze(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(i);
                return this;
            }

            public final zza zzf(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(i);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(str);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(str);
                return this;
            }

            public final zza zzo(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzo(str);
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(iterable);
                return this;
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(i);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(j);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(str);
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(str);
                return this;
            }

            public final zza zzk(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(str);
                return this;
            }

            public final zza zzl(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(str);
                return this;
            }

            public final zza zzm(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzm(str);
                return this;
            }

            public final zza zzn(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzn((String) null);
                return this;
            }

            public final zza zzp(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzp(str);
                return this;
            }

            public final zza zzq(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzq(str);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(j);
                return this;
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(j);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(j);
                return this;
            }

            public final zza zza(int i, zzc.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, (zzc) ((zzhy) zza.zzy()));
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(str);
                return this;
            }

            public final zza zzh(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(j);
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(j);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(j);
                return this;
            }

            public final zza zzl(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(j);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(str);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(j);
                return this;
            }

            public final zza zzg(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(i);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzh(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(i);
                return this;
            }

            public final zza zzi(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(i);
                return this;
            }

            public final zza zza(zzc.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzc) ((zzhy) zza.zzy()));
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(iterable);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(int i, zzk zzk) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, zzk);
                return this;
            }

            public final zza zza(zzk zzk) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzk);
                return this;
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzk) ((zzhy) zza.zzy()));
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(str);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(z);
                return this;
            }

            public final zza zza(zzh.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzh) ((zzhy) zza.zzy()));
                return this;
            }
        }

        static {
            zzg zzg2 = new zzg();
            zzax = zzg2;
            zzhy.zza(zzg.class, zzg2);
        }

        public static zza zzbh() {
            return (zza) zzax.zzbm();
        }

        private final void zzbw() {
            zzig<zzc> zzig = this.zzf;
            if (!zzig.zza()) {
                this.zzf = zzhy.zza(zzig);
            }
        }

        /* access modifiers changed from: private */
        public final void zzbx() {
            this.zzf = zzhy.zzbs();
        }

        private final void zzby() {
            zzig<zzk> zzig = this.zzg;
            if (!zzig.zza()) {
                this.zzg = zzhy.zza(zzig);
            }
        }

        /* access modifiers changed from: private */
        public final void zzbz() {
            this.zzc &= -17;
            this.zzk = 0;
        }

        /* access modifiers changed from: private */
        public final void zzca() {
            this.zzc &= -33;
            this.zzl = 0;
        }

        /* access modifiers changed from: private */
        public final void zzcb() {
            this.zzc &= -65537;
            this.zzw = zzax.zzw;
        }

        /* access modifiers changed from: private */
        public final void zzcc() {
            this.zzc &= -131073;
            this.zzx = false;
        }

        /* access modifiers changed from: private */
        public final void zzcd() {
            this.zzc &= -262145;
            this.zzy = zzax.zzy;
        }

        /* access modifiers changed from: private */
        public final void zzce() {
            this.zzc &= -2097153;
            this.zzab = zzax.zzab;
        }

        /* access modifiers changed from: private */
        public final void zzcf() {
            this.zzae = zzhy.zzbs();
        }

        /* access modifiers changed from: private */
        public final void zzcg() {
            this.zzc &= -268435457;
            this.zzaj = zzax.zzaj;
        }

        /* access modifiers changed from: private */
        public final void zzch() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzax.zzam;
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 1;
            this.zze = 1;
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzbw();
            this.zzf.remove(i);
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzaa() {
            return this.zzu;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        public final String zzad() {
            return this.zzw;
        }

        public final boolean zzae() {
            return (this.zzc & 131072) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        public final String zzag() {
            return this.zzy;
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        public final String zzal() {
            return this.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        public final String zzaq() {
            return this.zzaf;
        }

        public final boolean zzar() {
            return (this.zzc & 33554432) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        public final String zzat() {
            return this.zzaj;
        }

        public final boolean zzau() {
            return (this.zzc & DriveFile.MODE_WRITE_ONLY) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        public final boolean zzaw() {
            return (this.zzc & 1073741824) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        public final String zzay() {
            return this.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        public final int zzba() {
            return this.zzao;
        }

        public final String zzbb() {
            return this.zzap;
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        public final String zzbe() {
            return this.zzau;
        }

        public final boolean zzbf() {
            return (this.zzd & 128) != 0;
        }

        public final String zzbg() {
            return this.zzav;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        public final String zzq() {
            return this.zzm;
        }

        public final String zzr() {
            return this.zzn;
        }

        public final String zzs() {
            return this.zzo;
        }

        public final String zzt() {
            return this.zzp;
        }

        public final boolean zzu() {
            return (this.zzc & 1024) != 0;
        }

        public final int zzv() {
            return this.zzq;
        }

        public final String zzw() {
            return this.zzr;
        }

        public final String zzx() {
            return this.zzs;
        }

        public final String zzy() {
            return this.zzt;
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }

        /* access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        /* access modifiers changed from: private */
        public final void zzf(int i) {
            zzby();
            this.zzg.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zzg(int i) {
            this.zzc |= 1024;
            this.zzq = i;
        }

        /* access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzc |= 4194304;
            this.zzac = str;
        }

        /* access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzc |= 16777216;
            this.zzaf = str;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzc |= DriveFile.MODE_READ_ONLY;
            this.zzaj = str;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzd |= 64;
            this.zzau = str;
        }

        /* access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zzd |= 128;
            this.zzav = str;
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        public final zzk zzb(int i) {
            return this.zzg.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzbw();
            this.zzf.set(i, zzc2);
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzk> iterable) {
            zzby();
            zzgg.zza(iterable, this.zzg);
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzs = str;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzt = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        /* access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzc |= 33554432;
            this.zzag = i;
        }

        /* access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzc |= 1073741824;
            this.zzal = j;
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            zzc2.getClass();
            zzbw();
            this.zzf.add(zzc2);
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzp = str;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzr = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzn = str;
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zza> iterable) {
            zzig<zza> zzig = this.zzae;
            if (!zzig.zza()) {
                this.zzae = zzhy.zza(zzig);
            }
            zzgg.zza(iterable, this.zzae);
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        /* access modifiers changed from: private */
        public final void zzh(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        /* access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzc |= DriveFile.MODE_WRITE_ONLY;
            this.zzak = j;
        }

        /* access modifiers changed from: private */
        public final void zzj(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzbw();
            zzgg.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends Integer> iterable) {
            zzie zzie = this.zzar;
            if (!zzie.zza()) {
                int size = zzie.size();
                this.zzar = zzie.zzb(size == 0 ? 10 : size << 1);
            }
            zzgg.zza(iterable, this.zzar);
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzk zzk2) {
            zzk2.getClass();
            zzby();
            this.zzg.set(i, zzk2);
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk2) {
            zzk2.getClass();
            zzby();
            this.zzg.add(zzk2);
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh2) {
            zzh2.getClass();
            this.zzaq = zzh2;
            this.zzd |= 8;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzax, "\u0001-\u0000\u0002\u00015-\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", zzce.zzb()});
                case 4:
                    return zzax;
                case 5:
                    zzjs<zzg> zzjs = zzay;
                    if (zzjs == null) {
                        synchronized (zzg.class) {
                            zzjs = zzay;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzax);
                                zzay = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzi extends zzhy<zzi, zza> implements zzjl {
        public static final zzi zzg;
        public static volatile zzjs<zzi> zzh;
        public zzih zzc = zzhy.zzbr();
        public zzih zzd = zzhy.zzbr();
        public zzig<zzb> zze = zzhy.zzbs();
        public zzig<zzj> zzf = zzhy.zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzi, zza> implements zzjl {
            public zza() {
                super(zzi.zzg);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(iterable);
                return this;
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzm();
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(i);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zze(i);
                return this;
            }
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzhy.zza(zzi.class, zzi);
        }

        public static zza zzi() {
            return (zza) zzg.zzbm();
        }

        public static zzi zzj() {
            return zzg;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc = zzhy.zzbr();
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzhy.zzbr();
        }

        private final void zzn() {
            zzig<zzb> zzig = this.zze;
            if (!zzig.zza()) {
                this.zze = zzhy.zza(zzig);
            }
        }

        private final void zzo() {
            zzig<zzj> zzig = this.zzf;
            if (!zzig.zza()) {
                this.zzf = zzhy.zza(zzig);
            }
        }

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzih zzih = this.zzc;
            if (!zzih.zza()) {
                this.zzc = zzhy.zza(zzih);
            }
            zzgg.zza(iterable, this.zzc);
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends Long> iterable) {
            zzih zzih = this.zzd;
            if (!zzih.zza()) {
                this.zzd = zzhy.zza(zzih);
            }
            zzgg.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzb> iterable) {
            zzn();
            zzgg.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            zzn();
            this.zze.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzo();
            this.zzf.remove(i);
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzj> iterable) {
            zzo();
            zzgg.zza(iterable, this.zzf);
        }

        public final zzb zza(int i) {
            return this.zze.get(i);
        }

        public final zzj zzb(int i) {
            return this.zzf.get(i);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzjs<zzi> zzjs = zzh;
                    if (zzjs == null) {
                        synchronized (zzi.class) {
                            zzjs = zzh;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzg);
                                zzh = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzj extends zzhy<zzj, zza> implements zzjl {
        public static final zzj zzf;
        public static volatile zzjs<zzj> zzg;
        public int zzc;
        public int zzd;
        public zzih zze = zzhy.zzbr();

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzj, zza> implements zzjl {
            public zza() {
                super(zzj.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(i);
                return this;
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zzj zzj = new zzj();
            zzf = zzj;
            zzhy.zza(zzj.class, zzj);
        }

        public static zza zze() {
            return (zza) zzf.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzih zzih = this.zze;
            if (!zzih.zza()) {
                this.zze = zzhy.zza(zzih);
            }
            zzgg.zza(iterable, this.zze);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzj> zzjs = zzg;
                    if (zzjs == null) {
                        synchronized (zzj.class) {
                            zzjs = zzg;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzf);
                                zzg = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzk extends zzhy<zzk, zza> implements zzjl {
        public static final zzk zzj;
        public static volatile zzjs<zzk> zzk;
        public int zzc;
        public long zzd;
        public String zze = "";
        public String zzf = "";
        public long zzg;
        public float zzh;
        public double zzi;

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzk, zza> implements zzjl {
            public zza() {
                super(zzk.zzj);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(j);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzn();
                return this;
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(j);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzl();
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzm();
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(d);
                return this;
            }
        }

        static {
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzhy.zza(zzk.class, zzk2);
        }

        public static zza zzj() {
            return (zza) zzj.zzbm();
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -9;
            this.zzg = 0;
        }

        /* access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -33;
            this.zzi = RoundRectDrawableWithShadow.COS_45;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 32;
            this.zzi = d;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjs<zzk> zzjs = zzk;
                    if (zzjs == null) {
                        synchronized (zzk.class) {
                            zzjs = zzk;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzj);
                                zzk = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzd extends zzhy<zzd, zza> implements zzjl {
        public static final zzd zzf;
        public static volatile zzjs<zzd> zzg;
        public int zzc;
        public String zzd = "";
        public long zze;

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzd, zza> implements zzjl {
            public zza() {
                super(zzd.zzf);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(str);
                return this;
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(j);
                return this;
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzhy.zza(zzd.class, zzd2);
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zza() {
            return (zza) zzf.zzbm();
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzd> zzjs = zzg;
                    if (zzjs == null) {
                        synchronized (zzd.class) {
                            zzjs = zzg;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzf);
                                zzg = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zzh extends zzhy<zzh, zza> implements zzjl {
        public static final zzh zzf;
        public static volatile zzjs<zzh> zzg;
        public int zzc;
        public int zzd = 1;
        public zzig<zzd> zze = zzhy.zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzh, zza> implements zzjl {
            public zza() {
                super(zzh.zzf);
            }

            public final zza zza(zzd.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza((zzd) ((zzhy) zza.zzy()));
                return this;
            }

            public /* synthetic */ zza(zzcf zzcf) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public enum zzb implements zzid {
            RADS(1),
            PROVISIONING(2);
            
            public static final zzic<zzb> zzc = null;
            public final int zzd;

            /* access modifiers changed from: public */
            static {
                zzc = new zzci();
            }

            /* access modifiers changed from: public */
            zzb(int i) {
                this.zzd = i;
            }

            public static zzif zzb() {
                return zzcj.zza;
            }

            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zzd;
            }

            public static zzb zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }
        }

        static {
            zzh zzh = new zzh();
            zzf = zzh;
            zzhy.zza(zzh.class, zzh);
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            zzd2.getClass();
            zzig<zzd> zzig = this.zze;
            if (!zzig.zza()) {
                this.zze = zzhy.zza(zzig);
            }
            this.zze.add(zzd2);
        }

        public static zza zza() {
            return (zza) zzf.zzbm();
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcf.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzcf) null);
                case 3:
                    return zzhy.zza((zzjj) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzh> zzjs = zzg;
                    if (zzjs == null) {
                        synchronized (zzh.class) {
                            zzjs = zzg;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzf);
                                zzg = zzjs;
                            }
                        }
                    }
                    return zzjs;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
