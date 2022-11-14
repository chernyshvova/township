package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "SignInAccountCreator")
@SafeParcelable.Reserved({1})
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzd();
    @SafeParcelable.Field(defaultValue = "", mo17147id = 4)
    @Deprecated
    public String zzba;
    @SafeParcelable.Field(getter = "getGoogleSignInAccount", mo17147id = 7)
    public GoogleSignInAccount zzbb;
    @SafeParcelable.Field(defaultValue = "", mo17147id = 8)
    @Deprecated
    public String zzbc;

    @SafeParcelable.Constructor
    public SignInAccount(@SafeParcelable.Param(mo17150id = 4) String str, @SafeParcelable.Param(mo17150id = 7) GoogleSignInAccount googleSignInAccount, @SafeParcelable.Param(mo17150id = 8) String str2) {
        this.zzbb = googleSignInAccount;
        this.zzba = Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.zzbc = Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    @Nullable
    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzbb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.zzba, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzbb, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzbc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
