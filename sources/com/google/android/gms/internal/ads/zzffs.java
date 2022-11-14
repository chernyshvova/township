package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffs {
    public final HashMap<View, String> zza = new HashMap<>();
    public final HashMap<View, zzffr> zzb = new HashMap<>();
    public final HashMap<String, View> zzc = new HashMap<>();
    public final HashSet<View> zzd = new HashSet<>();
    public final HashSet<String> zze = new HashSet<>();
    public final HashSet<String> zzf = new HashSet<>();
    public final HashMap<String, String> zzg = new HashMap<>();
    public boolean zzh;

    public final HashSet<String> zza() {
        return this.zze;
    }

    public final HashSet<String> zzb() {
        return this.zzf;
    }

    public final String zzc(String str) {
        return this.zzg.get(str);
    }

    public final void zzd() {
        zzfew zza2 = zzfew.zza();
        if (zza2 != null) {
            for (zzfel next : zza2.zzf()) {
                View zzj = next.zzj();
                if (next.zzk()) {
                    String zzi = next.zzi();
                    if (zzj != null) {
                        String str = null;
                        if (!zzj.hasWindowFocus()) {
                            str = "noWindowFocus";
                        } else {
                            HashSet hashSet = new HashSet();
                            View view = zzj;
                            while (true) {
                                if (view == null) {
                                    this.zzd.addAll(hashSet);
                                    break;
                                }
                                String zzb2 = zzffq.zzb(view);
                                if (zzb2 != null) {
                                    str = zzb2;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        }
                        if (str == null) {
                            this.zze.add(zzi);
                            this.zza.put(zzj, zzi);
                            for (zzfez next2 : next.zzg()) {
                                View view2 = (View) next2.zza().get();
                                if (view2 != null) {
                                    zzffr zzffr = this.zzb.get(view2);
                                    if (zzffr != null) {
                                        zzffr.zza(next.zzi());
                                    } else {
                                        this.zzb.put(view2, new zzffr(next2, next.zzi()));
                                    }
                                }
                            }
                        } else {
                            this.zzf.add(zzi);
                            this.zzc.put(zzi, zzj);
                            this.zzg.put(zzi, str);
                        }
                    } else {
                        this.zzf.add(zzi);
                        this.zzg.put(zzi, "noAdView");
                    }
                }
            }
        }
    }

    public final void zze() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzh = false;
    }

    public final void zzf() {
        this.zzh = true;
    }

    public final String zzg(View view) {
        if (this.zza.size() == 0) {
            return null;
        }
        String str = this.zza.get(view);
        if (str != null) {
            this.zza.remove(view);
        }
        return str;
    }

    public final View zzh(String str) {
        return this.zzc.get(str);
    }

    public final zzffr zzi(View view) {
        zzffr zzffr = this.zzb.get(view);
        if (zzffr != null) {
            this.zzb.remove(view);
        }
        return zzffr;
    }

    public final int zzj(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzh ? 2 : 3;
    }
}
