package android.support.p000v4.media.session;

import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.p000v4.media.MediaDescriptionCompat;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.session.IMediaControllerCallback;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p000v4.media.session.PlaybackStateCompat;
import androidx.annotation.RequiresApi;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback */
public abstract class MediaControllerCompat$Callback implements IBinder.DeathRecipient {
    public IMediaControllerCallback mIControllerCallback;

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$MediaControllerCallbackApi21 */
    public static class MediaControllerCallbackApi21 extends MediaController.Callback {
        public final WeakReference<MediaControllerCompat$Callback> mCallback;

        public MediaControllerCallbackApi21(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
            this.mCallback = new WeakReference<>(mediaControllerCompat$Callback);
        }

        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            if (((MediaControllerCompat$Callback) this.mCallback.get()) != null) {
                playbackInfo.getPlaybackType();
                AudioAttributesCompat.wrap(playbackInfo.getAudioAttributes());
                playbackInfo.getVolumeControl();
                playbackInfo.getMaxVolume();
                playbackInfo.getCurrentVolume();
            }
        }

        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            if (((MediaControllerCompat$Callback) this.mCallback.get()) != null) {
                MediaMetadataCompat.fromMediaMetadata(mediaMetadata);
            }
        }

        public void onPlaybackStateChanged(PlaybackState playbackState) {
            ArrayList arrayList;
            PlaybackStateCompat.CustomAction customAction;
            PlaybackState playbackState2 = playbackState;
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
            if (mediaControllerCompat$Callback != null && mediaControllerCompat$Callback.mIControllerCallback == null) {
                Bundle bundle = null;
                if (playbackState2 != null && Build.VERSION.SDK_INT >= 21) {
                    List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
                    if (customActions != null) {
                        ArrayList arrayList2 = new ArrayList(customActions.size());
                        for (PlaybackState.CustomAction next : customActions) {
                            if (next == null || Build.VERSION.SDK_INT < 21) {
                                customAction = null;
                            } else {
                                PlaybackState.CustomAction customAction2 = next;
                                Bundle extras = customAction2.getExtras();
                                MediaSessionCompat.ensureClassLoader(extras);
                                customAction = new PlaybackStateCompat.CustomAction(customAction2.getAction(), customAction2.getName(), customAction2.getIcon(), extras);
                                customAction.mCustomActionFwk = customAction2;
                            }
                            arrayList2.add(customAction);
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = null;
                    }
                    if (Build.VERSION.SDK_INT >= 22) {
                        bundle = playbackState.getExtras();
                        MediaSessionCompat.ensureClassLoader(bundle);
                    }
                    new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), 0, playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), bundle).mStateFwk = playbackState2;
                }
            }
        }

        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            MediaSessionCompat.QueueItem queueItem;
            if (((MediaControllerCompat$Callback) this.mCallback.get()) != null && list != null && Build.VERSION.SDK_INT >= 21) {
                ArrayList arrayList = new ArrayList();
                for (MediaSession.QueueItem next : list) {
                    if (next == null || Build.VERSION.SDK_INT < 21) {
                        queueItem = null;
                    } else {
                        MediaSession.QueueItem queueItem2 = next;
                        queueItem = new MediaSessionCompat.QueueItem(queueItem2, MediaDescriptionCompat.fromMediaDescription(queueItem2.getDescription()), queueItem2.getQueueId());
                    }
                    arrayList.add(queueItem);
                }
            }
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onSessionDestroyed() {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
            if (mediaControllerCompat$Callback != null && mediaControllerCompat$Callback.mIControllerCallback != null) {
                int i = Build.VERSION.SDK_INT;
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat */
    public static class StubCompat extends IMediaControllerCallback.Stub {
        public final WeakReference<MediaControllerCompat$Callback> mCallback;

        public StubCompat(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
            this.mCallback = new WeakReference<>(mediaControllerCompat$Callback);
        }

        public void onExtrasChanged(Bundle bundle) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onSessionDestroyed() throws RemoteException {
            MediaControllerCompat$Callback mediaControllerCompat$Callback = (MediaControllerCompat$Callback) this.mCallback.get();
        }

        public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            if (((MediaControllerCompat$Callback) this.mCallback.get()) != null && parcelableVolumeInfo != null) {
                int i = parcelableVolumeInfo.volumeType;
                int i2 = parcelableVolumeInfo.audioStream;
                int i3 = parcelableVolumeInfo.controlType;
                int i4 = parcelableVolumeInfo.maxVolume;
                int i5 = parcelableVolumeInfo.currentVolume;
                new AudioAttributesCompat.Builder().setLegacyStreamType(i2).build();
            }
        }
    }

    public MediaControllerCompat$Callback() {
        if (Build.VERSION.SDK_INT >= 21) {
            new MediaControllerCallbackApi21(this);
        } else {
            this.mIControllerCallback = new StubCompat(this);
        }
    }

    public void binderDied() {
    }
}
