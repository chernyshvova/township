package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzbv {

    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class zza extends zzhy<zza, C3366zza> implements zzjl {
        public static final zza zzi;
        public static volatile zzjs<zza> zzj;
        public int zzc;
        public int zzd;
        public zzig<zze> zze = zzhy.zzbs();
        public zzig<zzb> zzf = zzhy.zzbs();
        public boolean zzg;
        public boolean zzh;

        /* renamed from: com.google.android.gms.internal.measurement.zzbv$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class C3366zza extends zzhy.zzb<zza, C3366zza> implements zzjl {
            public C3366zza() {
                super(zza.zzi);
            }

            public final int zza() {
                return ((zza) this.zza).zzd();
            }

            public final int zzb() {
                return ((zza) this.zza).zzf();
            }

            public /* synthetic */ C3366zza(zzbw zzbw) {
                this();
            }

            public final zze zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final zzb zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            public final C3366zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zze) ((zzhy) zza.zzy()));
                return this;
            }

            public final C3366zza zza(int i, zzb.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zzb) ((zzhy) zza.zzy()));
                return this;
            }
        }

        static {
            zza zza = new zza();
            zzi = zza;
            zzhy.zza(zza.class, zza);
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<zze> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final List<zzb> zze() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzf.size();
        }

        public final zze zza(int i) {
            return this.zze.get(i);
        }

        public final zzb zzb(int i) {
            return this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            zze2.getClass();
            zzig<zze> zzig = this.zze;
            if (!zzig.zza()) {
                this.zze = zzhy.zza(zzig);
            }
            this.zze.set(i, zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzb zzb) {
            zzb.getClass();
            zzig<zzb> zzig = this.zzf;
            if (!zzig.zza()) {
                this.zzf = zzhy.zza(zzig);
            }
            this.zzf.set(i, zzb);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3366zza((zzbw) null);
                case 3:
                    return zzhy.zza((zzjj) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001???\u0000\u0002\u001b\u0003\u001b\u0004???\u0001\u0005???\u0002", new Object[]{"zzc", "zzd", "zze", zze.class, "zzf", zzb.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjs<zza> zzjs = zzj;
                    if (zzjs == null) {
                        synchronized (zza.class) {
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
    public static final class zzb extends zzhy<zzb, zza> implements zzjl {
        public static final zzb zzl;
        public static volatile zzjs<zzb> zzm;
        public int zzc;
        public int zzd;
        public String zze = "";
        public zzig<zzc> zzf = zzhy.zzbs();
        public boolean zzg;
        public zzd zzh;
        public boolean zzi;
        public boolean zzj;
        public boolean zzk;

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzb, zza> implements zzjl {
            public zza() {
                super(zzb.zzl);
            }

            public final String zza() {
                return ((zzb) this.zza).zzc();
            }

            public final int zzb() {
                return ((zzb) this.zza).zze();
            }

            public /* synthetic */ zza(zzbw zzbw) {
                this();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(str);
                return this;
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zzc zzc) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, zzc);
                return this;
            }
        }

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzhy.zza(zzb.class, zzb);
        }

        public static zza zzl() {
            return (zza) zzl.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final List<zzc> zzd() {
            return this.zzf;
        }

        public final int zze() {
            return this.zzf.size();
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final zzd zzg() {
            zzd zzd2 = this.zzh;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public final boolean zzi() {
            return this.zzj;
        }

        public final boolean zzj() {
            return (this.zzc & 64) != 0;
        }

        public final boolean zzk() {
            return this.zzk;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final zzc zza(int i) {
            return this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzig<zzc> zzig = this.zzf;
            if (!zzig.zza()) {
                this.zzf = zzhy.zza(zzig);
            }
            this.zzf.set(i, zzc2);
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zzhy.zza((zzjj) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001???\u0000\u0002???\u0001\u0003\u001b\u0004???\u0002\u0005???\u0003\u0006???\u0004\u0007???\u0005\b???\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzjs<zzb> zzjs = zzm;
                    if (zzjs == null) {
                        synchronized (zzb.class) {
                            zzjs = zzm;
                            if (zzjs == null) {
                                zzjs = new zzhy.zza<>(zzl);
                                zzm = zzjs;
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
        public static final zzc zzh;
        public static volatile zzjs<zzc> zzi;
        public int zzc;
        public zzf zzd;
        public zzd zze;
        public boolean zzf;
        public String zzg = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzc, zza> implements zzjl {
            public zza() {
                super(zzc.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            public /* synthetic */ zza(zzbw zzbw) {
                this();
            }
        }

        static {
            zzc zzc2 = new zzc();
            zzh = zzc2;
            zzhy.zza(zzc.class, zzc2);
        }

        public static zzc zzi() {
            return zzh;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzf zzb() {
            zzf zzf2 = this.zzd;
            return zzf2 == null ? zzf.zzi() : zzf2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final zzd zzd() {
            zzd zzd2 = this.zze;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zzhy.zza((zzjj) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001???\u0000\u0002???\u0001\u0003???\u0002\u0004???\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjs<zzc> zzjs = zzi;
                    if (zzjs == null) {
                        synchronized (zzc.class) {
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
    public static final class zzd extends zzhy<zzd, zzb> implements zzjl {
        public static final zzd zzi;
        public static volatile zzjs<zzd> zzj;
        public int zzc;
        public int zzd;
        public boolean zze;
        public String zzf = "";
        public String zzg = "";
        public String zzh = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public enum zza implements zzid {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);
            
            public static final zzic<zza> zzf = null;
            public final int zzg;

            /* access modifiers changed from: public */
            static {
                zzf = new zzby();
            }

            /* access modifiers changed from: public */
            zza(int i) {
                this.zzg = i;
            }

            public static zzif zzb() {
                return zzbx.zza;
            }

            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zzg;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zzb extends zzhy.zzb<zzd, zzb> implements zzjl {
            public zzb() {
                super(zzd.zzi);
            }

            public /* synthetic */ zzb(zzbw zzbw) {
                this();
            }
        }

        static {
            zzd zzd2 = new zzd();
            zzi = zzd2;
            zzhy.zza(zzd.class, zzd2);
        }

        public static zzd zzk() {
            return zzi;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zza zzb() {
            zza zza2 = zza.zza(this.zzd);
            return zza2 == null ? zza.UNKNOWN_COMPARISON_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final boolean zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final String zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final String zzj() {
            return this.zzh;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb((zzbw) null);
                case 3:
                    return zzhy.zza((zzjj) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001???\u0000\u0002???\u0001\u0003???\u0002\u0004???\u0003\u0005???\u0004", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjs<zzd> zzjs = zzj;
                    if (zzjs == null) {
                        synchronized (zzd.class) {
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
        public int zzd;
        public String zze = "";
        public zzc zzf;
        public boolean zzg;
        public boolean zzh;
        public boolean zzi;

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

            public /* synthetic */ zza(zzbw zzbw) {
                this();
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzhy.zza(zze.class, zze2);
        }

        public static zza zzi() {
            return (zza) zzj.zzbm();
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final zzc zzd() {
            zzc zzc2 = this.zzf;
            return zzc2 == null ? zzc.zzi() : zzc2;
        }

        public final boolean zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zzc & 32) != 0;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zzhy.zza((zzjj) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001???\u0000\u0002???\u0001\u0003???\u0002\u0004???\u0003\u0005???\u0004\u0006???\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjs<zze> zzjs = zzk;
                    if (zzjs == null) {
                        synchronized (zze.class) {
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
        public static final zzf zzh;
        public static volatile zzjs<zzf> zzi;
        public int zzc;
        public int zzd;
        public String zze = "";
        public boolean zzf;
        public zzig<String> zzg = zzhy.zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public static final class zza extends zzhy.zzb<zzf, zza> implements zzjl {
            public zza() {
                super(zzf.zzh);
            }

            public /* synthetic */ zza(zzbw zzbw) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
        public enum zzb implements zzid {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);
            
            public static final zzic<zzb> zzh = null;
            public final int zzi;

            /* access modifiers changed from: public */
            static {
                zzh = new zzbz();
            }

            /* access modifiers changed from: public */
            zzb(int i) {
                this.zzi = i;
            }

            public static zzif zzb() {
                return zzcb.zza;
            }

            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zzi;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }
        }

        static {
            zzf zzf2 = new zzf();
            zzh = zzf2;
            zzhy.zza(zzf.class, zzf2);
        }

        public static zzf zzi() {
            return zzh;
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzb zzb() {
            zzb zza2 = zzb.zza(this.zzd);
            return zza2 == null ? zzb.UNKNOWN_MATCH_TYPE : zza2;
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

        public final boolean zzf() {
            return this.zzf;
        }

        public final List<String> zzg() {
            return this.zzg;
        }

        public final int zzh() {
            return this.zzg.size();
        }

        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zzhy.zza((zzjj) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001???\u0000\u0002???\u0001\u0003???\u0002\u0004\u001a", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjs<zzf> zzjs = zzi;
                    if (zzjs == null) {
                        synchronized (zzf.class) {
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
}
