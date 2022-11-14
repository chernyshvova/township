package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class BillingResult {
    public int zza;
    public String zzb;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    public static class Builder {
        public int zza;
        public String zzb = "";

        public Builder(zzaj zzaj) {
        }

        public BillingResult build() {
            BillingResult billingResult = new BillingResult();
            billingResult.zza = this.zza;
            billingResult.zzb = this.zzb;
            return billingResult;
        }
    }

    public static Builder newBuilder() {
        return new Builder((zzaj) null);
    }
}
