package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zad();
    @RecentlyNonNull
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(zad, new Scope[0]).build();
    @RecentlyNonNull
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zaa = new Scope(Scopes.PROFILE);
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zab = new Scope("email");
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zac = new Scope("openid");
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zad = new Scope(Scopes.GAMES_LITE);
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zae = new Scope(Scopes.GAMES);
    public static Comparator<Scope> zaq = new zac();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zaf;
    @SafeParcelable.Field(getter = "getScopes", mo17147id = 2)
    public final ArrayList<Scope> zag;
    @SafeParcelable.Field(getter = "getAccount", mo17147id = 3)
    @Nullable
    public Account zah;
    @SafeParcelable.Field(getter = "isIdTokenRequested", mo17147id = 4)
    public boolean zai;
    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", mo17147id = 5)
    public final boolean zaj;
    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", mo17147id = 6)
    public final boolean zak;
    @SafeParcelable.Field(getter = "getServerClientId", mo17147id = 7)
    @Nullable
    public String zal;
    @SafeParcelable.Field(getter = "getHostedDomain", mo17147id = 8)
    @Nullable
    public String zam;
    @SafeParcelable.Field(getter = "getExtensions", mo17147id = 9)
    public ArrayList<GoogleSignInOptionsExtensionParcelable> zan;
    @SafeParcelable.Field(getter = "getLogSessionId", mo17147id = 10)
    @Nullable
    public String zao;
    public Map<Integer, GoogleSignInOptionsExtensionParcelable> zap;

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class Builder {
        public Set<Scope> zaa = new HashSet();
        public boolean zab;
        public boolean zac;
        public boolean zad;
        @Nullable
        public String zae;
        @Nullable
        public Account zaf;
        @Nullable
        public String zag;
        public Map<Integer, GoogleSignInOptionsExtensionParcelable> zah = new HashMap();
        @Nullable
        public String zai;

        public Builder() {
        }

        private final String zaa(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.zae;
            Preconditions.checkArgument(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        @RecentlyNonNull
        public final Builder addExtension(@RecentlyNonNull GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (!this.zah.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                List<Scope> impliedScopes = googleSignInOptionsExtension.getImpliedScopes();
                if (impliedScopes != null) {
                    this.zaa.addAll(impliedScopes);
                }
                this.zah.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        @RecentlyNonNull
        public final GoogleSignInOptions build() {
            if (this.zaa.contains(GoogleSignInOptions.zae) && this.zaa.contains(GoogleSignInOptions.zad)) {
                this.zaa.remove(GoogleSignInOptions.zad);
            }
            if (this.zad && (this.zaf == null || !this.zaa.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, (zac) null);
        }

        @RecentlyNonNull
        public final Builder requestEmail() {
            this.zaa.add(GoogleSignInOptions.zab);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestId() {
            this.zaa.add(GoogleSignInOptions.zac);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestIdToken(@RecentlyNonNull String str) {
            this.zad = true;
            this.zae = zaa(str);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestProfile() {
            this.zaa.add(GoogleSignInOptions.zaa);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestScopes(@RecentlyNonNull Scope scope, @RecentlyNonNull Scope... scopeArr) {
            this.zaa.add(scope);
            this.zaa.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @RecentlyNonNull
        public final Builder requestServerAuthCode(@RecentlyNonNull String str) {
            return requestServerAuthCode(str, false);
        }

        @RecentlyNonNull
        public final Builder setAccountName(@RecentlyNonNull String str) {
            this.zaf = new Account(Preconditions.checkNotEmpty(str), "com.google");
            return this;
        }

        @RecentlyNonNull
        public final Builder setHostedDomain(@RecentlyNonNull String str) {
            this.zag = Preconditions.checkNotEmpty(str);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public final Builder setLogSessionId(@RecentlyNonNull String str) {
            this.zai = str;
            return this;
        }

        @RecentlyNonNull
        public final Builder requestServerAuthCode(@RecentlyNonNull String str, boolean z) {
            this.zab = true;
            this.zae = zaa(str);
            this.zac = z;
            return this;
        }

        public Builder(@RecentlyNonNull GoogleSignInOptions googleSignInOptions) {
            Preconditions.checkNotNull(googleSignInOptions);
            this.zaa = new HashSet(googleSignInOptions.zag);
            this.zab = googleSignInOptions.zaj;
            this.zac = googleSignInOptions.zak;
            this.zad = googleSignInOptions.zai;
            this.zae = googleSignInOptions.zal;
            this.zaf = googleSignInOptions.zah;
            this.zag = googleSignInOptions.zam;
            this.zah = GoogleSignInOptions.zab((List<GoogleSignInOptionsExtensionParcelable>) googleSignInOptions.zan);
            this.zai = googleSignInOptions.zao;
        }
    }

    @SafeParcelable.Constructor
    public GoogleSignInOptions(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(mo17150id = 3) @Nullable Account account, @SafeParcelable.Param(mo17150id = 4) boolean z, @SafeParcelable.Param(mo17150id = 5) boolean z2, @SafeParcelable.Param(mo17150id = 6) boolean z3, @SafeParcelable.Param(mo17150id = 7) @Nullable String str, @SafeParcelable.Param(mo17150id = 8) @Nullable String str2, @SafeParcelable.Param(mo17150id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, @SafeParcelable.Param(mo17150id = 10) @Nullable String str3) {
        this(i, arrayList, account, z, z2, z3, str, str2, zab((List<GoogleSignInOptionsExtensionParcelable>) arrayList2), str3);
    }

    @RecentlyNullable
    public static GoogleSignInOptions zaa(@Nullable String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        Account account = !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null;
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        String optString2 = jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null;
        if (jSONObject.has("hostedDomain")) {
            str2 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, optString2, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) new HashMap(), (String) null);
    }

    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> zab(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.getType()), next);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r3.zah.equals(r4.getAccount()) != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        if (r3.zal.equals(r4.getServerClientId()) != false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0091 }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.zan     // Catch:{ ClassCastException -> 0x0091 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 > 0) goto L_0x0091
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.zan     // Catch:{ ClassCastException -> 0x0091 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 <= 0) goto L_0x0018
            goto L_0x0091
        L_0x0018:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zag     // Catch:{ ClassCastException -> 0x0091 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0091 }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x0091 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 != r2) goto L_0x0091
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zag     // Catch:{ ClassCastException -> 0x0091 }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x0091 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0091
        L_0x0035:
            android.accounts.Account r1 = r3.zah     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.getAccount()     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 != 0) goto L_0x0091
            goto L_0x004c
        L_0x0040:
            android.accounts.Account r1 = r3.zah     // Catch:{ ClassCastException -> 0x0091 }
            android.accounts.Account r2 = r4.getAccount()     // Catch:{ ClassCastException -> 0x0091 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 == 0) goto L_0x0091
        L_0x004c:
            java.lang.String r1 = r3.zal     // Catch:{ ClassCastException -> 0x0091 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 == 0) goto L_0x005f
            java.lang.String r1 = r4.getServerClientId()     // Catch:{ ClassCastException -> 0x0091 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 == 0) goto L_0x0091
            goto L_0x006b
        L_0x005f:
            java.lang.String r1 = r3.zal     // Catch:{ ClassCastException -> 0x0091 }
            java.lang.String r2 = r4.getServerClientId()     // Catch:{ ClassCastException -> 0x0091 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 == 0) goto L_0x0091
        L_0x006b:
            boolean r1 = r3.zak     // Catch:{ ClassCastException -> 0x0091 }
            boolean r2 = r4.isForceCodeForRefreshToken()     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 != r2) goto L_0x0091
            boolean r1 = r3.zai     // Catch:{ ClassCastException -> 0x0091 }
            boolean r2 = r4.isIdTokenRequested()     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 != r2) goto L_0x0091
            boolean r1 = r3.zaj     // Catch:{ ClassCastException -> 0x0091 }
            boolean r2 = r4.isServerAuthCodeRequested()     // Catch:{ ClassCastException -> 0x0091 }
            if (r1 != r2) goto L_0x0091
            java.lang.String r1 = r3.zao     // Catch:{ ClassCastException -> 0x0091 }
            java.lang.String r4 = r4.getLogSessionId()     // Catch:{ ClassCastException -> 0x0091 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0091 }
            if (r4 == 0) goto L_0x0091
            r4 = 1
            return r4
        L_0x0091:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @KeepForSdk
    @RecentlyNullable
    public Account getAccount() {
        return this.zah;
    }

    @RecentlyNonNull
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zan;
    }

    @KeepForSdk
    @RecentlyNullable
    public String getLogSessionId() {
        return this.zao;
    }

    @RecentlyNonNull
    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.zag;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @RecentlyNonNull
    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zag);
    }

    @KeepForSdk
    @RecentlyNullable
    public String getServerClientId() {
        return this.zal;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zag;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.getScopeUri());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().addObject(arrayList).addObject(this.zah).addObject(this.zal).zaa(this.zak).zaa(this.zai).zaa(this.zaj).addObject(this.zao).hash();
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.zak;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.zai;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.zaj;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaf);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zam, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, @Nullable Account account, boolean z, boolean z2, boolean z3, @Nullable String str, @Nullable String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @Nullable String str3) {
        this.zaf = i;
        this.zag = arrayList;
        this.zah = account;
        this.zai = z;
        this.zaj = z2;
        this.zak = z3;
        this.zal = str;
        this.zam = str2;
        this.zan = new ArrayList<>(map.values());
        this.zap = map;
        this.zao = str3;
    }

    private final JSONObject zab() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zag, zaq);
            ArrayList<Scope> arrayList = this.zag;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zah != null) {
                jSONObject.put("accountName", this.zah.name);
            }
            jSONObject.put("idTokenRequested", this.zai);
            jSONObject.put("forceCodeForRefreshToken", this.zak);
            jSONObject.put("serverAuthRequested", this.zaj);
            if (!TextUtils.isEmpty(this.zal)) {
                jSONObject.put("serverClientId", this.zal);
            }
            if (!TextUtils.isEmpty(this.zam)) {
                jSONObject.put("hostedDomain", this.zam);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, zac zac2) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }

    @RecentlyNonNull
    public final String zaa() {
        return zab().toString();
    }
}
