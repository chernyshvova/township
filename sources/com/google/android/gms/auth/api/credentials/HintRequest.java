package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HintRequestCreator")
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getAccountTypes", mo17147id = 4)
    public final String[] zzaa;
    @SafeParcelable.Field(getter = "isIdTokenRequested", mo17147id = 5)
    public final boolean zzad;
    @SafeParcelable.Field(getter = "getServerClientId", mo17147id = 6)
    public final String zzae;
    @SafeParcelable.Field(getter = "getIdTokenNonce", mo17147id = 7)
    public final String zzaf;
    @SafeParcelable.Field(getter = "getHintPickerConfig", mo17147id = 1)
    public final CredentialPickerConfig zzah;
    @SafeParcelable.Field(getter = "isEmailAddressIdentifierSupported", mo17147id = 2)
    public final boolean zzai;
    @SafeParcelable.Field(getter = "isPhoneNumberIdentifierSupported", mo17147id = 3)
    public final boolean zzaj;
    @SafeParcelable.Field(mo17147id = 1000)
    public final int zzu;

    public static final class Builder {
        public String[] zzaa;
        public boolean zzad = false;
        public String zzae;
        public String zzaf;
        public CredentialPickerConfig zzah = new CredentialPickerConfig.Builder().build();
        public boolean zzai;
        public boolean zzaj;

        public final HintRequest build() {
            if (this.zzaa == null) {
                this.zzaa = new String[0];
            }
            if (this.zzai || this.zzaj || this.zzaa.length != 0) {
                return new HintRequest(this);
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

        public final Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzai = z;
            return this;
        }

        public final Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zzah = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
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

        public final Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.zzaj = z;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.zzae = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public HintRequest(@SafeParcelable.Param(mo17150id = 1000) int i, @SafeParcelable.Param(mo17150id = 1) CredentialPickerConfig credentialPickerConfig, @SafeParcelable.Param(mo17150id = 2) boolean z, @SafeParcelable.Param(mo17150id = 3) boolean z2, @SafeParcelable.Param(mo17150id = 4) String[] strArr, @SafeParcelable.Param(mo17150id = 5) boolean z3, @SafeParcelable.Param(mo17150id = 6) String str, @SafeParcelable.Param(mo17150id = 7) String str2) {
        this.zzu = i;
        this.zzah = (CredentialPickerConfig) Preconditions.checkNotNull(credentialPickerConfig);
        this.zzai = z;
        this.zzaj = z2;
        this.zzaa = (String[]) Preconditions.checkNotNull(strArr);
        if (this.zzu < 2) {
            this.zzad = true;
            this.zzae = null;
            this.zzaf = null;
            return;
        }
        this.zzad = z3;
        this.zzae = str;
        this.zzaf = str2;
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.zzaa;
    }

    @NonNull
    public final CredentialPickerConfig getHintPickerConfig() {
        return this.zzah;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.zzaf;
    }

    @Nullable
    public final String getServerClientId() {
        return this.zzae;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.zzai;
    }

    public final boolean isIdTokenRequested() {
        return this.zzad;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getHintPickerConfig(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, isEmailAddressIdentifierSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzaj);
        SafeParcelWriter.writeStringArray(parcel, 4, getAccountTypes(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, isIdTokenRequested());
        SafeParcelWriter.writeString(parcel, 6, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 7, getIdTokenNonce(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public HintRequest(Builder builder) {
        this(2, builder.zzah, builder.zzai, builder.zzaj, builder.zzaa, builder.zzad, builder.zzae, builder.zzaf);
    }
}
