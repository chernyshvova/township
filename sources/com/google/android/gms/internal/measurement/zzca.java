package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzhy;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzca {

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zza extends zzhy<zza, C3367zza> implements zzjl {
        public static final zza zzh;
        public static volatile zzjs<zza> zzi;
        public int zzc;
        public String zzd = "";
        public boolean zze;
        public boolean zzf;
        public int zzg;

        /* renamed from: com.google.android.gms.internal.measurement.zzca$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class C3367zza extends zzhy.zzb<zza, C3367zza> implements zzjl {
            public C3367zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            public /* synthetic */ C3367zza(zzcc zzcc) {
                this();
            }

            public final C3367zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzh = zza;
            zzhy.zza(zza.class, zza);
        }

        public final String zza() {
            return this.zzd;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcc.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3367zza((zzcc) null);
                case 3:
                    return zzhy.zza((zzjj) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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
        public static final zzb zzm;
        public static volatile zzjs<zzb> zzn;
        public int zzc;
        public long zzd;
        public String zze = "";
        public int zzf;
        public zzig<zzc> zzg = zzhy.zzbs();
        public zzig<zza> zzh = zzhy.zzbs();
        public zzig<zzbv.zza> zzi = zzhy.zzbs();
        public String zzj = "";
        public boolean zzk;
        public zzig<zzck.zzc> zzl = zzhy.zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzb, zza> implements zzjl {
            public zza() {
                super(zzb.zzm);
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final List<zzbv.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }

            public /* synthetic */ zza(zzcc zzcc) {
                this();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C3367zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) ((zzhy) zza.zzy()));
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzm = zzb;
            zzhy.zza(zzb.class, zzb);
        }

        public static zza zzi() {
            return (zza) zzm.zzbm();
        }

        public static zzb zzj() {
            return zzm;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzhy.zzbs();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final List<zzbv.zza> zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public final zza zza(int i) {
            return this.zzh.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zza zza2) {
            zza2.getClass();
            zzig<zza> zzig = this.zzh;
            if (!zzig.zza()) {
                this.zzh = zzhy.zza(zzig);
            }
            this.zzh.set(i, zza2);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcc.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzcc) null);
                case 3:
                    return zzhy.zza((zzjj) zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbv.zza.class, "zzj", "zzk", "zzl", zzck.zzc.class});
                case 4:
                    return zzm;
                case 5:
                    zzjs<zzb> zzjs = zzn;
                    if (zzjs == null) {
                        synchronized (zzb.class) {
                            zzjs = zzn;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzm);
                                zzn = zzjs;
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
        public static final zzc zzf;
        public static volatile zzjs<zzc> zzg;
        public int zzc;
        public String zzd = "";
        public String zze = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzc, zza> implements zzjl {
            public zza() {
                super(zzc.zzf);
            }

            public /* synthetic */ zza(zzcc zzcc) {
                this();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzf = zzc2;
            zzhy.zza(zzc.class, zzc2);
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzcc.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzcc) null);
                case 3:
                    return zzhy.zza((zzjj) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjs<zzc> zzjs = zzg;
                    if (zzjs == null) {
                        synchronized (zzc.class) {
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
