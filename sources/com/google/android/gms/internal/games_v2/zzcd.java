package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzcd implements AchievementsClient {
    public final zzar zza;

    public zzcd(zzar zzar) {
        this.zza = zzar;
    }

    public final Task<Intent> getAchievementsIntent() {
        return this.zza.zzb(zzbu.zza);
    }

    public final void increment(@NonNull String str, int i) {
        this.zza.zzb(new zzbr(str, i));
    }

    public final Task<Boolean> incrementImmediate(@NonNull String str, int i) {
        return this.zza.zzb(new zzbr(str, i));
    }

    public final Task<AnnotatedData<AchievementBuffer>> load(boolean z) {
        return this.zza.zzb(new zzbt(z));
    }

    public final void reveal(@NonNull String str) {
        this.zza.zzb(new zzcb(str));
    }

    public final Task<Void> revealImmediate(@NonNull String str) {
        return this.zza.zzb(new zzcb(str));
    }

    public final void setSteps(@NonNull String str, int i) {
        this.zza.zzb(new zzbs(str, i));
    }

    public final Task<Boolean> setStepsImmediate(@NonNull String str, int i) {
        return this.zza.zzb(new zzbs(str, i));
    }

    public final void unlock(@NonNull String str) {
        this.zza.zzb(new zzcc(str));
    }

    public final Task<Void> unlockImmediate(@NonNull String str) {
        return this.zza.zzb(new zzcc(str));
    }
}
