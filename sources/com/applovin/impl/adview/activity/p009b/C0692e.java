package com.applovin.impl.adview.activity.p009b;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
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
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.e */
public class C0692e extends C0670a implements AppLovinCommunicatorSubscriber {

    /* renamed from: A */
    public final C0754j f280A;

    /* renamed from: B */
    public boolean f281B;

    /* renamed from: C */
    public long f282C;

    /* renamed from: D */
    public int f283D;

    /* renamed from: E */
    public boolean f284E;

    /* renamed from: F */
    public boolean f285F;

    /* renamed from: G */
    public final C0664c f286G = new C0664c(this.f223a, this.f227e, this.f224b);

    /* renamed from: H */
    public final C0702a f287H = new C0702a();

    /* renamed from: I */
    public final Handler f288I;

    /* renamed from: J */
    public final boolean f289J;

    /* renamed from: K */
    public long f290K;

    /* renamed from: L */
    public final AtomicBoolean f291L;

    /* renamed from: M */
    public final AtomicBoolean f292M;

    /* renamed from: N */
    public long f293N;

    /* renamed from: O */
    public long f294O;

    /* renamed from: t */
    public final PlayerView f295t;

    /* renamed from: u */
    public final SimpleExoPlayer f296u;

    /* renamed from: v */
    public final C0653a f297v;
    @Nullable

    /* renamed from: w */
    public final C0767m f298w;
    @Nullable

    /* renamed from: x */
    public final ImageView f299x;
    @Nullable

    /* renamed from: y */
    public final C0782t f300y;
    @Nullable

    /* renamed from: z */
    public final ProgressBar f301z;

    /* renamed from: com.applovin.impl.adview.activity.b.e$a */
    public class C0702a implements C0783u.C0784a {
        public C0702a() {
        }

        /* renamed from: a */
        public void mo9528a(C0782t tVar) {
            C0692e.this.f225c.mo11372b("AppLovinFullscreenActivity", "Clicking through from video button...");
            C0692e.this.mo9496a(tVar.getAndClearLastClickLocation());
        }

        /* renamed from: b */
        public void mo9529b(C0782t tVar) {
            C0692e.this.f225c.mo11372b("AppLovinFullscreenActivity", "Closing ad from video button...");
            C0692e.this.mo9466h();
        }

