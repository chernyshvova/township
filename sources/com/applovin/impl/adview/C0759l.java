package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.C0752i;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p028d.C1101d;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.l */
public class C0759l extends Dialog implements C0758k {

    /* renamed from: a */
    public final Activity f458a;

    /* renamed from: b */
    public final C1188m f459b;

    /* renamed from: c */
    public final C1314v f460c;

    /* renamed from: d */
    public final C0740d f461d;

    /* renamed from: e */
    public final C1052a f462e;

    /* renamed from: f */
    public RelativeLayout f463f;

    /* renamed from: g */
    public C0752i f464g;

    public C0759l(C1052a aVar, C0740d dVar, Activity activity, C1188m mVar) {
        super(activity, 16973840);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (dVar == null) {
            throw new IllegalArgumentException("No main view specified");
        } else if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            this.f459b = mVar;
            this.f460c = mVar.mo10922B();
            this.f458a = activity;
            this.f461d = dVar;
            this.f462e = aVar;
            requestWindowFeature(1);
            setCancelable(false);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    /* renamed from: a */
    private int m532a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f458a, i);
    }

    /* renamed from: a */
    private void m534a(C0752i.C0753a aVar) {
        if (this.f464g != null) {
            this.f460c.mo11375d("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        C0752i a = C0752i.m513a(aVar, this.f458a);
        this.f464g = a;
        a.setVisibility(8);
        this.f464g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                C0759l.this.m538d();
            }
        });
        this.f464g.setClickable(false);
        int a2 = m532a(((Integer) this.f459b.mo10946a(C1085b.f1621bZ)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(10);
        int i = 9;
        layoutParams.addRule(((Boolean) this.f459b.mo10946a(C1085b.f1676cc)).booleanValue() ? 9 : 11);
        this.f464g.mo9646a(a2);
        int a3 = m532a(((Integer) this.f459b.mo10946a(C1085b.f1675cb)).intValue());
        int a4 = m532a(((Integer) this.f459b.mo10946a(C1085b.f1674ca)).intValue());
        layoutParams.setMargins(a4, a3, a4, 0);
        this.f463f.addView(this.f464g, layoutParams);
        this.f464g.bringToFront();
        int a5 = m532a(((Integer) this.f459b.mo10946a(C1085b.f1677cd)).intValue());
        View view = new View(this.f458a);
        view.setBackgroundColor(0);
        int i2 = a2 + a5;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams2.addRule(10);
        if (!((Boolean) this.f459b.mo10946a(C1085b.f1676cc)).booleanValue()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(a4 - m532a(5), a3 - m532a(5), a4 - m532a(5), 0);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (C0759l.this.f464g.isClickable()) {
                    C0759l.this.f464g.performClick();
                }
            }
        });
        this.f463f.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: c */
    private void m536c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f461d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f458a);
        this.f463f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f463f.setBackgroundColor(-1157627904);
        this.f463f.addView(this.f461d);
        if (!this.f462e.mo10537l()) {
            m534a(this.f462e.mo10538m());
            m541e();
        }
        setContentView(this.f463f);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m538d() {
        this.f461d.mo9616a("javascript:al_onCloseTapped();", (Runnable) new Runnable() {
            public void run() {
                C0759l.this.dismiss();
            }
        });
    }

    /* renamed from: e */
    private void m541e() {
        this.f458a.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (C0759l.this.f464g == null) {
                        C0759l.this.m538d();
                    }
                    C0759l.this.f464g.setVisibility(0);
                    C0759l.this.f464g.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(300);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            C0759l.this.f464g.setClickable(true);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    C0759l.this.f464g.startAnimation(alphaAnimation);
                } catch (Throwable th) {
                    C0759l.this.f460c.mo11373b("ExpandedAdDialog", "Unable to fade in close button", th);
                    C0759l.this.m538d();
                }
            }
        });
    }

    /* renamed from: a */
    public C1052a mo9659a() {
        return this.f462e;
    }

    /* renamed from: b */
    public C0740d mo9660b() {
        return this.f461d;
    }

    public void dismiss() {
        C1101d statsManagerHelper = this.f461d.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.mo10738e();
        }
        this.f458a.runOnUiThread(new Runnable() {
            public void run() {
                C0759l.this.f463f.removeView(C0759l.this.f461d);
                C0759l.super.dismiss();
            }
        });
    }

    public void onBackPressed() {
        this.f461d.mo9616a("javascript:al_onBackPressed();", (Runnable) new Runnable() {
            public void run() {
                C0759l.this.dismiss();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m536c();
    }

    public void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f458a.getWindow().getAttributes().flags, this.f458a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
                return;
            }
            this.f460c.mo11376e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
        } catch (Throwable th) {
            this.f460c.mo11373b("ExpandedAdDialog", "Setting window flags failed.", th);
        }
    }
}
