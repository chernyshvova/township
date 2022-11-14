package com.google.android.gms.games.snapshot;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.drive.Contents;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public interface SnapshotContents extends Parcelable {
    @RecentlyNonNull
    ParcelFileDescriptor getParcelFileDescriptor();

    boolean isClosed();

    boolean modifyBytes(int i, @RecentlyNonNull byte[] bArr, int i2, int i3);

    @RecentlyNonNull
    byte[] readFully() throws IOException;

    boolean writeBytes(@RecentlyNonNull byte[] bArr);

    @RecentlyNonNull
    Contents zza();

    void zzb();
}
