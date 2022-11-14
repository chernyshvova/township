package com.unity3d.scar.adapter.v1950.signals;

import com.google.android.gms.ads.query.QueryInfo;

public class QueryInfoMetadata {
    public String _error;
    public String _placementId;
    public QueryInfo _queryInfo;

    public QueryInfoMetadata(String str) {
        this._placementId = str;
    }
}
