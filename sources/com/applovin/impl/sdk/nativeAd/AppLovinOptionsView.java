package com.applovin.impl.sdk.nativeAd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.C1368R;

@SuppressLint({"ViewConstructor"})
public class AppLovinOptionsView extends FrameLayout implements AppLovinTouchToClickListener.OnClickListener {
    public final Uri privacyUri;
    public final C1188m sdk;

    public AppLovinOptionsView(Uri uri, C1188m mVar, Context context) {
        super(context);
        this.sdk = mVar;
        this.privacyUri = uri;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setAlpha(0.2f);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setImageResource(C1368R.C1369drawable.privacy_icon);
        addView(imageView);
        setOnTouchListener(new AppLovinTouchToClickListener(mVar, C1085b.f1563aS, context, this));
    }

    public void onClick(View view, PointF pointF) {
        Utils.openUri(this.sdk.mo10932L(), this.privacyUri, this.sdk);
    }
}
