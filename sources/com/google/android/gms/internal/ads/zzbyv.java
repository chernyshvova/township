package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbyv extends NativeAd {
    public final zzbof zza;
    public final List<NativeAd.Image> zzb = new ArrayList();
    @Nullable
    public final zzbyu zzc;
    @Nullable
    public final NativeAd.AdChoicesInfo zzd;
    public final List<MuteThisAdReason> zze = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0097 A[Catch:{ RemoteException -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbyv(com.google.android.gms.internal.ads.zzbof r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzb = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zze = r1
            r5.zza = r6
            r1 = 0
            java.util.List r6 = r6.zzf()     // Catch:{ RemoteException -> 0x0043 }
            if (r6 == 0) goto L_0x0047
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x0043 }
        L_0x0020:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x0043 }
            if (r2 == 0) goto L_0x0047
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x0043 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0043 }
            if (r3 == 0) goto L_0x0035
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.internal.ads.zzbmi r2 = com.google.android.gms.internal.ads.zzbmh.zzg(r2)     // Catch:{ RemoteException -> 0x0043 }
            goto L_0x0036
        L_0x0035:
            r2 = r1
        L_0x0036:
            if (r2 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.nativead.NativeAd$Image> r3 = r5.zzb     // Catch:{ RemoteException -> 0x0043 }
            com.google.android.gms.internal.ads.zzbyu r4 = new com.google.android.gms.internal.ads.zzbyu     // Catch:{ RemoteException -> 0x0043 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0043 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0043 }
            goto L_0x0020
        L_0x0043:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x0047:
            com.google.android.gms.internal.ads.zzbof r6 = r5.zza     // Catch:{ RemoteException -> 0x0076 }
            java.util.List r6 = r6.zzz()     // Catch:{ RemoteException -> 0x0076 }
            if (r6 == 0) goto L_0x007a
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x0076 }
        L_0x0053:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x0076 }
            if (r2 == 0) goto L_0x007a
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x0076 }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0076 }
            if (r3 == 0) goto L_0x0068
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x0076 }
            com.google.android.gms.internal.ads.zzbgq r2 = com.google.android.gms.internal.ads.zzbgp.zzb(r2)     // Catch:{ RemoteException -> 0x0076 }
            goto L_0x0069
        L_0x0068:
            r2 = r1
        L_0x0069:
            if (r2 == 0) goto L_0x0053
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zze     // Catch:{ RemoteException -> 0x0076 }
            com.google.android.gms.internal.ads.zzbgr r4 = new com.google.android.gms.internal.ads.zzbgr     // Catch:{ RemoteException -> 0x0076 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0076 }
            r3.add(r4)     // Catch:{ RemoteException -> 0x0076 }
            goto L_0x0053
        L_0x0076:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x007a:
            com.google.android.gms.internal.ads.zzbof r6 = r5.zza     // Catch:{ RemoteException -> 0x0088 }
            com.google.android.gms.internal.ads.zzbmi r6 = r6.zzh()     // Catch:{ RemoteException -> 0x0088 }
            if (r6 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzbyu r2 = new com.google.android.gms.internal.ads.zzbyu     // Catch:{ RemoteException -> 0x0088 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x0088 }
            goto L_0x008d
        L_0x0088:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x008c:
            r2 = r1
        L_0x008d:
            r5.zzc = r2
            com.google.android.gms.internal.ads.zzbof r6 = r5.zza     // Catch:{ RemoteException -> 0x00a4 }
            com.google.android.gms.internal.ads.zzbma r6 = r6.zzq()     // Catch:{ RemoteException -> 0x00a4 }
            if (r6 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzbys r6 = new com.google.android.gms.internal.ads.zzbys     // Catch:{ RemoteException -> 0x00a4 }
            com.google.android.gms.internal.ads.zzbof r2 = r5.zza     // Catch:{ RemoteException -> 0x00a4 }
            com.google.android.gms.internal.ads.zzbma r2 = r2.zzq()     // Catch:{ RemoteException -> 0x00a4 }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00a4 }
            r1 = r6
            goto L_0x00a8
        L_0x00a4:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x00a8:
            r5.zzd = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyv.<init>(com.google.android.gms.internal.ads.zzbof):void");
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzy();
        } catch (RemoteException e) {
            zzcgs.zzg("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final void destroy() {
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzD();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    @Nullable
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzd;
    }

    @Nullable
    public final String getAdvertiser() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    @Nullable
    public final String getBody() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    @Nullable
    public final String getCallToAction() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle zzw = this.zza.zzw();
            if (zzw != null) {
                return zzw;
            }
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
        return new Bundle();
    }

    @Nullable
    public final String getHeadline() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    @Nullable
    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    @Nullable
    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzF() != null) {
                return new zzbhz(this.zza.zzF());
            }
            return null;
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zze;
    }

    @Nullable
    public final String getPrice() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzbhd zzbhd;
        try {
            zzbhd = this.zza.zzH();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            zzbhd = null;
        }
        return ResponseInfo.zzb(zzbhd);
    }

    @Nullable
    public final Double getStarRating() {
        try {
            double zzk = this.zza.zzk();
            if (zzk == -1.0d) {
                return null;
            }
            return Double.valueOf(zzk);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    @Nullable
    public final String getStore() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zza.zzG();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zza.zzA();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (this.zza.zzA()) {
                if (muteThisAdReason == null) {
                    try {
                        this.zza.zzB((zzbgq) null);
                        return;
                    } catch (RemoteException e) {
                        zzcgs.zzg("", e);
                        return;
                    }
                } else if (muteThisAdReason instanceof zzbgr) {
                    this.zza.zzB(((zzbgr) muteThisAdReason).zza());
                    return;
                } else {
                    zzcgs.zzf("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                    return;
                }
            }
        } catch (RemoteException e2) {
            zzcgs.zzg("", e2);
        }
        zzcgs.zzf("Ad is not custom mute enabled");
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzr(bundle);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzE();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzs(bundle);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzt(bundle);
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zza.zzC(new zzbgn(muteThisAdListener));
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zza.zzI(new zzbio(onPaidEventListener));
        } catch (RemoteException e) {
            zzcgs.zzg("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzx(new zzbzc(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzcgs.zzg("Failed to setUnconfirmedClickListener", e);
        }
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zza() {
        try {
            return this.zza.zzu();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }
}
