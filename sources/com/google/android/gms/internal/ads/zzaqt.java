package com.google.android.gms.internal.ads;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaqt {
    public static final int zzA = zzava.zzl("sosn");
    public static final int zzB = zzava.zzl("tvsh");
    public static final int zzC = zzava.zzl("----");
    public static final String[] zzD = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    public static final int zza = zzava.zzl("nam");
    public static final int zzb = zzava.zzl("trk");
    public static final int zzc = zzava.zzl("cmt");
    public static final int zzd = zzava.zzl("day");
    public static final int zze = zzava.zzl("ART");
    public static final int zzf = zzava.zzl("too");
    public static final int zzg = zzava.zzl("alb");
    public static final int zzh = zzava.zzl("com");
    public static final int zzi = zzava.zzl("wrt");
    public static final int zzj = zzava.zzl("lyr");
    public static final int zzk = zzava.zzl("gen");
    public static final int zzl = zzava.zzl("covr");
    public static final int zzm = zzava.zzl("gnre");
    public static final int zzn = zzava.zzl("grp");
    public static final int zzo = zzava.zzl("disk");
    public static final int zzp = zzava.zzl("trkn");
    public static final int zzq = zzava.zzl("tmpo");
    public static final int zzr = zzava.zzl("cpil");
    public static final int zzs = zzava.zzl("aART");
    public static final int zzt = zzava.zzl("sonm");
    public static final int zzu = zzava.zzl("soal");
    public static final int zzv = zzava.zzl("soar");
    public static final int zzw = zzava.zzl("soaa");
    public static final int zzx = zzava.zzl("soco");
    public static final int zzy = zzava.zzl("rtng");
    public static final int zzz = zzava.zzl("pgap");

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A[Catch:{ all -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e A[Catch:{ all -> 0x01d7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzarp zza(com.google.android.gms.internal.ads.zzaut r13) {
        /*
            int r0 = r13.zzg()
            int r1 = r13.zzr()
            int r1 = r1 + r0
            int r0 = r13.zzr()
            int r2 = r0 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = "und"
            java.lang.String r4 = "TCON"
            java.lang.String r5 = "MetadataUtil"
            r6 = 0
            r7 = 169(0xa9, float:2.37E-43)
            if (r2 == r7) goto L_0x01da
            int r2 = zzm     // Catch:{ all -> 0x01d7 }
            r7 = -1
            if (r0 != r2) goto L_0x0047
            int r0 = zze(r13)     // Catch:{ all -> 0x01d7 }
            if (r0 <= 0) goto L_0x0034
            java.lang.String[] r2 = zzD     // Catch:{ all -> 0x01d7 }
            int r2 = r2.length     // Catch:{ all -> 0x01d7 }
            r2 = 148(0x94, float:2.07E-43)
            if (r0 > r2) goto L_0x0034
            java.lang.String[] r2 = zzD     // Catch:{ all -> 0x01d7 }
            int r0 = r0 + r7
            r0 = r2[r0]     // Catch:{ all -> 0x01d7 }
            goto L_0x0035
        L_0x0034:
            r0 = r6
        L_0x0035:
            if (r0 == 0) goto L_0x003e
            com.google.android.gms.internal.ads.zzary r2 = new com.google.android.gms.internal.ads.zzary     // Catch:{ all -> 0x01d7 }
            r2.<init>(r4, r6, r0)     // Catch:{ all -> 0x01d7 }
            r6 = r2
            goto L_0x0043
        L_0x003e:
            java.lang.String r0 = "Failed to parse standard genre code"
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x01d7 }
        L_0x0043:
            r13.zzi(r1)
            return r6
        L_0x0047:
            int r2 = zzo     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0055
            java.lang.String r2 = "TPOS"
            com.google.android.gms.internal.ads.zzary r0 = zzd(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0055:
            int r2 = zzp     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0063
            java.lang.String r2 = "TRCK"
            com.google.android.gms.internal.ads.zzary r0 = zzd(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0063:
            int r2 = zzq     // Catch:{ all -> 0x01d7 }
            r4 = 1
            r8 = 0
            if (r0 != r2) goto L_0x0073
            java.lang.String r2 = "TBPM"
            com.google.android.gms.internal.ads.zzarw r0 = zzc(r0, r2, r13, r4, r8)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0073:
            int r2 = zzr     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0081
            java.lang.String r2 = "TCMP"
            com.google.android.gms.internal.ads.zzarw r0 = zzc(r0, r2, r13, r4, r4)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0081:
            int r2 = zzl     // Catch:{ all -> 0x01d7 }
            r9 = 4
            if (r0 != r2) goto L_0x00df
            int r0 = r13.zzr()     // Catch:{ all -> 0x01d7 }
            int r2 = r13.zzr()     // Catch:{ all -> 0x01d7 }
            int r3 = com.google.android.gms.internal.ads.zzaqg.zzaH     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x00d6
            int r2 = r13.zzr()     // Catch:{ all -> 0x01d7 }
            int r2 = com.google.android.gms.internal.ads.zzaqg.zzf(r2)     // Catch:{ all -> 0x01d7 }
            r3 = 13
            r4 = 14
            if (r2 != r3) goto L_0x00a3
            java.lang.String r3 = "image/jpeg"
            goto L_0x00ab
        L_0x00a3:
            if (r2 != r4) goto L_0x00aa
            java.lang.String r3 = "image/png"
            r2 = 14
            goto L_0x00ab
        L_0x00aa:
            r3 = r6
        L_0x00ab:
            if (r3 != 0) goto L_0x00c4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d7 }
            r3 = 41
            r0.<init>(r3)     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = "Unrecognized cover art flags: "
            r0.append(r3)     // Catch:{ all -> 0x01d7 }
            r0.append(r2)     // Catch:{ all -> 0x01d7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01d7 }
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x01d7 }
            goto L_0x00db
        L_0x00c4:
            r13.zzj(r9)     // Catch:{ all -> 0x01d7 }
            int r0 = r0 + -16
            byte[] r2 = new byte[r0]     // Catch:{ all -> 0x01d7 }
            r13.zzk(r2, r8, r0)     // Catch:{ all -> 0x01d7 }
            com.google.android.gms.internal.ads.zzars r0 = new com.google.android.gms.internal.ads.zzars     // Catch:{ all -> 0x01d7 }
            r4 = 3
            r0.<init>(r3, r6, r4, r2)     // Catch:{ all -> 0x01d7 }
            r6 = r0
            goto L_0x00db
        L_0x00d6:
            java.lang.String r0 = "Failed to parse cover art attribute"
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x01d7 }
        L_0x00db:
            r13.zzi(r1)
            return r6
        L_0x00df:
            int r2 = zzs     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x00ed
            java.lang.String r2 = "TPE2"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x00ed:
            int r2 = zzt     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x00fb
            java.lang.String r2 = "TSOT"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x00fb:
            int r2 = zzu     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0109
            java.lang.String r2 = "TSO2"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0109:
            int r2 = zzv     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0117
            java.lang.String r2 = "TSOA"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0117:
            int r2 = zzw     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0125
            java.lang.String r2 = "TSOP"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0125:
            int r2 = zzx     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0133
            java.lang.String r2 = "TSOC"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0133:
            int r2 = zzy     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0141
            java.lang.String r2 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzarw r0 = zzc(r0, r2, r13, r8, r8)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0141:
            int r2 = zzz     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x014f
            java.lang.String r2 = "ITUNESGAPLESS"
            com.google.android.gms.internal.ads.zzarw r0 = zzc(r0, r2, r13, r8, r4)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x014f:
            int r2 = zzA     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x015d
            java.lang.String r2 = "TVSHOWSORT"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x015d:
            int r2 = zzB     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x016b
            java.lang.String r2 = "TVSHOW"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x016b:
            int r2 = zzC     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x0294
            r0 = r6
            r2 = r0
            r4 = -1
            r5 = -1
        L_0x0173:
            int r8 = r13.zzg()     // Catch:{ all -> 0x01d7 }
            if (r8 >= r1) goto L_0x01ad
            int r8 = r13.zzg()     // Catch:{ all -> 0x01d7 }
            int r10 = r13.zzr()     // Catch:{ all -> 0x01d7 }
            int r11 = r13.zzr()     // Catch:{ all -> 0x01d7 }
            r13.zzj(r9)     // Catch:{ all -> 0x01d7 }
            int r12 = com.google.android.gms.internal.ads.zzaqg.zzaF     // Catch:{ all -> 0x01d7 }
            if (r11 != r12) goto L_0x0193
            int r10 = r10 + -12
            java.lang.String r0 = r13.zzw(r10)     // Catch:{ all -> 0x01d7 }
            goto L_0x0173
        L_0x0193:
            int r12 = com.google.android.gms.internal.ads.zzaqg.zzaG     // Catch:{ all -> 0x01d7 }
            if (r11 != r12) goto L_0x019e
            int r10 = r10 + -12
            java.lang.String r2 = r13.zzw(r10)     // Catch:{ all -> 0x01d7 }
            goto L_0x0173
        L_0x019e:
            int r12 = com.google.android.gms.internal.ads.zzaqg.zzaH     // Catch:{ all -> 0x01d7 }
            if (r11 != r12) goto L_0x01a3
            r5 = r10
        L_0x01a3:
            if (r11 == r12) goto L_0x01a6
            goto L_0x01a7
        L_0x01a6:
            r4 = r8
        L_0x01a7:
            int r10 = r10 + -12
            r13.zzj(r10)     // Catch:{ all -> 0x01d7 }
            goto L_0x0173
        L_0x01ad:
            java.lang.String r8 = "com.apple.iTunes"
            boolean r0 = r8.equals(r0)     // Catch:{ all -> 0x01d7 }
            if (r0 == 0) goto L_0x01d3
            java.lang.String r0 = "iTunSMPB"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x01d7 }
            if (r0 == 0) goto L_0x01d3
            if (r4 != r7) goto L_0x01c0
            goto L_0x01d3
        L_0x01c0:
            r13.zzi(r4)     // Catch:{ all -> 0x01d7 }
            r0 = 16
            r13.zzj(r0)     // Catch:{ all -> 0x01d7 }
            int r5 = r5 + -16
            java.lang.String r0 = r13.zzw(r5)     // Catch:{ all -> 0x01d7 }
            com.google.android.gms.internal.ads.zzaru r6 = new com.google.android.gms.internal.ads.zzaru     // Catch:{ all -> 0x01d7 }
            r6.<init>(r3, r2, r0)     // Catch:{ all -> 0x01d7 }
        L_0x01d3:
            r13.zzi(r1)
            return r6
        L_0x01d7:
            r0 = move-exception
            goto L_0x02c9
        L_0x01da:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r0
            int r7 = zzc     // Catch:{ all -> 0x01d7 }
            if (r2 != r7) goto L_0x0220
            int r2 = r13.zzr()     // Catch:{ all -> 0x01d7 }
            int r4 = r13.zzr()     // Catch:{ all -> 0x01d7 }
            int r7 = com.google.android.gms.internal.ads.zzaqg.zzaH     // Catch:{ all -> 0x01d7 }
            if (r4 != r7) goto L_0x01ff
            r0 = 8
            r13.zzj(r0)     // Catch:{ all -> 0x01d7 }
            int r2 = r2 + -16
            java.lang.String r0 = r13.zzw(r2)     // Catch:{ all -> 0x01d7 }
            com.google.android.gms.internal.ads.zzaru r6 = new com.google.android.gms.internal.ads.zzaru     // Catch:{ all -> 0x01d7 }
            r6.<init>(r3, r0, r0)     // Catch:{ all -> 0x01d7 }
            goto L_0x021c
        L_0x01ff:
            java.lang.String r2 = "Failed to parse comment attribute: "
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaqg.zzg(r0)     // Catch:{ all -> 0x01d7 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01d7 }
            int r3 = r0.length()     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x0214
            java.lang.String r0 = r2.concat(r0)     // Catch:{ all -> 0x01d7 }
            goto L_0x0219
        L_0x0214:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x01d7 }
            r0.<init>(r2)     // Catch:{ all -> 0x01d7 }
        L_0x0219:
            android.util.Log.w(r5, r0)     // Catch:{ all -> 0x01d7 }
        L_0x021c:
            r13.zzi(r1)
            return r6
        L_0x0220:
            int r3 = zza     // Catch:{ all -> 0x01d7 }
            if (r2 == r3) goto L_0x02bf
            int r3 = zzb     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x022a
            goto L_0x02bf
        L_0x022a:
            int r3 = zzh     // Catch:{ all -> 0x01d7 }
            if (r2 == r3) goto L_0x02b5
            int r3 = zzi     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x0234
            goto L_0x02b5
        L_0x0234:
            int r3 = zzd     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x0242
            java.lang.String r2 = "TDRC"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0242:
            int r3 = zze     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x0250
            java.lang.String r2 = "TPE1"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0250:
            int r3 = zzf     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x025e
            java.lang.String r2 = "TSSE"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x025e:
            int r3 = zzg     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x026c
            java.lang.String r2 = "TALB"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x026c:
            int r3 = zzj     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x027a
            java.lang.String r2 = "USLT"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x027a:
            int r3 = zzk     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x0286
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r4, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0286:
            int r3 = zzn     // Catch:{ all -> 0x01d7 }
            if (r2 != r3) goto L_0x0294
            java.lang.String r2 = "TIT1"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x0294:
            java.lang.String r2 = "Skipped unknown metadata entry: "
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaqg.zzg(r0)     // Catch:{ all -> 0x01d7 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x01d7 }
            int r3 = r0.length()     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x02a9
            java.lang.String r0 = r2.concat(r0)     // Catch:{ all -> 0x01d7 }
            goto L_0x02ae
        L_0x02a9:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x01d7 }
            r0.<init>(r2)     // Catch:{ all -> 0x01d7 }
        L_0x02ae:
            android.util.Log.d(r5, r0)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r6
        L_0x02b5:
            java.lang.String r2 = "TCOM"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x02bf:
            java.lang.String r2 = "TIT2"
            com.google.android.gms.internal.ads.zzary r0 = zzb(r0, r2, r13)     // Catch:{ all -> 0x01d7 }
            r13.zzi(r1)
            return r0
        L_0x02c9:
            r13.zzi(r1)
            goto L_0x02ce
        L_0x02cd:
            throw r0
        L_0x02ce:
            goto L_0x02cd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqt.zza(com.google.android.gms.internal.ads.zzaut):com.google.android.gms.internal.ads.zzarp");
    }

    public static zzary zzb(int i, String str, zzaut zzaut) {
        int zzr2 = zzaut.zzr();
        if (zzaut.zzr() == zzaqg.zzaH) {
            zzaut.zzj(8);
            return new zzary(str, (String) null, zzaut.zzw(zzr2 - 16));
        }
        String valueOf = String.valueOf(zzaqg.zzg(i));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    public static zzarw zzc(int i, String str, zzaut zzaut, boolean z, boolean z2) {
        int zze2 = zze(zzaut);
        if (z2) {
            zze2 = Math.min(1, zze2);
        }
        if (zze2 < 0) {
            String valueOf = String.valueOf(zzaqg.zzg(i));
            Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
            return null;
        } else if (z) {
            return new zzary(str, (String) null, Integer.toString(zze2));
        } else {
            return new zzaru("und", str, Integer.toString(zze2));
        }
    }

    public static zzary zzd(int i, String str, zzaut zzaut) {
        int zzr2 = zzaut.zzr();
        if (zzaut.zzr() == zzaqg.zzaH && zzr2 >= 22) {
            zzaut.zzj(10);
            int zzm2 = zzaut.zzm();
            if (zzm2 > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(zzm2);
                String sb2 = sb.toString();
                int zzm3 = zzaut.zzm();
                if (zzm3 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(zzm3);
                    sb2 = sb3.toString();
                }
                return new zzary(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzaqg.zzg(i));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    public static int zze(zzaut zzaut) {
        zzaut.zzj(4);
        if (zzaut.zzr() == zzaqg.zzaH) {
            zzaut.zzj(8);
            return zzaut.zzl();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
