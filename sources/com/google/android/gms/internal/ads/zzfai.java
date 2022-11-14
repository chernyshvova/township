package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfai implements zzfah {
    @GuardedBy("this")
    public final ConcurrentHashMap<zzfar, zzfag> zza;
    public final zzfao zzb;
    public final zzfak zzc = new zzfak();

    public zzfai(zzfao zzfao) {
        this.zza = new ConcurrentHashMap<>(zzfao.zzd);
        this.zzb = zzfao;
    }

    private final void zzf() {
        Parcelable.Creator<zzfao> creator = zzfao.CREATOR;
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzeD)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzg());
            int i = 0;
            for (Map.Entry next : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(next.getValue());
                sb.append("#");
                sb.append(((zzfar) next.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfag) next.getValue()).zzc(); i2++) {
                    sb.append("[O]");
                }
                for (int zzc2 = ((zzfag) next.getValue()).zzc(); zzc2 < this.zzb.zzd; zzc2++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfag) next.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzcgs.zzd(sb.toString());
        }
    }

    @Nullable
    public final synchronized zzfaq<?, ?> zza(zzfar zzfar) {
        zzfaq<?, ?> zzfaq;
        zzfag zzfag = this.zza.get(zzfar);
        if (zzfag != null) {
            zzfaq = zzfag.zzb();
            if (zzfaq == null) {
                this.zzc.zzb();
            }
            zzfbe zzh = zzfag.zzh();
            if (zzfaq != null) {
                zzazm zza2 = zzazu.zza();
                zzazk zza3 = zzazl.zza();
                zza3.zza(zzazp.IN_MEMORY);
                zzazq zza4 = zzazr.zza();
                zza4.zza(zzh.zza);
                zza4.zzb(zzh.zzb);
                zza3.zzb(zza4);
                zza2.zza(zza3);
                zzfaq.zza.zzc().zzd().zzk((zzazu) zza2.zzah());
            }
            zzf();
        } else {
            this.zzc.zza();
            zzf();
            zzfaq = null;
        }
        return zzfaq;
    }

    public final synchronized boolean zzb(zzfar zzfar, zzfaq<?, ?> zzfaq) {
        boolean zza2;
        zzfag zzfag = this.zza.get(zzfar);
        zzfaq.zzd = zzs.zzj().currentTimeMillis();
        if (zzfag == null) {
            zzfao zzfao = this.zzb;
            zzfag = new zzfag(zzfao.zzd, zzfao.zze * 1000);
            int size = this.zza.size();
            zzfao zzfao2 = this.zzb;
            if (size == zzfao2.zzc) {
                int i = zzfao2.zzg;
                int i2 = i - 1;
                zzfar zzfar2 = null;
                if (i != 0) {
                    long j = RecyclerView.FOREVER_NS;
                    if (i2 == 0) {
                        for (Map.Entry next : this.zza.entrySet()) {
                            if (((zzfag) next.getValue()).zzd() < j) {
                                j = ((zzfag) next.getValue()).zzd();
                                zzfar2 = (zzfar) next.getKey();
                            }
                        }
                        if (zzfar2 != null) {
                            this.zza.remove(zzfar2);
                        }
                    } else if (i2 == 1) {
                        for (Map.Entry next2 : this.zza.entrySet()) {
                            if (((zzfag) next2.getValue()).zze() < j) {
                                j = ((zzfag) next2.getValue()).zze();
                                zzfar2 = (zzfar) next2.getKey();
                            }
                        }
                        if (zzfar2 != null) {
                            this.zza.remove(zzfar2);
                        }
                    } else if (i2 == 2) {
                        int i3 = Integer.MAX_VALUE;
                        for (Map.Entry next3 : this.zza.entrySet()) {
                            if (((zzfag) next3.getValue()).zzf() < i3) {
                                i3 = ((zzfag) next3.getValue()).zzf();
                                zzfar2 = (zzfar) next3.getKey();
                            }
                        }
                        if (zzfar2 != null) {
                            this.zza.remove(zzfar2);
                        }
                    }
                    this.zzc.zzd();
                } else {
                    throw null;
                }
            }
            this.zza.put(zzfar, zzfag);
            this.zzc.zzc();
        }
        zza2 = zzfag.zza(zzfaq);
        this.zzc.zze();
        zzfaj zzf = this.zzc.zzf();
        zzfbe zzh = zzfag.zzh();
        zzazm zza3 = zzazu.zza();
        zzazk zza4 = zzazl.zza();
        zza4.zza(zzazp.IN_MEMORY);
        zzazs zza5 = zzazt.zza();
        zza5.zza(zzf.zza);
        zza5.zzb(zzf.zzb);
        zza5.zzc(zzh.zzb);
        zza4.zzc(zza5);
        zza3.zza(zza4);
        zzfaq.zza.zzc().zzd().zzl((zzazu) zza3.zzah());
        zzf();
        return zza2;
    }

    public final synchronized boolean zzc(zzfar zzfar) {
        zzfag zzfag = this.zza.get(zzfar);
        if (zzfag == null) {
            return true;
        }
        if (zzfag.zzc() < this.zzb.zzd) {
            return true;
        }
        return false;
    }

    @Deprecated
    public final zzfar zzd(zzbdk zzbdk, String str, zzbdv zzbdv) {
        return new zzfas(zzbdk, str, new zzcbo(this.zzb.zza).zza().zzk, this.zzb.zzf, zzbdv);
    }

    public final zzfao zze() {
        return this.zzb;
    }
}
