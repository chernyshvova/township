package com.android.billingclient.api;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzac implements Callable<Purchase.PurchasesResult> {
    public final /* synthetic */ String zza;
    public final /* synthetic */ BillingClientImpl zzb;

    public zzac(BillingClientImpl billingClientImpl, String str) {
        this.zzb = billingClientImpl;
        this.zza = str;
    }

    public final Object call() throws Exception {
        Bundle bundle;
        BillingClientImpl billingClientImpl = this.zzb;
        String str = this.zza;
        if (billingClientImpl != null) {
            String valueOf = String.valueOf(str);
            zzb.zza("BillingClient", valueOf.length() != 0 ? "Querying owned items, item type: ".concat(valueOf) : new String("Querying owned items, item type: "));
            ArrayList arrayList = new ArrayList();
            Bundle zza2 = zzb.zza(billingClientImpl.zzm, billingClientImpl.zzq, billingClientImpl.zzb);
            String str2 = null;
            do {
                try {
                    if (billingClientImpl.zzm) {
                        bundle = billingClientImpl.zzg.zzc(9, billingClientImpl.zzf.getPackageName(), str, str2, zza2);
                    } else {
                        bundle = billingClientImpl.zzg.zza(3, billingClientImpl.zzf.getPackageName(), str, str2);
                    }
                    BillingResult billingResult = zzak.zzl;
                    int i = 0;
                    if (bundle == null) {
                        zzb.zzb("BillingClient", String.format("%s got null owned items list", new Object[]{"getPurchase()"}));
                    } else {
                        int zza3 = zzb.zza(bundle, "BillingClient");
                        String zzb2 = zzb.zzb(bundle, "BillingClient");
                        BillingResult.Builder newBuilder = BillingResult.newBuilder();
                        newBuilder.zza = zza3;
                        newBuilder.zzb = zzb2;
                        BillingResult build = newBuilder.build();
                        if (zza3 != 0) {
                            zzb.zzb("BillingClient", String.format("%s failed. Response code: %s", new Object[]{"getPurchase()", Integer.valueOf(zza3)}));
                            billingResult = build;
                        } else if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey(InAppPurchaseEventManager.INAPP_PURCHASE_DATA_LIST) || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                            zzb.zzb("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", new Object[]{"getPurchase()"}));
                        } else {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                            ArrayList<String> stringArrayList2 = bundle.getStringArrayList(InAppPurchaseEventManager.INAPP_PURCHASE_DATA_LIST);
                            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                            if (stringArrayList == null) {
                                zzb.zzb("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", new Object[]{"getPurchase()"}));
                            } else if (stringArrayList2 == null) {
                                zzb.zzb("BillingClient", String.format("Bundle returned from %s contains null purchases list.", new Object[]{"getPurchase()"}));
                            } else if (stringArrayList3 == null) {
                                zzb.zzb("BillingClient", String.format("Bundle returned from %s contains null signatures list.", new Object[]{"getPurchase()"}));
                            } else {
                                billingResult = zzak.zzn;
                            }
                        }
                    }
                    if (billingResult != zzak.zzn) {
                        return new Purchase.PurchasesResult(billingResult, (List<Purchase>) null);
                    }
                    ArrayList<String> stringArrayList4 = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList5 = bundle.getStringArrayList(InAppPurchaseEventManager.INAPP_PURCHASE_DATA_LIST);
                    ArrayList<String> stringArrayList6 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    while (i < stringArrayList5.size()) {
                        String str3 = stringArrayList5.get(i);
                        String str4 = stringArrayList6.get(i);
                        String valueOf2 = String.valueOf(stringArrayList4.get(i));
                        zzb.zza("BillingClient", valueOf2.length() != 0 ? "Sku is owned: ".concat(valueOf2) : new String("Sku is owned: "));
                        try {
                            Purchase purchase = new Purchase(str3, str4);
                            if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                zzb.zzb("BillingClient", "BUG: empty/null token!");
                            }
                            arrayList.add(purchase);
                            i++;
                        } catch (JSONException e) {
                            String valueOf3 = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(valueOf3.length() + 48);
                            sb.append("Got an exception trying to decode the purchase: ");
                            sb.append(valueOf3);
                            zzb.zzb("BillingClient", sb.toString());
                            return new Purchase.PurchasesResult(zzak.zzl, (List<Purchase>) null);
                        }
                    }
                    str2 = bundle.getString(InAppPurchaseEventManager.INAPP_CONTINUATION_TOKEN);
                    String valueOf4 = String.valueOf(str2);
                    zzb.zza("BillingClient", valueOf4.length() != 0 ? "Continuation token: ".concat(valueOf4) : new String("Continuation token: "));
                } catch (Exception e2) {
                    String valueOf5 = String.valueOf(e2);
                    StringBuilder sb2 = new StringBuilder(valueOf5.length() + 57);
                    sb2.append("Got exception trying to get purchases: ");
                    sb2.append(valueOf5);
                    sb2.append("; try to reconnect");
                    zzb.zzb("BillingClient", sb2.toString());
                    return new Purchase.PurchasesResult(zzak.zzo, (List<Purchase>) null);
                }
            } while (!TextUtils.isEmpty(str2));
            return new Purchase.PurchasesResult(zzak.zzn, arrayList);
        }
        throw null;
    }
}
