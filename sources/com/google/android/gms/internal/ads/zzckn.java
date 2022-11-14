package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzckn implements zzbps<zzciz> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzciz zzciz = (zzciz) obj;
        zzcnn zzh = zzciz.zzh();
        if (zzh == null) {
            try {
                zzcnn zzcnn = new zzcnn(zzciz, Float.parseFloat((String) map.get("duration")), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("customControlsAllowed")), AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("clickToExpandAllowed")));
                zzciz.zzx(zzcnn);
                zzh = zzcnn;
            } catch (NullPointerException e) {
                e = e;
                zzcgs.zzg("Unable to parse videoMeta message.", e);
                zzs.zzg().zzg(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                zzcgs.zzg("Unable to parse videoMeta message.", e);
                zzs.zzg().zzg(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        int i = 0;
        if (parseInt >= 0) {
            if (parseInt <= 3) {
                i = parseInt;
            }
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zzcgs.zzm(3)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
            sb.append("Video Meta GMSG: currentTime : ");
            sb.append(parseFloat2);
            sb.append(" , duration : ");
            sb.append(parseFloat);
            sb.append(" , isMuted : ");
            sb.append(equals);
            sb.append(" , playbackState : ");
            sb.append(i);
            sb.append(" , aspectRatio : ");
            sb.append(str);
            zzcgs.zzd(sb.toString());
        }
        zzh.zzs(parseFloat2, parseFloat, i, equals, parseFloat3);
    }
}
