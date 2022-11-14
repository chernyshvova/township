package com.playrix.engine;

import com.playrix.market.BuildConfig;
import com.swrve.sdk.SwrveAppStore;

public class EngineBilling {
    public static final int RESULT_CODE_ALREADY_PURCHASED = 4;
    public static final int RESULT_CODE_CANCELED = 1;
    public static final int RESULT_CODE_ERROR = 2;
    public static final int RESULT_CODE_INVALID_PRODUCT = 3;
    public static final int RESULT_CODE_MARKET_UNAVAILABLE = 5;
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int STATUS_CODE_DISABLED = 1;
    public static final int STATUS_CODE_INITIALIZING = 3;
    public static final int STATUS_CODE_PROCESSING_ACKNOWLEDGE = 8;
    public static final int STATUS_CODE_PROCESSING_BUY = 4;
    public static final int STATUS_CODE_PROCESSING_CONSUME = 5;
    public static final int STATUS_CODE_PROCESSING_REQUEST_PRODUCTS = 6;
    public static final int STATUS_CODE_PROCESSING_REQUEST_PURCHASES = 7;
    public static final int STATUS_CODE_READY = 0;
    public static final int STATUS_CODE_UNINITIALIZED = 2;
    public static final int STORE_TYPE_AMAZON = 2;
    public static final int STORE_TYPE_GOOGLE = 1;
    public static final int STORE_TYPE_HUAWEI = 6;
    public static final int STORE_TYPE_NONE = 0;
    public static final int STORE_TYPE_ONESTORE = 9;
    public static final int STORE_TYPE_SAMSUNG = 5;

    public interface IBilling {
        void marketAcknowledgeProduct(long j, String str, String str2, String str3);

        void marketCancelRequest();

        void marketConsumeProduct(long j, String str, String str2, String str3);

        void marketDisconnect();

        void marketInitialize(long j);

        void marketRequestActivePurchases(long j);

        void marketRequestProducts(long j, String[] strArr);

        void marketRequestPurchase(long j, String str, String str2, String str3);

        int marketStatus();
    }

    public static class ItemDetails {
        public String mCurrencyCode;
        public String mDescr;
        public boolean mOwned;
        public String mPrice;
        public double mPriceNumeric;
        public String mSku;
        public String mTitle;

        public ItemDetails(String str, String str2, double d, String str3, String str4, String str5, boolean z) {
            this.mSku = str;
            this.mPrice = str2;
            this.mPriceNumeric = d;
            this.mTitle = str3;
            this.mDescr = str4;
            this.mCurrencyCode = str5;
            this.mOwned = z;
        }

        public String getCurrencyCode() {
            return this.mCurrencyCode;
        }

        public String getDescr() {
            return this.mDescr;
        }

        public boolean getOwnInfo() {
            return this.mOwned;
        }

        public String getPrice() {
            return this.mPrice;
        }

        public double getPriceNumeric() {
            return this.mPriceNumeric;
        }

        public String getSku() {
            return this.mSku;
        }

        public String getTitle() {
            return this.mTitle;
        }
    }

    public static class PurchaseDetails {
        public final boolean mAcknowledged;
        public final String mData;
        public final String mDataSignature;
        public final String mOrderId;
        public final String mPayload;
        public final int mQuantity;
        public final String mSku;

        public PurchaseDetails(String str, String str2, int i, String str3, String str4, String str5, boolean z) {
            this.mSku = str;
            this.mOrderId = str2;
            this.mQuantity = i;
            this.mData = str3;
            this.mDataSignature = str4;
            this.mPayload = str5;
            this.mAcknowledged = z;
        }

        public boolean getAcknowledged() {
            return this.mAcknowledged;
        }

        public String getData() {
            return this.mData;
        }

        public String getDataSignature() {
            return this.mDataSignature;
        }

        public String getOrderId() {
            return this.mOrderId;
        }

        public String getPayload() {
            return this.mPayload;
        }

        public int getQuantity() {
            return this.mQuantity;
        }

        public String getSku() {
            return this.mSku;
        }
    }

    public static void callMarketAcknowledgeResponse(final long j, final PurchaseDetails purchaseDetails, final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketAcknowledgeResponse(j, purchaseDetails, i);
            }
        });
    }

    public static void callMarketActivePurchasesResponse(final long j, final PurchaseDetails[] purchaseDetailsArr, final boolean z) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketActivePurchasesResponse(j, purchaseDetailsArr, z);
            }
        });
    }

    public static void callMarketConsumeResponse(final long j, final PurchaseDetails purchaseDetails, final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketConsumeResponse(j, purchaseDetails, i);
            }
        });
    }

    public static void callMarketInitializeFinished(final long j, final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketInitializeFinished(j, i);
            }
        });
    }

    public static void callMarketLog(final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketLog(str);
            }
        });
    }

    public static void callMarketProductsResponse(final long j, final ItemDetails[] itemDetailsArr, final boolean z) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketProductsResponse(j, itemDetailsArr, z);
            }
        });
    }

    public static void callMarketPurchaseResponse(final long j, final PurchaseDetails purchaseDetails, final int i) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketPurchaseResponse(j, purchaseDetails, i);
            }
        });
    }

    public static void callMarketServiceDisconnected(final long j) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketServiceDisconnected(j);
            }
        });
    }

    public static void callPurchasesChanged(final PurchaseDetails[] purchaseDetailsArr) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                EngineBilling.nativeOnMarketPurchasesChanged(purchaseDetailsArr);
            }
        });
    }

    public static int getStoreType() {
        String flavor = Engine.getFlavor(BuildConfig.LIBRARY_PACKAGE_NAME);
        if (flavor == null) {
            return 0;
        }
        if (flavor.equals(BuildConfig.FLAVOR)) {
            return 1;
        }
        if (flavor.equals(SwrveAppStore.Amazon)) {
            return 2;
        }
        if (flavor.equals("samsung")) {
            return 5;
        }
        if (flavor.equals(SwrveAppStore.Huawei)) {
            return 6;
        }
        return flavor.equals("onestore") ? 9 : 0;
    }

    public static native void nativeOnMarketAcknowledgeResponse(long j, PurchaseDetails purchaseDetails, int i);

    public static native void nativeOnMarketActivePurchasesResponse(long j, PurchaseDetails[] purchaseDetailsArr, boolean z);

    public static native void nativeOnMarketConsumeResponse(long j, PurchaseDetails purchaseDetails, int i);

    public static native void nativeOnMarketInitializeFinished(long j, int i);

    public static native void nativeOnMarketLog(String str);

    public static native void nativeOnMarketProductsResponse(long j, ItemDetails[] itemDetailsArr, boolean z);

    public static native void nativeOnMarketPurchaseResponse(long j, PurchaseDetails purchaseDetails, int i);

    public static native void nativeOnMarketPurchasesChanged(PurchaseDetails[] purchaseDetailsArr);

    public static native void nativeOnMarketServiceDisconnected(long j);
}
