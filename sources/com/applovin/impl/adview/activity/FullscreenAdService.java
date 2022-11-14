package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0769o;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p025ad.C1057e;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;

public class FullscreenAdService extends Service {
    public static final String DATA_KEY_AD_SOURCE = "ad_source";
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    public static final String TAG = "FullscreenAdService";

    /* renamed from: com.applovin.impl.adview.activity.FullscreenAdService$a */
    public static class C0655a extends Handler {
        public C0655a() {
        }

        public void handleMessage(@NonNull Message message) {
            try {
                C0769o oVar = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (oVar != null) {
                    C1057e a = oVar.mo9675a();
                    if (message.what == C0656b.AD.mo9427a()) {
                        Bundle bundle = new Bundle();
                        bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, a.getRawFullResponse());
                        bundle.putInt("ad_source", a.getSource().mo10539a());
                        Message obtain = Message.obtain((Handler) null, C0656b.AD.mo9427a());
                        obtain.setData(bundle);
                        message.replyTo.send(obtain);
                    } else if (message.what == C0656b.AD_DISPLAYED.mo9427a()) {
                        C1267j.m2560a(oVar.mo9678c(), (AppLovinAd) a);
                    } else if (message.what == C0656b.AD_CLICKED.mo9427a()) {
                        C1267j.m2559a(oVar.mo9679d(), (AppLovinAd) a);
                    } else if (message.what == C0656b.AD_VIDEO_STARTED.mo9427a()) {
                        C1267j.m2564a(oVar.mo9677b(), (AppLovinAd) a);
                    } else if (message.what == C0656b.AD_VIDEO_ENDED.mo9427a()) {
                        Bundle data = message.getData();
                        C1267j.m2565a(oVar.mo9677b(), (AppLovinAd) a, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                    } else if (message.what == C0656b.AD_HIDDEN.mo9427a()) {
                        C1267j.m2572b(oVar.mo9678c(), (AppLovinAd) a);
                    } else {
                        super.handleMessage(message);
                    }
                } else if (!Utils.getBooleanForProbability(1)) {
                    super.handleMessage(message);
                } else {
                    throw new RuntimeException("parentWrapper is null for " + message.what);
                }
            } catch (RemoteException e) {
                C1314v.m2659c(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.FullscreenAdService$b */
    public enum C0656b {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);
        

        /* renamed from: g */
        public final int f192g;

        /* access modifiers changed from: public */
        C0656b(int i) {
            this.f192g = i;
        }

        /* renamed from: a */
        public int mo9427a() {
            return this.f192g;
        }
    }

    public IBinder onBind(Intent intent) {
        return new Messenger(new C0655a()).getBinder();
    }
}
