package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwn {
    @VisibleForTesting
    public static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    @Nullable
    public static zzabd zza(zzakr zzakr) {
        String str;
        String str2;
        String str3;
        int zzv = zzakr.zzv() + zzakr.zzg();
        int zzv2 = zzakr.zzv();
        int i = (zzv2 >> 24) & 255;
        zzabd zzabd = null;
        if (i == 169 || i == 253) {
            int i2 = zzv2 & ViewCompat.MEASURED_SIZE_MASK;
            if (i2 == 6516084) {
                int zzv3 = zzakr.zzv();
                if (zzakr.zzv() == 1684108385) {
                    zzakr.zzk(8);
                    String zzF = zzakr.zzF(zzv3 - 16);
                    zzabd = new zzabz("und", zzF, zzF);
                } else {
                    String valueOf = String.valueOf(zzvz.zzf(zzv2));
                    if (valueOf.length() != 0) {
                        str2 = "Failed to parse comment attribute: ".concat(valueOf);
                    } else {
                        str2 = new String("Failed to parse comment attribute: ");
                    }
                    Log.w("MetadataUtil", str2);
                }
                zzakr.zzh(zzv);
                return zzabd;
            } else if (i2 == 7233901 || i2 == 7631467) {
                zzaco zzb2 = zzb(zzv2, "TIT2", zzakr);
                zzakr.zzh(zzv);
                return zzb2;
            } else if (i2 == 6516589 || i2 == 7828084) {
                zzaco zzb3 = zzb(zzv2, "TCOM", zzakr);
                zzakr.zzh(zzv);
                return zzb3;
            } else if (i2 == 6578553) {
                zzaco zzb4 = zzb(zzv2, "TDRC", zzakr);
                zzakr.zzh(zzv);
                return zzb4;
            } else if (i2 == 4280916) {
                zzaco zzb5 = zzb(zzv2, "TPE1", zzakr);
                zzakr.zzh(zzv);
                return zzb5;
            } else if (i2 == 7630703) {
                zzaco zzb6 = zzb(zzv2, "TSSE", zzakr);
                zzakr.zzh(zzv);
                return zzb6;
            } else if (i2 == 6384738) {
                zzaco zzb7 = zzb(zzv2, "TALB", zzakr);
                zzakr.zzh(zzv);
                return zzb7;
            } else if (i2 == 7108978) {
                zzaco zzb8 = zzb(zzv2, "USLT", zzakr);
                zzakr.zzh(zzv);
                return zzb8;
            } else if (i2 == 6776174) {
                zzaco zzb9 = zzb(zzv2, "TCON", zzakr);
                zzakr.zzh(zzv);
                return zzb9;
            } else if (i2 == 6779504) {
                zzaco zzb10 = zzb(zzv2, "TIT1", zzakr);
                zzakr.zzh(zzv);
                return zzb10;
            }
        } else if (zzv2 == 1735291493) {
            try {
                int zze = zze(zzakr);
                String str4 = (zze <= 0 || zze > 192) ? null : zza[zze - 1];
                if (str4 != null) {
                    zzabd = new zzaco("TCON", (String) null, str4);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                }
                return zzabd;
            } finally {
                zzakr.zzh(zzv);
            }
        } else if (zzv2 == 1684632427) {
            zzaco zzd = zzd(1684632427, "TPOS", zzakr);
            zzakr.zzh(zzv);
            return zzd;
        } else if (zzv2 == 1953655662) {
            zzaco zzd2 = zzd(1953655662, "TRCK", zzakr);
            zzakr.zzh(zzv);
            return zzd2;
        } else if (zzv2 == 1953329263) {
            zzacg zzc = zzc(1953329263, "TBPM", zzakr, true, false);
            zzakr.zzh(zzv);
            return zzc;
        } else if (zzv2 == 1668311404) {
            zzacg zzc2 = zzc(1668311404, "TCMP", zzakr, true, true);
            zzakr.zzh(zzv);
            return zzc2;
        } else if (zzv2 == 1668249202) {
            int zzv4 = zzakr.zzv();
            if (zzakr.zzv() == 1684108385) {
                int zzv5 = zzakr.zzv() & ViewCompat.MEASURED_SIZE_MASK;
                if (zzv5 == 13) {
                    str3 = "image/jpeg";
                } else if (zzv5 == 14) {
                    str3 = "image/png";
                    zzv5 = 14;
                } else {
                    str3 = null;
                }
                if (str3 == null) {
                    StringBuilder sb = new StringBuilder(41);
                    sb.append("Unrecognized cover art flags: ");
                    sb.append(zzv5);
                    Log.w("MetadataUtil", sb.toString());
                } else {
                    zzakr.zzk(4);
                    int i3 = zzv4 - 16;
                    byte[] bArr = new byte[i3];
                    zzakr.zzm(bArr, 0, i3);
                    zzabd = new zzabr(str3, (String) null, 3, bArr);
                }
            } else {
                Log.w("MetadataUtil", "Failed to parse cover art attribute");
            }
            zzakr.zzh(zzv);
            return zzabd;
        } else if (zzv2 == 1631670868) {
            zzaco zzb11 = zzb(1631670868, "TPE2", zzakr);
            zzakr.zzh(zzv);
            return zzb11;
        } else if (zzv2 == 1936682605) {
            zzaco zzb12 = zzb(1936682605, "TSOT", zzakr);
            zzakr.zzh(zzv);
            return zzb12;
        } else if (zzv2 == 1936679276) {
            zzaco zzb13 = zzb(1936679276, "TSO2", zzakr);
            zzakr.zzh(zzv);
            return zzb13;
        } else if (zzv2 == 1936679282) {
            zzaco zzb14 = zzb(1936679282, "TSOA", zzakr);
            zzakr.zzh(zzv);
            return zzb14;
        } else if (zzv2 == 1936679265) {
            zzaco zzb15 = zzb(1936679265, "TSOP", zzakr);
            zzakr.zzh(zzv);
            return zzb15;
        } else if (zzv2 == 1936679791) {
            zzaco zzb16 = zzb(1936679791, "TSOC", zzakr);
            zzakr.zzh(zzv);
            return zzb16;
        } else if (zzv2 == 1920233063) {
            zzacg zzc3 = zzc(1920233063, "ITUNESADVISORY", zzakr, false, false);
            zzakr.zzh(zzv);
            return zzc3;
        } else if (zzv2 == 1885823344) {
            zzacg zzc4 = zzc(1885823344, "ITUNESGAPLESS", zzakr, false, true);
            zzakr.zzh(zzv);
            return zzc4;
        } else if (zzv2 == 1936683886) {
            zzaco zzb17 = zzb(1936683886, "TVSHOWSORT", zzakr);
            zzakr.zzh(zzv);
            return zzb17;
        } else if (zzv2 == 1953919848) {
            zzaco zzb18 = zzb(1953919848, "TVSHOW", zzakr);
            zzakr.zzh(zzv);
            return zzb18;
        } else if (zzv2 == 757935405) {
            String str5 = null;
            String str6 = null;
            int i4 = -1;
            int i5 = -1;
            while (zzakr.zzg() < zzv) {
                int zzg = zzakr.zzg();
                int zzv6 = zzakr.zzv();
                int zzv7 = zzakr.zzv();
                zzakr.zzk(4);
                if (zzv7 == 1835360622) {
                    str5 = zzakr.zzF(zzv6 - 12);
                } else if (zzv7 == 1851878757) {
                    str6 = zzakr.zzF(zzv6 - 12);
                } else {
                    if (zzv7 == 1684108385) {
                        i5 = zzv6;
                    }
                    if (zzv7 == 1684108385) {
                        i4 = zzg;
                    }
                    zzakr.zzk(zzv6 - 12);
                }
            }
            if (!(str5 == null || str6 == null)) {
                if (i4 != -1) {
                    zzakr.zzh(i4);
                    zzakr.zzk(16);
                    zzabd = new zzaci(str5, str6, zzakr.zzF(i5 - 16));
                }
            }
            zzakr.zzh(zzv);
            return zzabd;
        }
        String valueOf2 = String.valueOf(zzvz.zzf(zzv2));
        if (valueOf2.length() != 0) {
            str = "Skipped unknown metadata entry: ".concat(valueOf2);
        } else {
            str = new String("Skipped unknown metadata entry: ");
        }
        Log.d("MetadataUtil", str);
        zzakr.zzh(zzv);
        return null;
    }

    @Nullable
    public static zzaco zzb(int i, String str, zzakr zzakr) {
        String str2;
        int zzv = zzakr.zzv();
        if (zzakr.zzv() == 1684108385) {
            zzakr.zzk(8);
            return new zzaco(str, (String) null, zzakr.zzF(zzv - 16));
        }
        String valueOf = String.valueOf(zzvz.zzf(i));
        if (valueOf.length() != 0) {
            str2 = "Failed to parse text attribute: ".concat(valueOf);
        } else {
            str2 = new String("Failed to parse text attribute: ");
        }
        Log.w("MetadataUtil", str2);
        return null;
    }

    @Nullable
    public static zzacg zzc(int i, String str, zzakr zzakr, boolean z, boolean z2) {
        String str2;
        int zze = zze(zzakr);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze < 0) {
            String valueOf = String.valueOf(zzvz.zzf(i));
            if (valueOf.length() != 0) {
                str2 = "Failed to parse uint8 attribute: ".concat(valueOf);
            } else {
                str2 = new String("Failed to parse uint8 attribute: ");
            }
            Log.w("MetadataUtil", str2);
            return null;
        } else if (z) {
            return new zzaco(str, (String) null, Integer.toString(zze));
        } else {
            return new zzabz("und", str, Integer.toString(zze));
        }
    }

    @Nullable
    public static zzaco zzd(int i, String str, zzakr zzakr) {
        String str2;
        int zzv = zzakr.zzv();
        if (zzakr.zzv() == 1684108385 && zzv >= 22) {
            zzakr.zzk(10);
            int zzo = zzakr.zzo();
            if (zzo > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(zzo);
                String sb2 = sb.toString();
                int zzo2 = zzakr.zzo();
                if (zzo2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(zzo2);
                    sb2 = sb3.toString();
                }
                return new zzaco(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzvz.zzf(i));
        if (valueOf2.length() != 0) {
            str2 = "Failed to parse index/count attribute: ".concat(valueOf2);
        } else {
            str2 = new String("Failed to parse index/count attribute: ");
        }
        Log.w("MetadataUtil", str2);
        return null;
    }

    public static int zze(zzakr zzakr) {
        zzakr.zzk(4);
        if (zzakr.zzv() == 1684108385) {
            zzakr.zzk(8);
            return zzakr.zzn();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
