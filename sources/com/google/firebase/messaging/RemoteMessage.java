package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    @SafeParcelable.Field(mo17147id = 2)
    public Bundle bundle;
    public Map<String, String> data;

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(mo17150id = 2) Bundle bundle2) {
        this.bundle = bundle2;
    }

    @NonNull
    public final Map<String, String> getData() {
        if (this.data == null) {
            Bundle bundle2 = this.bundle;
            ArrayMap arrayMap = new ArrayMap();
            for (String str : bundle2.keySet()) {
                Object obj = bundle2.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            this.data = arrayMap;
        }
        return this.data;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.bundle, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
