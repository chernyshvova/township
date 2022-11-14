package com.applovin.impl.adview.activity.p009b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.adview.AppLovinAdView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.C0653a;
import com.applovin.impl.adview.C0754j;
import com.applovin.impl.adview.C0767m;
import com.applovin.impl.adview.C0781s;
import com.applovin.impl.adview.C0782t;
import com.applovin.impl.adview.C0783u;
import com.applovin.impl.adview.activity.p008a.C0664c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1052a;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.p025ad.C1064g;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1140o;
import com.applovin.impl.sdk.p029e.C1166z;
import com.applovin.impl.sdk.utils.C1263g;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.C1307p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1368R;
import com.swrve.sdk.rest.RESTClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.f */
public class C0705f extends C0670a implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    public boolean f316A;

    /* renamed from: B */
    public long f317B;

    /* renamed from: C */
    public boolean f318C;

    /* renamed from: D */
    public final C0664c f319D = new C0664c(this.f223a, this.f227e, this.f224b);

    /* renamed from: E */
    public MediaPlayer f320E;

    /* renamed from: F */
    public final C0718b f321F = new C0718b();

    /* renamed from: G */
    public final C0717a f322G = new C0717a();

    /* renamed from: H */
    public final Handler f323H;

    /* renamed from: I */
    public final boolean f324I;

    /* renamed from: J */
    public int f325J;

    /* renamed from: K */
    public int f326K;

    /* renamed from: L */
    public boolean f327L;

    /* renamed from: M */
    public final AtomicBoolean f328M;

    /* renamed from: N */
    public final AtomicBoolean f329N;

    /* renamed from: O */
    public long f330O;

    /* renamed from: P */
    public long f331P;

    /* renamed from: t */
    public final AppLovinVideoView f332t;

    /* renamed from: u */
    public final C0653a f333u;
    @Nullable

    /* renamed from: v */
    public final C0767m f334v;
    @Nullable

    /* renamed from: w */
    public final ImageView f335w;
    @Nullable

    /* renamed from: x */
    public final C0782t f336x;
    @Nullable

    /* renamed from: y */
    public final ProgressBar f337y;

    /* renamed from: z */
    public final C0754j f338z;

    /* renamed from: com.applovin.impl.adview.activity.b.f$a */
    public class C0717a implements C0783u.C0784a {
        public C0717a() {
        }

        /* renamed from: a */
        public void mo9528a(C0782t tVar) {
            C0705f.this.f225c.mo11372b("AppLovinFullscreenActivity", "Clicking through from video button...");
            C0705f.this.mo9506a(tVar.getAndClearLastClickLocation());
        }

        /* renamed from: b */
        public void mo9529b(C0782t tVar) {
            C0705f.this.f225c.mo11372b("AppLovinFullscreenActivity", "Closing ad from video button...");
            C0705f.this.mo9466h();
        }

        /* renamed from: c */
        public void mo9530c(C0782t tVar) {
            C0705f.this.f225c.mo11372b("AppLovinFullscreenActivity", "Skipping video from video button...");
            C0705f.this.mo9507c();
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.f$b */
    public class C0718b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        public C0718b() {
        }

        public void onClick(View view, PointF pointF) {
            C0705f.this.mo9506a(pointF);
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            C0705f.this.f225c.mo11372b("AppLovinFullscreenActivity", "Video completed");
            boolean unused = C0705f.this.f327L = true;
            C0705f.this.mo9513y();
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            C0705f fVar = C0705f.this;
            fVar.mo9509c("Video view error (" + i + "," + i2 + ")");
            C0705f.this.f332t.start();
            return true;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            C1314v vVar = C0705f.this.f225c;
            vVar.mo11372b("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i + RESTClient.COMMA_SEPARATOR + i2 + ")");
            if (i == 701) {
                C0705f.this.mo9510v();
                C0705f.this.f226d.mo10740g();
                return false;
            } else if (i == 3) {
                C0705f.this.f338z.mo9651a();
                C0705f fVar = C0705f.this;
                if (fVar.f334v != null) {
                    fVar.m351A();
                }
                C0705f.this.mo9511w();
                if (!C0705f.this.f239q.mo10659c()) {
                    return false;
                }
                C0705f.this.mo9463e();
                return false;
            } else if (i != 702) {
                return false;
            } else {
                C0705f.this.mo9511w();
                return false;
            }
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer unused = C0705f.this.f320E = mediaPlayer;
            mediaPlayer.setOnInfoListener(C0705f.this.f321F);
            mediaPlayer.setOnErrorListener(C0705f.this.f321F);
            float f = C0705f.this.f316A ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f, f);
            C0705f.this.mo9508c((long) mediaPlayer.getDuration());
            C0705f.this.mo9479u();
            C1314v vVar = C0705f.this.f225c;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaPlayer prepared: ");
            outline24.append(C0705f.this.f320E);
            vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.f$c */
    public class C0719c implements View.OnClickListener {
        public C0719c() {
        }

        public void onClick(View view) {
            C0705f fVar = C0705f.this;
            if (view == fVar.f334v) {
                if (fVar.mo9477s()) {
                    C0705f.this.mo9463e();
                    C0705f.this.mo9474p();
                    C0705f.this.f239q.mo10658b();
                    return;
                }
                C0705f.this.mo9507c();
            } else if (view == fVar.f335w) {
                fVar.mo9512x();
            } else {
                C1314v vVar = fVar.f225c;
                vVar.mo11376e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public C0705f(C1057e eVar, Activity activity, C1188m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f323H = handler;
        this.f338z = new C0754j(handler, this.f224b);
        this.f324I = this.f223a.mo9314e();
        this.f316A = Utils.isVideoMutedInitially(this.f224b);
        this.f326K = -1;
        this.f328M = new AtomicBoolean();
        this.f329N = new AtomicBoolean();
        this.f330O = -2;
        this.f331P = 0;
        if (eVar.hasVideoUrl()) {
            AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity, mVar);
            this.f332t = appLovinVideoView;
            appLovinVideoView.setOnPreparedListener(this.f321F);
            this.f332t.setOnCompletionListener(this.f321F);
            this.f332t.setOnErrorListener(this.f321F);
            this.f332t.setOnTouchListener(new AppLovinTouchToClickListener(mVar, C1085b.f1562aR, activity, this.f321F));
            C0719c cVar = new C0719c();
            if (eVar.mo10625o() >= 0) {
                C0767m mVar2 = new C0767m(eVar.mo10631u(), activity);
                this.f334v = mVar2;
                mVar2.setVisibility(8);
                this.f334v.setOnClickListener(cVar);
            } else {
                this.f334v = null;
            }
            if (m358a(this.f316A, mVar)) {
                ImageView imageView = new ImageView(activity);
                this.f335w = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f335w.setClickable(true);
                this.f335w.setOnClickListener(cVar);
                m364e(this.f316A);
            } else {
                this.f335w = null;
            }
            String z = eVar.mo10636z();
            if (StringUtils.isValidString(z)) {
                C0783u uVar = new C0783u(mVar);
                uVar.mo9709a(new WeakReference(this.f322G));
                C0782t tVar = new C0782t(uVar, activity);
                this.f336x = tVar;
                tVar.mo9708a(z);
            } else {
                this.f336x = null;
            }
            if (this.f324I) {
                C0653a aVar = new C0653a(activity, ((Integer) mVar.mo10946a(C1085b.f1654cG)).intValue(), 16842874);
                this.f333u = aVar;
                aVar.setColor(Color.parseColor("#75FFFFFF"));
                this.f333u.setBackgroundColor(Color.parseColor("#00000000"));
                this.f333u.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            } else {
                this.f333u = null;
            }
            if (eVar.mo10564J()) {
                ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842872);
                this.f337y = progressBar;
                progressBar.setMax(10000);
                this.f337y.setPadding(0, 0, 0, 0);
                if (C1263g.m2508d()) {
                    this.f337y.setProgressTintList(ColorStateList.valueOf(eVar.mo10565K()));
                }
                this.f338z.mo9652a("PROGRESS_BAR", ((Long) mVar.mo10946a(C1085b.f1651cD)).longValue(), (C0754j.C0756a) new C0754j.C0756a() {
                    /* renamed from: a */
                    public void mo9504a() {
                        C0705f fVar = C0705f.this;
                        if (fVar.f318C) {
                            fVar.f337y.setVisibility(8);
                            return;
                        }
                        C0705f fVar2 = C0705f.this;
                        fVar2.f337y.setProgress((int) ((((float) fVar.f332t.getCurrentPosition()) / ((float) fVar2.f317B)) * 10000.0f));
                    }

                    /* renamed from: b */
                    public boolean mo9505b() {
                        return !C0705f.this.f318C;
                    }
                });
                return;
            }
            this.f337y = null;
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m351A() {
        if (this.f329N.compareAndSet(false, true)) {
            mo9452a(this.f334v, this.f223a.mo10625o(), new Runnable() {
                public void run() {
                    long unused = C0705f.this.f330O = -1;
                    long unused2 = C0705f.this.f331P = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* renamed from: B */
    private void m352B() {
        C0782t tVar;
        C0781s A = this.f223a.mo10556A();
        if (A != null && A.mo9699e() && !this.f318C && (tVar = this.f336x) != null) {
            final boolean z = tVar.getVisibility() == 4;
            final long f = A.mo9701f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        C1307p.m2629a((View) C0705f.this.f336x, f, (Runnable) null);
                    } else {
                        C1307p.m2634b(C0705f.this.f336x, f, (Runnable) null);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public void m353C() {
        String str;
        C1314v vVar;
        if (this.f318C) {
            vVar = this.f225c;
            str = "Skip video resume - postitial shown";
        } else if (this.f224b.mo10965ac().mo11386a()) {
            vVar = this.f225c;
            str = "Skip video resume - app paused";
        } else if (this.f326K >= 0) {
            C1314v vVar2 = this.f225c;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Resuming video at position ");
            outline24.append(this.f326K);
            outline24.append("ms for MediaPlayer: ");
            outline24.append(this.f320E);
            vVar2.mo11372b("AppLovinFullscreenActivity", outline24.toString());
            this.f332t.seekTo(this.f326K);
            this.f332t.start();
            this.f338z.mo9651a();
            this.f326K = -1;
            mo9453a((Runnable) new Runnable() {
                public void run() {
                    C0653a aVar = C0705f.this.f333u;
                    if (aVar != null) {
                        aVar.mo9422a();
                        C0705f.this.mo9453a((Runnable) new Runnable() {
                            public void run() {
                                C0705f.this.f333u.mo9423b();
                            }
                        }, 2000);
                    }
                }
            }, 250);
            return;
        } else {
            this.f225c.mo11372b("AppLovinFullscreenActivity", "Invalid last video position");
            return;
        }
        vVar.mo11375d("AppLovinFullscreenActivity", str);
    }

    /* renamed from: a */
    public static boolean m358a(boolean z, C1188m mVar) {
        if (!((Boolean) mVar.mo10946a(C1085b.f1695cv)).booleanValue()) {
            return false;
        }
        if (!((Boolean) mVar.mo10946a(C1085b.f1696cw)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) mVar.mo10946a(C1085b.f1698cy)).booleanValue();
    }

    /* renamed from: d */
    private void m363d(boolean z) {
        this.f325J = mo9535z();
        if (z) {
            this.f332t.pause();
        } else {
            this.f332t.stopPlayback();
        }
    }

    /* renamed from: e */
    private void m364e(boolean z) {
        if (C1263g.m2508d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f227e.getDrawable(z ? C1368R.C1369drawable.unmute_to_mute : C1368R.C1369drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f335w.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f335w.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri ay = z ? this.f223a.mo10618ay() : this.f223a.mo10619az();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f335w.setImageURI(ay);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: a */
    public void mo9492a() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* renamed from: a */
    public void mo9449a(long j) {
        mo9453a((Runnable) new Runnable() {
            public void run() {
                C0705f.this.m353C();
            }
        }, j);
    }

    /* renamed from: a */
    public void mo9506a(PointF pointF) {
        if (this.f223a.mo9297B()) {
            this.f225c.mo11372b("AppLovinFullscreenActivity", "Clicking through video");
            Uri j = this.f223a.mo9326j();
            if (j != null) {
                C1267j.m2559a(this.f236n, (AppLovinAd) this.f223a);
                AppLovinAdView appLovinAdView = this.f228f;
                this.f224b.mo11005u().trackAndLaunchVideoClick(this.f223a, j, pointF, appLovinAdView != null ? appLovinAdView.getContext() : this.f224b.mo10932L());
                this.f226d.mo10732b();
                this.f233k++;
                return;
            }
            return;
        }
        m352B();
    }

    /* renamed from: a */
    public void mo9451a(@Nullable ViewGroup viewGroup) {
        this.f319D.mo9440a(this.f335w, this.f334v, this.f336x, this.f333u, this.f337y, this.f332t, this.f228f, viewGroup);
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        mo9456a(!this.f324I);
        this.f332t.setVideoURI(this.f223a.mo9317g());
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (this.f223a.mo10603ai()) {
            this.f239q.mo10656a(this.f223a, (Runnable) new Runnable() {
                public void run() {
                    C0705f.this.mo9449a(250);
                }
            });
        }
        this.f332t.start();
        if (this.f324I) {
            mo9510v();
        }
        this.f228f.renderAd(this.f223a);
        this.f226d.mo10733b(this.f324I ? 1 : 0);
        if (this.f334v != null) {
            this.f224b.mo10938S().mo10831a((C1109a) new C1166z(this.f224b, new Runnable() {
                public void run() {
                    C0705f.this.m351A();
                }
            }), C1140o.C1142a.MAIN, this.f223a.mo10626p(), true);
        }
        super.mo9460b(this.f316A);
    }

    /* renamed from: b */
    public void mo9493b() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Skipping video from prompt");
        mo9507c();
    }

    /* renamed from: c */
    public void mo9507c() {
        this.f330O = SystemClock.elapsedRealtime() - this.f331P;
        C1314v vVar = this.f225c;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Skipping video with skip time: ");
        outline24.append(this.f330O);
        outline24.append("ms");
        vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
        this.f226d.mo10739f();
        this.f232j++;
        if (this.f223a.mo10632v()) {
            mo9466h();
        } else {
            mo9513y();
        }
    }

    /* renamed from: c */
    public void mo9508c(long j) {
        this.f317B = j;
    }

    /* renamed from: c */
    public void mo9509c(String str) {
        C1314v vVar = this.f225c;
        StringBuilder outline27 = GeneratedOutlineSupport.outline27("Encountered media error: ", str, " for ad: ");
        outline27.append(this.f223a);
        vVar.mo11376e("AppLovinFullscreenActivity", outline27.toString());
        if (this.f328M.compareAndSet(false, true)) {
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.f237o;
            if (appLovinAdDisplayListener instanceof C1064g) {
                ((C1064g) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            mo9466h();
        }
    }

    /* renamed from: c */
    public void mo9461c(boolean z) {
        super.mo9461c(z);
        if (z) {
            mo9449a(((Boolean) this.f224b.mo10946a(C1085b.f1769eR)).booleanValue() ? 0 : 250);
        } else if (!this.f318C) {
            mo9463e();
        }
    }

    /* renamed from: d */
    public void mo9462d() {
        mo9451a((ViewGroup) null);
    }

    /* renamed from: e */
    public void mo9463e() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Pausing video");
        this.f326K = this.f332t.getCurrentPosition();
        this.f332t.pause();
        this.f338z.mo9654c();
        C1314v vVar = this.f225c;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Paused video at position ");
        outline24.append(this.f326K);
        outline24.append("ms");
        vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    /* renamed from: h */
    public void mo9466h() {
        this.f338z.mo9653b();
        this.f323H.removeCallbacksAndMessages((Object) null);
        mo9471m();
        super.mo9466h();
    }

    @SuppressLint({"LongLogTag"})
    /* renamed from: j */
    public void mo9468j() {
        this.f225c.mo11374c("AppLovinFullscreenActivity", "Destroying video components");
        try {
            if (this.f324I) {
                AppLovinCommunicator.getInstance(this.f227e).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            }
            if (this.f332t != null) {
                this.f332t.pause();
                this.f332t.stopPlayback();
            }
            if (this.f320E != null) {
                this.f320E.release();
            }
        } catch (Throwable th) {
            Log.e("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.mo9468j();
    }

    /* renamed from: m */
    public void mo9471m() {
        super.mo9448a(mo9535z(), this.f324I, mo9476r(), this.f330O);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j = messageData.getLong("ad_id");
            if (((Boolean) this.f224b.mo10946a(C1085b.f1770eS)).booleanValue() && j == this.f223a.getAdIdNumber() && this.f324I) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i < 200 || i >= 300) && !this.f327L && !this.f332t.isPlaying()) {
                    mo9509c("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
                }
            }
        }
    }

    /* renamed from: r */
    public boolean mo9476r() {
        return mo9535z() >= this.f223a.mo10566L();
    }

    /* renamed from: s */
    public boolean mo9477s() {
        return mo9478t() && !mo9476r();
    }

    /* renamed from: u */
    public void mo9479u() {
        long j;
        int k;
        long j2 = 0;
        if (this.f223a.mo10579Y() >= 0 || this.f223a.mo10580Z() >= 0) {
            int i = (this.f223a.mo10579Y() > 0 ? 1 : (this.f223a.mo10579Y() == 0 ? 0 : -1));
            C1057e eVar = this.f223a;
            if (i >= 0) {
                j = eVar.mo10579Y();
            } else {
                C1052a aVar = (C1052a) eVar;
                long j3 = this.f317B;
                if (j3 > 0) {
                    j2 = 0 + j3;
                }
                if (aVar.mo10595aa() && ((k = (int) ((C1052a) this.f223a).mo10536k()) > 0 || (k = (int) aVar.mo10627q()) > 0)) {
                    j2 += TimeUnit.SECONDS.toMillis((long) k);
                }
                double d = (double) j2;
                double Z = (double) this.f223a.mo10580Z();
                Double.isNaN(Z);
                Double.isNaN(d);
                j = (long) ((Z / 100.0d) * d);
            }
            mo9458b(j);
        }
    }

    /* renamed from: v */
    public void mo9510v() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0653a aVar = C0705f.this.f333u;
                if (aVar != null) {
                    aVar.mo9422a();
                }
            }
        });
    }

    /* renamed from: w */
    public void mo9511w() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0653a aVar = C0705f.this.f333u;
                if (aVar != null) {
                    aVar.mo9423b();
                }
            }
        });
    }

    /* renamed from: x */
    public void mo9512x() {
        if (this.f320E != null) {
            try {
                boolean z = false;
                float f = (float) (!this.f316A ? 0 : 1);
                this.f320E.setVolume(f, f);
                if (!this.f316A) {
                    z = true;
                }
                this.f316A = z;
                m364e(z);
                mo9457a(this.f316A, 0);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: y */
    public void mo9513y() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Showing postitial...");
        m363d(this.f223a.mo10592aG());
        this.f319D.mo9441a(this.f229g, this.f228f);
        mo9455a("javascript:al_onPoststitialShow(" + this.f232j + "," + this.f233k + ");", (long) this.f223a.mo10568N());
        if (this.f229g != null) {
            int i = (this.f223a.mo10627q() > 0 ? 1 : (this.f223a.mo10627q() == 0 ? 0 : -1));
            C0767m mVar = this.f229g;
            if (i >= 0) {
                mo9452a(mVar, this.f223a.mo10627q(), new Runnable() {
                    public void run() {
                        C0705f.this.f231i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.f318C = true;
    }

    /* renamed from: z */
    public int mo9535z() {
        long currentPosition = (long) this.f332t.getCurrentPosition();
        if (this.f327L) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.f317B)) * 100.0f) : this.f325J;
    }
}
