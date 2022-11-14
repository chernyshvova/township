package com.applovin.mediation.nativeAds;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.ads.C0838b;
import com.applovin.impl.mediation.p010a.C0804d;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.C1368R;
import java.lang.ref.WeakReference;

@SuppressLint({"ViewConstructor"})
public class MaxNativeAdView extends FrameLayout {

    /* renamed from: a */
    public final View f2679a;

    /* renamed from: b */
    public final TextView f2680b;

    /* renamed from: c */
    public final TextView f2681c;

    /* renamed from: d */
    public final TextView f2682d;

    /* renamed from: e */
    public final ImageView f2683e;

    /* renamed from: f */
    public final FrameLayout f2684f;

    /* renamed from: g */
    public final ViewGroup f2685g;

    /* renamed from: h */
    public final FrameLayout f2686h;

    /* renamed from: i */
    public final ViewGroup f2687i;

    /* renamed from: j */
    public final FrameLayout f2688j;

    /* renamed from: k */
    public final Button f2689k;

    /* renamed from: l */
    public C0838b f2690l;

    public MaxNativeAdView(MaxNativeAd maxNativeAd, Activity activity) {
        this(maxNativeAd, (String) null, (Context) activity);
    }

    public MaxNativeAdView(@Nullable MaxNativeAd maxNativeAd, MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        super(context);
        boolean z = maxNativeAdViewBinder.templateType != null;
        MaxAdFormat format = maxNativeAd != null ? maxNativeAd.getFormat() : MaxAdFormat.NATIVE;
        View view = maxNativeAdViewBinder.mainView;
        if (view != null) {
            this.f2679a = view;
        } else {
            this.f2679a = LayoutInflater.from(context).inflate(z ? m2708a(maxNativeAdViewBinder.templateType, format) : maxNativeAdViewBinder.layoutResourceId, this, false);
        }
        addView(this.f2679a);
        this.f2680b = (TextView) findViewById(maxNativeAdViewBinder.titleTextViewId);
        this.f2681c = (TextView) findViewById(maxNativeAdViewBinder.advertiserTextViewId);
        this.f2682d = (TextView) findViewById(maxNativeAdViewBinder.bodyTextViewId);
        this.f2683e = (ImageView) findViewById(maxNativeAdViewBinder.iconImageViewId);
        this.f2684f = (FrameLayout) findViewById(maxNativeAdViewBinder.iconContentViewId);
        this.f2685g = (ViewGroup) findViewById(maxNativeAdViewBinder.optionsContentViewGroupId);
        this.f2686h = (FrameLayout) findViewById(maxNativeAdViewBinder.optionsContentFrameLayoutId);
        this.f2687i = (ViewGroup) findViewById(maxNativeAdViewBinder.mediaContentViewGroupId);
        this.f2688j = (FrameLayout) findViewById(maxNativeAdViewBinder.mediaContentFrameLayoutId);
        this.f2689k = (Button) findViewById(maxNativeAdViewBinder.callToActionButtonId);
        if (maxNativeAd != null) {
            m2710a(maxNativeAd);
        }
    }

    public MaxNativeAdView(@Nullable MaxNativeAd maxNativeAd, @Nullable String str, Context context) {
        this(maxNativeAd, new MaxNativeAdViewBinder.Builder(-1).setTemplateType(str).setTitleTextViewId(C1368R.C1370id.native_title_text_view).setAdvertiserTextViewId(C1368R.C1370id.native_advertiser_text_view).setBodyTextViewId(C1368R.C1370id.native_body_text_view).setIconImageViewId(C1368R.C1370id.native_icon_image_view).setIconContentViewId(C1368R.C1370id.native_icon_view).setOptionsContentViewGroupId(C1368R.C1370id.options_view).setOptionsContentFrameLayoutId(C1368R.C1370id.options_view).setMediaContentViewGroupId(C1368R.C1370id.native_media_content_view).setMediaContentFrameLayoutId(C1368R.C1370id.native_media_content_view).setCallToActionButtonId(C1368R.C1370id.native_cta_button).build(), context);
    }

    public MaxNativeAdView(MaxNativeAdViewBinder maxNativeAdViewBinder, Context context) {
        this((MaxNativeAd) null, maxNativeAdViewBinder, context);
    }

    public MaxNativeAdView(String str, Context context) {
        this((MaxNativeAd) null, str, context);
    }

