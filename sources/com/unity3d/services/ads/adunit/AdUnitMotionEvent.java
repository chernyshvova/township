package com.unity3d.services.ads.adunit;

public class AdUnitMotionEvent {
    public int _action;
    public int _deviceId;
    public long _eventTime;
    public boolean _isObscured;
    public float _pressure;
    public float _size;
    public int _source;
    public int _toolType;

    /* renamed from: _x */
    public float f2836_x;

    /* renamed from: _y */
    public float f2837_y;

    public AdUnitMotionEvent(int i, boolean z, int i2, int i3, int i4, float f, float f2, long j, float f3, float f4) {
        this._action = i;
        this._isObscured = z;
        this._toolType = i2;
        this._source = i3;
        this._deviceId = i4;
        this.f2836_x = f;
        this.f2837_y = f2;
        this._eventTime = j;
        this._pressure = f3;
        this._size = f4;
    }

    public int getAction() {
        return this._action;
    }

    public int getDeviceId() {
        return this._deviceId;
    }

    public long getEventTime() {
        return this._eventTime;
    }

    public float getPressure() {
        return this._pressure;
    }

    public float getSize() {
        return this._size;
    }

    public int getSource() {
        return this._source;
    }

    public int getToolType() {
        return this._toolType;
    }

    public float getX() {
        return this.f2836_x;
    }

    public float getY() {
        return this.f2837_y;
    }

    public boolean isObscured() {
        return this._isObscured;
    }
}
