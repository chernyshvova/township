package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public class BillingFlowParams {
    public String zza;
    public String zzb;
    public String zzc;
    public String zzd;
    public String zze;
    public int zzf = 0;
    public ArrayList<SkuDetails> zzg;
    public boolean zzh;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    public static class Builder {
        public String zza;
        public int zze = 0;
        public ArrayList<SkuDetails> zzf;

        public Builder(zzai zzai) {
        }

        public BillingFlowParams build() {
            ArrayList<SkuDetails> arrayList = this.zzf;
            if (arrayList == null || arrayList.isEmpty()) {
                throw new IllegalArgumentException("SkuDetails must be provided.");
            }
            ArrayList<SkuDetails> arrayList2 = this.zzf;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                SkuDetails skuDetails = arrayList2.get(i);
                i++;
                if (skuDetails == null) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
            }
            if (this.zzf.size() > 1) {
                SkuDetails skuDetails2 = this.zzf.get(0);
                String type = skuDetails2.getType();
                ArrayList<SkuDetails> arrayList3 = this.zzf;
                int size2 = arrayList3.size();
                int i2 = 0;
                while (i2 < size2) {
                    SkuDetails skuDetails3 = arrayList3.get(i2);
                    i2++;
                    if (!type.equals(skuDetails3.getType())) {
                        throw new IllegalArgumentException("SKUs should have the same type.");
                    }
                }
                String zza2 = skuDetails2.zza();
                if (TextUtils.isEmpty(zza2)) {
                    ArrayList<SkuDetails> arrayList4 = this.zzf;
                    int size3 = arrayList4.size();
                    int i3 = 0;
                    while (i3 < size3) {
                        SkuDetails skuDetails4 = arrayList4.get(i3);
                        i3++;
                        if (!TextUtils.isEmpty(skuDetails4.zza())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                } else {
                    ArrayList<SkuDetails> arrayList5 = this.zzf;
                    int size4 = arrayList5.size();
                    int i4 = 0;
                    while (i4 < size4) {
                        SkuDetails skuDetails5 = arrayList5.get(i4);
                        i4++;
                        if (!zza2.equals(skuDetails5.zza())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            BillingFlowParams billingFlowParams = new BillingFlowParams((zzai) null);
            billingFlowParams.zza = null;
            billingFlowParams.zzb = this.zza;
            billingFlowParams.zze = null;
            billingFlowParams.zzc = null;
            billingFlowParams.zzd = null;
            billingFlowParams.zzf = this.zze;
            billingFlowParams.zzg = this.zzf;
            billingFlowParams.zzh = false;
            return billingFlowParams;
        }
    }

    public BillingFlowParams(zzai zzai) {
    }
}
