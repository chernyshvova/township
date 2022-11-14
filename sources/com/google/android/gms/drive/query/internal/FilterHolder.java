package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

@SafeParcelable.Class(creator = "FilterHolderCreator")
@SafeParcelable.Reserved({1000})
public class FilterHolder extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new zzh();
    public final Filter zzbc;
    @SafeParcelable.Field(mo17147id = 1)
    public final zzb<?> zzmd;
    @SafeParcelable.Field(mo17147id = 2)
    public final zzd zzme;
    @SafeParcelable.Field(mo17147id = 3)
    public final zzr zzmf;
    @SafeParcelable.Field(mo17147id = 4)
    public final zzv zzmg;
    @SafeParcelable.Field(mo17147id = 5)
    public final zzp<?> zzmh;
    @SafeParcelable.Field(mo17147id = 6)
    public final zzt zzmi;
    @SafeParcelable.Field(mo17147id = 7)
    public final zzn zzmj;
    @SafeParcelable.Field(mo17147id = 8)
    public final zzl zzmk;
    @SafeParcelable.Field(mo17147id = 9)
    public final zzz zzml;

    @SafeParcelable.Constructor
    public FilterHolder(@SafeParcelable.Param(mo17150id = 1) zzb<?> zzb, @SafeParcelable.Param(mo17150id = 2) zzd zzd, @SafeParcelable.Param(mo17150id = 3) zzr zzr, @SafeParcelable.Param(mo17150id = 4) zzv zzv, @SafeParcelable.Param(mo17150id = 5) zzp<?> zzp, @SafeParcelable.Param(mo17150id = 6) zzt zzt, @SafeParcelable.Param(mo17150id = 7) zzn<?> zzn, @SafeParcelable.Param(mo17150id = 8) zzl zzl, @SafeParcelable.Param(mo17150id = 9) zzz zzz) {
        this.zzmd = zzb;
        this.zzme = zzd;
        this.zzmf = zzr;
        this.zzmg = zzv;
        this.zzmh = zzp;
        this.zzmi = zzt;
        this.zzmj = zzn;
        this.zzmk = zzl;
        this.zzml = zzz;
        if (zzb != null) {
            this.zzbc = zzb;
        } else if (zzd != null) {
            this.zzbc = zzd;
        } else if (zzr != null) {
            this.zzbc = zzr;
        } else if (zzv != null) {
            this.zzbc = zzv;
        } else if (zzp != null) {
            this.zzbc = zzp;
        } else if (zzt != null) {
            this.zzbc = zzt;
        } else if (zzn != null) {
            this.zzbc = zzn;
        } else if (zzl != null) {
            this.zzbc = zzl;
        } else if (zzz != null) {
            this.zzbc = zzz;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public final Filter getFilter() {
        return this.zzbc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzmd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzme, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzmf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzmg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzmh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzmi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzmj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzmk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzml, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public FilterHolder(Filter filter) {
        Preconditions.checkNotNull(filter, "Null filter.");
        zzz zzz = null;
        this.zzmd = filter instanceof zzb ? (zzb) filter : null;
        this.zzme = filter instanceof zzd ? (zzd) filter : null;
        this.zzmf = filter instanceof zzr ? (zzr) filter : null;
        this.zzmg = filter instanceof zzv ? (zzv) filter : null;
        this.zzmh = filter instanceof zzp ? (zzp) filter : null;
        this.zzmi = filter instanceof zzt ? (zzt) filter : null;
        this.zzmj = filter instanceof zzn ? (zzn) filter : null;
        this.zzmk = filter instanceof zzl ? (zzl) filter : null;
        zzz = filter instanceof zzz ? (zzz) filter : zzz;
        this.zzml = zzz;
        if (this.zzmd == null && this.zzme == null && this.zzmf == null && this.zzmg == null && this.zzmh == null && this.zzmi == null && this.zzmj == null && this.zzmk == null && zzz == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzbc = filter;
    }
}
