package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.SkuDetails;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.google.android.gms.internal.play_billing.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzg implements Callable<Void> {
    public final /* synthetic */ SkuDetailsResponseListener zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ List zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ BillingClientImpl zze;

    public zzg(BillingClientImpl billingClientImpl, String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zze = billingClientImpl;
        this.zzb = str;
        this.zzc = list;
        this.zzd = str2;
        this.zza = skuDetailsResponseListener;
    }

    public final Object call() throws Exception {
        SkuDetails.zza zza2;
        int i;
        Bundle bundle;
        BillingClientImpl billingClientImpl = this.zze;
        String str = this.zzb;
        List list = this.zzc;
        String str2 = this.zzd;
        if (billingClientImpl != null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    zza2 = new SkuDetails.zza(0, "", arrayList);
                    break;
                }
                int i3 = i2 + 20;
                ArrayList arrayList2 = new ArrayList(list.subList(i2, i3 > size ? size : i3));
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList(InAppPurchaseEventManager.ITEM_ID_LIST, arrayList2);
                bundle2.putString("playBillingLibraryVersion", billingClientImpl.zzb);
                try {
                    if (billingClientImpl.zzn) {
                        i = i3;
                        bundle = billingClientImpl.zzg.zza(10, billingClientImpl.zzf.getPackageName(), str, bundle2, zzb.zza(billingClientImpl.zzm, billingClientImpl.zzp, billingClientImpl.zzq, billingClientImpl.zzb, str2));
                    } else {
                        i = i3;
                        bundle = billingClientImpl.zzg.zza(3, billingClientImpl.zzf.getPackageName(), str, bundle2);
                    }
                    if (bundle == null) {
                        zzb.zzb("BillingClient", "querySkuDetailsAsync got null sku details list");
                        zza2 = new SkuDetails.zza(4, "Null sku details list", (List<SkuDetails>) null);
                        break;
                    } else if (!bundle.containsKey(InAppPurchaseEventManager.DETAILS_LIST)) {
                        int zza3 = zzb.zza(bundle, "BillingClient");
                        String zzb2 = zzb.zzb(bundle, "BillingClient");
                        if (zza3 != 0) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("getSkuDetails() failed. Response code: ");
                            sb.append(zza3);
                            zzb.zzb("BillingClient", sb.toString());
                            zza2 = new SkuDetails.zza(zza3, zzb2, arrayList);
                        } else {
                            zzb.zzb("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                            zza2 = new SkuDetails.zza(6, zzb2, arrayList);
                        }
                    } else {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList(InAppPurchaseEventManager.DETAILS_LIST);
                        if (stringArrayList == null) {
                            zzb.zzb("BillingClient", "querySkuDetailsAsync got null response list");
                            zza2 = new SkuDetails.zza(4, "querySkuDetailsAsync got null response list", (List<SkuDetails>) null);
                            break;
                        }
                        int i4 = 0;
                        while (i4 < stringArrayList.size()) {
                            try {
                                SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                                String valueOf = String.valueOf(skuDetails);
                                StringBuilder sb2 = new StringBuilder(valueOf.length() + 17);
                                sb2.append("Got sku details: ");
                                sb2.append(valueOf);
                                zzb.zza("BillingClient", sb2.toString());
                                arrayList.add(skuDetails);
                                i4++;
                            } catch (JSONException unused) {
                                zzb.zzb("BillingClient", "Got a JSON exception trying to decode SkuDetails.");
                                zza2 = new SkuDetails.zza(6, "Error trying to decode SkuDetails.", (List<SkuDetails>) null);
                            }
                        }
                        i2 = i;
                    }
                } catch (Exception e) {
                    String valueOf2 = String.valueOf(e);
                    StringBuilder sb3 = new StringBuilder(valueOf2.length() + 63);
                    sb3.append("querySkuDetailsAsync got a remote exception (try to reconnect).");
                    sb3.append(valueOf2);
                    zzb.zzb("BillingClient", sb3.toString());
                    zza2 = new SkuDetails.zza(-1, "Service connection is disconnected.", (List<SkuDetails>) null);
                }
            }
            this.zze.zza((Runnable) new zzj(this, zza2));
            return null;
        }
        throw null;
    }
}
