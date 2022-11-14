package com.applovin.impl.mediation.debugger.p017ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.C1008a;
import com.applovin.impl.sdk.utils.C1256a;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.C1368R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a */
public class C0890a extends Activity implements AppLovinCommunicatorSubscriber {
    public List<String> communicatorTopics = new ArrayList();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a$a */
    public interface C0892a<T extends Activity> {
        /* renamed from: a */
        void mo10108a(T t);
    }

    public String getCommunicatorId() {
        return getClass().getSimpleName();
    }

    public void onCreate(Bundle bundle) {
        if (!Utils.isPubInDebugMode(this)) {
            setTheme(C1368R.style.com_applovin_mediation_MaxDebuggerActivity_Theme_Live);
        }
        super.onCreate(bundle);
        List<String> list = this.communicatorTopics;
        if (list != null && list.size() > 0) {
            AppLovinCommunicator.getInstance(this).subscribe((AppLovinCommunicatorSubscriber) this, this.communicatorTopics);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        List<String> list = this.communicatorTopics;
        if (list != null && list.size() > 0) {
            AppLovinCommunicator.getInstance(this).unsubscribe((AppLovinCommunicatorSubscriber) this, this.communicatorTopics);
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
    }

    public void startActivity(final Class cls, final C1008a aVar, final C0892a aVar2) {
        aVar.mo10435a(new C1256a() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (cls.isInstance(activity)) {
                    aVar2.mo10108a(activity);
                    aVar.mo10437b(this);
                }
            }
        });
        startActivity(new Intent(this, cls));
    }
}
