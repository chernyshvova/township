package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.collection.ArraySet;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    @VisibleForTesting
    public static Clock zaa = DefaultClock.getInstance();
    @SafeParcelable.VersionField(mo17153id = 1)
    public final int zab;
    @SafeParcelable.Field(getter = "getId", mo17147id = 2)
    @Nullable
    public String zac;
    @SafeParcelable.Field(getter = "getIdToken", mo17147id = 3)
    @Nullable
    public String zad;
    @SafeParcelable.Field(getter = "getEmail", mo17147id = 4)
    @Nullable
    public String zae;
    @SafeParcelable.Field(getter = "getDisplayName", mo17147id = 5)
    @Nullable
    public String zaf;
    @SafeParcelable.Field(getter = "getPhotoUrl", mo17147id = 6)
    @Nullable
    public Uri zag;
    @SafeParcelable.Field(getter = "getServerAuthCode", mo17147id = 7)
    @Nullable
    public String zah;
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", mo17147id = 8)
    public long zai;
    @SafeParcelable.Field(getter = "getObfuscatedIdentifier", mo17147id = 9)
    public String zaj;
    @SafeParcelable.Field(mo17147id = 10)
    public List<Scope> zak;
    @SafeParcelable.Field(getter = "getGivenName", mo17147id = 11)
    @Nullable
    public String zal;
    @SafeParcelable.Field(getter = "getFamilyName", mo17147id = 12)
    @Nullable
    public String zam;
    public Set<Scope> zan = new HashSet();

    @SafeParcelable.Constructor
    public GoogleSignInAccount(@SafeParcelable.Param(mo17150id = 1) int i, @SafeParcelable.Param(mo17150id = 2) @Nullable String str, @SafeParcelable.Param(mo17150id = 3) @Nullable String str2, @SafeParcelable.Param(mo17150id = 4) @Nullable String str3, @SafeParcelable.Param(mo17150id = 5) @Nullable String str4, @SafeParcelable.Param(mo17150id = 6) @Nullable Uri uri, @SafeParcelable.Param(mo17150id = 7) @Nullable String str5, @SafeParcelable.Param(mo17150id = 8) long j, @SafeParcelable.Param(mo17150id = 9) String str6, @SafeParcelable.Param(mo17150id = 10) List<Scope> list, @SafeParcelable.Param(mo17150id = 11) @Nullable String str7, @SafeParcelable.Param(mo17150id = 12) @Nullable String str8) {
        this.zab = i;
        this.zac = str;
        this.zad = str2;
        this.zae = str3;
        this.zaf = str4;
        this.zag = uri;
        this.zah = str5;
        this.zai = j;
        this.zaj = str6;
        this.zak = list;
        this.zal = str7;
        this.zam = str8;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GoogleSignInAccount createDefault() {
        return zaa(new Account("<<default account>>", "com.google"), (Set<Scope>) new HashSet());
    }

    @RecentlyNonNull
    @KeepForSdk
    public static GoogleSignInAccount fromAccount(@RecentlyNonNull Account account) {
        return zaa(account, (Set<Scope>) new ArraySet());
    }

    @RecentlyNullable
    public static GoogleSignInAccount zaa(@Nullable String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount zaa2 = zaa(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str2 = jSONObject.optString("serverAuthCode");
        }
        zaa2.zah = str2;
        return zaa2;
    }

    private final JSONObject zac() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            Uri photoUrl = getPhotoUrl();
            if (photoUrl != null) {
                jSONObject.put("photoUrl", photoUrl.toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zai);
            jSONObject.put("obfuscatedIdentifier", this.zaj);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.zak.toArray(new Scope[this.zak.size()]);
            Arrays.sort(scopeArr, zaa.zaa);
            for (Scope scopeUri : scopeArr) {
                jSONArray.put(scopeUri.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.zaj.equals(this.zaj) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes());
    }

    @RecentlyNullable
    public Account getAccount() {
        if (this.zae == null) {
            return null;
        }
        return new Account(this.zae, "com.google");
    }

    @RecentlyNullable
    public String getDisplayName() {
        return this.zaf;
    }

    @RecentlyNullable
    public String getEmail() {
        return this.zae;
    }

    @RecentlyNullable
    public String getFamilyName() {
        return this.zam;
    }

    @RecentlyNullable
    public String getGivenName() {
        return this.zal;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zak);
    }

    @RecentlyNullable
    public String getId() {
        return this.zac;
    }

    @RecentlyNullable
    public String getIdToken() {
        return this.zad;
    }

    @RecentlyNullable
    public Uri getPhotoUrl() {
        return this.zag;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zak);
        hashSet.addAll(this.zan);
        return hashSet;
    }

    @RecentlyNullable
    public String getServerAuthCode() {
        return this.zah;
    }

    public int hashCode() {
        return getRequestedScopes().hashCode() + GeneratedOutlineSupport.outline4(this.zaj, 527, 31);
    }

    @KeepForSdk
    public boolean isExpired() {
        return zaa.currentTimeMillis() / 1000 >= this.zai - 300;
    }

    @RecentlyNonNull
    @KeepForSdk
    public GoogleSignInAccount requestExtraScopes(@RecentlyNonNull Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.zan, scopeArr);
        }
        return this;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zab);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, this.zai);
        SafeParcelWriter.writeString(parcel, 9, this.zaj, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.zak, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final String zab() {
        JSONObject zac2 = zac();
        zac2.remove("serverAuthCode");
        return zac2.toString();
    }

    public static GoogleSignInAccount zaa(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, (l == null ? Long.valueOf(zaa.currentTimeMillis() / 1000) : l).longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }

    public static GoogleSignInAccount zaa(Account account, Set<Scope> set) {
        return zaa((String) null, (String) null, account.name, (String) null, (String) null, (String) null, (Uri) null, 0L, account.name, set);
    }

    @NonNull
    public final String zaa() {
        return this.zaj;
    }
}
