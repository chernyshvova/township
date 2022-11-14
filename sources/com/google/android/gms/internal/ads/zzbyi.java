package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C1620R;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.drive.DriveFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyi extends zzbyq {
    public final Map<String, String> zza;
    public final Context zzb;
    public final String zzc = zzd("description");
    public final long zzd = zze("start_ticks");
    public final long zze = zze("end_ticks");
    public final String zzf = zzd("summary");
    public final String zzg = zzd(FirebaseAnalytics.Param.LOCATION);

    public zzbyi(zzcmr zzcmr, Map<String, String> map) {
        super(zzcmr, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzcmr.zzj();
    }

    private final String zzd(String str) {
        return TextUtils.isEmpty(this.zza.get(str)) ? "" : this.zza.get(str);
    }

    private final long zze(String str) {
        String str2 = this.zza.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void zza() {
        if (this.zzb == null) {
            zzf("Activity context is not available.");
            return;
        }
        zzs.zzc();
        if (!new zzbiy(this.zzb).zzb()) {
            zzf("This feature is not available on the device.");
            return;
        }
        zzs.zzc();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
        Resources zzf2 = zzs.zzg().zzf();
        builder.setTitle(zzf2 != null ? zzf2.getString(C1620R.string.f2770s5) : "Create calendar event");
        builder.setMessage(zzf2 != null ? zzf2.getString(C1620R.string.f2771s6) : "Allow Ad to create a calendar event?");
        builder.setPositiveButton(zzf2 != null ? zzf2.getString(C1620R.string.f2768s3) : "Accept", new zzbyg(this));
        builder.setNegativeButton(zzf2 != null ? zzf2.getString(C1620R.string.f2769s4) : "Decline", new zzbyh(this));
        builder.create().show();
    }

    @TargetApi(14)
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(DriveFile.MODE_READ_ONLY);
        return data;
    }
}
