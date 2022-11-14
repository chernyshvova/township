package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzs;
import com.vungle.warren.p037ui.JavascriptBridge;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbyl implements DialogInterface.OnClickListener {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbyn zzc;

    public zzbyl(zzbyn zzbyn, String str, String str2) {
        this.zzc = zzbyn;
        this.zza = str;
        this.zzb = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzc.zzb.getSystemService(JavascriptBridge.MraidHandler.DOWNLOAD_ACTION);
        try {
            String str = this.zza;
            String str2 = this.zzb;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzs.zzc();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzc.zzf("Could not store picture.");
        }
    }
}
