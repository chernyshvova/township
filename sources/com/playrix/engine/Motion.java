package com.playrix.engine;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.android.tools.p006r8.GeneratedOutlineSupport;

public class Motion {
    public static final int ACCELEROMETER = 2;
    public static final int GYROSCOPE = 0;
    public static final int MAGNETOMETER = 1;
    public static final String TAG = "[Motion] ";

    public static class SensorControl implements SensorEventListener {
        public boolean registeredInSensorManager = false;
        public final Sensor sensor;
        public final SensorManager sensorManager;
        public String startObserveError;

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            if (r0 == null) goto L_0x0017;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public SensorControl(int r5) {
            /*
                r4 = this;
                r4.<init>()
                r0 = 0
                r4.registeredInSensorManager = r0
                r0 = 0
                r4.startObserveError = r0
                android.content.Context r1 = com.playrix.engine.Engine.getContext()     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
                java.lang.String r2 = "sensor"
                java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
                android.hardware.SensorManager r1 = (android.hardware.SensorManager) r1     // Catch:{ Exception -> 0x003c, all -> 0x0039 }
                if (r1 != 0) goto L_0x001c
            L_0x0017:
                r4.sensorManager = r1
                r4.sensor = r0
                return
            L_0x001c:
                if (r5 == 0) goto L_0x002f
                r2 = 2
                r3 = 1
                if (r5 == r3) goto L_0x002a
                if (r5 == r2) goto L_0x0025
                goto L_0x0034
            L_0x0025:
                android.hardware.Sensor r0 = r1.getDefaultSensor(r3)     // Catch:{ Exception -> 0x0037 }
                goto L_0x0034
            L_0x002a:
                android.hardware.Sensor r0 = r1.getDefaultSensor(r2)     // Catch:{ Exception -> 0x0037 }
                goto L_0x0034
            L_0x002f:
                r5 = 4
                android.hardware.Sensor r0 = r1.getDefaultSensor(r5)     // Catch:{ Exception -> 0x0037 }
            L_0x0034:
                if (r0 != 0) goto L_0x0043
                goto L_0x0017
            L_0x0037:
                r5 = move-exception
                goto L_0x003e
            L_0x0039:
                r5 = move-exception
                r1 = r0
                goto L_0x0049
            L_0x003c:
                r5 = move-exception
                r1 = r0
            L_0x003e:
                java.lang.String r2 = "Error get sensor"
                com.playrix.engine.Motion.logException(r2, r5)     // Catch:{ all -> 0x0048 }
            L_0x0043:
                r4.sensorManager = r1
                r4.sensor = r0
                return
            L_0x0048:
                r5 = move-exception
            L_0x0049:
                r4.sensorManager = r1
                r4.sensor = r0
                goto L_0x004f
            L_0x004e:
                throw r5
            L_0x004f:
                goto L_0x004e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.playrix.engine.Motion.SensorControl.<init>(int):void");
        }

        public static SensorControl create(int i) {
            SensorControl sensorControl = new SensorControl(i);
            if (sensorControl.isAvailable()) {
                return sensorControl;
            }
            return null;
        }

        private boolean isAvailable() {
            return (this.sensorManager == null || this.sensor == null) ? false : true;
        }

        public int getMinUpdateInterval() {
            if (isAvailable()) {
                return this.sensor.getMinDelay();
            }
            return 0;
        }

        public String getStartObserveError() {
            return this.startObserveError;
        }

        public void onAccuracyChanged(Sensor sensor2, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 4) {
                float[] fArr = sensorEvent.values;
                Motion.nativeOnGyroscopeEvent(fArr[0], fArr[1], fArr[2], sensorEvent.timestamp);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr2 = sensorEvent.values;
                Motion.nativeOnMagnetometerEvent(fArr2[0], fArr2[1], fArr2[2], sensorEvent.timestamp);
            } else if (sensorEvent.sensor.getType() == 1) {
                float[] fArr3 = sensorEvent.values;
                Motion.nativeOnAccelerometerEvent(fArr3[0], fArr3[1], fArr3[2], sensorEvent.timestamp);
            }
        }

        public int startObserve(int i) {
            int maxDelay;
            this.startObserveError = null;
            try {
                if (!isAvailable()) {
                    this.startObserveError = "Unavailable";
                    return -1;
                }
                if (Build.VERSION.SDK_INT >= 21 && (maxDelay = this.sensor.getMaxDelay()) > 0) {
                    i = Math.max(i, maxDelay);
                }
                int minDelay = this.sensor.getMinDelay();
                if (minDelay > 0) {
                    i = Math.min(i, minDelay);
                }
                if (!this.sensorManager.registerListener(this, this.sensor, i)) {
                    this.startObserveError = "Can't register listener";
                    return -1;
                }
                this.registeredInSensorManager = true;
                if (minDelay > 0) {
                    return i;
                }
                return 0;
            } catch (Exception e) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Exception: ");
                outline24.append(e.getMessage());
                this.startObserveError = outline24.toString();
                Motion.logException("Error start sensor", e);
                return -1;
            }
        }

        public void stopObserve() {
            if (isAvailable() && this.registeredInSensorManager) {
                try {
                    this.registeredInSensorManager = false;
                    this.sensorManager.unregisterListener(this);
                } catch (Exception e) {
                    Motion.logException("Error stop sensor", e);
                }
            }
        }
    }

    public static void logException(String str, Exception exc) {
        StringBuilder outline27 = GeneratedOutlineSupport.outline27(TAG, str, " : ");
        outline27.append(exc.getMessage());
        Logger.logError(outline27.toString());
    }

    public static native void nativeOnAccelerometerEvent(float f, float f2, float f3, long j);

    public static native void nativeOnGyroscopeEvent(float f, float f2, float f3, long j);

    public static native void nativeOnMagnetometerEvent(float f, float f2, float f3, long j);
}
