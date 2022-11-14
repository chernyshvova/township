package com.unity3d.scar.adapter.v2000.scarads;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2000.signals.QueryInfoMetadata;

public abstract class ScarAdBase<T> implements IScarAd {
    public T _adObj;
    public IAdsErrorHandler _adsErrorHandler;
    public Context _context;
    public QueryInfoMetadata _queryInfoMetadata;
    public ScarAdListener _scarAdListener;
    public ScarAdMetadata _scarAdMetadata;

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, QueryInfoMetadata queryInfoMetadata, IAdsErrorHandler iAdsErrorHandler) {
        this._context = context;
        this._scarAdMetadata = scarAdMetadata;
        this._queryInfoMetadata = queryInfoMetadata;
        this._adsErrorHandler = iAdsErrorHandler;
    }

    public void loadAd(IScarLoadListener iScarLoadListener) {
        QueryInfoMetadata queryInfoMetadata = this._queryInfoMetadata;
        if (queryInfoMetadata != null) {
            AdRequest build = new AdRequest.Builder().setAdInfo(new AdInfo(queryInfoMetadata._queryInfo, this._scarAdMetadata._adString)).build();
            this._scarAdListener._loadListener = iScarLoadListener;
            loadAdInternal(build, iScarLoadListener);
            return;
        }
        this._adsErrorHandler.handleError(GMAAdsError.InternalLoadError(this._scarAdMetadata));
    }

    public abstract void loadAdInternal(AdRequest adRequest, IScarLoadListener iScarLoadListener);
}
