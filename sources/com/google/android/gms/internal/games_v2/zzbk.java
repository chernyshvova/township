package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.internal.p034v2.resolution.zzb;
import com.google.android.gms.games.internal.p034v2.resolution.zzc;
import com.google.android.gms.games.internal.zzat;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.games.internal.zzj;
import com.google.android.gms.games.internal.zzl;
import com.google.android.gms.games.zzk;
import com.google.android.gms.games.zzm;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzbk implements zzav {
    public final AtomicReference<zzbh> zza = new AtomicReference<>(zzbh.UNINITIALIZED);
    public final AtomicReference<zzbg> zzb = new AtomicReference<>(zzbg.AUTOMATIC);
    public final Queue<zzbj<?>> zzc = new ArrayDeque();
    public final AtomicReference<TaskCompletionSource<Boolean>> zzd = new AtomicReference<>();
    public final AtomicReference<GoogleApi<zzm>> zze = new AtomicReference<>();
    public final Application zzf;
    public final zzg zzg;
    public final zzbl zzh;
    public final zzb zzi;

    public zzbk(Application application, zzg zzg2, zzb zzb2, zzbl zzbl, byte[] bArr) {
        this.zzf = application;
        this.zzg = zzg2;
        this.zzi = zzb2;
        this.zzh = zzbl;
    }

    public static ApiException zzj() {
        return new ApiException(new Status(4));
    }

    public static Task<AuthenticationResult> zzk(AtomicReference<zzbh> atomicReference, @Nullable TaskCompletionSource<Boolean> taskCompletionSource) {
        zzbh zzbh = zzbh.UNINITIALIZED;
        int ordinal = atomicReference.get().ordinal();
        if (ordinal == 0) {
            return Tasks.forException(new ApiException(new Status(10)));
        }
        if (ordinal == 2) {
            return Tasks.forResult(AuthenticationResult.zza);
        }
        if (ordinal == 3) {
            return Tasks.forResult(AuthenticationResult.zzb);
        }
        if (taskCompletionSource == null) {
            return Tasks.forResult(AuthenticationResult.zzb);
        }
        Task<Boolean> task = taskCompletionSource.getTask();
        if (!task.isSuccessful()) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            task.addOnCompleteListener(zzfr.zza(), (OnCompleteListener<Boolean>) new zzba(taskCompletionSource2));
            return taskCompletionSource2.getTask();
        } else if (task.getResult().booleanValue()) {
            return Tasks.forResult(AuthenticationResult.zza);
        } else {
            return Tasks.forResult(AuthenticationResult.zzb);
        }
    }

    public static <T> Task<T> zzl(zzfs<Task<T>> zzfs) {
        if (zzp()) {
            return zzfs.zza();
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        TaskExecutors.MAIN_THREAD.execute(new zzbd(zzfs, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private final void zzm(TaskCompletionSource<Boolean> taskCompletionSource, zzy zzy) {
        zzat.zza("GamesApiManager", "Attempting authentication: ".concat(zzy.toString()));
        this.zzh.zza(zzy).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new zzaz(this, taskCompletionSource, zzy));
    }

    @MainThread
    private final void zzn(TaskCompletionSource<Boolean> taskCompletionSource, int i, @Nullable PendingIntent pendingIntent, boolean z, boolean z2) {
        Activity zza2;
        Preconditions.checkMainThread("Must be called on the main thread.");
        if (!z || pendingIntent == null || (zza2 = this.zzg.zza()) == null) {
            boolean compareAndSet = this.zzb.compareAndSet(zzbg.AUTOMATIC_PENDING_EXPLICIT, zzbg.EXPLICIT);
            if (z2 || !compareAndSet) {
                taskCompletionSource.trySetResult(Boolean.FALSE);
                this.zza.set(zzbh.AUTHENTICATION_FAILED);
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    ((zzbj) it.next()).zzc(zzj());
                    it.remove();
                }
                return;
            }
            zzat.zza("GamesApiManager", "Consumed pending explicit sign-in. Attempting explicit sign-in");
            zzm(taskCompletionSource, zzy.zzb(0));
            return;
        }
        zzb.zzb(zza2, pendingIntent).addOnCompleteListener(TaskExecutors.MAIN_THREAD, new zzay(this, taskCompletionSource, i));
        zzat.zza("GamesApiManager", "Resolution triggered");
    }

    @MainThread
    private final void zzo(int i) {
        zzbg zzbg;
        StringBuilder sb = new StringBuilder(56);
        sb.append("startAuthenticationIfNecessary() signInType: ");
        sb.append(i);
        zzat.zza("GamesApiManager", sb.toString());
        Preconditions.checkMainThread("Must be called on the main thread.");
        if (this.zza.compareAndSet(zzbh.UNINITIALIZED, zzbh.AUTHENTICATING) || this.zza.compareAndSet(zzbh.AUTHENTICATION_FAILED, zzbh.AUTHENTICATING)) {
            TaskCompletionSource taskCompletionSource = this.zzd.get();
            if (taskCompletionSource != null) {
                taskCompletionSource.trySetException(new IllegalStateException("New authentication attempt in progress"));
            }
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.zzd.set(taskCompletionSource2);
            AtomicReference<zzbg> atomicReference = this.zzb;
            if (i == 0) {
                zzbg = zzbg.EXPLICIT;
            } else {
                zzbg = zzbg.AUTOMATIC;
            }
            atomicReference.set(zzbg);
            zzm(taskCompletionSource2, zzy.zzb(i));
            return;
        }
        if (i == 0) {
            boolean compareAndSet = this.zzb.compareAndSet(zzbg.AUTOMATIC, zzbg.AUTOMATIC_PENDING_EXPLICIT);
            StringBuilder sb2 = new StringBuilder(88);
            sb2.append("Explicit sign-in during existing authentication. Marking pending explicit sign-in: ");
            sb2.append(compareAndSet);
            zzat.zza("GamesApiManager", sb2.toString());
        }
        String valueOf = String.valueOf(this.zza.get());
        valueOf.length();
        zzat.zza("GamesApiManager", "Authentication attempt skipped. Already authenticated or authenticating. State: ".concat(valueOf));
    }

    public static boolean zzp() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final Task<AuthenticationResult> zza() {
        return zzl(new zzbe(this));
    }

    public final Task<AuthenticationResult> zzb() {
        return zzl(new zzbf(this));
    }

    public final Task<AuthenticationResult> zzc() {
        return zzk(this.zza, this.zzd.get());
    }

    public final <T> Task<T> zzd(zzap zzap) {
        zzbh zzbh = this.zza.get();
        String valueOf = String.valueOf(zzbh);
        valueOf.length();
        zzat.zzf("GamesApiManager", "Executing API call with authentication state: ".concat(valueOf));
        if (zzbh == zzbh.AUTHENTICATED) {
            return zzap.zza(this.zze.get());
        }
        if (zzbh == zzbh.AUTHENTICATION_FAILED) {
            return Tasks.forException(zzj());
        }
        if (zzbh == zzbh.UNINITIALIZED) {
            return Tasks.forException(new ApiException(new Status(10)));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzbc zzbc = new zzbc(this, new zzbj(zzap, taskCompletionSource, (byte[]) null));
        if (zzp()) {
            zzbc.run();
        } else {
            TaskExecutors.MAIN_THREAD.execute(zzbc);
        }
        return taskCompletionSource.getTask();
    }

    public final /* synthetic */ Task zze() {
        zzo(1);
        return zzk(this.zza, this.zzd.get());
    }

    public final /* synthetic */ Task zzf() {
        zzo(0);
        return zzk(this.zza, this.zzd.get());
    }

    public final /* synthetic */ void zzg(TaskCompletionSource taskCompletionSource, zzy zzy, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfo.zza(exception);
            zzat.zzb("GamesApiManager", "Authentication task failed", exception);
            zzn(taskCompletionSource, zzy.zza(), (PendingIntent) null, false, !zzy.zzd());
            return;
        }
        zzbp zzbp = (zzbp) task.getResult();
        if (!zzbp.zze()) {
            String valueOf = String.valueOf(zzbp);
            valueOf.length();
            zzat.zza("GamesApiManager", "Failed to authenticate: ".concat(valueOf));
            zzn(taskCompletionSource, zzy.zza(), zzbp.zza(), true, !zzy.zzd());
            return;
        }
        String zzd2 = zzbp.zzd();
        if (zzd2 == null) {
            zzat.zzg("GamesApiManager", "Unexpected state: game run token absent");
            zzn(taskCompletionSource, zzy.zza(), (PendingIntent) null, false, !zzy.zzd());
            return;
        }
        zzat.zza("GamesApiManager", "Successfully authenticated");
        Preconditions.checkMainThread("Must be called on the main thread.");
        zzk zzb2 = zzm.zzb();
        zzb2.zzd(2101523);
        zzb2.zzc(GoogleSignInAccount.createDefault());
        zzb2.zza(zzd2);
        zzj zza2 = zzl.zza();
        zza2.zzb(true);
        zza2.zzc(true);
        zza2.zza(true);
        zzb2.zzb(zza2.zzd());
        zze zze2 = new zze(this.zzf, zzb2.zze());
        this.zze.set(zze2);
        this.zza.set(zzbh.AUTHENTICATED);
        taskCompletionSource.trySetResult(Boolean.TRUE);
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            ((zzbj) it.next()).zza(zze2);
            it.remove();
        }
    }

    public final /* synthetic */ void zzh(TaskCompletionSource taskCompletionSource, int i, Task task) {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            zzfo.zza(exception);
            zzat.zzh("GamesApiManager", "Resolution failed", exception);
            zzn(taskCompletionSource, i, (PendingIntent) null, false, true);
            return;
        }
        zzc zzc2 = (zzc) task.getResult();
        if (zzc2.zzd()) {
            zzat.zza("GamesApiManager", "Resolution successful");
            zzm(taskCompletionSource, zzy.zzc(i, zzaf.zza(zzc2.zza())));
            return;
        }
        zzat.zza("GamesApiManager", "Resolution attempt was canceled");
        zzn(taskCompletionSource, i, (PendingIntent) null, false, true);
    }

    public final /* synthetic */ void zzi(zzbj zzbj) {
        Preconditions.checkMainThread("Must be called on the main thread.");
        zzbh zzbh = this.zza.get();
        if (zzbh == zzbh.AUTHENTICATED) {
            zzbj.zza(this.zze.get());
        } else if (zzbh == zzbh.AUTHENTICATION_FAILED) {
            zzbj.zzc(zzj());
        } else {
            this.zzc.add(zzbj);
        }
    }
}