        /* renamed from: c */
        public void mo9530c(C0782t tVar) {
            C0692e.this.f225c.mo11372b("AppLovinFullscreenActivity", "Skipping video from video button...");
            C0692e.this.mo9497c();
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.e$b */
    public class C0703b implements AppLovinTouchToClickListener.OnClickListener, Player.EventListener, PlayerControlView.VisibilityListener {
        public C0703b() {
        }

        public void onClick(View view, PointF pointF) {
            C0692e.this.mo9496a(pointF);
        }

        public void onPlaybackStateChanged(int i) {
            C1314v vVar = C0692e.this.f225c;
            StringBuilder outline25 = GeneratedOutlineSupport.outline25("Player state changed to state ", i, " and will play when ready: ");
            outline25.append(C0692e.this.f296u.getPlayWhenReady());
            vVar.mo11372b("AppLovinFullscreenActivity", outline25.toString());
            if (i == 2) {
                C0692e.this.mo9500v();
                C0692e.this.f226d.mo10740g();
            } else if (i == 3) {
                C0692e eVar = C0692e.this;
                eVar.f296u.setVolume(eVar.f281B ^ true ? 1.0f : 0.0f);
                C0692e eVar2 = C0692e.this;
                eVar2.mo9498c(eVar2.f296u.getDuration());
                C0692e.this.mo9479u();
                C1314v vVar2 = C0692e.this.f225c;
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaPlayer prepared: ");
                outline24.append(C0692e.this.f296u);
                vVar2.mo11372b("AppLovinFullscreenActivity", outline24.toString());
                C0692e.this.f280A.mo9651a();
                C0692e eVar3 = C0692e.this;
                if (eVar3.f298w != null) {
                    eVar3.mo9514A();
                }
                C0692e.this.mo9501w();
                if (C0692e.this.f239q.mo10659c()) {
                    C0692e.this.mo9463e();
                }
            } else if (i == 4) {
                C0692e.this.f225c.mo11372b("AppLovinFullscreenActivity", "Video completed");
                C0692e eVar4 = C0692e.this;
                eVar4.f285F = true;
                eVar4.mo9503y();
            }
        }

        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            C0692e eVar = C0692e.this;
            eVar.mo9499c("Video view error (" + exoPlaybackException + ")");
            C0692e.this.mo9466h();
        }

        public void onVisibilityChange(int i) {
            if (i == 0) {
                C0692e.this.f295t.hideController();
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.b.e$c */
    public class C0704c implements View.OnClickListener {
        public C0704c() {
        }

        public void onClick(View view) {
            C0692e eVar = C0692e.this;
            if (view == eVar.f298w) {
                if (eVar.mo9477s()) {
                    C0692e.this.mo9463e();
                    C0692e.this.mo9474p();
                    C0692e.this.f239q.mo10658b();
                    return;
                }
                C0692e.this.mo9497c();
            } else if (view == eVar.f299x) {
                eVar.mo9502x();
            } else {
                C1314v vVar = eVar.f225c;
                vVar.mo11376e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public C0692e(C1057e eVar, Activity activity, C1188m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f288I = handler;
        this.f280A = new C0754j(handler, this.f224b);
        this.f289J = this.f223a.mo9314e();
        this.f281B = Utils.isVideoMutedInitially(this.f224b);
        this.f290K = -1;
        this.f291L = new AtomicBoolean();
        this.f292M = new AtomicBoolean();
        this.f293N = -2;
        this.f294O = 0;
        if (eVar.hasVideoUrl()) {
            C0704c cVar = new C0704c();
            if (eVar.mo10625o() >= 0) {
                C0767m mVar2 = new C0767m(eVar.mo10631u(), activity);
                this.f298w = mVar2;
                mVar2.setVisibility(8);
                this.f298w.setOnClickListener(cVar);
            } else {
                this.f298w = null;
            }
            if (m317a(this.f281B, mVar)) {
                ImageView imageView = new ImageView(activity);
                this.f299x = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.f299x.setClickable(true);
                this.f299x.setOnClickListener(cVar);
                mo9518d(this.f281B);
            } else {
                this.f299x = null;
            }
            String z = eVar.mo10636z();
            if (StringUtils.isValidString(z)) {
                C0783u uVar = new C0783u(mVar);
                uVar.mo9709a(new WeakReference(this.f287H));
                C0782t tVar = new C0782t(uVar, activity);
                this.f300y = tVar;
                tVar.mo9708a(z);
            } else {
                this.f300y = null;
            }
            if (this.f289J) {
                C0653a aVar = new C0653a(activity, ((Integer) mVar.mo10946a(C1085b.f1654cG)).intValue(), 16842874);
                this.f297v = aVar;
                aVar.setColor(Color.parseColor("#75FFFFFF"));
                this.f297v.setBackgroundColor(Color.parseColor("#00000000"));
                this.f297v.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            } else {
                this.f297v = null;
            }
            if (eVar.mo10564J()) {
                ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842872);
                this.f301z = progressBar;
                progressBar.setMax(10000);
                this.f301z.setPadding(0, 0, 0, 0);
                if (C1263g.m2508d()) {
                    this.f301z.setProgressTintList(ColorStateList.valueOf(eVar.mo10565K()));
                }
                this.f280A.mo9652a("PROGRESS_BAR", ((Long) mVar.mo10946a(C1085b.f1651cD)).longValue(), (C0754j.C0756a) new C0754j.C0756a() {
                    /* renamed from: a */
                    public void mo9504a() {
                        C0692e eVar = C0692e.this;
                        if (eVar.f284E) {
                            eVar.f301z.setVisibility(8);
                            return;
                        }
                        C0692e eVar2 = C0692e.this;
                        eVar2.f301z.setProgress((int) ((((float) eVar.f296u.getCurrentPosition()) / ((float) eVar2.f282C)) * 10000.0f));
                    }

                    /* renamed from: b */
                    public boolean mo9505b() {
                        return !C0692e.this.f284E;
                    }
                });
            } else {
                this.f301z = null;
            }
            this.f296u = new SimpleExoPlayer.Builder(activity).build();
            C0703b bVar = new C0703b();
            this.f296u.addListener(bVar);
            this.f296u.setRepeatMode(0);
            PlayerView playerView = new PlayerView(activity);
            this.f295t = playerView;
            playerView.hideController();
            this.f295t.setControllerVisibilityListener(bVar);
            this.f295t.setPlayer(this.f296u);
            this.f295t.setOnTouchListener(new AppLovinTouchToClickListener(mVar, C1085b.f1562aR, activity, bVar));
            mo9519z();
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    /* renamed from: E */
    private void m315E() {
        C0782t tVar;
        C0781s A = this.f223a.mo10556A();
        if (A != null && A.mo9699e() && !this.f284E && (tVar = this.f300y) != null) {
            final boolean z = tVar.getVisibility() == 4;
            final long f = A.mo9701f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        C1307p.m2629a((View) C0692e.this.f300y, f, (Runnable) null);
                    } else {
                        C1307p.m2634b(C0692e.this.f300y, f, (Runnable) null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m317a(boolean z, C1188m mVar) {
        if (!((Boolean) mVar.mo10946a(C1085b.f1695cv)).booleanValue()) {
            return false;
        }
        if (!((Boolean) mVar.mo10946a(C1085b.f1696cw)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) mVar.mo10946a(C1085b.f1698cy)).booleanValue();
    }

    /* renamed from: A */
    public void mo9514A() {
        if (this.f292M.compareAndSet(false, true)) {
            mo9452a(this.f298w, this.f223a.mo10625o(), new Runnable() {
                public void run() {
                    long unused = C0692e.this.f293N = -1;
                    long unused2 = C0692e.this.f294O = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* renamed from: B */
    public void mo9515B() {
        this.f283D = mo9517D();
        this.f296u.setPlayWhenReady(false);
    }

    /* renamed from: C */
    public void mo9516C() {
        String str;
        C1314v vVar;
        if (this.f284E) {
            vVar = this.f225c;
            str = "Skip video resume - postitial shown";
        } else if (this.f224b.mo10965ac().mo11386a()) {
            vVar = this.f225c;
            str = "Skip video resume - app paused";
        } else {
            long j = this.f290K;
            if (j >= 0) {
                long aF = this.f223a.mo10591aF();
                if (aF > 0) {
                    j = Math.max(0, j - aF);
                    this.f296u.seekTo(j);
                }
                C1314v vVar2 = this.f225c;
                vVar2.mo11372b("AppLovinFullscreenActivity", "Resuming video at position " + j + "ms for MediaPlayer: " + this.f296u);
                this.f296u.setPlayWhenReady(true);
                this.f280A.mo9651a();
                this.f290K = -1;
                if (!this.f296u.isPlaying()) {
                    mo9500v();
                    return;
                }
                return;
            }
            C1314v vVar3 = this.f225c;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Invalid last video position, isVideoPlaying=");
            outline24.append(this.f296u.isPlaying());
            vVar3.mo11372b("AppLovinFullscreenActivity", outline24.toString());
            return;
        }
        vVar.mo11375d("AppLovinFullscreenActivity", str);
    }

    /* renamed from: D */
    public int mo9517D() {
        long currentPosition = this.f296u.getCurrentPosition();
        if (this.f285F) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.f282C)) * 100.0f) : this.f283D;
    }

    /* renamed from: a */
    public void mo9492a() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    /* renamed from: a */
    public void mo9449a(long j) {
        mo9453a((Runnable) new Runnable() {
            public void run() {
                C0692e.this.mo9516C();
            }
        }, j);
    }

    /* renamed from: a */
    public void mo9496a(PointF pointF) {
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
        m315E();
    }

    /* renamed from: a */
    public void mo9451a(@Nullable ViewGroup viewGroup) {
        this.f286G.mo9440a(this.f299x, this.f298w, this.f300y, this.f297v, this.f301z, this.f295t, this.f228f, viewGroup);
        this.f296u.setPlayWhenReady(true);
        if (this.f223a.mo10603ai()) {
            this.f239q.mo10656a(this.f223a, (Runnable) new Runnable() {
                public void run() {
                    C0692e.this.mo9449a(250);
                }
            });
        }
        if (this.f289J) {
            mo9500v();
        }
        this.f228f.renderAd(this.f223a);
        this.f226d.mo10733b(this.f289J ? 1 : 0);
        if (this.f298w != null) {
            this.f224b.mo10938S().mo10831a((C1109a) new C1166z(this.f224b, new Runnable() {
                public void run() {
                    C0692e.this.mo9514A();
                }
            }), C1140o.C1142a.MAIN, this.f223a.mo10626p(), true);
        }
        super.mo9460b(this.f281B);
    }

    /* renamed from: b */
    public void mo9493b() {
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Skipping video from prompt");
        mo9497c();
    }

    /* renamed from: c */
    public void mo9497c() {
        this.f293N = SystemClock.elapsedRealtime() - this.f294O;
        C1314v vVar = this.f225c;
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Skipping video with skip time: ");
        outline24.append(this.f293N);
        outline24.append("ms");
        vVar.mo11372b("AppLovinFullscreenActivity", outline24.toString());
        this.f226d.mo10739f();
        this.f232j++;
        if (this.f223a.mo10632v()) {
            mo9466h();
        } else {
            mo9503y();
        }
    }

    /* renamed from: c */
    public void mo9498c(long j) {
        this.f282C = j;
    }

    /* renamed from: c */
    public void mo9499c(String str) {
        C1314v vVar = this.f225c;
        StringBuilder outline27 = GeneratedOutlineSupport.outline27("Encountered media error: ", str, " for ad: ");
        outline27.append(this.f223a);
        vVar.mo11376e("AppLovinFullscreenActivity", outline27.toString());
        if (this.f291L.compareAndSet(false, true)) {
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
        } else if (!this.f284E) {
            mo9463e();
        }
    }

    /* renamed from: d */
    public void mo9462d() {
        mo9451a((ViewGroup) null);
    }

    /* renamed from: d */
    public void mo9518d(boolean z) {
        if (C1263g.m2508d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f227e.getDrawable(z ? C1368R.C1369drawable.unmute_to_mute : C1368R.C1369drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f299x.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f299x.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri ay = z ? this.f223a.mo10618ay() : this.f223a.mo10619az();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f299x.setImageURI(ay);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* renamed from: e */
    public void mo9463e() {
        String str;
        C1314v vVar;
        this.f225c.mo11372b("AppLovinFullscreenActivity", "Pausing video");
        if (this.f296u.isPlaying()) {
            this.f290K = this.f296u.getCurrentPosition();
            this.f296u.setPlayWhenReady(false);
            this.f280A.mo9654c();
            vVar = this.f225c;
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Paused video at position ");
            outline24.append(this.f290K);
            outline24.append("ms");
            str = outline24.toString();
        } else {
            vVar = this.f225c;
            str = "Nothing to pause";
        }
        vVar.mo11372b("AppLovinFullscreenActivity", str);
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    /* renamed from: h */
    public void mo9466h() {
        this.f280A.mo9653b();
        this.f288I.removeCallbacksAndMessages((Object) null);
        mo9471m();
        super.mo9466h();
    }

    /* renamed from: j */
    public void mo9468j() {
        this.f296u.release();
        if (this.f289J) {
            AppLovinCommunicator.getInstance(this.f227e).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
        }
        super.mo9468j();
    }

    /* renamed from: m */
    public void mo9471m() {
        super.mo9448a(mo9517D(), this.f289J, mo9476r(), this.f293N);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j = messageData.getLong("ad_id");
            if (((Boolean) this.f224b.mo10946a(C1085b.f1770eS)).booleanValue() && j == this.f223a.getAdIdNumber() && this.f289J) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i < 200 || i >= 300) && !this.f285F && !this.f296u.isPlaying()) {
                    mo9499c("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
                }
            }
        }
    }

    /* renamed from: r */
    public boolean mo9476r() {
        return mo9517D() >= this.f223a.mo10566L();
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
                long j3 = this.f282C;
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
    public void mo9500v() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0653a aVar = C0692e.this.f297v;
                if (aVar != null) {
                    aVar.mo9422a();
                }
            }
        });
    }

    /* renamed from: w */
    public void mo9501w() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                C0653a aVar = C0692e.this.f297v;
                if (aVar != null) {
                    aVar.mo9423b();
                }
            }
        });
    }

    /* renamed from: x */
    public void mo9502x() {
        boolean z = !this.f281B;
        this.f281B = z;
        this.f296u.setVolume(z ^ true ? 1.0f : 0.0f);
        mo9518d(this.f281B);
        mo9457a(this.f281B, 0);
    }

    /* renamed from: y */
    public void mo9503y() {
        mo9515B();
        this.f286G.mo9441a(this.f229g, this.f228f);
        mo9455a("javascript:al_onPoststitialShow(" + this.f232j + "," + this.f233k + ");", (long) this.f223a.mo10568N());
        if (this.f229g != null) {
            int i = (this.f223a.mo10627q() > 0 ? 1 : (this.f223a.mo10627q() == 0 ? 0 : -1));
            C0767m mVar = this.f229g;
            if (i >= 0) {
                mo9452a(mVar, this.f223a.mo10627q(), new Runnable() {
                    public void run() {
                        C0692e.this.f231i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.f284E = true;
    }

    /* renamed from: z */
    public void mo9519z() {
        mo9456a(!this.f289J);
        Activity activity = this.f227e;
        this.f296u.setMediaSource(new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(activity, Util.getUserAgent(activity, "com.applovin.sdk"))).createMediaSource(MediaItem.fromUri(this.f223a.mo9317g())));
        this.f296u.prepare();
        this.f296u.setPlayWhenReady(false);
    }
}
