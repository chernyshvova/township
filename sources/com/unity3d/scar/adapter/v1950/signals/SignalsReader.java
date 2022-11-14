package com.unity3d.scar.adapter.v1950.signals;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.DispatchGroup;
import com.unity3d.scar.adapter.common.signals.ISignalsReader;
import com.unity3d.services.ads.gmascar.handlers.SignalsHandler;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SignalsReader implements ISignalsReader {
    public static SignalsStorage _signalsStorage;

    public class GMAScarDispatchCompleted implements Runnable {
        public SignalsHandler _signalListener;

        public GMAScarDispatchCompleted(SignalsReader signalsReader, SignalsHandler signalsHandler) {
            this._signalListener = signalsHandler;
        }

        public void run() {
            HashMap hashMap = new HashMap();
            String str = null;
            for (Map.Entry<String, QueryInfoMetadata> value : SignalsReader._signalsStorage._placementQueryInfoMap.entrySet()) {
                QueryInfoMetadata queryInfoMetadata = (QueryInfoMetadata) value.getValue();
                String str2 = queryInfoMetadata._placementId;
                QueryInfo queryInfo = queryInfoMetadata._queryInfo;
                hashMap.put(str2, queryInfo != null ? queryInfo.getQuery() : null);
                String str3 = queryInfoMetadata._error;
                if (str3 != null) {
                    str = str3;
                }
            }
            if (hashMap.size() > 0) {
                this._signalListener.onSignalsCollected(new JSONObject(hashMap).toString());
            } else if (str == null) {
                this._signalListener.onSignalsCollected("");
            } else {
                this._signalListener.onSignalsCollectionFailed(str);
            }
        }
    }

    public SignalsReader(SignalsStorage signalsStorage) {
        _signalsStorage = signalsStorage;
    }

    public final void getSCARSignal(Context context, String str, AdFormat adFormat, DispatchGroup dispatchGroup) {
        AdRequest build = new AdRequest.Builder().build();
        QueryInfoMetadata queryInfoMetadata = new QueryInfoMetadata(str);
        QueryInfoCallback queryInfoCallback = new QueryInfoCallback(queryInfoMetadata, dispatchGroup);
        _signalsStorage._placementQueryInfoMap.put(str, queryInfoMetadata);
        QueryInfo.generate(context, adFormat, build, queryInfoCallback);
    }

    public void getSCARSignals(Context context, String[] strArr, String[] strArr2, SignalsHandler signalsHandler) {
        DispatchGroup dispatchGroup = new DispatchGroup();
        for (String sCARSignal : strArr) {
            dispatchGroup.enter();
            getSCARSignal(context, sCARSignal, AdFormat.INTERSTITIAL, dispatchGroup);
        }
        for (String sCARSignal2 : strArr2) {
            dispatchGroup.enter();
            getSCARSignal(context, sCARSignal2, AdFormat.REWARDED, dispatchGroup);
        }
        GMAScarDispatchCompleted gMAScarDispatchCompleted = new GMAScarDispatchCompleted(this, signalsHandler);
        dispatchGroup._runnable = gMAScarDispatchCompleted;
        if (dispatchGroup._threadCount <= 0) {
            gMAScarDispatchCompleted.run();
        }
    }
}
