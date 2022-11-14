package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.GraphRequest;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeyp {
    public final List<zzeye> zza;
    public final zzeyh zzb;
    public final List<zzeyo> zzc;

    public zzeyp(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List<zzeye> list;
        ArrayList arrayList;
        List<zzeye> emptyList = Collections.emptyList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        zzeyh zzeyh = null;
        List<zzeye> list2 = emptyList;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                List<zzeye> list3 = list2;
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        ArrayList arrayList3 = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            arrayList3.add(new zzeye(jsonReader));
                        }
                        jsonReader.endArray();
                        arrayList = arrayList3;
                    } else if (nextName2.equals("common")) {
                        zzeyh = new zzeyh(jsonReader);
                        arrayList = list3;
                    } else {
                        jsonReader.skipValue();
                        arrayList = list3;
                    }
                    list3 = arrayList;
                }
                jsonReader.endObject();
                jsonReader.endArray();
                list = list3;
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    JSONObject jSONObject = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if (GraphRequest.DEBUG_SEVERITY_INFO.equals(nextName3)) {
                            jSONObject = zzbv.zzc(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList2.add(new zzeyo(str, jSONObject));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
                list = list2;
            } else {
                list = list2;
            }
            list2 = list;
        }
        this.zzc = arrayList2;
        this.zza = list2;
        this.zzb = zzeyh == null ? new zzeyh(new JsonReader(new StringReader(JsonUtils.EMPTY_JSON))) : zzeyh;
    }

    public static zzeyp zza(Reader reader) throws zzeyi {
        try {
            zzeyp zzeyp = new zzeyp(new JsonReader(reader));
            IOUtils.closeQuietly((Closeable) reader);
            return zzeyp;
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
            throw new zzeyi("unable to parse ServerResponse", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) reader);
            throw th;
        }
    }
}
