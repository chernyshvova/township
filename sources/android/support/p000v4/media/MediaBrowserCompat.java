package android.support.p000v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.p000v4.media.session.IMediaSession;
import android.support.p000v4.media.session.MediaSessionCompat;
import android.support.p000v4.p001os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {
    public static final boolean DEBUG = Log.isLoggable("MediaBrowserCompat", 3);
    public final MediaBrowserImpl mImpl;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CallbackHandler */
    public static class CallbackHandler extends Handler {
        public final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        public WeakReference<Messenger> mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference != null && weakReference.get() != null && this.mCallbackImplRef.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = (MediaBrowserServiceCallbackImpl) this.mCallbackImplRef.get();
                Messenger messenger = (Messenger) this.mCallbacksMessengerRef.get();
                try {
                    int i = message.what;
                    if (i == 1) {
                        Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.ensureClassLoader(bundle);
                        mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                    } else if (i == 2) {
                        mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                    } else if (i != 3) {
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                    }
                }
            }
        }

        public void setCallbacksMessenger(Messenger messenger) {
            this.mCallbacksMessengerRef = new WeakReference<>(messenger);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback */
    public static class ConnectionCallback {
        public final MediaBrowser.ConnectionCallback mConnectionCallbackFwk;
        public ConnectionCallbackInternal mConnectionCallbackInternal;

        @RequiresApi(21)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackApi21 */
        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    MediaBrowserImplApi21 mediaBrowserImplApi21 = (MediaBrowserImplApi21) connectionCallbackInternal;
                    if (mediaBrowserImplApi21 != null) {
                        try {
                            Bundle extras = mediaBrowserImplApi21.mBrowserFwk.getExtras();
                            if (extras != null) {
                                extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                                if (binder != null) {
                                    mediaBrowserImplApi21.mServiceBinderWrapper = new ServiceBinderWrapper(binder, mediaBrowserImplApi21.mRootHints);
                                    Messenger messenger = new Messenger(mediaBrowserImplApi21.mHandler);
                                    mediaBrowserImplApi21.mCallbacksMessenger = messenger;
                                    mediaBrowserImplApi21.mHandler.setCallbacksMessenger(messenger);
                                    try {
                                        ServiceBinderWrapper serviceBinderWrapper = mediaBrowserImplApi21.mServiceBinderWrapper;
                                        Context context = mediaBrowserImplApi21.mContext;
                                        Messenger messenger2 = mediaBrowserImplApi21.mCallbacksMessenger;
                                        if (serviceBinderWrapper != null) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                                            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
                                            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, serviceBinderWrapper.mRootHints);
                                            serviceBinderWrapper.sendRequest(6, bundle, messenger2);
                                        } else {
                                            throw null;
                                        }
                                    } catch (RemoteException unused) {
                                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                                    }
                                }
                                IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                                if (asInterface != null) {
                                    mediaBrowserImplApi21.mMediaSessionToken = MediaSessionCompat.Token.fromToken(mediaBrowserImplApi21.mBrowserFwk.getSessionToken(), asInterface);
                                }
                            }
                        } catch (IllegalStateException e) {
                            Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
                        }
                    } else {
                        throw null;
                    }
                }
                ConnectionCallback.this.onConnected();
            }

            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal == null || ((MediaBrowserImplApi21) connectionCallbackInternal) != null) {
                    ConnectionCallback.this.onConnectionFailed();
                    return;
                }
                throw null;
            }

            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    MediaBrowserImplApi21 mediaBrowserImplApi21 = (MediaBrowserImplApi21) connectionCallbackInternal;
                    mediaBrowserImplApi21.mServiceBinderWrapper = null;
                    mediaBrowserImplApi21.mCallbacksMessenger = null;
                    mediaBrowserImplApi21.mMediaSessionToken = null;
                    mediaBrowserImplApi21.mHandler.setCallbacksMessenger((Messenger) null);
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal */
        public interface ConnectionCallbackInternal {
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mConnectionCallbackFwk = new ConnectionCallbackApi21();
            } else {
                this.mConnectionCallbackFwk = null;
            }
        }

        public void onConnected() {
            throw null;
        }

        public void onConnectionFailed() {
            throw null;
        }

        public void onConnectionSuspended() {
            throw null;
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$CustomActionResultReceiver */
    public static class CustomActionResultReceiver extends ResultReceiver {
        public void onReceiveResult(int i, Bundle bundle) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemReceiver */
    public static class ItemReceiver extends ResultReceiver {
        public void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                MediaItem mediaItem = (MediaItem) parcelable;
                throw null;
            }
            throw null;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl */
    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @NonNull
        MediaSessionCompat.Token getSessionToken();
    }

    @RequiresApi(21)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21 */
    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        public final MediaBrowser mBrowserFwk;
        public Messenger mCallbacksMessenger;
        public final Context mContext;
        public final CallbackHandler mHandler = new CallbackHandler(this);
        public MediaSessionCompat.Token mMediaSessionToken;
        public Bundle mNotifyChildrenChangedOptions;
        public final Bundle mRootHints;
        public ServiceBinderWrapper mServiceBinderWrapper;
        public final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            this.mContext = context;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            this.mRootHints = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            this.mRootHints.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new MediaBrowser(context, componentName, connectionCallback.mConnectionCallbackFwk, this.mRootHints);
        }

        public void connect() {
            this.mBrowserFwk.connect();
        }

        public void disconnect() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (!(serviceBinderWrapper == null || (messenger = this.mCallbacksMessenger) == null)) {
                try {
                    serviceBinderWrapper.sendRequest(7, (Bundle) null, messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.mBrowserFwk.disconnect();
        }

        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), (IMediaSession) null);
            }
            return this.mMediaSessionToken;
        }

        public void onConnectionFailed(Messenger messenger) {
        }

        public void onLoadChildren(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.mCallbacksMessenger == messenger) {
                Subscription subscription = this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    }
                } else if (subscription.getCallback(bundle) == null) {
                } else {
                    if (bundle == null) {
                        if (list != null) {
                            this.mNotifyChildrenChangedOptions = bundle2;
                        }
                    } else if (list != null) {
                        this.mNotifyChildrenChangedOptions = bundle2;
                    }
                }
            }
        }

        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }
    }

    @RequiresApi(23)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23 */
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    @RequiresApi(26)
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi26 */
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase */
    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        public final ConnectionCallback mCallback;
        public Messenger mCallbacksMessenger;
        public final Context mContext;
        public Bundle mExtras;
        public final CallbackHandler mHandler = new CallbackHandler(this);
        public MediaSessionCompat.Token mMediaSessionToken;
        public Bundle mNotifyChildrenChangedOptions;
        public final Bundle mRootHints;
        public String mRootId;
        public ServiceBinderWrapper mServiceBinderWrapper;
        public final ComponentName mServiceComponent;
        public MediaServiceConnection mServiceConnection;
        public int mState = 1;
        public final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection */
        public class MediaServiceConnection implements ServiceConnection {
            public MediaServiceConnection() {
            }

            public boolean isCurrent(String str) {
                int i;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mServiceConnection == this && (i = mediaBrowserImplBase.mState) != 0 && i != 1) {
                    return true;
                }
                int i2 = MediaBrowserImplBase.this.mState;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, " for ");
                outline26.append(MediaBrowserImplBase.this.mServiceComponent);
                outline26.append(" with mServiceConnection=");
                outline26.append(MediaBrowserImplBase.this.mServiceConnection);
                outline26.append(" this=");
                outline26.append(this);
                Log.i("MediaBrowserCompat", outline26.toString());
                return false;
            }

            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                postOrRun(new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaServiceConnection.onServiceConnected name=");
                            outline24.append(componentName);
                            outline24.append(" binder=");
                            outline24.append(iBinder);
                            Log.d("MediaBrowserCompat", outline24.toString());
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mServiceBinderWrapper = new ServiceBinderWrapper(iBinder, mediaBrowserImplBase.mRootHints);
                            MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                            MediaBrowserImplBase.this.mState = 2;
                            try {
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.dump();
                                }
                                ServiceBinderWrapper serviceBinderWrapper = MediaBrowserImplBase.this.mServiceBinderWrapper;
                                Context context = MediaBrowserImplBase.this.mContext;
                                Messenger messenger = MediaBrowserImplBase.this.mCallbacksMessenger;
                                if (serviceBinderWrapper != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                                    bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
                                    bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, serviceBinderWrapper.mRootHints);
                                    serviceBinderWrapper.sendRequest(1, bundle, messenger);
                                    return;
                                }
                                throw null;
                            } catch (RemoteException unused) {
                                StringBuilder outline242 = GeneratedOutlineSupport.outline24("RemoteException during connect for ");
                                outline242.append(MediaBrowserImplBase.this.mServiceComponent);
                                Log.w("MediaBrowserCompat", outline242.toString());
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.dump();
                                }
                            }
                        }
                    }
                });
            }

            public void onServiceDisconnected(final ComponentName componentName) {
                postOrRun(new Runnable() {
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("MediaServiceConnection.onServiceDisconnected name=");
                            outline24.append(componentName);
                            outline24.append(" this=");
                            outline24.append(this);
                            outline24.append(" mServiceConnection=");
                            outline24.append(MediaBrowserImplBase.this.mServiceConnection);
                            Log.d("MediaBrowserCompat", outline24.toString());
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mServiceBinderWrapper = null;
                            mediaBrowserImplBase.mCallbacksMessenger = null;
                            mediaBrowserImplBase.mHandler.setCallbacksMessenger((Messenger) null);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.mState = 4;
                            mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }

            public final void postOrRun(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (connectionCallback != null) {
                this.mContext = context;
                this.mServiceComponent = componentName;
                this.mCallback = connectionCallback;
                if (bundle == null) {
                    bundle2 = null;
                } else {
                    bundle2 = new Bundle(bundle);
                }
                this.mRootHints = bundle2;
            } else {
                throw new IllegalArgumentException("connection callback must not be null");
            }
        }

        public static String getStateLabel(int i) {
            if (i == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i != 3) {
                return i != 4 ? GeneratedOutlineSupport.outline14("UNKNOWN/", i) : "CONNECT_STATE_SUSPENDED";
            }
            return "CONNECT_STATE_CONNECTED";
        }

        public void connect() {
            int i = this.mState;
            if (i == 0 || i == 1) {
                this.mState = 2;
                this.mHandler.post(new Runnable() {
                    public void run() {
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        if (mediaBrowserImplBase.mState != 0) {
                            mediaBrowserImplBase.mState = 2;
                            if (!MediaBrowserCompat.DEBUG || mediaBrowserImplBase.mServiceConnection == null) {
                                MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                                if (mediaBrowserImplBase2.mServiceBinderWrapper != null) {
                                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("mServiceBinderWrapper should be null. Instead it is ");
                                    outline24.append(MediaBrowserImplBase.this.mServiceBinderWrapper);
                                    throw new RuntimeException(outline24.toString());
                                } else if (mediaBrowserImplBase2.mCallbacksMessenger == null) {
                                    Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                                    intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                                    MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                                    mediaBrowserImplBase3.mServiceConnection = new MediaServiceConnection();
                                    boolean z = false;
                                    try {
                                        z = MediaBrowserImplBase.this.mContext.bindService(intent, MediaBrowserImplBase.this.mServiceConnection, 1);
                                    } catch (Exception unused) {
                                        StringBuilder outline242 = GeneratedOutlineSupport.outline24("Failed binding to service ");
                                        outline242.append(MediaBrowserImplBase.this.mServiceComponent);
                                        Log.e("MediaBrowserCompat", outline242.toString());
                                    }
                                    if (!z) {
                                        MediaBrowserImplBase.this.forceCloseConnection();
                                        MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                                    }
                                    if (MediaBrowserCompat.DEBUG) {
                                        Log.d("MediaBrowserCompat", "connect...");
                                        MediaBrowserImplBase.this.dump();
                                    }
                                } else {
                                    StringBuilder outline243 = GeneratedOutlineSupport.outline24("mCallbacksMessenger should be null. Instead it is ");
                                    outline243.append(MediaBrowserImplBase.this.mCallbacksMessenger);
                                    throw new RuntimeException(outline243.toString());
                                }
                            } else {
                                StringBuilder outline244 = GeneratedOutlineSupport.outline24("mServiceConnection should be null. Instead it is ");
                                outline244.append(MediaBrowserImplBase.this.mServiceConnection);
                                throw new RuntimeException(outline244.toString());
                            }
                        }
                    }
                });
                return;
            }
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("connect() called while neigther disconnecting nor disconnected (state=");
            outline24.append(getStateLabel(this.mState));
            outline24.append(")");
            throw new IllegalStateException(outline24.toString());
        }

        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new Runnable() {
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                    if (messenger != null) {
                        try {
                            mediaBrowserImplBase.mServiceBinderWrapper.sendRequest(2, (Bundle) null, messenger);
                        } catch (RemoteException unused) {
                            StringBuilder outline24 = GeneratedOutlineSupport.outline24("RemoteException during connect for ");
                            outline24.append(MediaBrowserImplBase.this.mServiceComponent);
                            Log.w("MediaBrowserCompat", outline24.toString());
                        }
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    int i = mediaBrowserImplBase2.mState;
                    mediaBrowserImplBase2.forceCloseConnection();
                    if (i != 0) {
                        MediaBrowserImplBase.this.mState = i;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        public void dump() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
            Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger((Messenger) null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mState == 3) {
                return this.mMediaSessionToken;
            }
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("getSessionToken() called while not connected(state=");
            outline24.append(this.mState);
            outline24.append(")");
            throw new IllegalStateException(outline24.toString());
        }

        public final boolean isCurrent(Messenger messenger, String str) {
            int i;
            if (this.mCallbacksMessenger == messenger && (i = this.mState) != 0 && i != 1) {
                return true;
            }
            int i2 = this.mState;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, " for ");
            outline26.append(this.mServiceComponent);
            outline26.append(" with mCallbacksMessenger=");
            outline26.append(this.mCallbacksMessenger);
            outline26.append(" this=");
            outline26.append(this);
            Log.i("MediaBrowserCompat", outline26.toString());
            return false;
        }

        public void onConnectionFailed(Messenger messenger) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("onConnectFailed for ");
            outline24.append(this.mServiceComponent);
            Log.e("MediaBrowserCompat", outline24.toString());
            if (isCurrent(messenger, "onConnectFailed")) {
                if (this.mState != 2) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24("onConnect from service while mState=");
                    outline242.append(getStateLabel(this.mState));
                    outline242.append("... ignoring");
                    Log.w("MediaBrowserCompat", outline242.toString());
                    return;
                }
                forceCloseConnection();
                this.mCallback.onConnectionFailed();
            }
        }

        public void onLoadChildren(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (isCurrent(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.DEBUG) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("onLoadChildren for ");
                    outline24.append(this.mServiceComponent);
                    outline24.append(" id=");
                    outline24.append(str);
                    Log.d("MediaBrowserCompat", outline24.toString());
                }
                Subscription subscription = this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    }
                } else if (subscription.getCallback(bundle) == null) {
                } else {
                    if (bundle == null) {
                        if (list != null) {
                            this.mNotifyChildrenChangedOptions = bundle2;
                        }
                    } else if (list != null) {
                        this.mNotifyChildrenChangedOptions = bundle2;
                    }
                }
            }
        }

        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (isCurrent(messenger, "onConnect")) {
                if (this.mState != 2) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("onConnect from service while mState=");
                    outline24.append(getStateLabel(this.mState));
                    outline24.append("... ignoring");
                    Log.w("MediaBrowserCompat", outline24.toString());
                    return;
                }
                this.mRootId = str;
                this.mMediaSessionToken = token;
                this.mExtras = bundle;
                this.mState = 3;
                if (MediaBrowserCompat.DEBUG) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    for (Map.Entry next : this.mSubscriptions.entrySet()) {
                        String str2 = (String) next.getKey();
                        Subscription subscription = (Subscription) next.getValue();
                        List<SubscriptionCallback> list = subscription.mCallbacks;
                        List<Bundle> list2 = subscription.mOptionsList;
                        int i = 0;
                        while (true) {
                            if (i < list.size()) {
                                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                                IBinder iBinder = list.get(i).mToken;
                                Bundle bundle2 = list2.get(i);
                                Messenger messenger2 = this.mCallbacksMessenger;
                                if (serviceBinderWrapper != null) {
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str2);
                                    BundleCompat.putBinder(bundle3, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
                                    bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle2);
                                    serviceBinderWrapper.sendRequest(3, bundle3, messenger2);
                                    i++;
                                } else {
                                    throw null;
                                }
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserServiceCallbackImpl */
    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SearchResultReceiver */
    public static class SearchResultReceiver extends ResultReceiver {
        public void onReceiveResult(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
            }
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
                throw null;
            }
            throw null;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper */
    public static class ServiceBinderWrapper {
        public Messenger mMessenger;
        public Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.mMessenger = new Messenger(iBinder);
            this.mRootHints = bundle;
        }

        public final void sendRequest(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$Subscription */
    public static class Subscription {
        public final List<SubscriptionCallback> mCallbacks = new ArrayList();
        public final List<Bundle> mOptionsList = new ArrayList();

        public SubscriptionCallback getCallback(Bundle bundle) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), bundle)) {
                    return this.mCallbacks.get(i);
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback */
    public static abstract class SubscriptionCallback {
        public WeakReference<Subscription> mSubscriptionRef;
        public final IBinder mToken = new Binder();

        @RequiresApi(21)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi21 */
        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                WeakReference<Subscription> weakReference = SubscriptionCallback.this.mSubscriptionRef;
                Subscription subscription = weakReference == null ? null : (Subscription) weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback subscriptionCallback = SubscriptionCallback.this;
                    MediaItem.fromMediaItemList(list);
                    if (subscriptionCallback == null) {
                        throw null;
                    }
                    return;
                }
                List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                List<SubscriptionCallback> list2 = subscription.mCallbacks;
                List<Bundle> list3 = subscription.mOptionsList;
                for (int i = 0; i < list2.size(); i++) {
                    Bundle bundle = list3.get(i);
                    if (bundle != null) {
                        SubscriptionCallback subscriptionCallback2 = SubscriptionCallback.this;
                        if (fromMediaItemList != null) {
                            int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                            int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                            if (!(i2 == -1 && i3 == -1)) {
                                int i4 = i3 * i2;
                                int i5 = i4 + i3;
                                if (i2 < 0 || i3 < 1 || i4 >= fromMediaItemList.size()) {
                                    Collections.emptyList();
                                } else {
                                    if (i5 > fromMediaItemList.size()) {
                                        i5 = fromMediaItemList.size();
                                    }
                                    fromMediaItemList.subList(i4, i5);
                                }
                            }
                        }
                        if (subscriptionCallback2 == null) {
                            throw null;
                        }
                    } else if (SubscriptionCallback.this == null) {
                        throw null;
                    }
                }
            }

            public void onError(@NonNull String str) {
                if (SubscriptionCallback.this == null) {
                    throw null;
                }
            }
        }

        @RequiresApi(26)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi26 */
        public class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            public SubscriptionCallbackApi26() {
                super();
            }

            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                SubscriptionCallback subscriptionCallback = SubscriptionCallback.this;
                MediaItem.fromMediaItemList(list);
                if (subscriptionCallback == null) {
                    throw null;
                }
            }

            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.ensureClassLoader(bundle);
                if (SubscriptionCallback.this == null) {
                    throw null;
                }
            }
        }

        public SubscriptionCallback() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                new SubscriptionCallbackApi26();
            } else if (i >= 21) {
                new SubscriptionCallbackApi21();
            }
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.mImpl = new MediaBrowserImplApi26(context, componentName, connectionCallback, (Bundle) null);
        } else if (i >= 23) {
            this.mImpl = new MediaBrowserImplApi23(context, componentName, connectionCallback, (Bundle) null);
        } else if (i >= 21) {
            this.mImpl = new MediaBrowserImplApi21(context, componentName, connectionCallback, (Bundle) null);
        } else {
            this.mImpl = new MediaBrowserImplBase(context, componentName, connectionCallback, (Bundle) null);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            public Object createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            public Object[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        public final MediaDescriptionCompat mDescription;
        public final int mFlags;

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (!TextUtils.isEmpty(mediaDescriptionCompat.mMediaId)) {
                this.mFlags = i;
                this.mDescription = mediaDescriptionCompat;
            } else {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            MediaItem mediaItem;
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object next : list) {
                if (next == null || Build.VERSION.SDK_INT < 21) {
                    mediaItem = null;
                } else {
                    MediaBrowser.MediaItem mediaItem2 = (MediaBrowser.MediaItem) next;
                    mediaItem = new MediaItem(MediaDescriptionCompat.fromMediaDescription(mediaItem2.getDescription()), mediaItem2.getFlags());
                }
                arrayList.add(mediaItem);
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{" + "mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }

        public MediaItem(Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
