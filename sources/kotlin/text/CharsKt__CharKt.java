package kotlin.text;

import com.android.billingclient.api.zzam;
import com.facebook.LegacyTokenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;

/* compiled from: Char.kt */
public class CharsKt__CharKt {
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contains$default(java.lang.CharSequence r9, java.lang.CharSequence r10, boolean r11, int r12) {
        /*
            r0 = 2
            r12 = r12 & r0
            r1 = 0
            if (r12 == 0) goto L_0x0007
            r6 = 0
            goto L_0x0008
        L_0x0007:
            r6 = r11
        L_0x0008:
            java.lang.String r11 = "$this$contains"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            java.lang.String r11 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            boolean r11 = r10 instanceof java.lang.String
            if (r11 == 0) goto L_0x001f
            java.lang.String r10 = (java.lang.String) r10
            int r9 = indexOf$default((java.lang.CharSequence) r9, (java.lang.String) r10, (int) r1, (boolean) r6, (int) r0)
            if (r9 < 0) goto L_0x0030
            goto L_0x002f
        L_0x001f:
            r4 = 0
            int r5 = r9.length()
            r7 = 0
            r8 = 16
            r2 = r9
            r3 = r10
            int r9 = indexOf$StringsKt__StringsKt$default(r2, r3, r4, r5, r6, r7, r8)
            if (r9 < 0) goto L_0x0030
        L_0x002f:
            r1 = 1
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.CharsKt__CharKt.contains$default(java.lang.CharSequence, java.lang.CharSequence, boolean, int):boolean");
    }

    public static boolean endsWith$default(String str, String str2, boolean z, int i) {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "$this$endsWith");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean equals(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOf");
        Intrinsics.checkNotNullParameter(str, LegacyTokenHelper.TYPE_STRING);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16);
    }

    public static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            intProgression = new IntRange(i, i2);
        } else {
            int lastIndex = getLastIndex(charSequence);
            if (i > lastIndex) {
                i = lastIndex;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            intProgression = new IntProgression(i, i2, -1);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i3 = intProgression.first;
            int i4 = intProgression.last;
            int i5 = intProgression.step;
            if (i5 < 0 ? i3 >= i4 : i3 <= i4) {
                while (true) {
                    if (!regionMatchesImpl(charSequence2, 0, charSequence, i3, charSequence2.length(), z)) {
                        if (i3 == i4) {
                            break;
                        }
                        i3 += i5;
                    } else {
                        return i3;
                    }
                }
            }
        } else {
            int i6 = intProgression.first;
            int i7 = intProgression.last;
            int i8 = intProgression.step;
            if (i8 < 0 ? i6 >= i7 : i6 <= i7) {
                while (true) {
                    if (!regionMatches((String) charSequence2, 0, (String) charSequence, i6, charSequence2.length(), z)) {
                        if (i6 == i7) {
                            break;
                        }
                        i6 += i8;
                    } else {
                        return i6;
                    }
                }
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return indexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOfAny");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            if (i < 0) {
                i = 0;
            }
            int lastIndex = getLastIndex(charSequence);
            if (i > lastIndex) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(i);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return i;
                }
                if (i == lastIndex) {
                    return -1;
                }
                i++;
            }
        } else {
            return ((String) charSequence).indexOf(zzam.single(cArr), i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isBlank(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.length()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "$this$indices"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r3 = r4.length()
            int r3 = r3 + -1
            r0.<init>(r2, r3)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x002b
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002b
            goto L_0x0049
        L_0x002b:
            java.util.Iterator r0 = r0.iterator()
        L_0x002f:
            r3 = r0
            kotlin.ranges.IntProgressionIterator r3 = (kotlin.ranges.IntProgressionIterator) r3
            boolean r3 = r3.hasNext
            if (r3 == 0) goto L_0x0049
            r3 = r0
            kotlin.collections.IntIterator r3 = (kotlin.collections.IntIterator) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = com.android.billingclient.api.zzam.isWhitespace(r3)
            if (r3 != 0) goto L_0x002f
            r4 = 0
            goto L_0x004a
        L_0x0049:
            r4 = 1
        L_0x004a:
            if (r4 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.CharsKt__CharKt.isBlank(java.lang.CharSequence):boolean");
    }

    public static int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2) {
        boolean z2;
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        if (!z) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        char[] cArr = {c};
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (!z) {
            return ((String) charSequence).lastIndexOf(zzam.single(cArr), i);
        }
        int lastIndex = getLastIndex(charSequence);
        if (i > lastIndex) {
            i = lastIndex;
        }
        while (i >= 0) {
            char charAt = charSequence.charAt(i);
            int i3 = 0;
            while (true) {
                if (i3 >= 1) {
                    z2 = false;
                    break;
                } else if (equals(cArr[i3], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static final boolean regionMatches(String str, int i, String str2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "$this$regionMatches");
        Intrinsics.checkNotNullParameter(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$regionMatchesImpl");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String replace$default(String str, char c, char c2, boolean z, int i) {
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "$this$replace");
        if (!z) {
            String replace = str.replace(c, c2);
            Intrinsics.checkNotNullExpressionValue(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (equals(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        boolean z2 = true;
        int i2 = 0;
        if (i >= 0) {
            int indexOf = indexOf(charSequence, str, 0, z);
            if (indexOf == -1 || i == 1) {
                return zzam.listOf(charSequence.toString());
            }
            if (i <= 0) {
                z2 = false;
            }
            int i3 = 10;
            if (z2 && i <= 10) {
                i3 = i;
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                if ((z2 && arrayList.size() == i - 1) || (indexOf = indexOf(charSequence, str, i2, z)) == -1) {
                    arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                break;
            } while ((indexOf = indexOf(charSequence, str, i2, z)) == -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public static List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "$this$split");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        if (i < 0) {
            z2 = false;
        }
        if (z2) {
            DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(charSequence, 0, i, new StringsKt__StringsKt$rangesDelimitedBy$4(zzam.asList(strArr), z));
            Intrinsics.checkNotNullParameter(delimitedRangesSequence, "$this$asIterable");
            SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(delimitedRangesSequence);
            ArrayList arrayList = new ArrayList(zzam.collectionSizeOrDefault(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1, 10));
            Iterator it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
            while (it.hasNext()) {
                arrayList.add(substring(charSequence, (IntRange) it.next()));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public static boolean startsWith$default(String str, String str2, boolean z, int i) {
        boolean z2 = (i & 2) != 0 ? false : z;
        Intrinsics.checkNotNullParameter(str, "$this$startsWith");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z2) {
            return str.startsWith(str2);
        }
        return regionMatches(str, 0, str2, 0, str2.length(), z2);
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$substring");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static String substringAfter$default(String str, String str2, String str3, int i) {
        String str4 = (i & 2) != 0 ? str : null;
        Intrinsics.checkNotNullParameter(str, "$this$substringAfter");
        Intrinsics.checkNotNullParameter(str2, "delimiter");
        Intrinsics.checkNotNullParameter(str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6);
        if (indexOf$default == -1) {
            return str4;
        }
        String substring = str.substring(str2.length() + indexOf$default, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static String substringAfterLast$default(String str, char c, String str2, int i) {
        String str3 = (i & 2) != 0 ? str : null;
        Intrinsics.checkNotNullParameter(str, "$this$substringAfterLast");
        Intrinsics.checkNotNullParameter(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default(str, c, 0, false, 6);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Integer toIntOrNull(java.lang.String r10) {
        /*
            java.lang.String r0 = "$this$toIntOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r10.length()
            r1 = 0
            if (r0 != 0) goto L_0x0010
            goto L_0x006a
        L_0x0010:
            r2 = 0
            char r3 = r10.charAt(r2)
            r4 = 48
            int r4 = kotlin.jvm.internal.Intrinsics.compare(r3, r4)
            r5 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r6 = 1
            if (r4 >= 0) goto L_0x0032
            if (r0 != r6) goto L_0x0024
            goto L_0x006a
        L_0x0024:
            r4 = 45
            if (r3 != r4) goto L_0x002c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            goto L_0x0034
        L_0x002c:
            r4 = 43
            if (r3 != r4) goto L_0x006a
            r3 = 1
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            r6 = 0
        L_0x0034:
            r4 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
            r7 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
        L_0x003a:
            if (r3 >= r0) goto L_0x005d
            char r8 = r10.charAt(r3)
            r9 = 10
            int r8 = java.lang.Character.digit(r8, r9)
            if (r8 >= 0) goto L_0x0049
            goto L_0x006a
        L_0x0049:
            if (r2 >= r7) goto L_0x0052
            if (r7 != r4) goto L_0x006a
            int r7 = r5 / 10
            if (r2 >= r7) goto L_0x0052
            goto L_0x006a
        L_0x0052:
            int r2 = r2 * 10
            int r9 = r5 + r8
            if (r2 >= r9) goto L_0x0059
            goto L_0x006a
        L_0x0059:
            int r2 = r2 - r8
            int r3 = r3 + 1
            goto L_0x003a
        L_0x005d:
            if (r6 == 0) goto L_0x0064
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            goto L_0x0069
        L_0x0064:
            int r10 = -r2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
        L_0x0069:
            r1 = r10
        L_0x006a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.CharsKt__CharKt.toIntOrNull(java.lang.String):java.lang.Integer");
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static String replace$default(String str, String str2, String str3, boolean z, int i) {
        int i2 = 0;
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(str, "$this$replace");
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        int indexOf = indexOf(str, str2, 0, z);
        if (indexOf < 0) {
            return str;
        }
        int length = str2.length();
        int i3 = 1;
        if (length >= 1) {
            i3 = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i2, indexOf);
                sb.append(str3);
                i2 = indexOf + length;
                if (indexOf >= str.length() || (indexOf = indexOf(str, str2, indexOf + i3, z)) <= 0) {
                    sb.append(str, i2, str.length());
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(str, i2, indexOf);
                sb.append(str3);
                i2 = indexOf + length;
                break;
            } while ((indexOf = indexOf(str, str2, indexOf + i3, z)) <= 0);
            sb.append(str, i2, str.length());
            String sb22 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }
}
