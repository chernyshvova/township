package kotlin.text;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: Strings.kt */
public final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.Number r15 = (java.lang.Number) r15
            int r15 = r15.intValue()
            java.lang.String r0 = "$receiver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.List r6 = r13.$delimitersList
            boolean r7 = r13.$ignoreCase
            r8 = 0
            r0 = 0
            if (r7 != 0) goto L_0x0056
            int r1 = r6.size()
            r2 = 1
            if (r1 != r2) goto L_0x0056
            java.lang.String r1 = "$this$single"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            int r1 = r6.size()
            if (r1 == 0) goto L_0x004e
            if (r1 != r2) goto L_0x0046
            java.lang.Object r1 = r6.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            r2 = 4
            int r14 = kotlin.text.CharsKt__CharKt.indexOf$default((java.lang.CharSequence) r14, (java.lang.String) r1, (int) r15, (boolean) r0, (int) r2)
            if (r14 >= 0) goto L_0x003b
            goto L_0x00e8
        L_0x003b:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r1)
            goto L_0x00e9
        L_0x0046:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "List has more than one element."
            r14.<init>(r15)
            throw r14
        L_0x004e:
            java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
            java.lang.String r15 = "List is empty."
            r14.<init>(r15)
            throw r14
        L_0x0056:
            if (r15 >= 0) goto L_0x0059
            r15 = 0
        L_0x0059:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r14.length()
            r0.<init>(r15, r1)
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x00a8
            int r15 = r0.first
            int r9 = r0.last
            int r10 = r0.step
            if (r10 < 0) goto L_0x0071
            if (r15 > r9) goto L_0x00e8
            goto L_0x0073
        L_0x0071:
            if (r15 < r9) goto L_0x00e8
        L_0x0073:
            java.util.Iterator r11 = r6.iterator()
        L_0x0077:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0095
            java.lang.Object r12 = r11.next()
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            r2 = r14
            java.lang.String r2 = (java.lang.String) r2
            int r4 = r0.length()
            r3 = r15
            r5 = r7
            boolean r0 = kotlin.text.CharsKt__CharKt.regionMatches(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0077
            goto L_0x0096
        L_0x0095:
            r12 = r8
        L_0x0096:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x00a4
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r12)
            goto L_0x00e9
        L_0x00a4:
            if (r15 == r9) goto L_0x00e8
            int r15 = r15 + r10
            goto L_0x0073
        L_0x00a8:
            int r15 = r0.first
            int r9 = r0.last
            int r10 = r0.step
            if (r10 < 0) goto L_0x00b3
            if (r15 > r9) goto L_0x00e8
            goto L_0x00b5
        L_0x00b3:
            if (r15 < r9) goto L_0x00e8
        L_0x00b5:
            java.util.Iterator r11 = r6.iterator()
        L_0x00b9:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00d5
            java.lang.Object r12 = r11.next()
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            int r4 = r0.length()
            r2 = r14
            r3 = r15
            r5 = r7
            boolean r0 = kotlin.text.CharsKt__CharKt.regionMatchesImpl(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00b9
            goto L_0x00d6
        L_0x00d5:
            r12 = r8
        L_0x00d6:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x00e4
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r12)
            goto L_0x00e9
        L_0x00e4:
            if (r15 == r9) goto L_0x00e8
            int r15 = r15 + r10
            goto L_0x00b5
        L_0x00e8:
            r15 = r8
        L_0x00e9:
            if (r15 == 0) goto L_0x00fe
            A r14 = r15.first
            B r15 = r15.second
            java.lang.String r15 = (java.lang.String) r15
            int r15 = r15.length()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r14, r15)
        L_0x00fe:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
