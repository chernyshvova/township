package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfel extends zzfeh {
    public static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    public final zzfej zzb;
    public final zzfei zzc;
    public final List<zzfez> zzd = new ArrayList();
    public zzfgg zze;
    public zzffj zzf;
    public boolean zzg = false;
    public boolean zzh = false;
    public final String zzi;

    public zzfel(zzfei zzfei, zzfej zzfej) {
        this.zzc = zzfei;
        this.zzb = zzfej;
        this.zzi = UUID.randomUUID().toString();
        zzl((View) null);
        if (zzfej.zzj() == zzfek.HTML || zzfej.zzj() == zzfek.JAVASCRIPT) {
            this.zzf = new zzffk(zzfej.zzg());
        } else {
            this.zzf = new zzffm(zzfej.zzf(), (String) null);
        }
        this.zzf.zza();
        zzfew.zza().zzb(this);
        zzffc.zza().zzb(this.zzf.zzd(), zzfei.zzc());
    }

    private final void zzl(View view) {
        this.zze = new zzfgg(view);
    }

    public final void zza() {
        if (!this.zzg) {
            this.zzg = true;
            zzfew.zza().zzc(this);
            this.zzf.zzj(zzffd.zza().zzf());
            this.zzf.zzh(this, this.zzb);
        }
    }

    public final void zzb(View view) {
        if (!this.zzh && zzj() != view) {
            zzl(view);
            this.zzf.zzk();
            Collection<zzfel> zze2 = zzfew.zza().zze();
            if (zze2 != null && zze2.size() > 0) {
                for (zzfel next : zze2) {
                    if (next != this && next.zzj() == view) {
                        next.zze.clear();
                    }
                }
            }
        }
    }

    public final void zzc() {
        if (!this.zzh) {
            this.zze.clear();
            if (!this.zzh) {
                this.zzd.clear();
            }
            this.zzh = true;
            zzffc.zza().zzd(this.zzf.zzd());
            zzfew.zza().zzd(this);
            this.zzf.zzb();
            this.zzf = null;
        }
    }

    public final void zzd(View view, zzfen zzfen, @Nullable String str) {
        zzfez zzfez;
        if (this.zzh) {
            return;
        }
        if (str == null || (str.length() <= 50 && zza.matcher(str).matches())) {
            Iterator<zzfez> it = this.zzd.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzfez = null;
                    break;
                }
                zzfez = it.next();
                if (zzfez.zza().get() == view) {
                    break;
                }
            }
            if (zzfez == null) {
                this.zzd.add(new zzfez(view, zzfen, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
    }

    @Deprecated
    public final void zze(View view) {
        zzd(view, zzfen.OTHER, (String) null);
    }

    public final List<zzfez> zzg() {
        return this.zzd;
    }

    public final zzffj zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zzi;
    }

    public final View zzj() {
        return (View) this.zze.get();
    }

    public final boolean zzk() {
        return this.zzg && !this.zzh;
    }
}
