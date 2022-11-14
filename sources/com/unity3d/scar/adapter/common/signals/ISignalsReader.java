package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.services.ads.gmascar.handlers.SignalsHandler;

public interface ISignalsReader {
    void getSCARSignals(Context context, String[] strArr, String[] strArr2, SignalsHandler signalsHandler);
}
