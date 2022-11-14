package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzdxk;
import com.google.android.gms.internal.ads.zzdxo;
import com.google.android.gms.internal.ads.zzfqo;
import com.swrve.sdk.SwrveImp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzau {
    public final Context zza;
    public final zzdxo zzb;
    public String zzc;
    public String zzd;
    public String zze;
    @Nullable
    public String zzf;
    public int zzg;
    public int zzh;
    public PointF zzi;
    public PointF zzj;
    public Handler zzk;
    public Runnable zzl;

    public zzau(Context context) {
        this.zzg = 0;
        this.zzl = new zzae(this);
        this.zza = context;
        this.zzh = ViewConfiguration.get(context).getScaledTouchSlop();
        zzs.zzq().zza();
        this.zzk = zzs.zzq().zzb();
        this.zzb = zzs.zzm().zzb();
    }

    private final boolean zzs(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzi.x - f) < ((float) this.zzh) && Math.abs(this.zzi.y - f2) < ((float) this.zzh) && Math.abs(this.zzj.x - f3) < ((float) this.zzh) && Math.abs(this.zzj.y - f4) < ((float) this.zzh);
    }

    private final void zzt(Context context) {
        ArrayList arrayList = new ArrayList();
        int zzu = zzu(arrayList, "None", true);
        int zzu2 = zzu(arrayList, "Shake", true);
        int zzu3 = zzu(arrayList, "Flick", true);
        zzdxk zzdxk = zzdxk.NONE;
        int ordinal = this.zzb.zzf().ordinal();
        int i = ordinal != 1 ? ordinal != 2 ? zzu : zzu3 : zzu2;
        AlertDialog.Builder builder = new AlertDialog.Builder(context, zzs.zze().zzm());
        AtomicInteger atomicInteger = new AtomicInteger(i);
        builder.setTitle("Setup gesture");
        builder.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), i, new zzam(atomicInteger));
        builder.setNegativeButton("Dismiss", new zzan(this));
        builder.setPositiveButton("Save", new zzao(this, atomicInteger, i, zzu2, zzu3));
        builder.setOnCancelListener(new zzap(this));
        builder.create().show();
    }

    public static final int zzu(List<String> list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzc);
        sb.append(",DebugSignal: ");
        sb.append(this.zzf);
        sb.append(",AFMA Version: ");
        sb.append(this.zze);
        sb.append(",Ad Unit ID: ");
        return GeneratedOutlineSupport.outline18(sb, this.zzd, "}");
    }

    public final void zza(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.zzg = 0;
            this.zzi = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.zzg;
        if (i != -1) {
            if (i == 0) {
                if (actionMasked == 5) {
                    this.zzg = 5;
                    this.zzj = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                    this.zzk.postDelayed(this.zzl, ((Long) zzbex.zzc().zzb(zzbjn.zzcW)).longValue());
                }
            } else if (i == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z = false;
                        for (int i2 = 0; i2 < historySize; i2++) {
                            z |= !zzs(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2));
                        }
                        if (zzs(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1)) && !z) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.zzg = -1;
                this.zzk.removeCallbacks(this.zzl);
            }
        }
    }

    public final void zzb() {
        try {
            if (!(this.zza instanceof Activity)) {
                zzcgs.zzh("Can not create dialog without Activity Context");
                return;
            }
            String str = "Creative preview (enabled)";
            if (true == TextUtils.isEmpty(zzs.zzm().zzi())) {
                str = "Creative preview";
            }
            String str2 = "Troubleshooting (enabled)";
            if (true != zzs.zzm().zzm()) {
                str2 = "Troubleshooting";
            }
            ArrayList arrayList = new ArrayList();
            int zzu = zzu(arrayList, "Ad information", true);
            int zzu2 = zzu(arrayList, str, true);
            int zzu3 = zzu(arrayList, str2, true);
            boolean booleanValue = ((Boolean) zzbex.zzc().zzb(zzbjn.zzgq)).booleanValue();
            int zzu4 = zzu(arrayList, "Open ad inspector", booleanValue);
            int zzu5 = zzu(arrayList, "Ad inspector settings", booleanValue);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zza, zzs.zze().zzm());
            builder.setTitle("Select a debug mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzal(this, zzu, zzu2, zzu3, zzu4, zzu5));
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            zze.zzb("", e);
        }
    }

    public final void zzc(String str) {
        this.zzd = str;
    }

    public final void zzd(String str) {
        this.zze = str;
    }

    public final void zze(String str) {
        this.zzc = str;
    }

    public final void zzf(String str) {
        this.zzf = str;
    }

    public final /* synthetic */ void zzg() {
        zzay zzm = zzs.zzm();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        String str3 = this.zzf;
        boolean zzm2 = zzm.zzm();
        zzm.zzl(zzm.zze(context, str, str2));
        if (zzm.zzm()) {
            if (!zzm2 && !TextUtils.isEmpty(str3)) {
                zzm.zzh(context, str2, str3, str);
            }
            zzcgs.zzd("Device is linked for debug signals.");
            zzm.zzn(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzm.zzf(context, str, str2);
    }

    public final /* synthetic */ void zzh() {
        zzay zzm = zzs.zzm();
        Context context = this.zza;
        String str = this.zzd;
        String str2 = this.zze;
        if (!zzm.zzd(context, str, str2)) {
            zzm.zzn(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (SwrveImp.CAMPAIGN_RESPONSE_VERSION.equals(zzm.zza)) {
            zzcgs.zzd("Creative is not pushed for this device.");
            zzm.zzn(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zzm.zza)) {
            zzcgs.zzd("The app is not linked for creative preview.");
            zzm.zzf(context, str, str2);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(zzm.zza)) {
            zzcgs.zzd("Device is linked for in app preview.");
            zzm.zzn(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final /* synthetic */ void zzi(zzfqo zzfqo) {
        if (!zzs.zzm().zze(this.zza, this.zzd, this.zze)) {
            zzs.zzm().zzf(this.zza, this.zzd, this.zze);
        } else {
            zzfqo.execute(new zzaj(this));
        }
    }

    public final /* synthetic */ void zzj() {
        zzt(this.zza);
    }

    public final /* synthetic */ void zzk() {
        zzt(this.zza);
    }

    public final /* synthetic */ void zzl(zzfqo zzfqo) {
        if (!zzs.zzm().zze(this.zza, this.zzd, this.zze)) {
            zzs.zzm().zzf(this.zza, this.zzd, this.zze);
        } else {
            zzfqo.execute(new zzak(this));
        }
    }

    public final /* synthetic */ void zzm() {
        zzs.zzm().zzc(this.zza);
    }

    public final /* synthetic */ void zzn() {
        zzs.zzm().zzc(this.zza);
    }

    public final /* synthetic */ void zzo(String str, DialogInterface dialogInterface, int i) {
        zzs.zzc();
        zzr.zzP(this.zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    public final /* synthetic */ void zzp(AtomicInteger atomicInteger, int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (atomicInteger.get() != i) {
            if (atomicInteger.get() == i2) {
                this.zzb.zze(zzdxk.SHAKE);
            } else if (atomicInteger.get() == i3) {
                this.zzb.zze(zzdxk.FLICK);
            } else {
                this.zzb.zze(zzdxk.NONE);
            }
        }
        zzb();
    }

    public final /* synthetic */ void zzq(int i, int i2, int i3, int i4, int i5, DialogInterface dialogInterface, int i6) {
        if (i6 == i) {
            if (!(this.zza instanceof Activity)) {
                zzcgs.zzh("Can not create dialog without Activity Context");
                return;
            }
            String str = this.zzc;
            String str2 = "No debug information";
            if (!TextUtils.isEmpty(str)) {
                Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                zzs.zzc();
                Map<String, String> zzR = zzr.zzR(build);
                for (String next : zzR.keySet()) {
                    sb.append(next);
                    sb.append(" = ");
                    sb.append(zzR.get(next));
                    sb.append("\n\n");
                }
                String trim = sb.toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    str2 = trim;
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zza);
            builder.setMessage(str2);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new zzaq(this, str2));
            builder.setNegativeButton("Close", zzar.zza);
            builder.create().show();
        } else if (i6 == i2) {
            zzcgs.zzd("Debug mode [Creative Preview] selected.");
            zzche.zza.execute(new zzah(this));
        } else if (i6 == i3) {
            zzcgs.zzd("Debug mode [Troubleshooting] selected.");
            zzche.zza.execute(new zzai(this));
        } else if (i6 == i4) {
            zzfqo zzfqo = zzche.zze;
            zzfqo zzfqo2 = zzche.zza;
            if (this.zzb.zzn()) {
                zzfqo.execute(new zzas(this));
            } else {
                zzfqo2.execute(new zzat(this, zzfqo));
            }
        } else if (i6 == i5) {
            zzfqo zzfqo3 = zzche.zze;
            zzfqo zzfqo4 = zzche.zza;
            if (this.zzb.zzn()) {
                zzfqo3.execute(new zzaf(this));
            } else {
                zzfqo4.execute(new zzag(this, zzfqo3));
            }
        }
    }

    public final /* synthetic */ void zzr() {
        this.zzg = 4;
        zzb();
    }

    public zzau(Context context, String str) {
        this(context);
        this.zzc = str;
    }
}
