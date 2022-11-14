package kotlin.p038io;

import com.facebook.share.internal.VideoUploader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractIterator;
import kotlin.collections.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* renamed from: kotlin.io.FileTreeWalk */
/* compiled from: FileTreeWalk.kt */
public final class FileTreeWalk implements Sequence<File> {
    public final FileWalkDirection direction;
    public final int maxDepth = Integer.MAX_VALUE;
    public final Function1<File, Boolean> onEnter = null;
    public final Function2<File, IOException, Unit> onFail = null;
    public final Function1<File, Unit> onLeave = null;
    public final File start;

    /* renamed from: kotlin.io.FileTreeWalk$DirectoryState */
    /* compiled from: FileTreeWalk.kt */
    public static abstract class DirectoryState extends WalkState {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DirectoryState(File file) {
            super(file);
            Intrinsics.checkNotNullParameter(file, "rootDir");
            if (_Assertions.ENABLED) {
                boolean isDirectory = file.isDirectory();
                if (_Assertions.ENABLED && !isDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    /* renamed from: kotlin.io.FileTreeWalk$FileTreeWalkIterator */
    /* compiled from: FileTreeWalk.kt */
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        public final ArrayDeque<WalkState> state = new ArrayDeque<>();

        /* renamed from: kotlin.io.FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState */
        /* compiled from: FileTreeWalk.kt */
        public final class BottomUpDirectoryState extends DirectoryState {
            public boolean failed;
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;
            public final /* synthetic */ FileTreeWalkIterator this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootDir");
                this.this$0 = fileTreeWalkIterator;
            }

            public File step() {
                if (!this.failed && this.fileList == null) {
                    Function1<File, Boolean> function1 = FileTreeWalk.this.onEnter;
                    if (function1 != null && !function1.invoke(this.root).booleanValue()) {
                        return null;
                    }
                    File[] listFiles = this.root.listFiles();
                    this.fileList = listFiles;
                    if (listFiles == null) {
                        Function2<File, IOException, Unit> function2 = FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            Unit invoke = function2.invoke(this.root, new AccessDeniedException(this.root, (File) null, "Cannot list files in a directory", 2));
                        }
                        this.failed = true;
                    }
                }
                File[] fileArr = this.fileList;
                if (fileArr != null) {
                    int i = this.fileIndex;
                    Intrinsics.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.fileList;
                        Intrinsics.checkNotNull(fileArr2);
                        int i2 = this.fileIndex;
                        this.fileIndex = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.rootVisited) {
                    this.rootVisited = true;
                    return this.root;
                }
                Function1<File, Unit> function12 = FileTreeWalk.this.onLeave;
                if (function12 != null) {
                    Unit invoke2 = function12.invoke(this.root);
                }
                return null;
            }
        }

        /* renamed from: kotlin.io.FileTreeWalk$FileTreeWalkIterator$SingleFileState */
        /* compiled from: FileTreeWalk.kt */
        public final class SingleFileState extends WalkState {
            public boolean visited;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SingleFileState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootFile");
                if (_Assertions.ENABLED) {
                    boolean isFile = file.isFile();
                    if (_Assertions.ENABLED && !isFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            public File step() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return this.root;
            }
        }

        /* renamed from: kotlin.io.FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState */
        /* compiled from: FileTreeWalk.kt */
        public final class TopDownDirectoryState extends DirectoryState {
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;
            public final /* synthetic */ FileTreeWalkIterator this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                super(file);
                Intrinsics.checkNotNullParameter(file, "rootDir");
                this.this$0 = fileTreeWalkIterator;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
                if (r0.length == 0) goto L_0x0072;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.io.File step() {
                /*
                    r7 = this;
                    boolean r0 = r7.rootVisited
                    r1 = 0
                    if (r0 != 0) goto L_0x0022
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.p038io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1<java.io.File, java.lang.Boolean> r0 = r0.onEnter
                    if (r0 == 0) goto L_0x001c
                    java.io.File r2 = r7.root
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x001c
                    return r1
                L_0x001c:
                    r0 = 1
                    r7.rootVisited = r0
                    java.io.File r0 = r7.root
                    return r0
                L_0x0022:
                    java.io.File[] r0 = r7.fileList
                    if (r0 == 0) goto L_0x0040
                    int r2 = r7.fileIndex
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L_0x002f
                    goto L_0x0040
                L_0x002f:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.p038io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1<java.io.File, kotlin.Unit> r0 = r0.onLeave
                    if (r0 == 0) goto L_0x003f
                    java.io.File r2 = r7.root
                    java.lang.Object r0 = r0.invoke(r2)
                    kotlin.Unit r0 = (kotlin.Unit) r0
                L_0x003f:
                    return r1
                L_0x0040:
                    java.io.File[] r0 = r7.fileList
                    if (r0 != 0) goto L_0x0083
                    java.io.File r0 = r7.root
                    java.io.File[] r0 = r0.listFiles()
                    r7.fileList = r0
                    if (r0 != 0) goto L_0x0068
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.p038io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2<java.io.File, java.io.IOException, kotlin.Unit> r0 = r0.onFail
                    if (r0 == 0) goto L_0x0068
                    java.io.File r2 = r7.root
                    kotlin.io.AccessDeniedException r3 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r7.root
                    r5 = 2
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3.<init>(r4, r1, r6, r5)
                    java.lang.Object r0 = r0.invoke(r2, r3)
                    kotlin.Unit r0 = (kotlin.Unit) r0
                L_0x0068:
                    java.io.File[] r0 = r7.fileList
                    if (r0 == 0) goto L_0x0072
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L_0x0083
                L_0x0072:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.p038io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1<java.io.File, kotlin.Unit> r0 = r0.onLeave
                    if (r0 == 0) goto L_0x0082
                    java.io.File r2 = r7.root
                    java.lang.Object r0 = r0.invoke(r2)
                    kotlin.Unit r0 = (kotlin.Unit) r0
                L_0x0082:
                    return r1
                L_0x0083:
                    java.io.File[] r0 = r7.fileList
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r1 = r7.fileIndex
                    int r2 = r1 + 1
                    r7.fileIndex = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.p038io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState.step():java.io.File");
            }
        }

        public FileTreeWalkIterator() {
            if (FileTreeWalk.this.start.isDirectory()) {
                this.state.push(directoryState(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                this.state.push(new SingleFileState(this, FileTreeWalk.this.start));
            } else {
                this.state = State.Done;
            }
        }

        public final DirectoryState directoryState(File file) {
            int ordinal = FileTreeWalk.this.direction.ordinal();
            if (ordinal == 0) {
                return new TopDownDirectoryState(this, file);
            }
            if (ordinal == 1) {
                return new BottomUpDirectoryState(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: kotlin.io.FileTreeWalk$WalkState */
    /* compiled from: FileTreeWalk.kt */
    public static abstract class WalkState {
        public final File root;

        public WalkState(File file) {
            Intrinsics.checkNotNullParameter(file, "root");
            this.root = file;
        }

        public abstract File step();
    }

    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection) {
        Intrinsics.checkNotNullParameter(file, VideoUploader.PARAM_VALUE_UPLOAD_START_PHASE);
        Intrinsics.checkNotNullParameter(fileWalkDirection, "direction");
        this.start = file;
        this.direction = fileWalkDirection;
    }

    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }
}
