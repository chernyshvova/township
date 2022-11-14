package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@SafeParcelable.Class(creator = "CloudMessageCreator")
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class CloudMessage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zzb();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @SafeParcelable.Field(mo17147id = 1)
    @NonNull
    public Intent zza;
    @GuardedBy("this")
    public Map<String, String> zzb;

    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public @interface MessagePriority {
    }

    @SafeParcelable.Constructor
    public CloudMessage(@SafeParcelable.Param(mo17150id = 1) @NonNull Intent intent) {
        this.zza = intent;
    }

    public static int zza(@Nullable String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public final String getCollapseKey() {
        return this.zza.getStringExtra("collapse_key");
    }

    @NonNull
    public final synchronized Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle extras = this.zza.getExtras();
            ArrayMap arrayMap = new ArrayMap();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    Object obj = extras.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!str.startsWith("google.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
            this.zzb = arrayMap;
        }
        return this.zzb;
    }

    @Nullable
    public final String getFrom() {
        return this.zza.getStringExtra("from");
    }

    @NonNull
    public final Intent getIntent() {
        return this.zza;
    }

    @Nullable
    public final String getMessageId() {
        String stringExtra = this.zza.getStringExtra("google.message_id");
        return stringExtra == null ? this.zza.getStringExtra("message_id") : stringExtra;
    }

    @Nullable
    public final String getMessageType() {
        return this.zza.getStringExtra("message_type");
    }

    public final int getOriginalPriority() {
        String stringExtra = this.zza.getStringExtra("google.original_priority");
        if (stringExtra == null) {
            stringExtra = this.zza.getStringExtra("google.priority");
        }
        return zza(stringExtra);
    }

    public final int getPriority() {
        String stringExtra = this.zza.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zza.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = this.zza.getStringExtra("google.priority");
        }
        return zza(stringExtra);
    }

    @Nullable
    public final byte[] getRawData() {
        return this.zza.getByteArrayExtra("rawData");
    }

    @Nullable
    public final String getSenderId() {
        return this.zza.getStringExtra("google.c.sender.id");
    }

    public final long getSentTime() {
        Bundle extras = this.zza.getExtras();
        Object obj = extras != null ? extras.get("google.sent_time") : null;
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            GeneratedOutlineSupport.outline30(valueOf.length() + 19, "Invalid sent time: ", valueOf, "CloudMessage");
            return 0;
        }
    }

    @Nullable
    public final String getTo() {
        return this.zza.getStringExtra("google.to");
    }

    public final int getTtl() {
        Bundle extras = this.zza.getExtras();
        Object obj = extras != null ? extras.get("google.ttl") : null;
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            GeneratedOutlineSupport.outline30(valueOf.length() + 13, "Invalid TTL: ", valueOf, "CloudMessage");
            return 0;
        }
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
