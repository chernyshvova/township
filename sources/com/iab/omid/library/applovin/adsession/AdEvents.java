package com.iab.omid.library.applovin.adsession;

import androidx.annotation.NonNull;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import com.iab.omid.library.applovin.p047d.C2860e;

public final class AdEvents {
    public final C2839a adSession;

    public AdEvents(C2839a aVar) {
        this.adSession = aVar;
    }

    public static AdEvents createAdEvents(AdSession adSession2) {
        C2839a aVar = (C2839a) adSession2;
        C2860e.m3379a((Object) adSession2, "AdSession is null");
        C2860e.m3384d(aVar);
        C2860e.m3382b(aVar);
        AdEvents adEvents = new AdEvents(aVar);
        aVar.getAdSessionStatePublisher().mo36764a(adEvents);
        return adEvents;
    }

    public void impressionOccurred() {
        C2860e.m3382b(this.adSession);
        C2860e.m3386f(this.adSession);
        if (!this.adSession.mo36679f()) {
            try {
                this.adSession.start();
            } catch (Exception unused) {
            }
        }
        if (this.adSession.mo36679f()) {
            this.adSession.mo36676c();
        }
    }

    public void loaded() {
        C2860e.m3383c(this.adSession);
        C2860e.m3386f(this.adSession);
        this.adSession.mo36677d();
    }

    public void loaded(@NonNull VastProperties vastProperties) {
        C2860e.m3379a((Object) vastProperties, "VastProperties is null");
        C2860e.m3383c(this.adSession);
        C2860e.m3386f(this.adSession);
        this.adSession.mo36674a(vastProperties.mo36700a());
    }
}
