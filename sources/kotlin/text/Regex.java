package kotlin.text;

import com.android.billingclient.api.zzam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Regex.kt */
public final class Regex implements Serializable {
    public Set<? extends Object> _options;
    public final Pattern nativePattern;

    /* compiled from: Regex.kt */
    public static final class Serialized implements Serializable {
        public static final long serialVersionUID = 0;
        public final int flags;
        public final String pattern;

        public Serialized(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    public Regex(Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean matches(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final List<String> split(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (!matcher.find() || i == 1) {
                return zzam.listOf(charSequence.toString());
            }
            int i3 = 10;
            if (i > 0 && i <= 10) {
                i3 = i;
            }
            ArrayList arrayList = new ArrayList(i3);
            int i4 = i - 1;
            do {
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if ((i4 >= 0 && arrayList.size() == i4) || !matcher.find()) {
                    arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                break;
            } while (!matcher.find());
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(pattern, "nativePattern.toString()");
        return pattern;
    }

    public Regex(String str) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        Pattern compile = Pattern.compile(str);
        Intrinsics.checkNotNullExpressionValue(compile, "Pattern.compile(pattern)");
        Intrinsics.checkNotNullParameter(compile, "nativePattern");
        this.nativePattern = compile;
    }
}
