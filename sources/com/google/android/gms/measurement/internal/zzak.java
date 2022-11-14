package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.Clock;
import com.helpshift.util.ErrorReportProvider;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzak extends zzgq {
    public long zza;
    public String zzb;
    public Boolean zzc;
    public AccountManager zzd;
    public Boolean zze;
    public long zzf;

    public zzak(zzfu zzfu) {
        super(zzfu);
    }

    public final boolean zza(Context context) {
        if (this.zzc == null) {
            this.zzc = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.zzc = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.zzc.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final boolean zzd() {
        Calendar instance = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.zzb = GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(lowerCase2, GeneratedOutlineSupport.outline3(lowerCase, 1)), lowerCase, "-", lowerCase2);
        return false;
    }

    public final long zze() {
        zzab();
        return this.zza;
    }

    public final String zzf() {
        zzab();
        return this.zzb;
    }

    @WorkerThread
    public final long zzg() {
        zzc();
        return this.zzf;
    }

    @WorkerThread
    public final void zzh() {
        zzc();
        this.zze = null;
        this.zzf = 0;
    }

    @WorkerThread
    public final boolean zzi() {
        zzc();
        long currentTimeMillis = zzl().currentTimeMillis();
        if (currentTimeMillis - this.zzf > ErrorReportProvider.BATCH_TIME) {
            this.zze = null;
        }
        Boolean bool = this.zze;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(zzm(), "android.permission.GET_ACCOUNTS") != 0) {
            zzq().zzi().zza("Permission error checking for dasher/unicorn accounts");
            this.zzf = currentTimeMillis;
            this.zze = Boolean.FALSE;
            return false;
        }
        if (this.zzd == null) {
            this.zzd = AccountManager.get(zzm());
        }
        try {
            Account[] result = this.zzd.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, (AccountManagerCallback) null, (Handler) null).getResult();
            if (result == null || result.length <= 0) {
                Account[] result2 = this.zzd.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, (AccountManagerCallback) null, (Handler) null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.zze = Boolean.TRUE;
                    this.zzf = currentTimeMillis;
                    return true;
                }
                this.zzf = currentTimeMillis;
                this.zze = Boolean.FALSE;
                return false;
            }
            this.zze = Boolean.TRUE;
            this.zzf = currentTimeMillis;
            return true;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            zzq().zzf().zza("Exception checking account types", e);
        }
    }

    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
