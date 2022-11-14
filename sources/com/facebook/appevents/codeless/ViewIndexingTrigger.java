package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewIndexingTrigger.kt */
public final class ViewIndexingTrigger implements SensorEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final double SHAKE_THRESHOLD_GRAVITY = 2.3d;
    public OnShakeListener onShakeListener;

    /* compiled from: ViewIndexingTrigger.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ViewIndexingTrigger.kt */
    public interface OnShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(sensor, "sensor");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(sensorEvent, "event");
                OnShakeListener onShakeListener2 = this.onShakeListener;
                if (onShakeListener2 != null) {
                    float f = sensorEvent.values[0];
                    double d = (double) (f / 9.80665f);
                    double d2 = (double) (sensorEvent.values[1] / 9.80665f);
                    double d3 = (double) (sensorEvent.values[2] / 9.80665f);
                    Double.isNaN(d);
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    Double.isNaN(d2);
                    double d4 = d2 * d2;
                    Double.isNaN(d3);
                    Double.isNaN(d3);
                    if (Math.sqrt((d3 * d3) + d4 + (d * d)) > 2.3d) {
                        onShakeListener2.onShake();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setOnShakeListener(OnShakeListener onShakeListener2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.onShakeListener = onShakeListener2;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
