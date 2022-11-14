package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayx {
    public final zzazd zza;
    @GuardedBy("this")
    public final zzbaq zzb;
    public final boolean zzc;

    public zzayx() {
        this.zzb = zzbar.zze();
        this.zzc = false;
        this.zza = new zzazd();
    }

    public static zzayx zza() {
        return new zzayx();
    }

    private final synchronized void zzd(zzayz zzayz) {
        zzbaq zzbaq = this.zzb;
        zzbaq.zzd();
        List<String> zzd = zzbjn.zzd();
        ArrayList arrayList = new ArrayList();
        for (String split : zzd) {
            for (String valueOf : split.split(",")) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        zzbaq.zzc(arrayList);
        zzazc zzazc = new zzazc(this.zza, ((zzbar) this.zzb.zzah()).zzao(), (zzazb) null);
        zzazc.zzb(zzayz.zza());
        zzazc.zza();
        String valueOf2 = String.valueOf(Integer.toString(zzayz.zza(), 10));
        zze.zza(valueOf2.length() != 0 ? "Logging Event with event code : ".concat(valueOf2) : new String("Logging Event with event code : "));
    }

    private final synchronized void zze(zzayz zzayz) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzf(zzayz).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zze.zza("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zze.zza("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized String zzf(zzayz zzayz) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzb.zza(), Long.valueOf(zzs.zzj().elapsedRealtime()), Integer.valueOf(zzayz.zza()), Base64.encodeToString(((zzbar) this.zzb.zzah()).zzao(), 3)});
    }

    public final synchronized void zzb(zzayz zzayz) {
        if (this.zzc) {
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzdj)).booleanValue()) {
                zze(zzayz);
            } else {
                zzd(zzayz);
            }
        }
    }

    public final synchronized void zzc(zzayw zzayw) {
        if (this.zzc) {
            try {
                zzayw.zza(this.zzb);
            } catch (NullPointerException e) {
                zzs.zzg().zzg(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public zzayx(zzazd zzazd) {
        this.zzb = zzbar.zze();
        this.zza = zzazd;
        this.zzc = ((Boolean) zzbex.zzc().zzb(zzbjn.zzdi)).booleanValue();
    }
}
