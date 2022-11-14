package com.helpshift.support.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageButton;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.C2466R;
import com.helpshift.support.Faq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Styles {
    public static int getColor(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static int getInt(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int i2 = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        return i2;
    }

    public static Faq getQuestionWithHighlightedSearchTerms(Context context, Faq faq, ArrayList<String> arrayList) {
        Faq faq2 = faq;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        String str = faq2.title;
        String str2 = faq2.body;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String hexColor = com.helpshift.util.Styles.getHexColor(context, C2466R.attr.hs__searchHighlightColor);
        if (!(HSTransliterator.unidecode(str).equals(str) && HSTransliterator.unidecode(str2).equals(str2))) {
            int length = str.length();
            ArrayList arrayList2 = new ArrayList();
            String str3 = "";
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                String unidecode = HSTransliterator.unidecode(charAt + "");
                for (int i2 = 0; i2 < unidecode.length(); i2++) {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24(str3);
                    outline24.append(unidecode.charAt(i2));
                    str3 = outline24.toString();
                    arrayList2.add(Integer.valueOf(i));
                }
            }
            String lowerCase = str3.toLowerCase();
            int length2 = str2.length();
            HSTransliterator.unidecode(str2);
            ArrayList arrayList3 = new ArrayList();
            String str4 = "";
            for (int i3 = 0; i3 < length2; i3++) {
                char charAt2 = str2.charAt(i3);
                String unidecode2 = HSTransliterator.unidecode(charAt2 + "");
                for (int i4 = 0; i4 < unidecode2.length(); i4++) {
                    StringBuilder outline242 = GeneratedOutlineSupport.outline24(str4);
                    outline242.append(unidecode2.charAt(i4));
                    str4 = outline242.toString();
                    arrayList3.add(Integer.valueOf(i3));
                }
            }
            String lowerCase2 = str4.toLowerCase();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.length() >= 3) {
                    String lowerCase3 = next.toLowerCase();
                    for (int indexOf = TextUtils.indexOf(lowerCase, lowerCase3, 0); indexOf >= 0; indexOf = TextUtils.indexOf(lowerCase, lowerCase3, lowerCase3.length() + indexOf)) {
                        linkedHashSet.add(str.substring(((Integer) arrayList2.get(indexOf)).intValue(), ((Integer) arrayList2.get((lowerCase3.length() + indexOf) - 1)).intValue() + 1));
                    }
                    for (int indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase3, 0); indexOf2 >= 0; indexOf2 = TextUtils.indexOf(lowerCase2, lowerCase3, lowerCase3.length() + indexOf2)) {
                        linkedHashSet.add(str2.substring(((Integer) arrayList3.get(indexOf2)).intValue(), ((Integer) arrayList3.get((lowerCase3.length() + indexOf2) - 1)).intValue() + 1));
                    }
                }
            }
        } else {
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.length() >= 3) {
                    linkedHashSet.add(next2);
                }
            }
        }
        String outline17 = GeneratedOutlineSupport.outline17(">", str2, "<");
        String outline172 = GeneratedOutlineSupport.outline17(">", str, "<");
        Pattern compile = Pattern.compile(">[^<]+<");
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            String str5 = (String) it3.next();
            Matcher matcher = compile.matcher(outline172);
            String str6 = outline172;
            while (matcher.find()) {
                String substring = outline172.substring(matcher.start(), matcher.end());
                String outline173 = GeneratedOutlineSupport.outline17("(?i)(", str5, ")");
                str6 = str6.replace(substring, substring.replaceAll(outline173, "<span style=\"background-color: " + hexColor + "\">$1</span>"));
            }
            Matcher matcher2 = compile.matcher(outline17);
            String str7 = outline17;
            while (matcher2.find()) {
                String substring2 = outline17.substring(matcher2.start(), matcher2.end());
                String outline174 = GeneratedOutlineSupport.outline17("(?i)(", str5, ")");
                str7 = str7.replace(substring2, substring2.replaceAll(outline174, "<span style=\"background-color: " + hexColor + "\">$1</span>"));
            }
            outline17 = str7;
            outline172 = str6;
        }
        return new Faq(1, faq.getId(), faq2.publish_id, faq2.language, faq2.section_publish_id, outline172.substring(1, outline172.length() - 1), outline17.substring(1, outline17.length() - 1), faq2.is_helpful, faq2.is_rtl, faq.getTags(), faq.getCategoryTags());
    }

    public static int getResourceIdForAttribute(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public static boolean isTablet(Context context) {
        return context.getResources().getBoolean(C2466R.bool.is_screen_large);
    }

    public static void setAccentColor(Context context, Drawable drawable) {
        com.helpshift.util.Styles.setColorFilter(context, drawable, C2466R.attr.colorAccent);
    }

    public static void setAdminChatBubbleColor(Context context, Drawable drawable) {
        com.helpshift.util.Styles.setColorFilter(context, drawable, C2466R.attr.hs__chatBubbleAdminBackgroundColor);
    }

    public static void setImageAlpha(ImageButton imageButton, int i) {
        imageButton.setImageAlpha(i);
    }

    public static void setSendMessageButtonIconColor(Context context, Drawable drawable, boolean z) {
        com.helpshift.util.Styles.setColorFilter(context, drawable, z ? C2466R.attr.colorAccent : 16842906);
    }
}
