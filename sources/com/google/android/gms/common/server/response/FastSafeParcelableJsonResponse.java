package com.google.android.gms.common.server.response;

import android.os.Parcel;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                if (!fastJsonResponse.isFieldSet(next) || !Objects.equal(getFieldValue(next), fastJsonResponse.getFieldValue(next))) {
                    return false;
                }
            } else if (fastJsonResponse.isFieldSet(next)) {
                return false;
            }
        }
        return true;
    }

    @RecentlyNullable
    @VisibleForTesting
    public Object getValueObject(@RecentlyNonNull String str) {
        return null;
    }

    public int hashCode() {
        int i = 0;
        for (FastJsonResponse.Field next : getFieldMappings().values()) {
            if (isFieldSet(next)) {
                i = Preconditions.checkNotNull(getFieldValue(next)).hashCode() + (i * 31);
            }
        }
        return i;
    }

    @VisibleForTesting
    public boolean isPrimitiveFieldSet(@RecentlyNonNull String str) {
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public byte[] toByteArray() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
