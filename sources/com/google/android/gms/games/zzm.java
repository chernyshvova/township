package com.google.android.gms.games;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.games.internal.zzl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzm implements Api.ApiOptions.Optional, GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions {
    public final boolean zza = false;
    public final boolean zzb = true;
    public final int zzc = 17;
    public final boolean zzd = false;
    public final int zze;
    public final String zzf;
    public final ArrayList<String> zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final boolean zzj;
    public final GoogleSignInAccount zzk;
    public final String zzl;
    public final int zzm;
    @Nullable
    public final String zzn;
    public final zzl zzo;
    public final int zzp;

    public /* synthetic */ zzm(boolean z, boolean z2, int i, boolean z3, int i2, String str, ArrayList arrayList, boolean z4, boolean z5, boolean z6, GoogleSignInAccount googleSignInAccount, String str2, int i3, int i4, String str3, zzl zzl2, zzl zzl3) {
        this.zze = i2;
        this.zzf = null;
        this.zzg = arrayList;
        this.zzh = false;
        this.zzi = false;
        this.zzj = false;
        this.zzk = googleSignInAccount;
        this.zzl = null;
        this.zzp = 0;
        this.zzm = 9;
        this.zzn = str3;
        this.zzo = zzl2;
    }

    public static zzk zzb() {
        return new zzk((zzj) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r1 = r4.zzk;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.games.zzm
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.google.android.gms.games.zzm r5 = (com.google.android.gms.games.zzm) r5
            boolean r1 = r5.zza
            int r1 = r4.zze
            int r3 = r5.zze
            if (r1 != r3) goto L_0x0042
            java.util.ArrayList<java.lang.String> r1 = r4.zzg
            java.util.ArrayList<java.lang.String> r3 = r5.zzg
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0042
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r4.zzk
            if (r1 != 0) goto L_0x0027
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r1 = r5.zzk
            if (r1 != 0) goto L_0x0042
            goto L_0x0030
        L_0x0027:
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r3 = r5.zzk
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0030
            goto L_0x0042
        L_0x0030:
            r1 = 0
            boolean r1 = android.text.TextUtils.equals(r1, r1)
            if (r1 == 0) goto L_0x0042
            java.lang.String r1 = r4.zzn
            java.lang.String r5 = r5.zzn
            boolean r5 = com.google.android.gms.common.internal.Objects.equal(r1, r5)
            if (r5 == 0) goto L_0x0042
            return r0
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.zzm.equals(java.lang.Object):boolean");
    }

    public final int getExtensionType() {
        return 1;
    }

    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzk;
    }

    public final List<Scope> getImpliedScopes() {
        return Collections.singletonList(Games.zzc);
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.zzg.hashCode() + ((this.zze + 486741695) * 961)) * 923521;
        GoogleSignInAccount googleSignInAccount = this.zzk;
        int i2 = 0;
        if (googleSignInAccount == null) {
            i = 0;
        } else {
            i = googleSignInAccount.hashCode();
        }
        int i3 = (((hashCode + i) * 29791) + 9) * 31;
        String str = this.zzn;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i3 + i2;
    }

    public final Bundle toBundle() {
        return zza();
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", true);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", 17);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zze);
        bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", (String) null);
        bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzg);
        bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipPgaCheck", false);
        bundle.putBoolean("com.google.android.gms.games.key.skipWelcomePopup", false);
        bundle.putParcelable("com.google.android.gms.games.key.googleSignInAccount", this.zzk);
        bundle.putString("com.google.android.gms.games.key.realClientPackageName", (String) null);
        bundle.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        bundle.putString("com.google.android.gms.games.key.gameRunToken", this.zzn);
        return bundle;
    }
}
