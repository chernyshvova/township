package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1085b;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.utils.m */
public class C1303m implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public final int f2537a;

    /* renamed from: b */
    public final float f2538b;

    /* renamed from: c */
    public final SensorManager f2539c;

    /* renamed from: d */
    public final Sensor f2540d;

    /* renamed from: e */
    public final Sensor f2541e = this.f2539c.getDefaultSensor(4);

    /* renamed from: f */
    public final C1188m f2542f;

    /* renamed from: g */
    public float[] f2543g;

    /* renamed from: h */
    public float f2544h;

    public C1303m(C1188m mVar) {
        this.f2542f = mVar;
        SensorManager sensorManager = (SensorManager) mVar.mo10932L().getSystemService("sensor");
        this.f2539c = sensorManager;
        this.f2540d = sensorManager.getDefaultSensor(9);
        this.f2537a = ((Integer) mVar.mo10946a(C1085b.f1720dU)).intValue();
        this.f2538b = ((Float) mVar.mo10946a(C1085b.f1719dT)).floatValue();
        mVar.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void mo11328a() {
        this.f2539c.unregisterListener(this);
        if (((Boolean) this.f2542f.mo10931K().mo10678a(C1085b.f1717dR)).booleanValue()) {
            this.f2539c.registerListener(this, this.f2540d, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f2537a));
        }
        if (((Boolean) this.f2542f.mo10931K().mo10678a(C1085b.f1718dS)).booleanValue()) {
            this.f2539c.registerListener(this, this.f2541e, (int) TimeUnit.MILLISECONDS.toMicros((long) this.f2537a));
        }
    }

    /* renamed from: b */
    public float mo11329b() {
        return this.f2544h;
    }

    /* renamed from: c */
    public float mo11330c() {
        float[] fArr = this.f2543g;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos((double) (fArr[2] / 9.81f)));
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2539c.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo11328a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f2543g = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f = this.f2544h * this.f2538b;
            this.f2544h = f;
            float abs = Math.abs(sensorEvent.values[0]);
            this.f2544h = Math.abs(sensorEvent.values[2]) + Math.abs(sensorEvent.values[1]) + abs + f;
        }
    }
}
