package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.zzat;
import com.google.android.gms.games.internal.zzh;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotContentsEntityCreator")
@SafeParcelable.Reserved({1000})
/* compiled from: com.google.android.gms:play-services-games-v2@@16.0.1-eap */
public final class SnapshotContentsEntity extends zzh implements SnapshotContents {
    @RecentlyNonNull
    public static final Parcelable.Creator<SnapshotContentsEntity> CREATOR = new zza();
    public static final Object zza = new Object();
    @SafeParcelable.Field(getter = "getContents", mo17147id = 1)
    public Contents zzb;

    @SafeParcelable.Constructor
    public SnapshotContentsEntity(@RecentlyNonNull @SafeParcelable.Param(mo17150id = 1) Contents contents) {
        this.zzb = contents;
    }

    private final boolean zzc(int i, byte[] bArr, int i2, int i3, boolean z) {
        Preconditions.checkState(!isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized (zza) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.zzb.getParcelFileDescriptor().getFileDescriptor());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position((long) i);
                bufferedOutputStream.write(bArr, i2, i3);
                if (z) {
                    channel.truncate((long) bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (IOException e) {
                zzat.zze("SnapshotContentsEntity", "Failed to write snapshot data", e);
                return false;
            }
        }
        return true;
    }

    @RecentlyNonNull
    public final ParcelFileDescriptor getParcelFileDescriptor() {
        Preconditions.checkState(!isClosed(), "Cannot mutate closed contents!");
        return this.zzb.getParcelFileDescriptor();
    }

    public final boolean isClosed() {
        return this.zzb == null;
    }

    public final boolean modifyBytes(int i, @RecentlyNonNull byte[] bArr, int i2, int i3) {
        return zzc(i, bArr, i2, bArr.length, false);
    }

    @RecentlyNonNull
    public final byte[] readFully() throws IOException {
        byte[] readInputStreamFully;
        Preconditions.checkState(!isClosed(), "Must provide a previously opened Snapshot");
        synchronized (zza) {
            FileInputStream fileInputStream = new FileInputStream(this.zzb.getParcelFileDescriptor().getFileDescriptor());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                readInputStreamFully = IOUtils.readInputStreamFully(bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (IOException e) {
                zzat.zzh("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return readInputStreamFully;
    }

    public final boolean writeBytes(@RecentlyNonNull byte[] bArr) {
        return zzc(0, bArr, 0, bArr.length, true);
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final Contents zza() {
        return this.zzb;
    }

    public final void zzb() {
        this.zzb = null;
    }
}
