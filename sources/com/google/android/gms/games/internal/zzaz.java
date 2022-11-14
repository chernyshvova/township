package com.google.android.gms.games.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.games_v2.zzam;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class zzaz implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, zzd {
    public final zzas zza;
    public final zzam zzb;
    @Nullable
    public WeakReference<View> zzc;
    public boolean zzd = false;

    public zzaz(zzas zzas, int i) {
        this.zza = zzas;
        this.zzb = new zzam(i, (IBinder) null);
    }

    public static zzaz zzd(zzas zzas, int i) {
        return new zzaz(zzas, i);
    }

    @TargetApi(17)
    private final void zzh(View view) {
        Display display;
        int i = -1;
        if (PlatformVersion.isAtLeastJellyBeanMR1() && (display = view.getDisplay()) != null) {
            i = display.getDisplayId();
        }
        IBinder windowToken = view.getWindowToken();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        zzam zzam = this.zzb;
        zzam.zzc = i;
        zzam.zza = windowToken;
        int i2 = iArr[0];
        zzam.zzd = i2;
        int i3 = iArr[1];
        zzam.zze = i3;
        zzam.zzf = i2 + width;
        zzam.zzg = i3 + height;
        if (this.zzd) {
            zzg();
        }
    }

    public final void onGlobalLayout() {
        View view;
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            zzh(view);
        }
    }

    public final void onViewAttachedToWindow(View view) {
        zzh(view);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zza.zzs();
        view.removeOnAttachStateChangeListener(this);
    }

    public final void zza(Activity activity) {
        View view;
        try {
            view = activity.findViewById(16908290);
        } catch (IllegalStateException unused) {
            view = null;
        }
        if (view == null && (view = activity.getWindow().getDecorView()) == null) {
            String valueOf = String.valueOf(activity);
            valueOf.length();
            zzat.zzg("PopupManager", "Failed to bind to: ".concat(valueOf));
            return;
        }
        String valueOf2 = String.valueOf(activity);
        valueOf2.length();
        zzat.zzf("PopupManager", "Binding to: ".concat(valueOf2));
        zzf(view);
    }

    public final Bundle zzb() {
        return this.zzb.zza();
    }

    @Nullable
    public final IBinder zzc() {
        return this.zzb.zza;
    }

    public final zzam zze() {
        return this.zzb;
    }

    @TargetApi(16)
    public final void zzf(View view) {
        this.zza.zzs();
        WeakReference<View> weakReference = this.zzc;
        if (weakReference != null) {
            View view2 = (View) weakReference.get();
            Context context = this.zza.getContext();
            if (view2 == null && (context instanceof Activity)) {
                view2 = ((Activity) context).getWindow().getDecorView();
            }
            if (view2 != null) {
                view2.removeOnAttachStateChangeListener(this);
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                if (PlatformVersion.isAtLeastJellyBean()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
        this.zzc = null;
        Context context2 = this.zza.getContext();
        if (view == null && (context2 instanceof Activity)) {
            Activity activity = (Activity) context2;
            try {
                view = activity.findViewById(16908290);
            } catch (IllegalStateException unused) {
            }
            if (view == null) {
                view = activity.getWindow().getDecorView();
            }
            zzat.zzg("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        }
        if (view != null) {
            zzh(view);
            this.zzc = new WeakReference<>(view);
            view.addOnAttachStateChangeListener(this);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
            return;
        }
        zzat.zzc("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }

    public final void zzg() {
        boolean z;
        zzam zzam = this.zzb;
        IBinder iBinder = zzam.zza;
        if (iBinder != null) {
            this.zza.zzU(iBinder, zzam.zza());
            z = false;
        } else {
            z = true;
        }
        this.zzd = z;
    }
}
