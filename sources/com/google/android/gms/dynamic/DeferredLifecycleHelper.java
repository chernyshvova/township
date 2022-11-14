package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.LinkedList;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    public T zaa;
    @Nullable
    public Bundle zab;
    public LinkedList<zaa> zac;
    public final OnDelegateCreatedListener<T> zad = new zaa(this);

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface zaa {
        int zaa();

        void zaa(LifecycleDelegate lifecycleDelegate);
    }

    @KeepForSdk
    public static void showGooglePlayUnavailableMessage(@RecentlyNonNull FrameLayout frameLayout) {
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(context);
        String zac2 = zac.zac(context, isGooglePlayServicesAvailable);
        String zae = zac.zae(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zac2);
        linearLayout.addView(textView);
        Intent errorResolutionIntent = instance.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, (String) null);
        if (errorResolutionIntent != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zae);
            linearLayout.addView(button);
            button.setOnClickListener(new zad(context, errorResolutionIntent));
        }
    }

    private final void zaa(int i) {
        while (!this.zac.isEmpty() && this.zac.getLast().zaa() >= i) {
            this.zac.removeLast();
        }
    }

    @KeepForSdk
    public abstract void createDelegate(@RecentlyNonNull OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @RecentlyNonNull
    @KeepForSdk
    public T getDelegate() {
        return this.zaa;
    }

    @KeepForSdk
    public void handleGooglePlayUnavailable(@RecentlyNonNull FrameLayout frameLayout) {
        showGooglePlayUnavailableMessage(frameLayout);
    }

    @KeepForSdk
    public void onCreate(@RecentlyNonNull Bundle bundle) {
        zaa(bundle, (zaa) new zab(this, bundle));
    }

    @RecentlyNonNull
    @KeepForSdk
    public View onCreateView(@RecentlyNonNull LayoutInflater layoutInflater, @RecentlyNonNull ViewGroup viewGroup, @RecentlyNonNull Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        zaa(bundle, (zaa) new zae(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.zaa == null) {
            handleGooglePlayUnavailable(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    public void onDestroy() {
        T t = this.zaa;
        if (t != null) {
            t.onDestroy();
        } else {
            zaa(1);
        }
    }

    @KeepForSdk
    public void onDestroyView() {
        T t = this.zaa;
        if (t != null) {
            t.onDestroyView();
        } else {
            zaa(2);
        }
    }

    @KeepForSdk
    public void onInflate(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2) {
        zaa(bundle2, (zaa) new zac(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void onLowMemory() {
        T t = this.zaa;
        if (t != null) {
            t.onLowMemory();
        }
    }

    @KeepForSdk
    public void onPause() {
        T t = this.zaa;
        if (t != null) {
            t.onPause();
        } else {
            zaa(5);
        }
    }

    @KeepForSdk
    public void onResume() {
        zaa((Bundle) null, (zaa) new zaf(this));
    }

    @KeepForSdk
    public void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        T t = this.zaa;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.zab;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void onStart() {
        zaa((Bundle) null, (zaa) new zag(this));
    }

    @KeepForSdk
    public void onStop() {
        T t = this.zaa;
        if (t != null) {
            t.onStop();
        } else {
            zaa(4);
        }
    }

    private final void zaa(@Nullable Bundle bundle, zaa zaa2) {
        T t = this.zaa;
        if (t != null) {
            zaa2.zaa(t);
            return;
        }
        if (this.zac == null) {
            this.zac = new LinkedList<>();
        }
        this.zac.add(zaa2);
        if (bundle != null) {
            Bundle bundle2 = this.zab;
            if (bundle2 == null) {
                this.zab = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.zad);
    }
}
