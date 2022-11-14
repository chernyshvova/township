package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbog extends UnifiedNativeAd {
    public final zzbof zza;
    public final List<NativeAd.Image> zzb = new ArrayList();
    public final zzbmj zzc;
    public final VideoController zzd = new VideoController();
    public final NativeAd.AdChoicesInfo zze;
    public final List<MuteThisAdReason> zzf = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[Catch:{ RemoteException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af A[Catch:{ RemoteException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0027 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbog(com.google.android.gms.internal.ads.zzbof r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzb = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzd = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzf = r1
            r5.zza = r6
            r1 = 0
            java.util.List r6 = r6.zzf()     // Catch:{ RemoteException -> 0x005b }
            if (r6 == 0) goto L_0x005f
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x005b }
        L_0x0027:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x005b }
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x005b }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005b }
            if (r3 == 0) goto L_0x004d
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005b }
            if (r2 != 0) goto L_0x003a
            goto L_0x004d
        L_0x003a:
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005b }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzbmi     // Catch:{ RemoteException -> 0x005b }
            if (r4 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzbmi r3 = (com.google.android.gms.internal.ads.zzbmi) r3     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004e
        L_0x0047:
            com.google.android.gms.internal.ads.zzbmg r3 = new com.google.android.gms.internal.ads.zzbmg     // Catch:{ RemoteException -> 0x005b }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004e
        L_0x004d:
            r3 = r1
        L_0x004e:
            if (r3 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r5.zzb     // Catch:{ RemoteException -> 0x005b }
            com.google.android.gms.internal.ads.zzbmj r4 = new com.google.android.gms.internal.ads.zzbmj     // Catch:{ RemoteException -> 0x005b }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x005b }
            r2.add(r4)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x0027
        L_0x005b:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x005f:
            com.google.android.gms.internal.ads.zzbof r6 = r5.zza     // Catch:{ RemoteException -> 0x008e }
            java.util.List r6 = r6.zzz()     // Catch:{ RemoteException -> 0x008e }
            if (r6 == 0) goto L_0x0092
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x008e }
        L_0x006b:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x008e }
            if (r2 == 0) goto L_0x0092
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x008e }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x008e }
            if (r3 == 0) goto L_0x0080
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x008e }
            com.google.android.gms.internal.ads.zzbgq r2 = com.google.android.gms.internal.ads.zzbgp.zzb(r2)     // Catch:{ RemoteException -> 0x008e }
            goto L_0x0081
        L_0x0080:
            r2 = r1
        L_0x0081:
            if (r2 == 0) goto L_0x006b
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzf     // Catch:{ RemoteException -> 0x008e }
            com.google.android.gms.internal.ads.zzbgr r4 = new com.google.android.gms.internal.ads.zzbgr     // Catch:{ RemoteException -> 0x008e }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x008e }
            r3.add(r4)     // Catch:{ RemoteException -> 0x008e }
            goto L_0x006b
        L_0x008e:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x0092:
            com.google.android.gms.internal.ads.zzbof r6 = r5.zza     // Catch:{ RemoteException -> 0x00a0 }
            com.google.android.gms.internal.ads.zzbmi r6 = r6.zzh()     // Catch:{ RemoteException -> 0x00a0 }
            if (r6 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzbmj r2 = new com.google.android.gms.internal.ads.zzbmj     // Catch:{ RemoteException -> 0x00a0 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x00a0 }
            goto L_0x00a5
        L_0x00a0:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x00a4:
            r2 = r1
        L_0x00a5:
            r5.zzc = r2
            com.google.android.gms.internal.ads.zzbof r6 = r5.zza     // Catch:{ RemoteException -> 0x00bc }
            com.google.android.gms.internal.ads.zzbma r6 = r6.zzq()     // Catch:{ RemoteException -> 0x00bc }
            if (r6 == 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzbmb r6 = new com.google.android.gms.internal.ads.zzbmb     // Catch:{ RemoteException -> 0x00bc }
            com.google.android.gms.internal.ads.zzbof r2 = r5.zza     // Catch:{ RemoteException -> 0x00bc }
            com.google.android.gms.internal.ads.zzbma r2 = r2.zzq()     // Catch:{ RemoteException -> 0x00bc }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00bc }
            r1 = r6
            goto L_0x00c0
        L_0x00bc:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzcgs.zzg(r0, r6)
        L_0x00c0:
            r5.zze = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbog.<init>(com.google.android.gms.internal.ads.zzbof):void");
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

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zze;
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

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

    public final String getHeadline() {
        try {
            return this.zza.zze();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

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

    public final String getMediationAdapterClassName() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzf;
    }

    public final String getPrice() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

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

    public final String getStore() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzn() != null) {
                this.zzd.zza(this.zza.zzn());
            }
        } catch (RemoteException e) {
            zzcgs.zzg("Exception occurred while getting video controller", e);
        }
        return this.zzd;
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

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zza.zzI(new zzbio(onPaidEventListener));
        } catch (RemoteException e) {
            zzcgs.zzg("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzx(new zzboq(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzcgs.zzg("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final Object zza() {
        try {
            IObjectWrapper zzv = this.zza.zzv();
            if (zzv != null) {
                return ObjectWrapper.unwrap(zzv);
            }
            return null;
        } catch (RemoteException e) {
            zzcgs.zzg("", e);
            return null;
        }
    }
}
