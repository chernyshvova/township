package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzect {
    public final zzayx zza;
    public final Context zzb;
    public final zzecb zzc;
    public final zzcgy zzd;
    public final String zze;
    public final zzfdh zzf;
    public final zzg zzg = zzs.zzg().zzl();

    public zzect(Context context, zzcgy zzcgy, zzayx zzayx, zzecb zzecb, String str, zzfdh zzfdh) {
        this.zzb = context;
        this.zzd = zzcgy;
        this.zza = zzayx;
        this.zzc = zzecb;
        this.zze = str;
        this.zzf = zzfdh;
    }

    public static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList<zzbbk> arrayList) {
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            zzbbk zzbbk = arrayList.get(i);
            if (zzbbk.zzc() == zzbap.ENUM_TRUE && zzbbk.zza() > j) {
                j = zzbbk.zza();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
        }
    }

    public final void zza(boolean z) {
        try {
            this.zzc.zza(new zzecp(this, z));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzcgs.zzf(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    public final /* synthetic */ Void zzb(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        String str;
        String str2;
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            int i = 2;
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzfU)).booleanValue()) {
                zzfdg zza2 = zzfdg.zza("oa_upload");
                zza2.zzc("oa_failed_reqs", String.valueOf(zzeco.zzb(sQLiteDatabase, 0)));
                zza2.zzc("oa_total_reqs", String.valueOf(zzeco.zzb(sQLiteDatabase, 1)));
                zza2.zzc("oa_upload_time", String.valueOf(zzs.zzj().currentTimeMillis()));
                zza2.zzc("oa_last_successful_time", String.valueOf(zzeco.zzc(sQLiteDatabase, 2)));
                if (this.zzg.zzC()) {
                    str = "";
                } else {
                    str = this.zze;
                }
                zza2.zzc("oa_session_id", str);
                this.zzf.zza(zza2);
                ArrayList<zzbbk> zza3 = zzeco.zza(sQLiteDatabase);
                zzc(sQLiteDatabase, zza3);
                int size = zza3.size();
                for (int i2 = 0; i2 < size; i2++) {
                    zzbbk zzbbk = zza3.get(i2);
                    zzfdg zza4 = zzfdg.zza("oa_signals");
                    if (this.zzg.zzC()) {
                        str2 = "";
                    } else {
                        str2 = this.zze;
                    }
                    zza4.zzc("oa_session_id", str2);
                    zzbbf zzg2 = zzbbk.zzg();
                    String valueOf = zzg2.zza() ? String.valueOf(zzg2.zzc().zza()) : "-1";
                    String obj = zzfnd.zzb(zzbbk.zzf(), zzecs.zza).toString();
                    zza4.zzc("oa_sig_ts", String.valueOf(zzbbk.zza()));
                    zza4.zzc("oa_sig_status", String.valueOf(zzbbk.zzc().zza()));
                    zza4.zzc("oa_sig_resp_lat", String.valueOf(zzbbk.zzd()));
                    zza4.zzc("oa_sig_render_lat", String.valueOf(zzbbk.zze()));
                    zza4.zzc("oa_sig_formats", obj);
                    zza4.zzc("oa_sig_nw_type", valueOf);
                    zza4.zzc("oa_sig_wifi", String.valueOf(zzbbk.zzh().zza()));
                    zza4.zzc("oa_sig_airplane", String.valueOf(zzbbk.zzi().zza()));
                    zza4.zzc("oa_sig_data", String.valueOf(zzbbk.zzj().zza()));
                    zza4.zzc("oa_sig_nw_resp", String.valueOf(zzbbk.zzk()));
                    zza4.zzc("oa_sig_offline", String.valueOf(zzbbk.zzl().zza()));
                    zza4.zzc("oa_sig_nw_state", String.valueOf(zzbbk.zzm().zza()));
                    if (zzg2.zzd() && zzg2.zza() && zzg2.zzc().equals(zzbbe.CELL)) {
                        zza4.zzc("oa_sig_cell_type", String.valueOf(zzg2.zze().zza()));
                    }
                    this.zzf.zza(zza4);
                }
            } else {
                ArrayList<zzbbk> zza5 = zzeco.zza(sQLiteDatabase);
                zzbbl zza6 = zzbbp.zza();
                zza6.zze(this.zzb.getPackageName());
                zza6.zzf(Build.MODEL);
                zza6.zzb(zzeco.zzb(sQLiteDatabase, 0));
                zza6.zza(zza5);
                zza6.zzc(zzeco.zzb(sQLiteDatabase, 1));
                zza6.zzd(zzs.zzj().currentTimeMillis());
                zza6.zzg(zzeco.zzc(sQLiteDatabase, 2));
                zzc(sQLiteDatabase, zza5);
                this.zza.zzc(new zzecq((zzbbp) zza6.zzah()));
                zzbca zza7 = zzbcb.zza();
                zza7.zza(this.zzd.zzb);
                zza7.zzb(this.zzd.zzc);
                if (true == this.zzd.zzd) {
                    i = 0;
                }
                zza7.zzc(i);
                this.zza.zzc(new zzecr((zzbcb) zza7.zzah()));
                this.zza.zzb(zzayz.OFFLINE_UPLOAD);
            }
            sQLiteDatabase.delete("offline_signal_contents", (String) null, (String[]) null);
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", 0);
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{"failed_requests"});
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("value", 0);
            sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        }
        return null;
    }
}
