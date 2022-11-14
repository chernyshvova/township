package com.unity3d.scar.adapter.common;

import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.signals.ISignalsReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ScarAdapterBase implements IScarAdapter {
    public IAdsErrorHandler _adsErrorHandler;
    public IScarAd _currentAdReference;
    public Map<String, IScarAd> _loadedAds = new ConcurrentHashMap();
    public ISignalsReader _scarSignalReader;

    public ScarAdapterBase(IAdsErrorHandler iAdsErrorHandler) {
        this._adsErrorHandler = iAdsErrorHandler;
    }
}
