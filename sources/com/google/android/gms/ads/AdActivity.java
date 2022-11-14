package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcgs;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdActivity extends Activity {
    @RecentlyNonNull
    @KeepForSdk
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    @Nullable
    public zzbzr zza;

    private final void zza() {
        zzbzr zzbzr = this.zza;
        if (zzbzr != null) {
            try {
                zzbzr.zzs();
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onActivityResult(int i, int i2, @RecentlyNonNull Intent intent) {
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzm(i, i2, intent);
            }
        } catch (Exception e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null && !zzbzr.zzg()) {
                return;
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbzr zzbzr2 = this.zza;
            if (zzbzr2 != null) {
                zzbzr2.zze();
            }
        } catch (RemoteException e2) {
            zzcgs.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onConfigurationChanged(@RecentlyNonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzn(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        zzbzr zzg = zzbev.zzb().zzg(this);
        this.zza = zzg;
        if (zzg != null) {
            try {
                zzg.zzh(bundle);
            } catch (RemoteException e) {
                zzcgs.zzl("#007 Could not call remote method.", e);
                finish();
            }
        } else {
            zzcgs.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    public final void onDestroy() {
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzq();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    public final void onPause() {
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzl();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    public final void onRestart() {
        super.onRestart();
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzi();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    public final void onResume() {
        super.onResume();
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzk();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    public final void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzo(bundle);
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    public final void onStart() {
        super.onStart();
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzj();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    public final void onStop() {
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzp();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbzr zzbzr = this.zza;
            if (zzbzr != null) {
                zzbzr.zzf();
            }
        } catch (RemoteException e) {
            zzcgs.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    public final void setContentView(@RecentlyNonNull View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(@RecentlyNonNull View view, @RecentlyNonNull ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