    /* renamed from: a */
    private int m2708a(String str, MaxAdFormat maxAdFormat) {
        if (maxAdFormat == MaxAdFormat.NATIVE) {
            if ("small_template_1".equalsIgnoreCase(str)) {
                return C1368R.layout.max_native_ad_small_template_1;
            }
            if ("medium_template_1".equalsIgnoreCase(str)) {
                return C1368R.layout.max_native_ad_medium_template_1;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Attempting to render MAX native ad with invalid format: ", str));
        } else if (maxAdFormat == MaxAdFormat.BANNER) {
            return "vertical_banner_template".equals(str) ? C1368R.layout.max_native_ad_vertical_banner_view : ("media_banner_template".equals(str) || "no_body_banner_template".equals(str)) ? C1368R.layout.max_native_ad_media_banner_view : "vertical_media_banner_template".equals(str) ? C1368R.layout.max_native_ad_vertical_media_banner_view : C1368R.layout.max_native_ad_banner_view;
        } else {
            if (maxAdFormat == MaxAdFormat.LEADER) {
                return "vertical_leader_template".equals(str) ? C1368R.layout.max_native_ad_vertical_leader_view : C1368R.layout.max_native_ad_leader_view;
            }
            if (maxAdFormat == MaxAdFormat.MREC) {
                return C1368R.layout.max_native_ad_mrec_view;
            }
            throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
        }
    }

    /* renamed from: a */
    private void m2709a() {
        final ViewGroup viewGroup = (ViewGroup) findViewById(C1368R.C1370id.inner_parent_layout);
        if (viewGroup != null) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                final WeakReference weakReference = new WeakReference(viewTreeObserver);
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                            AppLovinSdk.getInstance(MaxNativeAdView.this.getContext()).coreSdk.mo10922B().mo11375d("MaxNativeAdView", "Failed to remove onPreDrawListener since the view tree observer is not alive.");
                        } else {
                            viewTreeObserver.removeOnPreDrawListener(this);
                        }
                        weakReference.clear();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                        layoutParams.height = ((View) viewGroup.getParent()).getWidth();
                        viewGroup.setLayoutParams(layoutParams);
                        return true;
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private void m2710a(MaxNativeAd maxNativeAd) {
        this.f2680b.setText(maxNativeAd.getTitle());
        if (this.f2681c != null) {
            if (StringUtils.isValidString(maxNativeAd.getAdvertiser())) {
                this.f2681c.setText(maxNativeAd.getAdvertiser());
            } else {
                this.f2681c.setVisibility(8);
            }
        }
        if (this.f2682d != null) {
            if (StringUtils.isValidString(maxNativeAd.getBody())) {
                this.f2682d.setText(maxNativeAd.getBody());
            } else {
                this.f2682d.setVisibility(4);
            }
        }
        if (this.f2689k != null) {
            if (StringUtils.isValidString(maxNativeAd.getCallToAction())) {
                this.f2689k.setText(maxNativeAd.getCallToAction());
            } else {
                this.f2689k.setVisibility(4);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        View iconView = maxNativeAd.getIconView();
        if (this.f2684f != null) {
            if (icon == null || this.f2683e == null) {
                if (iconView != null) {
                    iconView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    this.f2684f.removeAllViews();
                    this.f2684f.addView(iconView);
                }
            } else if (icon.getDrawable() != null) {
                this.f2683e.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() != null && StringUtils.isValidString(icon.getUri().toString())) {
                this.f2683e.setImageURI(icon.getUri());
            }
            this.f2684f.setVisibility(8);
        }
        View optionsView = maxNativeAd.getOptionsView();
        if (this.f2686h == null || optionsView == null) {
            FrameLayout frameLayout = this.f2686h;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f2686h.addView(optionsView);
        }
        View mediaView = maxNativeAd.getMediaView();
        if (this.f2688j != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                this.f2688j.addView(mediaView);
            } else if (maxNativeAd.getFormat() == MaxAdFormat.LEADER) {
                this.f2688j.setVisibility(8);
            }
        }
        m2709a();
        postDelayed(new Runnable() {
            public void run() {
                MaxNativeAdView.this.setSelected(true);
            }
        }, 2000);
    }

    /* renamed from: b */
    private void m2711b(MaxNativeAd maxNativeAd) {
        if (this.f2680b != null) {
            if (StringUtils.isValidString(maxNativeAd.getTitle())) {
                this.f2680b.setText(maxNativeAd.getTitle());
            } else {
                this.f2680b.setText((CharSequence) null);
            }
        }
        String body = maxNativeAd.getBody();
        if (this.f2682d != null) {
            if (StringUtils.isValidString(body)) {
                this.f2682d.setText(body);
            } else {
                this.f2682d.setText((CharSequence) null);
            }
        }
        String advertiser = maxNativeAd.getAdvertiser();
        if (this.f2681c != null) {
            if (StringUtils.isValidString(advertiser)) {
                this.f2681c.setText(advertiser);
            } else {
                this.f2681c.setText((CharSequence) null);
            }
        }
        String callToAction = maxNativeAd.getCallToAction();
        if (this.f2689k != null) {
            if (StringUtils.isValidString(callToAction)) {
                this.f2689k.setText(callToAction);
            } else {
                this.f2689k.setText((CharSequence) null);
            }
        }
        MaxNativeAd.MaxNativeAdImage icon = maxNativeAd.getIcon();
        ImageView imageView = this.f2683e;
        if (imageView != null) {
            if (icon == null) {
                imageView.setImageDrawable((Drawable) null);
            } else if (icon.getDrawable() != null) {
                this.f2683e.setImageDrawable(icon.getDrawable());
            } else if (icon.getUri() != null) {
                this.f2683e.setImageURI(icon.getUri());
            } else {
                this.f2683e.setImageDrawable((Drawable) null);
            }
        }
        View mediaView = maxNativeAd.getMediaView();
        ViewGroup viewGroup = this.f2687i;
        if (viewGroup != null) {
            if (mediaView != null) {
                mediaView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.f2687i.addView(mediaView);
            } else {
                viewGroup.removeAllViews();
            }
        }
        View optionsView = maxNativeAd.getOptionsView();
        ViewGroup viewGroup2 = this.f2685g;
        if (viewGroup2 == null) {
            return;
        }
        if (optionsView != null) {
            optionsView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f2685g.addView(optionsView);
            return;
        }
        viewGroup2.removeAllViews();
    }

    public TextView getAdvertiserTextView() {
        return this.f2681c;
    }

    public TextView getBodyTextView() {
        return this.f2682d;
    }

    public Button getCallToActionButton() {
        return this.f2689k;
    }

    @Deprecated
    public FrameLayout getIconContentView() {
        return this.f2684f;
    }

    public ImageView getIconImageView() {
        return this.f2683e;
    }

    public View getMainView() {
        return this.f2679a;
    }

    @Deprecated
    public FrameLayout getMediaContentView() {
        return this.f2688j;
    }

    public ViewGroup getMediaContentViewGroup() {
        ViewGroup viewGroup = this.f2687i;
        return viewGroup != null ? viewGroup : this.f2688j;
    }

    @Deprecated
    public FrameLayout getOptionsContentView() {
        return this.f2686h;
    }

    public ViewGroup getOptionsContentViewGroup() {
        ViewGroup viewGroup = this.f2685g;
        return viewGroup != null ? viewGroup : this.f2686h;
    }

    public TextView getTitleTextView() {
        return this.f2680b;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0838b bVar = this.f2690l;
        if (bVar != null) {
            bVar.mo9994b();
        }
        if (!isHardwareAccelerated()) {
            C1314v.m2662h("MaxNativeAdView", "Attached to non-hardware accelerated window: some native ad views require hardware accelerated Activities to render properly.");
        }
    }

    public void recycle() {
        ViewGroup viewGroup;
        C0838b bVar = this.f2690l;
        if (bVar != null) {
            bVar.mo9993a();
            this.f2690l = null;
        }
        View view = this.f2679a;
        if (view != null && view.getParent() != this && (viewGroup = (ViewGroup) this.f2679a.getParent()) != null) {
            viewGroup.removeAllViews();
            addView(this.f2679a);
            removeView(viewGroup);
        }
    }

    public void render(C0804d dVar, C0836a.C0837a aVar, C1188m mVar) {
        recycle();
        this.f2690l = new C0838b(dVar, aVar, mVar);
        MaxNativeAd v = dVar.mo9862v();
        if (StringUtils.isValidString(dVar.mo9886x())) {
            m2710a(v);
        } else {
            m2711b(v);
        }
    }
}
