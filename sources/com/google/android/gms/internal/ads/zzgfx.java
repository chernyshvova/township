package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgfx {
    public final ArrayDeque<zzgcz> zza = new ArrayDeque<>();

    public zzgfx() {
    }

    public static /* synthetic */ zzgcz zza(zzgfx zzgfx, zzgcz zzgcz, zzgcz zzgcz2) {
        zzgfx.zzb(zzgcz);
        zzgfx.zzb(zzgcz2);
        zzgcz pop = zzgfx.zza.pop();
        while (!zzgfx.zza.isEmpty()) {
            pop = new zzgfz(zzgfx.zza.pop(), pop, (zzgfw) null);
        }
        return pop;
    }

    private final void zzb(zzgcz zzgcz) {
        if (zzgcz.zzg()) {
            int zzc = zzc(zzgcz.zzc());
            int zzh = zzgfz.zzh(zzc + 1);
            if (this.zza.isEmpty() || this.zza.peek().zzc() >= zzh) {
                this.zza.push(zzgcz);
                return;
            }
            int zzh2 = zzgfz.zzh(zzc);
            zzgcz pop = this.zza.pop();
            while (!this.zza.isEmpty() && this.zza.peek().zzc() < zzh2) {
                pop = new zzgfz(this.zza.pop(), pop, (zzgfw) null);
            }
            zzgfz zzgfz = new zzgfz(pop, zzgcz, (zzgfw) null);
            while (!this.zza.isEmpty() && this.zza.peek().zzc() < zzgfz.zzh(zzc(zzgfz.zzc()) + 1)) {
                zzgfz = new zzgfz(this.zza.pop(), zzgfz, (zzgfw) null);
            }
            this.zza.push(zzgfz);
        } else if (zzgcz instanceof zzgfz) {
            zzgfz zzgfz2 = (zzgfz) zzgcz;
            zzb(zzgfz2.zzd);
            zzb(zzgfz2.zze);
        } else {
            String valueOf = String.valueOf(zzgcz.getClass());
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 49), "Has a new type of ByteString been created? Found ", valueOf));
        }
    }

    public static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzgfz.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ zzgfx(zzgfw zzgfw) {
    }
}
