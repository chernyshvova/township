package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.NonNull;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* renamed from: com.appsflyer.internal.x */
public final class C1495x implements SensorEventListener {
    public final float[][] AFInAppEventParameterName = new float[2][];
    public final long[] AFInAppEventType = new long[2];
    public long AFKeystoreWrapper;
    public final int AFLogger$LogLevel;
    public final Executor AFVersionDeclaration;
    @NonNull
    public final String getLevel;
    @NonNull
    public final String init;
    public double valueOf;
    public final int values;

    public C1495x(Sensor sensor, Executor executor) {
        this.AFVersionDeclaration = executor;
        this.values = sensor.getType();
        String name = sensor.getName();
        String str = "";
        this.getLevel = name == null ? str : name;
        String vendor = sensor.getVendor();
        str = vendor != null ? vendor : str;
        this.init = str;
        this.AFLogger$LogLevel = str.hashCode() + ((this.getLevel.hashCode() + ((this.values + 31) * 31)) * 31);
    }

    private boolean AFInAppEventParameterName() {
        return this.AFInAppEventParameterName[0] != null;
    }

    @NonNull
    public static List<Float> AFKeystoreWrapper(@NonNull float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf2 : fArr) {
            arrayList.add(Float.valueOf(valueOf2));
        }
        return arrayList;
    }

    public final void AFInAppEventType(@NonNull Map<C1495x, Map<String, Object>> map, boolean z) {
        if (AFInAppEventParameterName()) {
            map.put(this, AFKeystoreWrapper());
            if (z) {
                int length = this.AFInAppEventParameterName.length;
                for (int i = 0; i < length; i++) {
                    this.AFInAppEventParameterName[i] = null;
                }
                int length2 = this.AFInAppEventType.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    this.AFInAppEventType[i2] = 0;
                }
                this.valueOf = RoundRectDrawableWithShadow.COS_45;
                this.AFKeystoreWrapper = 0;
            }
        } else if (!map.containsKey(this)) {
            map.put(this, AFKeystoreWrapper());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1495x)) {
            return false;
        }
        C1495x xVar = (C1495x) obj;
        return AFInAppEventType(xVar.values, xVar.getLevel, xVar.init);
    }

    public final int hashCode() {
        return this.AFLogger$LogLevel;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        final long j = sensorEvent.timestamp;
        final float[] fArr = sensorEvent.values;
        this.AFVersionDeclaration.execute(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                C1495x xVar = C1495x.this;
                float[][] fArr = xVar.AFInAppEventParameterName;
                float[] fArr2 = fArr[0];
                if (fArr2 == null) {
                    float[] fArr3 = fArr;
                    fArr[0] = Arrays.copyOf(fArr3, fArr3.length);
                    C1495x.this.AFInAppEventType[0] = currentTimeMillis;
                    return;
                }
                float[] fArr4 = fArr[1];
                if (fArr4 == null) {
                    float[] fArr5 = fArr;
                    float[] copyOf = Arrays.copyOf(fArr5, fArr5.length);
                    C1495x xVar2 = C1495x.this;
                    xVar2.AFInAppEventParameterName[1] = copyOf;
                    xVar2.AFInAppEventType[1] = currentTimeMillis;
                    xVar2.valueOf = C1495x.AFInAppEventType(fArr2, copyOf);
                    return;
                }
                long j = j;
                if (50000000 <= j - xVar.AFKeystoreWrapper) {
                    xVar.AFKeystoreWrapper = j;
                    if (Arrays.equals(fArr4, fArr)) {
                        C1495x.this.AFInAppEventType[1] = currentTimeMillis;
                        return;
                    }
                    double AFInAppEventType2 = C1495x.AFInAppEventType(fArr2, fArr);
                    C1495x xVar3 = C1495x.this;
                    if (AFInAppEventType2 > xVar3.valueOf) {
                        float[][] fArr6 = xVar3.AFInAppEventParameterName;
                        float[] fArr7 = fArr;
                        fArr6[1] = Arrays.copyOf(fArr7, fArr7.length);
                        C1495x xVar4 = C1495x.this;
                        xVar4.AFInAppEventType[1] = currentTimeMillis;
                        xVar4.valueOf = AFInAppEventType2;
                    }
                }
            }
        });
    }

    @NonNull
    private Map<String, Object> AFKeystoreWrapper() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.values));
        concurrentHashMap.put("sN", this.getLevel);
        concurrentHashMap.put("sV", this.init);
        float[] fArr = this.AFInAppEventParameterName[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", AFKeystoreWrapper(fArr));
        }
        float[] fArr2 = this.AFInAppEventParameterName[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", AFKeystoreWrapper(fArr2));
        }
        return concurrentHashMap;
    }

    private boolean AFInAppEventType(int i, @NonNull String str, @NonNull String str2) {
        return this.values == i && this.getLevel.equals(str) && this.init.equals(str2);
    }

    public static /* synthetic */ double AFInAppEventType(float[] fArr, float[] fArr2) {
        int min = Math.min(fArr.length, fArr2.length);
        double d = RoundRectDrawableWithShadow.COS_45;
        for (int i = 0; i < min; i++) {
            d += StrictMath.pow((double) (fArr[i] - fArr2[i]), 2.0d);
        }
        return Math.sqrt(d);
    }
}
