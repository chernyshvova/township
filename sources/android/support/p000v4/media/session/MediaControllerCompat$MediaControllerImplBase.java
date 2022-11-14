package android.support.p000v4.media.session;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;

/* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplBase */
public class MediaControllerCompat$MediaControllerImplBase implements MediaControllerCompat$MediaControllerImpl {
    public IMediaSession mBinder;

    public MediaControllerCompat$MediaControllerImplBase(MediaSessionCompat.Token token) {
        this.mBinder = IMediaSession.Stub.asInterface((IBinder) token.mInner);
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        try {
            this.mBinder.sendMediaButton(keyEvent);
            return false;
        } catch (RemoteException e) {
            Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
            return false;
        }
    }
}
