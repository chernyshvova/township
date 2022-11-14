package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzva {
    public static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    public static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    public static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static zzuw zza(String str) throws IOException {
        long j;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            newPullParser.next();
            if (zzali.zzb(newPullParser, "x:xmpmeta")) {
                zzfml<zzuv> zzi = zzfml.zzi();
                long j2 = -9223372036854775807L;
                do {
                    newPullParser.next();
                    if (zzali.zzb(newPullParser, "rdf:Description")) {
                        String[] strArr = zza;
                        int i = 0;
                        int i2 = 0;
                        while (i2 < 4) {
                            String zzc2 = zzali.zzc(newPullParser, strArr[i2]);
                            if (zzc2 == null) {
                                i2++;
                            } else if (Integer.parseInt(zzc2) != 1) {
                                return null;
                            } else {
                                String[] strArr2 = zzb;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= 4) {
                                        break;
                                    }
                                    String zzc3 = zzali.zzc(newPullParser, strArr2[i3]);
                                    if (zzc3 != null) {
                                        j = Long.parseLong(zzc3);
                                        if (j == -1) {
                                        }
                                    } else {
                                        i3++;
                                    }
                                }
                                j = -9223372036854775807L;
                                String[] strArr3 = zzc;
                                while (true) {
                                    if (i >= 2) {
                                        zzi = zzfml.zzi();
                                        break;
                                    }
                                    String zzc4 = zzali.zzc(newPullParser, strArr3[i]);
                                    if (zzc4 != null) {
                                        zzi = zzfml.zzk(new zzuv("image/jpeg", "Primary", 0, 0), new zzuv("video/mp4", "MotionPhoto", Long.parseLong(zzc4), 0));
                                        break;
                                    }
                                    i++;
                                }
                                j2 = j;
                            }
                        }
                        return null;
                    } else if (zzali.zzb(newPullParser, "Container:Directory")) {
                        zzi = zzb(newPullParser, "Container", "Item");
                    } else if (zzali.zzb(newPullParser, "GContainer:Directory")) {
                        zzi = zzb(newPullParser, "GContainer", "GContainerItem");
                    }
                } while (!zzali.zza(newPullParser, "x:xmpmeta"));
                if (zzi.isEmpty()) {
                    return null;
                }
                return new zzuw(j2, zzi);
            }
            throw new zzlg("Couldn't find xmp metadata", (Throwable) null);
        } catch (zzlg | NumberFormatException | XmlPullParserException unused) {
            Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    public static zzfml<zzuv> zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        zzfmi zzu = zzfml.zzu();
        String concat = str.concat(":Item");
        String concat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (zzali.zzb(xmlPullParser, concat)) {
                String concat3 = str2.concat(":Mime");
                String concat4 = str2.concat(":Semantic");
                String concat5 = str2.concat(":Length");
                String concat6 = str2.concat(":Padding");
                String zzc2 = zzali.zzc(xmlPullParser, concat3);
                String zzc3 = zzali.zzc(xmlPullParser, concat4);
                String zzc4 = zzali.zzc(xmlPullParser, concat5);
                String zzc5 = zzali.zzc(xmlPullParser, concat6);
                if (zzc2 == null || zzc3 == null) {
                    return zzfml.zzi();
                }
                zzu.zze(new zzuv(zzc2, zzc3, zzc4 != null ? Long.parseLong(zzc4) : 0, zzc5 != null ? Long.parseLong(zzc5) : 0));
            }
        } while (!zzali.zza(xmlPullParser, concat2));
        return zzu.zzf();
    }
}
