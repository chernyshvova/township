package timber.log;

import android.os.Build;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Timber {
    public static final List<Tree> FOREST = new ArrayList();
    public static final Tree[] TREE_ARRAY_EMPTY = new Tree[0];
    public static final Tree TREE_OF_SOULS = new Tree() {
        /* renamed from: d */
        public void mo23036d(String str, Object... objArr) {
            for (Tree d : Timber.forestAsArray) {
                d.mo23036d(str, objArr);
            }
        }

        /* renamed from: e */
        public void mo23039e(String str, Object... objArr) {
            for (Tree e : Timber.forestAsArray) {
                e.mo23039e(str, objArr);
            }
        }

        /* renamed from: i */
        public void mo23042i(String str, Object... objArr) {
            for (Tree i : Timber.forestAsArray) {
                i.mo23042i(str, objArr);
            }
        }

        public void log(int i, String str, Object... objArr) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, str, objArr);
            }
        }

        /* renamed from: v */
        public void mo23049v(String str, Object... objArr) {
            for (Tree v : Timber.forestAsArray) {
                v.mo23049v(str, objArr);
            }
        }

        /* renamed from: w */
        public void mo23052w(String str, Object... objArr) {
            for (Tree w : Timber.forestAsArray) {
                w.mo23052w(str, objArr);
            }
        }

        public void wtf(String str, Object... objArr) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(str, objArr);
            }
        }

        /* renamed from: d */
        public void mo23038d(Throwable th, String str, Object... objArr) {
            for (Tree d : Timber.forestAsArray) {
                d.mo23038d(th, str, objArr);
            }
        }

        /* renamed from: e */
        public void mo23041e(Throwable th, String str, Object... objArr) {
            for (Tree e : Timber.forestAsArray) {
                e.mo23041e(th, str, objArr);
            }
        }

        /* renamed from: i */
        public void mo23044i(Throwable th, String str, Object... objArr) {
            for (Tree i : Timber.forestAsArray) {
                i.mo23044i(th, str, objArr);
            }
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, th, str, objArr);
            }
        }

        /* renamed from: v */
        public void mo23051v(Throwable th, String str, Object... objArr) {
            for (Tree v : Timber.forestAsArray) {
                v.mo23051v(th, str, objArr);
            }
        }

        /* renamed from: w */
        public void mo23054w(Throwable th, String str, Object... objArr) {
            for (Tree w : Timber.forestAsArray) {
                w.mo23054w(th, str, objArr);
            }
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(th, str, objArr);
            }
        }

        /* renamed from: d */
        public void mo23037d(Throwable th) {
            for (Tree d : Timber.forestAsArray) {
                d.mo23037d(th);
            }
        }

        /* renamed from: e */
        public void mo23040e(Throwable th) {
            for (Tree e : Timber.forestAsArray) {
                e.mo23040e(th);
            }
        }

        /* renamed from: i */
        public void mo23043i(Throwable th) {
            for (Tree i : Timber.forestAsArray) {
                i.mo23043i(th);
            }
        }

        public void log(int i, Throwable th) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, th);
            }
        }

        /* renamed from: v */
        public void mo23050v(Throwable th) {
            for (Tree v : Timber.forestAsArray) {
                v.mo23050v(th);
            }
        }

        /* renamed from: w */
        public void mo23053w(Throwable th) {
            for (Tree w : Timber.forestAsArray) {
                w.mo23053w(th);
            }
        }

        public void wtf(Throwable th) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(th);
            }
        }

        public void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    };
    public static volatile Tree[] forestAsArray = TREE_ARRAY_EMPTY;

    public static class DebugTree extends Tree {
        public static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        public static final int CALL_STACK_INDEX = 5;
        public static final int MAX_LOG_LENGTH = 4000;
        public static final int MAX_TAG_LENGTH = 23;

        public String createStackElementTag(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
        }

        public final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                return createStackElementTag(stackTrace[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        public void log(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() >= 4000) {
                int i2 = 0;
                int length = str2.length();
                while (i2 < length) {
                    int indexOf = str2.indexOf(10, i2);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i2 + 4000);
                        String substring = str2.substring(i2, min);
                        if (i == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i, str, substring);
                        }
                        if (min >= indexOf) {
                            break;
                        }
                        i2 = min;
                    }
                    i2 = min + 1;
                }
            } else if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        }
    }

    public static abstract class Tree {
        public final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        StringBuilder outline26 = GeneratedOutlineSupport.outline26(str, "\n");
                        outline26.append(getStackTraceString(th));
                        str = outline26.toString();
                    }
                } else if (th != null) {
                    str = getStackTraceString(th);
                } else {
                    return;
                }
                log(i, tag, str, th);
            }
        }

        /* renamed from: d */
        public void mo23036d(String str, Object... objArr) {
            prepareLog(3, (Throwable) null, str, objArr);
        }

        /* renamed from: e */
        public void mo23039e(String str, Object... objArr) {
            prepareLog(6, (Throwable) null, str, objArr);
        }

        public String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        /* renamed from: i */
        public void mo23042i(String str, Object... objArr) {
            prepareLog(4, (Throwable) null, str, objArr);
        }

        @Deprecated
        public boolean isLoggable(int i) {
            return true;
        }

        public boolean isLoggable(String str, int i) {
            return isLoggable(i);
        }

        public abstract void log(int i, String str, String str2, Throwable th);

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, (Throwable) null, str, objArr);
        }

        /* renamed from: v */
        public void mo23049v(String str, Object... objArr) {
            prepareLog(2, (Throwable) null, str, objArr);
        }

        /* renamed from: w */
        public void mo23052w(String str, Object... objArr) {
            prepareLog(5, (Throwable) null, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, (Throwable) null, str, objArr);
        }

        /* renamed from: d */
        public void mo23038d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        /* renamed from: e */
        public void mo23041e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        /* renamed from: i */
        public void mo23044i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        /* renamed from: v */
        public void mo23051v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        /* renamed from: w */
        public void mo23054w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        /* renamed from: d */
        public void mo23037d(Throwable th) {
            prepareLog(3, th, (String) null, new Object[0]);
        }

        /* renamed from: e */
        public void mo23040e(Throwable th) {
            prepareLog(6, th, (String) null, new Object[0]);
        }

        /* renamed from: i */
        public void mo23043i(Throwable th) {
            prepareLog(4, th, (String) null, new Object[0]);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, (String) null, new Object[0]);
        }

        /* renamed from: v */
        public void mo23050v(Throwable th) {
            prepareLog(2, th, (String) null, new Object[0]);
        }

        /* renamed from: w */
        public void mo23053w(Throwable th) {
            prepareLog(5, th, (String) null, new Object[0]);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, (String) null, new Object[0]);
        }
    }

    public static void plant(Tree tree) {
        if (tree != TREE_OF_SOULS) {
            synchronized (FOREST) {
                FOREST.add(tree);
                forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }

    public static Tree tag(String str) {
        for (Tree tree : forestAsArray) {
            tree.explicitTag.set(str);
        }
        return TREE_OF_SOULS;
    }
}
