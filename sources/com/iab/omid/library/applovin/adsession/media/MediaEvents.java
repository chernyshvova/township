package com.iab.omid.library.applovin.adsession.media;

import com.facebook.login.LoginLogger;
import com.facebook.share.internal.VideoUploader;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.C2839a;
import com.iab.omid.library.applovin.p045b.C2848f;
import com.iab.omid.library.applovin.p047d.C2856b;
import com.iab.omid.library.applovin.p047d.C2860e;
import org.json.JSONObject;

public final class MediaEvents {
    public final C2839a adSession;

    public MediaEvents(C2839a aVar) {
        this.adSession = aVar;
    }

    private void confirmValidDuration(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void confirmValidVolume(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static MediaEvents createMediaEvents(AdSession adSession2) {
        C2839a aVar = (C2839a) adSession2;
        C2860e.m3379a((Object) adSession2, "AdSession is null");
        C2860e.m3387g(aVar);
        C2860e.m3378a(aVar);
        C2860e.m3382b(aVar);
        C2860e.m3385e(aVar);
        MediaEvents mediaEvents = new MediaEvents(aVar);
        aVar.getAdSessionStatePublisher().mo36769a(mediaEvents);
        return mediaEvents;
    }

    public void adUserInteraction(InteractionType interactionType) {
        C2860e.m3379a((Object) interactionType, "InteractionType is null");
        C2860e.m3383c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2856b.m3362a(jSONObject, "interactionType", interactionType);
        this.adSession.getAdSessionStatePublisher().mo36772a("adUserInteraction", jSONObject);
    }

    public void bufferFinish() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("bufferFinish");
    }

    public void bufferStart() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("bufferStart");
    }

    public void complete() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("complete");
    }

    public void firstQuartile() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("firstQuartile");
    }

    public void midpoint() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("midpoint");
    }

    public void pause() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("pause");
    }

    public void playerStateChange(PlayerState playerState) {
        C2860e.m3379a((Object) playerState, "PlayerState is null");
        C2860e.m3383c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2856b.m3362a(jSONObject, "state", playerState);
        this.adSession.getAdSessionStatePublisher().mo36772a("playerStateChange", jSONObject);
    }

    public void resume() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("resume");
    }

    public void skipped() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED);
    }

    public void start(float f, float f2) {
        confirmValidDuration(f);
        confirmValidVolume(f2);
        C2860e.m3383c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2856b.m3362a(jSONObject, "duration", Float.valueOf(f));
        C2856b.m3362a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
        C2856b.m3362a(jSONObject, "deviceVolume", Float.valueOf(C2848f.m3325a().mo36754d()));
        this.adSession.getAdSessionStatePublisher().mo36772a(VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE, jSONObject);
    }

    public void thirdQuartile() {
        C2860e.m3383c(this.adSession);
        this.adSession.getAdSessionStatePublisher().mo36770a("thirdQuartile");
    }

    public void volumeChange(float f) {
        confirmValidVolume(f);
        C2860e.m3383c(this.adSession);
        JSONObject jSONObject = new JSONObject();
        C2856b.m3362a(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        C2856b.m3362a(jSONObject, "deviceVolume", Float.valueOf(C2848f.m3325a().mo36754d()));
        this.adSession.getAdSessionStatePublisher().mo36772a("volumeChange", jSONObject);
    }
}
