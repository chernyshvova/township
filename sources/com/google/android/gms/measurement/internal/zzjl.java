package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjl implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    public final /* synthetic */ zzir zza;
    public volatile boolean zzb;
    public volatile zzer zzc;

    public zzjl(zzir zzir) {
        this.zza = zzir;
    }

    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zza.zzp().zza((Runnable) new zzjm(this, (zzei) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzeq zzc2 = this.zza.zzy.zzc();
        if (zzc2 != null) {
            zzc2.zzh().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzp().zza((Runnable) new zzjo(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzq().zzv().zza("Service connection suspended");
        this.zza.zzp().zza((Runnable) new zzjp(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.zza.zzq().zze().zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005f */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzir r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzeq r4 = r4.zzq()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zze()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x0096
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x005f }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x005f }
            if (r2 == 0) goto L_0x004f
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x005f }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzei     // Catch:{ RemoteException -> 0x005f }
            if (r2 == 0) goto L_0x0039
            com.google.android.gms.measurement.internal.zzei r1 = (com.google.android.gms.measurement.internal.zzei) r1     // Catch:{ RemoteException -> 0x005f }
            goto L_0x003e
        L_0x0039:
            com.google.android.gms.measurement.internal.zzek r1 = new com.google.android.gms.measurement.internal.zzek     // Catch:{ RemoteException -> 0x005f }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x005f }
        L_0x003e:
            r0 = r1
            com.google.android.gms.measurement.internal.zzir r5 = r3.zza     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzeq r5 = r5.zzq()     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzw()     // Catch:{ RemoteException -> 0x005f }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x005f }
            goto L_0x006e
        L_0x004f:
            com.google.android.gms.measurement.internal.zzir r5 = r3.zza     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzeq r5 = r5.zzq()     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zze()     // Catch:{ RemoteException -> 0x005f }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zza(r2, r1)     // Catch:{ RemoteException -> 0x005f }
            goto L_0x006e
        L_0x005f:
            com.google.android.gms.measurement.internal.zzir r5 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzeq r5 = r5.zzq()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zze()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x001c }
        L_0x006e:
            if (r0 != 0) goto L_0x0086
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0094 }
            com.google.android.gms.measurement.internal.zzir r5 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0094 }
            android.content.Context r5 = r5.zzm()     // Catch:{ IllegalArgumentException -> 0x0094 }
            com.google.android.gms.measurement.internal.zzir r0 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0094 }
            com.google.android.gms.measurement.internal.zzjl r0 = r0.zza     // Catch:{ IllegalArgumentException -> 0x0094 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0094 }
            goto L_0x0094
        L_0x0086:
            com.google.android.gms.measurement.internal.zzir r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzp()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzjk r5 = new com.google.android.gms.measurement.internal.zzjk     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zza((java.lang.Runnable) r5)     // Catch:{ all -> 0x001c }
        L_0x0094:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x0096:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjl.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzq().zzv().zza("Service disconnected");
        this.zza.zzp().zza((Runnable) new zzjn(this, componentName));
    }

    @WorkerThread
    public final void zza(Intent intent) {
        this.zza.zzc();
        Context zzm = this.zza.zzm();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzq().zzw().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzq().zzw().zza("Using local app measurement service");
            this.zzb = true;
            instance.bindService(zzm, intent, this.zza.zza, 129);
        }
    }

    @WorkerThread
    public final void zzb() {
        this.zza.zzc();
        Context zzm = this.zza.zzm();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzq().zzw().zza("Connection attempt already in progress");
            } else if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                this.zzc = new zzer(zzm, Looper.getMainLooper(), this, this);
                this.zza.zzq().zzw().zza("Connecting to remote service");
                this.zzb = true;
                this.zzc.checkAvailabilityAndConnect();
            } else {
                this.zza.zzq().zzw().zza("Already awaiting connection attempt");
            }
        }
    }

    @WorkerThread
    public final void zza() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }
}
