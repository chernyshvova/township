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
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.utils.i */
public class C1265i implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* renamed from: a */
    public final C1188m f2448a;

    /* renamed from: b */
    public final SensorManager f2449b;

    /* renamed from: c */
    public final Sensor f2450c;

    /* renamed from: d */
    public final C1266a f2451d;

    /* renamed from: e */
    public float f2452e;

    /* renamed from: com.applovin.impl.sdk.utils.i$a */
    public interface C1266a {
        /* renamed from: b */
        void mo11018b();

        /* renamed from: c */
        void mo11019c();
    }

    public C1265i(C1188m mVar, C1266a aVar) {
        this.f2448a = mVar;
        SensorManager sensorManager = (SensorManager) mVar.mo10932L().getSystemService("sensor");
        this.f2449b = sensorManager;
        this.f2450c = sensorManager.getDefaultSensor(1);
        this.f2451d = aVar;
    }

    /* renamed from: a */
    public void mo11279a() {
        this.f2449b.unregisterListener(this);
        this.f2449b.registerListener(this, this.f2450c, (int) TimeUnit.MILLISECONDS.toMicros(50));
        this.f2448a.mo10972aj().unregisterReceiver(this);
        this.f2448a.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        this.f2448a.mo10972aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: b */
    public void mo11280b() {
        this.f2448a.mo10972aj().unregisterReceiver(this);
        this.f2449b.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onReceive(Context context, Intent intent, @Nullable Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2449b.unregisterListener(this);
        } else if ("com.applovin.application_resumed".equals(action)) {
            mo11279a();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float max = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f = this.f2452e;
            float f2 = (max * 0.5f) + (f * 0.5f);
            this.f2452e = f2;
            if (f < 0.8f && f2 > 0.8f) {
                this.f2451d.mo11019c();
            } else if (f > -0.8f && this.f2452e < -0.8f) {
                this.f2451d.mo11018b();
            }
        }
    }
}
