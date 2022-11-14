package com.iab.omid.library.applovin.adsession;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.p047d.C2860e;
import com.iab.omid.library.applovin.publisher.AdSessionStatePublisher;

public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        C2860e.m3376a();
        C2860e.m3379a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
        C2860e.m3379a((Object) adSessionContext, "AdSessionContext is null");
        return new C2839a(adSessionConfiguration, adSessionContext);
    }

    public abstract void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str);

    public abstract void error(ErrorType errorType, String str);

    public abstract void finish();

    public abstract String getAdSessionId();

    public abstract AdSessionStatePublisher getAdSessionStatePublisher();

    public abstract void registerAdView(View view);

    public abstract void removeAllFriendlyObstructions();

    public abstract void removeFriendlyObstruction(View view);

    public abstract void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener);

    public abstract void start();
}
