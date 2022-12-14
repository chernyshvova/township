package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "CredentialPickerConfigCreator")
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zze();
    @SafeParcelable.Field(getter = "shouldShowCancelButton", mo17147id = 2)
    public final boolean mShowCancelButton;
    @SafeParcelable.Field(mo17147id = 1000)
    public final int zzu;
    @SafeParcelable.Field(getter = "shouldShowAddAccountButton", mo17147id = 1)
    public final boolean zzv;
    @SafeParcelable.Field(getter = "isForNewAccount", mo17147id = 3)
    @Deprecated
    public final boolean zzw;
    @SafeParcelable.Field(getter = "getPromptInternalId", mo17147id = 4)
    public final int zzx;

    public static class Builder {
        public boolean mShowCancelButton = true;
        public boolean zzv = false;
        public int zzy = 1;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(this);
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.zzy = z ? 3 : 1;
            return this;
        }

        public Builder setPrompt(int i) {
            this.zzy = i;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzv = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: int} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CredentialPickerConfig(@com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo17150id = 1000) int r2, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo17150id = 1) boolean r3, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo17150id = 2) boolean r4, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo17150id = 3) boolean r5, @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param(mo17150id = 4) int r6) {
        /*
            r1 = this;
            r1.<init>()
            r1.zzu = r2
            r1.zzv = r3
            r1.mShowCancelButton = r4
            r3 = 1
            r4 = 3
            r0 = 2
            if (r2 >= r0) goto L_0x0016
            r1.zzw = r5
            if (r5 == 0) goto L_0x0013
            r3 = 3
        L_0x0013:
            r1.zzx = r3
            return
        L_0x0016:
            if (r6 != r4) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            r1.zzw = r3
            r1.zzx = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.credentials.CredentialPickerConfig.<init>(int, boolean, boolean, boolean, int):void");
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.zzx == 3;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzv;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, shouldShowAddAccountButton());
        SafeParcelWriter.writeBoolean(parcel, 2, shouldShowCancelButton());
        SafeParcelWriter.writeBoolean(parcel, 3, isForNewAccount());
        SafeParcelWriter.writeInt(parcel, 4, this.zzx);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public CredentialPickerConfig(Builder builder) {
        this(2, builder.zzv, builder.mShowCancelButton, false, builder.zzy);
    }
}
