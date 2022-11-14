package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.Purchase;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public final class zzb {
    public static int zza = Runtime.getRuntime().availableProcessors();

    public static void zza(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    public static void zzb(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }

    public static Purchase zzc(String str, String str2) {
        if (str == null || str2 == null) {
            zzb("BillingHelper", "Received a bad purchase data.");
            return null;
        }
        try {
            return new Purchase(str, str2);
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 47);
            sb.append("Got JSONException while parsing purchase data: ");
            sb.append(valueOf);
            zzb("BillingHelper", sb.toString());
            return null;
        }
    }

    public static int zza(Intent intent, String str) {
        return zzb(intent, str).zza;
    }

    @NonNull
    public static BillingResult zzb(Intent intent, String str) {
        if (intent == null) {
            zzb("BillingHelper", "Got null intent!");
            BillingResult.Builder newBuilder = BillingResult.newBuilder();
            newBuilder.zza = 6;
            newBuilder.zzb = "An internal error occurred.";
            return newBuilder.build();
        }
        BillingResult.Builder newBuilder2 = BillingResult.newBuilder();
        newBuilder2.zza = zza(intent.getExtras(), str);
        newBuilder2.zzb = zzb(intent.getExtras(), str);
        return newBuilder2.build();
    }

    public static int zza(Bundle bundle, String str) {
        if (bundle == null) {
            zzb(str, "Unexpected null bundle received!");
            return 6;
        }
        Object obj = bundle.get(InAppPurchaseEventManager.RESPONSE_CODE);
        if (obj == null) {
            zza(str, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            String name = obj.getClass().getName();
            zzb(str, name.length() != 0 ? "Unexpected type for bundle response code: ".concat(name) : new String("Unexpected type for bundle response code: "));
            return 6;
        }
    }

    public static List<Purchase> zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(InAppPurchaseEventManager.INAPP_PURCHASE_DATA_LIST);
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList arrayList = new ArrayList();
        if (stringArrayList == null || stringArrayList2 == null) {
            zzb("BillingHelper", "Couldn't find purchase lists, trying to find single data.");
            Purchase zzc = zzc(bundle.getString("INAPP_PURCHASE_DATA"), bundle.getString("INAPP_DATA_SIGNATURE"));
            if (zzc == null) {
                zzb("BillingHelper", "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(zzc);
        } else {
            int i = 0;
            while (i < stringArrayList.size() && i < stringArrayList2.size()) {
                Purchase zzc2 = zzc(stringArrayList.get(i), stringArrayList2.get(i));
                if (zzc2 != null) {
                    arrayList.add(zzc2);
                }
                i++;
            }
        }
        return arrayList;
    }

    @NonNull
    public static String zzb(Bundle bundle, String str) {
        if (bundle == null) {
            zzb(str, "Unexpected null bundle received!");
            return "";
        }
        Object obj = bundle.get("DEBUG_MESSAGE");
        if (obj == null) {
            zza(str, "getDebugMessageFromBundle() got null response code, assuming OK");
            return "";
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            String name = obj.getClass().getName();
            zzb(str, name.length() != 0 ? "Unexpected type for debug message: ".concat(name) : new String("Unexpected type for debug message: "));
            return "";
        }
    }

    @NonNull
    public static Bundle zza(BillingFlowParams billingFlowParams, boolean z, boolean z2, String str) {
        Bundle outline5 = GeneratedOutlineSupport.outline5("playBillingLibraryVersion", str);
        int i = billingFlowParams.zzf;
        if (i != 0) {
            outline5.putInt("prorationMode", i);
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzb)) {
            outline5.putString("accountId", billingFlowParams.zzb);
        }
        if (!TextUtils.isEmpty(billingFlowParams.zze)) {
            outline5.putString("obfuscatedProfileId", billingFlowParams.zze);
        }
        if (billingFlowParams.zzh) {
            outline5.putBoolean("vr", true);
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzc)) {
            outline5.putStringArrayList("skusToReplace", new ArrayList(Arrays.asList(new String[]{billingFlowParams.zzc})));
        }
        if (!TextUtils.isEmpty(billingFlowParams.zzd)) {
            outline5.putString("oldSkuPurchaseToken", billingFlowParams.zzd);
        }
        if (z && z2) {
            outline5.putBoolean("enablePendingPurchases", true);
        }
        return outline5;
    }

    @NonNull
    public static Bundle zza(boolean z, boolean z2, String str) {
        Bundle outline5 = GeneratedOutlineSupport.outline5("playBillingLibraryVersion", str);
        if (z && z2) {
            outline5.putBoolean("enablePendingPurchases", true);
        }
        return outline5;
    }

    @NonNull
    public static Bundle zza(boolean z, boolean z2, boolean z3, String str, @Nullable String str2) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        if (z && z3) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z2 && str2 != null) {
            bundle.putString("SKU_PACKAGE_NAME", str2);
        }
        return bundle;
    }

    @NonNull
    public static Bundle zza(ConsumeParams consumeParams, boolean z, String str) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString("playBillingLibraryVersion", str);
        }
        return bundle;
    }

    @NonNull
    public static Bundle zza(AcknowledgePurchaseParams acknowledgePurchaseParams, String str) {
        return GeneratedOutlineSupport.outline5("playBillingLibraryVersion", str);
    }
}
