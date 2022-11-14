package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzd;
import com.swrve.sdk.rest.RESTClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.android.billingclient:billing@@3.0.0 */
public class BillingClientImpl extends BillingClient {
    public int zza;
    public final String zzb;
    public final Handler zzc;
    public zzd zzd;
    public Context zzf;
    public com.google.android.gms.internal.play_billing.zza zzg;
    public zza zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public boolean zzl;
    public boolean zzm;
    public boolean zzn;
    public boolean zzo;
    public boolean zzp;
    public boolean zzq;
    public ExecutorService zzr;
    @Nullable
    public String zzs;
    public final ResultReceiver zzt;

    /* compiled from: com.android.billingclient:billing@@3.0.0 */
    public final class zza implements ServiceConnection {
        public final Object zzb = new Object();
        public boolean zzc = false;
        public BillingClientStateListener zzd;

        public zza(BillingClientStateListener billingClientStateListener, zzh zzh) {
            this.zzd = billingClientStateListener;
        }

        public static void zza(zza zza2, BillingResult billingResult) {
            BillingClientImpl.this.zza((Runnable) new zzae(zza2, billingResult));
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzb.zza("BillingClient", "Billing service connected.");
            BillingClientImpl.this.zzg = zzd.zza(iBinder);
            if (BillingClientImpl.this.zza(new zzag(this), 30000, new zzaf(this)) == null) {
                BillingClientImpl.this.zza((Runnable) new zzae(this, BillingClientImpl.this.zzc()));
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            zzb.zzb("BillingClient", "Billing service disconnected.");
            BillingClientImpl billingClientImpl = BillingClientImpl.this;
            billingClientImpl.zzg = null;
            billingClientImpl.zza = 0;
            synchronized (this.zzb) {
                if (this.zzd != null) {
                    this.zzd.onBillingServiceDisconnected();
                }
            }
        }
    }

