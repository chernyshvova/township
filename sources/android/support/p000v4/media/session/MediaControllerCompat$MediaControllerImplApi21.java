package android.support.p000v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaControllerCompat$Callback;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiresApi(21)
/* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21 */
public class MediaControllerCompat$MediaControllerImplApi21 implements MediaControllerCompat$MediaControllerImpl {
    public HashMap<MediaControllerCompat$Callback, ExtraCallback> mCallbackMap = new HashMap<>();
    public final MediaController mControllerFwk;
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public final List<MediaControllerCompat$Callback> mPendingCallbacks = new ArrayList();
    public final MediaSessionCompat.Token mSessionToken;

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver */
    public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
        public WeakReference<MediaControllerCompat$MediaControllerImplApi21> mMediaControllerImpl;

        public ExtraBinderRequestResultReceiver(MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21) {
            super((Handler) null);
            this.mMediaControllerImpl = new WeakReference<>(mediaControllerCompat$MediaControllerImplApi21);
        }

        public void onReceiveResult(int i, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = (MediaControllerCompat$MediaControllerImplApi21) this.mMediaControllerImpl.get();
            if (mediaControllerCompat$MediaControllerImplApi21 != null && bundle != null) {
                synchronized (mediaControllerCompat$MediaControllerImplApi21.mLock) {
                    MediaSessionCompat.Token token = mediaControllerCompat$MediaControllerImplApi21.mSessionToken;
                    IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    synchronized (token.mLock) {
                        token.mExtraBinder = asInterface;
                    }
                    MediaSessionCompat.Token token2 = mediaControllerCompat$MediaControllerImplApi21.mSessionToken;
                    ParcelUtils.getVersionedParcelable(bundle, "android.support.v4.media.session.SESSION_TOKEN2");
                    synchronized (token2.mLock) {
                    }
                    mediaControllerCompat$MediaControllerImplApi21.processPendingCallbacksLocked();
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraCallback */
    public static class ExtraCallback extends MediaControllerCompat$Callback.StubCompat {
        public ExtraCallback(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
            super(mediaControllerCompat$Callback);
        }

        public void onExtrasChanged(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }

        public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        public void onSessionDestroyed() throws RemoteException {
            throw new AssertionError();
        }

        public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }
    }

    public MediaControllerCompat$MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
        this.mSessionToken = token;
        this.mControllerFwk = new MediaController(context, (MediaSession.Token) this.mSessionToken.mInner);
        if (this.mSessionToken.getExtraBinder() == null) {
            this.mControllerFwk.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        return this.mControllerFwk.dispatchMediaButtonEvent(keyEvent);
    }

    @GuardedBy("mLock")
    public void processPendingCallbacksLocked() {
        if (this.mSessionToken.getExtraBinder() != null) {
            for (MediaControllerCompat$Callback next : this.mPendingCallbacks) {
                ExtraCallback extraCallback = new ExtraCallback(next);
                this.mCallbackMap.put(next, extraCallback);
                next.mIControllerCallback = extraCallback;
                try {
                    this.mSessionToken.getExtraBinder().registerCallbackListener(extraCallback);
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                }
            }
            this.mPendingCallbacks.clear();
        }
    }
}
