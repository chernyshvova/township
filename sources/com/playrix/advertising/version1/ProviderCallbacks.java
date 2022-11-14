package com.playrix.advertising.version1;

import com.playrix.advertising.version1.ProviderInterface;

public class ProviderCallbacks implements ProviderInterface.Callbacks {
    public static Call _call = new Call() {
        public void run(Runnable runnable) {
        }
    };
    public static ProviderInterface[] _providers = null;
    public final int _callbacksId;

    public interface Call {
        void run(Runnable runnable);
    }

    public ProviderCallbacks(int i) {
        this._callbacksId = i;
    }

    public static String[] getNatives() {
        return ProvidersConfig.getNatives();
    }

    public static ProviderInterface[] getProviders() {
        if (_providers == null) {
            _providers = ProvidersConfig.getProviders();
        }
        return _providers;
    }

    public static native void nativeOnAssert(int i, String str);

    public static native void nativeOnLoadFailed(int i, int i2, String str, String str2);

    public static native void nativeOnLoadSuccess(int i, int i2, String str, String str2);

    public static native void nativeOnLog(int i, String str);

    public static native void nativeOnShowDone(int i, int i2, String str, boolean z);

    public static native void nativeOnShowFinish(int i, int i2);

    public static native void nativeOnShowStart(int i);

    public static native void nativeOnTrackMediation(int i, String str);

    public static void setCall(Call call) {
        _call = call;
    }

    public void onAssert(final String str) {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnLog(ProviderCallbacks.this._callbacksId, str);
            }
        });
    }

    public void onLoadFailed(final int i, final String str, final String str2) {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnLoadFailed(ProviderCallbacks.this._callbacksId, i, str, str2);
            }
        });
    }

    public void onLoadSuccess(final int i, final String str, final String str2) {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnLoadSuccess(ProviderCallbacks.this._callbacksId, i, str, str2);
            }
        });
    }

    public void onLog(final String str) {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnLog(ProviderCallbacks.this._callbacksId, str);
            }
        });
    }

    public void onShowDone(final int i, final String str, final boolean z) {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnShowDone(ProviderCallbacks.this._callbacksId, i, str, z);
            }
        });
    }

    public void onShowFinish(final int i) {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnShowFinish(ProviderCallbacks.this._callbacksId, i);
            }
        });
    }

    public void onShowStart() {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnShowStart(ProviderCallbacks.this._callbacksId);
            }
        });
    }

    public void onTrackMediation(final String str) {
        _call.run(new Runnable() {
            public void run() {
                ProviderCallbacks.nativeOnTrackMediation(ProviderCallbacks.this._callbacksId, str);
            }
        });
    }
}
