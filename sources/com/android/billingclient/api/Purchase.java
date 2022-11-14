package com.android.billingclient.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public class Purchase {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc = new JSONObject(this.zza);

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    public static class PurchasesResult {
        @Nullable
        public final List<Purchase> zza;
        public final BillingResult zzb;

        public PurchasesResult(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {
            this.zza = list;
            this.zzb = billingResult;
        }
    }

    public Purchase(@NonNull String str, @NonNull String str2) throws JSONException {
        this.zza = str;
        this.zzb = str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.zza, purchase.zza) && TextUtils.equals(this.zzb, purchase.zzb);
    }

    public String getPurchaseToken() {
        JSONObject jSONObject = this.zzc;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String getSku() {
        return this.zzc.optString("productId");
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "Purchase. Json: ".concat(valueOf) : new String("Purchase. Json: ");
    }
}
