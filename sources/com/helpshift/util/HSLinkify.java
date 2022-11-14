package com.helpshift.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HSLinkify {
    public static final int ALL = 15;
    public static final int EMAIL_ADDRESSES = 2;
    public static final int MAP_ADDRESSES = 8;
    public static final int PHONE_NUMBERS = 4;
    public static final String TAG = "Helpshift_HSlnkfy";
    public static final int WEB_URLS = 1;
    public static final MatchFilter sUrlMatchFilter = new MatchFilter() {
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            return i == 0 || charSequence.charAt(i - 1) != '@';
        }
    };

    public interface LinkClickListener {
        void onLinkClickFailed();

        void onLinkClicked(String str);
    }

    public interface MatchFilter {
        boolean acceptMatch(CharSequence charSequence, int i, int i2);
    }

    public interface TransformFilter {
        String transformUrl(Matcher matcher, String str);
    }

    public static boolean addLinks(Spannable spannable, int i, LinkClickListener linkClickListener) {
        int i2;
        boolean z;
        boolean z2;
        Spannable spannable2 = spannable;
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable2.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable2.removeSpan(uRLSpanArr[length]);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            Matcher matcher = Patterns.WEB_URL.matcher(spannable2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                MatchFilter matchFilter = sUrlMatchFilter;
                if (matchFilter == null || matchFilter.acceptMatch(spannable2, start, end)) {
                    LinkSpec linkSpec = new LinkSpec();
                    String group = matcher.group(0);
                    String[] strArr = {"http://", "https://", "rtsp://"};
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 3) {
                            z2 = false;
                            break;
                        }
                        int i4 = i3;
                        if (group.regionMatches(true, 0, strArr[i3], 0, strArr[i3].length())) {
                            if (!group.regionMatches(false, 0, strArr[i4], 0, strArr[i4].length())) {
                                group = strArr[i4] + group.substring(strArr[i4].length());
                            }
                            z2 = true;
                        } else {
                            i3 = i4 + 1;
                        }
                    }
                    if (!z2) {
                        group = GeneratedOutlineSupport.outline18(new StringBuilder(), strArr[0], group);
                    }
                    linkSpec.url = group;
                    linkSpec.start = start;
                    linkSpec.end = end;
                    arrayList.add(linkSpec);
                }
            }
        }
        if ((i & 2) != 0) {
            Matcher matcher2 = Patterns.EMAIL_ADDRESS.matcher(spannable2);
            while (matcher2.find()) {
                int start2 = matcher2.start();
                int end2 = matcher2.end();
                LinkSpec linkSpec2 = new LinkSpec();
                String group2 = matcher2.group(0);
                String[] strArr2 = {"mailto:"};
                int i5 = 0;
                while (true) {
                    if (i5 >= 1) {
                        z = false;
                        break;
                    }
                    int i6 = i5;
                    if (group2.regionMatches(true, 0, strArr2[i5], 0, strArr2[i5].length())) {
                        if (!group2.regionMatches(false, 0, strArr2[i6], 0, strArr2[i6].length())) {
                            group2 = strArr2[i6] + group2.substring(strArr2[i6].length());
                        }
                        z = true;
                    } else {
                        i5 = i6 + 1;
                    }
                }
                if (!z) {
                    group2 = GeneratedOutlineSupport.outline18(new StringBuilder(), strArr2[0], group2);
                }
                linkSpec2.url = group2;
                linkSpec2.start = start2;
                linkSpec2.end = end2;
                arrayList.add(linkSpec2);
            }
        }
        if ((i & 4) != 0) {
            Matcher matcher3 = Patterns.PHONE.matcher(spannable2);
            while (matcher3.find()) {
                String group3 = matcher3.group();
                if (group3.length() >= 6) {
                    LinkSpec linkSpec3 = new LinkSpec();
                    linkSpec3.url = GeneratedOutlineSupport.outline16("tel:", group3);
                    linkSpec3.start = matcher3.start();
                    linkSpec3.end = matcher3.end();
                    arrayList.add(linkSpec3);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<LinkSpec>() {
            public final boolean equals(Object obj) {
                return false;
            }

            public final int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
                int i;
                int i2;
                int i3 = linkSpec.start;
                int i4 = linkSpec2.start;
                if (i3 < i4) {
                    return -1;
                }
                if (i3 > i4 || (i = linkSpec.end) < (i2 = linkSpec2.end)) {
                    return 1;
                }
                if (i > i2) {
                    return -1;
                }
                return 0;
            }
        });
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size - 1) {
            LinkSpec linkSpec4 = (LinkSpec) arrayList.get(i7);
            int i8 = i7 + 1;
            LinkSpec linkSpec5 = (LinkSpec) arrayList.get(i8);
            int i9 = linkSpec4.start;
            int i10 = linkSpec5.start;
            if (i9 <= i10 && (i2 = linkSpec4.end) > i10) {
                int i11 = linkSpec5.end;
                int i12 = (i11 > i2 && i2 - i9 <= i11 - i10) ? i2 - i9 < i11 - i10 ? i7 : -1 : i8;
                if (i12 != -1) {
                    arrayList.remove(i12);
                    size--;
                }
            }
            i7 = i8;
        }
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec6 = (LinkSpec) it.next();
            spannable2.setSpan(getURLSpanWithClickListener(linkSpec6.url, linkClickListener), linkSpec6.start, linkSpec6.end, 33);
        }
        return true;
    }

    public static URLSpan getURLSpanWithClickListener(final String str, final LinkClickListener linkClickListener) {
        return new URLSpan(str) {
            public void onClick(View view) {
                try {
                    super.onClick(view);
                    if (linkClickListener != null) {
                        linkClickListener.onLinkClicked(str);
                    }
                } catch (Exception e) {
                    HSLogger.m3242e(HSLinkify.TAG, "Error in handling link click.", e);
                    LinkClickListener linkClickListener = linkClickListener;
                    if (linkClickListener != null) {
                        linkClickListener.onLinkClickFailed();
                    }
                }
            }
        };
    }

    public static boolean addLinks(TextView textView, int i, LinkClickListener linkClickListener) {
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString valueOf = SpannableString.valueOf(text);
            if (!addLinks((Spannable) valueOf, i, linkClickListener)) {
                return false;
            }
            MovementMethod movementMethod = textView.getMovementMethod();
            if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            textView.setText(valueOf);
            return true;
        } else if (!addLinks((Spannable) text, i, linkClickListener)) {
            return false;
        } else {
            MovementMethod movementMethod2 = textView.getMovementMethod();
            if ((movementMethod2 == null || !(movementMethod2 instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            return true;
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter, LinkClickListener linkClickListener) {
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks((Spannable) valueOf, pattern, str, matchFilter, transformFilter, linkClickListener)) {
            textView.setText(valueOf);
            MovementMethod movementMethod = textView.getMovementMethod();
            if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String str, MatchFilter matchFilter, TransformFilter transformFilter, LinkClickListener linkClickListener) {
        boolean z;
        Spannable spannable2 = spannable;
        String str2 = str;
        MatchFilter matchFilter2 = matchFilter;
        TransformFilter transformFilter2 = transformFilter;
        String lowerCase = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        Matcher matcher = pattern.matcher(spannable2);
        boolean z2 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter2 != null ? matchFilter2.acceptMatch(spannable2, start, end) : true) {
                String group = matcher.group(0);
                String[] strArr = {lowerCase};
                if (transformFilter2 != null) {
                    group = transformFilter2.transformUrl(matcher, group);
                }
                int i = 0;
                while (true) {
                    if (i >= 1) {
                        z = false;
                        break;
                    }
                    int i2 = i;
                    if (group.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                        if (!group.regionMatches(false, 0, strArr[i2], 0, strArr[i2].length())) {
                            group = strArr[i2] + group.substring(strArr[i2].length());
                        }
                        z = true;
                    } else {
                        i = i2 + 1;
                    }
                }
                if (!z) {
                    group = GeneratedOutlineSupport.outline18(new StringBuilder(), strArr[0], group);
                }
                spannable2.setSpan(getURLSpanWithClickListener(group, linkClickListener), start, end, 33);
                z2 = true;
            } else {
                LinkClickListener linkClickListener2 = linkClickListener;
            }
        }
        return z2;
    }
}
