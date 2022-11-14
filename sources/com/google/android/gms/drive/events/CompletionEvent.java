package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzev;
import com.google.android.gms.internal.drive.zzhs;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SafeParcelable.Class(creator = "CompletionEventCreator")
@SafeParcelable.Reserved({1})
public final class CompletionEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new zzg();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final GmsLogger zzbz = new GmsLogger("CompletionEvent", "");
    @SafeParcelable.Field(mo17147id = 8)
    public final int status;
    @SafeParcelable.Field(mo17147id = 3)
    @Nullable
    public final String zzca;
    @SafeParcelable.Field(mo17147id = 4)
    @Nullable
    public final ParcelFileDescriptor zzcb;
    @SafeParcelable.Field(mo17147id = 5)
    @Nullable
    public final ParcelFileDescriptor zzcc;
    @SafeParcelable.Field(mo17147id = 6)
    @Nullable
    public final MetadataBundle zzcd;
    @SafeParcelable.Field(mo17147id = 7)
    public final List<String> zzce;
    @SafeParcelable.Field(mo17147id = 9)
    public final IBinder zzcf;
    public boolean zzcg = false;
    public boolean zzch = false;
    public boolean zzci = false;
    @SafeParcelable.Field(mo17147id = 2)
    public final DriveId zzk;

    @SafeParcelable.Constructor
    public CompletionEvent(@SafeParcelable.Param(mo17150id = 2) DriveId driveId, @SafeParcelable.Param(mo17150id = 3) String str, @SafeParcelable.Param(mo17150id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(mo17150id = 5) ParcelFileDescriptor parcelFileDescriptor2, @SafeParcelable.Param(mo17150id = 6) MetadataBundle metadataBundle, @SafeParcelable.Param(mo17150id = 7) List<String> list, @SafeParcelable.Param(mo17150id = 8) int i, @SafeParcelable.Param(mo17150id = 9) IBinder iBinder) {
        this.zzk = driveId;
        this.zzca = str;
        this.zzcb = parcelFileDescriptor;
        this.zzcc = parcelFileDescriptor2;
        this.zzcd = metadataBundle;
        this.zzce = list;
        this.status = i;
        this.zzcf = iBinder;
    }

    private final void zza(boolean z) {
        zzv();
        this.zzci = true;
        IOUtils.closeQuietly(this.zzcb);
        IOUtils.closeQuietly(this.zzcc);
        MetadataBundle metadataBundle = this.zzcd;
        if (metadataBundle != null && metadataBundle.zzd(zzhs.zzkq)) {
            ((BitmapTeleporter) this.zzcd.zza(zzhs.zzkq)).release();
        }
        IBinder iBinder = this.zzcf;
        String str = "snooze";
        if (iBinder == null) {
            if (!z) {
                str = "dismiss";
            }
            zzbz.efmt("CompletionEvent", "No callback on %s", str);
            return;
        }
        try {
            zzev.zza(iBinder).zza(z);
        } catch (RemoteException e) {
            if (!z) {
                str = "dismiss";
            }
            zzbz.mo17108e("CompletionEvent", String.format("RemoteException on %s", new Object[]{str}), e);
        }
    }

    private final void zzv() {
        if (this.zzci) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    public final void dismiss() {
        zza(false);
    }

    @Nullable
    public final String getAccountName() {
        zzv();
        return this.zzca;
    }

    @Nullable
    public final InputStream getBaseContentsInputStream() {
        zzv();
        if (this.zzcb == null) {
            return null;
        }
        if (!this.zzcg) {
            this.zzcg = true;
            return new FileInputStream(this.zzcb.getFileDescriptor());
        }
        throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
    }

    public final DriveId getDriveId() {
        zzv();
        return this.zzk;
    }

    @Nullable
    public final InputStream getModifiedContentsInputStream() {
        zzv();
        if (this.zzcc == null) {
            return null;
        }
        if (!this.zzch) {
            this.zzch = true;
            return new FileInputStream(this.zzcc.getFileDescriptor());
        }
        throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
    }

    @Nullable
    public final MetadataChangeSet getModifiedMetadataChangeSet() {
        zzv();
        if (this.zzcd != null) {
            return new MetadataChangeSet(this.zzcd);
        }
        return null;
    }

    public final int getStatus() {
        zzv();
        return this.status;
    }

    public final List<String> getTrackingTags() {
        zzv();
        return new ArrayList(this.zzce);
    }

    public final int getType() {
        return 2;
    }

    public final void snooze() {
        zza(true);
    }

    public final String toString() {
        String str;
        List<String> list = this.zzce;
        if (list == null) {
            str = "<null>";
        } else {
            String join = TextUtils.join("','", list);
            str = GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(join, 2), "'", join, "'");
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.zzk, Integer.valueOf(this.status), str});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzca, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzcb, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcc, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcd, i2, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzce, false);
        SafeParcelWriter.writeInt(parcel, 8, this.status);
        SafeParcelWriter.writeIBinder(parcel, 9, this.zzcf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
