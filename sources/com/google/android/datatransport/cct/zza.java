package com.google.android.datatransport.cct;

import android.util.Log;
import com.android.billingclient.api.zzam;
import com.facebook.GraphRequest;
import com.google.android.datatransport.cct.p032a.zzl;
import com.google.android.datatransport.cct.p032a.zzx;
import com.google.android.datatransport.cct.zzc;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.vungle.warren.downloader.AssetDownloader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final /* synthetic */ class zza {
    public final zzc zza;

    public zza(zzc zzc) {
        this.zza = zzc;
    }

    public Object apply(Object obj) {
        GZIPOutputStream gZIPOutputStream;
        InputStream inputStream;
        zzc zzc = this.zza;
        zzc.zza zza2 = (zzc.zza) obj;
        if (zzc != null) {
            zzam.m35d("CctTransportBackend", "Making request to: %s", (Object) zza2.zza);
            HttpURLConnection httpURLConnection = (HttpURLConnection) zza2.zza.openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(zzc.zzf);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, String.format("datatransport/%s android/", new Object[]{"2.2.0"}));
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty(AssetDownloader.ACCEPT_ENCODING, "gzip");
            String str = zza2.zzc;
            if (str != null) {
                httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
            }
            WritableByteChannel newChannel = Channels.newChannel(httpURLConnection.getOutputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    ((JsonDataEncoderBuilder.C23571) zzc.zza).encode(zza2.zzb, new OutputStreamWriter(gZIPOutputStream));
                    gZIPOutputStream.close();
                    newChannel.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
                    int responseCode = httpURLConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Status Code: ");
                    sb.append(responseCode);
                    zzam.m38i("CctTransportBackend", sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Content-Type: ");
                    sb2.append(httpURLConnection.getHeaderField("Content-Type"));
                    zzam.m38i("CctTransportBackend", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Content-Encoding: ");
                    sb3.append(httpURLConnection.getHeaderField("Content-Encoding"));
                    zzam.m38i("CctTransportBackend", sb3.toString());
                    if (!(responseCode == 302 || responseCode == 301)) {
                        if (responseCode != 307) {
                            if (responseCode != 200) {
                                zzc.zzb zzb = new zzc.zzb(responseCode, (URL) null, 0);
                                newChannel.close();
                                return zzb;
                            }
                            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            if (headerField == null || !headerField.equals("gzip")) {
                                inputStream = httpURLConnection.getInputStream();
                            } else {
                                inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                            }
                            zzc.zzb zzb2 = new zzc.zzb(responseCode, (URL) null, ((zzl) zzx.zza(new InputStreamReader(inputStream))).zza);
                            inputStream.close();
                            newChannel.close();
                            return zzb2;
                        }
                    }
                    zzc.zzb zzb3 = new zzc.zzb(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0);
                    newChannel.close();
                    return zzb3;
                } catch (EncodingException | IOException e) {
                    Log.e(zzam.getTag("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
                    zzc.zzb zzb4 = new zzc.zzb(400, (URL) null, 0);
                    gZIPOutputStream.close();
                    newChannel.close();
                    return zzb4;
                }
            } catch (Throwable th) {
                newChannel.close();
                throw th;
            }
        } else {
            throw null;
        }
    }
}
