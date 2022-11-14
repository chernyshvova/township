package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator = "CredentialRequestCreator")
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getAccountTypes", mo17147id = 2)
    public final String[] zzaa;
    @SafeParcelable.Field(getter = "getCredentialPickerConfig", mo17147id = 3)
    public final CredentialPickerConfig zzab;
    @SafeParcelable.Field(getter = "getCredentialHintPickerConfig", mo17147id = 4)
    public final CredentialPickerConfig zzac;
    @SafeParcelable.Field(getter = "isIdTokenRequested", mo17147id = 5)
    public final boolean zzad;
    @SafeParcelable.Field(getter = "getServerClientId", mo17147id = 6)
    public final String zzae;
    @SafeParcelable.Field(getter = "getIdTokenNonce", mo17147id = 7)
    public final String zzaf;
    @SafeParcelable.Field(getter = "getRequireUserMediation", mo17147id = 8)
    public final boolean zzag;
    @SafeParcelable.Field(mo17147id = 1000)
    public final int zzu;
    @SafeParcelable.Field(getter = "isPasswordLoginSupported", mo17147id = 1)
    public final boolean zzz;

    public static final class Builder {
        public String[] zzaa;
        public CredentialPickerConfig zzab;
        public CredentialPickerConfig zzac;
        public boolean zzad = false;
        @Nullable
        public String zzae = null;
        @Nullable
        public String zzaf;
        public boolean zzag = false;
        public boolean zzz;

        public final CredentialRequest build() {
            if (this.zzaa == null) {
                this.zzaa = new String[0];
            }
            if (this.zzz || this.zzaa.length != 0) {
                return new CredentialRequest(this);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzaa = strArr;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzac = credentialPickerConfig;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzab = credentialPickerConfig;
            return this;
        }

        public final Builder setIdTokenNonce(@Nullable String str) {
            this.zzaf = str;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z) {
            this.zzad = z;
            return this;
        }

        public final Builder setPasswordLoginSupported(boolean z) {
            this.zzz = z;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.zzae = str;
            return this;
        }

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }
    }

    @SafeParcelable.Constructor
    public CredentialRequest(@SafeParcelable.Param(mo17150id = 1000) int i, @SafeParcelable.Param(mo17150id = 1) boolean z, @SafeParcelable.Param(mo17150id = 2) String[] strArr, @SafeParcelable.Param(mo17150id = 3) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(mo17150id = 4) CredentialPickerConfig credentialPickerConfig2, @SafeParcelable.Param(mo17150id = 5) boolean z2, @SafeParcelable.Param(mo17150id = 6) String str, @SafeParcelable.Param(mo17150id = 7) String str2, @SafeParcelable.Param(mo17150id = 8) boolean z3) {
        this.zzu = i;
        this.zzz = z;
        this.zzaa = (String[]) Preconditions.checkNotNull(strArr);
        this.zzab = credentialPickerConfig == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig;
        this.zzac = credentialPickerConfig2 == null ? new CredentialPickerConfig.Builder().build() : credentialPickerConfig2;
        if (i < 3) {
            this.zzad = true;
            this.zzae = null;
            this.zzaf = null;
        } else {
            this.zzad = z2;
            this.zzae = str;
            this.zzaf = str2;
        }
        this.zzag = z3;
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.zzaa;
    }

    @NonNull
    public final Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.zzaa));
    }

    @NonNull
    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzac;
    }

    @NonNull
    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzab;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.zzaf;
    }

    @Nullable
    public final String getServerClientId() {
        return this.zzae;
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public final boolean isIdTokenRequested() {
        return this.zzad;
    }

    public final boolean isPasswordLoginSupported() {
        return this.zzz;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isPasswordLoginSupported());
        SafeParcelWriter.writeStringArray(parcel, 2, getAccountTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getCredentialPickerConfig(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getCredentialHintPickerConfig(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzu);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzag);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public CredentialRequest(Builder builder) {
        this(4, builder.zzz, builder.zzaa, builder.zzab, builder.zzac, builder.zzad, builder.zzae, builder.zzaf, false);
    }
}
