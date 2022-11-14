package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class RemoteCreator<T> {
    public final String zza;
    public T zzb;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class RemoteCreatorException extends Exception {
        @KeepForSdk
        public RemoteCreatorException(@RecentlyNonNull String str) {
            super(str);
        }

        @KeepForSdk
        public RemoteCreatorException(@RecentlyNonNull String str, @RecentlyNonNull Throwable th) {
            super(str, th);
        }
    }

    @KeepForSdk
    public RemoteCreator(@RecentlyNonNull String str) {
        this.zza = str;
    }

    @RecentlyNonNull
    @KeepForSdk
    public abstract T getRemoteCreator(@RecentlyNonNull IBinder iBinder);

    @RecentlyNonNull
    @KeepForSdk
    public final T getRemoteCreatorInstance(@RecentlyNonNull Context context) throws RemoteCreatorException {
        if (this.zzb == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    this.zzb = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zza).newInstance());
                } catch (ClassNotFoundException e) {
                    throw new RemoteCreatorException("Could not load creator class.", e);
                } catch (InstantiationException e2) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e2);
                } catch (IllegalAccessException e3) {
                    throw new RemoteCreatorException("Could not access creator.", e3);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.zzb;
    }
}