    @UiThread
    public BillingClientImpl(boolean z, @NonNull Context context, @NonNull PurchasesUpdatedListener purchasesUpdatedListener) {
        String str;
        try {
            str = (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get((Object) null);
        } catch (Exception unused) {
            str = "3.0.0";
        }
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzt = new zzh(this, this.zzc);
        this.zzs = null;
        this.zzb = str;
        Context applicationContext = context.getApplicationContext();
        this.zzf = applicationContext;
        this.zzd = new zzd(applicationContext, purchasesUpdatedListener);
        this.zzq = z;
    }

    public void endConnection() {
        try {
            this.zzd.zzc();
            if (this.zzh != null) {
                zza zza2 = this.zzh;
                synchronized (zza2.zzb) {
                    zza2.zzd = null;
                    zza2.zzc = true;
                }
            }
            if (!(this.zzh == null || this.zzg == null)) {
                zzb.zza("BillingClient", "Unbinding from service.");
                this.zzf.unbindService(this.zzh);
                this.zzh = null;
            }
            this.zzg = null;
            if (this.zzr != null) {
                this.zzr.shutdownNow();
                this.zzr = null;
            }
            this.zza = 3;
        } catch (Exception e) {
            try {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                sb.append("There was an exception while ending connection: ");
                sb.append(valueOf);
                zzb.zzb("BillingClient", sb.toString());
            } finally {
                this.zza = 3;
            }
        }
    }

    public boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    @NonNull
    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        boolean z;
        long j;
        Future future;
        int i;
        Activity activity2 = activity;
        BillingFlowParams billingFlowParams2 = billingFlowParams;
        if (!isReady()) {
            BillingResult billingResult = zzak.zzo;
            zza(billingResult);
            return billingResult;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(billingFlowParams2.zzg);
        SkuDetails skuDetails = (SkuDetails) arrayList.get(0);
        String type = skuDetails.getType();
        if (!type.equals(InAppPurchaseEventManager.SUBSCRIPTION) || this.zzi) {
            boolean z2 = billingFlowParams2.zzc != null;
            if (!z2 || this.zzj) {
                ArrayList<SkuDetails> arrayList2 = billingFlowParams2.zzg;
                int size = arrayList2.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = true;
                        break;
                    }
                    SkuDetails skuDetails2 = arrayList2.get(i2);
                    i2++;
                    if (skuDetails2.zza().isEmpty()) {
                        z = false;
                        break;
                    }
                }
                if (!((!billingFlowParams2.zzh && billingFlowParams2.zzb == null && billingFlowParams2.zza == null && billingFlowParams2.zze == null && billingFlowParams2.zzf == 0 && !z) ? false : true) || this.zzk) {
                    String str = "";
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        String valueOf = String.valueOf(str);
                        String valueOf2 = String.valueOf(arrayList.get(i3));
                        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length());
                        sb.append(valueOf);
                        sb.append(valueOf2);
                        str = sb.toString();
                        if (i3 < arrayList.size() - 1) {
                            str = String.valueOf(str).concat(RESTClient.COMMA_SEPARATOR);
                        }
                    }
                    StringBuilder sb2 = new StringBuilder(type.length() + String.valueOf(str).length() + 41);
                    sb2.append("Constructing buy intent for ");
                    sb2.append(str);
                    sb2.append(", item type: ");
                    sb2.append(type);
                    zzb.zza("BillingClient", sb2.toString());
                    if (this.zzk) {
                        Bundle zza2 = zzb.zza(billingFlowParams2, this.zzm, this.zzq, this.zzb);
                        if (!skuDetails.zzb.optString("skuDetailsToken").isEmpty()) {
                            zza2.putString("skuDetailsToken", skuDetails.zzb.optString("skuDetailsToken"));
                        }
                        if (!TextUtils.isEmpty(skuDetails.zza())) {
                            zza2.putString("skuPackageName", skuDetails.zza());
                        }
                        if (!TextUtils.isEmpty(this.zzs)) {
                            zza2.putString("accountName", this.zzs);
                        }
                        if (arrayList.size() > 1) {
                            ArrayList arrayList3 = new ArrayList(arrayList.size() - 1);
                            for (int i4 = 1; i4 < arrayList.size(); i4++) {
                                arrayList3.add(((SkuDetails) arrayList.get(i4)).getSku());
                            }
                            zza2.putStringArrayList("additionalSkus", arrayList3);
                        }
                        if (this.zzm) {
                            i = 9;
                        } else {
                            i = billingFlowParams2.zzh ? 7 : 6;
                        }
                        zzab zzab = r0;
                        zzab zzab2 = new zzab(this, i, skuDetails, type, billingFlowParams, zza2);
                        future = zza(zzab, 5000, (Runnable) null);
                        j = 5000;
                    } else {
                        j = 5000;
                        if (z2) {
                            future = zza(new zzaa(this, billingFlowParams2, skuDetails), 5000, (Runnable) null);
                        } else {
                            future = zza(new zzad(this, skuDetails, type), 5000, (Runnable) null);
                        }
                    }
                    try {
                        Bundle bundle = (Bundle) future.get(j, TimeUnit.MILLISECONDS);
                        int zza3 = zzb.zza(bundle, "BillingClient");
                        String zzb2 = zzb.zzb(bundle, "BillingClient");
                        if (zza3 != 0) {
                            StringBuilder sb3 = new StringBuilder(52);
                            sb3.append("Unable to buy item, Error response code: ");
                            sb3.append(zza3);
                            zzb.zzb("BillingClient", sb3.toString());
                            BillingResult.Builder newBuilder = BillingResult.newBuilder();
                            newBuilder.zza = zza3;
                            newBuilder.zzb = zzb2;
                            BillingResult build = newBuilder.build();
                            this.zzd.zzb.zza.onPurchasesUpdated(build, (List<Purchase>) null);
                            return build;
                        }
                        Intent intent = new Intent(activity2, ProxyBillingActivity.class);
                        intent.putExtra("result_receiver", this.zzt);
                        intent.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                        activity2.startActivity(intent);
                        return zzak.zzn;
                    } catch (CancellationException | TimeoutException unused) {
                        StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 68);
                        sb4.append("Time out while launching billing flow: ; for sku: ");
                        sb4.append(str);
                        sb4.append("; try to reconnect");
                        zzb.zzb("BillingClient", sb4.toString());
                        BillingResult billingResult2 = zzak.zzp;
                        zza(billingResult2);
                        return billingResult2;
                    } catch (Exception unused2) {
                        StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 69);
                        sb5.append("Exception while launching billing flow: ; for sku: ");
                        sb5.append(str);
                        sb5.append("; try to reconnect");
                        zzb.zzb("BillingClient", sb5.toString());
                        BillingResult billingResult3 = zzak.zzo;
                        zza(billingResult3);
                        return billingResult3;
                    }
                } else {
                    zzb.zzb("BillingClient", "Current client doesn't support extra params for buy intent.");
                    BillingResult billingResult4 = zzak.zzh;
                    zza(billingResult4);
                    return billingResult4;
                }
            } else {
                zzb.zzb("BillingClient", "Current client doesn't support subscriptions update.");
                BillingResult billingResult5 = zzak.zzr;
                zza(billingResult5);
                return billingResult5;
            }
        } else {
            zzb.zzb("BillingClient", "Current client doesn't support subscriptions.");
            BillingResult billingResult6 = zzak.zzq;
            zza(billingResult6);
            return billingResult6;
        }
    }

    @NonNull
    public Purchase.PurchasesResult queryPurchases(String str) {
        if (!isReady()) {
            return new Purchase.PurchasesResult(zzak.zzo, (List<Purchase>) null);
        }
        if (TextUtils.isEmpty(str)) {
            zzb.zzb("BillingClient", "Please provide a valid SKU type.");
            return new Purchase.PurchasesResult(zzak.zzg, (List<Purchase>) null);
        }
        try {
            return (Purchase.PurchasesResult) zza(new zzac(this, str), 5000, (Runnable) null).get(5000, TimeUnit.MILLISECONDS);
        } catch (CancellationException | TimeoutException unused) {
            return new Purchase.PurchasesResult(zzak.zzp, (List<Purchase>) null);
        } catch (Exception unused2) {
            return new Purchase.PurchasesResult(zzak.zzl, (List<Purchase>) null);
        }
    }

    public void startConnection(@NonNull BillingClientStateListener billingClientStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            zzb.zza("BillingClient", "Service connection is valid. No need to re-initialize.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzn);
            return;
        }
        int i = this.zza;
        if (i == 1) {
            zzb.zzb("BillingClient", "Client is already in the process of connecting to billing service.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzd);
        } else if (i == 3) {
            zzb.zzb("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzo);
        } else {
            this.zza = 1;
            zzd zzd2 = this.zzd;
            zze zze = zzd2.zzb;
            Context context = zzd2.zza;
            IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
            if (!zze.zzb) {
                context.registerReceiver(zze.zzc.zzb, intentFilter);
                zze.zzb = true;
            }
            zzb.zza("BillingClient", "Starting in-app billing setup.");
            this.zzh = new zza(billingClientStateListener, (zzh) null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.zzf.getPackageManager().queryIntentServices(intent, 0);
            if (!(queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null)) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    zzb.zzb("BillingClient", "The device doesn't have valid Play Store.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zzf.bindService(intent2, this.zzh, 1)) {
                        zzb.zza("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    zzb.zzb("BillingClient", "Connection to Billing service is blocked.");
                }
            }
            this.zza = 0;
            zzb.zza("BillingClient", "Billing service unavailable on device.");
            billingClientStateListener.onBillingSetupFinished(zzak.zzc);
        }
    }

    public final BillingResult zza(BillingResult billingResult) {
        this.zzd.zzb.zza.onPurchasesUpdated(billingResult, (List<Purchase>) null);
        return billingResult;
    }

    public final BillingResult zzc() {
        int i = this.zza;
        if (i == 0 || i == 3) {
            return zzak.zzo;
        }
        return zzak.zzl;
    }

    @Nullable
    public final <T> Future<T> zza(@NonNull Callable<T> callable, long j, @Nullable Runnable runnable) {
        double d = (double) j;
        Double.isNaN(d);
        long j2 = (long) (d * 0.95d);
        if (this.zzr == null) {
            this.zzr = Executors.newFixedThreadPool(zzb.zza);
        }
        try {
            Future<T> submit = this.zzr.submit(callable);
            this.zzc.postDelayed(new zzs(submit, runnable), j2);
            return submit;
        } catch (Exception e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 28);
            sb.append("Async task throws exception ");
            sb.append(valueOf);
            zzb.zzb("BillingClient", sb.toString());
            return null;
        }
    }

    public final void zza(Runnable runnable) {
        if (!Thread.interrupted()) {
            this.zzc.post(runnable);
        }
    }
}
