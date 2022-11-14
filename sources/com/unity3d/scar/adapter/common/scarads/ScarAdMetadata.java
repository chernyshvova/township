package com.unity3d.scar.adapter.common.scarads;

public class ScarAdMetadata {
    public String _adString;
    public String _adUnitId;
    public String _placementId;
    public String _queryId;
    public Integer _videoLengthMs;

    public ScarAdMetadata(String str, String str2, String str3, String str4, Integer num) {
        this._placementId = str;
        this._queryId = str2;
        this._adUnitId = str3;
        this._adString = str4;
        this._videoLengthMs = num;
    }
}
