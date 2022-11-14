package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class AccountPicker {

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static class AccountChooserOptions {
        @Nullable
        public Account zza;
        public boolean zzb;
        @Nullable
        public ArrayList<Account> zzc;
        @Nullable
        public ArrayList<String> zzd;
        public boolean zze;
        @Nullable
        public String zzf;
        @Nullable
        public Bundle zzg;
        public boolean zzh;
        public int zzi;
        @Nullable
        public String zzj;
        public boolean zzk;
        @Nullable
        public zza zzl;
        @Nullable
        public String zzm;
        public boolean zzn;
        public boolean zzo;

        /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
        public static class Builder {
            @Nullable
            public Account zza;
            @Nullable
            public ArrayList<Account> zzb;
            @Nullable
            public ArrayList<String> zzc;
            public boolean zzd = false;
            @Nullable
            public String zze;
            @Nullable
            public Bundle zzf;

            @RecentlyNonNull
            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                ArrayList unused = accountChooserOptions.zzd = this.zzc;
                ArrayList unused2 = accountChooserOptions.zzc = this.zzb;
                boolean unused3 = accountChooserOptions.zze = this.zzd;
                zza unused4 = accountChooserOptions.zzl = null;
                String unused5 = accountChooserOptions.zzj = null;
                Bundle unused6 = accountChooserOptions.zzg = this.zzf;
                Account unused7 = accountChooserOptions.zza = this.zza;
                boolean unused8 = accountChooserOptions.zzb = false;
                boolean unused9 = accountChooserOptions.zzh = false;
                String unused10 = accountChooserOptions.zzm = null;
                int unused11 = accountChooserOptions.zzi = 0;
                String unused12 = accountChooserOptions.zzf = this.zze;
                boolean unused13 = accountChooserOptions.zzk = false;
                boolean unused14 = accountChooserOptions.zzn = false;
                boolean unused15 = accountChooserOptions.zzo = false;
                return accountChooserOptions;
            }

            @RecentlyNonNull
            public Builder setAllowableAccounts(@Nullable List<Account> list) {
                this.zzb = list == null ? null : new ArrayList<>(list);
                return this;
            }

            @RecentlyNonNull
            public Builder setAllowableAccountsTypes(@Nullable List<String> list) {
                this.zzc = list == null ? null : new ArrayList<>(list);
                return this;
            }

            @RecentlyNonNull
            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.zzd = z;
                return this;
            }

            @RecentlyNonNull
            public Builder setOptionsForAddingAccount(@Nullable Bundle bundle) {
                this.zzf = bundle;
                return this;
            }

            @RecentlyNonNull
            public Builder setSelectedAccount(@Nullable Account account) {
                this.zza = account;
                return this;
            }

            @RecentlyNonNull
            public Builder setTitleOverrideText(@Nullable String str) {
                this.zze = str;
                return this;
            }
        }
    }

    @RecentlyNonNull
    @Deprecated
    public static Intent newChooseAccountIntent(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    @RecentlyNonNull
    public static Intent newChooseAccountIntent(@RecentlyNonNull AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        boolean unused = accountChooserOptions.zzk;
        String unused2 = accountChooserOptions.zzj;
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        zza unused3 = accountChooserOptions.zzl;
        Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
        boolean unused4 = accountChooserOptions.zzb;
        Preconditions.checkArgument(true, "Making the selected account non-clickable is only supported for the theme THEME_DAY_NIGHT_GOOGLE_MATERIAL2");
        boolean unused5 = accountChooserOptions.zzk;
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.zzc);
        if (accountChooserOptions.zzd != null) {
            intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.zzd.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.zzg);
        intent.putExtra("selectedAccount", accountChooserOptions.zza);
        boolean unused6 = accountChooserOptions.zzb;
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.zze);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.zzf);
        boolean unused7 = accountChooserOptions.zzh;
        intent.putExtra("setGmsCoreAccount", false);
        String unused8 = accountChooserOptions.zzm;
        intent.putExtra("realClientPackage", (String) null);
        int unused9 = accountChooserOptions.zzi;
        intent.putExtra("overrideTheme", 0);
        boolean unused10 = accountChooserOptions.zzk;
        intent.putExtra("overrideCustomTheme", 0);
        String unused11 = accountChooserOptions.zzj;
        intent.putExtra("hostedDomainFilter", (String) null);
        Bundle bundle = new Bundle();
        boolean unused12 = accountChooserOptions.zzk;
        zza unused13 = accountChooserOptions.zzl;
        boolean unused14 = accountChooserOptions.zzn;
        boolean unused15 = accountChooserOptions.zzo;
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
