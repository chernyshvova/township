package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbiu;
import com.google.android.gms.internal.ads.zzcgs;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    public final Object zza = new Object();
    @GuardedBy("lock")
    @Nullable
    public zzbhg zzb;
    @GuardedBy("lock")
    @Nullable
    public VideoLifecycleCallbacks zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @KeepForSdk
    public int getPlaybackState() {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg == null) {
                return 0;
            }
            try {
                int zzi = zzbhg.zzi();
                return zzi;
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    @RecentlyNullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzb != null;
        }
        return z;
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg == null) {
                return false;
            }
            try {
                boolean zzp = zzbhg.zzp();
                return zzp;
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg == null) {
                return false;
            }
            try {
                boolean zzn = zzbhg.zzn();
                return zzn;
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg == null) {
                return true;
            }
            try {
                boolean zzh = zzbhg.zzh();
                return zzh;
            } catch (RemoteException e) {
                zzcgs.zzg("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public void mute(boolean z) {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg != null) {
                try {
                    zzbhg.zzg(z);
                } catch (RemoteException e) {
                    zzcgs.zzg("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg != null) {
                try {
                    zzbhg.zzf();
                } catch (RemoteException e) {
                    zzcgs.zzg("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg != null) {
                try {
                    zzbhg.zze();
                } catch (RemoteException e) {
                    zzcgs.zzg("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public void setVideoLifecycleCallbacks(@RecentlyNonNull VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzbhg zzbhg = this.zzb;
            if (zzbhg != null) {
                try {
                    zzbhg.zzl(new zzbiu(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzcgs.zzg("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzbhg zzbhg = this.zzb;
            if (zzbhg != null) {
                try {
                    zzbhg.zzq();
                } catch (RemoteException e) {
                    zzcgs.zzg("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void zza(@Nullable zzbhg zzbhg) {
        synchronized (this.zza) {
            this.zzb = zzbhg;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    @Nullable
    public final zzbhg zzb() {
        zzbhg zzbhg;
        synchronized (this.zza) {
            zzbhg = this.zzb;
        }
        return zzbhg;
    }
}
