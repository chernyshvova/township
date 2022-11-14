package com.google.android.gms.drive;

import com.google.android.gms.common.internal.Objects;

public class TransferPreferencesBuilder {
    public static final TransferPreferences DEFAULT_PREFERENCES = new zza(1, true, 256);
    public int zzbl;
    public boolean zzbm;
    public int zzbn;

    public static class zza implements TransferPreferences {
        public final int zzbl;
        public final boolean zzbm;
        public final int zzbn;

        public zza(int i, boolean z, int i2) {
            this.zzbl = i;
            this.zzbm = z;
            this.zzbn = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && zza.class == obj.getClass()) {
                zza zza = (zza) obj;
                return zza.zzbl == this.zzbl && zza.zzbm == this.zzbm && zza.zzbn == this.zzbn;
            }
        }

        public final int getBatteryUsagePreference() {
            return this.zzbn;
        }

        public final int getNetworkPreference() {
            return this.zzbl;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.zzbl), Boolean.valueOf(this.zzbm), Integer.valueOf(this.zzbn));
        }

        public final boolean isRoamingAllowed() {
            return this.zzbm;
        }

        public final String toString() {
            return String.format("NetworkPreference: %s, IsRoamingAllowed %s, BatteryUsagePreference %s", new Object[]{Integer.valueOf(this.zzbl), Boolean.valueOf(this.zzbm), Integer.valueOf(this.zzbn)});
        }
    }

    public TransferPreferencesBuilder() {
        this(DEFAULT_PREFERENCES);
    }

    public TransferPreferences build() {
        return new zza(this.zzbl, this.zzbm, this.zzbn);
    }

    public TransferPreferencesBuilder setBatteryUsagePreference(int i) {
        this.zzbn = i;
        return this;
    }

    public TransferPreferencesBuilder setIsRoamingAllowed(boolean z) {
        this.zzbm = z;
        return this;
    }

    public TransferPreferencesBuilder setNetworkPreference(int i) {
        this.zzbl = i;
        return this;
    }

    public TransferPreferencesBuilder(TransferPreferences transferPreferences) {
        this.zzbl = transferPreferences.getNetworkPreference();
        this.zzbm = transferPreferences.isRoamingAllowed();
        this.zzbn = transferPreferences.getBatteryUsagePreference();
    }

    public TransferPreferencesBuilder(FileUploadPreferences fileUploadPreferences) {
        this.zzbl = fileUploadPreferences.getNetworkTypePreference();
        this.zzbm = fileUploadPreferences.isRoamingAllowed();
        this.zzbn = fileUploadPreferences.getBatteryUsagePreference();
    }
}
