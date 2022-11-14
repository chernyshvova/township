package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zas;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class ListenerHolder<L> {
    public final zaa zaa;
    @Nullable
    public volatile L zab;
    @Nullable
    public volatile ListenerKey<L> zac;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class ListenerKey<L> {
        public final L zaa;
        public final String zab;

        @KeepForSdk
        public ListenerKey(L l, String str) {
            this.zaa = l;
            this.zab = str;
        }

        @KeepForSdk
        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
        }

        @KeepForSdk
        public final int hashCode() {
            return this.zab.hashCode() + (System.identityHashCode(this.zaa) * 31);
        }
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(@RecentlyNonNull L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public final class zaa extends zas {
        public zaa(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            ListenerHolder.this.notifyListenerInternal((Notifier) message.obj);
        }
    }

    @KeepForSdk
    public ListenerHolder(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.zaa = new zaa(looper);
        this.zab = Preconditions.checkNotNull(l, "Listener must not be null");
        this.zac = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
    }

    @KeepForSdk
    public final void clear() {
        this.zab = null;
        this.zac = null;
    }

    @KeepForSdk
    @RecentlyNullable
    public final ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    @KeepForSdk
    public final boolean hasListener() {
        return this.zab != null;
    }

    @KeepForSdk
    public final void notifyListener(@RecentlyNonNull Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.sendMessage(this.zaa.obtainMessage(1, notifier));
    }

    @KeepForSdk
    public final void notifyListenerInternal(Notifier<? super L> notifier) {
        L l = this.zab;
        if (l == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(l);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }
}
