package com.playrix.gplay;

import android.app.Activity;
import android.text.TextUtils;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientImpl;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.android.billingclient.api.zza;
import com.android.billingclient.api.zzak;
import com.android.billingclient.api.zzal;
import com.android.billingclient.api.zzg;
import com.android.billingclient.api.zzi;
import com.android.billingclient.api.zzk;
import com.android.billingclient.api.zzl;
import com.android.billingclient.api.zzo;
import com.android.billingclient.api.zzt;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.play_billing.zzb;
import com.playrix.engine.Engine;
import com.playrix.engine.EngineActivity;
import com.playrix.engine.EngineBilling;
import com.playrix.gplay.billing.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billing implements EngineBilling.IBilling {
    public static final String testPurchasePrefix = "android.test.";
    public static final String tokenPrefix = "token:";
    public Request asyncRequestInProgress = null;
    public BillingClient billingClient = null;
    public boolean isServiceConnected = false;
    public long lastInitializingRequestId = 0;
    public volatile Activity mainActivity = null;
    public final Map<String, SkuDetails> receivedSkuDetails = new HashMap();
    public final String signatureBase64;

    public Billing(String str) {
        this.signatureBase64 = str;
    }

    public static String GetPurchaseTransactionId(Purchase purchase) {
        String optString = purchase.zzc.optString("orderId");
        if (!TextUtils.isEmpty(optString)) {
            return optString;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24(tokenPrefix);
        outline24.append(purchase.getPurchaseToken());
        return outline24.toString();
    }

    /* access modifiers changed from: private */
    public void OnServiceDisconnected(long j) {
        EngineBilling.callMarketLog("Billing - service disconnected");
        EngineBilling.callMarketServiceDisconnected(j);
    }

    public static EngineBilling.PurchaseDetails createEmptyPurchase(String str) {
        return new EngineBilling.PurchaseDetails(str, (String) null, 1, (String) null, (String) null, (String) null, false);
    }

    public static EngineBilling.ItemDetails createItemDetails(SkuDetails skuDetails) {
        return new EngineBilling.ItemDetails(skuDetails.getSku(), skuDetails.zzb.optString("price"), (double) (((float) skuDetails.zzb.optLong("price_amount_micros")) * 1.0E-6f), skuDetails.zzb.optString("title"), skuDetails.zzb.optString("description"), skuDetails.zzb.optString("price_currency_code"), false);
    }

    public static EngineBilling.PurchaseDetails createPurchaseDetails(Purchase purchase) {
        String str;
        String str2;
        boolean z = (purchase.zzc.optInt("purchaseState", 1) != 4 ? (char) 1 : 2) == 1;
        String sku = purchase.getSku();
        String GetPurchaseTransactionId = GetPurchaseTransactionId(purchase);
        String str3 = z ? purchase.zza : null;
        if (z) {
            if (isTestPurchase(purchase)) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                str2 = purchase.zzb;
            }
            str = str2;
        } else {
            str = null;
        }
        return new EngineBilling.PurchaseDetails(sku, GetPurchaseTransactionId, 1, str3, str, (String) null, purchase.zzc.optBoolean("acknowledged", true));
    }

    /* access modifiers changed from: private */
    public EngineBilling.PurchaseDetails[] createPurchasesDetails(List<Purchase> list) {
        ArrayList arrayList = new ArrayList();
        for (Purchase next : list) {
            if (verifyPurchase(this.signatureBase64, next)) {
                arrayList.add(createPurchaseDetails(next));
            }
        }
        return (EngineBilling.PurchaseDetails[]) arrayList.toArray(new EngineBilling.PurchaseDetails[arrayList.size()]);
    }

    private void executeRequest(final Request request, final Runnable runnable, final Runnable runnable2) {
        this.mainActivity.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (Billing.this) {
                    if (Billing.this.asyncRequestInProgress == null) {
                        if (Billing.this.isServiceConnected) {
                            Request unused = Billing.this.asyncRequestInProgress = request;
                            runnable.run();
                            return;
                        }
                    }
                    runnable2.run();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public Purchase findPurchaseInClient(String str, String str2) {
        Purchase.PurchasesResult queryPurchases = this.billingClient.queryPurchases("inapp");
        if (processBillingResult(queryPurchases != null ? queryPurchases.zzb : null, "Find purchase").zza == 0) {
            for (Purchase next : queryPurchases.zza) {
                if (next.getSku().equals(str) && GetPurchaseTransactionId(next).equals(str2)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static Purchase findPurchaseInList(String str, List<Purchase> list) {
        if (list == null) {
            return null;
        }
        for (Purchase next : list) {
            if (next.getSku().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public synchronized void finishAsyncRequest() {
        this.asyncRequestInProgress = null;
    }

    public static boolean isTestPurchase(Purchase purchase) {
        return !TextUtils.isEmpty(purchase.getSku()) && purchase.getSku().startsWith(testPurchasePrefix) && TextUtils.isEmpty(purchase.zzb);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0078, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onPurchasesUpdated(com.android.billingclient.api.BillingResult r6, java.util.List<com.android.billingclient.api.Purchase> r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "Purchases updated"
            com.android.billingclient.api.BillingResult r6 = processBillingResult(r6, r0)     // Catch:{ all -> 0x0079 }
            com.playrix.gplay.Billing$Request r0 = r5.asyncRequestInProgress     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x006c
            com.playrix.gplay.Billing$Request r0 = r5.asyncRequestInProgress     // Catch:{ all -> 0x0079 }
            int r0 = r0.status     // Catch:{ all -> 0x0079 }
            r1 = 4
            if (r0 != r1) goto L_0x006c
            com.playrix.gplay.Billing$Request r0 = r5.asyncRequestInProgress     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.purchaseSku     // Catch:{ all -> 0x0079 }
            if (r0 == 0) goto L_0x006c
            com.playrix.gplay.Billing$Request r0 = r5.asyncRequestInProgress     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r0.purchaseSku     // Catch:{ all -> 0x0079 }
            com.playrix.engine.EngineBilling$PurchaseDetails r0 = createEmptyPurchase(r0)     // Catch:{ all -> 0x0079 }
            r2 = 2
            int r3 = r6.zza     // Catch:{ all -> 0x0079 }
            r4 = 1
            if (r3 != 0) goto L_0x004e
            com.playrix.gplay.Billing$Request r6 = r5.asyncRequestInProgress     // Catch:{ all -> 0x0079 }
            java.lang.String r6 = r6.purchaseSku     // Catch:{ all -> 0x0079 }
            com.android.billingclient.api.Purchase r6 = findPurchaseInList(r6, r7)     // Catch:{ all -> 0x0079 }
            if (r6 != 0) goto L_0x003e
            java.lang.String r6 = "Skip update"
            com.playrix.engine.EngineBilling.callMarketLog(r6)     // Catch:{ all -> 0x0079 }
            com.playrix.engine.EngineBilling$PurchaseDetails[] r6 = r5.createPurchasesDetails(r7)     // Catch:{ all -> 0x0079 }
            com.playrix.engine.EngineBilling.callPurchasesChanged(r6)     // Catch:{ all -> 0x0079 }
            monitor-exit(r5)
            return
        L_0x003e:
            java.lang.String r7 = r5.signatureBase64     // Catch:{ all -> 0x0079 }
            boolean r7 = verifyPurchase(r7, r6)     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x0060
            com.playrix.engine.EngineBilling$PurchaseDetails r6 = createPurchaseDetails(r6)     // Catch:{ all -> 0x0079 }
            r7 = 0
            r0 = r6
            r1 = 0
            goto L_0x0061
        L_0x004e:
            int r7 = r6.zza     // Catch:{ all -> 0x0079 }
            if (r7 != r4) goto L_0x0054
            r1 = 1
            goto L_0x0061
        L_0x0054:
            int r7 = r6.zza     // Catch:{ all -> 0x0079 }
            if (r7 != r1) goto L_0x005a
            r1 = 3
            goto L_0x0061
        L_0x005a:
            int r6 = r6.zza     // Catch:{ all -> 0x0079 }
            r7 = 7
            if (r6 != r7) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r1 = 2
        L_0x0061:
            com.playrix.gplay.Billing$Request r6 = r5.asyncRequestInProgress     // Catch:{ all -> 0x0079 }
            long r6 = r6.requestId     // Catch:{ all -> 0x0079 }
            com.playrix.engine.EngineBilling.callMarketPurchaseResponse(r6, r0, r1)     // Catch:{ all -> 0x0079 }
            r5.finishAsyncRequest()     // Catch:{ all -> 0x0079 }
            goto L_0x0077
        L_0x006c:
            int r6 = r6.zza     // Catch:{ all -> 0x0079 }
            if (r6 != 0) goto L_0x0077
            com.playrix.engine.EngineBilling$PurchaseDetails[] r6 = r5.createPurchasesDetails(r7)     // Catch:{ all -> 0x0079 }
            com.playrix.engine.EngineBilling.callPurchasesChanged(r6)     // Catch:{ all -> 0x0079 }
        L_0x0077:
            monitor-exit(r5)
            return
        L_0x0079:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.playrix.gplay.Billing.onPurchasesUpdated(com.android.billingclient.api.BillingResult, java.util.List):void");
    }

    public static BillingResult processBillingResult(BillingResult billingResult, String str) {
        if (billingResult == null) {
            EngineBilling.callMarketLog(str + " finished with null result.");
            BillingResult.Builder newBuilder = BillingResult.newBuilder();
            newBuilder.zzb = "Null result";
            newBuilder.zza = 6;
            return newBuilder.build();
        }
        StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, " finished with response code: ");
        outline26.append(billingResult.zza);
        outline26.append(" message: ");
        outline26.append(billingResult.zzb);
        EngineBilling.callMarketLog(outline26.toString());
        return billingResult;
    }

    public static boolean verifyPurchase(String str, Purchase purchase) {
        if (isTestPurchase(purchase) || Security.verifyPurchase(str, purchase.zza, purchase.zzb)) {
            return true;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Skip purchase ");
        outline24.append(purchase.getSku());
        outline24.append(" ");
        outline24.append(GetPurchaseTransactionId(purchase));
        outline24.append(" data: ");
        outline24.append(purchase.zza);
        outline24.append(" signature: ");
        outline24.append(purchase.zzb);
        EngineBilling.callMarketLog(outline24.toString());
        return false;
    }

    public void marketAcknowledgeProduct(long j, String str, String str2, String str3) {
        Request request = new Request(8, j);
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        C32959 r1 = new Runnable() {
            public void run() {
                Purchase access$1300 = Billing.this.findPurchaseInClient(str4, str5);
                if (access$1300 == null) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Not found purchase: ");
                    outline24.append(str4);
                    outline24.append(" transactionId: ");
                    outline24.append(str5);
                    EngineBilling.callMarketLog(outline24.toString());
                    EngineBilling.callMarketAcknowledgeResponse(j2, new EngineBilling.PurchaseDetails(str4, str5, 1, (String) null, (String) null, (String) null, false), 3);
                    Billing.this.finishAsyncRequest();
                } else if (access$1300.zzc.optBoolean("acknowledged", true)) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("Already acknowledged purchase: ");
                    outline242.append(str4);
                    outline242.append(" transactionId: ");
                    outline242.append(str5);
                    EngineBilling.callMarketLog(outline242.toString());
                    EngineBilling.callMarketAcknowledgeResponse(j2, new EngineBilling.PurchaseDetails(str4, str5, 1, (String) null, (String) null, (String) null, false), 0);
                    Billing.this.finishAsyncRequest();
                } else {
                    BillingClient access$000 = Billing.this.billingClient;
                    String purchaseToken = access$1300.getPurchaseToken();
                    if (purchaseToken != null) {
                        AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams((zza) null);
                        acknowledgePurchaseParams.zza = purchaseToken;
                        C32961 r0 = new AcknowledgePurchaseResponseListener() {
                            public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                                int i = Billing.processBillingResult(billingResult, "Acknowledge purchase").zza;
                                int i2 = i == 0 ? 0 : (i == 8 || i == 4) ? 3 : 2;
                                C32959 r0 = C32959.this;
                                EngineBilling.callMarketAcknowledgeResponse(j2, new EngineBilling.PurchaseDetails(str4, str5, 1, (String) null, (String) null, (String) null, false), i2);
                                Billing.this.finishAsyncRequest();
                            }
                        };
                        BillingClientImpl billingClientImpl = (BillingClientImpl) access$000;
                        if (!billingClientImpl.isReady()) {
                            r0.onAcknowledgePurchaseResponse(zzak.zzo);
                        } else if (TextUtils.isEmpty(acknowledgePurchaseParams.zza)) {
                            zzb.zzb("BillingClient", "Please provide a valid purchase token.");
                            r0.onAcknowledgePurchaseResponse(zzak.zzk);
                        } else if (!billingClientImpl.zzm) {
                            r0.onAcknowledgePurchaseResponse(zzak.zzb);
                        } else if (billingClientImpl.zza(new zzo(billingClientImpl, acknowledgePurchaseParams, r0), 30000, new zzt(r0)) == null) {
                            r0.onAcknowledgePurchaseResponse(billingClientImpl.zzc());
                        }
                    } else {
                        throw new IllegalArgumentException("Purchase token must be set");
                    }
                }
            }
        };
        final long j3 = j;
        final String str6 = str;
        final String str7 = str2;
        executeRequest(request, r1, new Runnable() {
            public void run() {
                EngineBilling.callMarketAcknowledgeResponse(j3, new EngineBilling.PurchaseDetails(str6, str7, 1, (String) null, (String) null, (String) null, false), 2);
            }
        });
    }

    public void marketCancelRequest() {
        marketDisconnect();
    }

    public void marketConsumeProduct(long j, String str, String str2, String str3) {
        Request request = new Request(5, j);
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        C328311 r1 = new Runnable() {
            public void run() {
                Purchase access$1300 = Billing.this.findPurchaseInClient(str4, str5);
                if (access$1300 == null) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Not found purchase: ");
                    outline24.append(str4);
                    outline24.append(" transactionId: ");
                    outline24.append(str5);
                    EngineBilling.callMarketLog(outline24.toString());
                    EngineBilling.callMarketConsumeResponse(j2, new EngineBilling.PurchaseDetails(str4, str5, 1, (String) null, (String) null, (String) null, false), 3);
                    Billing.this.finishAsyncRequest();
                    return;
                }
                BillingClient access$000 = Billing.this.billingClient;
                String purchaseToken = access$1300.getPurchaseToken();
                if (purchaseToken != null) {
                    ConsumeParams consumeParams = new ConsumeParams((zzal) null);
                    consumeParams.zza = purchaseToken;
                    C32841 r0 = new ConsumeResponseListener() {
                        public void onConsumeResponse(BillingResult billingResult, String str) {
                            int i = Billing.processBillingResult(billingResult, "Consume purchase").zza;
                            int i2 = i == 0 ? 0 : (i == 8 || i == 4) ? 3 : 2;
                            C328311 r13 = C328311.this;
                            EngineBilling.callMarketConsumeResponse(j2, new EngineBilling.PurchaseDetails(str4, str5, 1, (String) null, (String) null, (String) null, false), i2);
                            Billing.this.finishAsyncRequest();
                        }
                    };
                    BillingClientImpl billingClientImpl = (BillingClientImpl) access$000;
                    if (!billingClientImpl.isReady()) {
                        r0.onConsumeResponse(zzak.zzo, consumeParams.zza);
                    } else if (billingClientImpl.zza(new zzl(billingClientImpl, consumeParams, r0), 30000, new zzk(r0, consumeParams)) == null) {
                        r0.onConsumeResponse(billingClientImpl.zzc(), consumeParams.zza);
                    }
                } else {
                    throw new IllegalArgumentException("Purchase token must be set");
                }
            }
        };
        final long j3 = j;
        final String str6 = str;
        final String str7 = str2;
        executeRequest(request, r1, new Runnable() {
            public void run() {
                EngineBilling.callMarketConsumeResponse(j3, new EngineBilling.PurchaseDetails(str6, str7, 1, (String) null, (String) null, (String) null, false), 2);
            }
        });
    }

    public void marketDisconnect() {
        if (this.mainActivity != null) {
            this.mainActivity.runOnUiThread(new Runnable() {
                public void run() {
                    synchronized (Billing.this) {
                        if (Billing.this.isServiceConnected) {
                            boolean unused = Billing.this.isServiceConnected = false;
                            Billing.this.billingClient.endConnection();
                            BillingClient unused2 = Billing.this.billingClient = null;
                            Billing.this.finishAsyncRequest();
                            Billing.this.OnServiceDisconnected(Billing.this.lastInitializingRequestId);
                        }
                    }
                }
            });
        }
    }

    public void marketInitialize(final long j) {
        EngineActivity activity = Engine.getActivity();
        if (activity == null) {
            EngineBilling.callMarketInitializeFinished(j, 2);
            return;
        }
        this.mainActivity = activity;
        this.mainActivity.runOnUiThread(new Runnable() {
            public void run() {
                if (Billing.this.billingClient == null) {
                    Billing billing = Billing.this;
                    Activity access$200 = billing.mainActivity;
                    C32801 r2 = new PurchasesUpdatedListener() {
                        public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
                            Billing.this.onPurchasesUpdated(billingResult, list);
                        }
                    };
                    if (access$200 != null) {
                        BillingClient unused = billing.billingClient = new BillingClientImpl(true, access$200, r2);
                    } else {
                        throw new IllegalArgumentException("Please provide a valid Context.");
                    }
                }
                synchronized (Billing.this) {
                    if (Billing.this.isServiceConnected) {
                        EngineBilling.callMarketInitializeFinished(j, 0);
                        return;
                    }
                    long unused2 = Billing.this.lastInitializingRequestId = j;
                    Request unused3 = Billing.this.asyncRequestInProgress = new Request(3, j);
                    Billing.this.billingClient.startConnection(new BillingClientStateListener() {
                        public void onBillingServiceDisconnected() {
                            synchronized (Billing.this) {
                                boolean unused = Billing.this.isServiceConnected = false;
                                if (Billing.this.asyncRequestInProgress != null && Billing.this.asyncRequestInProgress.status == 3) {
                                    Billing.this.finishAsyncRequest();
                                    EngineBilling.callMarketInitializeFinished(j, 2);
                                }
                                Billing.this.OnServiceDisconnected(j);
                            }
                        }

                        public void onBillingSetupFinished(BillingResult billingResult) {
                            synchronized (Billing.this) {
                                BillingResult access$600 = Billing.processBillingResult(billingResult, "Setup");
                                if (access$600.zza == 0) {
                                    boolean unused = Billing.this.isServiceConnected = true;
                                }
                                if (Billing.this.asyncRequestInProgress != null && Billing.this.asyncRequestInProgress.status == 3) {
                                    Billing.this.finishAsyncRequest();
                                    EngineBilling.callMarketLog("Initialize finished");
                                    int i = 2;
                                    if (access$600.zza == 0) {
                                        i = 0;
                                    } else if (access$600.zza == 3) {
                                        i = 5;
                                    }
                                    EngineBilling.callMarketInitializeFinished(j, i);
                                }
                            }
                        }
                    });
                }
            }
        });
    }

    public void marketRequestActivePurchases(final long j) {
        executeRequest(new Request(7, j), new Runnable() {
            public void run() {
                Purchase.PurchasesResult queryPurchases = Billing.this.billingClient.queryPurchases("inapp");
                if (Billing.processBillingResult(queryPurchases != null ? queryPurchases.zzb : null, "Request purchases").zza == 0) {
                    EngineBilling.callMarketActivePurchasesResponse(j, Billing.this.createPurchasesDetails(queryPurchases.zza), true);
                } else {
                    EngineBilling.callMarketActivePurchasesResponse(j, (EngineBilling.PurchaseDetails[]) null, false);
                }
                Billing.this.finishAsyncRequest();
            }
        }, new Runnable() {
            public void run() {
                EngineBilling.callMarketActivePurchasesResponse(j, (EngineBilling.PurchaseDetails[]) null, false);
            }
        });
    }

    public void marketRequestProducts(final long j, final String[] strArr) {
        executeRequest(new Request(6, j), new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
                BillingClient access$000 = Billing.this.billingClient;
                C32891 r7 = new SkuDetailsResponseListener() {
                    public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
                        if (Billing.processBillingResult(billingResult, "Request products").zza == 0) {
                            ArrayList arrayList = new ArrayList();
                            for (SkuDetails access$900 : list) {
                                arrayList.add(Billing.createItemDetails(access$900));
                            }
                            synchronized (Billing.this) {
                                for (SkuDetails next : list) {
                                    Billing.this.receivedSkuDetails.put(next.getSku(), next);
                                }
                            }
                            EngineBilling.callMarketProductsResponse(j, (EngineBilling.ItemDetails[]) arrayList.toArray(new EngineBilling.ItemDetails[arrayList.size()]), true);
                        } else {
                            EngineBilling.callMarketProductsResponse(j, (EngineBilling.ItemDetails[]) null, false);
                        }
                        Billing.this.finishAsyncRequest();
                    }
                };
                BillingClientImpl billingClientImpl = (BillingClientImpl) access$000;
                if (!billingClientImpl.isReady()) {
                    r7.onSkuDetailsResponse(zzak.zzo, (List<SkuDetails>) null);
                } else if (TextUtils.isEmpty("inapp")) {
                    zzb.zzb("BillingClient", "Please fix the input params. SKU type can't be empty.");
                    r7.onSkuDetailsResponse(zzak.zzg, (List<SkuDetails>) null);
                } else {
                    boolean z = billingClientImpl.zzp;
                    if (billingClientImpl.zza(new zzg(billingClientImpl, "inapp", arrayList, (String) null, r7), 30000, new zzi(r7)) == null) {
                        r7.onSkuDetailsResponse(billingClientImpl.zzc(), (List<SkuDetails>) null);
                    }
                }
            }
        }, new Runnable() {
            public void run() {
                EngineBilling.callMarketProductsResponse(j, (EngineBilling.ItemDetails[]) null, false);
            }
        });
    }

    public void marketRequestPurchase(final long j, final String str, String str2, String str3) {
        final String str4 = str;
        final long j2 = j;
        final String str5 = str3;
        executeRequest(new Request(4, j, str), new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0088, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    com.playrix.gplay.Billing r0 = com.playrix.gplay.Billing.this
                    monitor-enter(r0)
                    com.playrix.gplay.Billing r1 = com.playrix.gplay.Billing.this     // Catch:{ all -> 0x0089 }
                    java.util.Map r1 = r1.receivedSkuDetails     // Catch:{ all -> 0x0089 }
                    java.lang.String r2 = r3     // Catch:{ all -> 0x0089 }
                    java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0089 }
                    com.android.billingclient.api.SkuDetails r1 = (com.android.billingclient.api.SkuDetails) r1     // Catch:{ all -> 0x0089 }
                    if (r1 != 0) goto L_0x003c
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
                    r1.<init>()     // Catch:{ all -> 0x0089 }
                    java.lang.String r2 = "Not found purchase: "
                    r1.append(r2)     // Catch:{ all -> 0x0089 }
                    java.lang.String r2 = r3     // Catch:{ all -> 0x0089 }
                    r1.append(r2)     // Catch:{ all -> 0x0089 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0089 }
                    com.playrix.engine.EngineBilling.callMarketLog(r1)     // Catch:{ all -> 0x0089 }
                    long r1 = r4     // Catch:{ all -> 0x0089 }
                    java.lang.String r3 = r3     // Catch:{ all -> 0x0089 }
                    com.playrix.engine.EngineBilling$PurchaseDetails r3 = com.playrix.gplay.Billing.createEmptyPurchase(r3)     // Catch:{ all -> 0x0089 }
                    r4 = 3
                    com.playrix.engine.EngineBilling.callMarketPurchaseResponse(r1, r3, r4)     // Catch:{ all -> 0x0089 }
                    com.playrix.gplay.Billing r1 = com.playrix.gplay.Billing.this     // Catch:{ all -> 0x0089 }
                    r1.finishAsyncRequest()     // Catch:{ all -> 0x0089 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                    return
                L_0x003c:
                    com.android.billingclient.api.BillingFlowParams$Builder r2 = new com.android.billingclient.api.BillingFlowParams$Builder     // Catch:{ all -> 0x0089 }
                    r3 = 0
                    r2.<init>(r3)     // Catch:{ all -> 0x0089 }
                    java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0089 }
                    r3.<init>()     // Catch:{ all -> 0x0089 }
                    r3.add(r1)     // Catch:{ all -> 0x0089 }
                    r2.zzf = r3     // Catch:{ all -> 0x0089 }
                    java.lang.String r1 = r6     // Catch:{ all -> 0x0089 }
                    boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0089 }
                    if (r1 != 0) goto L_0x0058
                    java.lang.String r1 = r6     // Catch:{ all -> 0x0089 }
                    r2.zza = r1     // Catch:{ all -> 0x0089 }
                L_0x0058:
                    com.playrix.gplay.Billing r1 = com.playrix.gplay.Billing.this     // Catch:{ all -> 0x0089 }
                    com.android.billingclient.api.BillingClient r1 = r1.billingClient     // Catch:{ all -> 0x0089 }
                    com.playrix.gplay.Billing r3 = com.playrix.gplay.Billing.this     // Catch:{ all -> 0x0089 }
                    android.app.Activity r3 = r3.mainActivity     // Catch:{ all -> 0x0089 }
                    com.android.billingclient.api.BillingFlowParams r2 = r2.build()     // Catch:{ all -> 0x0089 }
                    com.android.billingclient.api.BillingResult r1 = r1.launchBillingFlow(r3, r2)     // Catch:{ all -> 0x0089 }
                    java.lang.String r2 = "Buy purchase"
                    com.android.billingclient.api.BillingResult r1 = com.playrix.gplay.Billing.processBillingResult(r1, r2)     // Catch:{ all -> 0x0089 }
                    int r1 = r1.zza     // Catch:{ all -> 0x0089 }
                    if (r1 == 0) goto L_0x0087
                    long r1 = r4     // Catch:{ all -> 0x0089 }
                    java.lang.String r3 = r3     // Catch:{ all -> 0x0089 }
                    com.playrix.engine.EngineBilling$PurchaseDetails r3 = com.playrix.gplay.Billing.createEmptyPurchase(r3)     // Catch:{ all -> 0x0089 }
                    r4 = 2
                    com.playrix.engine.EngineBilling.callMarketPurchaseResponse(r1, r3, r4)     // Catch:{ all -> 0x0089 }
                    com.playrix.gplay.Billing r1 = com.playrix.gplay.Billing.this     // Catch:{ all -> 0x0089 }
                    r1.finishAsyncRequest()     // Catch:{ all -> 0x0089 }
                L_0x0087:
                    monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                    return
                L_0x0089:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.playrix.gplay.Billing.C32937.run():void");
            }
        }, new Runnable() {
            public void run() {
                EngineBilling.callMarketPurchaseResponse(j, Billing.createEmptyPurchase(str), 2);
            }
        });
    }

    public synchronized int marketStatus() {
        if (!this.isServiceConnected) {
            if (this.asyncRequestInProgress == null) {
                return 2;
            }
            return this.asyncRequestInProgress.status;
        } else if (this.asyncRequestInProgress == null) {
            return 0;
        } else {
            return this.asyncRequestInProgress.status;
        }
    }

    public static class Request {
        public final String purchaseSku;
        public final long requestId;
        public final int status;

        public Request(int i, long j, String str) {
            this.status = i;
            this.requestId = j;
            this.purchaseSku = str;
        }

        public Request(int i, long j) {
            this(i, j, (String) null);
        }
    }
}
