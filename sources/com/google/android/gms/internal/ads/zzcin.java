package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcin extends FrameLayout implements zzcif {
    public final zzciz zza;
    public final FrameLayout zzb;
    public final View zzc;
    public final zzbkc zzd;
    public final zzcjb zze;
    public final long zzf;
    @Nullable
    public final zzcig zzg;
    public boolean zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public String zzn;
    public String[] zzo;
    public Bitmap zzp;
    public final ImageView zzq;
    public boolean zzr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcin(Context context, zzciz zzciz, int i, boolean z, zzbkc zzbkc, zzciy zzciy) {
        super(context);
        zzcig zzcig;
        Context context2 = context;
        this.zza = zzciz;
        this.zzd = zzbkc;
        FrameLayout frameLayout = new FrameLayout(context);
        this.zzb = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzciz.zzk());
        zzcih zzcih = zzciz.zzk().zza;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            zzcja zzcja = new zzcja(context, zzciz.zzt(), zzciz.zzm(), zzbkc, zzciz.zzi());
            if (i == 2) {
                zzcig = new zzcjq(context, zzcja, zzciz, z, zzcih.zza(zzciz), zzciy);
            } else {
                Context context3 = context;
                zzcig = new zzcie(context3, zzciz, z, zzcih.zza(zzciz), zzciy, new zzcja(context3, zzciz.zzt(), zzciz.zzm(), zzbkc, zzciz.zzi()));
            }
        } else {
            zzcig = null;
        }
        this.zzg = zzcig;
        View view = new View(context);
        this.zzc = view;
        view.setBackgroundColor(0);
        zzcig zzcig2 = this.zzg;
        if (zzcig2 != null) {
            this.zzb.addView(zzcig2, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzA)).booleanValue()) {
                this.zzb.addView(this.zzc, new FrameLayout.LayoutParams(-1, -1));
                this.zzb.bringChildToFront(this.zzc);
            }
            if (((Boolean) zzbex.zzc().zzb(zzbjn.zzx)).booleanValue()) {
                zzC();
            }
        }
        this.zzq = new ImageView(context);
        this.zzf = ((Long) zzbex.zzc().zzb(zzbjn.zzC)).longValue();
        boolean booleanValue = ((Boolean) zzbex.zzc().zzb(zzbjn.zzz)).booleanValue();
        this.zzk = booleanValue;
        zzbkc zzbkc2 = this.zzd;
        if (zzbkc2 != null) {
            zzbkc2.zzd("spinner_used", true != booleanValue ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        this.zze = new zzcjb(this);
        zzcig zzcig3 = this.zzg;
        if (zzcig3 != null) {
            zzcig3.zzb(this);
        }
        if (this.zzg == null) {
            zzf("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    private final boolean zzH() {
        return this.zzq.getParent() != null;
    }

    /* access modifiers changed from: private */
    public final void zzI(String str, String... strArr) {
        HashMap outline28 = GeneratedOutlineSupport.outline28("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                outline28.put(str2, str3);
                str2 = null;
            }
        }
        this.zza.zze("onVideoEvent", outline28);
    }

    private final void zzJ() {
        if (this.zza.zzj() != null && this.zzi && !this.zzj) {
            this.zza.zzj().getWindow().clearFlags(128);
            this.zzi = false;
        }
    }

    public final void finalize() throws Throwable {
        try {
            this.zze.zza();
            zzcig zzcig = this.zzg;
            if (zzcig != null) {
                zzche.zze.execute(zzcii.zza(zzcig));
            }
        } finally {
            super.finalize();
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zze.zzb();
        } else {
            this.zze.zza();
            this.zzm = this.zzl;
        }
        zzr.zza.post(new zzcij(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zze.zzb();
            z = true;
        } else {
            this.zze.zza();
            this.zzm = this.zzl;
            z = false;
        }
        zzr.zza.post(new zzcim(this, z));
    }

    public final void zzA(int i) {
        this.zzg.zzB(i);
    }

    @TargetApi(14)
    public final void zzB(MotionEvent motionEvent) {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.dispatchTouchEvent(motionEvent);
        }
    }

    @TargetApi(14)
    public final void zzC() {
        String str;
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            TextView textView = new TextView(zzcig.getContext());
            String valueOf = String.valueOf(this.zzg.zza());
            if (valueOf.length() != 0) {
                str = "AdMob - ".concat(valueOf);
            } else {
                str = new String("AdMob - ");
            }
            textView.setText(str);
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzb.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzb.bringChildToFront(textView);
        }
    }

    public final void zzD() {
        this.zze.zza();
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zzd();
        }
        zzJ();
    }

    public final void zzE() {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            long zzh2 = (long) zzcig.zzh();
            if (this.zzl != zzh2 && zzh2 > 0) {
                float f = ((float) zzh2) / 1000.0f;
                if (((Boolean) zzbex.zzc().zzb(zzbjn.zzbj)).booleanValue()) {
                    zzI("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzg.zzo()), "qoeCachedBytes", String.valueOf(this.zzg.zzn()), "qoeLoadedBytes", String.valueOf(this.zzg.zzm()), "droppedFrames", String.valueOf(this.zzg.zzp()), "reportTime", String.valueOf(zzs.zzj().currentTimeMillis()));
                } else {
                    zzI("timeupdate", "time", String.valueOf(f));
                }
                this.zzl = zzh2;
            }
        }
    }

    public final /* synthetic */ void zzF(boolean z) {
        zzI("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zza() {
        this.zze.zzb();
        zzr.zza.post(new zzcik(this));
    }

    public final void zzb() {
        zzcig zzcig = this.zzg;
        if (zzcig != null && this.zzm == 0) {
            zzI("canplaythrough", "duration", String.valueOf(((float) zzcig.zzg()) / 1000.0f), "videoWidth", String.valueOf(this.zzg.zzk()), "videoHeight", String.valueOf(this.zzg.zzl()));
        }
    }

    public final void zzc() {
        if (this.zza.zzj() != null && !this.zzi) {
            boolean z = (this.zza.zzj().getWindow().getAttributes().flags & 128) != 0;
            this.zzj = z;
            if (!z) {
                this.zza.zzj().getWindow().addFlags(128);
                this.zzi = true;
            }
        }
        this.zzh = true;
    }

    public final void zzd() {
        zzI("pause", new String[0]);
        zzJ();
        this.zzh = false;
    }

    public final void zze() {
        zzI("ended", new String[0]);
        zzJ();
    }

    public final void zzf(String str, @Nullable String str2) {
        zzI("error", "what", str, "extra", str2);
    }

    public final void zzg(String str, @Nullable String str2) {
        zzI("exception", "what", "ExoPlayerAdapter exception", "extra", str2);
    }

    public final void zzh() {
        if (this.zzr && this.zzp != null && !zzH()) {
            this.zzq.setImageBitmap(this.zzp);
            this.zzq.invalidate();
            this.zzb.addView(this.zzq, new FrameLayout.LayoutParams(-1, -1));
            this.zzb.bringChildToFront(this.zzq);
        }
        this.zze.zza();
        this.zzm = this.zzl;
        zzr.zza.post(new zzcil(this));
    }

    public final void zzi() {
        if (this.zzh && zzH()) {
            this.zzb.removeView(this.zzq);
        }
        if (this.zzp != null) {
            long elapsedRealtime = zzs.zzj().elapsedRealtime();
            if (this.zzg.getBitmap(this.zzp) != null) {
                this.zzr = true;
            }
            long elapsedRealtime2 = zzs.zzj().elapsedRealtime() - elapsedRealtime;
            if (zze.zzc()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zze.zza(sb.toString());
            }
            if (elapsedRealtime2 > this.zzf) {
                zzcgs.zzi("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzk = false;
                this.zzp = null;
                zzbkc zzbkc = this.zzd;
                if (zzbkc != null) {
                    zzbkc.zzd("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzj(int i, int i2) {
        if (this.zzk) {
            int max = Math.max(i / ((Integer) zzbex.zzc().zzb(zzbjn.zzB)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzbex.zzc().zzb(zzbjn.zzB)).intValue(), 1);
            Bitmap bitmap = this.zzp;
            if (bitmap == null || bitmap.getWidth() != max || this.zzp.getHeight() != max2) {
                this.zzp = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzr = false;
            }
        }
    }

    public final void zzk() {
        this.zzc.setVisibility(4);
    }

    public final void zzl(int i) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzA)).booleanValue()) {
            this.zzb.setBackgroundColor(i);
            this.zzc.setBackgroundColor(i);
        }
    }

    public final void zzm(int i, int i2, int i3, int i4) {
        if (zze.zzc()) {
            StringBuilder outline22 = GeneratedOutlineSupport.outline22(75, "Set video bounds to x:", i, ";y:", i2);
            outline22.append(";w:");
            outline22.append(i3);
            outline22.append(";h:");
            outline22.append(i4);
            zze.zza(outline22.toString());
        }
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzb.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzn(String str, String[] strArr) {
        this.zzn = str;
        this.zzo = strArr;
    }

    public final void zzo(float f, float f2) {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zzj(f, f2);
        }
    }

    public final void zzp() {
        if (this.zzg != null) {
            if (!TextUtils.isEmpty(this.zzn)) {
                this.zzg.zzw(this.zzn, this.zzo);
            } else {
                zzI("no_src", new String[0]);
            }
        }
    }

    public final void zzq() {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zzf();
        }
    }

    public final void zzr() {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zze();
        }
    }

    public final void zzs(int i) {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zzi(i);
        }
    }

    public final void zzt() {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zzb.zza(true);
            zzcig.zzq();
        }
    }

    public final void zzu() {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zzb.zza(false);
            zzcig.zzq();
        }
    }

    public final void zzv(float f) {
        zzcig zzcig = this.zzg;
        if (zzcig != null) {
            zzcig.zzb.zzb(f);
            zzcig.zzq();
        }
    }

    public final void zzw(int i) {
        this.zzg.zzx(i);
    }

    public final void zzx(int i) {
        this.zzg.zzy(i);
    }

    public final void zzy(int i) {
        this.zzg.zzz(i);
    }

    public final void zzz(int i) {
        this.zzg.zzA(i);
    }
}
