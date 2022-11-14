package com.google.android.gms.internal.ads;

import com.facebook.internal.Utility;
import com.google.android.gms.ads.internal.zzs;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzckz implements zzfjd {
    public final String zza;

    public zzckz(String str) {
        this.zza = str;
    }

    public final URLConnection zza() {
        String str;
        String str2;
        String str3 = this.zza;
        int i = zzcla.zzd;
        zzs.zzo();
        int intValue = ((Integer) zzbex.zzc().zzb(zzbjn.zzu)).intValue();
        URL url = new URL(str3);
        int i2 = 0;
        while (true) {
            i2++;
            if (i2 <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(intValue);
                openConnection.setReadTimeout(intValue);
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    zzcgr zzcgr = new zzcgr((String) null);
                    zzcgr.zza(httpURLConnection, (byte[]) null);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzcgr.zzc(httpURLConnection, responseCode);
                    if (responseCode / 100 != 3) {
                        return httpURLConnection;
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField != null) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            throw new IOException("Protocol is null");
                        } else if (protocol.equals("http") || protocol.equals(Utility.URL_SCHEME)) {
                            if (headerField.length() != 0) {
                                str = "Redirecting to ".concat(headerField);
                            } else {
                                str = new String("Redirecting to ");
                            }
                            zzcgs.zzd(str);
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            if (protocol.length() != 0) {
                                str2 = "Unsupported scheme: ".concat(protocol);
                            } else {
                                str2 = new String("Unsupported scheme: ");
                            }
                            throw new IOException(str2);
                        }
                    } else {
                        throw new IOException("Missing Location header in redirect");
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                throw new IOException("Too many redirects (20)");
            }
        }
    }
}
