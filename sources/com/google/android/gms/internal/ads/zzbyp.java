package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.vungle.warren.VisionController;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyp extends zzbyq implements zzbps<zzcmr> {
    public DisplayMetrics zza;
    public int zzb = -1;
    public int zzc = -1;
    public int zzd = -1;
    public int zze = -1;
    public int zzf = -1;
    public int zzg = -1;
    public final zzcmr zzh;
    public final Context zzi;
    public final WindowManager zzj;
    public final zzbiy zzk;
    public float zzl;
    public int zzm;

    public zzbyp(zzcmr zzcmr, Context context, zzbiy zzbiy) {
        super(zzcmr, "");
        this.zzh = zzcmr;
        this.zzi = context;
        this.zzk = zzbiy;
        this.zzj = (WindowManager) context.getSystemService(VisionController.WINDOW);
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObject;
        zzcmr zzcmr = (zzcmr) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        zzbev.zza();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzcgl.zzq(displayMetrics, displayMetrics.widthPixels);
        zzbev.zza();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzcgl.zzq(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzj2 = this.zzh.zzj();
        if (zzj2 == null || zzj2.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            zzs.zzc();
            int[] zzT = zzr.zzT(zzj2);
            zzbev.zza();
            this.zzd = zzcgl.zzq(this.zza, zzT[0]);
            zzbev.zza();
            this.zze = zzcgl.zzq(this.zza, zzT[1]);
        }
        if (this.zzh.zzP().zzg()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzk(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbyo zzbyo = new zzbyo();
        zzbiy zzbiy = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbyo.zzb(zzbiy.zzc(intent));
        zzbiy zzbiy2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbyo.zza(zzbiy2.zzc(intent2));
        zzbyo.zzc(this.zzk.zzb());
        zzbyo.zzd(this.zzk.zza());
        zzbyo.zze(true);
        boolean zzf2 = zzbyo.zza;
        boolean zzg2 = zzbyo.zzb;
        boolean zzh2 = zzbyo.zzc;
        boolean zzi2 = zzbyo.zzd;
        boolean zzj3 = zzbyo.zze;
        zzcmr zzcmr2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", zzf2).put("tel", zzg2).put("calendar", zzh2).put("storePicture", zzi2).put("inlineVideo", zzj3);
        } catch (JSONException e) {
            zzcgs.zzg("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObject = null;
        }
        zzcmr2.zzd("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(zzbev.zza().zza(this.zzi, iArr[0]), zzbev.zza().zza(this.zzi, iArr[1]));
        if (zzcgs.zzm(2)) {
            zzcgs.zzh("Dispatching Ready Event.");
        }
        zzg(this.zzh.zzt().zza);
    }

    public final void zzb(int i, int i2) {
        int i3;
        int i4 = 0;
        if (this.zzi instanceof Activity) {
            zzs.zzc();
            i3 = zzr.zzV((Activity) this.zzi)[0];
        } else {
            i3 = 0;
        }
        if (this.zzh.zzP() == null || !this.zzh.zzP().zzg()) {
            int width = this.zzh.getWidth();
            int height = this.zzh.getHeight();
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzM)).booleanValue()) {
                if (width == 0) {
                    width = this.zzh.zzP() != null ? this.zzh.zzP().zzb : 0;
                }
                if (height == 0) {
                    if (this.zzh.zzP() != null) {
                        i4 = this.zzh.zzP().zza;
                    }
                    this.zzf = zzbev.zza().zza(this.zzi, width);
                    this.zzg = zzbev.zza().zza(this.zzi, i4);
                }
            }
            i4 = height;
            this.zzf = zzbev.zza().zza(this.zzi, width);
            this.zzg = zzbev.zza().zza(this.zzi, i4);
        }
        zzi(i, i2 - i3, this.zzf, this.zzg);
        this.zzh.zzR().zzC(i, i2);
    }
}
