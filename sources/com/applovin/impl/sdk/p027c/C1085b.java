package com.applovin.impl.sdk.p027c;

import android.net.Uri;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.p007a.C0648m;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.playrix.engine.VideoPlayer;
import com.unity3d.services.banners.UnityBannerSize;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.c.b */
public class C1085b<T> implements Comparable {

    /* renamed from: a */
    public static final List<?> f1544a;

    /* renamed from: aA */
    public static final C1085b<Long> f1545aA = m1648a("consent_dialog_show_from_alert_delay_ms", 450L);

    /* renamed from: aB */
    public static final C1085b<Boolean> f1546aB = m1648a("alert_consent_for_dialog_rejected", Boolean.FALSE);

    /* renamed from: aC */
    public static final C1085b<Boolean> f1547aC = m1648a("alert_consent_for_dialog_closed", Boolean.FALSE);

    /* renamed from: aD */
    public static final C1085b<Boolean> f1548aD = m1648a("alert_consent_for_dialog_closed_with_back_button", Boolean.FALSE);

    /* renamed from: aE */
    public static final C1085b<Boolean> f1549aE = m1648a("alert_consent_after_init", Boolean.FALSE);

    /* renamed from: aF */
    public static final C1085b<Long> f1550aF = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 5, "alert_consent_after_init_interval_ms");

    /* renamed from: aG */
    public static final C1085b<Long> f1551aG = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 30, "alert_consent_after_dialog_rejection_interval_ms");

    /* renamed from: aH */
    public static final C1085b<Long> f1552aH = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 5, "alert_consent_after_dialog_close_interval_ms");

    /* renamed from: aI */
    public static final C1085b<Long> f1553aI = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 5, "alert_consent_after_dialog_close_with_back_button_interval_ms");

    /* renamed from: aJ */
    public static final C1085b<Long> f1554aJ = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 10, "alert_consent_after_cancel_interval_ms");

    /* renamed from: aK */
    public static final C1085b<Long> f1555aK = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 5, "alert_consent_reschedule_interval_ms");

    /* renamed from: aL */
    public static final C1085b<String> f1556aL = m1648a("text_alert_consent_title", "Make this App Better and Stay Free!");

    /* renamed from: aM */
    public static final C1085b<String> f1557aM = m1648a("text_alert_consent_body", "If you don't give us consent to use your data, you will be making our ability to support this app harder, which may negatively affect the user experience.");

    /* renamed from: aN */
    public static final C1085b<String> f1558aN = m1648a("text_alert_consent_yes_option", "I Agree");

    /* renamed from: aO */
    public static final C1085b<String> f1559aO = m1648a("text_alert_consent_no_option", "Cancel");

    /* renamed from: aP */
    public static final C1085b<Long> f1560aP = GeneratedOutlineSupport.outline7(TimeUnit.SECONDS, 1, "ttc_max_click_duration_ms");

    /* renamed from: aQ */
    public static final C1085b<Integer> f1561aQ = m1648a("ttc_max_click_distance_dp", 10);

    /* renamed from: aR */
    public static final C1085b<Integer> f1562aR = m1648a("ttc_acrsv2a", 1);

    /* renamed from: aS */
    public static final C1085b<Integer> f1563aS = m1648a("ttc_acrsnmv", 1);

    /* renamed from: aT */
    public static final C1085b<Integer> f1564aT = m1648a("ttc_edge_buffer_dp", 0);

    /* renamed from: aU */
    public static final C1085b<String> f1565aU = m1648a("whitelisted_postback_endpoints", "https://prod-a.applovin.com,https://rt.applovin.com/4.0/pix, https://rt.applvn.com/4.0/pix,https://ms.applovin.com/,https://ms.applvn.com/");

    /* renamed from: aV */
    public static final C1085b<String> f1566aV = m1648a("fetch_settings_endpoint", "https://ms.applovin.com/");

    /* renamed from: aW */
    public static final C1085b<String> f1567aW = m1648a("fetch_settings_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: aX */
    public static final C1085b<String> f1568aX = m1648a("adserver_endpoint", "https://a.applovin.com/");

    /* renamed from: aY */
    public static final C1085b<String> f1569aY = m1648a("adserver_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: aZ */
    public static final C1085b<String> f1570aZ = m1648a("api_endpoint", "https://d.applovin.com/");

    /* renamed from: ac */
    public static final C1085b<Boolean> f1571ac = m1648a("is_disabled", Boolean.FALSE);

    /* renamed from: ad */
    public static final C1085b<String> f1572ad = m1648a("device_id", "");

    /* renamed from: ae */
    public static final C1085b<Boolean> f1573ae = m1648a("rss", Boolean.TRUE);

    /* renamed from: af */
    public static final C1085b<String> f1574af = m1648a("device_token", "");

    /* renamed from: ag */
    public static final C1085b<Long> f1575ag = m1648a("publisher_id", 0L);

    /* renamed from: ah */
    public static final C1085b<Boolean> f1576ah = m1648a("is_verbose_logging", Boolean.FALSE);

    /* renamed from: ai */
    public static final C1085b<String> f1577ai = m1648a("sc", "");

    /* renamed from: aj */
    public static final C1085b<String> f1578aj = m1648a("sc2", "");

    /* renamed from: ak */
    public static final C1085b<String> f1579ak = m1648a("sc3", "");

    /* renamed from: al */
    public static final C1085b<String> f1580al = m1648a("server_installed_at", "");

    /* renamed from: am */
    public static final C1085b<Boolean> f1581am = m1648a("track_network_response_codes", Boolean.FALSE);

    /* renamed from: an */
    public static final C1085b<Boolean> f1582an = m1648a("submit_network_response_codes", Boolean.FALSE);

    /* renamed from: ao */
    public static final C1085b<Boolean> f1583ao = m1648a("clear_network_response_codes_on_request", Boolean.TRUE);

    /* renamed from: ap */
    public static final C1085b<Boolean> f1584ap = m1648a("clear_completion_callback_on_failure", Boolean.FALSE);

    /* renamed from: aq */
    public static final C1085b<Long> f1585aq = m1648a("sicd_ms", 0L);

    /* renamed from: ar */
    public static final C1085b<Integer> f1586ar = m1648a("logcat_max_line_size", 1000);

    /* renamed from: as */
    public static final C1085b<Integer> f1587as = m1648a("stps", 16);

    /* renamed from: at */
    public static final C1085b<Boolean> f1588at = m1648a("ustp", Boolean.FALSE);

    /* renamed from: au */
    public static final C1085b<Boolean> f1589au = m1648a("exception_handler_enabled", Boolean.TRUE);

    /* renamed from: av */
    public static final C1085b<Boolean> f1590av = m1648a("init_omsdk", Boolean.TRUE);

    /* renamed from: aw */
    public static final C1085b<String> f1591aw = m1648a("omsdk_partner_name", AppLovinNativeAdImpl.AD_RESPONSE_TYPE_APPLOVIN);

    /* renamed from: ax */
    public static final C1085b<Boolean> f1592ax = m1648a("publisher_can_show_consent_dialog", Boolean.TRUE);

    /* renamed from: ay */
    public static final C1085b<String> f1593ay = m1648a("consent_dialog_url", "https://assets.applovin.com/gdpr/flow_v1/gdpr-flow-1.html");

    /* renamed from: az */
    public static final C1085b<Boolean> f1594az = m1648a("consent_dialog_immersive_mode_on", Boolean.FALSE);

    /* renamed from: b */
    public static final Map<String, C1085b<?>> f1595b = new HashMap(512);

    /* renamed from: bA */
    public static final C1085b<String> f1596bA = m1648a("text_incent_warning_title", "Attention!");

    /* renamed from: bB */
    public static final C1085b<String> f1597bB = m1648a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");

    /* renamed from: bC */
    public static final C1085b<String> f1598bC = m1648a("text_incent_warning_close_option", "Close");

    /* renamed from: bD */
    public static final C1085b<String> f1599bD = m1648a("text_incent_warning_continue_option", "Keep Watching");

    /* renamed from: bE */
    public static final C1085b<Boolean> f1600bE = m1648a("incent_nonvideo_warning_enabled", Boolean.FALSE);

    /* renamed from: bF */
    public static final C1085b<String> f1601bF = m1648a("text_incent_nonvideo_warning_title", "Attention!");

    /* renamed from: bG */
    public static final C1085b<String> f1602bG = m1648a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");

    /* renamed from: bH */
    public static final C1085b<String> f1603bH = m1648a("text_incent_nonvideo_warning_close_option", "Close");

    /* renamed from: bI */
    public static final C1085b<String> f1604bI = m1648a("text_incent_nonvideo_warning_continue_option", "Keep Playing");

    /* renamed from: bJ */
    public static final C1085b<Boolean> f1605bJ = m1648a("check_webview_has_gesture", Boolean.FALSE);

    /* renamed from: bK */
    public static final C1085b<Integer> f1606bK = m1648a("close_button_touch_area", 0);

    /* renamed from: bL */
    public static final C1085b<Integer> f1607bL = m1648a("close_button_outside_touch_area", 0);

    /* renamed from: bM */
    public static final C1085b<Boolean> f1608bM = m1648a("creative_debugger_enabled", Boolean.FALSE);

    /* renamed from: bN */
    public static final C1085b<Long> f1609bN = GeneratedOutlineSupport.outline7(TimeUnit.SECONDS, 1, "viewability_adview_imp_delay_ms");

    /* renamed from: bO */
    public static final C1085b<Integer> f1610bO = m1648a("viewability_adview_banner_min_width", Integer.valueOf(UnityBannerSize.BannerSize.STANDARD_WIDTH));

    /* renamed from: bP */
    public static final C1085b<Integer> f1611bP = m1648a("viewability_adview_banner_min_height", Integer.valueOf(AppLovinAdSize.BANNER.getHeight()));

    /* renamed from: bQ */
    public static final C1085b<Integer> f1612bQ = m1648a("viewability_adview_mrec_min_width", Integer.valueOf(MaxAdFormat.MREC.getSize().getWidth()));

    /* renamed from: bR */
    public static final C1085b<Integer> f1613bR = m1648a("viewability_adview_mrec_min_height", Integer.valueOf(MaxAdFormat.MREC.getSize().getHeight()));

    /* renamed from: bS */
    public static final C1085b<Integer> f1614bS = m1648a("viewability_adview_leader_min_width", Integer.valueOf(UnityBannerSize.BannerSize.LEADERBOARD_WIDTH));

    /* renamed from: bT */
    public static final C1085b<Integer> f1615bT = m1648a("viewability_adview_leader_min_height", Integer.valueOf(AppLovinAdSize.LEADER.getHeight()));

    /* renamed from: bU */
    public static final C1085b<Integer> f1616bU = m1648a("viewability_adview_native_min_width", 0);

    /* renamed from: bV */
    public static final C1085b<Integer> f1617bV = m1648a("viewability_adview_native_min_height", 0);

    /* renamed from: bW */
    public static final C1085b<Float> f1618bW = m1648a("viewability_adview_min_alpha", Float.valueOf(10.0f));

    /* renamed from: bX */
    public static final C1085b<Long> f1619bX = GeneratedOutlineSupport.outline7(TimeUnit.SECONDS, 1, "viewability_timer_min_visible_ms");

    /* renamed from: bY */
    public static final C1085b<Long> f1620bY = m1648a("viewability_timer_interval_ms", 100L);

    /* renamed from: bZ */
    public static final C1085b<Integer> f1621bZ = m1648a("expandable_close_button_size", 27);

    /* renamed from: ba */
    public static final C1085b<String> f1622ba = m1648a("api_backup_endpoint", "https://d.applvn.com/");

    /* renamed from: bb */
    public static final C1085b<String> f1623bb = m1648a("event_tracking_endpoint_v2", "https://rt.applovin.com/");

    /* renamed from: bc */
    public static final C1085b<String> f1624bc = m1648a("event_tracking_backup_endpoint_v2", "https://rt.applvn.com/");

    /* renamed from: bd */
    public static final C1085b<String> f1625bd = m1648a("fetch_variables_endpoint", "https://ms.applovin.com/");

    /* renamed from: be */
    public static final C1085b<String> f1626be = m1648a("fetch_variables_backup_endpoint", "https://ms.applvn.com/");

    /* renamed from: bf */
    public static final C1085b<String> f1627bf = m1648a("anr_postback_endpoint", "https://ms.applovin.com/1.0/sdk/error");

    /* renamed from: bg */
    public static final C1085b<String> f1628bg = m1648a("token_type_prefixes_r", "4!");

    /* renamed from: bh */
    public static final C1085b<String> f1629bh = m1648a("token_type_prefixes_arj", "json_v3!");

    /* renamed from: bi */
    public static final C1085b<String> f1630bi = m1648a("top_level_events", "landing,paused,resumed,ref,rdf,checkout,iap");

    /* renamed from: bj */
    public static final C1085b<String> f1631bj;

    /* renamed from: bk */
    public static final C1085b<Boolean> f1632bk = m1648a("persist_super_properties", Boolean.TRUE);

    /* renamed from: bl */
    public static final C1085b<Integer> f1633bl = m1648a("super_property_string_max_length", 1024);

    /* renamed from: bm */
    public static final C1085b<Integer> f1634bm = m1648a("super_property_url_max_length", 1024);

    /* renamed from: bn */
    public static final C1085b<Long> f1635bn = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 10, "cached_advertising_info_ttl_ms");

    /* renamed from: bo */
    public static final C1085b<Boolean> f1636bo = m1648a("use_per_format_cache_queues", Boolean.TRUE);

    /* renamed from: bp */
    public static final C1085b<Boolean> f1637bp = m1648a("cache_cleanup_enabled", Boolean.FALSE);

    /* renamed from: bq */
    public static final C1085b<Long> f1638bq = m1648a("cache_file_ttl_seconds", Long.valueOf(TimeUnit.DAYS.toSeconds(1)));

    /* renamed from: br */
    public static final C1085b<Integer> f1639br = m1648a("cache_max_size_mb", -1);

    /* renamed from: bs */
    public static final C1085b<String> f1640bs = m1648a("precache_delimiters", ")]',");

    /* renamed from: bt */
    public static final C1085b<Boolean> f1641bt = m1648a("ad_resource_caching_enabled", Boolean.TRUE);

    /* renamed from: bu */
    public static final C1085b<Boolean> f1642bu = m1648a("fail_ad_load_on_failed_video_cache", Boolean.TRUE);

    /* renamed from: bv */
    public static final C1085b<String> f1643bv = m1648a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");

    /* renamed from: bw */
    public static final C1085b<String> f1644bw = m1648a("preserved_cached_assets", "sound_off.png,sound_on.png,closeOptOut.png,1381250003_28x28.png,zepto-1.1.3.min.js,jquery-2.1.1.min.js,jquery-1.9.1.min.js,jquery.knob.js");

    /* renamed from: bx */
    public static final C1085b<Integer> f1645bx = m1648a("vr_retry_count_v1", 1);

    /* renamed from: by */
    public static final C1085b<Integer> f1646by = m1648a("cr_retry_count_v1", 1);

    /* renamed from: bz */
    public static final C1085b<Boolean> f1647bz = m1648a("incent_warning_enabled", Boolean.FALSE);

    /* renamed from: cA */
    public static final C1085b<Integer> f1648cA = m1648a("mute_button_size", 32);

    /* renamed from: cB */
    public static final C1085b<Integer> f1649cB = m1648a("mute_button_margin", 10);

    /* renamed from: cC */
    public static final C1085b<Integer> f1650cC = m1648a("mute_button_gravity", 85);

    /* renamed from: cD */
    public static final C1085b<Long> f1651cD = m1648a("progress_bar_step", 25L);

    /* renamed from: cE */
    public static final C1085b<Integer> f1652cE = m1648a("progress_bar_scale", 10000);

    /* renamed from: cF */
    public static final C1085b<Integer> f1653cF = m1648a("progress_bar_vertical_padding", -8);

    /* renamed from: cG */
    public static final C1085b<Integer> f1654cG = m1648a("vs_buffer_indicator_size", 50);

    /* renamed from: cH */
    public static final C1085b<Long> f1655cH = m1648a("set_poststitial_muted_initial_delay_ms", 500L);

    /* renamed from: cI */
    public static final C1085b<Integer> f1656cI = m1648a("minepsv", -1);

    /* renamed from: cJ */
    public static final C1085b<Integer> f1657cJ = m1648a("maxepsv", -1);

    /* renamed from: cK */
    public static final C1085b<Boolean> f1658cK = m1648a("pctfnc", Boolean.FALSE);

    /* renamed from: cL */
    public static final C1085b<Integer> f1659cL = m1648a("submit_postback_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: cM */
    public static final C1085b<Integer> f1660cM = m1648a("submit_postback_retries", 4);

    /* renamed from: cN */
    public static final C1085b<Integer> f1661cN = m1648a("max_postback_attempts", 3);

    /* renamed from: cO */
    public static final C1085b<Boolean> f1662cO = m1648a("fppopq", Boolean.FALSE);

    /* renamed from: cP */
    public static final C1085b<Boolean> f1663cP = m1648a("retry_on_all_errors", Boolean.FALSE);

    /* renamed from: cQ */
    public static final C1085b<Integer> f1664cQ = m1648a("get_retry_delay_v1", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: cR */
    public static final C1085b<Integer> f1665cR = m1648a("http_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: cS */
    public static final C1085b<Integer> f1666cS = m1648a("http_socket_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(20)));

    /* renamed from: cT */
    public static final C1085b<Boolean> f1667cT = m1648a("force_ssl", Boolean.FALSE);

    /* renamed from: cU */
    public static final C1085b<Integer> f1668cU = m1648a("fetch_ad_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: cV */
    public static final C1085b<Integer> f1669cV = m1648a("fetch_ad_retry_count_v1", 1);

    /* renamed from: cW */
    public static final C1085b<Boolean> f1670cW = m1648a("faer", Boolean.FALSE);

    /* renamed from: cX */
    public static final C1085b<Boolean> f1671cX = m1648a("faroae", Boolean.FALSE);

    /* renamed from: cY */
    public static final C1085b<Integer> f1672cY = m1648a("submit_data_retry_count_v1", 1);

    /* renamed from: cZ */
    public static final C1085b<Integer> f1673cZ = m1648a("response_buffer_size", 16000);

    /* renamed from: ca */
    public static final C1085b<Integer> f1674ca = m1648a("expandable_h_close_button_margin", 10);

    /* renamed from: cb */
    public static final C1085b<Integer> f1675cb = m1648a("expandable_t_close_button_margin", 10);

    /* renamed from: cc */
    public static final C1085b<Boolean> f1676cc = m1648a("expandable_lhs_close_button", Boolean.FALSE);

    /* renamed from: cd */
    public static final C1085b<Integer> f1677cd = m1648a("expandable_close_button_touch_area", 0);

    /* renamed from: ce */
    public static final C1085b<Boolean> f1678ce = m1648a("iaad", Boolean.FALSE);

    /* renamed from: cf */
    public static final C1085b<String> f1679cf = m1648a("js_tag_schemes", "applovin,mopub");

    /* renamed from: cg */
    public static final C1085b<String> f1680cg = m1648a("js_tag_load_success_hosts", "load,load_succeeded");

    /* renamed from: ch */
    public static final C1085b<String> f1681ch = m1648a("js_tag_load_failure_hosts", "failLoad,load_failed");

    /* renamed from: ci */
    public static final C1085b<Integer> f1682ci = m1648a("auxiliary_operations_threads", 3);

    /* renamed from: cj */
    public static final C1085b<Integer> f1683cj = m1648a("caching_operations_threads", 8);

    /* renamed from: ck */
    public static final C1085b<Long> f1684ck = GeneratedOutlineSupport.outline7(TimeUnit.SECONDS, 10, "fullscreen_ad_pending_display_state_timeout_ms");

    /* renamed from: cl */
    public static final C1085b<Long> f1685cl = GeneratedOutlineSupport.outline7(TimeUnit.MINUTES, 2, "fullscreen_ad_showing_state_timeout_ms");

    /* renamed from: cm */
    public static final C1085b<Boolean> f1686cm = m1648a("lhs_close_button_video", Boolean.FALSE);

    /* renamed from: cn */
    public static final C1085b<Integer> f1687cn = m1648a("close_button_right_margin_video", 4);

    /* renamed from: co */
    public static final C1085b<Integer> f1688co = m1648a("close_button_size_video", 30);

    /* renamed from: cp */
    public static final C1085b<Integer> f1689cp = m1648a("close_button_top_margin_video", 8);

    /* renamed from: cq */
    public static final C1085b<Long> f1690cq = m1648a("inter_display_delay", 200L);

    /* renamed from: cr */
    public static final C1085b<Long> f1691cr = m1648a("maximum_close_button_delay_seconds", 999L);

    /* renamed from: cs */
    public static final C1085b<Boolean> f1692cs = m1648a("respect_close_button", Boolean.TRUE);

    /* renamed from: ct */
    public static final C1085b<Boolean> f1693ct = m1648a("lhs_skip_button", Boolean.TRUE);

    /* renamed from: cu */
    public static final C1085b<Boolean> f1694cu = m1648a("track_app_killed", Boolean.FALSE);

    /* renamed from: cv */
    public static final C1085b<Boolean> f1695cv = m1648a("mute_controls_enabled", Boolean.FALSE);

    /* renamed from: cw */
    public static final C1085b<Boolean> f1696cw = m1648a("allow_user_muting", Boolean.TRUE);

    /* renamed from: cx */
    public static final C1085b<Boolean> f1697cx = m1648a("mute_videos", Boolean.FALSE);

    /* renamed from: cy */
    public static final C1085b<Boolean> f1698cy = m1648a("show_mute_by_default", Boolean.FALSE);

    /* renamed from: cz */
    public static final C1085b<Boolean> f1699cz = m1648a("mute_with_user_settings", Boolean.TRUE);

    /* renamed from: dA */
    public static final C1085b<String> f1700dA = m1648a("plugin_version", "");

    /* renamed from: dB */
    public static final C1085b<Boolean> f1701dB = m1648a("hgn", Boolean.FALSE);

    /* renamed from: dC */
    public static final C1085b<Boolean> f1702dC = m1648a("cso", Boolean.FALSE);

    /* renamed from: dD */
    public static final C1085b<Boolean> f1703dD = m1648a("cfs", Boolean.FALSE);

    /* renamed from: dE */
    public static final C1085b<Boolean> f1704dE = m1648a("cmi", Boolean.FALSE);

    /* renamed from: dF */
    public static final C1085b<Boolean> f1705dF = m1648a("crat", Boolean.FALSE);

    /* renamed from: dG */
    public static final C1085b<Boolean> f1706dG = m1648a("cvs", Boolean.FALSE);

    /* renamed from: dH */
    public static final C1085b<Boolean> f1707dH = m1648a("caf", Boolean.FALSE);

    /* renamed from: dI */
    public static final C1085b<Boolean> f1708dI = m1648a("cf", Boolean.FALSE);

    /* renamed from: dJ */
    public static final C1085b<Boolean> f1709dJ = m1648a("cmtl", Boolean.TRUE);

    /* renamed from: dK */
    public static final C1085b<Boolean> f1710dK = m1648a("cnr", Boolean.FALSE);

    /* renamed from: dL */
    public static final C1085b<Boolean> f1711dL = m1648a("adr", Boolean.FALSE);

    /* renamed from: dM */
    public static final C1085b<Float> f1712dM = m1648a("volume_normalization_factor", Float.valueOf(6.6666665f));

    /* renamed from: dN */
    public static final C1085b<Boolean> f1713dN = m1648a("system_user_agent_collection_enabled", Boolean.FALSE);

    /* renamed from: dO */
    public static final C1085b<Boolean> f1714dO = m1648a("user_agent_collection_enabled", Boolean.FALSE);

    /* renamed from: dP */
    public static final C1085b<Boolean> f1715dP = m1648a("http_headers_collection_enabled", Boolean.FALSE);

    /* renamed from: dQ */
    public static final C1085b<String> f1716dQ = m1648a("webview_package_name", "com.google.android.webview");

    /* renamed from: dR */
    public static final C1085b<Boolean> f1717dR = m1648a("collect_device_angle", Boolean.FALSE);

    /* renamed from: dS */
    public static final C1085b<Boolean> f1718dS = m1648a("collect_device_movement", Boolean.FALSE);

    /* renamed from: dT */
    public static final C1085b<Float> f1719dT = m1648a("movement_degradation", Float.valueOf(0.75f));

    /* renamed from: dU */
    public static final C1085b<Integer> f1720dU = m1648a("device_sensor_period_ms", 250);

    /* renamed from: dV */
    public static final C1085b<Boolean> f1721dV = m1648a("dte", Boolean.TRUE);

    /* renamed from: dW */
    public static final C1085b<Boolean> f1722dW = m1648a("idcw", Boolean.FALSE);

    /* renamed from: dX */
    public static final C1085b<Long> f1723dX = m1648a("anr_debug_thread_refresh_time_ms", -1L);

    /* renamed from: dY */
    public static final C1085b<Integer> f1724dY = m1648a("fetch_basic_settings_delay_ms", 0);

    /* renamed from: dZ */
    public static final C1085b<Boolean> f1725dZ = m1648a("cclia", Boolean.TRUE);

    /* renamed from: da */
    public static final C1085b<Integer> f1726da = m1648a("fetch_basic_settings_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(10)));

    /* renamed from: db */
    public static final C1085b<Integer> f1727db = m1648a("fetch_basic_settings_retry_count", 3);

    /* renamed from: dc */
    public static final C1085b<Boolean> f1728dc = m1648a("fetch_basic_settings_on_reconnect", Boolean.FALSE);

    /* renamed from: dd */
    public static final C1085b<Boolean> f1729dd = m1648a("skip_fetch_basic_settings_if_not_connected", Boolean.FALSE);

    /* renamed from: de */
    public static final C1085b<Integer> f1730de = m1648a("fetch_basic_settings_retry_delay_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(2)));

    /* renamed from: df */
    public static final C1085b<Integer> f1731df = m1648a("fetch_variables_connection_timeout_ms", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(5)));

    /* renamed from: dg */
    public static final C1085b<Boolean> f1732dg = m1648a("idflrwbe", Boolean.FALSE);

    /* renamed from: dh */
    public static final C1085b<Boolean> f1733dh = m1648a("falawpr", Boolean.FALSE);

    /* renamed from: di */
    public static final C1085b<Boolean> f1734di = m1648a("sort_query_parameters", Boolean.FALSE);

    /* renamed from: dj */
    public static final C1085b<Long> f1735dj = GeneratedOutlineSupport.outline7(TimeUnit.SECONDS, 10, "communicator_request_timeout_ms");

    /* renamed from: dk */
    public static final C1085b<Integer> f1736dk = m1648a("communicator_request_retry_count", 3);

    /* renamed from: dl */
    public static final C1085b<Long> f1737dl = GeneratedOutlineSupport.outline7(TimeUnit.SECONDS, 2, "communicator_request_retry_delay_ms");

    /* renamed from: dm */
    public static final C1085b<Integer> f1738dm = m1648a("ad_session_minutes", 60);

    /* renamed from: dn */
    public static final C1085b<Boolean> f1739dn = m1648a("session_tracking_cooldown_on_event_fire", Boolean.TRUE);

    /* renamed from: do */
    public static final C1085b<Long> f1740do = m1648a("session_tracking_resumed_cooldown_minutes", 90L);

    /* renamed from: dp */
    public static final C1085b<Long> f1741dp = m1648a("session_tracking_paused_cooldown_minutes", 90L);

    /* renamed from: dq */
    public static final C1085b<Boolean> f1742dq = m1648a("qq", Boolean.FALSE);

    /* renamed from: dr */
    public static final C1085b<Boolean> f1743dr = m1648a("qq1", Boolean.TRUE);

    /* renamed from: ds */
    public static final C1085b<Boolean> f1744ds = m1648a("qq2", Boolean.TRUE);

    /* renamed from: dt */
    public static final C1085b<Boolean> f1745dt = m1648a("qq3", Boolean.TRUE);

    /* renamed from: du */
    public static final C1085b<Boolean> f1746du = m1648a("qq4", Boolean.TRUE);

    /* renamed from: dv */
    public static final C1085b<Boolean> f1747dv = m1648a("qq5", Boolean.TRUE);

    /* renamed from: dw */
    public static final C1085b<Boolean> f1748dw = m1648a("qq6", Boolean.TRUE);

    /* renamed from: dx */
    public static final C1085b<Boolean> f1749dx = m1648a("qq7", Boolean.TRUE);

    /* renamed from: dy */
    public static final C1085b<Boolean> f1750dy = m1648a("qq8", Boolean.TRUE);

    /* renamed from: dz */
    public static final C1085b<Boolean> f1751dz = m1648a("pui", Boolean.TRUE);

    /* renamed from: eA */
    public static final C1085b<Boolean> f1752eA = m1648a("device_init_gzip", Boolean.FALSE);

    /* renamed from: eB */
    public static final C1085b<Boolean> f1753eB = m1648a("fetch_ad_gzip", Boolean.FALSE);

    /* renamed from: eC */
    public static final C1085b<Boolean> f1754eC = m1648a("event_tracking_gzip", Boolean.FALSE);

    /* renamed from: eD */
    public static final C1085b<Boolean> f1755eD = m1648a("submit_ad_stats_gzip", Boolean.FALSE);

    /* renamed from: eE */
    public static final C1085b<Boolean> f1756eE = m1648a("reward_postback_gzip", Boolean.FALSE);

    /* renamed from: eF */
    public static final C1085b<Boolean> f1757eF = m1648a("force_rerender", Boolean.FALSE);

    /* renamed from: eG */
    public static final C1085b<Boolean> f1758eG = m1648a("daostr", Boolean.FALSE);

    /* renamed from: eH */
    public static final C1085b<Boolean> f1759eH = m1648a("tctlaa", Boolean.FALSE);

    /* renamed from: eI */
    public static final C1085b<Boolean> f1760eI = m1648a("rwvdv", Boolean.FALSE);

    /* renamed from: eJ */
    public static final C1085b<Boolean> f1761eJ = m1648a("handle_render_process_gone", Boolean.TRUE);

    /* renamed from: eK */
    public static final C1085b<Boolean> f1762eK = m1648a("comcr", Boolean.TRUE);

    /* renamed from: eL */
    public static final C1085b<Boolean> f1763eL = m1648a("gcoas", Boolean.FALSE);

    /* renamed from: eM */
    public static final C1085b<Boolean> f1764eM = m1648a("teorpc", Boolean.FALSE);

    /* renamed from: eN */
    public static final C1085b<Boolean> f1765eN = m1648a("rmpibt", Boolean.FALSE);

    /* renamed from: eO */
    public static final C1085b<Boolean> f1766eO = m1648a("spbcioa", Boolean.FALSE);

    /* renamed from: eP */
    public static final C1085b<Boolean> f1767eP = m1648a("set_webview_render_process_client", Boolean.FALSE);

    /* renamed from: eQ */
    public static final C1085b<Boolean> f1768eQ = m1648a("disable_webview_hardware_acceleration", Boolean.FALSE);

    /* renamed from: eR */
    public static final C1085b<Boolean> f1769eR = m1648a("fvrunc", Boolean.FALSE);

    /* renamed from: eS */
    public static final C1085b<Boolean> f1770eS = m1648a("dsaovcf", Boolean.FALSE);

    /* renamed from: eT */
    public static final C1085b<Boolean> f1771eT = m1648a("daoar", Boolean.FALSE);

    /* renamed from: eU */
    public static final C1085b<Boolean> f1772eU = m1648a("anr_detection_enabled", Boolean.FALSE);

    /* renamed from: eV */
    public static final C1085b<Long> f1773eV = m1648a("anr_trigger_millis", Long.valueOf(VideoPlayer.FRAME_TIMEOUT));

    /* renamed from: eW */
    public static final C1085b<Long> f1774eW = m1648a("anr_touch_millis", 3000L);

    /* renamed from: eX */
    public static final C1085b<Long> f1775eX = m1648a("anr_check_millis", 3000L);

    /* renamed from: eY */
    public static final C1085b<String> f1776eY = m1648a("config_consent_dialog_state", "unknown");

    /* renamed from: eZ */
    public static final C1085b<String> f1777eZ = m1648a("country_code", "");

    /* renamed from: ea */
    public static final C1085b<Long> f1778ea = m1648a("lccdm", 10L);

    /* renamed from: eb */
    public static final C1085b<Integer> f1779eb = m1648a("lmfd", 3);

    /* renamed from: ec */
    public static final C1085b<Boolean> f1780ec = m1648a("is_track_ad_info", Boolean.TRUE);

    /* renamed from: ed */
    public static final C1085b<Boolean> f1781ed = m1648a("submit_ad_stats_enabled", Boolean.FALSE);

    /* renamed from: ee */
    public static final C1085b<Integer> f1782ee = m1648a("submit_ad_stats_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: ef */
    public static final C1085b<Integer> f1783ef = m1648a("submit_ad_stats_retry_count", 1);

    /* renamed from: eg */
    public static final C1085b<Integer> f1784eg = m1648a("submit_ad_stats_max_count", 500);

    /* renamed from: eh */
    public static final C1085b<Boolean> f1785eh = m1648a("asdm", Boolean.FALSE);

    /* renamed from: ei */
    public static final C1085b<String> f1786ei = m1648a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");

    /* renamed from: ej */
    public static final C1085b<String> f1787ej = m1648a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");

    /* renamed from: ek */
    public static final C1085b<Integer> f1788ek = m1648a("vast_max_response_length", 640000);

    /* renamed from: el */
    public static final C1085b<Integer> f1789el = m1648a("vast_max_wrapper_depth", 5);

    /* renamed from: em */
    public static final C1085b<Long> f1790em = GeneratedOutlineSupport.outline7(TimeUnit.SECONDS, 1, "vast_progress_tracking_countdown_step");

    /* renamed from: en */
    public static final C1085b<String> f1791en = m1648a("vast_unsupported_video_extensions", "ogv,flv");

    /* renamed from: eo */
    public static final C1085b<String> f1792eo = m1648a("vast_unsupported_video_types", "video/ogg,video/x-flv");

    /* renamed from: ep */
    public static final C1085b<Boolean> f1793ep = m1648a("vast_validate_with_extension_if_no_video_type", Boolean.TRUE);

    /* renamed from: eq */
    public static final C1085b<Integer> f1794eq = m1648a("vast_video_selection_policy", 2);

    /* renamed from: er */
    public static final C1085b<Integer> f1795er = m1648a("vast_wrapper_resolution_retry_count_v1", 1);

    /* renamed from: es */
    public static final C1085b<Integer> f1796es = m1648a("vast_wrapper_resolution_connection_timeout", Integer.valueOf((int) TimeUnit.SECONDS.toMillis(30)));

    /* renamed from: et */
    public static final C1085b<Boolean> f1797et = m1648a("ree", Boolean.TRUE);

    /* renamed from: eu */
    public static final C1085b<Boolean> f1798eu = m1648a("btee", Boolean.TRUE);

    /* renamed from: ev */
    public static final C1085b<Long> f1799ev = m1648a("server_timestamp_ms", 0L);

    /* renamed from: ew */
    public static final C1085b<Long> f1800ew = m1648a("device_timestamp_ms", 0L);

    /* renamed from: ex */
    public static final C1085b<Integer> f1801ex = m1648a("gzip_min_length", 0);

    /* renamed from: ey */
    public static final C1085b<Boolean> f1802ey = m1648a("gzip_encoding_default", Boolean.FALSE);

    /* renamed from: ez */
    public static final C1085b<Boolean> f1803ez = m1648a("fetch_settings_gzip", Boolean.FALSE);

    /* renamed from: fa */
    public static final C1085b<String> f1804fa = m1648a("c_sticky_topics", "user_engagement_sdk_init,adjust_init,safedk_init,discovery_init,max_ad_events,send_http_request,adapter_initialization_status,privacy_setting_updated,network_sdk_version_updated");

    /* renamed from: c */
    public final String f1805c;

    /* renamed from: d */
    public final T f1806d;

    static {
        Class<String> cls = String.class;
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        Class<Float> cls4 = Float.class;
        f1544a = Arrays.asList(new Class[]{Boolean.class, cls4, cls3, cls2, cls});
        AppLovinTouchToClickListener.ClickRecognitionState clickRecognitionState = AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN;
        AppLovinTouchToClickListener.ClickRecognitionState clickRecognitionState2 = AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN;
        f1631bj = m1648a("valid_super_property_types", cls.getName() + "," + cls3.getName() + "," + cls2.getName() + "," + Double.class.getName() + "," + cls4.getName() + "," + Date.class.getName() + "," + Uri.class.getName() + "," + List.class.getName() + "," + Map.class.getName());
        C0648m.C0650a aVar = C0648m.C0650a.MEDIUM;
    }

    public C1085b(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (t != null) {
            this.f1805c = str;
            this.f1806d = t;
        } else {
            throw new IllegalArgumentException("No default value specified");
        }
    }

    /* renamed from: a */
    public static <T> C1085b<T> m1648a(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (f1544a.contains(t.getClass())) {
            C1085b<T> bVar = new C1085b<>(str, t);
            if (!f1595b.containsKey(str)) {
                f1595b.put(str, bVar);
                return bVar;
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline16("Setting has already been used: ", str));
        } else {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Unsupported value type: ");
            outline24.append(t.getClass());
            throw new IllegalArgumentException(outline24.toString());
        }
    }

    /* renamed from: c */
    public static Collection<C1085b<?>> m1649c() {
        return Collections.synchronizedCollection(f1595b.values());
    }

    /* renamed from: a */
    public T mo10673a(Object obj) {
        return this.f1806d.getClass().cast(obj);
    }

    /* renamed from: a */
    public String mo10674a() {
        return this.f1805c;
    }

    /* renamed from: b */
    public T mo10675b() {
        return this.f1806d;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof C1085b)) {
            return 0;
        }
        return this.f1805c.compareTo(((C1085b) obj).mo10674a());
    }
}
