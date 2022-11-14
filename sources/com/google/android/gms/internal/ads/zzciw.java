package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.vungle.warren.VisionController;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzciw implements SensorEventListener {
    public final SensorManager zza;
    public final Object zzb = new Object();
    public final Display zzc;
    public final float[] zzd = new float[9];
    public final float[] zze = new float[9];
    @GuardedBy("sensorThreadLock")
    public float[] zzf;
    public Handler zzg;
    public zzciv zzh;

    public zzciw(Context context) {
        this.zza = (SensorManager) context.getSystemService("sensor");
        this.zzc = ((WindowManager) context.getSystemService(VisionController.WINDOW)).getDefaultDisplay();
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzb) {
                if (this.zzf == null) {
                    this.zzf = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzd, fArr);
            int rotation = this.zzc.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.zzd, 2, 129, this.zze);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.zzd, 129, 130, this.zze);
            } else if (rotation != 3) {
                System.arraycopy(this.zzd, 0, this.zze, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.zzd, 130, 1, this.zze);
            }
            float[] fArr2 = this.zze;
            float f = fArr2[1];
            fArr2[1] = fArr2[3];
            fArr2[3] = f;
            float f2 = fArr2[2];
            fArr2[2] = fArr2[6];
            fArr2[6] = f2;
            float f3 = fArr2[5];
            fArr2[5] = fArr2[7];
            fArr2[7] = f3;
            synchronized (this.zzb) {
                System.arraycopy(this.zze, 0, this.zzf, 0, 9);
            }
            zzciv zzciv = this.zzh;
            if (zzciv != null) {
                zzciv.zza();
            }
        }
    }

    public final void zza() {
        if (this.zzg == null) {
            Sensor defaultSensor = this.zza.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzcgs.zzf("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            zzfjj zzfjj = new zzfjj(handlerThread.getLooper());
            this.zzg = zzfjj;
            if (!this.zza.registerListener(this, defaultSensor, 0, zzfjj)) {
                zzcgs.zzf("SensorManager.registerListener failed.");
                zzb();
            }
        }
    }

    public final void zzb() {
        if (this.zzg != null) {
            this.zza.unregisterListener(this);
            this.zzg.post(new zzciu(this));
            this.zzg = null;
        }
    }

    public final void zzc(zzciv zzciv) {
        this.zzh = zzciv;
    }

    public final boolean zzd(float[] fArr) {
        synchronized (this.zzb) {
            float[] fArr2 = this.zzf;
            if (fArr2 == null) {
                return false;
            }
            System.arraycopy(fArr2, 0, fArr, 0, 9);
            return true;
        }
    }
}
