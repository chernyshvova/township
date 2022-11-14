package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeye {
    public final zzcdw zzA;
    public final String zzB;
    public final JSONObject zzC;
    public final JSONObject zzD;
    public final String zzE;
    public final boolean zzF;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final int zzM;
    public final int zzN;
    public final boolean zzO;
    public final String zzP;
    public final zzeyz zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final int zzT;
    public final String zzU;
    public final int zzV;
    public final String zzW;
    public final boolean zzX;
    public final zzbzx zzY;
    public final boolean zzZ;
    public final List<String> zza;
    @Nullable
    public final zzbdr zzaa;
    public final String zzab;
    public final boolean zzac;
    public final JSONObject zzad;
    public final boolean zzae;
    public final JSONObject zzaf;
    public final boolean zzag;
    @Nullable
    public final String zzah;
    public final boolean zzai;
    public final int zzb;
    public final List<String> zzc;
    public final List<String> zzd;
    public final List<String> zze;
    public final int zzf;
    public final List<String> zzg;
    public final List<String> zzh;
    public final List<String> zzi;
    public final List<String> zzj;
    public final String zzk;
    public final String zzl;
    @Nullable
    public final zzccm zzm;
    public final List<String> zzn;
    public final List<String> zzo;
    public final List<String> zzp;
    public final int zzq;
    public final List<zzeyf> zzr;
    @Nullable
    public final zzeyj zzs;
    public final List<String> zzt;
    public final List<zzeyf> zzu;
    public final JSONObject zzv;
    public final String zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzeye(android.util.JsonReader r70) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r69 = this;
            r0 = r69
            r69.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            com.google.android.gms.internal.ads.zzfml r20 = com.google.android.gms.internal.ads.zzfml.zzi()
            r70.beginObject()
            r21 = 1
            r22 = -1
            r23 = 0
            java.lang.String r24 = ""
            r25 = 0
            r26 = r16
            r27 = r17
            r28 = r18
            r29 = r19
            r30 = r20
            r20 = r23
            r31 = r20
            r32 = r31
            r33 = r32
            r34 = r33
            r36 = r24
            r37 = r36
            r38 = r37
            r39 = r38
            r40 = r39
            r51 = r40
            r55 = r51
            r57 = r55
            r60 = r57
            r62 = r60
            r35 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = -1
            r49 = 0
            r50 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r56 = -1
            r58 = 0
            r59 = 1
            r61 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r19 = r12
            r18 = r13
            r17 = r14
            r16 = r15
            r15 = r34
            r14 = r62
            r12 = 0
            r13 = 0
            r23 = r11
            r11 = r14
        L_0x00ce:
            boolean r66 = r70.hasNext()
            if (r66 == 0) goto L_0x072b
            java.lang.String r66 = r70.nextName()
            if (r66 != 0) goto L_0x00dd
            r67 = r24
            goto L_0x00df
        L_0x00dd:
            r67 = r66
        L_0x00df:
            int r66 = r67.hashCode()
            switch(r66) {
                case -1980587809: goto L_0x0529;
                case -1965512151: goto L_0x0518;
                case -1812055556: goto L_0x0507;
                case -1662989631: goto L_0x04f6;
                case -1620470467: goto L_0x04e5;
                case -1440104884: goto L_0x04d4;
                case -1439500848: goto L_0x04c2;
                case -1428969291: goto L_0x04b0;
                case -1403779768: goto L_0x049e;
                case -1375413093: goto L_0x048c;
                case -1360811658: goto L_0x047a;
                case -1306015996: goto L_0x0468;
                case -1303332046: goto L_0x0456;
                case -1289032093: goto L_0x0444;
                case -1240082064: goto L_0x0432;
                case -1234181075: goto L_0x0420;
                case -1168140544: goto L_0x040e;
                case -1152230954: goto L_0x03fd;
                case -1146534047: goto L_0x03eb;
                case -1115838944: goto L_0x03d9;
                case -1081936678: goto L_0x03c7;
                case -1078050970: goto L_0x03b5;
                case -1051269058: goto L_0x03a3;
                case -982608540: goto L_0x0391;
                case -776859333: goto L_0x0380;
                case -544216775: goto L_0x036e;
                case -437057161: goto L_0x035d;
                case -404433734: goto L_0x034b;
                case -404326515: goto L_0x0339;
                case -397704715: goto L_0x0327;
                case -388807511: goto L_0x0315;
                case -369773488: goto L_0x0303;
                case -213449460: goto L_0x02f1;
                case -213424028: goto L_0x02df;
                case -180214626: goto L_0x02cd;
                case -154616268: goto L_0x02bb;
                case -29338502: goto L_0x02a9;
                case 3107: goto L_0x0297;
                case 3355: goto L_0x0285;
                case 3076010: goto L_0x0273;
                case 63195984: goto L_0x0261;
                case 107433883: goto L_0x024f;
                case 230323073: goto L_0x023e;
                case 418392395: goto L_0x022c;
                case 549176928: goto L_0x021a;
                case 597473788: goto L_0x0208;
                case 673261304: goto L_0x01f7;
                case 754887508: goto L_0x01e5;
                case 791122864: goto L_0x01d4;
                case 1010584092: goto L_0x01c2;
                case 1100650276: goto L_0x01b0;
                case 1186014765: goto L_0x019e;
                case 1321720943: goto L_0x018c;
                case 1637553475: goto L_0x017a;
                case 1638957285: goto L_0x0169;
                case 1686319423: goto L_0x0157;
                case 1688341040: goto L_0x0145;
                case 1799285870: goto L_0x0133;
                case 1839650832: goto L_0x0122;
                case 1875425491: goto L_0x0110;
                case 2068142375: goto L_0x00fe;
                case 2072888499: goto L_0x00ec;
                default: goto L_0x00e6;
            }
        L_0x00e6:
            r68 = r9
            r66 = r10
            goto L_0x053a
        L_0x00ec:
            r66 = r10
            java.lang.String r10 = "manual_tracking_urls"
            r68 = r9
            r9 = r67
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 15
            goto L_0x053b
        L_0x00fe:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "rule_line_external_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 52
            goto L_0x053b
        L_0x0110:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "is_analytics_logging_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 42
            goto L_0x053b
        L_0x0122:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "renderers"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 0
            goto L_0x053b
        L_0x0133:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "use_third_party_container_height"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 48
            goto L_0x053b
        L_0x0145:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "video_reward_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 8
            goto L_0x053b
        L_0x0157:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad_network_class_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 55
            goto L_0x053b
        L_0x0169:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "video_start_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 6
            goto L_0x053b
        L_0x017a:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "bid_response"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 40
            goto L_0x053b
        L_0x018c:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "allow_pub_owned_ad_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 31
            goto L_0x053b
        L_0x019e:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "cache_hit_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 61
            goto L_0x053b
        L_0x01b0:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "rewards"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 12
            goto L_0x053b
        L_0x01c2:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "transaction_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 10
            goto L_0x053b
        L_0x01d4:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 5
            goto L_0x053b
        L_0x01e5:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "container_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 17
            goto L_0x053b
        L_0x01f7:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "reward_granted_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 7
            goto L_0x053b
        L_0x0208:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "debug_dialog_string"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 27
            goto L_0x053b
        L_0x021a:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "presentation_error_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 16
            goto L_0x053b
        L_0x022c:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "is_closable_area_disabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 36
            goto L_0x053b
        L_0x023e:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 4
            goto L_0x053b
        L_0x024f:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "qdata"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 24
            goto L_0x053b
        L_0x0261:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "render_test_label"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 33
            goto L_0x053b
        L_0x0273:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 22
            goto L_0x053b
        L_0x0285:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 23
            goto L_0x053b
        L_0x0297:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 18
            goto L_0x053b
        L_0x02a9:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "allow_custom_click_gesture"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 32
            goto L_0x053b
        L_0x02bb:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "is_offline_ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 56
            goto L_0x053b
        L_0x02cd:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "native_required_asset_viewability"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 58
            goto L_0x053b
        L_0x02df:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "watermark"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 46
            goto L_0x053b
        L_0x02f1:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "force_disable_hardware_acceleration"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 60
            goto L_0x053b
        L_0x0303:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "is_close_button_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 50
            goto L_0x053b
        L_0x0315:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "content_url"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 59
            goto L_0x053b
        L_0x0327:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad_close_time_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 45
            goto L_0x053b
        L_0x0339:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "render_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 38
            goto L_0x053b
        L_0x034b:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "rtb_native_required_assets"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 57
            goto L_0x053b
        L_0x035d:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "imp_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 3
            goto L_0x053b
        L_0x036e:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "safe_browsing"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 26
            goto L_0x053b
        L_0x0380:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "click_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 2
            goto L_0x053b
        L_0x0391:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "valid_from_timestamp"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 11
            goto L_0x053b
        L_0x03a3:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "active_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 25
            goto L_0x053b
        L_0x03b5:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "video_complete_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 9
            goto L_0x053b
        L_0x03c7:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "allocation_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 21
            goto L_0x053b
        L_0x03d9:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "fill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 13
            goto L_0x053b
        L_0x03eb:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "is_scroll_aware"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 43
            goto L_0x053b
        L_0x03fd:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 1
            goto L_0x053b
        L_0x040e:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "presentation_error_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 14
            goto L_0x053b
        L_0x0420:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "allow_pub_rendered_attribution"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 30
            goto L_0x053b
        L_0x0432:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad_event_value"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 51
            goto L_0x053b
        L_0x0444:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "extras"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 29
            goto L_0x053b
        L_0x0456:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "test_mode_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 34
            goto L_0x053b
        L_0x0468:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "adapters"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 20
            goto L_0x053b
        L_0x047a:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 19
            goto L_0x053b
        L_0x048c:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "ad_cover"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 54
            goto L_0x053b
        L_0x049e:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "showable_impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 44
            goto L_0x053b
        L_0x04b0:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "enable_omid"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 39
            goto L_0x053b
        L_0x04c2:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "orientation"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 37
            goto L_0x053b
        L_0x04d4:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "is_custom_close_blocked"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 35
            goto L_0x053b
        L_0x04e5:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "backend_query_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 47
            goto L_0x053b
        L_0x04f6:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "is_interscroller"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 53
            goto L_0x053b
        L_0x0507:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "play_prewarm_options"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 49
            goto L_0x053b
        L_0x0518:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "omid_settings"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 41
            goto L_0x053b
        L_0x0529:
            r68 = r9
            r66 = r10
            r9 = r67
            java.lang.String r10 = "debug_signals"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x053a
            r9 = 28
            goto L_0x053b
        L_0x053a:
            r9 = -1
        L_0x053b:
            switch(r9) {
                case 0: goto L_0x071f;
                case 1: goto L_0x0714;
                case 2: goto L_0x070d;
                case 3: goto L_0x0706;
                case 4: goto L_0x06ff;
                case 5: goto L_0x06f4;
                case 6: goto L_0x06ed;
                case 7: goto L_0x06e7;
                case 8: goto L_0x06e0;
                case 9: goto L_0x06d9;
                case 10: goto L_0x06d2;
                case 11: goto L_0x06cb;
                case 12: goto L_0x06bf;
                case 13: goto L_0x06b7;
                case 14: goto L_0x06af;
                case 15: goto L_0x06a5;
                case 16: goto L_0x069d;
                case 17: goto L_0x0693;
                case 18: goto L_0x0688;
                case 19: goto L_0x067e;
                case 20: goto L_0x0674;
                case 21: goto L_0x066c;
                case 22: goto L_0x0662;
                case 23: goto L_0x065d;
                case 24: goto L_0x0658;
                case 25: goto L_0x064f;
                case 26: goto L_0x0641;
                case 27: goto L_0x063c;
                case 28: goto L_0x0632;
                case 29: goto L_0x0628;
                case 30: goto L_0x0623;
                case 31: goto L_0x061e;
                case 32: goto L_0x0619;
                case 33: goto L_0x0614;
                case 34: goto L_0x060f;
                case 35: goto L_0x0609;
                case 36: goto L_0x0603;
                case 37: goto L_0x05f9;
                case 38: goto L_0x05f3;
                case 39: goto L_0x05ed;
                case 40: goto L_0x05e7;
                case 41: goto L_0x05dd;
                case 42: goto L_0x05d7;
                case 43: goto L_0x05d1;
                case 44: goto L_0x05cb;
                case 45: goto L_0x05c5;
                case 46: goto L_0x05bf;
                case 47: goto L_0x05b9;
                case 48: goto L_0x05b3;
                case 49: goto L_0x05a5;
                case 50: goto L_0x059f;
                case 51: goto L_0x0591;
                case 52: goto L_0x058b;
                case 53: goto L_0x0585;
                case 54: goto L_0x057b;
                case 55: goto L_0x0575;
                case 56: goto L_0x056f;
                case 57: goto L_0x0565;
                case 58: goto L_0x055f;
                case 59: goto L_0x0555;
                case 60: goto L_0x054f;
                case 61: goto L_0x0545;
                default: goto L_0x053e;
            }
        L_0x053e:
            r10 = r70
            r70.skipValue()
            goto L_0x0725
        L_0x0545:
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            r10 = r70
            r30 = r9
            goto L_0x0725
        L_0x054f:
            boolean r65 = r70.nextBoolean()
            goto L_0x0670
        L_0x0555:
            java.lang.String r9 = r70.nextString()
            r10 = r70
            r34 = r9
            goto L_0x0725
        L_0x055f:
            boolean r64 = r70.nextBoolean()
            goto L_0x0670
        L_0x0565:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            r10 = r70
            r29 = r9
            goto L_0x0725
        L_0x056f:
            boolean r63 = r70.nextBoolean()
            goto L_0x0670
        L_0x0575:
            java.lang.String r62 = r70.nextString()
            goto L_0x0670
        L_0x057b:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            r10 = r70
            r28 = r9
            goto L_0x0725
        L_0x0585:
            boolean r61 = r70.nextBoolean()
            goto L_0x0670
        L_0x058b:
            java.lang.String r60 = r70.nextString()
            goto L_0x0670
        L_0x0591:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            com.google.android.gms.internal.ads.zzbdr r9 = com.google.android.gms.internal.ads.zzbdr.zza(r9)
            r10 = r70
            r33 = r9
            goto L_0x0725
        L_0x059f:
            boolean r59 = r70.nextBoolean()
            goto L_0x0670
        L_0x05a5:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            com.google.android.gms.internal.ads.zzbzx r9 = com.google.android.gms.internal.ads.zzbzx.zza(r9)
            r10 = r70
            r32 = r9
            goto L_0x0725
        L_0x05b3:
            boolean r58 = r70.nextBoolean()
            goto L_0x0670
        L_0x05b9:
            java.lang.String r57 = r70.nextString()
            goto L_0x0670
        L_0x05bf:
            java.lang.String r55 = r70.nextString()
            goto L_0x0670
        L_0x05c5:
            int r56 = r70.nextInt()
            goto L_0x0670
        L_0x05cb:
            int r54 = r70.nextInt()
            goto L_0x0670
        L_0x05d1:
            boolean r53 = r70.nextBoolean()
            goto L_0x0670
        L_0x05d7:
            boolean r52 = r70.nextBoolean()
            goto L_0x0670
        L_0x05dd:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            r10 = r70
            r27 = r9
            goto L_0x0725
        L_0x05e7:
            java.lang.String r51 = r70.nextString()
            goto L_0x0670
        L_0x05ed:
            boolean r50 = r70.nextBoolean()
            goto L_0x0670
        L_0x05f3:
            int r49 = r70.nextInt()
            goto L_0x0670
        L_0x05f9:
            java.lang.String r9 = r70.nextString()
            int r48 = zzd(r9)
            goto L_0x0670
        L_0x0603:
            boolean r47 = r70.nextBoolean()
            goto L_0x0670
        L_0x0609:
            boolean r46 = r70.nextBoolean()
            goto L_0x0670
        L_0x060f:
            boolean r45 = r70.nextBoolean()
            goto L_0x0670
        L_0x0614:
            boolean r44 = r70.nextBoolean()
            goto L_0x0670
        L_0x0619:
            boolean r43 = r70.nextBoolean()
            goto L_0x0670
        L_0x061e:
            boolean r42 = r70.nextBoolean()
            goto L_0x0670
        L_0x0623:
            boolean r41 = r70.nextBoolean()
            goto L_0x0670
        L_0x0628:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            r10 = r70
            r26 = r9
            goto L_0x0725
        L_0x0632:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            r10 = r70
            r16 = r9
            goto L_0x0725
        L_0x063c:
            java.lang.String r40 = r70.nextString()
            goto L_0x0670
        L_0x0641:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            com.google.android.gms.internal.ads.zzcdw r9 = com.google.android.gms.internal.ads.zzcdw.zza(r9)
            r10 = r70
            r31 = r9
            goto L_0x0725
        L_0x064f:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            java.lang.String r39 = r9.toString()
            goto L_0x0670
        L_0x0658:
            java.lang.String r38 = r70.nextString()
            goto L_0x0670
        L_0x065d:
            java.lang.String r37 = r70.nextString()
            goto L_0x0670
        L_0x0662:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbv.zzc(r70)
            r10 = r70
            r17 = r9
            goto L_0x0725
        L_0x066c:
            java.lang.String r36 = r70.nextString()
        L_0x0670:
            r10 = r70
            goto L_0x0725
        L_0x0674:
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            r10 = r70
            r19 = r9
            goto L_0x0725
        L_0x067e:
            java.util.List r9 = com.google.android.gms.internal.ads.zzeyf.zza(r70)
            r10 = r70
            r18 = r9
            goto L_0x0725
        L_0x0688:
            com.google.android.gms.internal.ads.zzeyj r9 = new com.google.android.gms.internal.ads.zzeyj
            r10 = r70
            r9.<init>(r10)
            r20 = r9
            goto L_0x0725
        L_0x0693:
            r10 = r70
            java.util.List r9 = com.google.android.gms.internal.ads.zzeyf.zza(r70)
            r23 = r9
            goto L_0x0725
        L_0x069d:
            r10 = r70
            int r35 = r70.nextInt()
            goto L_0x0725
        L_0x06a5:
            r10 = r70
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            r66 = r9
            goto L_0x0725
        L_0x06af:
            r10 = r70
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0727
        L_0x06b7:
            r10 = r70
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x06bf:
            r10 = r70
            org.json.JSONArray r9 = com.google.android.gms.ads.internal.util.zzbv.zzd(r70)
            com.google.android.gms.internal.ads.zzccm r9 = com.google.android.gms.internal.ads.zzccm.zza(r9)
            r15 = r9
            goto L_0x0725
        L_0x06cb:
            r10 = r70
            java.lang.String r11 = r70.nextString()
            goto L_0x0725
        L_0x06d2:
            r10 = r70
            java.lang.String r14 = r70.nextString()
            goto L_0x0725
        L_0x06d9:
            r10 = r70
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x06e0:
            r10 = r70
            java.util.List r6 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x06e7:
            r10 = r70
            com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x06ed:
            r10 = r70
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x06f4:
            r10 = r70
            int r9 = r70.nextInt()
            int r12 = zzc(r9)
            goto L_0x0725
        L_0x06ff:
            r10 = r70
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x0706:
            r10 = r70
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x070d:
            r10 = r70
            java.util.List r2 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
            goto L_0x0725
        L_0x0714:
            r10 = r70
            java.lang.String r9 = r70.nextString()
            int r13 = zzb(r9)
            goto L_0x0725
        L_0x071f:
            r10 = r70
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzbv.zzb(r70)
        L_0x0725:
            r9 = r68
        L_0x0727:
            r10 = r66
            goto L_0x00ce
        L_0x072b:
            r68 = r9
            r66 = r10
            r10 = r70
            r70.endObject()
            r0.zza = r1
            r0.zzb = r13
            r0.zzc = r2
            r0.zzd = r3
            r0.zzg = r4
            r0.zzf = r12
            r0.zzh = r5
            r0.zzi = r6
            r0.zzj = r7
            r0.zzk = r14
            r0.zzl = r11
            r0.zzm = r15
            r0.zzn = r8
            r0.zzo = r9
            r10 = r66
            r0.zzp = r10
            r1 = r35
            r0.zzq = r1
            r11 = r23
            r0.zzr = r11
            r1 = r20
            r0.zzs = r1
            r12 = r19
            r0.zzt = r12
            r13 = r18
            r0.zzu = r13
            r1 = r36
            r0.zzw = r1
            r14 = r17
            r0.zzv = r14
            r1 = r37
            r0.zzx = r1
            r1 = r38
            r0.zzy = r1
            r1 = r39
            r0.zzz = r1
            r1 = r31
            r0.zzA = r1
            r1 = r40
            r0.zzB = r1
            r15 = r16
            r0.zzC = r15
            r1 = r26
            r0.zzD = r1
            r1 = r41
            r0.zzF = r1
            r1 = r42
            r0.zzG = r1
            r1 = r43
            r0.zzH = r1
            r1 = r44
            r0.zzI = r1
            r1 = r45
            r0.zzJ = r1
            r1 = r46
            r0.zzK = r1
            r1 = r47
            r0.zzL = r1
            r1 = r48
            r0.zzM = r1
            r1 = r49
            r0.zzN = r1
            r1 = r50
            r0.zzO = r1
            r1 = r51
            r0.zzP = r1
            com.google.android.gms.internal.ads.zzeyz r1 = new com.google.android.gms.internal.ads.zzeyz
            r2 = r27
            r1.<init>(r2)
            r0.zzQ = r1
            r1 = r52
            r0.zzR = r1
            r1 = r53
            r0.zzS = r1
            r1 = r54
            r0.zzT = r1
            r1 = r55
            r0.zzU = r1
            r1 = r56
            r0.zzV = r1
            r1 = r57
            r0.zzW = r1
            r1 = r58
            r0.zzX = r1
            r1 = r32
            r0.zzY = r1
            r1 = r59
            r0.zzZ = r1
            r1 = r33
            r0.zzaa = r1
            r1 = r60
            r0.zzab = r1
            r1 = r61
            r0.zzac = r1
            r1 = r28
            r0.zzad = r1
            r1 = r62
            r0.zzE = r1
            r1 = r63
            r0.zzae = r1
            r1 = r29
            r0.zzaf = r1
            r1 = r64
            r0.zzag = r1
            r1 = r34
            r0.zzah = r1
            r1 = r65
            r0.zzai = r1
            r1 = r30
            r0.zze = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeye.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    public static int zzb(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if (AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    public static int zzc(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return 0;
    }

    public static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }
}
