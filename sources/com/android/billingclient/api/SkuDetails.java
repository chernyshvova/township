package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public class SkuDetails {
    public final String zza;
    public final JSONObject zzb = new JSONObject(this.zza);

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    public static class zza {
        public final List<SkuDetails> zza;
        public final int zzb;
        public final String zzc;

        public zza(int i, String str, @Nullable List<SkuDetails> list) {
            this.zzb = i;
            this.zzc = str;
            this.zza = list;
        }
    }

    public SkuDetails(@NonNull String str) throws JSONException {
        this.zza = str;
        if (TextUtils.isEmpty(getSku())) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        } else if (TextUtils.isEmpty(getType())) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuDetails)) {
            return false;
        }
        return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
    }

    public String getSku() {
        return this.zzb.optString("productId");
    }

    public String getType() {
        return this.zzb.optString("type");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "SkuDetails: ".concat(valueOf) : new String("SkuDetails: ");
    }

    public final String zza() {
        return this.zzb.optString(InAppPurchaseBillingClientWrapper.PACKAGE_NAME);
    }
}
