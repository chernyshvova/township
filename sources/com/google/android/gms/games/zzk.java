package com.google.android.gms.games;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.internal.zzl;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzk {
    public static final AtomicInteger zzf = new AtomicInteger(0);
    public int zza;
    public final ArrayList<String> zzb;
    public GoogleSignInAccount zzc;
    @Nullable
    public String zzd;
    public zzl zze;

    public zzk() {
        this.zza = 4368;
        this.zzb = new ArrayList<>();
        this.zzc = null;
        this.zzd = null;
        throw null;
    }

    public final zzk zza(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    public final zzk zzb(zzl zzl) {
        this.zze = (zzl) Preconditions.checkNotNull(zzl);
        return this;
    }

    public final zzk zzc(@NonNull GoogleSignInAccount googleSignInAccount) {
        this.zzc = googleSignInAccount;
        return this;
    }

    public final zzk zzd(int i) {
        this.zza = 2101523;
        return this;
    }

    public final zzm zze() {
        return new zzm(false, true, 17, false, this.zza, (String) null, this.zzb, false, false, false, this.zzc, (String) null, 0, 9, this.zzd, this.zze, (zzl) null);
    }

    public /* synthetic */ zzk(zzj zzj) {
        this.zza = 4368;
        this.zzb = new ArrayList<>();
        this.zzc = null;
        this.zzd = null;
        this.zze = zzl.zza;
    }
}
